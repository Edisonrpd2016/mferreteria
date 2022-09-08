/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.cnt.fereteria.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import newpackage.cnt.fereteria.entities.Venta;

/**
 *
 * @author erporras
 */
public class VentaFacade extends AbstractFacade<Venta> {

    @PersistenceContext(unitName = "mferreteria")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public VentaFacade(){
      super(Venta.class);
    }

    
}
