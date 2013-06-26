package br.edu.unifil.model;

/**
 * Objeto TipoQuarto
 * @author ThiagoAugustus
 */
public class TipoQuartoModel {

    // Define atributos do objeto
    private int    idTipoQuarto;
    private String descricaoTipoQuarto;
    
    /**
     * Inicia os valores do atributo
     */
    public TipoQuartoModel( ) {
        
        // Adciona os valores aos atributos do objeto
        this.idTipoQuarto        = 0;
        this.descricaoTipoQuarto = null;
        
    }
    
    /**
     * Define os valores do atributo
     * @param descricaoTipoQuarto 
     */
    public TipoQuartoModel( String descricaoTipoQuarto ) {
        
        // Adciona os valores aos atributos do objeto
        this.descricaoTipoQuarto = descricaoTipoQuarto;
        
    }
    
    /**
     * Define os valores do atributo
     * @param idTipoQuarto
     * @param descricaoTipoQuarto 
     */
    public TipoQuartoModel( int idTipoQuarto, String descricaoTipoQuarto ) {
        
        // Adciona os valores aos atributos do objeto
        this.idTipoQuarto        = idTipoQuarto;
        this.descricaoTipoQuarto = descricaoTipoQuarto;
        
    }

    /**
     * @return the idTipoQuarto
     */
    public int getIdTipoQuarto() {
        return idTipoQuarto;
    }

    /**
     * @param idTipoQuarto the idTipoQuarto to set
     * @return boolean
     */
    public boolean setIdTipoQuarto(int idTipoQuarto) {
        // Atribui o valor ao atributo idTipo
        try {
            this.idTipoQuarto = idTipoQuarto;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the descricaoTipoQuarto
     */
    public String getDescricaoTipoQuarto() {
        return descricaoTipoQuarto;
    }

    /**
     * @param descricaoTipoQuarto the descricaoTipoQuarto to set
     * @return boolean
     */
    public boolean setDescricaoTipoQuarto(String descricaoTipoQuarto) {
        // Atribui o valor ao atributo descricao
        try {
            this.descricaoTipoQuarto = descricaoTipoQuarto;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }
    
}
