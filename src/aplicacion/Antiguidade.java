/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Antiguidade extends Obra {

    private TipoEstado estado;
    private Integer num_restauracion;

    public Antiguidade(TipoEstado estado, Integer num_restauracion, Integer codigo, String titulo, Integer año, String sala, java.util.List<Autor> autores) {
        super(codigo, titulo, año, sala, autores);
        this.estado = estado;
        this.num_restauracion = num_restauracion;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public Integer getNum_restauracion() {
        return num_restauracion;
    }

}
