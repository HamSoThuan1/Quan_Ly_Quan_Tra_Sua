/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import java.sql.*;
import serviceimql.KhachHang_serviceimpl;

/**
 *
 * @author 84337
 */
public class ViewQuanLyKhachHang extends javax.swing.JPanel {

    private List<KhachHang> listkh = new ArrayList<>();
    private KhachHang_serviceimpl khsv = new KhachHang_serviceimpl();
    private DefaultTableModel tblmodel = new DefaultTableModel();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form ViewQuanLyKhachHang
     */
    public ViewQuanLyKhachHang() {

        initComponents();
        loadtable(khsv.GetallKH());

    }

    public void updateKhachHang() throws ParseException {
        KhachHang kh = new KhachHang();
        String ma = txtma.getText();
        kh.setMakh(ma);
        kh.setTenkh(txtten.getText());
        boolean giotinh = kh.isGioitinh();
        if (rdonam.isSelected()) {
            kh.setGioitinh(true);
        }
        if (rdonu.isSelected()) {
            kh.setGioitinh(false);
        }
        kh.setSodt(txtso.getText());
        kh.setDiachi(txtdiachi.getText());
        kh.setGhichu(txtghichu.getText());
        int trangthai = kh.getTrangthai();
        if (rdoon.isSelected()) {
            kh.setTrangthai(0);
        }
        if (rdooff.isSelected()) {
            kh.setTrangthai(1);
        }
        JOptionPane.showMessageDialog(this, khsv.updateKH(kh, ma));
        listkh = khsv.GetallKH();
        loadtable(listkh);
    }

    public void ADD() throws ParseException {
        KhachHang kh = new KhachHang();
        kh.setMakh(txtma.getText());
        kh.setTenkh(txtten.getText());
        boolean giotinh = kh.isGioitinh();
        if (rdonam.isSelected()) {
            kh.setGioitinh(true);
        }
        if (rdonu.isSelected()) {
            kh.setGioitinh(false);
        }
        kh.setSodt(txtso.getText());
        kh.setDiachi(txtdiachi.getText());
        kh.setGhichu(txtghichu.getText());
        int trangthai = kh.getTrangthai();
        if (rdoon.isSelected()) {
            kh.setTrangthai(0);
        }
        if (rdooff.isSelected()) {
            kh.setTrangthai(1);
        }
        JOptionPane.showMessageDialog(this, khsv.add(kh));
        listkh = khsv.GetallKH();
        loadtable(listkh);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        soDT = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        txtdiachi = new javax.swing.JTextField();
        txtghichu = new javax.swing.JTextField();
        rdoon = new javax.swing.JRadioButton();
        rdooff = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtso = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_timKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkhachang = new javax.swing.JTable();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("KHÁCH HÀNG");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Makh");

        jLabel4.setText("HoTenKH");

        jLabel5.setText("giới tính");

        soDT.setText("địa chỉ");

        jLabel8.setText("ghi chú");

        jLabel9.setText("trạng thái");

        txtten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenActionPerformed(evt);
            }
        });

        rdonam.setSelected(true);
        rdonam.setText("nam");

        rdonu.setText("nữ");

        rdoon.setText("online");

        rdooff.setText("off");

        jLabel3.setText("SoDT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(54, 54, 54)
                        .addComponent(rdoon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdooff, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(soDT)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdonam, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(rdonu, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txtghichu, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdonam)
                    .addComponent(rdonu))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDT))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoon)
                        .addComponent(rdooff)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_timKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timKiemMouseClicked(evt);
            }
        });
        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        tblkhachang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MaKH", "HoTenKH", "Giới tính", "SoDT", "Địa chỉ", "Ghi chú", "Trạng thái"
            }
        ));
        tblkhachang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkhachang);

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(104, 104, 104))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblkhachangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachangMouseClicked
        // TODO add your handling code here:
//        DefaultTableModel dtm = (DefaultTableModel) tblkhachang.getModel();
//        int row=tblkhachang.getSelectedRow();
//        txtma.setText(dtm.getValueAt(row,0).toString());
//        txtten.setText(dtm.getValueAt(row,1).toString());
////        if (tblkhachang.getValueAt(index, 2)) {
//            
//        } else {
//        }
        Showdetail();
    }//GEN-LAST:event_tblkhachangMouseClicked

    private void txttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        try {
            ADD();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        try {
            updateKhachHang();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        String MaKH = txtma.getText();
        JOptionPane.showMessageDialog(this, khsv.deleteKH(MaKH));
        listkh = khsv.GetallKH();
        loadtable(listkh);
    }//GEN-LAST:event_btnxoaActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_timKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timKiemMouseClicked
        // TODO add your handling code here:
           String ten = txt_timKiem.getText();
        String sdt = txtso.getText();
        List<KhachHang> list1 = khsv.searchByname(ten);
        List<KhachHang> list2 = khsv.searchBysdt(sdt);
        showData(list1);
        showData(list2);
    }//GEN-LAST:event_txt_timKiemMouseClicked

    private void Showdetail() {
//        KhachHang kh= listkh.get(index);
//      txtma.setText(kh.getMakh());
//      txtten.setText(kh.getTenkh());
//      rdonam.setSelected(kh.isGioitinh());
//      rdonu.setSelected(kh.isGioitinh());
//      txtngay.setText(kh.getNgaysinh()+"");
//      txtdiachi.setText(kh.getDiachi());
//      txtghichu.setText(kh.getGhichu());
//      cbott.setSelectedItem(kh.getTrangthai());

        DefaultTableModel dtm = (DefaultTableModel) tblkhachang.getModel();
        int row = tblkhachang.getSelectedRow();
        txtma.setText(dtm.getValueAt(row, 0).toString());
        txtten.setText(dtm.getValueAt(row, 1).toString());

        if (dtm.getValueAt(row, 2).toString().equalsIgnoreCase("nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        txtso.setText(dtm.getValueAt(row, 4).toString());
        txtdiachi.setText(dtm.getValueAt(row, 5).toString());
        txtghichu.setText(dtm.getValueAt(row, 6).toString());
        if (dtm.getValueAt(row, 7).toString().equalsIgnoreCase("nam")) {
            rdoon.setSelected(true);
        } else {
            rdooff.setSelected(true);
        }

    }
     public void showData(List<KhachHang> list) {
        tblmodel.setRowCount(0);
        int stt = 1;
        for (KhachHang khachHang : list) {
            tblmodel.addRow(new Object[]{
                khachHang.getMakh(),
                khachHang.getTenkh(),
                khachHang.isGioitinh() == true ? "Nam" : "Nữ",
                khachHang.getSodt(),
                khachHang.getDiachi(),
                khachHang.getGhichu(),
                khachHang.getTrangthai()
            });
        }
    }

    private void loadtable(List<KhachHang> listkh) {
        tblmodel = (DefaultTableModel) tblkhachang.getModel();
        tblmodel.setRowCount(0);
        for (KhachHang kh : listkh) {
            String gt = kh.isGioitinh() == false ? "nam" : "nữ";
            String tt = kh.getTrangthai() == 1 ? "online" : "off";
            tblmodel.addRow(new Object[]{
                kh.getMakh(), kh.getTenkh(), gt, kh.getSodt(), kh.getDiachi(), kh.getGhichu(), tt
            }
            );

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JRadioButton rdooff;
    private javax.swing.JRadioButton rdoon;
    private javax.swing.JLabel soDT;
    private javax.swing.JTable tblkhachang;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtso;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables

}
