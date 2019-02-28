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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;

public class Apelari  {
    File fileCercetator=new File("AdaugaCercetator.txt");
    File fileArticol=new File("AdaugaArticol.txt");
    File fileRevista=new File("AdaugaRevista.txt");
    File fileConferinta=new File("AdaugaConferinta.txt");
    CtrlDepartament ctrlDepartament;
    public Apelari(CtrlDepartament ctrlDepartament){
        this.ctrlDepartament=ctrlDepartament;
    }
    public BorderPane afisareAdaugari(BorderPane borderPane,CtrlDepartament ctrlDepartament){
        Label label4=new Label();
        VBox vBox=new VBox(10);
        this.ctrlDepartament.citireFisierRevista(fileRevista);

        HBox articol=new HBox(10);
        Button addArticol=new Button("addArticol");
        Label label=new Label("Scrieti in  fisierul File Articol.Tipul Articolului(Revista,Conferinta),id-ul" +"\n" +
                "numarul de cercetatori iar apoi cercetatorii");
        label.setFont(Font.font("Cambria", 14));

        articol.getChildren().addAll(addArticol,label);
        addArticol.setPrefSize(100,30);

        HBox cercetator=new HBox(10);
        Label label1=new Label("Scrieti in fisierul AdaugaCercetatori"+"\n"+"Un cercetator contine: nume, serie, numar, id-ul grupei de cercetatori");
        Button addCercetator=new Button("addCercetator");
        label1.setFont(Font.font("Cambria", 14));
        cercetator.getChildren().addAll(addCercetator,label1);
        addCercetator.setPrefSize(100,30);





        HBox revista=new HBox(10);

        Label label3=new Label("Scriei in Adauga Revista" +"\n"+" Nume revista , numarul revistei");
        Button addRevista=new Button("addRevista");
        addRevista.setOnAction(e->{
            ctrlDepartament.citireFisierRevista(fileRevista);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileRevista);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            System.out.println("Intra");
            label4.setText("Adaugare Revista efectuata cu succes");
            label4.setFont(Font.font("Cambria", 14));
            borderPane.setBottom(label4);
        });
        label3.setFont(Font.font("Cambria", 14));
        addRevista.setPrefSize(100,30);
        revista.getChildren().addAll(addRevista,label3);


        Button addConferinta=new Button("addConferinta");
        addConferinta.setPrefSize(100,30);
        HBox hBox=new HBox(10);
        Label label2=new Label("Scrieti in Adauga Conferinta"+"\n"+" numele conferintei, id-ul, anul ");
        label2.setFont(Font.font("Cambria", 14));
        hBox.getChildren().addAll(addConferinta,label2);

        vBox.getChildren().addAll(articol,cercetator
                ,hBox,revista);
        borderPane.setCenter(vBox);



