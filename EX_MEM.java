/**
 * Project 3: Pipeline Simulation
 * Class Name: EX_MEM
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The EX_MEM class is the pipeline register keeping all necessary variables for the ex-mem stage
 * 
 * Features:
 * - get and set methods
 * - print method
 *  
 * Dependencies:
 * none
 * 
 **/

package P3;

 

public class EX_MEM {

    public static Write write = new Write();

    public static class Write {

        //variables
        short calc_BTA;
        boolean zero;
        int ALU_result;
        int SB_value;
        int write_Reg_Num;

        //get methods
        public short get_Calc_BTA() {
            return calc_BTA;
        }

        public boolean get_Zero() {
            return zero;
        }

        public int get_ALU_result() {
            return ALU_result;
        }
        
        public int get_SB_value() {
            return SB_value;
        }

        public int get_Write_Reg_Num() {
            return write_Reg_Num;
        }

        //set methods
        public void set_Calc_BTA(short calc_BTA) {
            this.calc_BTA = calc_BTA;
        }
        
        public void set_Zero(boolean zero) {
            this.zero = zero;
        }

        public void set_ALU_result(int aLU_result) {
            ALU_result = aLU_result;
        }

        public void set_SB_value(int sW_value) {
            SB_value = sW_value;
        }

        
        public void set_Write_Reg_Num(int write_Reg_Num) {
            this.write_Reg_Num = write_Reg_Num;
        }


        //control bit variables
        byte mem_Read = 0;
        byte mem_Write = 0;
        byte branch = 0;
        byte mem_To_Reg = 0;
        byte reg_Write = 0;


        //get methods
        public byte get_mem_Read() {
            return mem_Read;
        }

        public byte get_mem_Write() {
            return mem_Write;
        }

        public byte get_branch() {
            return branch;
        }

        public byte get_Mem_To_Reg() {
            return mem_To_Reg;
        }

        public byte get_Reg_Write() {
            return reg_Write;
        }

        //setter methods
        public void set_mem_Read(byte mem_Read) {
            this.mem_Read = mem_Read;
        }

        public void set_mem_Write(byte mem_Write) {
            this.mem_Write = mem_Write;
        }

        public void set_branch(byte branch) {
            this.branch = branch;
        }

        public void set_Mem_To_Reg(byte mem_To_Reg) {
            this.mem_To_Reg = mem_To_Reg;
        }
        
        public void set_Reg_Write(byte reg_Write) {
            this.reg_Write = reg_Write;
        }

        public void print() {
            System.out.println("Control: ");
            System.out.println("MemRead = " + mem_Read);
            System.out.println("MemWrite = " + mem_Write);
            System.out.println("Branch = " + branch);
            System.out.println("Mem_To_Reg = " + mem_To_Reg);
            System.out.println("Reg_Write = " + reg_Write);
            System.out.println();

            System.out.println("Calc_BTA = " + calc_BTA);
            System.out.println("Zero = " + zero);
            System.out.printf("%s%X%n", "ALU_result = ", ALU_result);
            System.out.printf("%s%X%n", "SB_value = " , SB_value);
            System.out.println("Write_Reg_Num = " + write_Reg_Num);
            System.out.println();
            
        }
        
    }

    public static Read read = new Read();

    public static class Read {
        
        //variables
        short calc_BTA;
        boolean zero;
        int ALU_result;
        int SB_value;
        int write_Reg_Num;

        //get methods
        public short get_Calc_BTA() {
            return calc_BTA;
        }

        public boolean get_Zero() {
            return zero;
        }

        public int get_ALU_result() {
            return ALU_result;
        }
        
        public int get_SB_value() {
            return SB_value;
        }

        public int get_Write_Reg_Num() {
            return write_Reg_Num;
        }

        //set methods
        public void set_Calc_BTA(short calc_BTA) {
            this.calc_BTA = calc_BTA;
        }
        
        public void set_Zero(boolean zero) {
            this.zero = zero;
        }

        public void set_ALU_result(int aLU_result) {
            ALU_result = aLU_result;
        }

        public void set_SB_value(int sW_value) {
            SB_value = sW_value;
        }

        
        public void set_Write_Reg_Num(int write_Reg_Num) {
            this.write_Reg_Num = write_Reg_Num;
        }


        //control bit variables
        byte mem_Read = 0;
        byte mem_Write = 0;
        byte branch = 0;
        byte mem_To_Reg = 0;
        byte reg_Write = 0;


        //get methods
        public byte get_mem_Read() {
            return mem_Read;
        }

        public byte get_mem_Write() {
            return mem_Write;
        }

        public byte get_branch() {
            return branch;
        }

        public byte get_Mem_To_Reg() {
            return mem_To_Reg;
        }

        public byte get_Reg_Write() {
            return reg_Write;
        }

        //setter methods
        public void set_mem_Read(byte mem_Read) {
            this.mem_Read = mem_Read;
        }

        public void set_mem_Write(byte mem_Write) {
            this.mem_Write = mem_Write;
        }

        public void set_branch(byte branch) {
            this.branch = branch;
        }

        public void set_Mem_To_Reg(byte mem_To_Reg) {
            this.mem_To_Reg = mem_To_Reg;
        }
        
        public void set_Reg_Write(byte reg_Write) {
            this.reg_Write = reg_Write;
        }

        public void print() {
            System.out.println("Control: ");
            System.out.println("MemRead = " + mem_Read);
            System.out.println("MemWrite = " + mem_Write);
            System.out.println("Branch = " + branch);
            System.out.println("Mem_To_Reg = " + mem_To_Reg);
            System.out.println("Reg_Write = " + reg_Write);
            System.out.println();

            System.out.println("Calc_BTA = " + calc_BTA);
            System.out.println("Zero = " + zero);
            System.out.printf("%s%X%n", "ALU_result = ", ALU_result);
            System.out.printf("%s%X%n", "SB_value = " , SB_value);
            System.out.println("Write_Reg_Num = " + write_Reg_Num);
            System.out.println();
            
        }


    }

    
}
