/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Envio;
import Modelos.Inspectoria;
import Modelos.Proyecto;
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
public class ProyectoFacade extends AbstractFacade<Proyecto> {

    @PersistenceContext(unitName = "ismaelbernadtelloPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }
    
     //La usamos en el selectmany y select one de proyectos para que nos salgan ordenados
    public List<Proyecto> proyectosOrdenados() {
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Proyecto.findAllOrdered");
        return q.getResultList();
    }
    
    //Para Envio Proyecto
    public List<Envio> EnvioPorProyecto(Proyecto proyecto){ //Sirve para sacar los envíos de dinero de un proyecto
        em = getEntityManager();
        Query q;
        if (proyecto != null){ //Comrprobamos que se ha seleccionado un proyectom sino se devuelve unos envíos de un proyecto por defecto
        q = em.createNamedQuery("Proyecto.findEnvioByProyecto").setParameter("unProyecto", proyecto.getCodigo());
        }
        else{
        q = em.createNamedQuery("Proyecto.findEnvioByProyecto").setParameter("unProyecto", "ZA/626/22/PY"); 
        }
        return q.getResultList();
    }

    
    public Inspectoria inspectoriaProyectoCompleto(Proyecto proyectoCompleto) {
        em = getEntityManager();
        Query q;
        
        //Compruebo que el proyecto haya sido seleccionado y que ese proyecto tenga una sede asignada
        if (proyectoCompleto != null && proyectoCompleto.getInspectoria() != null) {
            q = em.createNamedQuery("Proyecto.findByInspectoriaProyectoCompleto")
                    .setParameter("unProyectoCompleto",proyectoCompleto.getInspectoria().getCodInspectoria())
                    .setMaxResults(1);
        } 
        else {
            return null; //Si no se ha seleccionado nada o no tiene sede asignada no saldra nada
        }

        // Ejecutar la consulta y obtener el resultado
        Inspectoria resultado = (Inspectoria) q.getSingleResult();  // Devolvemos 1 solo resultado por el tipo de relacion

        // Devolver el resultado
        return resultado;
    }

    public Sede sedeProyectoCompleto(Proyecto proyectoCompleto) {
        em = getEntityManager();
        Query q;
        
        //Compruebo que el proyecto haya sido seleccionado y que ese proyecto tenga una sede asignada
        if (proyectoCompleto != null && proyectoCompleto.getSede() != null) {
            q = em.createNamedQuery("Proyecto.findBySedeProyectoCompleto")
                    .setParameter("unProyectoCompleto",proyectoCompleto.getSede().getCodSede())
                    .setMaxResults(1);
        } 
        else {
            return null; //Si no se ha seleccionado nada o no tiene sede asignada no saldra nada
        }

        // Ejecutar la consulta y obtener el resultado
        Sede resultado = (Sede) q.getSingleResult();  // Devolvemos 1 solo resultado por el tipo de relacion

        // Devolver el resultado
        return resultado;
    }
    

    
    
}
