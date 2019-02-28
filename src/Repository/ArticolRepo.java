package Repository;

import Domain.ArticolStiintific;
import Domain.Cercetator;
import Domain.GrupCercetare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ArticolRepo extends GeneralRepo<ArticolStiintific> {
    Scanner x;
    public ArticolRepo(){
        super();
    }
  public  ArticolRepo(Vector<ArticolStiintific> v){
      super(v);
  }

  public ArticolRepo(ArticolRepo articolRepo){
      super(articolRepo);
  }

public void updateCercetatorArticolRepo(Cercetator cercetator){
      for(int i=0;i<this.length;i++){
            //    this.getElementIndex(i).updateCercetatorArticol(String serie,int numar,String nume,int grup);
          this.getElementIndex(i).updateCercetatorArticol(cercetator);
      }
}


    @Override
    public String toString() {
        System.out.println("Artiolele sunt");
        for (int i=0;i<this.length;i++){
            System.out.println("Articolul cu nuarul "+i);
            System.out.println(this.getElementIndex(i).getType());
            System.out.println(this.getElementIndex(i).getIndentificare_lucrareStiintifica());
            System.out.println(this.getElementIndex(i).getNumar());
            for(int j=0;j<this.getElementIndex(i).getNumar();j++){
                System.out.println(this.getElementIndex(i).getAutorIndex(j).toString());
            }

        }
        String  s="";
        return s;
    }

    @Override
    public int existaObiectDat(ArticolStiintific obj) {
        return super.existaObiectDat(obj);
    }

    public Scanner getX() {
        return x;
    }

    @Override
    public ArticolStiintific getElementIndex(int i) {
        return super.getElementIndex(i);
    }

    @Override
    public Vector<ArticolStiintific> getV() {
        return super.getV();
    }

    @Override
    public void addElement(ArticolStiintific v) {
        super.addElement(v);
    }

    @Override
    public int searchElem(ArticolStiintific obj) {
        return super.searchElem(obj);
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public boolean deleteElementIndex(int i) {
     return    super.deleteElementIndex(i);
    }

    @Override
    public void updateElem(ArticolStiintific obj, ArticolStiintific obj1) {
        super.updateElem(obj, obj1);
    }

    @Override
    public void setV(Vector<ArticolStiintific> v) {
        super.setV(v);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public boolean deleteObject(ArticolStiintific obj) {
        return  super.deleteObject(obj);
    }

    @Override
    public void ScriereFisierArticol(File file) {

        for(int i=0;i<this.length;i++){
            FileWriter writer = null;
            try {
                writer = new FileWriter(file,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                writer.write(""+this.getElementIndex(i).getType()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.write(this.getElementIndex(i).getIndentificare_lucrareStiintifica()+"\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.write(this.getElementIndex(i).getNumar()+"\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

            for(int j=0;j<this.getElementIndex(i).getNumar();j++) {
                try {
                    writer.write(this.getElementIndex(i).getAutorIndex(j).getNume_cercetator()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }try {
                    writer.write(this.getElementIndex(i).getAutorIndex(j).getSerie()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }try {
                    writer.write(this.getElementIndex(i).getAutorIndex(j).getNumar()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }try {
                    writer.write(this.getElementIndex(i).getAutorIndex(j).getNrGrupCercetare()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }

