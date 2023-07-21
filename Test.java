package com.vrp.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
 
public class Test
{
	public static void main (String[] args) throws IOException
		{
			
			
		    int i;
		    String line = new String();
		    
		    try {
		      //lire le fichier file.txt
		      FileReader file = new FileReader("c:/p01");
		      BufferedReader buffer = new BufferedReader(file);
		    
		      // parcourir le fichier
		      for (i = 1; i < 10; i++) {
		        // Si le numéro de la ligne = 5 récupérer la ligne
		        if (i == 1)
		          line = buffer.readLine();
		         
		        else
		          buffer.readLine();
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    System.out.println(line);
		    
	 
		      
		    String maChaine ="C'est un test";
		    
		    String[] result = line.split("\\s");
		     //for (int x=0; x<result.length; x++)
		         
		         String a=result[1];
		         System.out.println("le nombre de vehecule est"+a);
		         String b=result[2];
		         System.out.println("le nombre de client est"+b);
		      }
		  }
			
			
			
			
			
			
 
      
