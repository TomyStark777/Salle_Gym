/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_admin.controller;

import entite.TypeAbonnement;
import gui_admin.view.types_abonnement.Edit;
import service.TypeAbonnementService;

/**
 *
 * @author klaus
 */
public class TypeAbonnementController {
    
    private TypeAbonnementService service;

    public TypeAbonnementController() {
        service = new TypeAbonnementService();
    }

    public Edit ajouter() {
        Edit edit = new Edit();
        edit.afficher();
        edit.getSaveButton().addActionListener(e -> {
            edit.init();
            service.ajouter(edit.getEntite());
            edit.dispose();
        });
        return edit;
    }
    
    public Edit modifier(TypeAbonnement entite) {
        Edit edit = new Edit(entite);
        edit.afficher();
        edit.getSaveButton().addActionListener(e -> {
            edit.init();
            service.modifier(edit.getEntite());
            edit.dispose();
        });
        return edit;
    }
}
