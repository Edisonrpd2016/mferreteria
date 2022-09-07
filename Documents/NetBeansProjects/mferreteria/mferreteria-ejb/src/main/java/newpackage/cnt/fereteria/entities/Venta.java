/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.cnt.fereteria.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author erporras
 */
@Entity
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByVentId", query = "SELECT v FROM Venta v WHERE v.ventId = :ventId"),
    @NamedQuery(name = "Venta.findByVentCosto", query = "SELECT v FROM Venta v WHERE v.ventCosto = :ventCosto"),
    @NamedQuery(name = "Venta.findByVentFecha", query = "SELECT v FROM Venta v WHERE v.ventFecha = :ventFecha"),
    @NamedQuery(name = "Venta.findByVendId", query = "SELECT v FROM Venta v WHERE v.vendId = :vendId")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vent_id")
    private Integer ventId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vent_costo")
    private int ventCosto;
    @Column(name = "vent_fecha")
    @Temporal(TemporalType.DATE)
    private Date ventFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vend_id")
    private short vendId;
    @JoinColumn(name = "clie_id", referencedColumnName = "clie_id")
    @ManyToOne(optional = false)
    private Cliente clieId;
    @JoinColumn(name = "fopa_id", referencedColumnName = "fopa_id")
    @ManyToOne
    private FormaPago fopaId;
    @JoinColumn(name = "prom_id", referencedColumnName = "prom_id")
    @ManyToOne(optional = false)
    private Promociones promId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventId")
    private List<VentaProducto> ventaProductoList;

    public Venta() {
    }

    public Venta(Integer ventId) {
        this.ventId = ventId;
    }

    public Venta(Integer ventId, int ventCosto, short vendId) {
        this.ventId = ventId;
        this.ventCosto = ventCosto;
        this.vendId = vendId;
    }

    public Integer getVentId() {
        return ventId;
    }

    public void setVentId(Integer ventId) {
        this.ventId = ventId;
    }

    public int getVentCosto() {
        return ventCosto;
    }

    public void setVentCosto(int ventCosto) {
        this.ventCosto = ventCosto;
    }

    public Date getVentFecha() {
        return ventFecha;
    }

    public void setVentFecha(Date ventFecha) {
        this.ventFecha = ventFecha;
    }

    public short getVendId() {
        return vendId;
    }

    public void setVendId(short vendId) {
        this.vendId = vendId;
    }

    public Cliente getClieId() {
        return clieId;
    }

    public void setClieId(Cliente clieId) {
        this.clieId = clieId;
    }

    public FormaPago getFopaId() {
        return fopaId;
    }

    public void setFopaId(FormaPago fopaId) {
        this.fopaId = fopaId;
    }

    public Promociones getPromId() {
        return promId;
    }

    public void setPromId(Promociones promId) {
        this.promId = promId;
    }

    public List<VentaProducto> getVentaProductoList() {
        return ventaProductoList;
    }

    public void setVentaProductoList(List<VentaProducto> ventaProductoList) {
        this.ventaProductoList = ventaProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventId != null ? ventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.ventId == null && other.ventId != null) || (this.ventId != null && !this.ventId.equals(other.ventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.Venta[ ventId=" + ventId + " ]";
    }
    
}
