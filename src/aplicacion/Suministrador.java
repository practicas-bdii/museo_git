package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Suministrador {
    private String CIF;
    private String nombre;
    private String pais;
    private TipoSuministrador tipo;

    public Suministrador(String CIF, String nombre, String pais, TipoSuministrador tipo) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.pais = pais;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public TipoSuministrador getTipo() {
        return tipo;
    }

    public String getCIF() {
        return CIF;
    }
    

    

   
   

  
   
   
}
