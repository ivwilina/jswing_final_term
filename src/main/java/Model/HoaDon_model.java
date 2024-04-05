/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connector.connect_to_mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author vugia
 */
public class HoaDon_model {
    private String mahoadon,chitiet,gia ;

    public HoaDon_model(String mahoadon, String chitiet, String gia) {
        this.mahoadon = mahoadon;
        this.chitiet = chitiet;
        this.gia = gia;
    }
    public HoaDon_model() {}

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
    Connection con = null ;
     public ResultSet timkiem() throws ClassNotFoundException, SQLException {
    con=connect_to_mysql.getConnection();
    String sql = "select * from hoadon where mahoadon like ? ";
        PreparedStatement st = con.prepareCall(sql);
        st.setString(1, "%"+mahoadon+"%");
        
        ResultSet rs = st.executeQuery();
        return rs ;
    }
    public ResultSet XoaHoaDon() throws ClassNotFoundException, SQLException {
    con=connect_to_mysql.getConnection();
    String sql = "Delete from hoadon where mahoadon = ? ";
        PreparedStatement st = con.prepareCall(sql);
        st.setString(1, "%"+mahoadon+"%");
        
        ResultSet rs = st.executeQuery();
        return rs ;
    }
}
