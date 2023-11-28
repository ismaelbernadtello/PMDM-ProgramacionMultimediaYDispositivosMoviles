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
@Table(name = "continentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continentes.findAll", query = "SELECT c FROM Continentes c")
    , @NamedQuery(name = "Continentes.findByCodContinente", query = "SELECT c FROM Continentes c WHERE c.codContinente = :codContinente")
    , @NamedQuery(name = "Continentes.findByNomContinente", query = "SELECT c FROM Continentes c WHERE c.nomContinente = :nomContinente")})
public class Continentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_continente")
    private Integer codContinente;
    @Size(max = 50)
    @Column(name = "nom_continente")
    private String nomContinente;

    public Continentes() {
    }

    public Continentes(Integer codContinente) {
        this.codContinente = codContinente;
    }

    public Integer getCodContinente() {
        return codContinente;
    }

    public void setCodContinente(Integer codContinente) {
        this.codContinente = codContinente;
    }

    public String getNomContinente() {
        return nomContinente;
    }

    public void setNomContinente(String nomContinente) {
        this.nomContinente = nomContinente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codContinente != null ? codContinente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continentes)) {
            return false;
        }
        Continentes other = (Continentes) object;
        if ((this.codContinente == null && other.codContinente != null) || (this.codContinente != null && !this.codContinente.equals(other.codContinente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Continentes[ codContinente=" + codContinente + " ]";
    }
    
}
