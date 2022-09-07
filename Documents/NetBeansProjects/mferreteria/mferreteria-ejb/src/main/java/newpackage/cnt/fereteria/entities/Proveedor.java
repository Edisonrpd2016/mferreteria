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
@Table(name = "proveedor")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByProvId", query = "SELECT p FROM Proveedor p WHERE p.provId = :provId"),
    @NamedQuery(name = "Proveedor.findByProvNombre", query = "SELECT p FROM Proveedor p WHERE p.provNombre = :provNombre"),
    @NamedQuery(name = "Proveedor.findByProvNit", query = "SELECT p FROM Proveedor p WHERE p.provNit = :provNit"),
    @NamedQuery(name = "Proveedor.findByProvDireccion", query = "SELECT p FROM Proveedor p WHERE p.provDireccion = :provDireccion"),
    @NamedQuery(name = "Proveedor.findByProvTelefono", query = "SELECT p FROM Proveedor p WHERE p.provTelefono = :provTelefono"),
    @NamedQuery(name = "Proveedor.findByProvEstado", query = "SELECT p FROM Proveedor p WHERE p.provEstado = :provEstado")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_id")
    private Integer provId;
    @Size(max = 100)
    @Column(name = "prov_nombre")
    private String provNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_nit")
    private int provNit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "prov_direccion")
    private String provDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "prov_telefono")
    private String provTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_estado")
    private int provEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provId")
    private List<Producto> productoList;

    public Proveedor() {
    }

    public Proveedor(Integer provId) {
        this.provId = provId;
    }

    public Proveedor(Integer provId, int provNit, String provDireccion, String provTelefono, int provEstado) {
        this.provId = provId;
        this.provNit = provNit;
        this.provDireccion = provDireccion;
        this.provTelefono = provTelefono;
        this.provEstado = provEstado;
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    public int getProvNit() {
        return provNit;
    }

    public void setProvNit(int provNit) {
        this.provNit = provNit;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public String getProvTelefono() {
        return provTelefono;
    }

    public void setProvTelefono(String provTelefono) {
        this.provTelefono = provTelefono;
    }

    public int getProvEstado() {
        return provEstado;
    }

    public void setProvEstado(int provEstado) {
        this.provEstado = provEstado;
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
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.Proveedor[ provId=" + provId + " ]";
    }
    
}
