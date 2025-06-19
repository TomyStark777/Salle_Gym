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
public class Paiement {
    private int id;
    private LocalDateTime dateDePaiement;
    private int montant;
    private MoyenDePaiement moyenDePaiement;
    private Abonnement abonnement;
    
    public Paiement() {

    }

    public LocalDateTime getDateDePaiement() {
        return dateDePaiement;
    }

    public void setDateDePaiement(LocalDateTime dateDePaiement) {
        this.dateDePaiement = dateDePaiement;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public MoyenDePaiement getMoyenDePaiement() {
        return moyenDePaiement;
    }

    public void setMoyenDePaiement(MoyenDePaiement moyenDePaiement) {
        this.moyenDePaiement = moyenDePaiement;
    }

    public Abonnement getAbonement() {
        return abonnement;
    }

    public void setAbonement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
