package br.edu.unifil.tablemodel;

import br.edu.unifil.dao.PerfilDao;
import br.edu.unifil.model.PerfilModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Perfil Table Model Object
 * @author ThiagoAugustus
 */
public class PerfilTableModel extends AbstractTableModel {
    
    // Declara os atributos do objeto
    String[]                  columnNames = {"Descrição", "Status"};
    private int               startPosition;
    private List<PerfilModel> listaPerfil;
    private PerfilDao         perfilCRUD;

    /**
     * Classe construtora
     */
    public PerfilTableModel() {
        
        this.perfilCRUD = new PerfilDao();
        this.startPosition = 0;
        this.listaPerfil = getAllItems();
        
    }
    
    /**
     * Retorna uma lista com os perfis
     * @return List<PerfilModel> 
     */
    private List<PerfilModel> getAllItems() {
        
        try {
        
            return perfilCRUD.listAll();
        
        } catch (SQLException ex) {
        
            System.out.println("Erro ao recuperar os perfil cadastrados.");
        
        }
        
        return null;
        
    }
    
    /**
     * Retora uma lista 
     * @param from
     * @param to
     * @return 
     */
    private List<PerfilModel> getItems(int from, int to) {
        
        try {
        
            return perfilCRUD.listAll();
        
        } catch (SQLException ex) {
        
            System.out.println("Erro ao recuperar os perfil cadastrados.");
        
        }
        
        return null;
    
    }

//    public void setValueAt(PerfilModel perfil, int row, int col) {
//        PerfilModel p = (PerfilModel) listaPerfil.get(row);
//
//        listaPerfil.add(perfil);
//        fireTableCellUpdated(row, col);
//    }

    /**
     * Retorna os dados conforme eixo Y e X
     * @param int rowIndex
     * @param int columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object toReturn = null;
        if (!listaPerfil.isEmpty()) {
            
            PerfilModel perfil = listaPerfil.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                    toReturn = perfil.getDescricaoPerfil();
                    break;
                case 1:
                    toReturn = perfil.isStatusPerfil();
                    break;
                case 2:
                    toReturn = perfil.getPermissaoPerfil().getIdPermissao();
                    break;
                default:
                    toReturn = perfil.getIdPerfil();

            }
        
            return toReturn;
        }
        
        return toReturn;
        
    }

    /**
     * Retorna a quantidade de linhas
     * @return int
     */
    @Override
    public int getRowCount() {

        return listaPerfil.size();
    
    }

    /**
     * Retorna a quantidade de colunas da tabela
     * @return int
     */
    @Override
    public int getColumnCount() {
        
        return 2;
        
    }

    /**
     * Retorna o perfil conforme indice
     * @param int indice
     * @return PerfilModel
     */
    public PerfilModel getFromIndice(int indice) {
        
        return listaPerfil.get(indice);
        
    }

    /**
     * Retorna o nome da coluna
     * @param int column
     * @return String 
     */
    @Override
    public String getColumnName(int column) {
        
        String toReturn;
        
        switch (column) {
            case 0:
                toReturn = columnNames[0];
                break;

            case 1:
                toReturn = columnNames[1];
                break;

            default:
                toReturn = "";
                break;
        }

        return toReturn;
    
    }

    /**
     * 
     */
    @Override
    public void fireTableDataChanged() {
        this.listaPerfil = getAllItems();
        super.fireTableDataChanged();
    }

    /**
     * 
     * @param tme 
     */
    @Override
    public void fireTableChanged(TableModelEvent tme) {
        super.fireTableChanged(tme);
    }
    
    /**
     * 
     * @param tl 
     */
    @Override
    public void addTableModelListener(TableModelListener tl) {
        super.addTableModelListener(tl);
    }

    /**
     * Recupera o PerfilDao do objeto
     * @return PerfilDao
     */
    public PerfilDao getCrud() {
        return perfilCRUD;
    }

    /**
     * Atribui o PerfilDao ao objeto
     * @param PerfilDao perfil 
     */
    public void setCrud(PerfilDao perfil) {
        this.perfilCRUD = perfil;
    }
    
}
