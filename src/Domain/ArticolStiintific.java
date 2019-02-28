package Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ArticolStiintific {

   protected String type;//de ce tip e, conferinta sau revista
  protected   int indentificare_lucrareStiintifica;
   protected Vector<Cercetator> lista_autori;
   int numar;
   public Cercetator getAutorIndex(int i){
       if(i>=numar){
           System.out.println("Index prea mare");
           return null;
       }
       return lista_autori.get(i);
   }
   public  ArticolStiintific(){lista_autori=new Vector<>(100);}
  public   ArticolStiintific(String type,int indentificare_lucrareStiintifica,Vector<Cercetator> lista_autori,int numar){
      this.lista_autori=new Vector<>(lista_autori.size());
      for(int i=0;i<lista_autori.size();i++){
          this.lista_autori.add(lista_autori.get(i));
      }
      this.type=type;
      this.indentificare_lucrareStiintifica=indentificare_lucrareStiintifica;
      this.numar=numar;
  }

    public int getIndentificare_lucrareStiintifica() {
        return indentificare_lucrareStiintifica;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public int getNumar() {
        return numar;
    }

    public String getType() {
        return type;
    }

    public Vector<Cercetator> getLista_autori() {
        return lista_autori;
    }

    public void setIndentificare_lucrareStiintifica(int indentificare_lucrareStiintifica) {
        this.indentificare_lucrareStiintifica = indentificare_lucrareStiintifica;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
      String s="";
      s=" "+type+" "+indentificare_lucrareStiintifica+" "+numar+"  LISTA_CERCETATORI:  ";
      for(int i=0;i<lista_autori.size();i++){
          s=s+lista_autori.get(i)+" ";
      }
        return s;
    }
    public boolean equals(Object obj){
        //vad daca doi cercetatori sunt egali
        if(!(obj instanceof Domain.ArticolStiintific))
            return false;
        Domain.ArticolStiintific p=(Domain.ArticolStiintific) obj;
        return( this.indentificare_lucrareStiintifica==p.indentificare_lucrareStiintifica && this.type.equals(p.type));
    }

    public void setLista_autori(Vector<Cercetator> lista_autori) {
        this.lista_autori = lista_autori;
    }
    public boolean existaGrupCercetare(int id){
        for(int i=0;i<this.lista_autori.size();i++){
            if(lista_autori.get(i).getNrGrupCercetare()==id){
                return true;
            }
        }
        return false;
    }
    public boolean existaCercetator(Cercetator cercetator){
        for(int i=0;i<lista_autori.size();i++){
            if(this.lista_autori.get(i).equals(cercetator)){
                return true;
            }
        }
        return false;
    }

    //updatez un cercetator
    public void updateCercetatorArticol(Cercetator cercetator){
        for(int i=0;i<lista_autori.size();i++){
            if(lista_autori.get(i).serie.equals(cercetator.getSerie()) && lista_autori.get(i).getNumar()==cercetator.getNumar()){
                lista_autori.get(i).setNrGrupCercetare(cercetator.getNrGrupCercetare());
                lista_autori.get(i).setNume_cercetator(cercetator.getNume_cercetator());
            }
        }
    }

    public void scriereFisierArticol(File file) {
    }

}
