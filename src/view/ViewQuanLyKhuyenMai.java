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
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
import service.KhuyenMai_service;
import serviceimql.KhuyenMai_serviceimpl;

/**
 *
 * @author hung2
 */
public class ViewQuanLyKhuyenMai extends javax.swing.JPanel {

    private List<KhuyenMai> listKM = new ArrayList<>();
    private KhuyenMai_service KMSer = new KhuyenMai_serviceimpl();
    DefaultTableModel mol;

    public ViewQuanLyKhuyenMai() {
        initComponents();
        fillTableKM();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTimKM = new javax.swing.JTextField();
        btnTimKM = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboLocLoaiKM = new javax.swing.JComboBox<>();
        cboLocTT = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtMaKM = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        txtGiatri = new javax.swing.JTextField();
        txtNgayBD = new javax.swing.JTextField();
        txtNgayKT = new javax.swing.JTextField();
        rdoPT = new javax.swing.JRadioButton();
        rdoTienmat = new javax.swing.JRadioButton();
        cboTT = new javax.swing.JComboBox<>();
        btnDel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1013, 746));

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Loại KM", "Giá trị", "Trạng thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKM);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Tìm khuyến mãi");

        txtTimKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKMActionPerformed(evt);
            }
        });

        btnTimKM.setText("Tìm");
        btnTimKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKMMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Loại khuyến mãi");

        cboLocLoaiKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "Tiền mặt" }));
        cboLocLoaiKM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocLoaiKMItemStateChanged(evt);
            }
        });

        cboLocTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động", " " }));
        cboLocTT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocTTItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Trạng thái");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã khuyến mãi");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên khuyến mãi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Loại khuyến mãi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá trị");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ngày bắt đầu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày kết thúc");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Trạng thái");

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoPT);
        rdoPT.setSelected(true);
        rdoPT.setText("%");

        buttonGroup1.add(rdoTienmat);
        rdoTienmat.setText("Tiền mặt");

        cboTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động" }));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaKM))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNgayKT))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNgayBD))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtGiatri))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenKM)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdoPT)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoTienmat)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cboTT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoPT)
                    .addComponent(rdoTienmat))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiatri, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDel, btnUpdate});

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lí khuyến mãi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimKM))
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLocLoaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLocTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(9, 9, 9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboLocLoaiKM, jLabel10});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKM)
                            .addComponent(cboLocLoaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboLocTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMMouseClicked
        // TODO add your handling code here:
        int index = tblKM.getSelectedRow();
        mol = (DefaultTableModel) tblKM.getModel();
        String mak = mol.getValueAt(index,0).toString();
        KhuyenMai km = KMSer.getKMByMa(mak);
        showdetail(km);
    }//GEN-LAST:event_tblKMMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        KhuyenMai km = null;          
        try {
            km = getKMByForm();
            KMSer.add(km);
            fillTableKM();
            clearForm();
        } catch (ParseException ex) {
            Logger.getLogger(ViewQuanLyKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            KhuyenMai km = getKMByForm();
            KMSer.update(km);
            fillTableKM();
            clearForm();
        } catch (ParseException ex) {
            Logger.getLogger(ViewQuanLyKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            KhuyenMai km = getKMByForm();
            KMSer.delete(km);
            fillTableKM();
            clearForm();
        } catch (ParseException ex) {
            Logger.getLogger(ViewQuanLyKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void cboLocLoaiKMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocLoaiKMItemStateChanged
        // TODO add your handling code here:
        if(cboLocLoaiKM.getItemCount() > 0){
            String mak = cboLocLoaiKM.getSelectedItem().toString();
            KhuyenMai km = KMSer.getKMByMa(mak);
            fillTableKM(mak);
        }
    }//GEN-LAST:event_cboLocLoaiKMItemStateChanged

    private void cboLocTTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocTTItemStateChanged
        // TODO add your handling code here:
        int i;
        if(cboLocTT.getItemCount() > 0){
            String trangthai=cboLocTT.getSelectedItem().toString();
            if(trangthai.equalsIgnoreCase("Đang hoạt động")){
                i=0;
            }else{
                i=1;
            }
            List<KhuyenMai> km = KMSer.getKMByTrangthai(i);
            System.out.println(km);
//            fillTableKMByTT(km);
        }
    }//GEN-LAST:event_cboLocTTItemStateChanged

    private void btnTimKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKMMouseClicked
        // TODO add your handling code here:
        String ma = txtTimKM.getText();
        fillTableMa(ma);
    }//GEN-LAST:event_btnTimKMMouseClicked

    private void txtTimKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnTimKM;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboLocLoaiKM;
    private javax.swing.JComboBox<String> cboLocTT;
    private javax.swing.JComboBox<String> cboTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoPT;
    private javax.swing.JRadioButton rdoTienmat;
    private javax.swing.JTable tblKM;
    private javax.swing.JTextField txtGiatri;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayKT;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTimKM;
    // End of variables declaration//GEN-END:variables

    private void fillTableKM() {
        listKM = KMSer.getAllKM();
        mol = (DefaultTableModel) tblKM.getModel();
        mol.setRowCount(0);
        for (int i = 0; i < listKM.size(); i++) {
            String tt = null;
            if (listKM.get(i).getTrangthai() == 0) {
                tt = "Đang hoạt động";
            } else if (listKM.get(i).getTrangthai() == 1) {
                tt = "Dừng hoạt động";
            }
            Object[] data = new Object[]{
                listKM.get(i).getMaKM(), listKM.get(i).getTenKM(), listKM.get(i).getLoaiKM(), listKM.get(i).getGiatri(), tt
            };
            mol.addRow(data);
        }
    }
    
    private void fillTableKM(String makm) {
        listKM = KMSer.getKMByMaKM(makm);
        mol = (DefaultTableModel) tblKM.getModel();
        mol.setRowCount(0);
        for (int i = 0; i < listKM.size(); i++) {
            String tt = null;
            if (listKM.get(i).getTrangthai() == 0) {
                tt = "Đang hoạt động";
            } else if (listKM.get(i).getTrangthai() == 1) {
                tt = "Dừng hoạt động";
            }
            Object[] data = new Object[]{
                listKM.get(i).getMaKM(), listKM.get(i).getTenKM(), listKM.get(i).getLoaiKM(), listKM.get(i).getGiatri(), tt
            };
            mol.addRow(data);
        }
    }
    
    private void fillTableMa(String mak) {
        listKM.removeAll(listKM);
        KhuyenMai km = KMSer.getKMByMa(mak);
        listKM.add(km);
        mol = (DefaultTableModel) tblKM.getModel();
        mol.setRowCount(0);
        for (int i = 0; i < listKM.size(); i++) {
            String tt = null;
            if (listKM.get(i).getTrangthai() == 0) {
                tt = "Đang hoạt động";
            } else if (listKM.get(i).getTrangthai() == 1) {
                tt = "Dừng hoạt động";
            }
            Object[] data = new Object[]{
                listKM.get(i).getMaKM(), listKM.get(i).getTenKM(), listKM.get(i).getLoaiKM(), listKM.get(i).getGiatri(), tt
            };
            mol.addRow(data);
        }
    }
    

    private void showdetail(KhuyenMai km) {
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        if (km.getLoaiKM().equals("%")) {
            rdoPT.setSelected(true);
        } else if (km.getLoaiKM().equals("Tiền mặt")) {
            rdoTienmat.setSelected(true);
        }
        txtGiatri.setText(km.getGiatri() + "");
        txtNgayBD.setText(km.getNgayBD() + "");
        txtNgayKT.setText(km.getNgayKT() + "");
        String tt = null;
        if (km.getTrangthai() == 0) {
            tt = "Đang hoạt động";
        } else if (km.getTrangthai() == 1) {
            tt = "Ngừng hoạt động";
        }
        cboTT.setSelectedItem(tt);
    }
    
    public KhuyenMai getKMByForm() throws ParseException {
        String makm = txtMaKM.getText();
        String tenkm = txtTenKM.getText();
        String loai =  rdoPT.isSelected() ? "%":"Tiền mặt";
        int gtri = Integer.parseInt(txtGiatri.getText());
//        String ngaybd = txtNgayBD.getText();
        Date nbd = new SimpleDateFormat("yyyy-MM-dd").parse(txtNgayBD.getText());
//        String ngaykt = txtNgayKT.getText();
        Date nkt = new SimpleDateFormat("yyyy-MM-dd").parse(txtNgayKT.getText());
        
//        String tthai = cboTT.getSelectedItem().toString();
        int tthai;
        String tt= (String) cboTT.getSelectedItem();
        if(tt.equals("Đang hoạt động")){
            tthai=0;
        }else {
            tthai=1;
        }
        return new KhuyenMai(makm, tenkm, nbd, nkt, loai, gtri, tthai);
    }
    
    public void clearForm() {
        txtMaKM.setText("");
        txtTenKM.setText("");
        txtGiatri.setText("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");
    }

//    private void fillTableKMByTT(KhuyenMai km) {
//        listKM = KMSer.getKMByTrangthai(km);
//        mol = (DefaultTableModel) tblKM.getModel();
//        mol.setRowCount(0);
//        for (int i = 0; i < listKM.size(); i++) {
//            String tt = null;
//            if (listKM.get(i).getTrangthai() == 0) {
//                tt = "Đang hoạt động";
//            } else if (listKM.get(i).getTrangthai() == 1) {
//                tt = "Dừng hoạt động";
//            }
//            Object[] data = new Object[]{
//                listKM.get(i).getMaKM(), listKM.get(i).getTenKM(), listKM.get(i).getLoaiKM(), listKM.get(i).getGiatri(), tt
//            };
//            mol.addRow(data);
//        }
//    }


    private void fillTableKMByTT(List<KhuyenMai> km) {
        mol=(DefaultTableModel) tblKM.getModel();
        mol.setRowCount(0);
        for (int i = 0; i < listKM.size(); i++) {
            mol.addRow(new Object[]{
                listKM.get(i).getMaKM()
            });
        }
    }
    
}
