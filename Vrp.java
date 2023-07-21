package com.vrp.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created MOURAD
 */

 
import java.util.*;

public class  Vrp{

    public static void main(String[] args) {

        Random ran = new Random(1);

/////////////////////Parametre du VRP Client ,véhicule ,Capacite véhicule/////////////////////////////
        

//////////////////////Cordination Depot//////////////////////////////////////////////////////////////
        int Depot_x = 50;
        int Depot_y = 50;

        /////////////////////////////////////////////////////////////////////////////
        int m;
	    String line = new String();
	    
	     
	    
	    
	    
	    
	    
	    
	    try {
	      //lire le fichier file.txt
	      FileReader file = new FileReader("e:/p01.txt");
	      BufferedReader buffer = new BufferedReader(file);
	    
	      // parcourir le fichier
	      for (m = 1; m < 10; m++) {
	        // Si le numéro de la ligne = 5 récupérer la ligne
	        if (m == 1)
	          line = buffer.readLine();
	         
	        else
	          buffer.readLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    System.out.println(line);
	    
 
	      
	     
	    
	    String[] result = line.split("\\s");
	     //for (int x=0; x<result.length; x++)
	         
	         String a=result[0];
	         System.out.println("le nombre de vehecule est"+a);
	         String b=result[1];
	         System.out.println("le nombre de client est"+b);
        
	         int nbclients = Integer.parseInt(b);
	         int nbvehcule =Integer.parseInt(a);
	         int VehicleCap = 25;
        
        /////////////////////////////////////////////////////////////////////////////////

/////////////Inisialisationnnnnnnnnnnnnnnnnnnnnnn//////////////////////////////////////////////////////////
	         
	         
	      
////////////creation client en utilisant  Fonction Random/////////////////////////////////////////////////
	         Node[] Nodes = new Node[nbclients + 1]; 
////////////////Entreprise ou Depot///////////////////////////////////////////////////////////////////////        
        Node depot = new Node(Depot_x, Depot_y);
////////////reserve pout le depot pour l'entreprise pour le noeud////////////////////////////////////////// 
        Nodes[0] = depot;
//////////////////////creation Client/////////////////////////////////////////////////////////////////////
       
   
  /*      
        
        try {
  	      //lire le fichier file.txt
  	      FileReader file1 = new FileReader("e:/p01.txt");
  	      BufferedReader buffer1 = new BufferedReader(file1);
  	    
  	      StringBuffer sb = new StringBuffer();    
  	       int h=1;
  	      while((line = buffer1.readLine()) != null)
  	      {
  	        // ajoute la ligne au buffer
  	        sb.append(line); 
  	        String[] result2  = line.split("\\s");
  		    String l= result2[0];
  		  String l1= result2[1];
  		 
  		 
  	         

  	            Nodes[h] = new Node(h, //Id ) is reserved for depot
  	            		h , //Random Cordinates
  	            		h ,
  	                    4 + h   //Random Demand
  	            );
  		         
  	        sb.append("\n");     
  	      }
  	        
  	      System.out.println("Contenu du fichier: ");
  	      System.out.println(sb.toString()); 
  	    } catch (IOException e) {
  	  	      e.printStackTrace();
  	  	    }
        
         */

       for (int i = 1; i <= nbclients; i++) {
            Nodes[i] = new Node(i, //Id ) is reserved for depot
                    ran.nextInt(2), //Random Cordinates
                    ran.nextInt(2),
                    4 + ran.nextInt(7)  //Random Demand
            );
        }
        
      
        
////////////calcule distance entre les deférent client et depot/////////////////////////////////////////////////
        double[][] distanceMatrix = new double[nbclients + 1][nbclients + 1];
        double Delta_x, Delta_y;
        for (int i = 0; i <= nbclients; i++) {
            for (int j = i + 1; j <= nbclients; j++) //The table is summetric to the first diagonal
            {                                      //Use this to compute distances in O(n/2)

                Delta_x = (Nodes[i].Node_X - Nodes[j].Node_X);
                Delta_y = (Nodes[i].Node_Y - Nodes[j].Node_Y);

                double distance = Math.sqrt((Delta_x * Delta_x) + (Delta_y * Delta_y));

                distance = Math.round(distance);                //Distance is Casted in Integer
                //distance = Math.round(distance*100.0)/100.0; //Distance in double

                distanceMatrix[i][j] = distance;
                 
            }
        }
       
            for (int i = 0; i <= nbclients; i++) {
                for (int j = 0; j <= nbclients; j++) {
                     //System.out.print(distanceMatrix[i][j] + "  ");
                }
                System.out.println();
            }
         
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Programme principal
        //Affichage dans le consol fait l'appel au methode dans la class solution
        System.out.println("Solution  (VRP) du  "+nbclients+
                " Client et "+nbvehcule+" Vehicles"+" de  "+VehicleCap + "  capacity\n");

        Solution s = new Solution(nbclients, nbvehcule, VehicleCap);
//appel methode vrp in class solution
        s.vrp(Nodes, distanceMatrix);
//appel methode  SolutionPrint in class solution
        s.SolutionPrint("Solution VRP");

       

    
  
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
