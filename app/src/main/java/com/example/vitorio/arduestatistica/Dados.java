package com.example.vitorio.arduestatistica;

/**
 * Created by vitorio on 30/11/17.
 */

public class Dados {
    String nameOftable,data;

    public Dados(String nameOftable, String data) {
        this.nameOftable = nameOftable;
        this.data = data;
    }
    public String toString() {
        return "Dados :: " + data;
    }

    public String getNameOftable() {
        return nameOftable;
    }

    public void setNameOftable(String nameOftable) {
        this.nameOftable = nameOftable;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
