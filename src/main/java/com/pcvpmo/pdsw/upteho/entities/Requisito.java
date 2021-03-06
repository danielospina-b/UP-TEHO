package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;

/**
 * Una clase simple que representa un Requisito en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Requisito implements Serializable {
    private String sigMateria;
    private String sigRequisito;
    private int tipo;

    public Requisito() {
    }
    
    public Requisito(String mat, String req, int tipo){
        this.sigMateria = mat;
        this.sigRequisito = req;
        this.tipo = tipo;
    }
    
    public String getSigMateria(){
        return this.sigMateria;
    }
    
    public String getSigRequisito(){
        return this.sigRequisito;    
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public void setSigMateria(String mat){
        this.sigMateria = mat;
    }
    
    public void setSigRequisito(String req){
        this.sigRequisito = req;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}
