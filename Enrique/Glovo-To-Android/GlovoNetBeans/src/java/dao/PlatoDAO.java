/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidad.Plato;
import interfacesDAO.SQLTools;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import motores.MotorMySQL;

/**
 *
 * @author S1-PC64
 */
public class PlatoDAO {
    private SQLTools miMotor = null;
    private static final String SQL_FINDCARTABYID = "SELECT * FROM `platos` WHERE id_restaurante = ";

    public PlatoDAO() {
        this.miMotor = new MotorMySQL();
    }
    
    public ArrayList<Plato> findRestaurantesVentas(Plato bean) {
        String sql_filtro = "'" +  bean.getId_restaurante() + "'";
        String sql_final = "";
        ArrayList<Plato> lstCarta = null;
        try {
            this.miMotor.connect();

            sql_final = SQL_FINDCARTABYID + bean.getId_restaurante();

            ResultSet resultset = this.miMotor.executeQuery(sql_final);

            if (resultset != null) {
                lstCarta = new ArrayList();

                while (resultset.next()) {
                    Plato entidad = new Plato();
                    entidad.setId_plato(resultset.getInt(1));
                    entidad.setId_restaurante(resultset.getInt(2));
                    entidad.setNombre(resultset.getString(3));
                    entidad.setDescripcion(resultset.getString(4));
                    entidad.setIngredientes(resultset.getString(5));
                    entidad.setPrecio(resultset.getInt(6));
                    entidad.setImagen(resultset.getString(7));
                    lstCarta.add(entidad);

                }
            }
            this.miMotor.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(RestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCarta;
    }

}
