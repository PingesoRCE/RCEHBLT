/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByConsultaid", query = "SELECT c FROM Consulta c WHERE c.consultaid = :consultaid"),
    @NamedQuery(name = "Consulta.findByCancelada", query = "SELECT c FROM Consulta c WHERE c.cancelada = :cancelada"),
    @NamedQuery(name = "Consulta.findByConsultafecha", query = "SELECT c FROM Consulta c WHERE c.consultafecha = :consultafecha"),
    @NamedQuery(name = "Consulta.findByEstado", query = "SELECT c FROM Consulta c WHERE c.estado = :estado"),
    @NamedQuery(name = "Consulta.findByExploracionFisica", query = "SELECT c FROM Consulta c WHERE c.exploracionFisica = :exploracionFisica"),
    @NamedQuery(name = "Consulta.findByHdiagnostica", query = "SELECT c FROM Consulta c WHERE c.hdiagnostica = :hdiagnostica"),
    @NamedQuery(name = "Consulta.findByMotivoConsulta", query = "SELECT c FROM Consulta c WHERE c.motivoConsulta = :motivoConsulta"),
    @NamedQuery(name = "Consulta.findByMotivocancel", query = "SELECT c FROM Consulta c WHERE c.motivocancel = :motivocancel"),
    @NamedQuery(name = "Consulta.findByNotas", query = "SELECT c FROM Consulta c WHERE c.notas = :notas"),
    @NamedQuery(name = "Consulta.findByPausada", query = "SELECT c FROM Consulta c WHERE c.pausada = :pausada")})
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consultaid")
    private Integer consultaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancelada")
    private boolean cancelada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consultafecha")
    @Temporal(TemporalType.DATE)
    private Date consultafecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "exploracion_fisica")
    private String exploracionFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hdiagnostica")
    private String hdiagnostica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "motivo_consulta")
    private String motivoConsulta;
    @Size(max = 255)
    @Column(name = "motivocancel")
    private String motivocancel;
    @Size(max = 255)
    @Column(name = "notas")
    private String notas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pausada")
    private boolean pausada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultaid")
    private Collection<Anamnesis2> anamnesis2Collection;
    @JoinColumn(name = "episodioid", referencedColumnName = "episodioid")
    @ManyToOne(optional = false)
    private Episodios episodioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultaid")
    private Collection<Diagnostico> diagnosticoCollection;
    @OneToMany(mappedBy = "consultaid")
    private Collection<Prescription> prescriptionCollection;
    @OneToMany(mappedBy = "consultaid")
    private Collection<IpdGes> ipdGesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultaid")
    private Collection<Solicitudexamen> solicitudexamenCollection;
    @OneToMany(mappedBy = "consultaid")
    private Collection<ConsentimientoGes> consentimientoGesCollection;

    public Consulta() {
    }

    public Consulta(Integer consultaid) {
        this.consultaid = consultaid;
    }

    public Consulta(Integer consultaid, boolean cancelada, Date consultafecha, String estado, String hdiagnostica, String motivoConsulta, boolean pausada) {
        this.consultaid = consultaid;
        this.cancelada = cancelada;
        this.consultafecha = consultafecha;
        this.estado = estado;
        this.hdiagnostica = hdiagnostica;
        this.motivoConsulta = motivoConsulta;
        this.pausada = pausada;
    }

    public Integer getConsultaid() {
        return consultaid;
    }

    public void setConsultaid(Integer consultaid) {
        this.consultaid = consultaid;
    }

    public boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Date getConsultafecha() {
        return consultafecha;
    }

    public void setConsultafecha(Date consultafecha) {
        this.consultafecha = consultafecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getExploracionFisica() {
        return exploracionFisica;
    }

    public void setExploracionFisica(String exploracionFisica) {
        this.exploracionFisica = exploracionFisica;
    }

    public String getHdiagnostica() {
        return hdiagnostica;
    }

    public void setHdiagnostica(String hdiagnostica) {
        this.hdiagnostica = hdiagnostica;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getMotivocancel() {
        return motivocancel;
    }

    public void setMotivocancel(String motivocancel) {
        this.motivocancel = motivocancel;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public boolean getPausada() {
        return pausada;
    }

    public void setPausada(boolean pausada) {
        this.pausada = pausada;
    }

    @XmlTransient
    public Collection<Anamnesis2> getAnamnesis2Collection() {
        return anamnesis2Collection;
    }

    public void setAnamnesis2Collection(Collection<Anamnesis2> anamnesis2Collection) {
        this.anamnesis2Collection = anamnesis2Collection;
    }

    public Episodios getEpisodioid() {
        return episodioid;
    }

    public void setEpisodioid(Episodios episodioid) {
        this.episodioid = episodioid;
    }

    @XmlTransient
    public Collection<Diagnostico> getDiagnosticoCollection() {
        return diagnosticoCollection;
    }

    public void setDiagnosticoCollection(Collection<Diagnostico> diagnosticoCollection) {
        this.diagnosticoCollection = diagnosticoCollection;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
    }

    @XmlTransient
    public Collection<IpdGes> getIpdGesCollection() {
        return ipdGesCollection;
    }

    public void setIpdGesCollection(Collection<IpdGes> ipdGesCollection) {
        this.ipdGesCollection = ipdGesCollection;
    }

    @XmlTransient
    public Collection<Solicitudexamen> getSolicitudexamenCollection() {
        return solicitudexamenCollection;
    }

    public void setSolicitudexamenCollection(Collection<Solicitudexamen> solicitudexamenCollection) {
        this.solicitudexamenCollection = solicitudexamenCollection;
    }

    @XmlTransient
    public Collection<ConsentimientoGes> getConsentimientoGesCollection() {
        return consentimientoGesCollection;
    }

    public void setConsentimientoGesCollection(Collection<ConsentimientoGes> consentimientoGesCollection) {
        this.consentimientoGesCollection = consentimientoGesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaid != null ? consultaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.consultaid == null && other.consultaid != null) || (this.consultaid != null && !this.consultaid.equals(other.consultaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.entities.Consulta[ consultaid=" + consultaid + " ]";
    }
    
}
