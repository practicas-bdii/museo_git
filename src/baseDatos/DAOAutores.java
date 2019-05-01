/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Autor;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author alumnogreibd
 */
public class DAOAutores extends AbstractDAO {

    public DAOAutores(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Autor> consultarAutores(String nome) {
        java.util.List<Autor> resultado = new java.util.ArrayList<Autor>();
        Autor autorTmp;
        Connection con;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores;

        con = this.getConexion();

        try  {
        stmAutores=con.prepareStatement("select * from autores where nome like ?");
        stmAutores.setString(1, "%"+nome+"%");
        rsAutores = stmAutores.executeQuery();
        while (rsAutores.next())
        {

            autorTmp = new Autor(rsAutores.getString("nome"), rsAutores.getDate("fecha_nac"), rsAutores.getDate("fecha_fal"));
            resultado.add(autorTmp);
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAutores.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Autor> consultarAutoresLista() {
        java.util.List<Autor> resultado = new java.util.ArrayList<Autor>();
        Autor autorActual;
        Connection con;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores;

        con = this.getConexion();

        try  {
        stmAutores=con.prepareStatement("select * from autores");
        rsAutores = stmAutores.executeQuery();
        while (rsAutores.next())
        {

            autorActual = new Autor(rsAutores.getString("nome"), rsAutores.getDate("fecha_nac"), rsAutores.getDate("fecha_fal"));
            resultado.add(autorActual);
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAutores.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public void actualizarAutor(String nome, Autor a){
        Connection con;
        PreparedStatement stmAutor = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        con = this.getConexion();
        
        try {
            stmAutor = con.prepareStatement("update autores "+
                                            "set nome = ?, "+
                                            "    fecha_nac = ?, "+
                                            "    fecha_fal= ?, " +
                                            "    where nome = ?");
            stmAutor.setString(1, a.getNombre());
            stmAutor.setString(2, sdf.format(a.getFechaNacemento()));
            stmAutor.setString(3, sdf.format(a.getFechaFalecemento()));
            stmAutor.setString(4, nome);
            stmAutor.executeUpdate();
            
            
            
            } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAutor.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
          
        }
    }
    
    public void insertarAutor(Autor a){
        Connection con;
        PreparedStatement stmAutor = null;
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);
    
        con = this.getConexion();
        
        try{
            
            stmAutor=con.prepareStatement("insert into autores"+
                                         "values (?,?,?)");
            stmAutor.setString(1, a.getNombre());
          //  stmAutor.setString(2, (Date) a.getFechaNacemento());
           // stmAutor.setString(3, 0);
            stmAutor.executeUpdate();
            
                    
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmAutor.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void borrarAutor(String nome){
        Connection con;
        PreparedStatement stmAutor = null;
        
        con = this.getConexion();
        
        try{
            stmAutor = con.prepareStatement("delete from autores where nome = ?");
                    stmAutor.setString(1, nome);
                    stmAutor.executeUpdate();
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAutor.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
          
        }
        
    }
}
