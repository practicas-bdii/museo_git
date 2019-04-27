
package baseDatos;
import aplicacion.Antiguidade;
import aplicacion.AntiguidadeSimplif;
import aplicacion.Obra;
import aplicacion.TipoEstado;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import static aplicacion.TipoUsuario.Restaurador;
import java.sql.*;
import java.time.LocalDateTime;
/**
 *
 * @author basesdatos
 */
public class DAORestauracion extends AbstractDAO {

   public DAORestauracion (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

   public boolean existeRestauracion(Integer codObra){
       Connection con;
       PreparedStatement stmUsuario=null;
       con=super.getConexion();
       ResultSet rsListaUsuarios;
        try {
        stmUsuario=con.prepareStatement("select * from restauracions "+
                                      " where antiguidade=? ");
        stmUsuario.setInt(1, codObra);
        rsListaUsuarios=stmUsuario.executeQuery();
        if (rsListaUsuarios.next()){
            return true;
        } 
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return false;
   }
   public void realizarRestauracion(Integer codObra, String codTraballador){
      Connection con;
      PreparedStatement stmRestauracion=null;

        con=super.getConexion();
        Date date= new Date(1999-04-07);
        try {
        stmRestauracion=con.prepareStatement("insert into restauracions(antiguidade, traballador, fecha_ini, fecha_fin) "+
                                      " values (?,?,?,?)");
       // stmUsuario.setString(1, usuario.getIdUsuario());
        stmRestauracion.setInt(1, codObra);
        stmRestauracion.setString(2, codTraballador);
        stmRestauracion.setDate(3, date);
        stmRestauracion.setDate(4, null);
       
        stmRestauracion.executeUpdate();
  
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestauracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
   }
   public void eliminarRestauracion(int codObra){
     Connection con;
        PreparedStatement stmRestauracion=null;

        con=super.getConexion();

        try {
        stmRestauracion=con.prepareStatement("delete from restauracion where antiguidade = ?");
        stmRestauracion.setInt(1, codObra);
        stmRestauracion.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestauracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
   }
    public java.util.List<AntiguidadeSimplif> obtenerObras(String Restaurador) {
        System.out.println("obtener obras dao");
        java.util.List<AntiguidadeSimplif> resultado = new java.util.ArrayList<AntiguidadeSimplif>();
        Connection con;
        //Obtener Nombre(titulo) de la obra, Estado, Fecha de Inicio, Fecha de Fin
        PreparedStatement stmListaObras=null;
        ResultSet rsListaObras;
        
        con=this.getConexion();
        System.out.println("entramos en operacion dao bien");
       /* String consulta = "select a.estado, a.numrestauraciones, o.titulo, r.fecha_ini, r.fecha_fin" +
                                         " from antiguidades a join obras o on a.obra=o.codigo"+
                                         " join restauracion r on r.antiguidade=a.obra"+
                                         " where r.traballador = ?";*/
     
        try {
            stmListaObras=con.prepareStatement("select estado, num_restauraciones, titulo, fecha_ini, fecha_fin, codigo" +
                                         " from antiguidades a join obras o on a.obra=o.codigo"+
                                         " join restauracions r on r.antiguidade=a.obra"+
                                         " where r.traballador = ?");
            stmListaObras.setString(1, Restaurador);
            rsListaObras=stmListaObras.executeQuery();
         while (rsListaObras.next()){
             //System.out.println("restauracion=> "+ rsListaObras.getString("o.titulo"));
             //AntiguidadeSimplif(TipoEstado estado, Integer num_restauracion, String nombre, Date f_ini, Date f_fin)
             //TipoUsuario.valueOf(rsListaUsuarios.getString("tipo_usuario"))
             AntiguidadeSimplif antig = new AntiguidadeSimplif(TipoEstado.valueOf(rsListaObras.getString("estado")), rsListaObras.getInt("num_restauraciones"),
                     rsListaObras.getString("titulo"), rsListaObras.getDate("fecha_ini"), rsListaObras.getDate("fecha_fin"), rsListaObras.getInt("codigo"));
             //        rsListaObras.getString("telefono"), rsListaObras.getBoolean("e_administrador"));
             resultado.add(antig);
         }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmListaObras.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }     
        return resultado;
    }
    
     public java.util.List<AntiguidadeSimplif> obtenerDemasObras(String Titulo) {
        java.util.List<AntiguidadeSimplif> resultado = new java.util.ArrayList<AntiguidadeSimplif>();
        Connection con;
        //Obtener Nombre(titulo), Estado y Codigo
        PreparedStatement stmListaObras=null;
        ResultSet rsListaObras;
        
        con=this.getConexion();
        
        String consulta = "select o.titulo, a.estado, o.codigo"+
                          " from antiguidades a join obras o on a.obra=o.codigo"+
                          " where o.titulo = ?";
     
        try {
         stmListaObras=con.prepareStatement(consulta);
         stmListaObras.setString(1, Titulo);;
         rsListaObras=stmListaObras.executeQuery();
         while (rsListaObras.next()){
             //AntiguidadeSimplif(TipoEstado estado, String nombre, Integer codigo)
             AntiguidadeSimplif antig = new AntiguidadeSimplif(TipoEstado.valueOf(rsListaObras.getString("a.estado")),
                     rsListaObras.getString("o.titulo"), rsListaObras.getInt("o.codigo"));
             resultado.add(antig);
         }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmListaObras.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }     
        return resultado;
    }
 public java.util.List<AntiguidadeSimplif> obtenerTodasObras() {
     java.util.List<AntiguidadeSimplif> resultado = new java.util.ArrayList<AntiguidadeSimplif>();
        Connection con;
        //Obtener Nombre(titulo), Estado y Codigo
        PreparedStatement stmListaObras=null;
        ResultSet rsListaObras;
        
        con=this.getConexion();
        
        String consulta = "select titulo, estado, codigo"+
                          " from antiguidades a join obras o on a.obra=o.codigo";
     
        try {
         stmListaObras=con.prepareStatement(consulta);
         rsListaObras=stmListaObras.executeQuery();
         while (rsListaObras.next()){
             //AntiguidadeSimplif(TipoEstado estado, String nombre, Integer codigo)
             AntiguidadeSimplif antig = new AntiguidadeSimplif(TipoEstado.valueOf(rsListaObras.getString("estado")),
                     rsListaObras.getString("titulo"), rsListaObras.getInt("codigo"));
             resultado.add(antig);
         }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmListaObras.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }     
        return resultado;
     
 }
public void finalizaRestauracion(Integer CodObra, String Restaurador){
    System.out.println("finalizar restauracion");
        Connection con;
        PreparedStatement stmUsuario=null;
        Date date;
       date = new Date(2000-04-07);
        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("update restauracions "+
                                    "set fecha_fin=?"+
                                    "where traballador=? and antiguidade=?");
        stmUsuario.setDate(1, date);//poner fecha actual
        stmUsuario.setString(2, Restaurador);
        stmUsuario.setInt(3, CodObra);
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
}
