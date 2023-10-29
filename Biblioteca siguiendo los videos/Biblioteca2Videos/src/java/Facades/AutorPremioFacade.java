/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import EntidadesOModelos.AutorPremio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ismae
 */
@Stateless
public class AutorPremioFacade extends AbstractFacade<AutorPremio> {

    @PersistenceContext(unitName = "Biblioteca2VideosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorPremioFacade() {
        super(AutorPremio.class);
    }
    
}