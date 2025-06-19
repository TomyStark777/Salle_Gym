/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.time.LocalDateTime;

/**
 *
 * @author klaus
 */
public class Client {
    
    private int id;
    private String nom;
    private String prenom;
    private LocalDateTime dateNaissance;
    private String email;
    private Membre menbre;
    private DemandeInscription demandeInscription;
    private Ticket ticket;
    
    public Client(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDateTime getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDateTime dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Membre getMenbre() {
        return menbre;
    }

    public void setMenbre(Membre menbre) {
        this.menbre = menbre;
    }

    public DemandeInscription getDemandeInscription() {
        return demandeInscription;
    }

    public void setDemandeInscription(DemandeInscription demandeInscription) {
        this.demandeInscription = demandeInscription;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    
}
