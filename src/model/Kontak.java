/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Kontak {
    private int id;
    private String nama;
    private String nomorTelepon;
    private String kategori;

    public Kontak(int id, String nama, String nomorTelepon, String kategori) {
        this.id = id;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.kategori = kategori;
    }

    public Kontak(String nama, String nomorTelepon, String kategori) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.kategori = kategori;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getNomorTelepon() { return nomorTelepon; }
    public String getKategori() { return kategori; }

    public void setId(int id) { this.id = id; }
    public void setNama(String nama) { this.nama = nama; }
    public void setNomorTelepon(String nomorTelepon) { this.nomorTelepon = nomorTelepon; }
    public void setKategori(String kategori) { this.kategori = kategori; }
}

