/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_jade;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

/**
 *
 * @author Andy
 */
public class Agente_Deteccion extends Agent {

    //private gui_jade migui;
    public void setup() {
        //migui = new gui_jade();

        addBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {
                ACLMessage message_rec = receive();
                if (message_rec != null) {
                    String valor = message_rec.getContent();
                    System.out.println(valor);
                } else {
                    block();
                }

            }
        });
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Ingrese palabra a buscar:\n");
                Scanner scan = new Scanner(System.in);
                String valor = scan.next();

                ACLMessage message_env = new ACLMessage(ACLMessage.REQUEST);
                message_env.setContent(valor);

                message_env.addReceiver(new AID("busqueda", AID.ISLOCALNAME));
                send(message_env);

            }
        });
    }
}
