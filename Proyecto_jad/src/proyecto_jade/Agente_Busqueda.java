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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Agente_Busqueda extends Agent {

    static conexiones con = new conexiones();
    static Statement st;

    public void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message_reci = receive();
                String contenido = "";
                if (message_reci != null) {

                    try {
                        st = con.AbrirConexion().createStatement();
                        String sentencia;
                        System.out.println("iniciando busqueda\n");
                        sentencia = "Select r.recurso from tieneRecurso tr, "
                                + "recurso r, materia m WHERE tr.id = r.id and "
                                + "tr.id_materia = m.id_materia AND m.materia like '" + message_reci.getContent() + "%';";
                        
                        ResultSet rs = st.executeQuery(sentencia);

                        while (rs.next()) {
                            //System.out.println(rs.getString(1) + "\n");
                            contenido = contenido + rs.getString(1) + "\n";

                        }
                        System.out.println("Sugerencias de busqueda\n");

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Agente_Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Agente_Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    block();
                }
                ACLMessage message_env = new ACLMessage(ACLMessage.REQUEST);
                message_env.setContent(contenido);
                message_env.addReceiver(new AID("deteccion", AID.ISLOCALNAME));
                send(message_env);
            }
        });
    }
}
