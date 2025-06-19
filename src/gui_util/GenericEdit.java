/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author klaus
 */
public class GenericEdit extends JFrame {
    
    protected JPanel form = new JPanel();
    protected ButtonPanel buttonPanel = new ButtonPanel();
   
    public GenericEdit() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        form.setLayout(new GridLayout(0, 2));
        
        c.add(buttonPanel, BorderLayout.SOUTH);
        c.add(form, BorderLayout.CENTER);
    }

    public JPanel getForm() {
        return form;
    }

    public JButton getSaveButton() {
        return buttonPanel.getSaveButton();
    }
    
     public JButton getCancelButton() {
        return buttonPanel.getCancelButton();
    }
    
     
     public void afficher(){
         this.setVisible(true);
     }
}
