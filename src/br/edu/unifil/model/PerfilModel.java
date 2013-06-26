package br.edu.unifil.model;

/**
 * Object Perfil
 * @author ThiagoAugustus
 */
public class PerfilModel {
    
    private int            idPerfil;
    private String         descricaoPerfil;
    private boolean        statusPerfil;
    private PermissaoModel permissaoPerfil;
    
    /**
     * Metodo construtor
     */
    public PerfilModel(){ 
    
        this.idPerfil        = 0;
        this.descricaoPerfil = null;
        this.statusPerfil    = false;
        this.permissaoPerfil = null;
        
    }

    /**
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @return the descricaoPerfil
     */
    public String getDescricaoPerfil() {
        return descricaoPerfil;
    }

    /**
     * @param descricaoPerfil the descricaoPerfil to set
     */
    public void setDescricaoPerfil(String descricaoPerfil) {
        this.descricaoPerfil = descricaoPerfil;
    }

    /**
     * @return the statusPerfil
     */
    public boolean isStatusPerfil() {
        return statusPerfil;
    }

    /**
     * @param statusPerfil the statusPerfil to set
     */
    public void setStatusPerfil(boolean statusPerfil) {
        this.statusPerfil = statusPerfil;
    }

    /**
     * @return the permissaoPerfil
     */
    public PermissaoModel getPermissaoPerfil() {
        return permissaoPerfil;
    }

    /**
     * @param permissaoPerfil the permissaoPerfil to set
     */
    public void setPermissaoPerfil(PermissaoModel permissaoPerfil) {
        this.permissaoPerfil = permissaoPerfil;
    }
    
}
