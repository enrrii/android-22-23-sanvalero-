/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author S1-PC64
 */
public class Plato {
    
    private int id_plato;
    private int id_restaurante;
    private String nombre;
    private String descripcion;
    private String ingredientes;
    private int precio;
    private String imagen;

    public Plato() {

    }

    public Plato(int id_plato, int id_restaurante, String descripcion, int precio, String nombre, String ingredientes, String imagen) {
        this.id_plato = id_plato;
        this.id_restaurante = id_restaurante;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.imagen = imagen;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
   public static String fromArrayListToJson(ArrayList<Plato> lstCarta) {
        String resp = "[";
        for (Plato carta : lstCarta) {
            resp += "{"
                    + "\"ID_PLATO\":\"" + carta.getId_plato()+ "\", "
                    + "\"ID_RESTAURANTE\":\"" + carta.getId_restaurante()+ "\","
                    + "\"DESCRIPCION\":\"" + carta.getDescripcion()+ "\","
                    + "\"NOMBRE\":\"" + carta.getNombre()+ "\", "
                    + "\"PRECIO\":\"" + carta.getPrecio()+ "\", "
                    + "\"INGREDIENTES\":\"" + carta.getIngredientes() + "\","
                    + "\"IMAGEN\":\"" + carta.getImagen()+ "\"}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }
}
