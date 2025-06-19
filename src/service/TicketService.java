/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.TicketDao;
import entite.Ticket;
import java.util.List;

/**
 *
 * @author klaus
 */
public class TicketService {
    private TicketDao dao = new TicketDao();

    public void ajouter(Ticket ticket) {
       dao.ajouter(ticket);
    }
    public void modifier(Ticket ticket) {
       dao.modifier(ticket);
    }
    public void supprimer(Ticket ticket) {
       dao.supprimer(ticket);
    }
    public Ticket trouver(int montant) {
       return dao.trouver(montant);
    }

    public List<Ticket> lister() {
       return dao.listerTous();
    }
}
