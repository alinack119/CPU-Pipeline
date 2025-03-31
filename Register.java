/**
 * Project 3: Pipeline Simulation
 * Class Name: Register
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The register class creates the register for the pipeline simulation
 * 
 * Features:
 * - 2D array for register
 * - get and set method
 *  
 * Dependencies:
 * none
 * 
 **/

package P3;

public class Register {

    int [] regs;

    public Register(int n) {

        regs = new int[n];

        short value = 0x100;

        for (int i = 0; i < n ; i++) {
            
            if (i == 0) {
                regs[i] = i;
            }
            else {
                regs[i] = (value + i);
            }
            

        }
        
    }

    public int get_Value(int i) {
        return regs[i];

    }

    public void set_Value(int i, int value) {
        regs[i] = value;
    }

    public void print() {

        for (short i = 0; i < regs.length ; i++) {
            
           System.out.printf("%s%d: %X%n", "$", i, regs[i]);       

        }
        
    }

}
