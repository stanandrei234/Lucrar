package Domain;

import java.io.*;
import java.util.Scanner;

public class Cercetator {
    String nume_cercetator;
 String serie;
   long numar;
   public int nrGrupCercetare;
   Scanner x;
    public void citireFisierCercetator(File file){
        try{
            x=new Scanner(file);

                String nume = "";
                String serie = "";
                long numar = 0;
                int nrGrup = 0;
                try{
                nume = x.next();
                serie = x.next();
                numar = x.nextLong();
                nrGrup = x.nextInt();}catch
                        (Exception e){
                    System.out.println("Datele din FISIERUL CERCETATOR NU SUNT CORECTE");
                }
                this.numar=numar;
                this.serie=serie;
                this.nume_cercetator=nume;
                this.nrGrupCercetare=nrGrup;

        }catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file.getName());
        }
        x.close();
    }

   public Cercetator(){
       numar=0;
       serie="";
       nume_cercetator="";
    }
    public Cercetator(String nume_cercetator,String serie,long numar,int nrGrupCercetare){
       this.nume_cercetator=nume_cercetator;
       this.serie=serie;
       this.numar=numar;
       this.nrGrupCercetare=nrGrupCercetare;
    }

    //set and get


    public int getNrGrupCercetare() {
        return nrGrupCercetare;
    }

    public void setNrGrupCercetare(int nrGrupCercetare) {
        this.nrGrupCercetare = nrGrupCercetare;
    }

    public void setNume_cercetator(String nume_cercetator) {
        this.nume_cercetator = nume_cercetator;
    }

    public void setNumar(long numar) {
        this.numar = numar;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNume_cercetator() {
        return nume_cercetator;
    }

    public long getNumar() {
        return numar;
    }

    public String getSerie() {
        return serie;
    }

    @Override
    public  String toString(){
        return nume_cercetator+" "+serie+" "+numar+" "+nrGrupCercetare;
    }
    public boolean equals(Object obj){
        //vad daca doi cercetatori sunt egali
        if(!(obj instanceof Cercetator))
            return false;
        Cercetator p=(Cercetator) obj;
        return((serie.equals(p.serie))&&(numar==p.numar));
    }

    public void scriereFisierCercetator(File file){
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
          //  writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(""+this.nume_cercetator+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(this.serie+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }try {
            writer.write(this.numar+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }try {
            writer.write(this.nrGrupCercetare+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
