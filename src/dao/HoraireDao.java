/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.Connexion;
import entite.Horaire;
import java.time.LocalDateTime;

/**
 *
 * @author klaus
 */
public class HoraireDao {
    public void ajouter(Horaire Horaire) {
        //Connection session =  Connexion.getInstance().getSession();
        Connection session = Connexion.getSessionV2();
        String sql = "INSERT INTO horaires(id, debut, fin, salle) "
                + "VALUES("
                + "'" + Horaire.getId() + "',"
                + "'" + Horaire.getDebut() +"',"
                + "'" + Horaire.getFin() +"'"
                + ");";
        try {
            Statement statement = session.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }


    }

    public void modifier(Horaire Horaire) {
        Connection session = Connexion.getSessionV2();
        String sql = "UPDATE horaires SET " +
                "id = '" + Horaire.getId() + "', " +
                "debut = '" + Horaire.getDebut() + "', " +
                "fin = " + Horaire.getFin() + "'" +
                " WHERE code = '" + Horaire.getId() + ";";
        try {
            Statement statement = session.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void supprimer(Horaire horaire) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM horaires " +
                "WHERE code = '" + horaire.getId() + "';";
        try {
            Statement statement = session.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public Horaire trouver(int id) {
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM horaires WHERE id = '" + id + "'";
        try {
            Statement statement = session.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                LocalDateTime debut = rs.getTimestamp("debut").toLocalDateTime();
                LocalDateTime fin = rs.getTimestamp("fin").toLocalDateTime();
                return new Horaire(id, debut, fin);
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return null;
    }

    public List<Horaire> listerTous() {

        List<Horaire> liste = new ArrayList<>();

        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM horaires";
        try {
            Statement statement = session.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDateTime debut = rs.getTimestamp("debut").toLocalDateTime();
                LocalDateTime fin = rs.getTimestamp("fin").toLocalDateTime();
                liste.add(new Horaire(id, debut, fin));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return liste;
    }
}
