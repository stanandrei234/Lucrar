package Domain;

import javax.security.sasl.SaslClient;
import java.io.*;
import java.util.Scanner;

public class RevistaStiintifica extends LucrareStiintifica {
    Scanner x;
    protected  int nr_revista;
    public  RevistaStiintifica(){}
    public RevistaStiintifica(String nume,int nr_revista){
        super(nume);
        this.nr_revista=nr_revista;
    }
    public  RevistaStiintifica(RevistaStiintifica rev){
        this.nr_revista=rev.nr_revista;
        this.nume_lucrare=rev.nume_lucrare;
    }

    @Override
    public String toString() {
        return super.toString()+nr_revista;
    }

    @Override
    public boolean equals(Object obj){
        //vad daca doi cercetatori sunt egali
        if(!(obj instanceof Domain.RevistaStiintifica))
            return false;
        Domain.RevistaStiintifica p=(Domain.RevistaStiintifica) obj;

        String s=this.getNume_lucrare();
        String ss=p.nume_lucrare;
        return(this.getNume_lucrare().equals(p.getNume_lucrare())&&(this.nr_revista==p.nr_revista));
    }

    @Override
    public String getNume_lucrare() {
        return super.getNume_lucrare();
    }

    @Override
    public void setNume_lucrare(String nume_lucrare) {
        super.setNume_lucrare(nume_lucrare);
    }

    public int getNr_revista() {
        return nr_revista;
    }

    public void setNr_revista(int nr_revista) {
        this.nr_revista = nr_revista;
    }

    @Override
    public void scriereFisierRevista(File file) {
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
            writer.write(this.nr_revista+"\n");

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
    public void scriereFisierConferinta(File file) {
     //   super.scriereFisierConferinta(file);
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public String reurnTipLucrare() {
        return "Revista";
    }

    @Override
    public int returnNumarIdentificareLucrare() {
        return this.getNr_revista();
    }

    @Override
    public int returnNumarConferinta() {
        return super.returnNumarConferinta();
    }

    @Override
    public boolean citireFisierRevista(File file) {



            try{
                x=new Scanner(file);

                String s = "";
                int k = 0;
                int an=0;
                try{
                s = x.next();
                k = x.nextInt();}
                catch(Exception e){
                    System.out.println("Datele din Fisierul REVISTA STIINTIFICA nu sunt corecte");
                    return false;
                }
                this.nume_lucrare=s;
                this.nr_revista=k;


            }catch(Exception e){
                System.out.println("Nu s-a putut deschide fisierul "+file.getName());
                return false;
            }
            x.close();
            return true;
        }

}
