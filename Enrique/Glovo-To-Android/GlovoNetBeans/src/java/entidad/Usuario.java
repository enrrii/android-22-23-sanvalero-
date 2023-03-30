/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class Usuario {

    /*@SerializedName("nombre")
    private String nombre;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
     */
    private int idUser;
    private String nombre;
    private String email;
    private String password;

    public Usuario() {

    }

    public Usuario(int idUser,String nommbre, String email, String password) {
        this.idUser = idUser;
        this.nombre = nommbre;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nommbre) {
        this.nombre = nommbre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public static String fromArrayListToJson(ArrayList<Usuario> lstUsuarios) {
        String resp = "[";
        for (Usuario user : lstUsuarios) {
            resp += "{"
                    + "\"ID_USER\":\"" + user.getIdUser() + "\","
                    + "\"NOMBRE\":\"" + user.getNombre() + "\","
                    + "\"PASSWORD\":\"" + user.getPassword() + "\", "
                    + "\"EMAIL\":\"" + user.getEmail() + "\"}";
            resp += ",";

        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }
}
