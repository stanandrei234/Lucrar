package Repository;

import java.io.File;
import java.util.Vector;

public class GeneralRepo<Object> {
    Vector<Object> v = new Vector<Object>(10);
    int length;//lungimea vectorului

    public GeneralRepo() {//constructor implicit in care doar definesc de ce tip va fi vectorul meu
     //   Vector<Object> v = new Vector<Object>(10);
    }


    public GeneralRepo(Vector<Object> obj) {//constructor cu parametru
        Vector<Object> v = new Vector<Object>(10);//initializez vectorul
        this.length = obj.size();
        this.v = obj;
    }


    public GeneralRepo(GeneralRepo<Object> repo) {//constructor de copiere
        this.length = repo.length;
        Vector<Object> v = new Vector<Object>(length);
        for (int i = 0; i < length; i++) {//"mut" elementele din repo-ul transmis ca si parametru in acesta
            v.add(repo.v.get(i));
        }
    }

    public Vector<Object> getV() {
        return v;
    }


    public void setV(Vector<Object> v) {
        this.v = v;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public void addElement(Object v) {//adaug doar daca acest element exista
        if(this.searchElem(v)<0){
        this.v.add(v);length++;}
        else{
            System.out.println("Elementul deja exista "+v.toString());
        }

    }

    public Object getElementIndex(int i) {//returnez element de pe o pozitie indicata
        if (i >= length) {
            System.out.println("POzitia nu exista.Se va returna NULL");
            return null;
        }
        return v.get(i);
    }

    public boolean deleteElementIndex(int i) {//se da o pozitie si sa se stearge lementul de pe acea pozitie
        boolean ok=false;
        if (i >= length || i<0) {
            System.out.println("Elementul de pe pozitia indicata nu exista");
        } else {
            Vector<Object> aux = new Vector<>(length - 1);//fac un vector auxiar in care pun
//toate elemntele exceptand cel de po pozitia data. Apoi doar schimbam adresele de la vectorul
//auxiliar la vectorul nostru
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    ok=true;
                    aux.add(v.get(j));
                }
            }
            v = aux;
            length--;
        }
        return ok;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.length; i++) {
            s = s + v.get(i).toString() + " ";
        }
        return s;

    }

    public int searchElem(Object obj) {//caut toate pozitiile pe care se poate afla un element
        int vv=-1;
        for (int j = 0; j < length; j++) {
            if (this.v.get(j).equals(obj)==true) {
                vv=j;
                break;
            }
        }
        return vv;
    }

    public void updateElem(Object obj,Object obj1){//actualizez un element
        for(int i=0;i<length;i++){
            if(v.get(i).equals(obj)){
                v.set(i,obj1);
                break;
            }
        }
    }

    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public int existaObiectDat(Object obj){
        for(int i=0;i<this.length;i++){
            if(this.v.get(i).equals(obj)==true){
                return i;
            }
        }
        return -1;
    }

    public boolean deleteObject(Object obj){
        int k=this.searchElem(obj);
      return  this.deleteElementIndex(k);
    }
    public void ScriereFisierRevista(File file){

    } public void ScriereFisierConferinta(File file){

    }
    public  void ScriereFisierArticol(File file){}
}
