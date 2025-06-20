/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.view.dashboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author klaus
 */
public class DashboardMenu extends JPanel {
    private JPanel panelOptions;
    private Dashboard dashboard;

    public DashboardMenu(Dashboard dashboard) {
        this.dashboard = dashboard;
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 10, 20, 10));
        setPreferredSize(new Dimension(220, 0)); // 220 pixels de large, ajuste selon ton besoin

        JLabel titre = new JLabel("Menu", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 22));
        titre.setBorder(new EmptyBorder(0, 0, 20, 0));
        add(titre, BorderLayout.NORTH);

        panelOptions = new JPanel();
        panelOptions.setLayout(new BoxLayout(panelOptions, BoxLayout.Y_AXIS));
        panelOptions.setOpaque(false);
        add(panelOptions, BorderLayout.CENTER);

        setBackground(new Color(140, 140, 255)); // Couleur de fond claire
    }

    public void addOption(String text) {
        JButton option = new JButton(text);
        option.setBorderPainted(false);
        option.setContentAreaFilled(true);
        option.setFocusPainted(false);
        option.setOpaque(true);
        option.setBackground(this.getBackground());  
        option.setForeground(Color.WHITE);
        option.setFont(new Font("Arial", Font.PLAIN, 15));
        option.setRolloverEnabled(false);
        option.setHorizontalAlignment(SwingConstants.LEFT);
        option.setHorizontalTextPosition(SwingConstants.LEFT);
        option.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        option.setBorder(new EmptyBorder(10, 5, 5, 10)); 
        option.addActionListener(e -> dashboard.afficherContenu(text));

        panelOptions.add(option);

        // Ajoute un séparateur sauf après le dernier bouton
        panelOptions.add(Box.createRigidArea(new Dimension(0, 5)));
        JSeparator separateur= new JSeparator(SwingConstants.HORIZONTAL);
        separateur.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        panelOptions.add(separateur);

    }


}
