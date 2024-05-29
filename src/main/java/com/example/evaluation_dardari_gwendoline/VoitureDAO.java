package com.example.evaluation_dardari_gwendoline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO {

    public List<Voiture> getVoiture(){
        List<Voiture> voitures = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e6447u_eval_java","e6447u_appli", "32319255");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM tvoiture");

            while (rs.next()){
                voitures.add(new Voiture(rs.getString(2),rs.getInt(3)));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    System.out.println(voitures);
        return voitures;
    }

    public void ajouterVoiture(Voiture voiture){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e6447u_eval_java","e6447u_appli", "32319255");
            PreparedStatement statement = con.prepareStatement("INSERT INTO tvoiture(nom,prix)VALUES(?,?)");
            statement.setString(1,voiture.getNom());
            statement.setDouble(2,voiture.getPrix());
            statement.executeUpdate();
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void supprimerToutesVoitures(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e6447u_eval_java", "e6447u_appli", "32319255");
            PreparedStatement statement = con.prepareStatement("DELETE FROM tvoiture");
            statement.executeUpdate();
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
