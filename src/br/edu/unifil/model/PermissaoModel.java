package br.edu.unifil.model;

/**
 * Objeto Permissao
 * @author ThiagoAugustus
 */
public class PermissaoModel {
 
    private int idPermissao;
    private boolean readPermissao;
    private boolean createPermissao;
    private boolean updatePermissao;
    private boolean deletePermissao;
    
    /**
     * Metodo constutor
     */
    public PermissaoModel(){ 
    
        this.idPermissao     = 0;
        this.readPermissao   = false;
        this.createPermissao = false;
        this.updatePermissao = false;
        this.deletePermissao = false;
        
    }

    /**
     * @return the idPermissao
     */
    public int getIdPermissao() {
        return idPermissao;
    }

    /**
     * @param idPermissao the idPermissao to set
     */
    public void setIdPermissao(int idPermissao) {
        this.idPermissao = idPermissao;
    }

    /**
     * @return the readPermissao
     */
    public boolean isReadPermissao() {
        return readPermissao;
    }

    /**
     * @param readPermissao the readPermissao to set
     */
    public void setReadPermissao(boolean readPermissao) {
        this.readPermissao = readPermissao;
    }

    /**
     * @return the createPermissao
     */
    public boolean isCreatePermissao() {
        return createPermissao;
    }

    /**
     * @param createPermissao the createPermissao to set
     */
    public void setCreatePermissao(boolean createPermissao) {
        this.createPermissao = createPermissao;
    }

    /**
     * @return the updatePermissao
     */
    public boolean isUpdatePermissao() {
        return updatePermissao;
    }

    /**
     * @param updatePermissao the updatePermissao to set
     */
    public void setUpdatePermissao(boolean updatePermissao) {
        this.updatePermissao = updatePermissao;
    }

    /**
     * @return the deletePermissao
     */
    public boolean isDeletePermissao() {
        return deletePermissao;
    }

    /**
     * @param deletePermissao the deletePermissao to set
     */
    public void setDeletePermissao(boolean deletePermissao) {
        this.deletePermissao = deletePermissao;
    }
    
}
