/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.MembreDao;
import entite.Membre;
import java.util.List;

/**
 *
 * @author klaus
 */
public class MembreService {
    
    private MembreDao dao = new MembreDao();

    public void ajouter(Membre membre) {
        dao.ajouter(membre);
    }

    public void modifier(Membre membre) {
        dao.modifier(membre);
    }

    public void supprimer(Membre membre) {
        dao.supprimer(membre);
    }

    public Membre trouver(int id) {
        return dao.trouver(id);
    }

    public List<Membre> lister() {
        return dao.listerTous();
    }
}
