/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.cnt.fereteria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author erporras
 */
@Entity
@Table(name = "tipo_producto")
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t"),
    @NamedQuery(name = "TipoProducto.findByTiprId", query = "SELECT t FROM TipoProducto t WHERE t.tiprId = :tiprId"),
    @NamedQuery(name = "TipoProducto.findByTiprDescripc", query = "SELECT t FROM TipoProducto t WHERE t.tiprDescripc = :tiprDescripc"),
    @NamedQuery(name = "TipoProducto.findByTiprEstado", query = "SELECT t FROM TipoProducto t WHERE t.tiprEstado = :tiprEstado")})
public class TipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipr_id")
    private Short tiprId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipr_descripc")
    private String tiprDescripc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipr_estado")
    private int tiprEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiprId")
    private List<Producto> productoList;

    public TipoProducto() {
    }

    public TipoProducto(Short tiprId) {
        this.tiprId = tiprId;
    }

    public TipoProducto(Short tiprId, String tiprDescripc, int tiprEstado) {
        this.tiprId = tiprId;
        this.tiprDescripc = tiprDescripc;
        this.tiprEstado = tiprEstado;
    }

    public Short getTiprId() {
        return tiprId;
    }

    public void setTiprId(Short tiprId) {
        this.tiprId = tiprId;
    }

    public String getTiprDescripc() {
        return tiprDescripc;
    }

    public void setTiprDescripc(String tiprDescripc) {
        this.tiprDescripc = tiprDescripc;
    }

    public int getTiprEstado() {
        return tiprEstado;
    }

    public void setTiprEstado(int tiprEstado) {
        this.tiprEstado = tiprEstado;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiprId != null ? tiprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.tiprId == null && other.tiprId != null) || (this.tiprId != null && !this.tiprId.equals(other.tiprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.TipoProducto[ tiprId=" + tiprId + " ]";
    }
    
}
