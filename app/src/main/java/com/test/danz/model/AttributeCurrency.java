package com.test.danz.model;

public class AttributeCurrency {

    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;



    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setNumCode(String numCode){
        this.numCode = numCode;
    }

    public String getNumCode() {
        return numCode;
    }


    public void setCharCode(String charCode){
        this.charCode = charCode;
    }

    public String getCharCode() {
        return charCode;
    }


    public void setNominal(int nominal){
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setValue(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }


}

