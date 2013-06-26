package br.edu.unifil.model;

/**
 * Objeto Quarto
 * @author ThiagoAugustus
 */
public class QuartoModel {
    
    // Define atributos do objeto
    private int    idQuarto;
    private int    capacidadeQuarto;
    private String descricaoQuarto;
    private TipoQuartoModel tipoQuarto;
    
    /**
     * Metodo construtor
     */
    public QuartoModel( ) {
        
        // Adciona os valores aos atributos do objeto
        this.idQuarto         = 0;
        this.tipoQuarto       = null;
        this.capacidadeQuarto = 0;
        this.descricaoQuarto  = null;
        
    }
    
    /**
     * @return the idQuarto
     */
    public int getIdQuarto() {
        return idQuarto;
    }

    /**
     * @param idQuarto the idQuarto to set
     * @return boolean
     */
    public boolean setIdQuarto(int idQuarto) {
        // Atribui o valor ao atributo id
        try {
            this.idQuarto = idQuarto;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the tipoQuarto
     */
    public TipoQuartoModel getTipoQuarto() {
        return tipoQuarto;
    }

    /**
     * @param tipoQuarto the tipoQuarto to set
     * @return boolean
     */
    public boolean setTipoQuarto(TipoQuartoModel tipoQuarto) {
        // Atribui o valor ao atributo id
        try {
            this.tipoQuarto = tipoQuarto;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the capacidadeQuarto
     */
    public int getCapacidadeQuarto() {
        return capacidadeQuarto;
    }

    /**
     * @param capacidadeQuarto the capacidadeQuarto to set
     * @return boolean
     */
    public boolean setCapacidadeQuarto(int capacidadeQuarto) {
        // Atribui o valor ao atributo id
        try {
            this.capacidadeQuarto = capacidadeQuarto;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the descricaoQuarto
     */
    public String getDescricaoQuarto() {
        return descricaoQuarto;
    }

    /**
     * @param descricaoQuarto the descricaoQuarto to set
     * @return boolean
     */
    public boolean setDescricaoQuarto(String descricaoQuarto) {
        // Atribui o valor ao atributo id
        try {
            this.descricaoQuarto = descricaoQuarto;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }
    
}
