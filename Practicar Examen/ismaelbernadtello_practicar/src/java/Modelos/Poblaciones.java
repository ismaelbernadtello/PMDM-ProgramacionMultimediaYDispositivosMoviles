/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ismae
 */
@Entity
@Table(name = "poblaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poblaciones.findAll", query = "SELECT p FROM Poblaciones p")
    , @NamedQuery(name = "Poblaciones.findByCodPoblacion", query = "SELECT p FROM Poblaciones p WHERE p.codPoblacion = :codPoblacion")
    , @NamedQuery(name = "Poblaciones.findByNomPoblacion", query = "SELECT p FROM Poblaciones p WHERE p.nomPoblacion = :nomPoblacion")
    , @NamedQuery(name = "Poblaciones.findByTarget", query = "SELECT p FROM Poblaciones p WHERE p.target = :target")})
public class Poblaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_poblacion")
    private String codPoblacion;
    @Size(max = 50)
    @Column(name = "nom_poblacion")
    private String nomPoblacion;
    @Size(max = 50)
    @Column(name = "target")
    private String target;

    public Poblaciones() {
    }

    public Poblaciones(String codPoblacion) {
        this.codPoblacion = codPoblacion;
    }

    public String getCodPoblacion() {
        return codPoblacion;
    }

    public void setCodPoblacion(String codPoblacion) {
        this.codPoblacion = codPoblacion;
    }

    public String getNomPoblacion() {
        return nomPoblacion;
    }

    public void setNomPoblacion(String nomPoblacion) {
        this.nomPoblacion = nomPoblacion;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPoblacion != null ? codPoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poblaciones)) {
            return false;
        }
        Poblaciones other = (Poblaciones) object;
        if ((this.codPoblacion == null && other.codPoblacion != null) || (this.codPoblacion != null && !this.codPoblacion.equals(other.codPoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Poblaciones[ codPoblacion=" + codPoblacion + " ]";
    }
    
}
