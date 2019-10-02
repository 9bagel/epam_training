package com.epam.basic_of_oop.present.wrap;

public class Basket implements Wrap {
    private String msg;
    private String materialName;

    public Basket(String msg, String materialName) {
        this.msg = msg;
        this.materialName = materialName;
    }

    @Override
    public void setName(String msg) {
        this.msg = msg;
    }

    @Override
    public void setMaterial(String materialName) {
        this.materialName = materialName;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "msg='" + msg + '\'' +
                ", materialName='" + materialName + '\'' +
                '}';
    }
}
