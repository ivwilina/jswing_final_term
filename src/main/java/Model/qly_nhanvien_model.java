/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import Connector.connect_to_mysql;
import java.sql.PreparedStatement;
/**
 *
 * @author ivwi3
 */
public class qly_nhanvien_model {
    private String ten,sdt,username,password,phanquyen;
    private Connection con = null;
    public qly_nhanvien_model() {
    }

    public qly_nhanvien_model(String ten, String sdt, String username, String password, String phanquyen) {
        this.ten = ten;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.phanquyen = phanquyen;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhanquyen() {
        return phanquyen;
    }
    
    public ResultSet timkiem() {
        ResultSet rs = null;
        try {
            con = connect_to_mysql.getConnection();
            String sql = "select * from chucvu where ten like ? and phanquyen like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+ten+"%");
            st.setString(2, "%"+phanquyen+"%");
            rs = st.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return rs;
    }
    
    public void createNV(){
        try {
            con = connect_to_mysql.getConnection();
            String sql = "insert into chucvu values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ten);
            st.setString(2, sdt);
            st.setString(3, phanquyen);
            st.setString(4, username);
            st.setString(5, password);
            st.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
    public void updateNV(){
        try {
            con = connect_to_mysql.getConnection();
            String sql = "update chucvu set ten=?,sdt=?,phanquyen=?,pass=? where user=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ten);
            st.setString(2, sdt);
            st.setString(3, phanquyen);
            st.setString(5, username);
            st.setString(4, password);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteNV(){
        try {
            con = connect_to_mysql.getConnection();
            String sql = "delete from chucvu where user=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public ResultSet timkiemtheoten() {
        ResultSet rs = null;
        try {
            con = connect_to_mysql.getConnection();
            String sql = "select * from chucvu where ten like ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+ten+"%");
            rs = st.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return rs;
    }
    
    public ResultSet timkiemtheophanquyen() {
        ResultSet rs = null;
        try {
            con = connect_to_mysql.getConnection();
            String sql = "select * from chucvu where phanquyen like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+phanquyen+"%");
            rs = st.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return rs;
    }
}
