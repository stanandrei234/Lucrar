package Domain;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LucrareStiintifica {
 
    
        protected int idLucrareStiintifica=0;
        protected   String nume_lucrare;

        public LucrareStiintifica(){


            this.nume_lucrare="";
        }

        public LucrareStiintifica(String nume_lucrare){

            this.nume_lucrare=nume_lucrare;

        }

        public void setNume_lucrare(String nume_lucrare) {
            this.nume_lucrare = nume_lucrare;
        }

        public String getNume_lucrare() {
            return nume_lucrare;
        }
        @Override
        public  String toString(){
            return nume_lucrare+" ";
        }
        public boolean equals(Object obj){
            //vad daca doi cercetatori sunt egali
            if(!(obj instanceof Domain.LucrareStiintifica))
                return false;
            Domain.LucrareStiintifica p=(Domain.LucrareStiintifica) obj;
            return(nume_lucrare.equals(p.nume_lucrare));
        }
    public void scriereFisierRevista(File file) throws IOException {
        Scanner x;
        try{
            System.out.println(this.getNume_lucrare());

        }catch (Exception e){
            System.out.println( " Imposibil de scris in fisierul "+file.getName());
        }
    }
    public void scriereFisierConferinta(File file){
        Scanner x;
        try{
            System.out.println(this.getNume_lucrare());

        }catch (Exception e){
            System.out.println( " Imposibil de scris in fisierul "+file.getName());
        }
    }
    public boolean citireFisierRevista(File file){return true;}
    public boolean citireFisierConferinte(File file){return true;}
    /*WATCH OUT*/
    //e o metoda care imi zice ce tip de lucrare am. SE VA DECLARA ACEIASI METODA IN REVISTA SI CONFERINTA, IN REVISTA RE
    //TURNANDU-SE "REVISTA", RESPECTIV "CONFERINTA"
    public String reurnTipLucrare(){
        return "";
    }
    public int returnNumarIdentificareLucrare(){
        return -1;
    }
    public int returnNumarConferinta(){
        return -1;
    }

    }


