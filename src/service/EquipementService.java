/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.EquipementDao;
import entite.Equipement;
import java.util.List;

/**
 *
 * @author klaus
 */
public class EquipementService {

    private EquipementDao dao = new EquipementDao();

    public void ajouter(Equipement equipement) {
        dao.ajouter(equipement);
    }

    public void modifier(Equipement equipement) {
        dao.modifier(equipement);
    }

    public void supprimer(Equipement equipement) {
        dao.supprimer(equipement);
    }

    public Equipement trouver(String libelle) {
        return dao.trouver(libelle);
    }

    public List<Equipement> lister() {
        return dao.listerTous();
    }
}
