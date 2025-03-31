/**
 * Project 3: Pipeline Simulation
 * Class Name: Pipeline_Stages
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The pipeline stages class contains the methods within each stage of a pipeline simulation.
 * 
 * Features:
 * - method for IF_stage
 * - method for ID_stage
 * - method for EX_stage
 * - method for MEM_stage
 * - method for WB_stage
 * - parameters could contain register or main mem, and instruction
 *  
 * Dependencies:
 * This class depends on the Main_Memory, Register, and the pipeline register classes.
 * 
 **/

package P3;

public class Pipeline_Stages {

    public static void IF_stage(int inst) {
        IF_ID.write.set_Inst(inst);

    }

    public static void ID_stage(Register reg) {
        int inst = IF_ID.read.get_Inst();
        InstructionDecoder decoder = new InstructionDecoder();
        int opcode = decoder.getOpcode(inst);
        int format = decoder.determineFormat(opcode);

        if (format == 0) { //for r-format
            decoder.extractRFormat(inst);
            ID_EX.write.set_func(decoder.getFunc()); 
            ID_EX.write.set_read_Reg_1_Value(reg.get_Value(decoder.getS1()));
            ID_EX.write.set_read_Reg_2_Value(reg.get_Value(decoder.getS2())); 
            ID_EX.write.set_SE_Offset(decoder.getX());      
            ID_EX.write.set_write_Reg_15_11(decoder.getDs());
            ID_EX.write.set_write_Reg_20_16(decoder.getS2());
            

        }
        else if (format == 1) {//for i-format
            decoder.extractIFormat(inst);
            ID_EX.write.set_func(decoder.getFunc()); 
            ID_EX.write.set_read_Reg_1_Value(reg.get_Value(decoder.getS1()));
            ID_EX.write.set_read_Reg_2_Value(reg.get_Value(decoder.getSd())); 
            ID_EX.write.set_SE_Offset(decoder.getOffset());      
            ID_EX.write.set_write_Reg_15_11(0);
            ID_EX.write.set_write_Reg_20_16(decoder.getSd());
        
        }

        //set control bits
        if (opcode == 0 && ID_EX.write.get_func() == 0) {//nop
            ID_EX.write.set_reg_Dst((byte) 0);
            ID_EX.write.set_ALU_Src((byte) 0);
            ID_EX.write.set_ALU_Op((byte) 0);
            ID_EX.write.set_mem_Read((byte) 0);
            ID_EX.write.set_mem_Write((byte) 0);
            ID_EX.write.set_branch((byte) 0);
            ID_EX.write.set_mem_To_Reg((byte) 0);
            ID_EX.write.set_reg_Write((byte) 0);
        }
        else if (opcode == 0x20) {//lb
            ID_EX.write.set_reg_Dst((byte) 0);
            ID_EX.write.set_ALU_Src((byte) 1);
            ID_EX.write.set_ALU_Op((byte) 00);
            ID_EX.write.set_mem_Read((byte) 1);
            ID_EX.write.set_mem_Write((byte) 0);
            ID_EX.write.set_branch((byte) 0);
            ID_EX.write.set_mem_To_Reg((byte) 1);
            ID_EX.write.set_reg_Write((byte) 1);
        }
        else if(opcode == 0x28) {//sb
            ID_EX.write.set_reg_Dst((byte) 0);
            ID_EX.write.set_ALU_Src((byte) 1);
            ID_EX.write.set_ALU_Op((byte) 00);
            ID_EX.write.set_mem_Read((byte) 0);
            ID_EX.write.set_mem_Write((byte) 1);
            ID_EX.write.set_branch((byte) 0);
            ID_EX.write.set_mem_To_Reg((byte) 0);
            ID_EX.write.set_reg_Write((byte) 0);
        }
        else {//r-type
            ID_EX.write.set_reg_Dst((byte) 1);
            ID_EX.write.set_ALU_Src((byte) 0);
            ID_EX.write.set_ALU_Op((byte) 10);
            ID_EX.write.set_mem_Read((byte) 0);
            ID_EX.write.set_mem_Write((byte) 0);
            ID_EX.write.set_branch((byte) 0);
            ID_EX.write.set_mem_To_Reg((byte) 0);
            ID_EX.write.set_reg_Write((byte) 1);
        }



        

    }

