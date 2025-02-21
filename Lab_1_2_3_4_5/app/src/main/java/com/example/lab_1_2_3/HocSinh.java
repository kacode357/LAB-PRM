package com.example.lab_1_2_3;
import java.io.Serializable;

public class HocSinh implements Serializable {
    private String hoTen;
    private int namSinh;

    public HocSinh(String hoTen, int namSinh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }
}
