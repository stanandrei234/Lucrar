package Domain;

public class GrupCercetare {
    int id_grup;
    String nume_grup;
   public GrupCercetare(){  //constructor implicit
        this.id_grup=0;
        this.nume_grup="";
    }

   public GrupCercetare(int id,String nume){
        id_grup=id;
        nume_grup=nume;
    }

    //set and get
    public void setId_grup(int id){
           //setez id-ul doar daca nu este deja setat, altfel arunc o exceptie
           if(this.id_grup>0){
               System.out.println("Id-ul deja exista"+ " "+id_grup);
    }
           else{
        this.id_grup=id;
    }
    }

    public int getId_grup(){ return this.id_grup; }
    public String getNume_grup(){ return this.nume_grup;}
    public void setNume_grup(String nume){this.nume_grup=nume;}

    @Override
    public  String toString(){ return id_grup+" "+nume_grup; }
    public boolean equals(Object obj){
        //compar doua grupuri de cercetare
        if(!(obj instanceof GrupCercetare))
            return false;
        GrupCercetare p=(GrupCercetare) obj;
        return(id_grup==p.id_grup)&&(nume_grup.equals(p.nume_grup));
    }



}
