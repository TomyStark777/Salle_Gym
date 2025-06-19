/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entite.Seance;
import java.util.List;
import dao.SeanceDao;

/**
 *
 * @author klaus
 */
public class SeanceService {
    private SeanceDao dao = new SeanceDao();

    public void ajouter(Seance seance) {
        dao.ajouter(seance);
    }
    
    public void modifier(Seance seance) {
        dao.modifier(seance);
    }
    public void supprimer(Seance seance) {
        dao.supprimer(seance);
    }
    
    public Seance trouver(int id) {
        return dao.trouver(id);
    }
    
    public List<Seance> lister() {
        return dao.listerTous();
    }
}