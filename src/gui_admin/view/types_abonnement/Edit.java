/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.view.types_abonnement;

import entite.TypeAbonnement;
import gui_util.ButtonPanel;
import gui_util.GenericEdit;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author klaus
 */
public class Edit extends GenericEdit {

    private JTextField code = new JTextField();
    private JTextField libelle = new JTextField();
    private JTextField montant = new JTextField();
    private TypeAbonnement entite = new TypeAbonnement();

    public Edit() {
        super();
        JLabel codeLabel = new JLabel("Code :");
        JLabel libelleLabel = new JLabel("Libellé :");
        JLabel montantLabel = new JLabel("Montant :");

        this.form.add(codeLabel);
        this.form.add(code);

        this.form.add(libelleLabel);
        this.form.add(libelle);

        this.form.add(montantLabel);
        this.form.add(montant);

    }

    public Edit(TypeAbonnement entite) {
        this();
        this.entite = entite;
        this.initForm(entite);
    }

    public void init() {
        this.entite.setCode(code.getText());
        this.entite.setLibelle(libelle.getText());
        this.entite.setMontant(Integer.parseInt(montant.getText()));
    }

    public TypeAbonnement getEntite() {
        return entite;
    }

    private void initForm(TypeAbonnement entite) {
        code.setText(entite.getCode());
        libelle.setText(entite.getLibelle());
        montant.setText(String.valueOf(entite.getMontant()));
    }

}
