/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.view.dashboard;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author klaus
 */
public class AccueilPanel extends JPanel {

    public AccueilPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));

        // Titre
        JLabel titre = new JLabel("Tableau de bord administratif", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 28));
        titre.setForeground(new Color(33, 64, 154));
        titre.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(titre, BorderLayout.NORTH);

        // Panneau central avec statistiques
        JPanel statsPanel = new JPanel(new GridLayout(2, 3, 30, 30));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        statsPanel.setOpaque(false);

        statsPanel.add(dashboardCard("Membres actifs", "152", new Color(76, 175, 80)));
        statsPanel.add(dashboardCard("Abonnements à renouveler", "12", new Color(255, 193, 7)));
        statsPanel.add(dashboardCard("Paiements ce mois", "3 200 €", new Color(33, 150, 243)));
        statsPanel.add(dashboardCard("Tickets unitaires", "45", new Color(156, 39, 176)));
        statsPanel.add(dashboardCard("Salles affiliées", "5", new Color(244, 67, 54)));
        statsPanel.add(dashboardCard("Notifications", "3", new Color(0, 188, 212)));

        JPanel statsContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        statsContainer.setOpaque(false);


        statsPanel.setPreferredSize(new Dimension(800, 350));

        statsContainer.add(statsPanel);
        add(statsContainer, BorderLayout.CENTER);

        // Message d'accueil
        JLabel info = new JLabel(
            "<html><div style='text-align:center;'>Bienvenue !<br>"
            + "Utilisez le menu à gauche pour naviguer entre les différentes sections de gestion.<br>"
            + "Ce dashboard vous permet de superviser l’ensemble du réseau de salles de sport.</div></html>",
            JLabel.CENTER
        );
        info.setFont(new Font("Arial", Font.PLAIN, 16));
        info.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        add(info, BorderLayout.SOUTH);
    }

    private JPanel dashboardCard(String titre, String valeur, Color couleur) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(couleur, 3, true),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));
        panel.setLayout(new BorderLayout());

        JLabel titreLabel = new JLabel(titre, JLabel.CENTER);
        titreLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        titreLabel.setForeground(new Color(80, 80, 80));

        JLabel valeurLabel = new JLabel(valeur, JLabel.CENTER);
        valeurLabel.setFont(new Font("Arial", Font.BOLD, 28));
        valeurLabel.setForeground(couleur);

        panel.add(titreLabel, BorderLayout.NORTH);
        panel.add(valeurLabel, BorderLayout.CENTER);

        return panel;
    }
}
