package com.vrp.java;

import java.util.ArrayList;
//////////////////class vehecule////////////////////////////
class Vehicle
{
    public int VehId;
    //////////////////////qui contient rout de noeud
    
    //chaque route contient plusieur noeud
    ///////////////////////////////////////
    public ArrayList<Node> Route = new ArrayList<Node>();
    public int capacite;//capacite du vehicule
    public int nbdemande;//variable contient les demande du client
    public int idnoeud;//variable contient les id du noeud
    public boolean Closed;///etat inicial vide ferme

    public Vehicle(int id, int capacite)
    {
        this.VehId = id;
        this.capacite = capacite;
        this.nbdemande = 0;//variable qui contient nombre de demande
        this.idnoeud = 0; //In depot Initially
        this.Closed = false;
        this.Route.clear();//initialisation route
    }

    public void AddNode(Node client )//Add Customer to Vehicle Route
    {
        Route.add(client);
        this.nbdemande +=  client.demande;///nbdemande=client.demande
        this.idnoeud = client.NodeId;////contient tout les id du noeud
    }
///verification nombre de demande au capacite du vehecule
    public boolean CheckIfFits(int demande) //Check if we have Capacity Violation
    {
        return ((nbdemande + demande <= capacite));
    }

}