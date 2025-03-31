/**
 * Project 3: Pipeline Simulation
 * Class Name: MEM_WB
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The MEM_WB class is the pipeline register keeping all necessary variables for the mem-wb stage
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

public class MEM_WB {

    public static Write write = new Write();

    public static class Write {

        //variables
        int LW_value;
        int ALU_result;
        int write_Reg_Num;

        //get methods
        public int get_LW_value() {
            return LW_value;
        }

        public int get_ALU_result() {
            return ALU_result;
        }

        public int get_Write_Reg_Num() {
            return write_Reg_Num;
        }

        //setter methods
        public void set_LW_value(int lW_value) {
            LW_value = lW_value;
        }

        public void set_ALU_result(int aLU_result) {
            ALU_result = aLU_result;
        }

        public void set_Write_Reg_Num(int write_Reg_Num) {
            this.write_Reg_Num = write_Reg_Num;
        }


        //control bit variables
        byte mem_To_Reg = 0;
        byte reg_Write = 0;

        public byte get_Mem_To_Reg() {
            return mem_To_Reg;
        }

        public byte get_Reg_Write() {
            return reg_Write;
        }


        public void set_Mem_To_Reg(byte mem_To_Reg) {
            this.mem_To_Reg = mem_To_Reg;
        }

        public void set_Reg_Write(byte reg_Write) {
            this.reg_Write = reg_Write;
        }

        public void print() {
            System.out.println("The control bits are: ");
            System.out.println("Mem_To_Reg = " + mem_To_Reg);
            System.out.println("Reg_Write = " + reg_Write);
            System.out.println();

            System.out.printf("%s%X%n", "ALU_result = " , ALU_result);
            System.out.printf("%s%X%n", "LW_value = " ,+ LW_value);
            System.out.println("Write_Reg_Num = " + write_Reg_Num);
            System.out.println();
            
        }
        
        
    }

    public static Read read = new Read();

    public static class Read {

        //variables
        int LW_value;
        int ALU_result;
        int write_Reg_Num;

        //get methods
        public int get_LW_value() {
            return LW_value;
        }

        public int get_ALU_result() {
            return ALU_result;
        }

        public int get_Write_Reg_Num() {
            return write_Reg_Num;
        }

        //setter methods
        public void set_LW_value(int lW_value) {
            LW_value = lW_value;
        }

        public void set_ALU_result(int aLU_result) {
            ALU_result = aLU_result;
        }

        public void set_Write_Reg_Num(int write_Reg_Num) {
            this.write_Reg_Num = write_Reg_Num;
        }


        //control bit variables
        byte mem_To_Reg = 0;
        byte reg_Write = 0;


        public byte get_Mem_To_Reg() {
            return mem_To_Reg;
        }

        public byte get_Reg_Write() {
            return reg_Write;
        }


        public void set_Mem_To_Reg(byte mem_To_Reg) {
            this.mem_To_Reg = mem_To_Reg;
        }

        public void set_Reg_Write(byte reg_Write) {
            this.reg_Write = reg_Write;
        }

        public void print() {
            System.out.println("The control bits are: ");
            System.out.println("Mem_To_Reg = " + mem_To_Reg);
            System.out.println("Reg_Write = " + reg_Write);
            System.out.println();

            System.out.printf("%s%X%n", "ALU_result = " , ALU_result);
            System.out.printf("%s%X%n", "LW_value = " ,+ LW_value);
            System.out.println("Write_Reg_Num = " + write_Reg_Num);
            System.out.println();
            
        }
        
    }

}
