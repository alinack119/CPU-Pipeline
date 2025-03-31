/**
 * Project 3: Pipeline Simulation
 * Class Name: PipelineUpdate
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The pipeline update class contains the methods to print out all outputs (pipeline registers and register) and to copy from write to read registers within the pipeline registers.
 * 
 * Features:
 * - print all pipeline registers and register
 * - copy from write to read for all pipeline registers
 *  
 * Dependencies:
 * This class depends on the Pipeline_Stages, register, and the pipeline register classes.
 * 
 **/

package P3;

import javax.crypto.ExemptionMechanism;

public class Pipeline_Update {

    public static void Print_out_everything(Register regs) {
        

        System.out.println();
        System.out.println("Pipline Registers:");
        System.out.println("IF_ID Write register: ");
        IF_ID.write.print_IF_ID();
        System.out.println();

        System.out.println("IF_ID Read register: ");
        IF_ID.read.print();
        System.out.println();
        
        System.out.println("ID_EX Write register: ");
        ID_EX.write.print();
        System.out.println();
        
        System.out.println("ID_EX Read register: ");
        ID_EX.read.print();
        System.out.println();

        System.out.println("EX_MEM Write register: ");
        EX_MEM.write.print();
        System.out.println();

        System.out.println("EX_MEM Read register: ");
        EX_MEM.read.print();
        System.out.println();

        System.out.println("MEM_WB Write register: ");
        MEM_WB.write.print();
        System.out.println();

        System.out.println("MEM_WB Read register: ");
        MEM_WB.read.print();
        System.out.println();

        System.out.println("Register: ");
        regs.print();

    }

    public static void Copy_write_to_read() {
        //IF_ID
        IF_ID.read.set_Inst(IF_ID.write.get_Inst());
        
        //ID_EX
        ID_EX.read.set_read_Reg_1_Value(ID_EX.write.get_read_Reg_1_Value());
        ID_EX.read.set_read_Reg_2_Value(ID_EX.write.get_read_Reg_2_Value());
        ID_EX.read.set_SE_Offset(ID_EX.write.get_SE_Offset());
        ID_EX.read.set_write_Reg_20_16(ID_EX.write.get_write_Reg_20_16());
        ID_EX.read.set_write_Reg_15_11(ID_EX.write.get_write_Reg_15_11());
        ID_EX.read.set_read_Reg_2_Value(ID_EX.write.get_read_Reg_2_Value());
        ID_EX.read.set_func(ID_EX.write.get_func());

        ID_EX.read.set_reg_Dst(ID_EX.write.get_reg_Dst());
        ID_EX.read.set_ALU_Src(ID_EX.write.get_ALU_Src());
        ID_EX.read.set_ALU_Op(ID_EX.write.get_ALU_Op());
        ID_EX.read.set_mem_Read(ID_EX.write.get_mem_Read());
        ID_EX.read.set_mem_Write(ID_EX.write.get_mem_Write());
        ID_EX.read.set_branch(ID_EX.write.get_branch());
        ID_EX.read.set_mem_To_Reg(ID_EX.write.get_mem_To_Reg());
        ID_EX.read.set_reg_Write(ID_EX.write.get_reg_Write());

        //EX_MEM
        EX_MEM.read.set_Calc_BTA(EX_MEM.write.get_Calc_BTA());
        EX_MEM.read.set_Zero(EX_MEM.write.get_Zero());
        EX_MEM.read.set_ALU_result(EX_MEM.write.get_ALU_result());
        EX_MEM.read.set_SB_value(EX_MEM.write.get_SB_value());
        EX_MEM.read.set_Write_Reg_Num(EX_MEM.write.get_Write_Reg_Num());

        EX_MEM.read.set_mem_Read(EX_MEM.write.get_mem_Read());
        EX_MEM.read.set_mem_Write(EX_MEM.write.get_mem_Write());
        EX_MEM.read.set_branch(EX_MEM.write.get_branch());
        EX_MEM.read.set_Mem_To_Reg(EX_MEM.write.get_Mem_To_Reg());
        EX_MEM.read.set_Reg_Write(EX_MEM.write.get_Reg_Write());

        //MEM_WB
        MEM_WB.read.set_LW_value(MEM_WB.write.get_LW_value());
        MEM_WB.read.set_ALU_result(MEM_WB.write.get_ALU_result());
        MEM_WB.read.set_Write_Reg_Num(MEM_WB.write.get_Write_Reg_Num());

        MEM_WB.read.set_Mem_To_Reg(MEM_WB.write.get_Mem_To_Reg());
        MEM_WB.read.set_Reg_Write(MEM_WB.write.get_Reg_Write());

    }

}
