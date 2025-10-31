/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DatabaseConnection;
import model.Kontak;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KontakController {

    // 🔹 Menambahkan kontak
    public void tambahKontak(Kontak kontak) {
        String sql = "INSERT INTO contacts (nama, nomor_telepon, kategori) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kontak.getNama());
            pstmt.setString(2, kontak.getNomorTelepon());
            pstmt.setString(3, kontak.getKategori());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error tambah kontak: " + e.getMessage());
        }
    }

    // 🔹 Mengedit kontak
    public void updateKontak(Kontak kontak) {
        String sql = "UPDATE contacts SET nama=?, nomor_telepon=?, kategori=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kontak.getNama());
            pstmt.setString(2, kontak.getNomorTelepon());
            pstmt.setString(3, kontak.getKategori());
            pstmt.setInt(4, kontak.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error update kontak: " + e.getMessage());
        }
    }

    // 🔹 Menghapus kontak
    public void hapusKontak(int id) {
        String sql = "DELETE FROM contacts WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error hapus kontak: " + e.getMessage());
        }
    }

    // 🔹 Menampilkan semua kontak
    public List<Kontak> getAllKontak() {
        List<Kontak> daftar = new ArrayList<>();
        String sql = "SELECT * FROM contacts ORDER BY nama ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                daftar.add(new Kontak(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("kategori")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error getAllKontak: " + e.getMessage());
        }
        return daftar;
    }

    // 🔹 Mencari kontak berdasarkan nama
    public List<Kontak> cariKontak(String keyword) {
        List<Kontak> hasil = new ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE nama LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                hasil.add(new Kontak(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("kategori")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error cari kontak: " + e.getMessage());
        }
        return hasil;
    }
}

