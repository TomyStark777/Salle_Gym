/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Membre;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Connexion;

/**
 *
 * @author klaus
 */
public class MembreDao {

    public void ajouter(Membre membre) {
        Connection session = Connexion.getSessionV2();
        String sql;
        sql = "INSERT INTO membres (id, dateInscription) VALUES ("
                + membre.getId() + ", "
                + "'" + membre.getDateInscription() + "'"
                + ");";

        try {

            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du membre : " + e.getMessage());
        }
    }

    public void modifier(Membre membre) {
        Connection session = Connexion.getSessionV2();
        String sql;
        sql = "UPDATE membres SET "
                + "id = " + membre.getId() + ", "
                + "dateInscription = '" + membre.getDateInscription() + "' "
                + "WHERE id = " + membre.getId() + ";";

        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du membre : " + e.getMessage());
        }
    }

    public Membre trouver(int id) {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM membres WHERE id = " + id + ";";
        Membre membre = new Membre();
        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                membre.setId(resultSet.getInt("id"));
                membre.setDateInscription(resultSet.getTimestamp("date").toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du membre : " + e.getMessage());
        }
        return membre;
    }

    public void supprimer(Membre membre) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM membres WHERE id = " + membre.getId() + ";";

        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du membre : " + e.getMessage());
        }
    }

    public List<Membre> listerTous() {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM membres;";
        List<Membre> membre = new ArrayList<>();

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Membre mem = new Membre();
                mem.setId(resultSet.getInt("id"));
                mem.setDateInscription(resultSet.getTimestamp("date").toLocalDateTime());
                membre.add(mem);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la liste des membres : " + e.getMessage());
        }
        return membre;
    }
}
