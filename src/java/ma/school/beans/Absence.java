/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kholo
 */
@Entity
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateAbsence;
    private String motif;
    private String justifiee;
    private String module;
    private String etudiant;

    public Absence(Date dateAbsence, String motif, String justifiee, String module, String etudiant) {
        this.dateAbsence = dateAbsence;
        this.motif = motif;
        this.justifiee = justifiee;
        this.module = module;
        this.etudiant = etudiant;
    }

 
    
    

    public Absence() {
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(Date dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getJustifiee() {
        return justifiee;
    }

    public void setJustifiee(String justifiee) {
        this.justifiee = justifiee;
    }

    public String getModule() {
        return module;
    }

    public String getEtudiant() {
        return etudiant;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setEtudiant(String etudiant) {
        this.etudiant = etudiant;
    }

}
