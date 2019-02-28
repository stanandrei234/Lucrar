package Repository;

import Domain.Cercetator;
import Domain.GrupCercetare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class CercetatoriRepo extends GeneralRepo<Cercetator> {
    Scanner x;
    public CercetatoriRepo(){

    }
    public CercetatoriRepo(Vector<Cercetator> v){
        super(v);
    }
    public CercetatoriRepo(CercetatoriRepo repo){
        super(repo);
    }
    public void scriereFisier(File file){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    for(int i=0;i<this.length;i++){
            this.getElementIndex(i).scriereFisierCercetator(file);
    }

        writer.close();
    }

    //citesc din fisier cercetatorii, presupunanad ca id-ul grupurilor in care se afla exista

    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void setV(Vector<Cercetator> v) {
        super.setV(v);
    }

    @Override
    public void updateElem(Cercetator obj,Cercetator obj1) {
        super.updateElem(obj,obj1);
    }

    @Override
    public boolean deleteElementIndex(int i)  {
     return   super.deleteElementIndex(i);
    }

    @Override
    public void addElement(Cercetator v) {
        super.addElement(v);
    }

    @Override
    public int searchElem(Cercetator obj) {
        return super.searchElem(obj);
    }

    @Override
    public Vector<Cercetator> getV() {
        return super.getV();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Cercetator getElementIndex(int i) {
        return super.getElementIndex(i);
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<this.length;i++){
            System.out.println(this.getElementIndex(i).toString());
        }
        return s;
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public int existaObiectDat(Cercetator obj) {
        return super.existaObiectDat(obj);
    }
    public  boolean existaElementDatIntregime(Cercetator cercetator){
        for(int i=0;i<this.length;i++){
            if(this.getElementIndex(i).equals(cercetator
            )&&(cercetator.getNume_cercetator().equals(this.getElementIndex(i).getNume_cercetator()))){
                return true;
            }
        }
        return false;
    }


}
