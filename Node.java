package com.vrp.java;

///////////////////////////////////////////////////////////////////////////
///////////////////////////class noeud qui peut etre noeud client ou noeud depot ////////////////////////////////////////////////
class Node
{
    public int NodeId;
    public int Node_X ,Node_Y; //coordonne noeud
    public int demande; //pour le noeud client demande client
    public boolean route_o_n;//
    private boolean depot_o_n; //pour le depot est ce que depot ou non
//ona deux type de constructeur  
    //constructeur pour le depot qui contient 2 parametre coordination
    public Node(int depot_x,int depot_y) //Cunstructor for depot
    {//////////////////attribut pour depot//////////////////////////
        this.NodeId = 0;
        this.Node_X = depot_x;
        this.Node_Y = depot_y;
        this.route_o_n = true;// dans le cas depot true
    }
//constructeur pour client qui contient coordonne et demande 
    public Node(int id ,int x, int y, int demande) //
    {///////////////////////////attribut pour les client//////////////////////////////////
        this.NodeId = id;
        this.Node_X = x;
        this.Node_Y = y;
        this.demande = demande;
        this.route_o_n = false;//affecter au route ou non
        this.depot_o_n = false;//dans le cas client return false
    }
}



