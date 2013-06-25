package br.edu.unifil.model;

/**
 * Objeto Visitante
 * @author ThiagoAugustus
 */
public class VisitanteModel {

    // Declara as variaveis
    private int    idVisitante;
    private String nomeVisitante;
    private String telefoneVisitante;
    private String emailVisitante;
    
    /**
     * Inicia os atributos do objeto
     */
    public VisitanteModel(){ 
    
        // Inicia os atributos do objeto
        this.idVisitante       = 0;
        this.nomeVisitante     = null;
        this.telefoneVisitante = null;
        this.emailVisitante    = null;
        
    }
    
    /**
     * Adciona os valores aos atributos
     * @param idVisitante
     * @param nomeVisitante
     * @param telefoneVisitante
     * @param emailVisitante 
     */
    public VisitanteModel( int idVisitante, 
            String nomeVisitante, 
            String telefoneVisitante,
            String emailVisitante ) {  
        
        // Seta os valores aos atributos
        this.idVisitante       = idVisitante;
        this.nomeVisitante     = nomeVisitante;
        this.telefoneVisitante = telefoneVisitante;
        this.emailVisitante    = emailVisitante;
    
    }
    
    /**
     * Adciona os valores aos atributos
     * @param nomeVisitante
     * @param telefoneVisitante
     * @param emailVisitante 
     */
    public VisitanteModel( String nomeVisitante, 
            String telefoneVisitante,
            String emailVisitante ) {  
    
    }
    
    /**
     * @return the idVisitante
     */
    public int getIdVisitante() {
        return idVisitante;
    }

    /**
     * @param idVisitante the idVisitante to set
     * @return boolean
     */
    public boolean setIdVisitante(int idVisitante) {
        // Atribui o valor ao atributo id
        try {
            this.idVisitante = idVisitante;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the nomeVisitante
     */
    public String getNomeVisitante() {
        return nomeVisitante;
    }

    /**
     * @param nomeVisitante the nomeVisitante to set
     * @return boolean
     */
    public boolean setNomeVisitante(String nomeVisitante) {
        // Atribui o valor ao atributo nome
        try {
            this.nomeVisitante = nomeVisitante;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the telefoneVisitante
     */
    public String getTelefoneVisitante() {
        return telefoneVisitante;
    }

    /**
     * @param telefoneVisitante the telefoneVisitante to set
     * @return boolean
     */
    public boolean setTelefoneVisitante(String telefoneVisitante) {
        // Atribui o valor ao atributo nome
        try {
            this.telefoneVisitante = telefoneVisitante;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the emailVisitante
     */
    public String getEmailVisitante() {
        return emailVisitante;
    }

    /**
     * @param emailVisitante the emailVisitante to set
     * @return boolean
     */
    public boolean setEmailVisitante(String emailVisitante) {
        // Atribui o valor ao atributo nome
        try {
            this.emailVisitante = emailVisitante;
        } catch (Exception e) {
            return false;
        }        
        return true;        
    }   
    
}
