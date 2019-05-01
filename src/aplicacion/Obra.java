package aplicacion;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author basesdatos
 */
public class Obra {

    private Integer codigo;
    private String titulo;
    private Integer ano;
    private String sala;
    private java.util.List<Autor> autores;

    public Obra(Integer codigo, String titulo, Integer ano, String sala, java.util.List<Autor> autores) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.sala = sala;
        this.autores = autores;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public java.util.List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(java.util.List<Autor> autores) {
        this.autores = autores;
    }

    public boolean tieneAutor() {
        return this.autores != null;
    }

}
