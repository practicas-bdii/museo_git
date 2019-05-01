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
public class Pintura extends Obra {

    private String tecnica;

    public Pintura(String tecnica, Integer codigo, String titulo, Integer año, Integer sala, java.util.List<Autor> autores) {
        super(codigo, titulo, año, sala, autores);
        this.tecnica = tecnica;
    }

    public String getTecnica() {
        return tecnica;
    }

}
