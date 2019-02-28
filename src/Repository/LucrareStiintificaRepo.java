package Repository;

import Domain.ConferintaStiintifica;
import Domain.GrupCercetare;
import Domain.LucrareStiintifica;
import Domain.RevistaStiintifica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class LucrareStiintificaRepo extends GeneralRepo<LucrareStiintifica> {
    Scanner x;
    public LucrareStiintificaRepo(){
        super();
    }
   public LucrareStiintificaRepo(Vector<LucrareStiintifica> v){
       super(v);
   }
   public LucrareStiintificaRepo(LucrareStiintificaRepo lucrareStiintificaRepo){
       super(lucrareStiintificaRepo);
   }





    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public void setV(Vector<LucrareStiintifica> v) {
        super.setV(v);
    }

    @Override
    public void updateElem(LucrareStiintifica obj, LucrareStiintifica obj1) {
        for(int i=0;i<length;i++){
            if(v.get(i).equals(obj)){
                v.set(i,obj1);
                break;
            }
        }
    }

    @Override
    public boolean deleteElementIndex(int i) {
       return super.deleteElementIndex(i);
    }

    @Override
    public int searchElem(LucrareStiintifica obj) {
        return super.searchElem(obj);
    }

    @Override
    public void addElement(LucrareStiintifica v) {
     boolean   ok=true;
        for(int i=0;i<this.length;i++){
            if(this.getElementIndex(i).returnNumarConferinta()==v.returnNumarConferinta() && (v.returnNumarConferinta()>-1)){
                ok=false;
            }
        }
        if(ok==true)
        super.addElement(v);
        else{
            System.out.println("Conferinta deja exista");
        }
    }

    @Override
    public LucrareStiintifica getElementIndex(int i) {
        return super.getElementIndex(i);
    }

    @Override
    public Vector<LucrareStiintifica> getV() {
        return super.getV();
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<this.length;i++){
            System.out.println(this.getElementIndex(i).toString());
        }
        return  s;
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    public Scanner getX() {
        return x;
    }

    @Override
    public int existaObiectDat(LucrareStiintifica obj) {
        return super.existaObiectDat(obj);
    }

    @Override
    public boolean deleteObject(LucrareStiintifica obj) {
     return   super.deleteObject(obj);
    }

    @Override
    public void ScriereFisierRevista(File file) {
        for(int i=0;i<this.length;i++){
            try {
                this.getElementIndex(i).scriereFisierRevista(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void ScriereFisierConferinta(File file) {
        for(int i=0;i<this.length;i++){
            this.getElementIndex(i).scriereFisierConferinta(file);
        }
    }
}
