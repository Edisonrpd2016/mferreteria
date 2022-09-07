/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.cnt.fereteria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "forma_pago")
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"),
    @NamedQuery(name = "FormaPago.findByFopaId", query = "SELECT f FROM FormaPago f WHERE f.fopaId = :fopaId"),
    @NamedQuery(name = "FormaPago.findByFopaDescripc", query = "SELECT f FROM FormaPago f WHERE f.fopaDescripc = :fopaDescripc"),
    @NamedQuery(name = "FormaPago.findByFopaEstado", query = "SELECT f FROM FormaPago f WHERE f.fopaEstado = :fopaEstado")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fopa_id")
    private Integer fopaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fopa_descripc")
    private String fopaDescripc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fopa_estado")
    private int fopaEstado;
    @OneToMany(mappedBy = "fopaId")
    private List<Venta> ventaList;

    public FormaPago() {
    }

    public FormaPago(Integer fopaId) {
        this.fopaId = fopaId;
    }

    public FormaPago(Integer fopaId, String fopaDescripc, int fopaEstado) {
        this.fopaId = fopaId;
        this.fopaDescripc = fopaDescripc;
        this.fopaEstado = fopaEstado;
    }

    public Integer getFopaId() {
        return fopaId;
    }

    public void setFopaId(Integer fopaId) {
        this.fopaId = fopaId;
    }

    public String getFopaDescripc() {
        return fopaDescripc;
    }

    public void setFopaDescripc(String fopaDescripc) {
        this.fopaDescripc = fopaDescripc;
    }

    public int getFopaEstado() {
        return fopaEstado;
    }

    public void setFopaEstado(int fopaEstado) {
        this.fopaEstado = fopaEstado;
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
        hash += (fopaId != null ? fopaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.fopaId == null && other.fopaId != null) || (this.fopaId != null && !this.fopaId.equals(other.fopaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.FormaPago[ fopaId=" + fopaId + " ]";
    }
    
}