    public static void EX_stage() {
        int source = 0;

        if (ID_EX.read.get_ALU_Src() == 1) { //i-format
            source = ID_EX.read.get_SE_Offset(); 
            source = source & 0xFFFF; //entended sign offset
            if ((source & 0x8000) != 0) { 
                source = (source | 0xFFFF0000); 
            } else {
                source = (source & 0x0000FFFF); 
            }
        } else if (ID_EX.read.get_ALU_Src() == 0) { //r-format
            source = ID_EX.read.get_read_Reg_2_Value();
        }

        if (ID_EX.read.get_ALU_Op() == 10) { //r-format
            int func = ID_EX.read.get_func();

            if (func == 0x20) { //add
                int result = ID_EX.read.get_read_Reg_1_Value() + source;
                EX_MEM.write.set_ALU_result(result);
            } else if (func == 0x22) { //sub
                int result = ID_EX.read.get_read_Reg_1_Value() - source;
                EX_MEM.write.set_ALU_result(result);
            } else if (func == 0) { //nop
                EX_MEM.write.set_ALU_result(0);
            }
        } else if (ID_EX.read.get_ALU_Op() == 00) { //i-format
            int result = ID_EX.read.get_read_Reg_1_Value() + source;
            EX_MEM.write.set_ALU_result(result);
        }

        //for write_reg_num
        if (ID_EX.read.get_reg_Dst() == 0) {
            EX_MEM.write.set_Write_Reg_Num(ID_EX.read.get_write_Reg_20_16());
        } else if (ID_EX.read.get_reg_Dst() == 1) {
            EX_MEM.write.set_Write_Reg_Num(ID_EX.read.get_write_Reg_15_11());
        }

        EX_MEM.write.set_SB_value(ID_EX.read.get_read_Reg_2_Value());
        EX_MEM.write.set_Zero(false);
        EX_MEM.write.set_Calc_BTA((short) 0);

        //control bits
        EX_MEM.write.set_mem_Read(ID_EX.read.get_mem_Read());
        EX_MEM.write.set_mem_Write(ID_EX.read.get_mem_Write());
        EX_MEM.write.set_branch(ID_EX.read.get_branch());
        EX_MEM.write.set_Mem_To_Reg(ID_EX.read.get_mem_To_Reg());
        EX_MEM.write.set_Reg_Write(ID_EX.read.get_reg_Write());


    }


    public static void MEM_stage(Register reg, Main_Memory mem) {

        if (EX_MEM.read.get_mem_Write() == 0 && EX_MEM.read.get_mem_Read() == 0 && EX_MEM.read.get_branch() == 0) { //r-type
            MEM_WB.write.set_LW_value(0);
            MEM_WB.write.set_ALU_result(EX_MEM.read.get_ALU_result());
            MEM_WB.write.set_Write_Reg_Num(EX_MEM.read.get_Write_Reg_Num());
        } else if (EX_MEM.read.get_mem_Write() == 0 && EX_MEM.read.get_mem_Read() == 1 && EX_MEM.read.get_branch() == 0) { //lb
            MEM_WB.write.set_LW_value(mem.get_Value(EX_MEM.read.get_ALU_result()));
            MEM_WB.write.set_ALU_result(EX_MEM.read.get_ALU_result());
            MEM_WB.write.set_Write_Reg_Num(EX_MEM.read.get_Write_Reg_Num());
        } else if (EX_MEM.read.get_mem_Write() == 1 && EX_MEM.read.get_mem_Read() == 0 && EX_MEM.read.get_branch() == 0) { //sb
            MEM_WB.write.set_LW_value(0);
            MEM_WB.write.set_ALU_result(EX_MEM.read.get_ALU_result());
            MEM_WB.write.set_Write_Reg_Num(EX_MEM.read.get_Write_Reg_Num());
            mem.set_value(EX_MEM.read.get_ALU_result(), EX_MEM.read.get_SB_value());
        }

        //set control bits
        MEM_WB.write.set_Mem_To_Reg(EX_MEM.read.get_Mem_To_Reg());
        MEM_WB.write.set_Reg_Write(EX_MEM.read.get_Reg_Write());

    }

    public static void WB_stage(Register reg) {

        if (MEM_WB.read.get_Mem_To_Reg() == 0 && MEM_WB.read.get_Reg_Write() == 1) { //r-type
            reg.set_Value(MEM_WB.read.get_Write_Reg_Num(), MEM_WB.read.get_ALU_result());
        } else if (MEM_WB.read.get_Mem_To_Reg() == 1 && MEM_WB.read.get_Reg_Write() == 1) { //lb
            reg.set_Value(MEM_WB.read.get_Write_Reg_Num(), MEM_WB.read.get_LW_value());
        } else if (MEM_WB.read.get_Mem_To_Reg() == 0 && MEM_WB.read.get_Reg_Write() == 0) { //sb
            //nothing happens becuase SB does not write back to registers
        }

        
    }

}
