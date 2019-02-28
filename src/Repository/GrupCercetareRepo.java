package Repository;

import Domain.GrupCercetare;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Vector;

public class GrupCercetareRepo extends GeneralRepo<GrupCercetare> {
    Scanner x;
    public GrupCercetareRepo(){
        super();
    }
    public GrupCercetareRepo(Vector<GrupCercetare> v){
        super(v);
    }
    public GrupCercetareRepo(GrupCercetareRepo repo){
        super(repo);
    }
    public void scriereFisier(File file){
        try{
             x=new Scanner(file);
        }catch (Exception e){
            System.out.println("Nu s-a putut deschide fisierul "+file);
        }
        for(int i=0;i<this.length;i++){
        //    System.out.println("Lista de grupuri de cercetare");
            System.out.println(this.getElementIndex(i).getId_grup());
            System.out.println(this.getElementIndex(i).getNume_grup());
        }
        x.close();
    }
    //citim din fisier o multime de grupuri de cercetatori

    //testeaza daca exista un grup cu id-ul dat
    public boolean existaUnGrup(int id){
        for(int i=0;i<this.length;i++){
            if(this.getElementIndex(i).getId_grup()==id)
                return true;
        }
        return false;
    }
    @Override
    public GrupCercetare getElementIndex(int i) {
        return super.getElementIndex(i);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Vector<GrupCercetare> getV() {
        return super.getV();
    }

    @Override
    public int searchElem(GrupCercetare obj) {
        return super.searchElem(obj);
    }

    @Override
    public void addElement(GrupCercetare v) {
        super.addElement(v);
    }

    @Override
    public boolean deleteElementIndex(int i) {
      return   super.deleteElementIndex(i);
    }

    @Override
    public void updateElem(GrupCercetare obj, GrupCercetare obj1) {
        super.updateElem(obj, obj1);
    }

    @Override
    public void setV(Vector<GrupCercetare> v) {
        super.setV(v);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public int existaObiectDat(GrupCercetare obj) {
        return super.existaObiectDat(obj);
    }

    @Override
    public boolean deleteObject(GrupCercetare obj) {
       return super.deleteObject(obj);
    }
    public String getNumeGrupById(int id){
        for(int i=0;i<this.length;i++){
            if(this.getElementIndex(i).getId_grup()==id){
                return this.getElementIndex(i).getNume_grup();
            }
        }
        return "";
    }
}
