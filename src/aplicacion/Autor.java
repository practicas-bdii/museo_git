package aplicacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author basesdatos
 */
public class Autor {

    private String nombre;
    private Date fechaNacemento;
    private Date fechaFalecemento;
    private final DateFormat dateFormat;

    public Autor(String nombre, Date fechaNacemento, Date fechaFalecemento) {
        this.nombre = nombre;
        this.fechaNacemento = fechaNacemento;
        this.fechaFalecemento = fechaFalecemento;
        this.dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacemento() {
        return fechaNacemento;
    }

    public String getFechaNacementoString(){
        if (this.fechaNacemento != null) {
            return this.dateFormat.format(this.fechaNacemento);
        } else {
            return "";
        }
    }
    
    public Date getFechaFalecemento() {
        return fechaFalecemento;
    }

    public String getFechaFalecementoString(){
        if (this.fechaFalecemento != null) {
            return this.dateFormat.format(this.fechaFalecemento);
        } else {
            return "";
        }
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setFechaNacemento(String fechaNacemento) throws ParseException {
        this.fechaNacemento = this.dateFormat.parse(fechaNacemento);
    }
    
    public void setFechaFalecemento(String fechaFalecemento) throws ParseException {
        this.fechaFalecemento = this.dateFormat.parse(fechaFalecemento);
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }

}
