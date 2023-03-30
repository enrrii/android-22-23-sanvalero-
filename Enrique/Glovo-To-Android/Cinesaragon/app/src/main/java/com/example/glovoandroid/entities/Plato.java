package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Plato implements java.io.Serializable{
    @SerializedName("ID_PLATO")
    private int id_plato;

    @SerializedName("ID_RESTAURANTE")
    private int id_restaurante;

    @SerializedName("DESCRIPCION")
    private String descripcion;

    @SerializedName("PRECIO")
    private int precio;

    @SerializedName("NOMBRE")
    private String nombre;

    @SerializedName("INGREDIENTES")
    private String ingredientes;

    @SerializedName("IMAGEN")
    private String imagen;

    private  int cantidad;

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
        this.cantidad = 0;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void addOne(){
        this.cantidad++;
    }
    public void removeOne(){
        this.cantidad--;
    }
}
