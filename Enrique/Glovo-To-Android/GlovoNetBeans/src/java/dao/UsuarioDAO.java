/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Usuario;
import interfacesDAO.IDAO;
import interfacesDAO.SQLTools;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import motores.MotorMySQL;

/**
 *
 * @author alber
 */
public class UsuarioDAO implements IDAO<Usuario, Integer> {

    private SQLTools miMotor = null;

    private final String SQL_USER = "INSERT INTO usuario SET ";
    private final String SQL_FINDALL = "SELECT * FROM `usuario` WHERE 1=1 ";
    private static final String SELECT_LOGIN_INICIO = "SELECT * FROM `usuario` WHERE ";

    public UsuarioDAO() {
        this.miMotor = new MotorMySQL();
    }

    @Override
    public int add(Usuario bean) {
        //Usuario usuario = new Usuario();
        String sql = SQL_USER;
        int filas = 0;
        miMotor.connect();
        if (bean != null) {
            if (bean.getNombre().length() > 0 && !bean.getNombre().equals("") && bean.getNombre() != null) {
                sql += "Nombre='" + bean.getNombre() + "'";
            }
            if (bean.getPassword().length() > 0 && !bean.getPassword().equals("") && bean.getPassword() != null) {
                sql += ",Password ='" + bean.getPassword() + "'";
            }
            if (bean.getEmail().length() > 0 && !bean.getEmail().equals("") && bean.getEmail() != null) {
                sql += ",Email='" + bean.getEmail() + "'";
            }

        }
        filas = miMotor.execute(sql);
        miMotor.disconnect();
        return filas;

        /*ResultSet rs = miMotor.
        executeQuery(sql);
        
        while (rs.next()) {
        
        usuario.setNombre(rs.getString(2));
        usuario.setEmail(rs.getString(3));
        usuario.setPassword(rs.getString(4));
        
        }*/
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario bean) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            miMotor.connect();
            if (bean != null) {
                if (bean.getNombre().length() > 0 && !bean.getNombre().equals("") && bean.getNombre() != null) {
                    sql += "AND Nombre='" + bean.getNombre() + "'";
                }
                if (bean.getEmail().length() > 0 && !bean.getEmail().equals("") && bean.getEmail() != null) {
                    sql += "AND Email='" + bean.getEmail() + "'";
                }
                if (bean.getPassword().length() > 0 && !bean.getPassword().equals("") && bean.getPassword() != null) {
                    sql += "AND Password ='" + bean.getPassword() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = miMotor.executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setNombre(rs.getString(2));
                usuario.setEmail(rs.getString(3));
                usuario.setPassword(rs.getString(4));

                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            miMotor.disconnect();
        }
        return usuarios;
    }

    @Override
    public int update(Usuario bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Usuario> findOne(Usuario bean) {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = SELECT_LOGIN_INICIO;

        try {
            //1º) 
            miMotor.connect();
            if (bean != null) {
                sql += "Nombre = '" + bean.getNombre() + "'";
                sql +=  " AND password = " + bean.getPassword();

            }
            ResultSet rs = miMotor.
                    executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setNombre(rs.getString(2));
                    usuario.setEmail(rs.getString(3));
                    usuario.setPassword(rs.getString(4));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            miMotor.disconnect();
        }
        return usuarios;
    }

}
