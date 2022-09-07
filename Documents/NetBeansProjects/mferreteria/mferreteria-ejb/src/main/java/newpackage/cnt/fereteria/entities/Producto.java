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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProdId", query = "SELECT p FROM Producto p WHERE p.prodId = :prodId"),
    @NamedQuery(name = "Producto.findByProdDescripc", query = "SELECT p FROM Producto p WHERE p.prodDescripc = :prodDescripc"),
    @NamedQuery(name = "Producto.findByProdPrecio", query = "SELECT p FROM Producto p WHERE p.prodPrecio = :prodPrecio"),
    @NamedQuery(name = "Producto.findByProdMarca", query = "SELECT p FROM Producto p WHERE p.prodMarca = :prodMarca"),
    @NamedQuery(name = "Producto.findByProdCantidad", query = "SELECT p FROM Producto p WHERE p.prodCantidad = :prodCantidad"),
    @NamedQuery(name = "Producto.findByProdEstado", query = "SELECT p FROM Producto p WHERE p.prodEstado = :prodEstado")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_id")
    private Short prodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "prod_descripc")
    private String prodDescripc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "prod_precio")
    private String prodPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "prod_marca")
    private String prodMarca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_cantidad")
    private short prodCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_estado")
    private int prodEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<VentaProducto> ventaProductoList;
    @JoinColumn(name = "prov_id", referencedColumnName = "prov_id")
    @ManyToOne(optional = false)
    private Proveedor provId;
    @JoinColumn(name = "tipr_id", referencedColumnName = "tipr_id")
    @ManyToOne(optional = false)
    private TipoProducto tiprId;

    public Producto() {
    }

    public Producto(Short prodId) {
        this.prodId = prodId;
    }

    public Producto(Short prodId, String prodDescripc, String prodPrecio, String prodMarca, short prodCantidad, int prodEstado) {
        this.prodId = prodId;
        this.prodDescripc = prodDescripc;
        this.prodPrecio = prodPrecio;
        this.prodMarca = prodMarca;
        this.prodCantidad = prodCantidad;
        this.prodEstado = prodEstado;
    }

    public Short getProdId() {
        return prodId;
    }

    public void setProdId(Short prodId) {
        this.prodId = prodId;
    }

    public String getProdDescripc() {
        return prodDescripc;
    }

    public void setProdDescripc(String prodDescripc) {
        this.prodDescripc = prodDescripc;
    }

    public String getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(String prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    public String getProdMarca() {
        return prodMarca;
    }

    public void setProdMarca(String prodMarca) {
        this.prodMarca = prodMarca;
    }

    public short getProdCantidad() {
        return prodCantidad;
    }

    public void setProdCantidad(short prodCantidad) {
        this.prodCantidad = prodCantidad;
    }

    public int getProdEstado() {
        return prodEstado;
    }

    public void setProdEstado(int prodEstado) {
        this.prodEstado = prodEstado;
    }

    public List<VentaProducto> getVentaProductoList() {
        return ventaProductoList;
    }

    public void setVentaProductoList(List<VentaProducto> ventaProductoList) {
        this.ventaProductoList = ventaProductoList;
    }

    public Proveedor getProvId() {
        return provId;
    }

    public void setProvId(Proveedor provId) {
        this.provId = provId;
    }

    public TipoProducto getTiprId() {
        return tiprId;
    }

    public void setTiprId(TipoProducto tiprId) {
        this.tiprId = tiprId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.Producto[ prodId=" + prodId + " ]";
    }
    
}
