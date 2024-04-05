/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connector.connect_to_mysql;
import View.sanpham_frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author 84334
 */
public class sanpham {
    private String masp, tensp, hang, gia, mota;
    public Connection con = null;
    public sanpham(){
        
    }
    public  Map<String, String> map_hangsp = new HashMap<>();
    public  Map<String, String> map_hangsp2 = new HashMap<>();
    public sanpham(String masp, String tensp, String hang, String gia, String mota) {
        this.masp = masp;
        this.tensp = tensp;
        this.hang = hang;
        this.gia = gia;
        this.mota = mota;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    public ResultSet Timkiemls() {
        ResultSet rs = null;
        try {
            con = connect_to_mysql.getConnection();
            String sql="Select * from sanpham where masp like ? and tensp like ?";
            PreparedStatement PreSt = con.prepareStatement(sql);
            PreSt.setString(1, "%"+masp+"%");
            PreSt.setString(2, "%"+tensp+"%");
            rs = PreSt.executeQuery();
            return rs;
        } catch (Exception e) {
            
        }
        return rs;
    }
    
    private void check_valid(String ms) {
        try {
            String valid="";
           con = connect_to_mysql.getConnection();
            
            String sqlQueryGetSach="Select * from sanpham where masp='"+ms+"'";
            Statement st=con.createStatement();
            
            ResultSet rs=st.executeQuery(sqlQueryGetSach);
            while(rs.next()) {
                valid = rs.getString(1);
            }
            if(valid.length()!=0) {
//                JOptionPane.showMessageDialog(sanpham_, "Trùng mã sp");
            }
        } catch (Exception e) {
        }
    }
    public  void TimLs(){
        try{
        con=connect_to_mysql.getConnection();
        String sql = "SELECT * from sanpham WHERE masp like ? and tensp like ?";
         PreparedStatement PreSt = con.prepareStatement(sql);
         PreSt.setString(1, masp);
         PreSt.setString(2, tensp);
         PreSt.executeUpdate();
        }catch(Exception e) {
            
        }
    }
    public void LuuLs() {
            con=connect_to_mysql.getConnection();
    try {
            String sql = "Insert into sanpham values(?,?,?,?,?)";
            PreparedStatement PreSt = con.prepareStatement(sql);
            PreSt.setString(1, masp);
            PreSt.setString(2, tensp);
            PreSt.setString(3, hang);
            PreSt.setString(4, gia);
            PreSt.setString(5, mota);
            PreSt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void SuaLs() {
        try {
            con=connect_to_mysql.getConnection();
            String sql = "Update sanpham set tensp=?, hang=?, gia=?, mota=? WHERE masp=?";
            PreparedStatement PreSt = con.prepareStatement(sql);
            PreSt.setString(1, tensp);
            PreSt.setString(2, hang);
            PreSt.setString(3, gia);
            PreSt.setString(4, mota);
            PreSt.setString(5, masp);
            PreSt.executeUpdate();        
        } catch (Exception e) {
            
        }
    }
    public void XoaLs() {
        try {
            con=connect_to_mysql.getConnection();
            String sql = "DELETE from sanpham WHERE masp=N'"+masp+"'";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
}
