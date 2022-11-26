package com.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED not null")
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "timetoarrive", nullable = false, length = 45)
    private String timetoarrive;

    @Size(max = 45)
    @NotNull
    @Column(name = "addressofpickup", nullable = false, length = 45)
    private String addressofpickup;

    @Size(max = 45)
    @NotNull
    @Column(name = "codeshipment", nullable = false, length = 45)
    private String codeshipment;

    @Size(max = 45)
    @NotNull
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Size(max = 45)
    @NotNull
    @Column(name = "nameofdestinatary", nullable = false, length = 45)
    private String nameofdestinatary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimetoarrive() {
        return timetoarrive;
    }

    public void setTimetoarrive(String timetoarrive) {
        this.timetoarrive = timetoarrive;
    }

    public String getAddressofpickup() {
        return addressofpickup;
    }

    public void setAddressofpickup(String addressofpickup) {
        this.addressofpickup = addressofpickup;
    }

    public String getCodeshipment() {
        return codeshipment;
    }

    public void setCodeshipment(String codeshipment) {
        this.codeshipment = codeshipment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameofdestinatary() {
        return nameofdestinatary;
    }

    public void setNameofdestinatary(String nameofdestinatary) {
        this.nameofdestinatary = nameofdestinatary;
    }

    @Override
    public String toString()
    {
        return "TrackingService [id=" + id + ",timetoarrive="+timetoarrive+", addressofpickup="+addressofpickup+"," +
                " codeshipment=" + codeshipment + ", status=" + status +", nameofdestinatary="+nameofdestinatary+"]";
    }

}