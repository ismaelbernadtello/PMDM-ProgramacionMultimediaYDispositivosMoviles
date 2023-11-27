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
@Table(name = "subcategorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategorias.findAll", query = "SELECT s FROM Subcategorias s")
    , @NamedQuery(name = "Subcategorias.findByCodSubcategoria", query = "SELECT s FROM Subcategorias s WHERE s.codSubcategoria = :codSubcategoria")
    , @NamedQuery(name = "Subcategorias.findByNomSubcategoria", query = "SELECT s FROM Subcategorias s WHERE s.nomSubcategoria = :nomSubcategoria")
    , @NamedQuery(name = "Subcategorias.findByDescripcion", query = "SELECT s FROM Subcategorias s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Subcategorias.findByCodCategoria", query = "SELECT s FROM Subcategorias s WHERE s.codCategoria = :codCategoria")})
public class Subcategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_subcategoria")
    private Short codSubcategoria;
    @Size(max = 100)
    @Column(name = "nom_subcategoria")
    private String nomSubcategoria;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cod_categoria")
    private Short codCategoria;

    public Subcategorias() {
    }

    public Subcategorias(Short codSubcategoria) {
        this.codSubcategoria = codSubcategoria;
    }

    public Short getCodSubcategoria() {
        return codSubcategoria;
    }

    public void setCodSubcategoria(Short codSubcategoria) {
        this.codSubcategoria = codSubcategoria;
    }

    public String getNomSubcategoria() {
        return nomSubcategoria;
    }

    public void setNomSubcategoria(String nomSubcategoria) {
        this.nomSubcategoria = nomSubcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Short codCategoria) {
        this.codCategoria = codCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubcategoria != null ? codSubcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategorias)) {
            return false;
        }
        Subcategorias other = (Subcategorias) object;
        if ((this.codSubcategoria == null && other.codSubcategoria != null) || (this.codSubcategoria != null && !this.codSubcategoria.equals(other.codSubcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Subcategorias[ codSubcategoria=" + codSubcategoria + " ]";
    }
    
}
