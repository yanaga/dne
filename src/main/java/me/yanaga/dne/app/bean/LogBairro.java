package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogBairro implements Serializable {

    public static final String FILE_NAME = "LOG_BAIRRO";

    @Id
    @Column(nullable = false)
    private Integer baiNu;

    @Column(length = 2, nullable = false)
    private String ufeSg;

    @Column(nullable = false)
    private Integer locNu;

    @Column(length = 72, nullable = false)
    private String baiNo;

    @Column(length = 36)
    private String baiNoAbrev;

    public String getBaiNo() {
        return baiNo;
    }

    public void setBaiNo(String baiNo) {
        this.baiNo = baiNo;
    }

    public String getBaiNoAbrev() {
        return baiNoAbrev;
    }

    public void setBaiNoAbrev(String baiNoAbrev) {
        this.baiNoAbrev = baiNoAbrev;
    }

    public Integer getBaiNu() {
        return baiNu;
    }

    public void setBaiNu(Integer baiNu) {
        this.baiNu = baiNu;
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

