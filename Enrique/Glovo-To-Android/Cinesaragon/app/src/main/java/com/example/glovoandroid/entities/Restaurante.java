package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Restaurante {
    @SerializedName("ID_RESTAURANTE")
    private int ID_RESTAURANTE;

    @SerializedName("NOMBRE")
    private String NOMBRE;

    @SerializedName("TIPO")
    private String TIPO;

    @SerializedName("VENTAS")
    private int VENTAS;

    @SerializedName("PUNTUACION")
    private int PUNTUACION;

    @SerializedName("IMAGEN")
    private String IMAGEN;



    public Restaurante(int id, String nombre, String tipo, int ventas, int puntuacion, String imagen) {
        this.ID_RESTAURANTE = id;
        this.NOMBRE = nombre;
        this.TIPO = tipo;
        this.VENTAS=ventas;
        this.PUNTUACION=puntuacion;
        this.IMAGEN=imagen;
    }
    public Restaurante() {

    }

    public int getID_RESTAURANTE() {
        return ID_RESTAURANTE;
    }

    public void setID_RESTAURANTE(int ID_RESTAURANTE) {
        this.ID_RESTAURANTE = ID_RESTAURANTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public int getVENTAS() {
        return VENTAS;
    }

    public void setVENTAS(int VENTAS) {
        this.VENTAS = VENTAS;
    }

    public int getPUNTUACION() {
        return PUNTUACION;
    }

    public void setPUNTUACION(int PUNTUACION) {
        this.PUNTUACION = PUNTUACION;
    }

    public String getIMAGEN() {
        return IMAGEN;
    }

    public void setIMAGEN(String IMAGEN) {
        this.IMAGEN = IMAGEN;
    }
}
