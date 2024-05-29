package com.example.evaluation_dardari_gwendoline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {
    public List<Moto> getMoto(){
        List<Moto> motos = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e6447u_eval_java","e6447u_appli", "32319255");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM tmoto");

            while (rs.next()){
                motos.add(new Moto(rs.getString(2),rs.getInt(3)));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(motos);
        return motos;
    }

    public void ajouterMoto(Moto moto){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e6447u_eval_java","e6447u_appli", "32319255");
            PreparedStatement statement = con.prepareStatement("INSERT INTO tmoto(nom,prix)VALUES(?,?)");
            statement.setString(1,moto.getNom());
            statement.setDouble(2,moto.getPrix());
            statement.executeUpdate();
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void supprimerToutesMotos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e6447u_eval_java", "e6447u_appli", "32319255");
            PreparedStatement statement = con.prepareStatement("DELETE FROM tmoto");
            statement.executeUpdate();
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
