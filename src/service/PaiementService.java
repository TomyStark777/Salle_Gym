/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.PaiementDao;
import entite.Paiement;
import java.util.List;

/**
 *
 * @author klaus
 */
public class PaiementService {

    private PaiementDao dao = new PaiementDao();

    public void ajouter(Paiement paiement) {
        dao.ajouter(paiement);
    }

    public void modifier(Paiement paiement) {
        dao.modifier(paiement);
    }

    public void supprimer(Paiement paiement) {
        dao.supprimer(paiement);
    }

    public Paiement trouver(int montant) {
        return dao.trouver(montant);
    }

    public List<Paiement> lister() {
        return dao.listerTous();
    }
}
