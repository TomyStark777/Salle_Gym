/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salle_gym;

import entite.TypeAbonnement;
import gui_admin.controller.TypeAbonnementController;
import gui_admin.view.dashboard.Dashboard;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import service.TypeAbonnementService;

/**
 *
 * @author klaus
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*TypeAbonnementController controller = new TypeAbonnementController();
        JFrame fenetre = new JFrame();
        fenetre.setSize(400, 400);
        
        Container c = fenetre.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(controller.edit());
        
        fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fenetre.setVisible(true);*/
        //TypeAbonnementController controller = new TypeAbonnementController();
        //controller.edit();
        //TypeAbonnementService service =  new TypeAbonnementService();
        //TypeAbonnement entite = service.trouver("HEBDO");
        //System.out.println(entite);
        //controller.ajouter();
        
        new Dashboard();
    }
    
}
