/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstr_stack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author GP62 6QF
 */
public class Warehouse 
{
    Merchandise Stacker[]=new Merchandise[5];
    int topS=-1;
    Merchandise Bin0[]=new Merchandise[5];
    int topB0=-1;
    Merchandise Bin1[]=new Merchandise[5];
    int topB1=-1;
    Merchandise Bin2[]=new Merchandise[5];
    int topB2=-1;
    Merchandise Bin3[]=new Merchandise[5];
    int topB3=-1;
    Merchandise Bin4[]=new Merchandise[5];
    int topB4=-1;
    
    
    int topO=-1;
    
    int bID=0;
    int iID=0;
    int min=10; //min item in the truck
    int rand;
    Merchandise merch;
    Merchandise mer;// this is when removing merchandise from the bin
    
    ArrayList<Merchandise> merchList=new ArrayList<Merchandise>();
    
    public int dockTruck(int itemID)
    {
        do
        {
            rand=randomizer(25);
        }
        while(rand<=min);
        
        iID=itemID;
        System.out.println("\nThere are "+rand+" items in the truck");
        for(int count=0;count<rand;count++)
        {
            bID=randomizer(5);
            Merchandise m=new Merchandise(iID,bID);
            merchList.add(m);
            iID++;
            System.out.println("Item: "+m.itemID+" (Bin: "+m.binID+") is in the truck");
        }
        System.out.println("\nTruck is in the Loading Dock");
        wakeUpStacker();
        
        return iID;
    }
    
    public void wakeUpStacker()
    {   
        System.out.println("\n\tStacker Woke Up");
        do
        {
            System.out.println("\n\tStacker is empty: Stacker is going to the Loading Dock\n");
            while(topS<4&&merchList.size()>0)
            {     
                int r=randomizer(merchList.size());
                Merchandise m=merchList.get(r);
                System.out.println("\tStacker has taken item Id: "+m.itemID+" bin Id: "+m.binID);
                pushStacker(m);
                merchList.remove(r);
            }
            if(topS==4)
            {
                System.out.println("\n\tStacker is full: Stacker is returning in the Warehouse\n");
            }
            else
            {
                System.out.println("\nTruck is empty: Truck is leaving the Loading Dock\n");
                System.out.println("\tStacker is returning to the Warehouse with "+(topS+1)+" item(s)\n");
            }
            while(topS!=-1)
            {
                merch=popStacker();
                System.out.println("\t\tRobot has taken Merchandise "+merch.itemID+" from Stacker");
                pushBin(merch);
                System.out.print("\t\tRobot has put Merchandise "+merch.itemID+" to Bin "+merch.binID+"\n");

            }
        }
        while(merchList.size()>0);
        System.out.println("\n\tStacker is going to Sleep");
    }
    
    public void pushStacker(Merchandise m)
    {
        topS++;
        Stacker[topS]=m;
    }
    
    public Merchandise popStacker()
    {
        Merchandise m=Stacker[topS];
        Stacker[topS]=null;
        topS--;
        return m;
    }
    
    public int randomizer(int i)
    {
        int random=new Random().nextInt(i);
        return random;
    }
    
    public void pushBin(Merchandise m)
    {
        switch(m.binID)
        {
            case 0:
            {
                if(topB0!=4)
                {
                    topB0++;
                    Bin0[topB0]=m;
                }
                else
                {
                    System.out.println("\t\t\tBin 0 is full");
                    mer=popBin(0);
                    System.out.println("\t\t\tThe Top of Bin 0: Merchandise "+mer.itemID+" was removed");
                    topB0++;
                    Bin0[topB0]=m;
                }
                break;
            }
            case 1:
            {
                if(topB1!=4)
                {
                    topB1++;
                    Bin1[topB1]=m;
                }
                else
                {
                    System.out.println("\t\t\tBin 1 is full");
                    mer=popBin(1);
                    System.out.println("\t\t\tThe Top of Bin 1: Merchandise "+mer.itemID+" was removed");
                    topB1++;
                    Bin1[topB1]=m;
                }
                break;   
            }
            
            case 2:
            {
                if(topB2!=4)
                {
                    topB2++;
                    Bin2[topB2]=m;
                }
                else
                {
                    System.out.println("\t\t\tBin 2 is full");
                    mer=popBin(2);
                    System.out.println("\t\t\tThe Top of Bin 2: Merchandise "+mer.itemID+" was removed");
                    topB2++;
                    Bin2[topB2]=m;
                }
                break;
                
            }
            case 3:
            {
                if(topB3!=4)
                {
                    topB3++;
                    Bin3[topB3]=m;
                }
                else
                {
                    System.out.println("\t\t\tBin 3 is full");
                    mer=popBin(3);
                    System.out.println("\t\t\tThe Top of Bin 3: Merchandise "+mer.itemID+" was removed");
                    topB3++;
                    Bin3[topB3]=m;
                }
                    
                break;
                
            }
            case 4:
            {
                if(topB4!=4)
                {
                   topB4++;
                   Bin4[topB4]=m;
                }
                else
                {
                    System.out.println("\t\t\tBin 4 is full");
                    mer=popBin(4);
                    System.out.println("\t\t\tThe Top of Bin 4: Merchandise "+mer.itemID+" was removed");
                    topB4++;
                    Bin4[topB4]=m;
                }
                    
                break;
                
            }
        }
    }
    
    public Merchandise popBin(int n)
    {
        Merchandise m=null;
        switch(n)
        {
            case 0:
            {
                m=Bin0[topB0];
                Bin0[topB0]=null;
                topB0--;
                break;
            }
            case 1:
            {
                m=Bin1[topB1];
                Bin1[topB1]=null;
                topB1--;
                break;
            }
            case 2:
            {
                m=Bin2[topB2];
                Bin2[topB2]=null;
                topB2--;
                break;
            }
            case 3:
            {
                m=Bin3[topB3];
                Bin3[topB3]=null;
                topB3--;
                break;
            }
            case 4:
            {
                m=Bin4[topB4];
                Bin4[topB4]=null;
                topB4--;
                break;
            }
            case 5:
            {
                break;
            }
        }
        return m;
    }
    
    public void viewOutput()
    {
        Merchandise m;
        topO=topB0;
        System.out.println("\nBin 0: ");
        while(topO!=-1)
        {
            m=Bin0[topO];
            topO--;
            System.out.println("Merchandise "+m.itemID);
        }
        topO=topB1;
        System.out.println("\nBin 1: ");
        while(topO!=-1)
        {
            m=Bin1[topO];
            topO--;
            System.out.println("Merchandise "+m.itemID);
        }
        topO=topB2;
        System.out.println("\nBin 2: ");
        while(topO!=-1)
        {
            m=Bin2[topO];
            topO--;
            System.out.println("Merchandise "+m.itemID);
        }
        topO=topB3;
        System.out.println("\nBin 3: ");
        while(topO!=-1)
        {
            m=Bin3[topO];
            topO--;
            System.out.println("Merchandise "+m.itemID);
        }
        topO=topB4;
        System.out.println("\nBin 4: ");
        while(topO!=-1)
        {
            m=Bin4[topO];
            topO--;
            System.out.println("Merchandise "+m.itemID);
        }
    }
    
}
