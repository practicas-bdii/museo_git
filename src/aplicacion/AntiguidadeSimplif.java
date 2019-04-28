/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.sql.Date;

/**
 *
 * @author alumnogreibd
 */
public class AntiguidadeSimplif {

    private TipoEstado estado;
    private String nombre;
    private Date f_ini;
    private Date f_fin;
    private Integer num_restauracion;
    private Integer codigo;

    public AntiguidadeSimplif(TipoEstado estado, Integer num_restauracion, String nombre, Date f_ini, Date f_fin, Integer codigo) {
        this.estado = estado;
        this.num_restauracion = num_restauracion;
        this.nombre = nombre;
        this.f_ini = f_ini;
        this.f_fin = f_fin;
        this.codigo = codigo;
    }

    public AntiguidadeSimplif(TipoEstado estado, String nombre, Integer codigo) {
        this.estado = estado;
        this.nombre = nombre;
        this.codigo = codigo;
    }
    

    public TipoEstado getEstado() {
        return estado;
    }

    public Integer getNum_restauracion() {
        return num_restauracion;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getF_ini() {
        return f_ini;
    }

    public Date getF_fin() {
        return f_fin;
    }

    public Integer getCodigo() {
        return codigo;
    }

    
}
