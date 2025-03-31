/**
 * Project 3: Pipeline Simulation
 * Class Name: ID_EX
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The ID_EX class is the pipeline register keeping all necessary variables for the id-ex stage
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


public class ID_EX {

    public static Write write = new Write();

    public static class Write {

        //Variable
        private short PC;
        private int read_Reg_1_Value;
        private int read_Reg_2_Value;
        private int SE_Offset;
        private int write_Reg_20_16;
        private int write_Reg_15_11;
        private int func;

        //get methods
        public short get_PC() {
            return PC;
        }

        public int get_read_Reg_1_Value() {
            return read_Reg_1_Value;
        }

        public int get_read_Reg_2_Value() {
            return read_Reg_2_Value;
        }

        public int get_SE_Offset() {
            return SE_Offset;
        }

        public int get_write_Reg_20_16() {
            return write_Reg_20_16;
        }

        public int get_write_Reg_15_11() {
            return write_Reg_15_11;
        }

        public int get_func() {
            return func;
        }

        //set methods
        public void set_PC(short n) {
            PC = n;
        }

        public void set_read_Reg_1_Value(int n) {
            read_Reg_1_Value = n;
        }

        public void set_read_Reg_2_Value(int n) {
            read_Reg_2_Value = n;
        }

        public void set_SE_Offset(int n) {
            SE_Offset = n;
        }

        public void set_write_Reg_20_16(int n) {
            write_Reg_20_16 = n;
        }

        public void set_write_Reg_15_11(int n) {
            write_Reg_15_11 = n;
        }

        public void set_func(int n) {
            func = n;
        }


        //Control bits
        private byte reg_Dst = 0;
        private byte ALU_Src = 0;
        private byte ALU_Op = 0;
        private byte mem_Read = 0;
        private byte mem_Write = 0;
        private byte branch = 0;
        private byte mem_To_Reg = 0;
        private byte reg_Write = 0;

        //get methods
        public byte get_reg_Dst() {
            return reg_Dst;
        }

        public byte get_ALU_Src() {
            return ALU_Src;
        }

        public byte get_ALU_Op() {
            return ALU_Op;
        }

        public byte get_mem_Read() {
            return mem_Read;
        }

        public byte get_mem_Write() {
            return mem_Write;
        }

        public byte get_branch() {
            return branch;
        }

        public byte get_mem_To_Reg() {
            return mem_To_Reg;
        }

        public byte get_reg_Write() {
            return reg_Write;
        }

        //set methods
        public void set_reg_Dst(byte n) {
            this.reg_Dst = n;
        }

        public void set_ALU_Src(byte n) {
            this.ALU_Src = n;
        }

        public void set_ALU_Op(byte n) {
            this.ALU_Op = n;
        }

        public void set_mem_Read(byte n) {
            this.mem_Read = n;
        }

        public void set_mem_Write(byte n) {
            this.mem_Write = n;
        }

        public void set_branch(byte n) {
            this.branch = n;
        }

        public void set_mem_To_Reg(byte n) {
            this.mem_To_Reg = n;
        }

        public void set_reg_Write(byte n) {
            this.reg_Write = n;
        }

        public void print() {
            System.out.println("Control: ");
            System.out.println("RegDst = " + reg_Dst);
            System.out.println("ALUSrc = " + ALU_Src);
            System.out.println("ALUOp = " + ALU_Op);
            System.out.println("MemRead = " + mem_Read);
            System.out.println("MemWrite = " + mem_Write);
            System.out.println("Branch = " + branch);
            System.out.println("MemToReg = " + mem_To_Reg);
            System.out.println("RegWrite = " + reg_Write);
            System.out.println();
            System.out.printf("%s%X%n", "ReadReg1Value = ", read_Reg_1_Value);
            System.out.printf("%s%X%n", "ReadReg2Value = ", read_Reg_2_Value);
            System.out.printf("%s%X%n", "SEOffset {hex} = ", SE_Offset);
            System.out.println("WriteReg_20_16 = " + write_Reg_20_16);
            System.out.println("WriteReg_15-11 = " + write_Reg_15_11);
            System.out.printf("%s%X%n", "Function = ",func);
        }


    }

    public static Read read = new Read();

    public static class Read {

        //Variable
        private short PC;
        private int read_Reg_1_Value;
        private int read_Reg_2_Value;
        private int SE_Offset;
        private int write_Reg_20_16;
        private int write_Reg_15_11;
        private int func;

        //get methods
        public short get_PC() {
            return PC;
        }

        public int get_read_Reg_1_Value() {
            return read_Reg_1_Value;
        }

        public int get_read_Reg_2_Value() {
            return read_Reg_2_Value;
        }

        public int get_SE_Offset() {
            return SE_Offset;
        }

        public int get_write_Reg_20_16() {
            return write_Reg_20_16;
        }

        public int get_write_Reg_15_11() {
            return write_Reg_15_11;
        }

        public int get_func() {
            return func;
        }

        //set methods
        public void set_PC(short n) {
            PC = n;
        }

        public void set_read_Reg_1_Value(int n) {
            read_Reg_1_Value = n;
        }

        public void set_read_Reg_2_Value(int n) {
            read_Reg_2_Value = n;
        }

        public void set_SE_Offset(int n) {
            SE_Offset = n;
        }

        public void set_write_Reg_20_16(int n) {
            write_Reg_20_16 = n;
        }

        public void set_write_Reg_15_11(int n) {
            write_Reg_15_11 = n;
        }

        public void set_func(int n) {
            func = n;
        }


        //Control bits
        private byte reg_Dst = 0;
        private byte ALU_Src = 0;
        private byte ALU_Op = 0;
        private byte mem_Read = 0;
        private byte mem_Write = 0;
        private byte branch = 0;
        private byte mem_To_Reg = 0;
        private byte reg_Write = 0;

        //get methods
        public byte get_reg_Dst() {
            return reg_Dst;
        }

        public byte get_ALU_Src() {
            return ALU_Src;
        }

        public byte get_ALU_Op() {
            return ALU_Op;
        }

        public byte get_mem_Read() {
            return mem_Read;
        }

        public byte get_mem_Write() {
            return mem_Write;
        }

        public byte get_branch() {
            return branch;
        }

        public byte get_mem_To_Reg() {
            return mem_To_Reg;
        }

        public byte get_reg_Write() {
            return reg_Write;
        }

        //set methods
        public void set_reg_Dst(byte n) {
            reg_Dst = n;
        }

        public void set_ALU_Src(byte n) {
            ALU_Src = n;
        }

        public void set_ALU_Op(byte n) {
            ALU_Op = n;
        }

        public void set_mem_Read(byte n) {
            mem_Read = n;
        }

        public void set_mem_Write(byte n) {
            mem_Write = n;
        }

        public void set_branch(byte n) {
            branch = n;
        }

        public void set_mem_To_Reg(byte n) {
            mem_To_Reg = n;
        }

        public void set_reg_Write(byte n) {
            reg_Write = n;
        }

        public void print() {
            System.out.println("Control: ");
            System.out.println("RegDst = " + reg_Dst);
            System.out.println("ALUSrc = " + ALU_Src);
            System.out.println("ALUOp = " + ALU_Op);
            System.out.println("MemRead = " + mem_Read);
            System.out.println("MemWrite = " + mem_Write);
            System.out.println("Branch = " + branch);
            System.out.println("MemToReg = " + mem_To_Reg);
            System.out.println("RegWrite = " + reg_Write);
            System.out.println();
            System.out.printf("%s%X%n", "ReadReg1Value = ", read_Reg_1_Value);
            System.out.printf("%s%X%n", "ReadReg2Value = ", read_Reg_2_Value);
            System.out.printf("%s%X%n", "SEOffset = ", SE_Offset);
            System.out.println("WriteReg_20_16 = " + write_Reg_20_16);
            System.out.println("WriteReg_15-11 = " + write_Reg_15_11);
            System.out.printf("%s%X%n", "Function = ",func);
        }

        
    }

    

    


}
