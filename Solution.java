package com.vrp.java;

 import java.util.ArrayList;
 

class Solution
{
    int nbvehcule;
    int nbclients;
    Vehicle[] Vehicles;
    double cout_trajet;

    //Tabu Variables
    public Vehicle[] VehiclesSolution;
    
    
    
    
///////////////////////////affichage solution dans le consol///////////////////////////////////////////////
public void SolutionPrint(String Solution_Label)//
{
System.out.println("=========================================================");
System.out.println("=========================================================");
System.out.println(Solution_Label+"\n");
////////////////////////////////////compteur sur les nombre de vehecule//////////////////////////////////////////////////////////////////////////////////////
for (int j=0 ; j < nbvehcule ; j++)
{
if (! Vehicles[j].Route.isEmpty())
///////////////////////////affichage id vehcule////////////////////////////
{   System.out.print("Vehicle " + j + ":");
///////////////////////////affichage size pour chaque route////////////////////////////////////////////::::
int RoutSize = Vehicles[j].Route.size();
////////////////////////boucle sur chaque route////////////////////////////////////////////////////
for (int k = 0; k < RoutSize ; k++) {
if (k == RoutSize-1)
{ System.out.print(Vehicles[j].Route.get(k).NodeId );  }
else
{ System.out.print(Vehicles[j].Route.get(k).NodeId+ "->"); }
}
System.out.println("\n=========================================================");
}
}
System.out.println("le cout minimal entre les different client est\nDistance Minimal=== "+this.cout_trajet+"\n");
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    






    
    
    
    
    
    //////////////////////////dessiner la route qui prend le numero client,vehcule,et le capacite////////////////////////////////////////////////
    Solution(int numclient, int numvehcule , int Capveh)
    {
        this.nbvehcule = numvehcule;
        this.nbclients = numclient;
        this.cout_trajet = 0;
        Vehicles = new Vehicle[nbvehcule];
        VehiclesSolution =  new Vehicle[nbvehcule];
       

        for (int i = 0 ; i < nbvehcule; i++)
        {
            Vehicles[i] = new Vehicle(i+1,Capveh);
            VehiclesSolution[i] = new Vehicle(i+1,Capveh);
        }
    }

    public boolean UnassignedCustomerExists(Node[] Nodes)
    {
        for (int i = 1; i < Nodes.length; i++)
        {
            if (!Nodes[i].route_o_n)
                return true;
        }
        return false;
    }
////////////////////////////////////////////affectation selon le min distance client//////////////////////////////////////////////////////
    public void vrp(Node[] Nodes , double[][] clientMatrix) {

        double clientsuivant,clientfinal;
        int VehIndex = 0;

        while (UnassignedCustomerExists(Nodes)) {

            int CustIndex = 0;
            Node Candidate = null;
            ///parametre de min distance client par defaut pour converture en double c distance
            double minclient = (float) Double.MAX_VALUE;
//creation depot
            if (Vehicles[VehIndex].Route.isEmpty())
            {
                Vehicles[VehIndex].AddNode(Nodes[0]);
            }

            for (int i = 1; i <= nbclients; i++) {
                if (Nodes[i].route_o_n == false) {
                    if (Vehicles[VehIndex].CheckIfFits(Nodes[i].demande)) {
                        clientsuivant = clientMatrix[Vehicles[VehIndex].idnoeud][i];
                        if (minclient > clientsuivant) {
                        	minclient = clientsuivant;
                            //System.out.println(minCost);
                            CustIndex = i;
                            Candidate = Nodes[i];
                        }
                    }
                }
            }

            if ( Candidate  == null)
            {
                //Affectation vehecule
                if ( VehIndex+1 < Vehicles.length ) //We have more vehicles to assign
                {
                    if (Vehicles[VehIndex].idnoeud != 0) {//End this route
                    	clientfinal = clientMatrix[Vehicles[VehIndex].idnoeud][0];
                        Vehicles[VehIndex].AddNode(Nodes[0]);
                        this.cout_trajet +=  clientfinal;
                    }
                    VehIndex = VehIndex+1; //Go to next Vehicle
                }
                
                else //We DO NOT have any more vehicle to assign. The problem is unsolved under these parameters
                {
                     
                }
            }
            else
            {
                Vehicles[VehIndex].AddNode(Candidate);//If a fitting Customer is Found
                Nodes[CustIndex].route_o_n = true;
                this.cout_trajet += minclient;
            }
        }

        clientfinal = clientMatrix[Vehicles[VehIndex].nbdemande][0];
        Vehicles[VehIndex].AddNode(Nodes[0]);
        this.cout_trajet +=  clientfinal;

    }




 

}

