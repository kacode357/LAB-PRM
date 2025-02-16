package com.example.lab_1_2_3;

public class Drink {
    private String ten;
    private String mota;
    private String hinhanh;
    private int gia; // Giữ lại thuộc tính giá
    private int quantity; // Thêm thuộc tính quantity để theo dõi số lượng

    // Constructor
    public Drink(String ten, String mota, String hinhanh, int gia) {
        this.ten = ten;
        this.mota = mota;
        this.hinhanh = hinhanh;
        this.gia = gia;

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

    // Phương thức tăng số lượng
    public void incrementQuantity() {
        this.quantity++;
    }

    // Phương thức giảm số lượng
    public void decrementQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }
}
