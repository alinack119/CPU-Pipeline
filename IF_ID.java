/**
 * Project 3: Pipeline Simulation
 * Class Name: IF_ID
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The IF_ID class is the pipeline register keeping all necessary variables for the if-id stage
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

public class IF_ID {

    public static Write write = new Write();
    
    public static class Write {

        //variable
        private int Inst;
        private short PC;

        public int get_Inst() {
            return Inst;
        }

        public short get_PC() {
            return PC;
        }

        public void set_Inst(int n) {
            Inst = n;
        }

        public void set_PC(short n) {
            PC = n;
        }

        public void print_IF_ID() {
            System.out.printf("%s%X%n", "Inst = ",  Inst);
        }

        
        
    }

    public static Read read = new Read();

    public static class Read {

        private int Inst;
        private short PC;

        public int get_Inst() {
            return Inst;
        }

        public short get_PC() {
            return PC;
        }

        public void set_Inst(int n) {
            Inst = n;
        }

        public void set_PC(short n) {
            PC = n;
        }

        public void print() {
            System.out.printf("%s%X%n", "Inst = ",  Inst);
        }




    }

    


}
