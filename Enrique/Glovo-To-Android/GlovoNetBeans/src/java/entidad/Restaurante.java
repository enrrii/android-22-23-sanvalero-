/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author S2-PC00
 */
public class Restaurante {

    private int ID_RESTAURANTE;

    private String NOMBRE;

    private String TIPO;

    private int VENTAS;

    private int PUNTUACION;

    private String IMAGEN;

    public Restaurante(int id, String nombre, String tipo, int ventas, int puntuacion, String imagen) {
        this.ID_RESTAURANTE = id;
        this.NOMBRE = nombre;
        this.TIPO = tipo;
        this.VENTAS = ventas;
        this.PUNTUACION = puntuacion;
        this.IMAGEN = imagen;
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

    public static String fromArrayListToJson(ArrayList<Restaurante> lstRestaurantes) {
        String resp = "[";
        for (Restaurante restaurante : lstRestaurantes) {
            resp += "{"
                    + "\"ID_RESTAURANTE\":\"" + restaurante.getID_RESTAURANTE() + "\", "
                    + "\"NOMBRE\":\"" + restaurante.getNOMBRE() + "\","
                    + "\"TIPO\":\"" + restaurante.getTIPO() + "\", "
                    + "\"VENTAS\":\"" + restaurante.getVENTAS() + "\", "
                    + "\"PUNTUACION\":\"" + restaurante.getPUNTUACION() + "\","
                    + "\"IMAGEN\":\"" + restaurante.getIMAGEN() + "\"}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }

    public static String fromArrayListToJsonOnly(Restaurante restaurante) {
        String resp = "[";
        resp += "{"
                + "\"ID_RESTAURANTE\":\"" + restaurante.getID_RESTAURANTE() + "\", "
                + "\"NOMBRE\":\"" + restaurante.getNOMBRE() + "\","
                + "\"TIPO\":\"" + restaurante.getTIPO() + "\", "
                + "\"VENTAS\":\"" + restaurante.getVENTAS() + "\", "
                + "\"PUNTUACION\":\"" + restaurante.getPUNTUACION() + "\","
                + "\"IMAGEN\":\"" + restaurante.getIMAGEN() + "\"}";
        resp += "]";
        return resp;
    }
}
