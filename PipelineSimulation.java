/**
 * Project 3: Pipeline Simulation
 * Class Name: PipelineSimulation
 * 
 * Author: Alina Kenny
 * Date: Nov 30, 2024
 * 
 * Purpose:
 * The pipeline simulation class contains the main program to execute the pipeline simulation on a set of instructions.
 * 
 * Features:
 * - Read instructions from instruction cache and execute a pipline simulation
 * - creates main memory and registers array
 *  
 * Dependencies:
 * This class depends on the Pipeline_Stages, Pipeline_Update, Main_Memory, Register, and the pipeline register classes.
 * 
 **/

package P3;

public class PipelineSimulation {
    public static void main(String[] args) throws Exception {
        
        Main_Memory Main_Mem = new Main_Memory(1024);

        Register Regs = new Register(32);

        int [] instCache = {0xa1020000, 0x810AFFFC, 0x00831820, 0x01263820, 0x01224820, 0x81180000, 0x81510010, 0x00624022, 0x00000000, 0x00000000, 0x00000000, 0x00000000};

        int [] test = {0, 0x00a63820, 0x8d0f0004, 0xad09fffc, 0x00625022, 0, 0, 0, 0};
        

        int PC = 1; //start at cycle 1
        for (int i = 0; i < instCache.length; i++) {
            System.out.println("Clock Cycle: " + PC);
            int inst = instCache[i];
            Pipeline_Stages.IF_stage(inst);
            Pipeline_Stages.ID_stage(Regs);
            Pipeline_Stages.EX_stage();
            Pipeline_Stages.MEM_stage(Regs, Main_Mem);
            Pipeline_Stages.WB_stage(Regs);
            Pipeline_Update.Print_out_everything(Regs);
            Pipeline_Update.Copy_write_to_read();
            PC++;
            
            System.out.println("--------------------------------");
            System.out.println();
        
            
        }

        
        









        

    }

}
