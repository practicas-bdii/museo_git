/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Autor;
import java.sql.*;

/**
 *
 * @author alumnogreibd
 */
public class DAOAutores extends AbstractDAO {

    public DAOAutores(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Autor> consultarAutores() {
        java.util.List<Autor> resultado = new java.util.ArrayList<Autor>();
        Autor autorActual;
        Connection con;
        PreparedStatement stmCategorias = null;
        ResultSet rsAutores;

        con = this.getConexion();

        try {
            stmCategorias = con.prepareStatement("select nome from autores");
            rsAutores = stmCategorias.executeQuery();
            while (rsAutores.next()) {
                autorActual = new Autor(rsAutores.getString("nome"), rsAutores.getDate("fecha_nac"), rsAutores.getDate("fecha_fal"));
                resultado.add(autorActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategorias.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

}
