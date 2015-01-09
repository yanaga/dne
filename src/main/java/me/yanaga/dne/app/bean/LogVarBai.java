package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogVarBaiPK.class)
public class LogVarBai implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer baiNu;

    @Id
    @Column(nullable = false)
    private Integer vdbNu;

    @Column(length = 72, nullable = false)
    private String vdbTx;

    public Integer getBaiNu() {
        return baiNu;
    }

    public void setBaiNu(Integer baiNu) {
        this.baiNu = baiNu;
    }

    public Integer getVdbNu() {
        return vdbNu;
    }

    public void setVdbNu(Integer vdbNu) {
        this.vdbNu = vdbNu;
    }

    public String getVdbTx() {
        return vdbTx;
    }

    public void setVdbTx(String vdbTx) {
        this.vdbTx = vdbTx;
    }

}

