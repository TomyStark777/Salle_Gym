/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.MoyenDePaiement;
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
public class MoyenDePaiementDao {

    public void ajouter(MoyenDePaiement moyenDePaiement) {
        //Connection session =  Connexion.getInstance().getSession();
        Connection session = Connexion.getSessionV2();
        String sql = "INSERT INTO moyens_paiement(code, libelle) "
                + "VALUES("
                + "'" + moyenDePaiement.getCode() + "',"
                + "'" + moyenDePaiement.getLibelle() + "'"
                + ");";
        try {
            Statement statement = session.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }

    public void modifier(MoyenDePaiement moyenDePaiement) {

        Connection session = Connexion.getSessionV2();
        String sql = "UPDATE moyens_paiement"
                + "SET" + "libelle = " + moyenDePaiement.getLibelle() + ","
                + "WHERE" + "code = " + moyenDePaiement.getCode() + ";";

        try {
            Statement statement = session.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void supprimer(String code) {
        Connection session = Connexion.getSessionV2();
        String sql = "DELETE FROM moyens_paiement WHERE code = '" + code + "' ;";

        try {
            Statement statement = session.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public MoyenDePaiement trouver(String code) {
        MoyenDePaiement moyenDePaiement = new MoyenDePaiement();
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM moyens_paiement WHERE code = '" + code + "';";

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                moyenDePaiement.setCode(resultSet.getString(1));
                moyenDePaiement.setLibelle(resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        return moyenDePaiement;
    }

    public List<MoyenDePaiement> listerTous() {
        List<MoyenDePaiement> listes = new ArrayList<>();
        Connection session = Connexion.getSessionV2();
        String sql = "SELECT * FROM moyens_paiement;";

        try {
            Statement statement = session.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            MoyenDePaiement moyenDePaiement = new MoyenDePaiement();

            while (resultSet.next()) {
                moyenDePaiement.setCode(resultSet.getString(1));
                moyenDePaiement.setLibelle(resultSet.getString(2));

                listes.add(moyenDePaiement);
            }

        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return listes;
    }

}
