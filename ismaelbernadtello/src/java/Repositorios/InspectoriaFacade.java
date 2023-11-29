/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Inspectoria;
import Modelos.Sede;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ismae
 */
@Stateless
public class InspectoriaFacade extends AbstractFacade<Inspectoria> {

    @PersistenceContext(unitName = "ismaelbernadtelloPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InspectoriaFacade() {
        super(Inspectoria.class);
    }
    //La usamos en el selectmany y select one de proyectos para que nos salgan ordenados
    public List<Inspectoria> inspectoriasOrdenadas() {
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Inspectoria.findAllOrdered");
        return q.getResultList();
    }
}
