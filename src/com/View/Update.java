package com.View;

import Controller.CtrlDepartament;
import Domain.*;
import Repository.ArticolRepo;
import Repository.CercetatoriRepo;
import Repository.GrupCercetareRepo;
import Repository.LucrareStiintificaRepo;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import com.sun.org.apache.bcel.internal.generic.LADD;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import javafx.scene.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RectangularShape;


import javafx.scene.text.Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import javafx.scene.control.*;

public class Update {
    File fileCercetator=new File("AdaugaCercetator.txt");
    File fileArticol=new File("AdaugaArticol.txt");
    File fileRevista=new File("AdaugaRevista.txt");
    File fileConferinta=new File("AdaugaConferinta.txt");
    CtrlDepartament ctrlDepartament;
    File file=new File("Citire_Conferinta.txt");
    File file2=new File("Citire_Reviste.txt");
    File file3=new File("Citire_Cercetatori.txt");
    File file4=new File("Citire_Grup_Cercetare.txt");
    File file5=new File("Citire_Articole.txt");
    public Update(CtrlDepartament ctrlDepartament){
        this.ctrlDepartament=ctrlDepartament;
    }

    public boolean citireFisierUpdateRevista(){
        Scanner x=null;

        try {
            x=new Scanner(fileRevista);
        } catch (FileNotFoundException e) {
            System.out.println("Nu s-a putut citi revista pentru update");
            return false;
        }
        String nume_vechi="";
        String nume_nou="";
        int id=0;
        try{
        nume_vechi=x.next();
        id=x.nextInt();
        nume_nou=x.next();}catch (Exception e){
            return false;
        }
        x.close();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileRevista);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        writer.print("");
        writer.close();
        this.ctrlDepartament.updateRevista( nume_vechi, id,nume_nou,id);
        return true;
    }

    public boolean citireFisierUpdateConferinta(){
        Scanner x=null;

        try {
            x=new Scanner(fileConferinta);
        } catch (FileNotFoundException e) {
            System.out.println("Nu s-a putut citi revista pentru update");
            return false;
        }
        String nume_vechi="";
        String nume_nou="";
        int id=0;
        int an=0;
        try{
        nume_vechi=x.next();
        id=x.nextInt();
        nume_nou=x.next();
        an=x.nextInt();}catch (Exception e){
            return false;
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileConferinta);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        writer.print("");
        writer.close();

        this.ctrlDepartament.updateConferinta(nume_vechi,id,an,nume_nou,id,an);
        return true;
    }


    public boolean citireRevistaTastatura(BorderPane borderPane){
        VBox vBox=new VBox(10);

        javafx.scene.control.TextField nume_vechi=new javafx.scene.control.TextField();
       nume_vechi.setPromptText("Numele Actual");
        final String[] nume_old = {""};
        final String[] nume_new = {""};
        final int[] id = {-1};
        nume_vechi.setOnKeyReleased(event->{
            if (event.getCode() == KeyCode.ENTER){

                nume_old[0] =nume_vechi.getText();
                Label label=new Label(nume_old[0]);
                borderPane.setBottom(label);
            }
        });

        javafx.scene.control.TextField d=new javafx.scene.control.TextField();
        d.setPromptText("Numarul Revistei");


        d.setOnKeyReleased(event->{
            if (event.getCode() == KeyCode.ENTER){
                    String s="";
                    s=d.getText();
                    try{
                        id[0]=Integer.parseInt(s);
                        Label label=new Label(s);
                        borderPane.setBottom(label);

                    }catch (Exception e){
                        Label label=new Label("Reintorduceti id-ul");
                        borderPane.setBottom(label);

                    }
            }
        });


        javafx.scene.control.TextField nume_nou=new javafx.scene.control.TextField();
        nume_nou.setPromptText("Noul nume");

        nume_nou.setOnKeyReleased(event->{
            if (event.getCode() == KeyCode.ENTER){

                nume_new[0] =nume_nou.getText();
                Label label=new Label(nume_new[0]);
                borderPane.setBottom(label);
            }
        });

        Button gata=new Button("Gata");
        gata.setPrefSize(150,50);
        gata.setOnAction(e->{
            if(nume_new[0].equals("") || nume_old[0].equals("") || id[0]<=-1){
                Label label=new Label("Nu ati completat toate campurile");
                borderPane.setBottom(label);
                borderPane.setRight(null);
            }
            else{
                this.ctrlDepartament.updateRevista( nume_old[0], id[0],nume_new[0],id[0]);
                Label label=new Label("Update Realizat");
                borderPane.setBottom(label);
            }

        });
        vBox.getChildren().addAll(nume_vechi,d,nume_nou,gata);
        borderPane.setRight(vBox);
        return true;
    }

    public void UpdateRevista(BorderPane borderPane){
        VBox vBox=new VBox(10);

        HBox hBox=new HBox(10);
        Button gata=new Button("Gata");
        ComboBox<String > comboBox =new ComboBox<>();
        comboBox.getItems().addAll(
                "Fisier",
                "Tastatura");
        comboBox.setOnAction(e->{
            if(comboBox.getValue().equals("Fisier")){
                Label label=new Label("Scrieti in Adauga Revista"+"\n"+
                "numele revistei actual, numarul revistei si noul nume ");
                borderPane.setBottom(label);
            }

        });
        comboBox.setPromptText("Mod Update Revista");
        gata.setOnAction(e->{
            if(comboBox.getValue().equals("Fisier")){
               boolean ok=citireFisierUpdateRevista();
               if(ok){
                   Label label=new Label("Update cu succes");
                   borderPane.setBottom(label);
               }
               else{
                   Label label=new Label("Update cu esuat");
                   borderPane.setBottom(label);
               }
            }
            if(comboBox.getValue().equals("Tastatura")){
                citireRevistaTastatura(borderPane);
            }


        });

        hBox.getChildren().addAll(comboBox,gata);


        HBox hBox1=new HBox(10);
        Button conferitna=new Button("Update Conferinta");
        conferitna.setPrefSize(150,30);
        Label label=new Label("Scrieti in ADAUGA CONFERINTA" + "\n"+ "Numele actual, id-ul, noul nume, noul an");
        conferitna.setOnAction(e->{
            boolean ok=this.citireFisierUpdateConferinta();
            if(ok){
                Label label1=new Label("Update reusit");
                borderPane.setBottom(label1);
            }
            else{
                Label label1=new Label("Update esuat");
                borderPane.setBottom(label1);
            }
        });
        hBox1.getChildren().addAll(conferitna,label);



        HBox hBox2=new HBox(10);

        Button cercetator=new Button("Update Cercetator");
        cercetator. setPrefSize(150,30);
        Label label3=new Label("Scrie in ADAUGA CERCETATOR"+"\n"+"Seria, numarul, noul nume, noua grupa");
        cercetator.setOnAction(e->{
            int k=updateFileCercetator();
            if(k==-1){
                Label label2=new Label("Update esuat");
                borderPane.setBottom(label2);
            }
            else{
                if(k==1){
                    Label label2=new Label("Update reusit");
                    borderPane.setBottom(label2);
                }
                else{
                    Label label2=new Label("Nu exista grupul de cercetare dat");
                    borderPane.setBottom(label2);
                }
            }

        });
        hBox2.getChildren().addAll(cercetator,label3);

        vBox.getChildren().addAll(hBox,hBox1,hBox2,updateGrupCercetator(borderPane));
        borderPane.setLeft(vBox);



    }

    public String getInt(String something){
        int length = something.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            Character character = something.charAt(i);
            if (Character.isDigit(character) &&(i>something.indexOf(" "))) {
                result += character;
            }
        }
        return result;
    }


    public HBox updateGrupCercetator(BorderPane borderPane){
        HBox hBox=new HBox();
        TextField textField=new TextField();
        textField.setPromptText("Noul Nume al Grupului");
        ArrayList<String> ll=new ArrayList<>();
        for(int i=0;i<ctrlDepartament.getGrupCercetareRepo().getLength();i++){
            ll.add(ctrlDepartament.getGrupCercetareRepo().getElementIndex(i).getNume_grup()+" "+
            ctrlDepartament.getGrupCercetareRepo().getElementIndex(i).getId_grup());
        }
        ObservableList<String > l=FXCollections.observableArrayList(ll);

        final ComboBox comboBox=new ComboBox(l);
        comboBox.setPromptText("Alegeti Grupul");
        comboBox.setOnAction(e->{

            int k=Integer.parseInt(getInt(comboBox.getValue().toString()));
            String nume=this.ctrlDepartament.getGrupCercetareRepo().getNumeGrupById(k);
            System.out.println(k);

            String nou=textField.getText();
            GrupCercetare grupCercetare=new GrupCercetare(k,nume);
            GrupCercetare grupCercetare1=new GrupCercetare(k,nou);
            ctrlDepartament.getGrupCercetareRepo().updateElem(grupCercetare,grupCercetare1);
            textField.clear();
            textField.setPromptText("Noul Nume al Grupului");
          //  comboBox.getSelectionModel().clearSelection();
            Label label=new Label("Update reusit");
            borderPane.setBottom(label);

        });
        hBox.getChildren().addAll(comboBox,textField);
        return hBox;
    }

    public int updateFileCercetator(){
        Scanner x;
        try {
            x=new Scanner(fileCercetator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        String serie_veche;
        int numar_vechi;
        String nume;
        int grup;
        try{
         serie_veche=x.next();
         numar_vechi=x.nextInt();nume=x.next();
         grup=x.nextInt();}catch (Exception e){
            return -1;
        }
        if(this.ctrlDepartament.getGrupCercetareRepo().existaUnGrup(grup)) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileCercetator);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            this.ctrlDepartament.updateCercetatorByNumarAndSerie(serie_veche, numar_vechi,
                    nume, serie_veche, numar_vechi, grup);
            Cercetator cercetator=new Cercetator(nume,serie_veche,numar_vechi,grup);
            this.ctrlDepartament.getArticolRepo().updateCercetatorArticolRepo(cercetator);
            this.ctrlDepartament.getCercetatoriRepo().toString();
        }
        else{
            return 0;
        }

        return 1;


    }
}
