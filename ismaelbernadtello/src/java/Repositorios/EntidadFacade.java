/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Entidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ismae
 */
@Stateless
public class EntidadFacade extends AbstractFacade<Entidad> {

    @PersistenceContext(unitName = "ismaelbernadtelloPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadFacade() {
        super(Entidad.class);
    }
    
}
