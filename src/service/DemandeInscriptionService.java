/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DemandeInscriptionDao;
import entite.DemandeInscription;
import java.util.List;

/**
 *
 * @author klaus
 */
public class DemandeInscriptionService {
    private DemandeInscriptionDao dao = new DemandeInscriptionDao();

    public void ajouter(DemandeInscription demandeInscription) {
        dao.ajouter(demandeInscription);
    }

    public void modifier(DemandeInscription demandeInscription) {
        dao.modifier(demandeInscription);
    }

    public void supprimer(String code) {
        dao.supprimer(code);
    }

    public DemandeInscription trouver(int id) {
        return dao.trouver(id);
    }

    public List<DemandeInscription> listerTous() {
        return dao.listerTous();
    }
}
