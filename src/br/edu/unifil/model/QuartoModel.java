package br.edu.unifil.model;

/**
 * Objeto Quarto
 * @author ThiagoAugustus
 */
public class QuartoModel {
    
    private int    idQuarto;
    private int    tipoQuarto;
    private int    capacidadeQuarto;
    private String descricaoQuarto;
    
    /**
     * Inicia os atributos do objeto
     */
    public QuartoModel( ) {
        
        // Adciona os valores aos atributos do objeto
        this.idQuarto         = 0;
        this.tipoQuarto       = 0;
        this.capacidadeQuarto = 0;
        this.descricaoQuarto  = null;
        
    }
    
    /**
     * Inicia os atributos do objeto
     * @param tipoQuarto
     * @param capacidadeQuarto
     * @param descricaoQuarto 
     */
    public QuartoModel( int tipoQuarto,
            int capacidadeQuarto,
            String descricaoQuarto ) {
        
        // Adciona os valores aos atributos do objeto
        this.tipoQuarto       = tipoQuarto;
        this.capacidadeQuarto = capacidadeQuarto;
        this.descricaoQuarto  = descricaoQuarto;
        
    }
    
    /**
     * Inicia os atributos do objeto
     * @param idQuarto
     * @param tipoQuarto
     * @param capacidadeQuarto
     * @param descricaoQuarto 
     */
    public QuartoModel( int idQuarto,
            int tipoQuarto,
            int capacidadeQuarto,
            String descricaoQuarto ) {
        
        // Adciona os valores aos atributos do objeto
        this.idQuarto         = idQuarto;
        this.tipoQuarto       = tipoQuarto;
        this.capacidadeQuarto = capacidadeQuarto;
        this.descricaoQuarto  = descricaoQuarto;
        
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
    public int getTipoQuarto() {
        return tipoQuarto;
    }

    /**
     * @param tipoQuarto the tipoQuarto to set
     * @return boolean
     */
    public boolean setTipoQuarto(int tipoQuarto) {
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
