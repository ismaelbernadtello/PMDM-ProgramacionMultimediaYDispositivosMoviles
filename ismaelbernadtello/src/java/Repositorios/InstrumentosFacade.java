/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Instrumentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ismae
 */
@Stateless
public class InstrumentosFacade extends AbstractFacade<Instrumentos> {

    @PersistenceContext(unitName = "ismaelbernadtelloPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstrumentosFacade() {
        super(Instrumentos.class);
    }
    
}
