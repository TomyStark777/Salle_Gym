/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Salle;
import entite.Seance;
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
public class SeanceDao {

    public void ajouter(Seance seance) {
        Connection session = Connexion.getSessionV2();
        String sql = "INSERT INTO seances(date_debut, date_fin, salle_code)"
                + "VALUES("
                + "'" + seance.getDateDebut() + "'" + ","
                + "'" + seance.getDateFin() + "'" + ","
                + "'" + seance.getSalle().getLibelle() + "'"
                + ")";
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la seance : " + e.getMessage());
        }
    }

    public void modifier(Seance seance) {
        Connection session = Connexion.getSessionV2();
        String sql = "UPDATE seances SET "
                + "date_debut = '" + seance.getDateDebut() + "', "
                + "date_fin = '" + seance.getDateFin() + "',"
                + "salle_code = '" + seance.getSalle().getLibelle() + "' "
                + "WHERE id = " + seance.getId();
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la seance : " + e.getMessage());
        }

    }

    public void supprimer(Seance seance) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM seances WHERE id = " + seance.getId();

        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la séance : " + e.getMessage());
        }

    }

    public Seance trouver(int id) {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM seances WHERE id = " + id;
        Seance seance = new Seance();

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                seance.setId(resultSet.getInt("id"));
                seance.setDateDebut(resultSet.getTimestamp("date_debut").toLocalDateTime());
                seance.setDateFin(resultSet.getTimestamp("date_fin").toLocalDateTime());
                Salle salle = new Salle();
                salle.setLibelle(resultSet.getString("salle_code"));
                seance.setSalle(salle);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la séance : " + e.getMessage());
        }
        return seance;
    }

    public List<Seance> listerTous() {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM seances";
        List<Seance> seances = new ArrayList<>();

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Seance seance = new Seance();
                seance.setId(resultSet.getInt("id"));
                seance.setDateDebut(resultSet.getTimestamp("date_debut").toLocalDateTime());
                seance.setDateFin(resultSet.getTimestamp("date_fin").toLocalDateTime());
                Salle salle = new Salle();
                salle.setLibelle(resultSet.getString("salle_code"));
                seance.setSalle(salle);
                seances.add(seance);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des séances : " + e.getMessage());
        }
        return seances;
    }
}
