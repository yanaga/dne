package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogVarBai implements Serializable {

    @EmbeddedId
    private LogVarBaiPK id;

    @Column(insertable = false, updatable = false)
    private Integer baiNu;

    @Column(insertable = false, updatable = false)
    private Integer vdbNu;

    @Column(length = 72, nullable = false)
    private String vdbTx;

    public LogVarBaiPK getId() {
        return id;
    }

    public void setId(LogVarBaiPK id) {
        this.id = id;
    }

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