        addConferinta.setOnAction(e->{
            this.ctrlDepartament.citireFisierConferinte(fileConferinta);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileConferinta);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            System.out.println("Intra");
            label4.setText("Adaugare Conferinta efectuata cu succes");
            label4.setFont(Font.font("Cambria", 14));
            borderPane.setBottom(label4);
        });addCercetator.setOnAction(e->{
            this.ctrlDepartament.citireFisierCercetator(fileCercetator);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileCercetator);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            System.out.println("Intra");
            label4.setText("Adaugare Cercetator efectuata cu succes");
            label4.setFont(Font.font("Cambria", 14));
            borderPane.setBottom(label4);
        });addArticol.setOnAction(e->{
            this.ctrlDepartament.citireFisierArticol(fileArticol);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileArticol);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            System.out.println("Intra");
            label4.setText("Adaugare Articol efectuata cu succes");
            label4.setFont(Font.font("Cambria", 14));
            borderPane.setBottom(label4);
        });


    return borderPane;

    }




    public void arataCercetatorii(BorderPane borderPane){


       ArrayList<Cercetator> ll=new ArrayList();
        for(int i=0;i<ctrlDepartament.getCercetatoriRepo().getLength();i++){
            ll.add(ctrlDepartament.getCercetatoriRepo().getElementIndex(i));
        }
        ObservableList<Cercetator> l= FXCollections.observableArrayList(ll) ;
        TableView<Cercetator> table;
        //name colum
        TableColumn<Cercetator,String> tableColumn=new TableColumn<>("Nume");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("nume_cercetator"));

        //serie colum
        TableColumn<Cercetator,String> serieColumn=new TableColumn<>("Serie");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("serie"));

        //numar colum
        TableColumn<Cercetator,Long> numarColumn=new TableColumn<>("Numar");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("numar"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColumn);
       TableView table1=new TableView<>();
        table1.setItems(l);
        table1.getColumns().addAll(serieColumn);

        HBox hBox=new HBox();
        hBox.getChildren().addAll(table,table1);

        borderPane.setLeft(hBox);
    }


    public void afisareGrupCercetare(BorderPane borderPane){

        ArrayList<GrupCercetare> ll=new ArrayList();
        for(int i=0;i<ctrlDepartament.getGrupCercetareRepo().getLength();i++){
            ll.add(ctrlDepartament.getGrupCercetareRepo().getElementIndex(i));
        }
        ObservableList<GrupCercetare> l= FXCollections.observableArrayList(ll) ;
        TableView<GrupCercetare> table;TableView<GrupCercetare> table1;
        TableColumn<GrupCercetare,String> tableColumn=new TableColumn<>("Nume");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("nume_grup"));

        TableColumn<GrupCercetare,Integer> tableColum=new TableColumn<>("ID");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("id_grup"));
        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColumn,tableColum);
        table1=new TableView<>();
        table1.setItems(l);
      //  table1.getColumns().addAll(tableColumnn);
        HBox hBox=new HBox();
        hBox.getChildren().addAll(table);

        borderPane.setRight(hBox);
    }


    public void afisareStergeri(BorderPane borderPane,CtrlDepartament ctrlDepartament){

    }

    public void afisariTotale(BorderPane borderPane){
        VBox vBox=new VBox(10);
        Button grupCercetare=new Button("Afisare Grup Cercetare");
        grupCercetare.setPrefSize(150,30);
        grupCercetare.setOnAction(e->{
            clearPanel(borderPane);
            this.afisareGrupCercetare(borderPane);
        });

        Button lucrariStiintifice=new Button("Afisare Lucrari Stiintifice");
        lucrariStiintifice.setPrefSize(150,30);
        lucrariStiintifice.setOnAction(e->{
            clearPanel(borderPane);
            this.arataLucrareStiintifica(borderPane);
        });
        Button articol=new Button("Afisare Toate Articolele");
        articol.setPrefSize(150,30);
        articol.setOnAction(e->{
            clearPanel(borderPane);
            this.arataArticole(ctrlDepartament,borderPane);
        });

        Button listaArticoleDinReviste=new Button("Articole din Reviste");
        listaArticoleDinReviste.setPrefSize(150,30);
        listaArticoleDinReviste.setOnAction(e->{
            clearPanel(borderPane);
                AfisariCerinte afisariCerinte=new AfisariCerinte(ctrlDepartament);
                afisariCerinte.afisareListaArticolelorDinReviste(borderPane);
        });

        Button listaArticoleDinConferinte=new Button("Articole din Conferinte");
        listaArticoleDinConferinte.setPrefSize(150,30);
        listaArticoleDinConferinte.setOnAction(e->{
            clearPanel(borderPane);
            AfisariCerinte afisariCerinte=new AfisariCerinte(ctrlDepartament);
            afisariCerinte.afisareListaArticolelorDinConferinte(borderPane);
        });
        Button listaArticolePeGrupuri=new Button("Articole pe Grupuri");
        listaArticolePeGrupuri.setPrefSize(150,30);
        listaArticolePeGrupuri.setOnAction(e->{
            clearPanel(borderPane);
            AfisariCerinte afisariCerinte=new AfisariCerinte(ctrlDepartament);
            afisariCerinte.afisareListaArticolelorPeGrupuri(borderPane);
        });
     Button listaArticolePeAutori=new Button("Articole pe Autori");
        listaArticolePeAutori.setPrefSize(150,30);
        listaArticolePeAutori.setOnAction(e->{
            clearPanel(borderPane);
            AfisariCerinte afisariCerinte=new AfisariCerinte(ctrlDepartament);
            afisariCerinte.afisareListaArticolelorPeAutori(borderPane);
        });


        vBox.getChildren().setAll(grupCercetare,lucrariStiintifice,articol,listaArticoleDinReviste,listaArticoleDinConferinte
        ,listaArticolePeGrupuri,listaArticolePeAutori);
        borderPane.setLeft(vBox);

    }



    public void clearPanel(BorderPane borderPane) {
        borderPane.setCenter(null);
        borderPane.setBottom(null);
        borderPane.setRight(null);
    }

    public void arataLucrareStiintifica(BorderPane borderPane){
        ArrayList<LucrareStiintifica> ll=new ArrayList();
        for(int i=0;i<ctrlDepartament.getLucrareStiintificaRepo().getLength();i++){
            ll.add(ctrlDepartament.getLucrareStiintificaRepo().getElementIndex(i));
        }
        ObservableList<LucrareStiintifica> l= FXCollections.observableArrayList(ll) ;
        TableView<LucrareStiintifica> table;
        TableView<LucrareStiintifica> table1;

        TableColumn<LucrareStiintifica,String > tableColumn=new TableColumn<>("Nume");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("nume_lucrare"));

        TableColumn<LucrareStiintifica,String > tableColum=new TableColumn<>("Numar Revista");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("nr_revista"));

        TableColumn<LucrareStiintifica,String > tableColumm=new TableColumn<>("Numar Conferinta");
        tableColumm.setCellValueFactory(new PropertyValueFactory<>("numar_conferinta"));
        TableColumn<LucrareStiintifica,String > tableColummn=new TableColumn<>("An-Conferinta");
        tableColummn.setCellValueFactory(new PropertyValueFactory<>("an"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColumn,tableColum,tableColumm,tableColummn);
        table.setLayoutX(100);

        borderPane.setCenter(table);
    }

    public void arataArticole(CtrlDepartament ctrlDepartament,BorderPane borderPane){

        ArrayList<ArticolStiintific> ll=new ArrayList();
        for(int i=0;i<ctrlDepartament.getArticolRepo().getLength();i++){
            ll.add(ctrlDepartament.getArticolRepo().getElementIndex(i));
        }
        ObservableList<ArticolStiintific> l= FXCollections.observableArrayList(ll) ;
        TableView<ArticolStiintific> table;
        TableView<ArticolStiintific> table1;

        TableColumn<ArticolStiintific,String > tableColumn=new TableColumn<>("Tip Articol");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<ArticolStiintific,String > tableColum=new TableColumn<>("ID");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("indentificare_lucrareStiintifica"));

        TableColumn<ArticolStiintific,String > tableColumm=new TableColumn<>("Numar Cercetatori");
        tableColumm.setCellValueFactory(new PropertyValueFactory<>("numar"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColumn,tableColum,tableColumm);
        table.setLayoutX(100);

        borderPane.setRight(table);

    }
}
