/**
 * Project 3: Pipeline Simulation
 * Class Name: Main_Memory
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The main memory class creates the main memory for the pipeline simulation
 * 
 * Features:
 * - 2D array for main method 
 * - get and set method
 *  
 * Dependencies:
 * none
 * 
 **/

package P3;

public class Main_Memory {

    int[] main_mem;

    public Main_Memory(int n) {
        main_mem = new int[n];
        for (short i = 0x0; i < n ; i++) {
            if (i <= 0xFF) {
                main_mem[i] = i;
            }
            else {
                main_mem[i] = (short) (i & 0xFF); //bitwise AND operation
            }
        }
    }

    public int get_Value(int i) {
        return main_mem[i];
    }

    public void set_value(int i, int value) {
        main_mem[i] = value;
    }

}
