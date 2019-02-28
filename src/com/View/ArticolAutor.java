package com.View;

import Domain.ArticolStiintific;

public class ArticolAutor {
    String nume;
    protected String type;
    protected   int indentificare_lucrareStiintifica;
    int numar;

    //de ce tip e, conferinta sau revista

    public ArticolAutor (){
        nume="";
        type="";
    }
    public ArticolAutor(ArticolStiintific articolStiintific, String nume){
        this.type=articolStiintific.getType();
        this.indentificare_lucrareStiintifica=articolStiintific.getIndentificare_lucrareStiintifica();
        this.nume=nume;
        this.numar=articolStiintific.getNumar();
    }

    public String getNume() {
        return nume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setIndentificare_lucrareStiintifica(int indentificare_lucrareStiintifica) {
        this.indentificare_lucrareStiintifica = indentificare_lucrareStiintifica;
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
}
