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
@Table(name = "ipd_ges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IpdGes.findAll", query = "SELECT i FROM IpdGes i"),
    @NamedQuery(name = "IpdGes.findByIdIpd", query = "SELECT i FROM IpdGes i WHERE i.idIpd = :idIpd"),
    @NamedQuery(name = "IpdGes.findByConfirmages", query = "SELECT i FROM IpdGes i WHERE i.confirmages = :confirmages"),
    @NamedQuery(name = "IpdGes.findByDiagnostico", query = "SELECT i FROM IpdGes i WHERE i.diagnostico = :diagnostico"),
    @NamedQuery(name = "IpdGes.findByFechalimite", query = "SELECT i FROM IpdGes i WHERE i.fechalimite = :fechalimite"),
    @NamedQuery(name = "IpdGes.findByFundamentodiagnostico", query = "SELECT i FROM IpdGes i WHERE i.fundamentodiagnostico = :fundamentodiagnostico"),
    @NamedQuery(name = "IpdGes.findByProblemaauge", query = "SELECT i FROM IpdGes i WHERE i.problemaauge = :problemaauge"),
    @NamedQuery(name = "IpdGes.findBySubproblemaauge", query = "SELECT i FROM IpdGes i WHERE i.subproblemaauge = :subproblemaauge"),
    @NamedQuery(name = "IpdGes.findByTratamientoind", query = "SELECT i FROM IpdGes i WHERE i.tratamientoind = :tratamientoind")})
public class IpdGes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ipd")
    private Integer idIpd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmages")
    private boolean confirmages;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechalimite")
    @Temporal(TemporalType.DATE)
    private Date fechalimite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fundamentodiagnostico")
    private String fundamentodiagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "problemaauge")
    private String problemaauge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subproblemaauge")
    private String subproblemaauge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tratamientoind")
    private String tratamientoind;
    @JoinColumn(name = "consultaid", referencedColumnName = "consultaid")
    @ManyToOne
    private Consulta consultaid;

    public IpdGes() {
    }

    public IpdGes(Integer idIpd) {
        this.idIpd = idIpd;
    }

    public IpdGes(Integer idIpd, boolean confirmages, String diagnostico, Date fechalimite, String fundamentodiagnostico, String problemaauge, String subproblemaauge, String tratamientoind) {
        this.idIpd = idIpd;
        this.confirmages = confirmages;
        this.diagnostico = diagnostico;
        this.fechalimite = fechalimite;
        this.fundamentodiagnostico = fundamentodiagnostico;
        this.problemaauge = problemaauge;
        this.subproblemaauge = subproblemaauge;
        this.tratamientoind = tratamientoind;
    }

    public Integer getIdIpd() {
        return idIpd;
    }

    public void setIdIpd(Integer idIpd) {
        this.idIpd = idIpd;
    }

    public boolean getConfirmages() {
        return confirmages;
    }

    public void setConfirmages(boolean confirmages) {
        this.confirmages = confirmages;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechalimite() {
        return fechalimite;
    }

    public void setFechalimite(Date fechalimite) {
        this.fechalimite = fechalimite;
    }

    public String getFundamentodiagnostico() {
        return fundamentodiagnostico;
    }

    public void setFundamentodiagnostico(String fundamentodiagnostico) {
        this.fundamentodiagnostico = fundamentodiagnostico;
    }

    public String getProblemaauge() {
        return problemaauge;
    }

    public void setProblemaauge(String problemaauge) {
        this.problemaauge = problemaauge;
    }

    public String getSubproblemaauge() {
        return subproblemaauge;
    }

    public void setSubproblemaauge(String subproblemaauge) {
        this.subproblemaauge = subproblemaauge;
    }

    public String getTratamientoind() {
        return tratamientoind;
    }

    public void setTratamientoind(String tratamientoind) {
        this.tratamientoind = tratamientoind;
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
        hash += (idIpd != null ? idIpd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpdGes)) {
            return false;
        }
        IpdGes other = (IpdGes) object;
        if ((this.idIpd == null && other.idIpd != null) || (this.idIpd != null && !this.idIpd.equals(other.idIpd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.entities.IpdGes[ idIpd=" + idIpd + " ]";
    }
    
}
