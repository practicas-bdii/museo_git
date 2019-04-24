package aplicacion;

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

    public Autor(String nombre, Date fechaNacemento, Date fechaFalecemento) {
        this.nombre = nombre;
        this.fechaNacemento = fechaNacemento;
        this.fechaFalecemento = fechaFalecemento;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacemento() {
        return fechaNacemento;
    }

    public Date getFechaFalecemento() {
        return fechaFalecemento;
    }

}
