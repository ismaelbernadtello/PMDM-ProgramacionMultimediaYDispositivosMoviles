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
@Table(name = "instrumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instrumentos.findAll", query = "SELECT i FROM Instrumentos i")
    , @NamedQuery(name = "Instrumentos.findByLt", query = "SELECT i FROM Instrumentos i WHERE i.lt = :lt")
    , @NamedQuery(name = "Instrumentos.findByCodigo", query = "SELECT i FROM Instrumentos i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Instrumentos.findByDescripcion", query = "SELECT i FROM Instrumentos i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Instrumentos.findByNumero", query = "SELECT i FROM Instrumentos i WHERE i.numero = :numero")
    , @NamedQuery(name = "Instrumentos.findByBloque", query = "SELECT i FROM Instrumentos i WHERE i.bloque = :bloque")})
public class Instrumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "lt")
    private String lt;
    @Size(max = 12)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 1)
    @Column(name = "bloque")
    private String bloque;

    public Instrumentos() {
    }

    public Instrumentos(String lt) {
        this.lt = lt;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lt != null ? lt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumentos)) {
            return false;
        }
        Instrumentos other = (Instrumentos) object;
        if ((this.lt == null && other.lt != null) || (this.lt != null && !this.lt.equals(other.lt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Instrumentos[ lt=" + lt + " ]";
    }
    
}
