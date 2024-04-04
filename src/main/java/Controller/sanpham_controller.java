/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.sanpham_frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author 84334
 */
public class sanpham_controller implements ActionListener{
    sanpham_frame spv;
    public sanpham_controller(){
    
    }
    public sanpham_controller(sanpham_frame view) {
       this.spv=view;
    }
public void actionPerformed(ActionEvent e) {
        JButton src = (JButton)e.getSource();
        String btn = src.getActionCommand();
        System.out.println(btn);
        if("Thêm".equals(btn)) {
            spv.LuuLS();
        }else if("Sửa".equals(btn)) {
            spv.SuaLs();
        }else if("Xoá".equals(btn)) {
            spv.XoaLs();
        }else if("Tìm kiếm".equals(btn)) {
            spv.Timkiem();
        }
    }
    
    
}
