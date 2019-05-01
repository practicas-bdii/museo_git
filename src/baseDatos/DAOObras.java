/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Antiguidade;
import aplicacion.Autor;
import aplicacion.Escultura;
import aplicacion.Obra;
import aplicacion.Pintura;
import aplicacion.TipoEstado;
import java.sql.*;
import java.util.ArrayList;
import aplicacion.Suministrador;
import aplicacion.TipoAdquisicion;

/**
 *
 * @author sergio_buzzoni
 */
public class DAOObras extends AbstractDAO {

    public DAOObras(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Obra> consultarCatalogo(Integer codigo, String titulo, Integer ano, String autor, String sala, String tipo) {
        java.util.List<Obra> resultado = new java.util.ArrayList<>(); //lista devuelta
        java.util.List<Autor> autoresTmp = null; //autor temporal para añadirle a la obra actual
        String compruebaNulo = null;
        Connection con;
        PreparedStatement stmObras = null; //statement para consultar todas las obras
        ResultSet rsObras;

        con = this.getConexion();

        String subConsulta = "(SELECT o.*, autor, 'pintura' as tipo"
                + " FROM obras as o JOIN pinturas as p ON (o.codigo = p.obra) LEFT JOIN autor_crea_obra as aco ON (o.codigo = aco.obra)"
                + " UNION"
                + " SELECT o.*, autor, 'escultura' as tipo"
                + " FROM obras as o JOIN esculturas as e ON (o.codigo = e.obra) LEFT JOIN autor_crea_obra as aco ON (o.codigo = aco.obra)"
                + " UNION"
                + " SELECT o.*, autor, 'antiguidade' as tipo"
                + " FROM obras as o JOIN antiguidades as a ON (o.codigo = a.obra) LEFT JOIN autor_crea_obra as aco ON (o.codigo = aco.obra)"
                + " ) as subquery";

        String consulta = "SELECT *"
                + " FROM " + subConsulta
                + " WHERE titulo LIKE ? AND tipo = ?";

        if (codigo != null) {
            consulta = consulta + " AND subquery.codigo = " + codigo.toString();
        }

        if (ano != null) {
            consulta = consulta + " AND subquery.ano = " + ano.toString();
        }

        if (!autor.isEmpty()) {
            consulta = consulta + " AND autor LIKE ? ";
        }

        if (sala != null) {
            consulta = consulta + " AND subquery.sala = " + sala;
        }

        try { //se ejecuta la sentencia
            stmObras = con.prepareStatement(consulta);
            stmObras.setString(1, "%" + titulo + "%");
            stmObras.setString(2, tipo);
            if (!autor.isEmpty()) {
                stmObras.setString(3, "%" + autor + "%");
            }
            System.out.println(stmObras.toString());
            rsObras = stmObras.executeQuery();

            while (rsObras.next()) {
                if (rsObras.getString("tipo").equals("pintura")) {
                    Pintura pinturaTmp;
                    PreparedStatement stmPinturas = null;
                    ResultSet rsPinturas;

                    compruebaNulo = rsObras.getString("autor");
                    if (!rsObras.wasNull()) {
                        autoresTmp = this.consultarAutores(rsObras.getString("autor"));
                    }
                    stmPinturas = con.prepareStatement("SELECT *"
                            + " FROM pinturas"
                            + " WHERE obra = " + rsObras.getInt("codigo"));

                    rsPinturas = stmPinturas.executeQuery();

                    while (rsPinturas.next()) {
                        pinturaTmp = new Pintura(rsPinturas.getString("tecnica"), rsPinturas.getInt("obra"),
                                rsObras.getString("titulo"), rsObras.getInt("ano"),
                                rsObras.getInt("sala"), autoresTmp);

                        resultado.add(pinturaTmp);
                    }
                } else if (rsObras.getString("tipo").equals("escultura")) {
                    Escultura esculturaTmp;
                    PreparedStatement stmEsculturas = null;
                    ResultSet rsEsculturas;

                    compruebaNulo = rsObras.getString("autor");
                    if (!rsObras.wasNull()) {
                        autoresTmp = this.consultarAutores(rsObras.getString("autor"));
                    }
                    stmEsculturas = con.prepareStatement("SELECT *"
                            + " FROM esculturas"
                            + " WHERE obra = " + rsObras.getInt("codigo"));

                    rsEsculturas = stmEsculturas.executeQuery();
                    while (rsEsculturas.next()) {
                        esculturaTmp = new Escultura(rsEsculturas.getString("material"), rsEsculturas.getInt("obra"),
                                rsObras.getString("titulo"), rsObras.getInt("ano"),
                                rsObras.getInt("sala"), autoresTmp);

                        resultado.add(esculturaTmp);
                    }

                } else {
                    Antiguidade antiguidadeTmp;
                    PreparedStatement stmAntiguidades = null;
                    ResultSet rsAntiguidades;

                    compruebaNulo = rsObras.getString("autor");
                    if (!rsObras.wasNull()) {
                        autoresTmp = this.consultarAutores(rsObras.getString("autor"));
                    } else {
                        autoresTmp = null;
                    }
                    stmAntiguidades = con.prepareStatement("SELECT *"
                            + " FROM antiguidades"
                            + " WHERE obra = " + rsObras.getInt("codigo"));

                    rsAntiguidades = stmAntiguidades.executeQuery();

                    while (rsAntiguidades.next()) {
                        antiguidadeTmp = new Antiguidade(TipoEstado.valueOf(rsAntiguidades.getString("estado")), rsAntiguidades.getInt("num_restauraciones"),
                                rsObras.getInt("codigo"), rsObras.getString("titulo"), rsObras.getInt("ano"),
                                rsObras.getInt("sala"), autoresTmp);

                        resultado.add(antiguidadeTmp);
                    }

                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmObras.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Obra> consultarObras() {
        java.util.List<Obra> resultado = new java.util.ArrayList<Obra>(); //lista devuelta
        java.util.List<Autor> autoresTmp = null; //autor temporal para añadirle a la obra actualh
        String compruebaNulo = null;
        Connection con;
        PreparedStatement stmObras = null; //statement para consultar todas las obras
        ResultSet rsObras;

        con = this.getConexion();

        String subConsulta = "(SELECT o.*, autor, 'pintura' as tipo"
                + " FROM obras as o JOIN pinturas as p ON (o.codigo = p.obra) LEFT JOIN autor_crea_obra as aco ON (o.codigo = aco.obra)"
                + " UNION"
                + " SELECT o.*, autor, 'escultura' as tipo"
                + " FROM obras as o JOIN esculturas as e ON (o.codigo = e.obra) LEFT JOIN autor_crea_obra as aco ON (o.codigo = aco.obra)"
                + " UNION"
                + " SELECT o.*, autor, 'antiguidade' as tipo"
                + " FROM obras as o JOIN antiguidades as a ON (o.codigo = a.obra) LEFT JOIN autor_crea_obra as aco ON (o.codigo = aco.obra)"
                + " ) as subquery";

        String consulta = "SELECT *"
                + " FROM " + subConsulta;

        try { //se ejecuta la sentencia
            stmObras = con.prepareStatement(consulta);
            rsObras = stmObras.executeQuery();

            while (rsObras.next()) {
                if (rsObras.getString("tipo").equals("pintura")) {
                    Pintura pinturaTmp;
                    PreparedStatement stmPinturas;
                    ResultSet rsPinturas;

                    compruebaNulo = rsObras.getString("autor");
                    if (!rsObras.wasNull()) {
                        autoresTmp = this.consultarAutores(rsObras.getString("autor"));
                    }
                    stmPinturas = con.prepareStatement("SELECT *"
                            + " FROM pinturas"
                            + " WHERE obra = " + rsObras.getInt("codigo"));

                    rsPinturas = stmPinturas.executeQuery();
                    pinturaTmp = new Pintura(rsPinturas.getString("tecnica"), rsPinturas.getInt("obra"),
                            rsObras.getString("titulo"), rsObras.getInt("ano"),
                            rsObras.getInt("sala"), autoresTmp);

                    resultado.add(pinturaTmp);
                } else if (rsObras.getString("tipo").equals("escultura")) {
                    Escultura esculturaTmp;
                    PreparedStatement stmEsculturas;
                    ResultSet rsEsculturas;

                    compruebaNulo = rsObras.getString("autor");
                    if (!rsObras.wasNull()) {
                        autoresTmp = this.consultarAutores(rsObras.getString("autor"));
                    }
                    stmEsculturas = con.prepareStatement("SELECT *"
                            + " FROM esculturas"
                            + " WHERE obra = " + rsObras.getInt("codigo"));

                    rsEsculturas = stmEsculturas.executeQuery();
                    esculturaTmp = new Escultura(rsEsculturas.getString("material"), rsEsculturas.getInt("obra"),
                            rsObras.getString("titulo"), rsObras.getInt("ano"),
                            rsObras.getInt("sala"), autoresTmp);

                    resultado.add(esculturaTmp);
                } else {
                    Antiguidade antiguidadeTmp;
                    PreparedStatement stmAntiguidades;
                    ResultSet rsAntiguidades;

                    compruebaNulo = rsObras.getString("autor");
                    if (!rsObras.wasNull()) {
                        autoresTmp = this.consultarAutores(rsObras.getString("autor"));
                    }
                    stmAntiguidades = con.prepareStatement("SELECT *"
                            + " FROM antiguidades"
                            + " WHERE obra = " + rsObras.getInt("codigo"));

                    rsAntiguidades = stmAntiguidades.executeQuery();
                    antiguidadeTmp = new Antiguidade(TipoEstado.valueOf(rsAntiguidades.getString("estado")), rsAntiguidades.getInt("num_restauraciones"),
                            rsAntiguidades.getInt("codigo"), rsObras.getString("titulo"), rsAntiguidades.getInt("ano"),
                            rsObras.getInt("sala"), autoresTmp);

                    resultado.add(antiguidadeTmp);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmObras.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public void insertarObra(Obra o){
        Connection con;
        PreparedStatement stmObra = null;
    
        con = this.getConexion();
        
        try{
            
            stmObra=con.prepareStatement("insert into obras"+
                                         "values (?,?,?,?)");
            stmObra.setInt(1, o.getCodigo());
            stmObra.setString(2, o.getTitulo());
            stmObra.setInt(3, o.getAno());
            stmObra.setInt(4, o.getSala());
            stmObra.executeUpdate();
            
                    
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmObra.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void insertarAutcObra(Autor a, Obra o){
        Connection con;
        PreparedStatement stmAutcObra = null;
    
        con = this.getConexion();
        
        try{
            
            stmAutcObra=con.prepareStatement("insert into autor_crea_obra"+
                                            "values (?,?)");
            stmAutcObra.setString(1, a.getNombre());
            stmAutcObra.setInt(2, o.getCodigo());
            stmAutcObra.executeUpdate();
            
                    
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmAutcObra.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void insertarAdquisicion(Integer obra, Suministrador sumin, TipoAdquisicion tipo, String fecha, Float precio){
        Connection con;
        PreparedStatement stmAutcObra = null;
    
        con = this.getConexion();
        
        try{
            
            stmAutcObra=con.prepareStatement("insert into adquisicions"+
                                            "values (?,?,?,?,?)");
            stmAutcObra.setInt(1, obra);
            stmAutcObra.setString(2, sumin.getCIF());
            stmAutcObra.setString(3, tipo.toString());
            //stmAutcObra.setString(2, fecha);
            stmAutcObra.setFloat(5, precio);
            stmAutcObra.executeUpdate();
            
                    
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmAutcObra.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    public java.util.List<Autor> consultarAutores(String nome) {
        java.util.List<Autor> resultado = new ArrayList<>();
        Connection con;
        Autor autorTmp = null;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores = null;

        con = this.getConexion();

        System.out.println("nombre del autor buscado: " + nome);
        try {
            stmAutores = con.prepareStatement("SELECT *"
                    + " FROM autores"
                    + " WHERE nome = " + "'" + nome + "'");

            System.out.println(stmAutores.toString());
            rsAutores = stmAutores.executeQuery();

            while (rsAutores.next()) {
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
}
