/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.HoaDon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author vugia
 */
public class control_hoadon implements ActionListener {
    HoaDon hoadon ;

    @Override
    public void actionPerformed(ActionEvent e) {
       JButton src = (JButton)e.getSource();
        String btn = src.getActionCommand();
        System.out.println(btn);
        if("Tìm kiếm".equals(btn)) {
            hoadon.TimKiem();
        }
        else if("Sửa".equals(btn)) {
            hoadon.XoaHoaDon();
    }
}
}
