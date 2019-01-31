/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_jade;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Andy
 */
public class Proyecto_jade extends Agent {

    //private AID[] selletAgents = {new AID("busqueda", AID.ISLOCALNAME),new AID("deteccion", AID.ISLOCALNAME)};
    public void setup() {
        //System.out.println("Hola mundo");
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                
            }
        });

        
    }

}
