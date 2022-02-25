/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Mascota;

/**
 *
 * @author Ismael
 */
public class MascotaControlador {
    
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Statement sentencia;
    
    Mascota mascota = new Mascota();

    public MascotaControlador() {
        con.getConector();
    }
    
    public void crearMascota (Mascota m){
        try {
            String sql = "INSERT INTO Mascota (id, nombre, raza, edad, color, duenio, tamanio)"
                    + "VALUES ( "+m.getId() + ",'" +m.getNombre() + "','" +m.getRaza() + "','" +m.getEdad()+ "','" +m.getColor()+ "','" +m.getDuenio()+ "','" 
                    +m.getTamanio()+"');";
            
            sentencia= con.getConector().createStatement();
            
            if (sentencia.executeUpdate(sql) > 0) {
                System.out.println("El registro se inserto correctamente");
    
            }
            else{
            
                System.out.println("No se pudo insertar el registro");
            
            }
                           
        } catch (SQLException e) {
            
            System.out.println("Error" + " " + e);
        }
        
        System.out.println(m.toString());
        con.cerrar();
    
    }
    
    
}
