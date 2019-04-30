/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Suministrador;
import aplicacion.TipoSuministrador;
import java.sql.*;

/**
 *
 * @author alumnogreibd
 */
public class DAOSuministradores extends AbstractDAO{
    
    public DAOSuministradores (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Suministrador> consultarSumins(String cif){
        java.util.List<Suministrador> result = new java.util.ArrayList<Suministrador>();
        Suministrador subActual;
        Connection con;
        PreparedStatement stmSumin=null;
        ResultSet rsSumin;
        
        con = this.getConexion();
        
        String consulta = "Select *" +
                            "from subministradores";
                            //"where cif = ?";
        
        try{
            stmSumin=con.prepareStatement(consulta);
            //stmSumin.setString(1, cif);
            
            rsSumin=stmSumin.executeQuery();
        while(rsSumin.next())
        {
            subActual = new Suministrador(rsSumin.getString("cif"), rsSumin.getString("pais"),
                                            rsSumin.getString("nome"), TipoSuministrador.valueOf(rsSumin.getString("tipo")));
            
            result.add(subActual);
            
        }
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
          try {stmSumin.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return result;
    }
    
    public void actualizarSuministrador(String cif, Suministrador s){
        Connection con;
        PreparedStatement stmSumin = null;
        
        con = this.getConexion();
        
        try {
            stmSumin = con.prepareStatement("update subministradores "+
                                            "set cif=?, "+
                                            "    pais=?, "+
                                            "    nome=?, "+
                                            "    tipo=?, "+
                                            "    where id_usuario=?");
            stmSumin.setString(1, s.getCIF());
            stmSumin.setString(2, s.getPais());
            stmSumin.setString(3, s.getNombre());
            stmSumin.setString(4, s.getTipo().name());
            stmSumin.setString(5, cif);
            stmSumin.executeUpdate();
            
            
            
            } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmSumin.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
          
        }
    }
    
    
    public void insertarSuministrador(Suministrador s){
        Connection con;
        PreparedStatement stmSumin = null;
    
        con = this.getConexion();
        
        try{
            
            stmSumin=con.prepareStatement("insert into subministradores (cif, pais, nome, tipo)"+
                                                    "values (?,?,?,?)");
            stmSumin.setString(1, s.getCIF());
            stmSumin.setString(2, s.getPais());
            stmSumin.setString(3, s.getNombre());
            stmSumin.setObject(4, s.getTipo().name());
            stmSumin.executeUpdate();
            
                    
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmSumin.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void borrarSuministrador(String cif){
        Connection con;
        PreparedStatement stmSumin = null;
        
        con = this.getConexion();
        
        try{
            stmSumin = con.prepareStatement("delete from subministradores where cif = ?");
                    stmSumin.setString(1, cif);
                    stmSumin.executeUpdate();
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmSumin.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
          
        }
        
    }
    
}
