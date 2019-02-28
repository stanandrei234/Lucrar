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

public class Stergeri {
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
    public Stergeri(CtrlDepartament ctrlDepartament){
        this.ctrlDepartament=ctrlDepartament;
    }

    public void VBoxStergeri(BorderPane borderPane){
        VBox vBox=new VBox(10);

        HBox revista=new HBox(10);
        Label label=new Label("Scrieti in fiserul ADAUDA REVISTA"+"\n"+"Numele revistei si numarul acesteia");
        label.setFont(Font.font("Cambria", 14));
        Button stergeRevista=new Button("Sterge Revista");
        stergeRevista.setPrefSize(150,30);

        stergeRevista.setOnAction(e->{
            boolean ok=false;
            boolean ok1=false;
            RevistaStiintifica revistaStiintifica=new RevistaStiintifica();
           ok1= revistaStiintifica.citireFisierRevista(fileRevista);
           ok= this.ctrlDepartament.deleteRevista(revistaStiintifica.getNume_lucrare(),revistaStiintifica.returnNumarIdentificareLucrare());
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileRevista);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            if(ok && ok1){
                Label label1=new Label("Stergere Efectuata");
                borderPane.setBottom(label1);
            }else{
                Label label1=new Label("Nu s-a putut realiza stergerea");
                borderPane.setBottom(label1);
            }
        });
        revista.getChildren().addAll(stergeRevista,label);

        HBox conferinta=new HBox(10);
        Label label1=new Label("Scrieti in fiserul ADAUDA CONFERINTA"+"\n"+"Numele conferintei ,numarul acesteia, si anul");
        label1.setFont(Font.font("Cambria", 14));
        Button stergeConferinta=new Button("Sterge Conferinta");
        stergeConferinta.setPrefSize(150,30);

        stergeConferinta.setOnAction(e->{
            boolean ok;
            boolean ok1;
            ConferintaStiintifica conferintaStiintifica=new ConferintaStiintifica();
          ok=  conferintaStiintifica.citireFisierConferinte(fileConferinta);
          ok1=  this.ctrlDepartament.delteConferinta(conferintaStiintifica.getNume_lucrare(),conferintaStiintifica.returnNumarConferinta(),conferintaStiintifica.getAn());

            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fileConferinta);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();
            if(ok && ok1){
                Label label2=new Label("Stergere Efectuata");
                borderPane.setBottom(label2);
            }else{
                Label label2=new Label("Nu s-a putut realiza stergerea");
                borderPane.setBottom(label2);
            }

        });
        conferinta.getChildren().addAll(stergeConferinta,label1);

        vBox.getChildren().addAll(revista,conferinta);
        borderPane.setLeft(vBox);

    }


}
