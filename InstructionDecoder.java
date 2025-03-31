/**
 * Project 3: Pipeline Simulation
 * Class Name: InstructionDecoder
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The instruction decoder class decodes an instruction and assigns correct values for instance variables
 * 
 * Features:
 * - decode instruction for both i and r type
 * - set and get method 
 * - parameter is an instruction
 *  
 * Dependencies:
 * none
 * 
 **/

package P3;

public class InstructionDecoder {

    //variables created for all parts of the I and R format
    private int opcode = 0;
    private int s1;
    private int s2;
    private int ds;
    private int x = 0;
    private int func = 0;
    private int sd;
    private String function;
    private int offset;
    private int address;
    private int targetAddress;

    //get method for the func bitwise value
    public int getFunc() {
        return func;
    }

    //get method for the offset value
    public int getOffset() {
        return offset;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getDs() {
        return ds;
    }

    public void setDs(int ds) {
        this.ds = ds;
    }

    public int getSd() {
        return sd;
    }

    public void setSd(int sd) {
        this.sd = sd;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    //get method for the opcode value
    public int getOpcode(int inst) {
        opcode = (inst & 0xFC000000) >>> 26; //bitwise AND operation to mask and find the opcode value
        return opcode;
    }

    //method to set the address
    public int setAddress(int hexNum) {
        return this.address = hexNum;
    }

    //method to determine if instruction is a r or i format
    public int determineFormat(int opcode) {
        if (opcode == 0) {
            return 0; //it is an r-format
        }
        else {
            return 1; //it is an i-format
        }
    }

    //format to determine the function of the instruction for R-format
    public String determineFunc(int func) {
        if (func == 32) {
            function = "add";
        }
        else if (func == 0x24) {
            function = "and";
        }
        else if (func == 0x25) {
            function = "or";
        }
        else if (func == 0x22) {
            function = "sub";
        }
        else if (func == 0x2a) {
            function = "slt";
        }
        else {
            return null;
        }
        return function;
    }


    //method to determine the functin for the I-format instruction
    public String determineOpcode(int opcode) {
        if (opcode == 0x23) {
            function = "lw";
        }
        else if (opcode == 0x2b) {
            function = "sw";
        }
        else if (opcode == 0x04) {
            function = "beq";
        }
        else if (opcode == 0x05) {
            function = "bne";
        }
        else {
            return null;
        }
        return function;
    }

    //method using bitwise AND operation to mask and find the different registers/elements of the r-format instruction
    public void extractRFormat(int inst) {
        s1 = (inst & 0x03E00000) >>> 21;
        s2 = (inst & 0x001F0000) >>> 16;
        ds = (inst & 0x0000F800) >>> 11;
        x = (inst & 0x000007C0) >>> 6;
        func = (inst & 0x0000003F);
    }

    //method using bitwise AND operation to mask and find the different registers/elements of the i-format instruction
    public void extractIFormat(int inst) {
        s1 = (inst & 0x03E00000) >>> 21;
        sd = (inst & 0x001F0000) >>> 16;
        offset = (inst & 0x0000FFFF); //masked offset set to int for comparing to int instruction
        //offset = (short) extractedOffset; //offset set to singed short
    }

    //method to increment address by hex 4
    public int incrementAddress() {
        return this.address = this.address + 0x4;
    }

   
    //method to calcuate target address for branches
    public int calculateTargetAddress() {
        targetAddress = this.address + 0x4;
        offset = (short) (offset << 2);
        targetAddress = targetAddress + offset;
        return targetAddress;

    }

}
