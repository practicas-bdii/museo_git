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
public class Escultura extends Obra {

    private String material;

    public Escultura(String material, Integer codigo, String titulo, Integer año, Integer sala, java.util.List<Autor> autores) {
        super(codigo, titulo, año, sala, autores);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

}
