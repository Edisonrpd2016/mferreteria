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
@Table(name = "promociones")
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p"),
    @NamedQuery(name = "Promociones.findByPromId", query = "SELECT p FROM Promociones p WHERE p.promId = :promId"),
    @NamedQuery(name = "Promociones.findByPromDescuento", query = "SELECT p FROM Promociones p WHERE p.promDescuento = :promDescuento"),
    @NamedQuery(name = "Promociones.findByPromEstado", query = "SELECT p FROM Promociones p WHERE p.promEstado = :promEstado")})
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prom_id")
    private Integer promId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "prom_descuento")
    private String promDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prom_estado")
    private int promEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promId")
    private List<Venta> ventaList;

    public Promociones() {
    }

    public Promociones(Integer promId) {
        this.promId = promId;
    }

    public Promociones(Integer promId, String promDescuento, int promEstado) {
        this.promId = promId;
        this.promDescuento = promDescuento;
        this.promEstado = promEstado;
    }

    public Integer getPromId() {
        return promId;
    }

    public void setPromId(Integer promId) {
        this.promId = promId;
    }

    public String getPromDescuento() {
        return promDescuento;
    }

    public void setPromDescuento(String promDescuento) {
        this.promDescuento = promDescuento;
    }

    public int getPromEstado() {
        return promEstado;
    }

    public void setPromEstado(int promEstado) {
        this.promEstado = promEstado;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promId != null ? promId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.promId == null && other.promId != null) || (this.promId != null && !this.promId.equals(other.promId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.Promociones[ promId=" + promId + " ]";
    }
    
}
