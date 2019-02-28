package UI;

import Controller.CtrlDepartament;
import Domain.Cercetator;
import Domain.ConferintaStiintifica;
import Domain.LucrareStiintifica;
import Domain.RevistaStiintifica;

import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Interface {
    File fileCercetator=new File("AdaugaCercetator.txt");
    File fileArticol=new File("AdaugaArticol.txt");
    File fileRevista=new File("AdaugaRevista.txt");
    File fileConferinta=new File("AdaugaConferinta.txt");
    protected  CtrlDepartament ctrlDepartament;
    File file=new File("Citire_Conferinta.txt");
    File file2=new File("Citire_Reviste.txt");
    File file3=new File("Citire_Cercetatori.txt");
    File file4=new File("Citire_Grup_Cercetare.txt");
    File file5=new File("Citire_Articole.txt");
   public Interface(CtrlDepartament ctrlDepartament){
       this.ctrlDepartament=ctrlDepartament;
   }
   public  void initial(){



       ctrlDepartament.citireFisierGrupCercetre(file4);
       ctrlDepartament.citireFisierCercetator(file3);
       ctrlDepartament.citireFisierRevista(file2);
       ctrlDepartament.citireFisierConferinte(file);
       ctrlDepartament.citireFisierArticol(file5);
       // ctrlDepartament.getArticolRepo().toString();
      // ctrlDepartament.getArticolStiintificPeGrupuri();
     //  ctrlDepartament.getLucrariStiintificePeAutri();
   }

   public void UpdateRevista() throws FileNotFoundException {
       Scanner x=null;

       try {
           x=new Scanner(fileRevista);
       } catch (FileNotFoundException e) {
           System.out.println("Nu s-a putut citi revista pentru update");
       }
       String nume_vechi="";
       String nume_nou="";
       int id=0;
       nume_vechi=x.next();
       id=x.nextInt();
       nume_nou=x.next();
        x.close();
       this.ctrlDepartament.updateRevista( nume_vechi, id,nume_nou,id);
       this.ctrlDepartament.getLucrareStiintificaRepo().toString();




   }
    public void UpdateConferinta(){
        Scanner x=null;

        try {
            x=new Scanner(fileConferinta);
        } catch (FileNotFoundException e) {
            System.out.println("Nu s-a putut citi revista pentru update");
        }
        String nume_vechi="";
        String nume_nou="";
        int id=0;
        int an=0;
        nume_vechi=x.next();
        id=x.nextInt();
        nume_nou=x.next();
        an=x.nextInt();
        this.ctrlDepartament.updateConferinta(nume_vechi,id,an,nume_nou,id,an);
        this.ctrlDepartament.getLucrareStiintificaRepo().toString();




    }


    public void afisareAdaugari(){
       System.out.println("1.Adauga Articol");
        System.out.println("Scrieti in  fisierul File Articol: Tipul Articolului(Revista,Conferinta), " +
                "id-ul de identificare pentru acest tip(numarul revistei sau id-ul conferintei), " +
                "numarul de cercetatori iar apoi cercetatorii");
        System.out.println("Un cercetator contine: nume, serie, numar, id-ul grupei de cercetatori");
        System.out.println("----------------------------------------------------------------");
        System.out.println("2.Adauga Cercetator");
        System.out.println("Toate datele vor fi scrise pe linii separate");
        System.out.println("Un cercetator contine: nume, serie, numar, id-ul grupei de cercetatori");
        System.out.println("----------------------------------------------------------------");
       System.out.println("3.Adauga Revista");
        System.out.println("Toate datele vor fi scrise pe linii separate");

        System.out.println("Scriei in Adauga Revista : Nume revista , numarul revistei");
        System.out.println("----------------------------------------------------------------");

        System.out.println("4.Adauga Conferinta");
        System.out.println("Toate datele vor fi scrise pe linii separate");
        System.out.println("Scrieti in Adauga Conferinta: numele conferintei, id-ul, anul ");
       System.out.println("5.Afiseaza toate lucrarile stiintifice");
       System.out.println("6.Afiseaza cercetatorii");
   } public void afisareStergeri(){
   //   System.out.println("1.Sterge Articol");
       System.out.println("2.Sterge Cercetator");
       System.out.println("3.Sterge Revista");
       System.out.println("4.Sterge Conferinta");
     //  System.out.println("5.Afiseaza toate lucrarile stiintifice");
   }public void afisareUpdate(){
   //   System.out.println("1.Sterge Articol");
        System.out.println("Scrieti in fisierul ADAUGA_CERCETATOR seria si numarul " +
                "\n"+"Scrieti noul nume si noul id al departamentului");
       System.out.println("2.Update Cercetator");

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
       System.out.println("3.Update Revista");
        System.out.println("Scrieti in fisier numele si numarul revistei pe care doriti sa o modificcati");
        System.out.println("Scrieti apoi noul nume");
        System.out.println("Scrieti in fisier numele si numarul conferinteipe care doriti sa o modificcati");
        System.out.println("Scrieti apoi noul nume si noul an");
       System.out.println("4.Update Conferinta");
     //  System.out.println("5.Afiseaza toate lucrarile stiintifice");
   }

   public void afisare(){
    //   System.out.println("1.Citiri");
       System.out.println("2.lista articolelor din reviste şi conferinţe pe autori");
       System.out.println("3.lista articolelor din reviste şi conferinţe pe grupuri");
       System.out.println("4.lista articolelor din reviste");
       System.out.println("5.lista articolelor din conferinta");
       System.out.println("6.Adauga");
       System.out.println("7.Sterge");
       System.out.println("8.Update");
       System.out.println("9.Salvati modificari? Daca apasati se vor salva modificarile");

   }
   public void run(){
       initial();
       int op=0;
       Scanner scan;
       scan=new Scanner(System.in);
       while (true){
           afisare();
           System.out.println("Dati optiunea");
           try{
           op=scan.nextInt();
           switch (op){
               case 2:
                   if(op==2){
                       this.ctrlDepartament.getLucrariStiintificePeAutri();
               }
               break;
               case 3:
                   if(op==3) {
                       this.ctrlDepartament.getArticolStiintificPeGrupuri();
                   }
                   break;
               case 4:
                   if(op==4){
                       this.ctrlDepartament.getListaArticolelorDinReviste();
                   }
                   break;
               case 5:
                   if(op==5){
                       this.ctrlDepartament.getListaArticolelorDinConferinte();
                   }
                   break;
               case 6:
                   if(op==6){
                       int op1=0;
                       afisareAdaugari();
                       System.out.println("Selectati.Apoi scrieti in fisierul corspunzator selectiei");
                       op1=scan.nextInt();
                       try{
                           if(op1==1){
                               //eliberez ce am acolo

                                         this.ctrlDepartament.citireFisierArticol(fileArticol);
                               PrintWriter writer = new PrintWriter(fileArticol);
                               writer.print("");
                               writer.close();
                           }
                           if(op1==2){
                               //eliberez ce am acolo

                               this.ctrlDepartament.citireFisierCercetator(fileCercetator);
                               PrintWriter writer = new PrintWriter(fileCercetator);
                               writer.print("");
                               writer.close();
                           }
                           if(op1==3){
                               //eliberez ce am acolo

                               this.ctrlDepartament.citireFisierRevista(fileRevista);
                               PrintWriter writer = new PrintWriter(fileRevista);
                               writer.print("");
                               writer.close();
                           }
                           if(op1==4){
                               //eliberez ce am acolo

                               this.ctrlDepartament.citireFisierConferinte(fileConferinta);
                             //  PrintWriter writer = new PrintWriter(fileConferinta);
                             //  writer.print("");
                             //  writer.close();
                           }
                           if(op1==5){
                               this.ctrlDepartament.getLucrareStiintificaRepo().toString();
                           }
                           if(op1==6){
                               this.ctrlDepartament.getCercetatoriRepo().toString();
                           }

                       }catch (Exception e){
                           System.out.println("Incercati din nou");
                       }
                   }
                   break;
               case 7:
                   int op1=0;this.afisareStergeri();
                   System.out.println("Dati optiunea pentru stergere");
                    op1=scan.nextInt();
                    if(op1==3){
                        RevistaStiintifica revistaStiintifica=new RevistaStiintifica();
                        revistaStiintifica.citireFisierRevista(fileRevista);
                        this.ctrlDepartament.deleteRevista(revistaStiintifica.getNume_lucrare(),revistaStiintifica.returnNumarIdentificareLucrare());
                    }
                    if(op1==2){
                        Cercetator cercetator=new Cercetator();
                        cercetator.citireFisierCercetator(fileCercetator);
                       this.ctrlDepartament.deleteCercetatori(cercetator.getNume_cercetator(),cercetator.getSerie(),cercetator.getNumar(),cercetator.getNrGrupCercetare());
                        // this.ctrlDepartament.addCercetator(cercetator.getNume_cercetator(),cercetator.getSerie(),cercetator.getNumar(),cercetator.getNrGrupCercetare());
                    }
                    if(op1==4){
                        ConferintaStiintifica conferintaStiintifica=new ConferintaStiintifica();
                        conferintaStiintifica.citireFisierConferinte(fileConferinta);
                        this.ctrlDepartament.delteConferinta(conferintaStiintifica.getNume_lucrare(),conferintaStiintifica.returnNumarConferinta(),conferintaStiintifica.getAn());
                    }
                    break;
               case 8:
                  this.afisareUpdate();
                   System.out.println("Dati optiunea pentru stergere.");
                   op1=scan.nextInt();
                   if(op1==2){
                       Scanner x;
                       x=new Scanner(fileCercetator);
                       String serie_veche=x.next();
                       int numar_vechi=x.nextInt();String nume=x.next();
                       int grup=x.nextInt();
                       if(this.ctrlDepartament.getGrupCercetareRepo().existaUnGrup(grup)) {
                           this.ctrlDepartament.updateCercetatorByNumarAndSerie(serie_veche, numar_vechi,
                                   nume, serie_veche, numar_vechi, grup);
                           Cercetator cercetator=new Cercetator(nume,serie_veche,numar_vechi,grup);
                           this.ctrlDepartament.getArticolRepo().updateCercetatorArticolRepo(cercetator);
                           this.ctrlDepartament.getCercetatoriRepo().toString();
                       }
                       else{
                           System.out.println("Grupul introdus nu exista");
                       }
                   }
                   if(op1==3){
                       UpdateRevista();
                   }
                   if(op1==4){
                       UpdateConferinta();
                   }
               case 9:
                   PrintWriter writer = new PrintWriter(file2);
                   writer.print("");
                   writer.close();
                   this.ctrlDepartament.getLucrareStiintificaRepo().ScriereFisierRevista(file2);
                    writer = new PrintWriter(file);
                   writer.print("");
                   writer.close();
                   this.ctrlDepartament.getLucrareStiintificaRepo().ScriereFisierConferinta(file);
                   writer = new PrintWriter(file3);
                   writer.print("");
                   writer.close();
                   this.ctrlDepartament.getCercetatoriRepo().scriereFisier(file3);
                   writer = new PrintWriter(file5);
                   writer.print("");
                   writer.close();
                   this.ctrlDepartament.getArticolRepo().ScriereFisierArticol(file5);
           }

           }
           catch (Exception e){
               System.out.println("Incercati din nou");
           }


       }
   }
}
