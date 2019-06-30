package com.example.museumjakarta.model;

import java.io.Serializable;

public class Request implements Serializable {

private String nama,alamat,desk,oprasional,key;

    public Request() {
    }

    public Request(String nama, String alamat, String desk, String oprasional) {
        this.nama = nama;
        this.alamat = alamat;
        this.desk = desk;
        this.oprasional = oprasional;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getOprasional(){ return oprasional; }

    public void setOprasional(String oprasional){ this.oprasional = oprasional; }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Request{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", oprasional='" + oprasional + '\'' +
                ", desk='" + desk + '\'' +
                '}';
    }
}
