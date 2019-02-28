package Controller;

import Domain.ArticolStiintific;
import Domain.*;
import Domain.GrupCercetare;
import Domain.LucrareStiintifica;
import Repository.ArticolRepo;
import Repository.CercetatoriRepo;
import Repository.GrupCercetareRepo;
import Repository.LucrareStiintificaRepo;
import com.View.ArticolAutor;
import com.View.ArticolGrup;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class CtrlDepartament {
protected CercetatoriRepo cercetatoriRepo;
protected ArticolRepo articolRepo;
protected GrupCercetareRepo grupCercetareRepo;
protected LucrareStiintificaRepo lucrareStiintificaRepo;
Scanner x;
//implicit constructor
public CtrlDepartament(){
    cercetatoriRepo=new CercetatoriRepo();
    articolRepo=new ArticolRepo();
    grupCercetareRepo=new GrupCercetareRepo();
    lucrareStiintificaRepo=new LucrareStiintificaRepo();
}
public CtrlDepartament(Vector<Cercetator> cercetators, Vector<ArticolStiintific> articolStiintifics,
                       Vector<GrupCercetare> grupCercetares, Vector<LucrareStiintifica> lucrareStiintificas){

    cercetatoriRepo=new CercetatoriRepo(cercetators);
    articolRepo=new ArticolRepo(articolStiintifics);
    grupCercetareRepo=new GrupCercetareRepo(grupCercetares);
    lucrareStiintificaRepo=new LucrareStiintificaRepo(lucrareStiintificas);
}
public CtrlDepartament(CercetatoriRepo cercetatoriRepo,ArticolRepo articolRepo
                        ,GrupCercetareRepo grupCercetareRepo,LucrareStiintificaRepo lucrareStiintificaRepo){

    this.lucrareStiintificaRepo=lucrareStiintificaRepo;
    this.cercetatoriRepo=cercetatoriRepo;
    this.articolRepo=articolRepo;
    this.grupCercetareRepo=grupCercetareRepo;
}

/*Setter and getter*/

    public ArticolRepo getArticolRepo() {
        return articolRepo;
    }

    public CercetatoriRepo getCercetatoriRepo() {
        return cercetatoriRepo;
    }

    public GrupCercetareRepo getGrupCercetareRepo() {
        return grupCercetareRepo;
    }

    public LucrareStiintificaRepo getLucrareStiintificaRepo() {
        return lucrareStiintificaRepo;
    }

    public void setArticolRepo(ArticolRepo articolRepo) {
        this.articolRepo = articolRepo;
    }

    public void setCercetatoriRepo(CercetatoriRepo cercetatoriRepo) {
        this.cercetatoriRepo = cercetatoriRepo;
    }

    public void setGrupCercetareRepo(GrupCercetareRepo grupCercetareRepo) {
        this.grupCercetareRepo = grupCercetareRepo;
    }

    public void setLucrareStiintificaRepo(LucrareStiintificaRepo lucrareStiintificaRepo) {
        this.lucrareStiintificaRepo = lucrareStiintificaRepo;
    }


/*Add element
* */

public void addCercetator(String nume,String serie,long numar,int idGrup){
    if(this.grupCercetareRepo.existaUnGrup(idGrup)==true ){
        Cercetator cercetator=new Cercetator(nume,serie,numar,idGrup);
        this.cercetatoriRepo.addElement(cercetator);
    }
    else{
        System.out.println("Nu se poate insera acest cercetator pentru ca id-ul grupului de cercetare nu exista");
    }
}


public  void addGrupCercetare(int idGrupCercetare,String numeGrupCercetare){
    GrupCercetare grupCercetare=new GrupCercetare(idGrupCercetare,numeGrupCercetare);
    this.grupCercetareRepo.addElement(grupCercetare);
}


//adaug un articol
public void addArticolStiintific(String type,int numarIdentificare,int numarElemente,Vector<Cercetator> cercetators) {
    //vad daca toti cercetatorii exista
    boolean ok = true;
    for (int i = 0; i < numarElemente; i++) {
        if (this.cercetatoriRepo.existaObiectDat(cercetators.get(i)) <0) {
            ok = false;
            break;
        }
    }
    if (ok == false) {
        System.out.println("Nu toti cercetatorii exista");
    } else {
        ArticolStiintific articolStiintific = new ArticolStiintific(type, numarIdentificare, cercetators, numarElemente);
        this.articolRepo.addElement(articolStiintific);
    }
}

//add lucrareStiintifica
    public void addRevistaStiintifica(String nume,int nr_revista){
    RevistaStiintifica revistaStiintifica=new RevistaStiintifica(nume,nr_revista);
    this.lucrareStiintificaRepo.addElement(revistaStiintifica);
    }

    public void addConferintaStiintifica(String nume,int numarConferinta,int an){
        ConferintaStiintifica conferintaStiintifica=new ConferintaStiintifica(nume,numarConferinta,an);
        this.lucrareStiintificaRepo.addElement(conferintaStiintifica);
    }


/*update Element*/

public void updateCercetatori(String nume,String serie,long numar,int idGrup,String nume1,String serie1,long numar1,int idGrup1){
    Cercetator cercetator=new Cercetator(nume,serie,numar,idGrup);
    Cercetator cercetator1=new Cercetator(nume1,serie1,numar1,idGrup1);
    if(this.cercetatoriRepo.existaObiectDat(cercetator1)>0)
    this.cercetatoriRepo.updateElem(cercetator,cercetator1);
    else{
        System.out.println("Acest cercetator deja exista");
    }
}

public void updateArticolStiintific(String type,int numarIdentificare,
                                    String type1,int numarIdentificare1,int numarElemente1,Vector<Cercetator> cercetators1){
    for(int i=0;i<this.articolRepo.getLength();i++){
        if(this.articolRepo.getElementIndex(i).getIndentificare_lucrareStiintifica()==numarIdentificare&&
                this.articolRepo.getElementIndex(i).getType().equals(type) ){
            ArticolStiintific articolStiintific;
            articolStiintific=this.articolRepo.getElementIndex(i);
            ArticolStiintific articolStiintific1 = new ArticolStiintific(type1, numarIdentificare1, cercetators1, numarElemente1);
            this.articolRepo.updateElem(articolStiintific,articolStiintific1);
            break;

        }

}}

public void updateRevista(String nume,int nr_revista,String nume1,int nr_revista1){
    RevistaStiintifica revistaStiintifica=new RevistaStiintifica(nume,nr_revista);
    RevistaStiintifica revistaStiintifica1=new RevistaStiintifica(nume1,nr_revista1);
    this.lucrareStiintificaRepo.updateElem(revistaStiintifica,revistaStiintifica1);
}
public void updateConferinta(String nume,int numarConferinta,int an,String nume1,int numarConferinta1,int an1){
    ConferintaStiintifica conferintaStiintifica=new ConferintaStiintifica(nume,numarConferinta,an);
    ConferintaStiintifica conferintaStiintifica1=new ConferintaStiintifica(nume1,numarConferinta1,an1);
    this.lucrareStiintificaRepo.updateElem(conferintaStiintifica,conferintaStiintifica1);
}
//fac un update la un cercetator dupa numar si serie
public void updateCercetatorByNumarAndSerie(String serie,long numar,String nume1,String serie1,long numar1,int idGrup1){
    Cercetator cercetator1=new Cercetator(nume1,serie1,numar1,idGrup1);

    for(int i=0;i<this.cercetatoriRepo.getLength();i++){
         if( this.cercetatoriRepo.getElementIndex(i).getNumar()==numar && serie.equals(this.cercetatoriRepo.getElementIndex(i).getSerie())){
             this.cercetatoriRepo.updateElem(this.cercetatoriRepo.getElementIndex(i),cercetator1);
         }
}}

/*Delete element*/

    public void deleteCercetatori(String nume,String serie,long numar,int idGrup){
        Cercetator cercetator=new Cercetator(nume,serie,numar,idGrup);
        this.cercetatoriRepo.deleteObject(cercetator);
    }
//sterg un articol dupa tip,nr identificare
    public void deleteArticolStiintific(String type,int numarIdentificare){
     for(int i=0;i<this.articolRepo.getLength();i++){
         if(this.articolRepo.getElementIndex(i).getIndentificare_lucrareStiintifica()==numarIdentificare&&
                 this.articolRepo.getElementIndex(i).getType().equals(type) ){
             ArticolStiintific articolStiintific;
             articolStiintific=this.articolRepo.getElementIndex(i);
             this.articolRepo.deleteObject(articolStiintific);
         }
     }

    }

    public boolean deleteRevista(String nume,int nr_revista){

        RevistaStiintifica revistaStiintifica=new RevistaStiintifica(nume,nr_revista);
     return   this.lucrareStiintificaRepo.deleteObject(revistaStiintifica);
    }
    public boolean delteConferinta(String nume,int numarConferinta,int an){
        ConferintaStiintifica conferintaStiintifica=new ConferintaStiintifica(nume,numarConferinta,an);
      return  this.lucrareStiintificaRepo.deleteObject(conferintaStiintifica);
    }

    /* Citiri din fisier
    * */

    public void citireFisierCercetator(File file){
        try{
            x=new Scanner(file);
            while (x.hasNext()) {
                String nume = "";
                String serie = "";
                long numar = 0;
                int nrGrup = 0;
                try{
                nume = x.next();
                serie = x.next();
                numar = x.nextLong();
                nrGrup = x.nextInt();}catch(Exception e){
                    System.out.println("Date intorduse gresit in fisierul "+file.getName());
                }
                //vad daca nrGrupului exista in lista de grupuri de cercetare
                if(this.grupCercetareRepo.existaUnGrup(nrGrup)){
                Cercetator cercetator = new Cercetator(nume, serie, numar, nrGrup);

                this.cercetatoriRepo.addElement(cercetator);}
                else{
                    System.out.println("Nu exista un astfel de grup pentru acest cercetator ");
                }
            }
        }catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file.getName());
        }
        x.close();
    }

    public void citireFisierGrupCercetre(File file) {
        try{
            x = new Scanner(new File("Citire_Grup_Cercetare.txt"));
            while (x.hasNext()) {
                String s = "";
                int k = 0;
                try{
                k = x.nextInt();
                s = x.next();}
                catch (Exception e){
                    System.out.println("Date intorduse gresit in fisierul "+file.getName());
                }
                GrupCercetare grup = new GrupCercetare(k, s);
                this.grupCercetareRepo.addElement(grup);}
        }catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul " + file.getName());
        }
        x.close();
    }
    public void citireFisierConferinte(File file){
        try{
            x=new Scanner(file);
            while (x.hasNext()) {
                String s = "";
                int k = 0;
                int an=0;
                try{
                s = x.next();
                k = x.nextInt();
                an=x.nextInt();}catch (Exception e){
                    System.out.println("Date intorduse gresit in fisierul "+file.getName());
                }
                ConferintaStiintifica grup = new ConferintaStiintifica(s,k,an);

                this.lucrareStiintificaRepo.addElement(grup);

            }
        }catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file.getName());
        }
        x.close();
    }
    public void citireFisierRevista(File file){
        try{
            x=new Scanner(file);
            while (x.hasNext()) {
                String s = "";
                int k = 0;
                int an=0;
                s = x.next();
                k = x.nextInt();

                RevistaStiintifica grup = new RevistaStiintifica(s,k);
                this.lucrareStiintificaRepo.addElement(grup);
            }
        }catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file.getName());
        }
        x.close();
    }
    //citesc fin fisier un articol
    //verific daca revista sau conferinta exista
    //verific daca toto cercetatorii exista
    public void citireFisierArticol(File file){
        int contor_linii=0;
        try{


            x=new Scanner(file);}catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file.getName());
        }
        try {
            while (x.hasNext()) {
                contor_linii++;
                String type = "";
                int lucrare = 0;
                int numar = 0;
                type = x.next();
                try {
                    if (!(type.equals("Revista") || (type.equals("Conferinta")))) {
                        throw (new Exception());
                    }
                } catch (Exception e) {
                    System.out.println("Articolul citit nu este intr-o conferinta sau revista");
                }
                String nume = "";
                String serie = "";
                long numar_identificare = 0;
                int nrGrup = 0;
                lucrare = x.nextInt();
                boolean ok = false;
                //vad daca exista o asemenea lucrare
                for (int i = 0; i < this.lucrareStiintificaRepo.getLength(); i++) {
                    if ((this.lucrareStiintificaRepo.getElementIndex(i).reurnTipLucrare().equals(type) &&
                            this.lucrareStiintificaRepo.getElementIndex(i).returnNumarConferinta() == lucrare)
                            || (this.lucrareStiintificaRepo.getElementIndex(i).reurnTipLucrare().equals(type) &&
                            this.lucrareStiintificaRepo.getElementIndex(i).returnNumarIdentificareLucrare() == lucrare)) {
                        ok = true;
                        break;
                    }
                }
                boolean ok1 = true;
                numar = x.nextInt();
                Vector<Cercetator> cercetators = new Vector<>(numar);
                for (int i = 0; i < numar; i++) {
                    try {
                        nume = x.next();
                        serie = x.next();
                        numar_identificare = x.nextLong();
                        nrGrup = x.nextInt();
                    } catch (Exception e) {
                        System.out.println("Date intorduse gresit in fisierul " + file.getName());
                    }
                    Cercetator articolStiintific = new Cercetator(nume, serie, numar_identificare, nrGrup);
                    if (this.cercetatoriRepo.existaElementDatIntregime(articolStiintific))
                        cercetators.add(articolStiintific);
                    else
                        ok1 = false;
                }
                if (ok1 && ok) {//daca fiecare cercetator exista si daca lucrarea, de asemenea, exista
                    ArticolStiintific articolStiintific = new ArticolStiintific(type, lucrare, cercetators, numar);
                    this.articolRepo.addElement(articolStiintific);
                } else {
                    System.out.println("Datele nu corespund la citire pentru al " + contor_linii + " -lea element");
                }
            }
        }catch(Exception e){
            System.out.println("Eroare la citireal datelor din fisierul "+file.getName());
        }
        x.close();
    }
    public ArrayList<ArticolStiintific> getListaArticolelorDinConferinte(){
        int contor=1;
        ArrayList<ArticolStiintific> v=new ArrayList(this.getArticolRepo().getLength());
        for(int i=0;i<this.getArticolRepo().getLength();i++){
            if(this.articolRepo.getElementIndex(i).getType().equals("Conferinta")){
                v.add(this.articolRepo.getElementIndex(i));
                System.out.println("Articolul "+contor+this.articolRepo.getElementIndex(i).toString());
                contor++;
            }
        }
        return v;
   }
    public ArrayList<ArticolStiintific> getListaArticolelorDinReviste(){
        int contor=1;
        ArrayList<ArticolStiintific> v=new ArrayList(this.getArticolRepo().getLength());
        System.out.println("Indice  | TipArticol  |  NumarIdentificare ");
        System.out.println("--------------------------------------------");

        for(int i=0;i<this.getArticolRepo().getLength();i++){
            if(this.articolRepo.getElementIndex(i).getType().equals("Revista")){
                v.add(this.articolRepo.getElementIndex(i));
                System.out.println(contor+"       |  "+this.articolRepo.getElementIndex(i).getType()+"    |     "+this.articolRepo.getElementIndex(i).getNumar());
                contor++;
            }
        }
        return v;
    }

    public ArrayList<ArticolGrup>  getArticolStiintificPeGrupuri(){
        int id_grup=0;
        ArrayList<ArticolGrup> v=new ArrayList();
        for(int i=0;i<this.getGrupCercetareRepo().getLength();i++) {
            id_grup = this.getGrupCercetareRepo().getElementIndex(i).getId_grup();
            System.out.println(this.grupCercetareRepo.getElementIndex(i).toString());
            System.out.println("----------------------------------------------");
            for (int j = 0; j < articolRepo.getLength(); j++) {
                if (this.articolRepo.getElementIndex(j).existaGrupCercetare(id_grup)) {
                    ArticolGrup articolGrup = new ArticolGrup(this.articolRepo.getElementIndex(j), id_grup);
                    v.add(articolGrup);
                    System.out.println(this.articolRepo.getElementIndex(j).toString());
                }
            }
        }
        return v;
    }


    public ArrayList<ArticolAutor> getLucrariStiintificePeAutri(){
        ArrayList<ArticolAutor> v=new ArrayList<>();
        for(int i=0;i<this.cercetatoriRepo.getLength();i++){
            System.out.println(this.cercetatoriRepo.getElementIndex(i).toString());
            for(int j=0;j<articolRepo.getLength();j++){
                if(this.articolRepo.getElementIndex(j).existaCercetator(this.cercetatoriRepo.getElementIndex(i))){
                    ArticolAutor articolAutor=new ArticolAutor(this.articolRepo.getElementIndex(j),this.cercetatoriRepo.getElementIndex(i).getNume_cercetator());
                    System.out.println( this.articolRepo.getElementIndex(j).toString());
                    v.add(articolAutor);

                }
            }
        }
return v;
    }
}
