/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ClientDao;
import entite.Client;
import java.util.List;

/**
 *
 * @author klaus
 */
public class ClientService {
    
    private ClientDao dao = new ClientDao();

    public void ajouter(Client client) {
        dao.ajouter(client);
    }

    public void modifier(Client client) {
        dao.modifier(client);
    }

    public void supprimer(Client client) {
        dao.supprimer(client);  
    }

    public Client trouver(String nom) {
        return dao.trouver(nom);
    }

    public List<Client> lister() {
        return dao.listerTous();
    }

}
