/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.qly_nhanvien;
import javax.swing.JButton;

/**
 *
 * @author ivwi3
 */
public class qly_nhanvien_controller implements ActionListener{
    
    private qly_nhanvien qlyNV;
    
    public qly_nhanvien_controller() {
        
    }
    
    public qly_nhanvien_controller(qly_nhanvien qlyNV) {
        this.qlyNV = qlyNV;
    }
       
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton)e.getSource();
        String btn = src.getText();
        System.out.println(btn);
        if("Thêm mới".equals(btn)) {
            qlyNV.newNV();
        }else if("Lưu".equals(btn)) {
            qlyNV.addNV();
        }else if("Cập nhật".equals(btn)){
            qlyNV.UpdateNV();
        }else if("Xóa".equals(btn)){
            qlyNV.DeleteNV();
        }else if("Hủy".equals(btn)){
            qlyNV.Cancel();
        }else if("Tìm theo tên".equals(btn)){
            qlyNV.searchByName();
        }else if("Tìm theo phân quyền".equals(btn)){
            qlyNV.searchByPermission();
        }
    }

}
