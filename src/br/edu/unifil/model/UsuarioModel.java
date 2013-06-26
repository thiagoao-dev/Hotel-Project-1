package br.edu.unifil.model;

/**
 * Objeto Usuario
 * @author ThiagoAugustus
 */
public class UsuarioModel {
 
    private int         idUsuario;
    private String      loginUsuario;
    private String      passwordUsuario;
    private PerfilModel perfilUsuario;
    
    public UsuarioModel(){ }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the loginUsuario
     */
    public String getLoginUsuario() {
        return loginUsuario;
    }

    /**
     * @param loginUsuario the loginUsuario to set
     */
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    /**
     * @return the passwordUsuario
     */
    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    /**
     * @param passwordUsuario the passwordUsuario to set
     */
    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    /**
     * @return the perfilUsuario
     */
    public PerfilModel getPerfilUsuario() {
        return perfilUsuario;
    }

    /**
     * @param perfilUsuario the perfilUsuario to set
     */
    public void setPerfilUsuario(PerfilModel perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
    
}
