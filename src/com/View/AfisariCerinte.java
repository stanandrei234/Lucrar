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


public class AfisariCerinte {
    File fileCercetator=new File("AdaugaCercetator.txt");
    File fileArticol=new File("AdaugaArticol.txt");
    File fileRevista=new File("AdaugaRevista.txt");
    File fileConferinta=new File("AdaugaConferinta.txt");
    CtrlDepartament ctrlDepartament;
    public AfisariCerinte(CtrlDepartament ctrlDepartament){
        this.ctrlDepartament=ctrlDepartament;
    }

    public void afisareListaArticolelorDinReviste(BorderPane borderPane){
        ArrayList<ArticolStiintific> ll=new ArrayList();
        ll=this.ctrlDepartament.getListaArticolelorDinReviste();
        ObservableList<ArticolStiintific> l= FXCollections.observableArrayList(ll) ;
        TableView<ArticolStiintific> table;
        TableColumn<ArticolStiintific,String > tableColumn=new TableColumn<>("Tip Articol");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<ArticolStiintific,String > tableColum=new TableColumn<>("ID");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("indentificare_lucrareStiintifica"));

        TableColumn<ArticolStiintific,String > tableColumm=new TableColumn<>("Numar Cercetatori");
        tableColumm.setCellValueFactory(new PropertyValueFactory<>("numar"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColumn,tableColum,tableColumm);
        borderPane.setRight(table);
    }
    public void afisareListaArticolelorDinConferinte(BorderPane borderPane){
        ArrayList<ArticolStiintific> ll=new ArrayList();
        ll=this.ctrlDepartament.getListaArticolelorDinConferinte();
        ObservableList<ArticolStiintific> l= FXCollections.observableArrayList(ll) ;
        TableView<ArticolStiintific> table;
        TableColumn<ArticolStiintific,String > tableColumn=new TableColumn<>("Tip Articol");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<ArticolStiintific,String > tableColum=new TableColumn<>("ID");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("indentificare_lucrareStiintifica"));

        TableColumn<ArticolStiintific,String > tableColumm=new TableColumn<>("Numar Cercetatori");
        tableColumm.setCellValueFactory(new PropertyValueFactory<>("numar"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColumn,tableColum,tableColumm);
        borderPane.setRight(table);
    }
    public void afisareListaArticolelorPeGrupuri(BorderPane borderPane){
        ArrayList<ArticolGrup> ll=new ArrayList();
        ll=this.ctrlDepartament.getArticolStiintificPeGrupuri();
        ObservableList<ArticolGrup> l= FXCollections.observableArrayList(ll) ;
        TableView<ArticolGrup> table;
        TableColumn<ArticolGrup,String > tableColummm=new TableColumn<>("ID Grup");
        tableColummm.setCellValueFactory(new PropertyValueFactory<>("nr_grupa"));

        TableColumn<ArticolGrup,String > tableColumn=new TableColumn<>("Tip Articol");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<ArticolGrup,String > tableColum=new TableColumn<>("ID");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("indentificare_lucrareStiintifica"));

        TableColumn<ArticolGrup,String > tableColumm=new TableColumn<>("Numar Cercetatori");
        tableColumm.setCellValueFactory(new PropertyValueFactory<>("numar"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColummm,tableColumn,tableColum,tableColumm);
        borderPane.setRight(table);
    }
    public void afisareListaArticolelorPeAutori(BorderPane borderPane){
        ArrayList<ArticolAutor> ll=new ArrayList();
        ll=this.ctrlDepartament.getLucrariStiintificePeAutri();
        ObservableList<ArticolAutor> l= FXCollections.observableArrayList(ll) ;
        TableView<ArticolAutor> table;
        TableColumn<ArticolAutor,String > tableColummm=new TableColumn<>("Nume Cercetator");
        tableColummm.setCellValueFactory(new PropertyValueFactory<>("nume"));

        TableColumn<ArticolAutor,String > tableColumn=new TableColumn<>("Tip Articol");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<ArticolAutor,String > tableColum=new TableColumn<>("ID");
        tableColum.setCellValueFactory(new PropertyValueFactory<>("indentificare_lucrareStiintifica"));

        TableColumn<ArticolAutor,String > tableColumm=new TableColumn<>("Numar Cercetatori");
        tableColumm.setCellValueFactory(new PropertyValueFactory<>("numar"));

        table=new TableView<>();
        table.setItems(l);
        table.getColumns().addAll(tableColummm,tableColumn,tableColum,tableColumm);
        borderPane.setRight(table);
    }


}
