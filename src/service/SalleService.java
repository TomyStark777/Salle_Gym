/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.SalleDao;
import entite.Salle;
import java.util.List;

/**
 *
 * @author klaus
 */
public class SalleService {
    private SalleDao dao = new SalleDao();

    public void ajouter(Salle salle) {
        dao.ajouter(salle);
    }

    public void modifier(Salle salle) {
        dao.modifier(salle);
    }

    public void supprimer(Salle salle) {
        dao.supprimer(salle);
    }

    public Salle trouver(String libelle) {
        return dao.trouver(libelle);
    }

    public List<Salle> lister() {
        return dao.listerTous();
    }
}
