/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.view.dashboard;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author klaus
 */
public class Dashboard {

    private JFrame fenetre;
    private JPanel contenu;
    private CardLayout cardLayout;

    public Dashboard() {
        fenetre = new JFrame("Salle De Sport");
        fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fenetre.setSize(1280, 800);
        fenetre.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        contenu = new JPanel(cardLayout);

        // Ajoute les différents contenus avec un nom unique
        contenu.add(new AccueilPanel(), "Accueil");
        contenu.add(new MembresPanel(), "Membres");
        contenu.add(new JLabel("Informations sur les Tickets"), "Tickets");
        contenu.add(new JLabel("Gestion des Paiements"), "Paiements");

        contenu.add(new JLabel("Gestion des abonnements", JLabel.CENTER), "Abonnements");
        contenu.add(new JLabel("Gestion des paiements", JLabel.CENTER), "Paiements");
        contenu.add(new JLabel("Gestion des salles"), "Gestion des salles");

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
        JLabel footer = new JLabel("© 2023 Salle De Sport - Tous droits réservés", JLabel.CENTER);
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        fenetre.add(footer, BorderLayout.SOUTH);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }

    public void afficherContenu(String nom) {
        cardLayout.show(contenu, nom);
    }
}
