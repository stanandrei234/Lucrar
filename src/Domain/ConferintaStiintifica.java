package Domain;

import java.io.*;
import java.util.Scanner;

public class ConferintaStiintifica extends LucrareStiintifica {
    int numar_conferinta;
    int an;
    Scanner x;
public ConferintaStiintifica(){
    super();
}
    public ConferintaStiintifica(String nume, int numar_conferinta, int an) {
        super(nume);
        this.numar_conferinta = numar_conferinta;
        this.an = an;
    }

    public int getAn() {
        return an;
    }

    @Override
    public void scriereFisierConferinta(File file) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(""+this.nume_lucrare+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(this.numar_conferinta+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }try {
            writer.write(this.an+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + an + " " + numar_conferinta;
    }

    public int getNumar_conferinta() {
        return numar_conferinta;
    }

    @Override
    public void setNume_lucrare(String nume_lucrare) {
        super.setNume_lucrare(nume_lucrare);
    }

    @Override
    public String getNume_lucrare() {
        return super.getNume_lucrare();
    }

    public void setAn(int an) {
        this.an = an;
    }

    public void setNumar_conferinta(int numar_conferinta) {
        this.numar_conferinta = numar_conferinta;
    }
    public boolean equals(Object obj){
        //vad daca doi cercetatori sunt egali
        if(!(obj instanceof Domain.ConferintaStiintifica))
            return false;
        Domain.ConferintaStiintifica p=(Domain.ConferintaStiintifica) obj;
        return(super.getNume_lucrare().equals(p.getNume_lucrare())&& this.numar_conferinta==p.numar_conferinta);
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public String reurnTipLucrare() {
        return "Conferinta";
    }

    @Override
    public int returnNumarIdentificareLucrare() {
        return this.numar_conferinta;
    }

    @Override
    public int returnNumarConferinta() {
        return this.numar_conferinta;
    }
    @Override
    public boolean citireFisierConferinte(File file){

        try{
            x=new Scanner(file);

                String s = "";
                int k = 0;
                int an=0;
                try{
                s = x.next();
                k = x.nextInt();
                an=x.nextInt();}
                catch(Exception e){
                    System.out.println("Datele din fisierul Conferinta nu sunt corecte");
                    return false;
                }
                this.an=an;
                this.numar_conferinta=k;
                this.nume_lucrare=s;




        }catch(Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file.getName());
            return false;
        }
        x.close();
        return true;
    }

    @Override
    public void scriereFisierRevista(File file) {
      //  super.scriereFisierRevista(file);
    }
}
