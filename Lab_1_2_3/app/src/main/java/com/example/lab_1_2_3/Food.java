package com.example.lab_1_2_3;

public class Food {
    private String ten;
    private String mota;
    private String hinhanh;
    private int gia;
    private int quantity; // Lưu trữ số lượng món ăn

    // Constructor
    public Food(String ten, String mota, String hinhanh, int gia) {
        this.ten = ten;
        this.mota = mota;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.quantity = 0; // Mặc định số lượng là 0
    }

    // Getter và Setter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Kiểm tra món ăn đã được chọn hay chưa (nếu số lượng > 0 thì món ăn đã chọn)
    public boolean isSelected() {
        return quantity > 0;
    }
}
