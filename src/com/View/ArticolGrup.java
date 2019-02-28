package com.View;

import Domain.ArticolStiintific;

public class ArticolGrup {
    int nr_grupa=0;
    protected String type;
    protected   int indentificare_lucrareStiintifica;
    int numar;

   //de ce tip e, conferinta sau revista

    public ArticolGrup (){
        this.nr_grupa=0;
        type="";
    }
    public ArticolGrup(ArticolStiintific articolStiintific,int nr_grupa){
        this.type=articolStiintific.getType();
        this.indentificare_lucrareStiintifica=articolStiintific.getIndentificare_lucrareStiintifica();
        this.nr_grupa=nr_grupa;
        this.numar=articolStiintific.getNumar();
    }

    public void setNr_grupa(int nr_grupa) {
        this.nr_grupa = nr_grupa;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNr_grupa() {
        return nr_grupa;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public void setIndentificare_lucrareStiintifica(int indentificare_lucrareStiintifica) {
        this.indentificare_lucrareStiintifica = indentificare_lucrareStiintifica;
    }

    public String getType() {
        return type;
    }

    public int getIndentificare_lucrareStiintifica() {
        return indentificare_lucrareStiintifica;
    }

}
