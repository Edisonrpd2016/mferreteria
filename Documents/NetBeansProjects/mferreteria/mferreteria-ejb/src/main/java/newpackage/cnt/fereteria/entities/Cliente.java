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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClieId", query = "SELECT c FROM Cliente c WHERE c.clieId = :clieId"),
    @NamedQuery(name = "Cliente.findByClieNombre", query = "SELECT c FROM Cliente c WHERE c.clieNombre = :clieNombre"),
    @NamedQuery(name = "Cliente.findByClieApellido", query = "SELECT c FROM Cliente c WHERE c.clieApellido = :clieApellido"),
    @NamedQuery(name = "Cliente.findByClieCedula", query = "SELECT c FROM Cliente c WHERE c.clieCedula = :clieCedula"),
    @NamedQuery(name = "Cliente.findByClieDireccion", query = "SELECT c FROM Cliente c WHERE c.clieDireccion = :clieDireccion"),
    @NamedQuery(name = "Cliente.findByClieTelefono", query = "SELECT c FROM Cliente c WHERE c.clieTelefono = :clieTelefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clie_id")
    private Integer clieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "clie_nombre")
    private String clieNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "clie_apellido")
    private String clieApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clie_cedula")
    private String clieCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "clie_direccion")
    private String clieDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clie_telefono")
    private String clieTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clieId")
    private List<Venta> ventaList;

    public Cliente() {
    }

    public Cliente(Integer clieId) {
        this.clieId = clieId;
    }

    public Cliente(Integer clieId, String clieNombre, String clieApellido, String clieCedula, String clieDireccion, String clieTelefono) {
        this.clieId = clieId;
        this.clieNombre = clieNombre;
        this.clieApellido = clieApellido;
        this.clieCedula = clieCedula;
        this.clieDireccion = clieDireccion;
        this.clieTelefono = clieTelefono;
    }

    public Integer getClieId() {
        return clieId;
    }

    public void setClieId(Integer clieId) {
        this.clieId = clieId;
    }

    public String getClieNombre() {
        return clieNombre;
    }

    public void setClieNombre(String clieNombre) {
        this.clieNombre = clieNombre;
    }

    public String getClieApellido() {
        return clieApellido;
    }

    public void setClieApellido(String clieApellido) {
        this.clieApellido = clieApellido;
    }

    public String getClieCedula() {
        return clieCedula;
    }

    public void setClieCedula(String clieCedula) {
        this.clieCedula = clieCedula;
    }

    public String getClieDireccion() {
        return clieDireccion;
    }

    public void setClieDireccion(String clieDireccion) {
        this.clieDireccion = clieDireccion;
    }

    public String getClieTelefono() {
        return clieTelefono;
    }

    public void setClieTelefono(String clieTelefono) {
        this.clieTelefono = clieTelefono;
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
        hash += (clieId != null ? clieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clieId == null && other.clieId != null) || (this.clieId != null && !this.clieId.equals(other.clieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.cnt.fereteria.entities.Cliente[ clieId=" + clieId + " ]";
    }
    
}
