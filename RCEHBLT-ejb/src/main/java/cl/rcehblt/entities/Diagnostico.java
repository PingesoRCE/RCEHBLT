/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByDiagnosticoid", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoid = :diagnosticoid"),
    @NamedQuery(name = "Diagnostico.findByDiagnosticoestado", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoestado = :diagnosticoestado"),
    @NamedQuery(name = "Diagnostico.findByDiagnosticofecha", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticofecha = :diagnosticofecha"),
    @NamedQuery(name = "Diagnostico.findByDiagnosticoges", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoges = :diagnosticoges")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diagnosticoid")
    private Integer diagnosticoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "diagnosticoestado")
    private String diagnosticoestado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diagnosticofecha")
    @Temporal(TemporalType.DATE)
    private Date diagnosticofecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diagnosticoges")
    private boolean diagnosticoges;
    @JoinColumn(name = "patologiaid", referencedColumnName = "patologiaid")
    @ManyToOne(optional = false)
    private Patologia patologiaid;
    @JoinColumn(name = "consultaid", referencedColumnName = "consultaid")
    @ManyToOne(optional = false)
    private Consulta consultaid;

    public Diagnostico() {
    }

    public Diagnostico(Integer diagnosticoid) {
        this.diagnosticoid = diagnosticoid;
    }

    public Diagnostico(Integer diagnosticoid, String diagnosticoestado, Date diagnosticofecha, boolean diagnosticoges) {
        this.diagnosticoid = diagnosticoid;
        this.diagnosticoestado = diagnosticoestado;
        this.diagnosticofecha = diagnosticofecha;
        this.diagnosticoges = diagnosticoges;
    }

    public Integer getDiagnosticoid() {
        return diagnosticoid;
    }

    public void setDiagnosticoid(Integer diagnosticoid) {
        this.diagnosticoid = diagnosticoid;
    }

    public String getDiagnosticoestado() {
        return diagnosticoestado;
    }

    public void setDiagnosticoestado(String diagnosticoestado) {
        this.diagnosticoestado = diagnosticoestado;
    }

    public Date getDiagnosticofecha() {
        return diagnosticofecha;
    }

    public void setDiagnosticofecha(Date diagnosticofecha) {
        this.diagnosticofecha = diagnosticofecha;
    }

    public boolean getDiagnosticoges() {
        return diagnosticoges;
    }

    public void setDiagnosticoges(boolean diagnosticoges) {
        this.diagnosticoges = diagnosticoges;
    }

    public Patologia getPatologiaid() {
        return patologiaid;
    }

    public void setPatologiaid(Patologia patologiaid) {
        this.patologiaid = patologiaid;
    }

    public Consulta getConsultaid() {
        return consultaid;
    }

    public void setConsultaid(Consulta consultaid) {
        this.consultaid = consultaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoid != null ? diagnosticoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.diagnosticoid == null && other.diagnosticoid != null) || (this.diagnosticoid != null && !this.diagnosticoid.equals(other.diagnosticoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.entities.Diagnostico[ diagnosticoid=" + diagnosticoid + " ]";
    }
    
}
