package com.example.evaluation_dardari_gwendoline;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class VehiculeController implements Initializable {
    @FXML
    private TextField nomField;
    @FXML
    private TextField prixField;
    @FXML
    private TableView table_voiture;
    @FXML
    private TableView table_moto;
    @FXML
    private TableColumn nom_col_voiture;
    @FXML
    private TableColumn prix_col_voiture;
    @FXML
    private TableColumn nom_col_moto;
    @FXML
    private TableColumn prix_col_moto;
    @FXML
    private Button btn_ajouter_voiture;
    @FXML
    private Button btn_vider_voiture;
    @FXML
    private Button btn_ajouter_moto;
    @FXML
    private Button btn_vider_moto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        nom_col_voiture.setCellValueFactory(new PropertyValueFactory<Voiture,String>("nom"));
        prix_col_voiture.setCellValueFactory(new PropertyValueFactory<Voiture,Double>("prix"));
        nom_col_moto.setCellValueFactory(new PropertyValueFactory<Moto,String>("nom"));
        prix_col_moto.setCellValueFactory(new PropertyValueFactory<Moto,Double>("prix"));
        VoitureDAO voitureDAO = new VoitureDAO();
        ObservableList<Voiture> voitures = FXCollections.observableArrayList(voitureDAO.getVoiture());
        MotoDAO motoDAO = new MotoDAO();
        ObservableList<Moto> motos = FXCollections.observableArrayList(motoDAO.getMoto());
        table_voiture.setItems(voitures);
        table_moto.setItems(motos);
        System.out.println(voitures);
        System.out.println(motos);
    }

    @FXML
    public void ajouterVoiture(){
        try{
            String nom = nomField.getText();
            Double prix = Double.parseDouble(prixField.getText());
            nomField.setText("");
            prixField.setText("");
            Voiture voiture = new Voiture(nom,prix);
            ObservableList<Voiture> voitures = table_voiture.getItems();
            voitures.add(voiture);
            table_voiture.setItems(voitures);
            VoitureDAO voitureDAO = new VoitureDAO();
            voitureDAO.ajouterVoiture(voiture);
        }
        catch (Exception e){

        }
    }

    @FXML
    public void ajouterMoto(){
        try{
            String nom = nomField.getText();
            Double prix = Double.parseDouble(prixField.getText());
            nomField.setText("");
            prixField.setText("");
            Moto moto = new Moto(nom,prix);
            ObservableList<Moto> motos = table_moto.getItems();
            motos.add(moto);
            table_moto.setItems(motos);
            MotoDAO motoDAO = new MotoDAO();
            motoDAO.ajouterMoto(moto);
        }
        catch (Exception e){

        }
    }

    @FXML
    public void supprimerToutesVoitures(){
        VoitureDAO voitureDAO = new VoitureDAO();
        voitureDAO.supprimerToutesVoitures();
        table_voiture.getItems().clear();
    }
    @FXML
    public void supprimerToutesMotos(){
        MotoDAO motoDAO = new MotoDAO();
        motoDAO.supprimerToutesMotos();
        table_moto.getItems().clear();
    }


}
