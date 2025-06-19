/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.HoraireDao;
import entite.Horaire;
import java.util.List;

/**     
 *
 * @author klaus
 */
public class HoraireService {
    private HoraireDao dao = new HoraireDao();
    
    public void ajouter(Horaire horaire) {
        dao.ajouter(horaire);
    }
    
    public void modifier(Horaire horaire) {
        dao.modifier(horaire);
    }
    
    public void supprimer(Horaire horaire) {
        dao.supprimer(horaire);
    }
    
    public Horaire trouver(int id) {
        return dao.trouver(id);
    }
    
    public List<Horaire> lister() {
        return dao.listerTous();
    }
}
