/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.cnt.fereteria.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author erporras
 */
@Entity
@Table(name = "venta_producto")
@NamedQueries({
    @NamedQuery(name = "VentaProducto.findAll", query = "SELECT v FROM VentaProducto v"),
    @NamedQuery(name = "VentaProducto.findByVepoId", query = "SELECT v FROM VentaProducto v WHERE v.vepoId = :vepoId")})
public class VentaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vepo_id")
    private Integer vepoId;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false)
    private Producto prodId;
    @JoinColumn(name = "vent_id", referencedColumnName = "vent_id")
    @ManyToOne(optional = false)
    private Venta ventId;

    public VentaProducto() {
    }

    public VentaProducto(Integer vepoId) {
        this.vepoId = vepoId;
    }

    public Integer getVepoId() {
        return vepoId;
    }

    public void setVepoId(Integer vepoId) {
        this.vepoId = vepoId;
    }

    public Producto getProdId() {
        return prodId;
    }

    public void setProdId(Producto prodId) {
        this.prodId = prodId;
    }

    public Venta getVentId() {
        return ventId;
    }

    public void setVentId(Venta ventId) {
        this.ventId = ventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vepoId != null ? vepoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaProducto)) {
            return false;
        }
        VentaProducto other = (VentaProducto) object;
        if ((this.vepoId == null && other.vepoId != null) || (this.vepoId != null && !this.vepoId.equals(other.vepoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.VentaProducto[ vepoId=" + vepoId + " ]";
    }
    
}
