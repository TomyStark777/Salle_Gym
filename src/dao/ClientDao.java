/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import util.Connexion;

/**
 *
 * @author klaus
 */
public class ClientDao {
    public void ajouter(Client client) {
        Connection session = Connexion.getSessionV2();
        String sql = "INSERT INTO clients(nom, prenom, date_naissance, email) "
                + "VALUES("
                + "'" + client.getNom() + "',"
                + "'" + client.getPrenom() + "',"
                + "'" + client.getDateNaissance() + "',"
                + "'" + client.getEmail() + "'"
                + ");";
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void modifier(Client client) {
        Connection session = Connexion.getSessionV2();
        String sql = "UPDATE clients SET "
                + "nom = '" + client.getNom() + "',"
                + "prenom = '" + client.getPrenom() + "',"
                + "date_naissance = '" + client.getDateNaissance() + "',"
                + "email = '" + client.getEmail() + "' "
                + "WHERE id = " + client.getId() + ";";
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void supprimer(Client client) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM clients WHERE id = " + client.getId() + ";";
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public Client trouver(String nom) {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM clients WHERE nom = '" + nom + "';";
        Client client = null;
        try {
            Statement statement = session.createStatement();
            var result = statement.executeQuery(sql);
            if (result.next()) {
                client = new Client();
                client.setId(result.getInt("id"));
                client.setNom(result.getString("nom"));
                client.setPrenom(result.getString("prenom"));
                client.setDateNaissance(result.getObject("date_naissance", java.time.LocalDateTime.class));
                client.setEmail(result.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return client;
    }

    // Méthode pour lister tous les clients
    public List<Client> listerTous() {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();
        
        try (Statement statement = session.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setNom(resultSet.getString("nom"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setDateNaissance(resultSet.getObject("date_naissance", LocalDateTime.class));
                client.setEmail(resultSet.getString("email"));
                
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors du listage des clients : " + e.getMessage());
        }
        
        return clients;
    }
}
