/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Client;
import entite.DemandeInscription;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.Connexion;
import java.util.ArrayList;

/**
 *
 * @author klaus
 */
public class DemandeInscriptionDao {

    public void ajouter(DemandeInscription demandeInscription) {
        Connection session =  Connexion.getSessionV2();
        String sql = "INSERT INTO demande_inscription (dateDeDemande, dateDeTraitement, clientId) VALUES ('"
                + demandeInscription.getDateDeDemande() + "', '"
                + demandeInscription.getDateDeTraitement() + "', "
                + demandeInscription.getClient().getId() + ");";
        try (Statement statement = session.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la demande d'inscription : " + e.getMessage());
        }
    }

    public void modifier(DemandeInscription demandeInscription) {
        Connection session =  Connexion.getSessionV2();
        String sql = "UPDATE demande_inscription SET dateDeDemande = '"
                + demandeInscription.getDateDeDemande() + "', dateDeTraitement = '"
                + demandeInscription.getDateDeTraitement() + "', clientId = "
                + demandeInscription.getClient().getId() + " WHERE code = '"
                + demandeInscription.getId() + "'";
        try{
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la demande d'inscription : " + e.getMessage());
        }
    }


    public void supprimer(String code) {
        Connection session =  Connexion.getSessionV2();
        String sql = "DELETE FROM demande_inscription WHERE code = '" + code + "'";
        try (Statement statement = session.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la demande d'inscription : " + e.getMessage());
        }
    }

    public DemandeInscription trouver(int id) {
        Connection session =  Connexion.getSessionV2();
        String sql = "SELECT * FROM demande_inscription WHERE code = '" + id + "';";
        DemandeInscription demandeInscription = new DemandeInscription();
        try{
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                demandeInscription.setId(resultSet.getInt("code"));
                demandeInscription.setDateDeDemande(resultSet.getTimestamp("dateDeDemande").toLocalDateTime());
                demandeInscription.setDateDeTraitement(resultSet.getTimestamp("dateDeTraitement").toLocalDateTime());
                demandeInscription.setClient(new Client());
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return demandeInscription;
    }

    public List<DemandeInscription> listerTous() {
        Connection session =  Connexion.getSessionV2();
        String sql = "SELECT * FROM demande_inscription;";
        List<DemandeInscription> listeDemandes = new ArrayList<>();
        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DemandeInscription demandeInscription = new DemandeInscription();
                demandeInscription.setId(resultSet.getInt("code"));
                demandeInscription.setDateDeDemande(resultSet.getTimestamp("dateDeDemande").toLocalDateTime());
                demandeInscription.setDateDeTraitement(resultSet.getTimestamp("dateDeTraitement").toLocalDateTime());
                demandeInscription.setClient(new Client());
                listeDemandes.add(demandeInscription);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des demandes d'inscription : " + e.getMessage());
        }
        return listeDemandes;
    }
}
