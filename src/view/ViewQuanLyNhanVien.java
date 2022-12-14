/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Nhanvien;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serviceimql.Nhanvien_serviceimpl;
import service.nhanvien_service;

/**
 *
 * @author hung2
 */
public class ViewQuanLyNhanVien extends javax.swing.JPanel {

    private List<Nhanvien> listnv = new ArrayList<>();
    private List<Nhanvien> listtk = new ArrayList<>();
    private final nhanvien_service nvservice;
    DefaultTableModel model;

    /**
     * Creates new form ViewQuanLyNhanVien
     */
    public ViewQuanLyNhanVien() {
        initComponents();
        nvservice = new Nhanvien_serviceimpl();
        filltotablenv();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHotenNV = new javax.swing.JTextField();
        txtsoDT = new javax.swing.JTextField();
        txtmaNV = new javax.swing.JTextField();
        txtngaysinh = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JTextField();
        cbott = new javax.swing.JComboBox<>();
        cbochucvu = new javax.swing.JComboBox<>();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1013, 703));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setText("Nhân viên");

        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ tên NV", "So ĐT", "Mật khẩu", "Trạng thái", "Chức vụ"
            }
        ));
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnhanvien);

        txtsearch.setForeground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Mã NV");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Họ tên NV");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Số ĐT");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Giới tính");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ngày sinh");

        rdoNam.setText("Nam");

        rdonu.setText("Nu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Mật khẩu");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Trạng thái");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Chức vụ");

        cbott.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khong hoat dong", "Dang hoat dong" }));

        cbochucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quan li", "Nhan vien" }));

        btnthem.setText("Thêm ");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHotenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(rdoNam)
                                            .addGap(57, 57, 57)
                                            .addComponent(rdonu))
                                        .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnxoa, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnthem)
                        .addGap(32, 32, 32)
                        .addComponent(btnsua))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbochucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbott, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtHotenNV, txtmaNV, txtngaysinh, txtsoDT});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbochucvu, cbott, txtdiachi, txtemail, txtmatkhau});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHotenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rdoNam)
                    .addComponent(rdonu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbott, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbochucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHotenNV, txtmaNV, txtngaysinh, txtsoDT});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbochucvu, cbott, txtdiachi, txtemail, txtmatkhau});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked
        int index = tblnhanvien.getSelectedRow();
        model = (DefaultTableModel) tblnhanvien.getModel();
        String ma = model.getValueAt(index, 0).toString();
        Nhanvien nv = nvservice.getNVbyma(ma);
        showdetail(nv);
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if(txtmaNV.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mã nhân viên không được để trống");
            return;
        }
        listnv=nvservice.GetallNV();
        for(int i=0;i<listnv.size();i++){
            if(txtmaNV.getText().equals(listnv.get(i).getMaNV())){
                JOptionPane.showMessageDialog(this,"Mã nhân viên không được trùng");
            return;
            }
        }
        if(txtHotenNV.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Họ tên không được để trống");
            return;
        }
        if(txtsoDT.getText().equals("")){
            JOptionPane.showMessageDialog(this,"SDT không được để trống");
            return;
        }
        String resdt="0\\d{9}";
            if(!txtsoDT.getText().matches(resdt)){
                JOptionPane.showMessageDialog(this,"sai định dạng số điện thoại, Mời nhập lại");
                return;
            }
        if(txtngaysinh.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Ngày sinh không được để trống");
            return;
        }
        try {
            Date Ngaysinh = new SimpleDateFormat("MM-dd-yyyy").parse(txtngaysinh.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"sai định dạng ngày sinh, Mời nhập lại");
                return;
        }
        if(txtemail.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Email không được để trống");
            return;
        }
        String reemail="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if(!txtemail.getText().matches(reemail)){
                JOptionPane.showMessageDialog(this,"sai định dạng email, Mời nhập lại");
                return;
            }
        if(txtdiachi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"địa chỉ không được để trống");
            return;
        }
        if(txtmatkhau.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mật khẩu không được để trống");
            return;
        }
        Nhanvien nv = null;
        try {
            nv = getNVbyfrom();
        } catch (ParseException ex) {
            Logger.getLogger(ViewQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int chon=JOptionPane.showConfirmDialog(this,"Bạn có muốn thêm Nhân viên này ko","Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
            if(chon==JOptionPane.YES_OPTION){
                nvservice.add(nv);
            filltotablenv();
                JOptionPane.showMessageDialog(this,"Thêm nhân viên thành công");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Thêm nhân viên thất bại");
        }
        
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        if(txtmaNV.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mã nhân viên không được để trống");
            return;
        }
        
        if(txtHotenNV.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Họ tên không được để trống");
            return;
        }
        if(txtsoDT.getText().equals("")){
            JOptionPane.showMessageDialog(this,"SDT không được để trống");
            return;
        }
        String resdt="0\\d{9}";
            if(!txtsoDT.getText().matches(resdt)){
                JOptionPane.showMessageDialog(this,"sai định dạng số điện thoại, Mời nhập lại");
                return;
            }
        if(txtngaysinh.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Ngày sinh không được để trống");
            return;
        }
        try {
            Date Ngaysinh = new SimpleDateFormat("MM-dd-yyyy").parse(txtngaysinh.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"sai định dạng ngày sinh, Mời nhập lại");
                return;
        }
        if(txtemail.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Email không được để trống");
            return;
        }
        String reemail="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if(!txtemail.getText().matches(reemail)){
                JOptionPane.showMessageDialog(this,"sai định dạng email, Mời nhập lại");
                return;
            }
        if(txtdiachi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"địa chỉ không được để trống");
            return;
        }
        if(txtmatkhau.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mật khẩu không được để trống");
            return;
        }
        Nhanvien nv = null;
        try {
            nv = getNVbyfrom();
        } catch (ParseException ex) {
            Logger.getLogger(ViewQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int chon=JOptionPane.showConfirmDialog(this,"Bạn có muốn sửa Nhân viên này ko","Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
            if(chon==JOptionPane.YES_OPTION){
                nvservice.update(nv);
            filltotablenv();
                JOptionPane.showMessageDialog(this,"sửa nhân viên thành công");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"sửa nhân viên thất bại");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        
        if(txtmaNV.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mã nhân viên không được để trống");
            return;
        }
        
        Nhanvien nv = null;
        try {
            nv = getNVbyfrom();
        } catch (ParseException ex) {
            Logger.getLogger(ViewQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
       try {
            int chon=JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa Nhân viên này ko","Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
            if(chon==JOptionPane.YES_OPTION){
                nvservice.delete(nv);
            filltotablenv();
                JOptionPane.showMessageDialog(this,"xóa nhân viên thành công");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"xóa nhân viên thất bại");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ma = txtsearch.getText();
        filltotabletk(ma);
    }//GEN-LAST:event_jButton1ActionPerformed

    public Nhanvien getNVbyfrom() throws ParseException {
        String manv = txtmaNV.getText();
        String hoten = txtHotenNV.getText();
        String sodt = txtsoDT.getText();

        Date Ngaysinh = new SimpleDateFormat("MM-dd-yyyy").parse(txtngaysinh.getText());
        String gt = rdoNam.isSelected() ? "Nam" : "Nu";
        String email = txtemail.getText();
        String diachi = txtdiachi.getText();
        String matkhau = txtmatkhau.getText();
        int trangthai;
        String tt = (String) cbott.getSelectedItem();
        if (tt.equals("Dang hoat dong")) {
            trangthai = 1;
        } else {
            trangthai = 0;
        }

        String chucvu = (String) cbochucvu.getSelectedItem();
        Nhanvien nv = new Nhanvien(manv, hoten, sodt, gt, Ngaysinh, email, diachi, chucvu, matkhau, trangthai);
        return nv;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbochucvu;
    private javax.swing.JComboBox<String> cbott;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblnhanvien;
    private javax.swing.JTextField txtHotenNV;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmaNV;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsoDT;
    // End of variables declaration//GEN-END:variables
 private void filltotablenv() {

        listnv = nvservice.GetallNV();
        model = (DefaultTableModel) tblnhanvien.getModel();
        model.setRowCount(0);
        for (int i = 0; i < listnv.size(); i++) {
            String tt = null;
            if (listnv.get(i).getTrangthai() == 1) {
                tt = "Dang hoat dong";
            }
            if (listnv.get(i).getTrangthai() == 0) {
                tt = "Khong hoat dong";
            }
            Object[] data = new Object[]{
                listnv.get(i).getMaNV(), listnv.get(i).getHotenNv(), listnv.get(i).getSoDt(), listnv.get(i).getMatkhau(), tt, listnv.get(i).getChucvu()
            };
            model.addRow(data);
        }
    }

    private void filltotabletk(String ma) {
        listtk.removeAll(listtk);
        Nhanvien nv = nvservice.getNVbyma(ma);
        listtk.add(nv);
        model = (DefaultTableModel) tblnhanvien.getModel();
        model.setRowCount(0);
        for (int i = 0; i < listnv.size(); i++) {
            String tt = null;
            if (listnv.get(i).getTrangthai() == 1) {
                tt = "Dang hoat dong";
            }
            if (listnv.get(i).getTrangthai() == 0) {
                tt = "Khong hoat dong";
            }
            Object[] data = new Object[]{
                listtk.get(i).getMaNV(), listtk.get(i).getHotenNv(), listtk.get(i).getSoDt(), listtk.get(i).getMatkhau(), tt, listtk.get(i).getChucvu()
            };
            model.addRow(data);
        }
    }

    private void showdetail(Nhanvien nv) {
        String tt = null;
        txtmaNV.setText(nv.getMaNV());
        txtHotenNV.setText(nv.getHotenNv());
        txtsoDT.setText(nv.getSoDt());
        txtngaysinh.setText(nv.getNgaysinh() + "");
        txtemail.setText(nv.getEmail());
        txtdiachi.setText(nv.getDiachi());
        txtmatkhau.setText(nv.getMatkhau());

        if (nv.getTrangthai() == 0) {
            tt = "Khong hoat dong";
        }
        if (nv.getTrangthai() == 1) {
            tt = "Dang hoat dong";
        }
        cbott.setSelectedItem(tt);
        cbochucvu.setSelectedItem(nv.getChucvu());
        if (nv.getGioitinh().equals("Nam")) {
            rdoNam.setSelected(true);
        }
        if (nv.getGioitinh().equals("Nu")) {
            rdonu.setSelected(true);
        }
    }

    private Object SimpleDateFormat(String mMddyyyy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
