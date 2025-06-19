/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author klaus
 */
public class Ticket {
    
    private int id;
    private int nombreDeSeance;
    private int montant;
    private Client client;
    
    public Ticket(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombreDeSeance() {
        return nombreDeSeance;
    }

    public void setNombreDeSeance(int nombreDeSeance) {
        this.nombreDeSeance = nombreDeSeance;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
