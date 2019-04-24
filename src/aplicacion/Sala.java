package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Sala {
    private Integer numSala;
    private float superficie;
    private Integer piso;

   
   public Sala (Integer numSala, float superficie, Integer piso){
    this.numSala=numSala;
    this.superficie=superficie;
    this.piso=piso;
   }

    public Integer getNumSala() {
        return numSala;
    }

    public float getSuperficie() {
        return superficie;
    }

    public Integer getPiso() {
        return piso;
    }

  
   
   
}
