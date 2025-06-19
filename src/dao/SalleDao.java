/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Salle;
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
public class SalleDao {

    public void ajouter(Salle salle) {
        Connection session = Connexion.getSessionV2();
        String sql = "INSERT INTO salles (libelle, description)"
                + " VALUES ('" + salle.getLibelle() + "', "
                + "'" + salle.getDescription()+ "'"
                + ")";
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la salle : " + e.getMessage());
        }

    }

    public void modifier(Salle salle) {
        Connection session = Connexion.getSessionV2();
        String sql = "UPDATE salles SET "
                + "libelle = '" + salle.getLibelle() + "', "
                + "description = '" + salle.getDescription() + "' "
                + "WHERE id = " + salle.getId();
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la salle : " + e.getMessage());
        }
    }

    public void supprimer(Salle salle) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM salles WHERE libelle = '" + salle.getLibelle() + "';";
        try {
            Statement statement = session.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la salle : " + e.getMessage());
        }
    }

    public Salle trouver(String libelle) {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM salles WHERE libelle = '" + libelle + "';";
        Salle salle =  new Salle();

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            if (resultSet.next()) {
                salle.setLibelle(resultSet.getString("libelle"));
                salle.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la salle : " + e.getMessage());
        }
        return salle;
    }

    public List<Salle> listerTous() {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM salles;";
        List<Salle> salles = new ArrayList<>();
        Salle salle = new Salle();

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                salle.setId(resultSet.getInt("id"));
                salle.setLibelle(resultSet.getString("libelle"));
                salle.setDescription(resultSet.getString("description"));
                salles.add(salle);
            }
            
        } catch (SQLException e)  {
            System.out.println("Erreur : " + e.getMessage());
        }

        return salles;
    }
}
