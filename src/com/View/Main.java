package com.View;

import Controller.CtrlDepartament;
import Domain.Cercetator;
import Domain.GrupCercetare;
import Domain.LucrareStiintifica;
import Repository.ArticolRepo;
import Repository.CercetatoriRepo;
import Repository.GrupCercetareRepo;
import Repository.LucrareStiintificaRepo;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import com.sun.org.apache.bcel.internal.generic.LADD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
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

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;

public class Main extends Application  {
    public javafx.scene.control.TextField txtName;
    public javafx.scene.control.Label txtField;
    public javafx.scene.control.Button Buton;
    File fileCercetator=new File("AdaugaCercetator.txt");
    File fileArticol=new File("AdaugaArticol.txt");
    File fileRevista=new File("AdaugaRevista.txt");
    File fileConferinta=new File("AdaugaConferinta.txt");
    public CtrlDepartament ctrlDepartament;
    File file=new File("Citire_Conferinta.txt");
    File file2=new File("Citire_Reviste.txt");
    File file3=new File("Citire_Cercetatori.txt");
    File file4=new File("Citire_Grup_Cercetare.txt");
    File file5=new File("Citire_Articole.txt");
    Button Adaugare=new Button("Adaugare");
    Button Stergeri=new Button("Stergeri");
    Button Afisari=new Button("Afisari");
    Button Update=new Button("Update");
    Button pressMe=new Button("PRESS ME");

    public  void initial(){
        GrupCercetareRepo grupCercetareRepo=new GrupCercetareRepo();
        CercetatoriRepo cercetatoriRepo=new CercetatoriRepo();
        LucrareStiintificaRepo lucrareStiintificaRepo=new LucrareStiintificaRepo();
        ArticolRepo articolRepo=new ArticolRepo();
        CtrlDepartament ctrlDepartament=new CtrlDepartament(cercetatoriRepo,articolRepo,grupCercetareRepo,lucrareStiintificaRepo);
        ctrlDepartament.citireFisierGrupCercetre(file4);
        ctrlDepartament.citireFisierCercetator(file3);
        ctrlDepartament.citireFisierRevista(file2);
        ctrlDepartament.citireFisierConferinte(file);
        ctrlDepartament.citireFisierArticol(file5);
        this.ctrlDepartament=ctrlDepartament;
        // ctrlDepartament.getArticolRepo().toString();
        // ctrlDepartament.getArticolStiintificPeGrupuri();
        //  ctrlDepartament.getLucrariStiintificePeAutri();
      //  ctrlDepartament.getCercetatoriRepo().toString();
      //  System.out.println("E");
    }

    public void createBoxMainMenu(HBox mainMenu){
        mainMenu.setPadding(new Insets(20));
        mainMenu.setAlignment(Pos.CENTER);

       Tooltip tooltip=new Tooltip("Afisari posibile");
       Tooltip tooltip1=new Tooltip("Stergeri posibile");
       Tooltip tooltip2=new Tooltip("Adaugari posibile");
       Tooltip tooltip3=new Tooltip("Update-uri posibile");Tooltip tooltip4=new Tooltip("" +
                "Find out how stupid you are!!");
        tooltip4.setStyle("-fx-font: normal bold 15 Langdon; "
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");
       Tooltip.install(Afisari,tooltip);
       Tooltip.install(Stergeri,tooltip1);
       Tooltip.install(Adaugare,tooltip2);
       Tooltip.install(Update,tooltip3);
       Tooltip.install(pressMe,tooltip4);
        DropShadow shadow = new DropShadow();
       pressMe.setStyle("-fx-font: 15 arial; -fx-base: #ee2211;");
        pressMe.setEffect(shadow);
        pressMe.  setLayoutX(250);
      pressMe.setCancelButton(true);

      HBox hBox=new HBox(60);
      Label label1=new Label("");
      hBox.getChildren().addAll(label1,pressMe);
        mainMenu.getChildren().addAll(Adaugare,Stergeri,Afisari,Update,hBox);


    }

    public void setOnAction(Button b,BorderPane borderPane,Stage stage){
        Apelari apelari=new Apelari(this.ctrlDepartament);
      Stergeri stergeri=new Stergeri(ctrlDepartament);
      Update update=new Update(ctrlDepartament);
        if(b.getText().equals("Adaugare")){

            b.setOnAction(e->{
                borderPane.setCenter(null);
                borderPane.setBottom(null);
                borderPane.setRight(null);
                borderPane.setLeft(null);
             apelari.afisareAdaugari(borderPane,ctrlDepartament);
            });
        }
        if(b.getText().equals("Stergeri")){
            VBox vBox=new VBox();

            b.setOnAction(e->{
                borderPane.setCenter(null);
                borderPane.setBottom(null);
                borderPane.setRight(null);
                stergeri.VBoxStergeri(borderPane);

            });
        }
        if(b.getText().equals("Afisari")){
            b.setOnAction(e->{
                borderPane.setCenter(null);
                borderPane.setBottom(null);
                borderPane.setRight(null);
                apelari.afisariTotale(borderPane);
            });
        }
        if(b.getText().equals("Update")){
            b.setOnAction(e->{
                borderPane.setCenter(null);
                borderPane.setBottom(null);
                borderPane.setRight(null);
                update.UpdateRevista(borderPane);
            });
        }
        if(b.getText().equals("PRESS ME")){
            b.setOnAction(e->{
                stage.close();

            });
        }

    }





    @Override
    public void start(Stage stage) throws Exception {
        initial();
        BorderPane borderPane=new BorderPane();
        HBox mainMenu=new HBox(5);
        createBoxMainMenu(mainMenu);
  //   FXMLLoader fxmlLoader=new FXMLLoader();

   //  fxmlLoader.setLocation((getClass().getResource("fox.fxml")));

       //     Parent root=fxmlLoader.load();


        // Parent root FXMLLoader.load()

        borderPane.setTop(mainMenu);

     setOnAction(Adaugare,borderPane,stage);
   setOnAction(Stergeri,borderPane,stage);
      setOnAction(Afisari,borderPane,stage);
     setOnAction(Update,borderPane,stage);
   setOnAction(pressMe,borderPane,stage);
     //   JLabel lblNewLabel = new JLabel("New label");
     //   lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/view/images.jpeg")));
    //    lblNewLabel.setBounds(271, 46, 208, 228);
    //   borderPane.add(lblNewLabel);
  // borderPane.setStyle("-fx-set-backgroung: url("file://C://Users//Andy%20Joker//IdeaProjects//Lucrari%20Stiintifice//science-03.png);

        Scene scene = new Scene(borderPane, 600, 500);





        stage.setTitle("Welcome to JavaFX!!");
        stage.setScene(scene);
        stage.show();
    }
   public static void main(String[] args) {

         launch(args);
    }

}
