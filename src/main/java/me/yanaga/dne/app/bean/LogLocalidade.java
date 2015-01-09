package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogLocalidade implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer locNu;

    @Column(length = 2, nullable = false)
    private String ufeSg;

    @Column(length = 72, nullable = false)
    private String locNo;

    @Column(length = 8)
    private String cep;

    @Column(length = 1, nullable = false)
    private String locInSit;

    @Column(length = 1, nullable = false)
    private String locInTipoLoc;

    @Column
    private Integer locNuSub;

    @Column(length = 36)
    private String locNoAbrev;

    @Column(length = 7)
    private String munNu;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocInSit() {
        return locInSit;
    }

    public void setLocInSit(String locInSit) {
        this.locInSit = locInSit;
    }

    public String getLocInTipoLoc() {
        return locInTipoLoc;
    }

    public void setLocInTipoLoc(String locInTipoLoc) {
        this.locInTipoLoc = locInTipoLoc;
    }

    public String getLocNo() {
        return locNo;
    }

    public void setLocNo(String locNo) {
        this.locNo = locNo;
    }

    public String getLocNoAbrev() {
        return locNoAbrev;
    }

    public void setLocNoAbrev(String locNoAbrev) {
        this.locNoAbrev = locNoAbrev;
    }

    public Integer getLocNu() {
        return locNu;
    }

    public void setLocNu(Integer locNu) {
        this.locNu = locNu;
    }

    public Integer getLocNuSub() {
        return locNuSub;
    }

    public void setLocNuSub(Integer locNuSub) {
        this.locNuSub = locNuSub;
    }

    public String getMunNu() {
        return munNu;
    }

    public void setMunNu(String munNu) {
        this.munNu = munNu;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

}

