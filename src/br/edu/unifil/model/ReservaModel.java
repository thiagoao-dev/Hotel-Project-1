package br.edu.unifil.model;

import java.util.Date;

/**
 * Objeto Reserva
 * @author ThiagoAugustus
 */
public class ReservaModel {
    
    // Define atributos do objeto
    private int            idReserva;
    private VisitanteModel visitanteReserva;
    private QuartoModel    quartoReserva;
    private Date           entradaReserva;
    private Date           saidaReserva;
    private double         pagamentoReserva;
    private boolean        statusReserva;

    /**
     * Metodo construtor
     */
    public ReservaModel( ) {
    
        // Seta os valores aos atributos
        this.idReserva        = 0;
        this.visitanteReserva = null;
        this.quartoReserva    = null;
        this.entradaReserva   = null;
        this.saidaReserva     = null;
        this.pagamentoReserva = 0.00;
        this.statusReserva    = false;
        
    }
    
    /**
     * @return the idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     * @return boolean
     */
    public boolean setIdReserva(int idReserva) {
        // Atribui o valor ao atributo id
        try {
            this.idReserva = idReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the visitanteReserva
     */
    public VisitanteModel getVisitanteReserva() {
        return visitanteReserva;
    }

    /**
     * @param visitanteReserva the visitanteReserva to set
     * @return boolean
     */
    public boolean setVisitanteReserva(VisitanteModel visitanteReserva) {
        // Atribui o valor ao atributo id
        try {
            this.visitanteReserva = visitanteReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the quartoReserva
     */
    public QuartoModel getQuartoReserva() {
        return quartoReserva;
    }

    /**
     * @param quartoReserva the quartoReserva to set
     * @return boolean
     */
    public boolean setQuartoReserva(QuartoModel quartoReserva) {
        // Atribui o valor ao atributo id
        try {
            this.quartoReserva = quartoReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the entradaReserva
     */
    public Date getEntradaReserva() {
        return entradaReserva;
    }

    /**
     * @param entradaReserva the entradaReserva to set
     * @return boolean
     */
    public boolean setEntradaReserva(Date entradaReserva) {
        // Atribui o valor ao atributo id
        try {
            this.entradaReserva = entradaReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the saidaReserva
     */
    public Date getSaidaReserva() {
        return saidaReserva;
    }

    /**
     * @param saidaReserva the saidaReserva to set
     * @return boolean
     */
    public boolean setSaidaReserva(Date saidaReserva) {
        // Atribui o valor ao atributo id
        try {
            this.saidaReserva = saidaReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the pagamentoReserva
     */
    public double getPagamentoReserva() {
        return pagamentoReserva;
    }

    /**
     * @param pagamentoReserva the pagamentoReserva to set
     * @return boolean
     */
    public boolean setPagamentoReserva(double pagamentoReserva) {
        // Atribui o valor ao atributo id
        try {
            this.pagamentoReserva = pagamentoReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }

    /**
     * @return the statusPagamento
     */
    public boolean isStatusReserva() {
        return statusReserva;
    }

    /**
     * @param statusPagamento the statusPagamento to set
     * @return boolean
     */
    public boolean setStatusReserva(boolean statusReserva) {
        // Atribui o valor ao atributo id
        try {
            this.statusReserva = statusReserva;
        } catch (Exception e) {
            return false;
        }        
        return true;
    }
    
}
