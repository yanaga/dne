package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogCpc implements Serializable {

    public static final String FILE_NAME = "LOG_CPC";
    @Id
    @Column(nullable = false)
    private Integer cpcNu;

    @Column(length = 2, nullable = false)
    private String ufeSg;

    @Column(nullable = false)
    private Integer locNu;

    @Column(length = 72, nullable = false)
    private String cpcNo;

    @Column(length = 100, nullable = false)
    private String cpcEndereco;

    @Column(length = 8, nullable = false)
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpcEndereco() {
        return cpcEndereco;
    }

    public void setCpcEndereco(String cpcEndereco) {
        this.cpcEndereco = cpcEndereco;
    }

    public String getCpcNo() {
        return cpcNo;
    }

    public void setCpcNo(String cpcNo) {
        this.cpcNo = cpcNo;
    }

    public Integer getCpcNu() {
        return cpcNu;
    }

    public void setCpcNu(Integer cpcNu) {
        this.cpcNu = cpcNu;
    }

    public Integer getLocNu() {
        return locNu;
    }

    public void setLocNu(Integer locNu) {
        this.locNu = locNu;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

}

