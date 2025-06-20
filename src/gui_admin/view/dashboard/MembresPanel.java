/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.view.dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author klaus
 */
public class MembresPanel extends JPanel {

    public MembresPanel() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(4, 1, 15, 15)); // 4 sections verticales, espacées

        // 1. Création de compte
        JPanel creationPanel = new JPanel();
        creationPanel.setLayout(new BoxLayout(creationPanel, BoxLayout.Y_AXIS));
        creationPanel.setBorder(BorderFactory.createTitledBorder("Création de compte"));

        JPanel ligneNom = new JPanel(new BorderLayout(5, 0));
        ligneNom.add(new JLabel("Nom : "), BorderLayout.WEST);
        ligneNom.add(new JTextField(15), BorderLayout.CENTER);

        JPanel lignePrenom = new JPanel(new BorderLayout(5, 0));
        lignePrenom.add(new JLabel("Prénom : "), BorderLayout.WEST);
        lignePrenom.add(new JTextField(15), BorderLayout.CENTER);

        JPanel ligneEmail = new JPanel(new BorderLayout(5, 0));
        ligneEmail.add(new JLabel("Email : "), BorderLayout.WEST);
        ligneEmail.add(new JTextField(15), BorderLayout.CENTER);

        JButton boutonCreer = new JButton("Créer");
        boutonCreer.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonCreer.addActionListener((ActionEvent ) -> {
        });


        creationPanel.add(ligneNom);
        creationPanel.add(Box.createVerticalStrut(8));
        creationPanel.add(lignePrenom);
        creationPanel.add(Box.createVerticalStrut(8));
        creationPanel.add(ligneEmail);
        creationPanel.add(Box.createVerticalStrut(12));
        creationPanel.add(boutonCreer);

        //Modification d'unn compte
        JPanel modificationPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        modificationPanel.setBorder(BorderFactory.createTitledBorder("Modification d'utilisateur"));
        modificationPanel.add(new JLabel("ID utilisateur :"));
        modificationPanel.add(new JTextField());
        modificationPanel.add(new JLabel("Nouveau nom :"));
        modificationPanel.add(new JTextField());
        modificationPanel.add(new JLabel(""));
        modificationPanel.add(new JButton("Modifier"));

        //Suppression d'un compte
        JPanel suppressionPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        suppressionPanel.setBorder(BorderFactory.createTitledBorder("Suppression d'utilisateur"));
        suppressionPanel.add(new JLabel("ID utilisateur :"));
        suppressionPanel.add(new JTextField());
        suppressionPanel.add(new JLabel(""));
        suppressionPanel.add(new JButton("Supprimer"));

        //Consultation d'un compte
        JPanel consultationPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        consultationPanel.setBorder(BorderFactory.createTitledBorder("Consultation d'utilisateur"));
        consultationPanel.add(new JLabel("ID utilisateur :"));
        consultationPanel.add(new JTextField());
        consultationPanel.add(new JLabel(""));
        consultationPanel.add(new JButton("Consulter"));

        // Ajout des panels à la vue principale
        add(creationPanel);
        add(modificationPanel);
        add(suppressionPanel);
        add(consultationPanel);
    }
}
