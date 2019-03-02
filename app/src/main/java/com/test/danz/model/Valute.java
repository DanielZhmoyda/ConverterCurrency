package com.test.danz.model;

import com.google.gson.annotations.SerializedName;

public class Valute {

    @SerializedName("AUD")
    private Aud aud;
    @SerializedName("AZN")
    private Azn azn;
    @SerializedName("USD")
    private Usd usd;
    @SerializedName("EUR")
    private Eur eur;
    @SerializedName("CAD")
    private Cad cad;
    @SerializedName("UAH")
    private Uah uah;
    @SerializedName("CZK")
    private Czk czk;
    @SerializedName("JPY")
    private Jpy jpy;
    @SerializedName("UZS")
    private Uzs uzs;
    @SerializedName("RON")
    private Ron ron;

    public Aud getAud() {
        return aud;
    }

    public void setAud(Aud aud) {
        this.aud = aud;
    }

    public Azn getAzn() {
        return azn;
    }

    public void setAzn(Azn azn) {
        this.azn = azn;
    }

    public Usd getUsd() {
        return usd;
    }

    public void setUsd(Usd usd) {
        this.usd = usd;
    }

    public Eur getEur() {
        return eur;
    }

    public void setEur(Eur eur) {
        this.eur = eur;
    }

    public Cad getCad() {
        return cad;
    }

    public void setCad(Cad cad) {
        this.cad = cad;
    }

    public Uah getUah() {
        return uah;
    }

    public void setUah(Uah uah) {
        this.uah = uah;
    }

    public Czk getCzk() {
        return czk;
    }

    public void setCzk(Czk czk) {
        this.czk = czk;
    }

    public Jpy getJpy() {
        return jpy;
    }

    public void setJpy(Jpy jpy) {
        this.jpy = jpy;
    }

    public Uzs getUzs() {
        return uzs;
    }

    public void setUzs(Uzs uzs) {
        this.uzs = uzs;
    }

    public Ron getRon() {
        return ron;
    }

    public void setRon(Ron ron) {
        this.ron = ron;
    }

    public class Aud {

        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public class Azn {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public class Usd {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public class Eur {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public class Cad {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public class Ron {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public class Uzs {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public class Uah {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public class Czk{
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public class Krw {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public class Jpy {
        @SerializedName("ID")
        private String id;
        @SerializedName("NumCode")
        private String numCode;
        @SerializedName("CharCode")
        private String charCode;
        @SerializedName("Nominal")
        private int nominal;
        @SerializedName("Name")
        private String name;
        @SerializedName("Value")
        private double value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
