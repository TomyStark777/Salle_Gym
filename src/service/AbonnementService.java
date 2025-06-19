/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AbonnementDao;
import entite.Abonnement;
import java.util.List;

/**
 *
 * @author klaus
 */
public class AbonnementService {
    private AbonnementDao dao = new AbonnementDao();


    public void ajouter(Abonnement abonnement) {
        dao.ajouter(abonnement);
    }

    public void modifier(Abonnement abonnement) {
        dao.modifier(abonnement);
    }

    public void supprimer(Abonnement abonnement) {
        dao.supprimer(abonnement);
    }

    public Abonnement trouver(int id) {
        return dao.trouver(id);
    }

    public List<Abonnement> lister() {
        return dao.listerTous();
    }
}
