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
@Table(name = "comunidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidades.findAll", query = "SELECT c FROM Comunidades c")
    , @NamedQuery(name = "Comunidades.findByCodComunidad", query = "SELECT c FROM Comunidades c WHERE c.codComunidad = :codComunidad")
    , @NamedQuery(name = "Comunidades.findByNomComunidad", query = "SELECT c FROM Comunidades c WHERE c.nomComunidad = :nomComunidad")})
public class Comunidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_comunidad")
    private Integer codComunidad;
    @Size(max = 50)
    @Column(name = "nom_comunidad")
    private String nomComunidad;

    public Comunidades() {
    }

    public Comunidades(Integer codComunidad) {
        this.codComunidad = codComunidad;
    }

    public Integer getCodComunidad() {
        return codComunidad;
    }

    public void setCodComunidad(Integer codComunidad) {
        this.codComunidad = codComunidad;
    }

    public String getNomComunidad() {
        return nomComunidad;
    }

    public void setNomComunidad(String nomComunidad) {
        this.nomComunidad = nomComunidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComunidad != null ? codComunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidades)) {
            return false;
        }
        Comunidades other = (Comunidades) object;
        if ((this.codComunidad == null && other.codComunidad != null) || (this.codComunidad != null && !this.codComunidad.equals(other.codComunidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Comunidades[ codComunidad=" + codComunidad + " ]";
    }
    
}
