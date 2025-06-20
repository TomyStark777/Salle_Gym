/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.view.dashboard;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author klaus
 */
public class Dashboard {

    private JFrame fenetre;
    private JPanel contenu;
    private CardLayout cardLayout;

    public Dashboard() {
        fenetre = new JFrame("Tableau de bord");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(800, 600);
        fenetre.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        contenu = new JPanel(cardLayout);

        // Ajoute les différents contenus avec un nom unique
        contenu.add(new JLabel("Bienvenue sur le dashboard", JLabel.CENTER), "Accueil");
        contenu.add(new JLabel("Gestion des abonnements", JLabel.CENTER), "Abonnements");
        contenu.add(new JLabel("Gestion des paiements", JLabel.CENTER), "Paiements");

        DashboardMenu menu = new DashboardMenu(this);

        menu.addOption("Accueil");
        menu.addOption("Membres");
        menu.addOption("Tickets");
        menu.addOption("Paiements");
        menu.addOption("Abonnements");
        menu.addOption("Gestion des Salles");
        menu.addOption("Notifications");
        menu.addOption("Paramètres");

        fenetre.add(menu, BorderLayout.WEST);
        fenetre.add(contenu, BorderLayout.CENTER);
        fenetre.add(new JLabel("\u00A9 Copyright..."), BorderLayout.SOUTH);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }

    // Affiche la vue correspondant au nom passé
    public void afficherContenu(String nom) {
        cardLayout.show(contenu, nom);
    }
}
