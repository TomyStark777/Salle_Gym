/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Abonnement;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Connexion;

/**
 *
 * @author klaus
 */
public class AbonnementDao {
    public void ajouter(Abonnement abonnement) {
        Connection connexion = Connexion.getSessionV2();
        String sql = "INSERT INTO abonnements (id, type, date_debut, date_fin) VALUES ("
                + abonnement.getId() + ", "
                + "'" + abonnement.getTypeAbonnement().getLibelle()+ "', "
                + "'" + abonnement.getDateDebut() + "', "
                + "'" + abonnement.getDateFin() + "');";

        try {
            Statement statement = connexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'abonnement : " + e.getMessage());
        }
    }

    public void modifier(Abonnement abonnement) {
        Connection connexion = Connexion.getSessionV2();
        String sql = "UPDATE abonnements SET "
                + "type = '" + abonnement.getTypeAbonnement().getLibelle()+ "', "
                + "date_debut = '" + abonnement.getDateDebut() + "', "
                + "date_fin = '" + abonnement.getDateFin() + "' "
                + "WHERE id = " + abonnement.getId() + ";";

        try {
            Statement statement = connexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'abonnement : " + e.getMessage());
        }
    }

    public void supprimer(Abonnement abonnement) {
        Connection connexion = Connexion.getSessionV2();
        String sql = "DELETE FROM abonnements WHERE id = " + abonnement.getId() + ";";

        try {
            Statement statement = connexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'abonnement : " + e.getMessage());
        }
    }

    public Abonnement trouver(int id) {
        Connection connexion = Connexion.getSessionV2();
        String sql = "SELECT * FROM abonnements WHERE id = " + id + ";";
        Abonnement abonnement = new Abonnement();
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                abonnement.setId(resultSet.getInt("id"));
                //abonnement.setTypeAbonnement(TypeAbonnement.valueOf(resultSet.getString("type")));
                abonnement.setDateDebut(resultSet.getTimestamp("date_debut").toLocalDateTime());
                abonnement.setDateFin(resultSet.getTimestamp("date_fin").toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de l'abonnement : " + e.getMessage());
        }
        
        return abonnement;
    }

    public List<Abonnement> listerTous() {
        Connection connexion = Connexion.getSessionV2();
        String sql = "SELECT * FROM abonnements;";
        List<Abonnement> abonnements = new ArrayList<>();

        try {
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Abonnement abonnement = new Abonnement();
                abonnement.setId(resultSet.getInt("id"));
                //abonnement.setTypeAbonnement(resultSet.getString("type"));
                abonnement.setDateDebut(resultSet.getTimestamp("date_debut").toLocalDateTime());
                abonnement.setDateFin(resultSet.getTimestamp("date_fin").toLocalDateTime());
                abonnements.add(abonnement);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la liste des abonnements : " + e.getMessage());
        }

        return abonnements;
    }
}
