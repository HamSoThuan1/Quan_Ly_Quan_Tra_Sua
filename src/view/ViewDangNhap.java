/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import entity.setDangNhap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Nhanvien;
import repository.DangNhap_responsitory;
import service.GiaoCa_service;
import service.nhanvien_service;
import serviceimql.DangNhap_servicesimpl;
import serviceimql.GiaoCa_serviceimpl;
import serviceimql.Nhanvien_serviceimpl;
import viewModel.GiaoCaViewModel;

/**
 *
 * @author Acer
 */
public class ViewDangNhap extends javax.swing.JFrame {
    private List<Nhanvien> list=new ArrayList<>();
    private List<GiaoCaViewModel> listgcvm = new ArrayList<>();
    
    private nhanvien_service nvservice = new Nhanvien_serviceimpl();
    private GiaoCa_service gcservice = new GiaoCa_serviceimpl();
    
//    private DangNhap_servicesimpl dangNhap_services;

    /**
     * Creates new form ViewDangNhap
     */
    public ViewDangNhap() {
        initComponents();
        setLocationRelativeTo(null);
//        dangNhap_services = new DangNhap_servicesimpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_TenDangNhap = new javax.swing.JTextField();
        pw_MatKhau = new javax.swing.JPasswordField();
        cb_HienThi = new javax.swing.JCheckBox();
        btn_DoiMatKhau = new javax.swing.JButton();
        btn_DangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Đăng Nhập");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mật Khẩu");

        cb_HienThi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_HienThi.setText("Hiện Thị Mật Khẩu");
        cb_HienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_HienThiMouseClicked(evt);
            }
        });

        btn_DoiMatKhau.setBackground(new java.awt.Color(255, 0, 51));
        btn_DoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_DoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btn_DoiMatKhau.setText("Đổi Mật Khẩu");
        btn_DoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoiMatKhauActionPerformed(evt);
            }
        });

        btn_DangNhap.setBackground(new java.awt.Color(255, 0, 51));
        btn_DangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangNhap.setText("Đăng Nhập");
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trasuaxoaphong.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        btn_Thoat.setBackground(new java.awt.Color(255, 0, 51));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 255, 255));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_HienThi)
                            .addComponent(pw_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txt_TenDangNhap))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btn_DoiMatKhau)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Thoat)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pw_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_HienThi)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_DoiMatKhau)
                            .addComponent(btn_DangNhap)
                            .addComponent(btn_Thoat)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void btn_DoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoiMatKhauActionPerformed
        // TODO add your handling code here:
        ViewDoiMatKhau view = new ViewDoiMatKhau();
        view.setVisible(true);
    }//GEN-LAST:event_btn_DoiMatKhauActionPerformed

    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed
        // TODO add your handling code here:
        DangNhap();
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    private void cb_HienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_HienThiMouseClicked
        // TODO add your handling code here:
        if (cb_HienThi.isSelected()) {
            pw_MatKhau.setEchoChar((char) 0);
        } else {
            pw_MatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_HienThiMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDangNhap().setVisible(true);
            }
        });
    }

    public void DangNhap() {
        String maNV = txt_TenDangNhap.getText();
        String matKhau = new String(pw_MatKhau.getPassword());
        if(maNV.equals("")){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            txt_TenDangNhap.requestFocus();
            return;
        }
        if(pw_MatKhau.equals("")){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            pw_MatKhau.requestFocus();
            return;
        }
        Nhanvien nv = nvservice.getNVByMaVaMatKhau(maNV,matKhau);
        if(nv==null){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại");
            return;
        }
        String idnhanvien = nv.getID();
        Date dt = new Date();
        int stt =gcservice.getAllGiaoCaViewModel().size()+1;
        String maca = "CA"+stt;
        double SoTienBanDau = 1000000;
        GiaoCaViewModel gcvm = new GiaoCaViewModel(maca, dt, SoTienBanDau, idnhanvien);
        gcservice.add(gcvm);
        this.dispose();
        listgcvm=(List<GiaoCaViewModel>) gcservice.getAllGiaoCaViewModel();
        String mac=listgcvm.get(listgcvm.size()-1).getMaca();
        ViewXacNhanGiaoCa v = new ViewXacNhanGiaoCa(mac);
//        ViewXacNhanGiaoCa v = new ViewXacNhanGiaoCa(idnhanvien);
        v.setVisible(true);
        System.out.println(mac);
        
        
        
        
        
        



//        setDangNhap.user = dangNhap_services.getOne(maNV, matKhau);
//        if (maNV.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Tên đăng nhập không được để trống");
//        } else if (matKhau.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
//        } else if (setDangNhap.user != null) {
//            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
//            ViewChinh view = new ViewChinh();
//            view.setVisible(true);
//            this.dispose();
//        } else {
//            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng");
//        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JButton btn_DoiMatKhau;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JCheckBox cb_HienThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pw_MatKhau;
    private javax.swing.JTextField txt_TenDangNhap;
    // End of variables declaration//GEN-END:variables
}
