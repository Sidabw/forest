package com.beta.widgets.gp.dao;

import java.io.Serializable;

public class BlobTestEntity implements Serializable {
    private Integer id;

    private String imageName;

    private byte[] imageBin;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public byte[] getImageBin() {
        return imageBin;
    }

    public void setImageBin(byte[] imageBin) {
        this.imageBin = imageBin;
    }
}