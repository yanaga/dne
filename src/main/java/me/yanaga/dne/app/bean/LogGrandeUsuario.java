package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogGrandeUsuario implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer gruNu;

    @Column(length = 2, nullable = false)
    private String ufeSg;

    @Column(nullable = false)
    private Integer locNu;

    @Column(nullable = false)
    private Integer baiNu;

    @Column
    private Integer logNu;

    @Column(length = 72, nullable = false)
    private String gruNo;

    @Column(length = 100, nullable = false)
    private String gruEndereco;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 36)
    private String gruNoAbrev;

    public Integer getBaiNu() {
        return baiNu;
    }

    public void setBaiNu(Integer baiNu) {
        this.baiNu = baiNu;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getGruEndereco() {
        return gruEndereco;
    }

    public void setGruEndereco(String gruEndereco) {
        this.gruEndereco = gruEndereco;
    }

    public String getGruNo() {
        return gruNo;
    }

    public void setGruNo(String gruNo) {
        this.gruNo = gruNo;
    }

    public String getGruNoAbrev() {
        return gruNoAbrev;
    }

    public void setGruNoAbrev(String gruNoAbrev) {
        this.gruNoAbrev = gruNoAbrev;
    }

    public Integer getGruNu() {
        return gruNu;
    }

    public void setGruNu(Integer gruNu) {
        this.gruNu = gruNu;
    }

    public Integer getLocNu() {
        return locNu;
    }

    public void setLocNu(Integer locNu) {
        this.locNu = locNu;
    }

    public Integer getLogNu() {
        return logNu;
    }

    public void setLogNu(Integer logNu) {
        this.logNu = logNu;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

}

