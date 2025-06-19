/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Paiement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connexion;

/**
 *
 * @author klaus
 */
public class PaiementDao {

    public void ajouter(Paiement paiement) {
        Connection session = Connexion.getSessionV2();
        String sql;
        sql = "INSERT INTO paiements (montant, date) VALUES ("
                + paiement.getMontant() + ", "
                + "'" + paiement.getDateDePaiement().toLocalTime() + "'"
                + ");";

        try {

            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du paiement : " + e.getMessage());
        }
    }

    public void modifier(Paiement paiement) {
        Connection session = Connexion.getSessionV2();
        String sql;
        sql = "UPDATE paiements SET "
                + "montant = " + paiement.getMontant() + ", "
                + "date = '" + paiement.getDateDePaiement().toLocalTime() + "' "
                + "WHERE id = " + paiement.getId() + ";";

        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du paiement : " + e.getMessage());
        }
    }

    public Paiement trouver(int montant) {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM paiements WHERE montant = " + montant + ";";
        Paiement paiement = new Paiement();
        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                paiement.setId(resultSet.getInt("id"));
                paiement.setMontant(resultSet.getInt("montant"));
                paiement.setDateDePaiement(resultSet.getTimestamp("date").toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du paiement : " + e.getMessage());
        }
        return paiement;
    }

    public void supprimer(Paiement paiement) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM paiements WHERE id = " + paiement.getId() + ";";

        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du paiement : " + e.getMessage());
        }
    }

    public List<Paiement> listerTous() {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM paiements;";
        List<Paiement> paiements = new ArrayList<>();

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Paiement paiement = new Paiement();
                paiement.setId(resultSet.getInt("id"));
                paiement.setMontant(resultSet.getInt("montant"));
                paiement.setDateDePaiement(resultSet.getTimestamp("date").toLocalDateTime());
                paiements.add(paiement);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la liste des paiements : " + e.getMessage());
        }
        return paiements;
    }
}
