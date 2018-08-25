/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstr_stack;

import java.util.Scanner;
/**
 *
 * @author GP62 6QF
 */
public class DSTR_Stack 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Warehouse w=new Warehouse();
        String option;
        int opt;
        Scanner inp=new Scanner(System.in);
        int itemID=0;
        Merchandise m;
        
        System.out.println("WAREHOUSE SYSTEM");
        while(true)
        {
            System.out.print("\n1. New Truck\n2. Retrieve Merchandise\n3. View Output\n0. Exit\nAnswer: ");
            option=inp.next();
            try
            {
                opt=Integer.parseInt(option);
                if(opt==0)
                {
                    System.out.println("\nExiting...");
                    break;
                }
                else if(opt==1)
                {
                    itemID=w.dockTruck(itemID);
                    
                }
                else if(opt==2)
                {
                    while(true)
                    {
                        System.out.print("\nRetrieve Merchandise from which Bin:\n0. Bin 0\n1. Bin 1\n2. Bin 2\n3. Bin 3\n4. Bin 4\nAnswer: ");
                        option=inp.next();
                        try
                        {
                            opt=Integer.parseInt(option);
                            if(opt==0||opt==1||opt==2||opt==3||opt==4)
                            {
                                try
                                {
                                    m=w.popBin(opt);
                                    System.out.println("\nMerchandise "+m.itemID+" was retrieve from Bin "+opt);
                                }
                                catch(Exception e)
                                {
                                    System.out.println("\nThere is no Merchandise in Bin "+opt);
                                    
                                }   
                                break;
                            }
                            else
                            {
                                System.out.println("\nInvalid Input\nPlease try again");
                            }
                        }
                        catch(Exception e)
                        {
                            System.out.println("\nInvalid Input\nPlease try again");
                        }
                    }
                    
                    
                }
                else if(opt==3)
                {
                    System.out.println("\nThe output shows the order the Warehouse would be emptied if we start from Bin 0 to Bin 4");
                    w.viewOutput();
                }
                else
                {
                    System.out.println("\nInvalid Input\nPlease try again");
                }
            }
            catch(Exception e)
            {
                System.out.println("\nInvalid Input\nPlease try again in MAIN");
            }
        }
    }
    
}
