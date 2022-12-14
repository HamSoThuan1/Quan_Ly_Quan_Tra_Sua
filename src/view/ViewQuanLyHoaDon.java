/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;
import serviceimql.HoaDonChiTietServiceImpl;
import serviceimql.HoaDonServiceImpl;
import viewModel.HoaDonChiTietViewModel;
import viewModel.HoaDonViewModel1;

/**
 *
 * @author hung2
 */
public class ViewQuanLyHoaDon extends javax.swing.JPanel {

    private List<HoaDon> listhd;
    private HoaDonServiceImpl hoaDonServiceImpl;
    private List<HoaDonViewModel1> list;
    private HoaDonChiTietServiceImpl hoaDonChiTietServiceImpl;

    /**
     * Creates new form ViewQuanLyHoaDon
     */
    public ViewQuanLyHoaDon() {
        initComponents();
        listhd = new ArrayList<>();
        hoaDonServiceImpl = new HoaDonServiceImpl();
        list = new ArrayList<>();
        hoaDonChiTietServiceImpl = new HoaDonChiTietServiceImpl();
        fillDataTable();
        fillDataHDCT();

    }

    public void fillDataTable() {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tbl_hoaDon.getModel();
        tblModel.setRowCount(0);
        listhd = hoaDonServiceImpl.getAllHoaDon();
        for (HoaDon hoaDon : listhd) {
            tblModel.addRow(new Object[]{
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getNgayThanhToan(),
                hoaDon.getTongTien(),
                hoaDon.getTienApDungKM(),
                hoaDon.getTienKHThanhToan(),
                hoaDon.getTrangThai() == 0 ? "Chờ thanh toán" : hoaDon.getTrangThai() == 1 ? "Đã thanh toán" : "Đã hủy",
                hoaDon.getGhiChu()
            });
        }
    }

    public void fillDataHDCT() {
        DefaultTableModel Model = new DefaultTableModel();
        Model = (DefaultTableModel) tbl_hoaDonChiTiet.getModel();
        Model.setRowCount(0);
        list = hoaDonChiTietServiceImpl.getAll();
        for (HoaDonViewModel1 hd : list) {
            Model.addRow(new Object[]{
                hd.getIdSanPham().getMaSP(),
                hd.getIdSanPham().getTenSP(),
                hd.getSoLuong(),
                hd.getDonGia(),
                hd.getGiaTopping(),
                hd.getTrangThai(),
                hd.getIdHoaDon().getTongTien(),});
        }
    }

    public void showHoaDon(int index) {
        HoaDon h = listhd.get(index);
        lbl_maHD.setText(h.getMaHD());
        lbl_ngayTao.setText(h.getNgayTao() + "");
        lbl_ngayThanhToan.setText(h.getNgayThanhToan() + "");
        lbl_tienApDung.setText(h.getTienApDungKM() + "");
        lbl_tienKhachHangThanhToan.setText(h.getTienKHThanhToan() + "");
        lbl_tongTienSanPham.setText(h.getTongTien() + "");
        lbl_trangThai.setText(tbl_hoaDon.getValueAt(index, 6).toString());
        tet_ghiChu.setText(h.getGhiChu());
    }

    public void fillTbaleTheoThang() {
        String month = (String) cbo_month.getSelectedItem();
        listhd = hoaDonServiceImpl.getlocTheoThang(month);
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tbl_hoaDon.getModel();
        tblModel.setRowCount(0);
        for (HoaDon hoaDon : listhd) {
            tblModel.addRow(new Object[]{
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getNgayThanhToan(),
                hoaDon.getTongTien(),
                hoaDon.getTienApDungKM(),
                hoaDon.getTienKHThanhToan(),
                hoaDon.getTrangThai() == 0 ? "Chờ thanh toán" : hoaDon.getTrangThai() == 1 ? "Đã thanh toán" : "Đã hủy",
                hoaDon.getGhiChu()
            });
        }
    }

    public void fillTbaleTheonam() {
        String nam = (String) cbo_nam.getSelectedItem();
        List<HoaDon> listNam = hoaDonServiceImpl.getlocTheoNam(nam);
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tbl_hoaDon.getModel();
        tblModel.setRowCount(0);
        for (HoaDon hoaDon : listNam) {
            tblModel.addRow(new Object[]{
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getNgayThanhToan(),
                hoaDon.getTongTien(),
                hoaDon.getTienApDungKM(),
                hoaDon.getTienKHThanhToan(),
                hoaDon.getTrangThai() == 0 ? "Chờ thanh toán" : hoaDon.getTrangThai() == 1 ? "Đã thanh toán" : "Đã hủy",
                hoaDon.getGhiChu()
            });
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoaDonChiTiet = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tet_ghiChu = new javax.swing.JTextArea();
        lbl_maHD = new javax.swing.JLabel();
        lbl_ngayTao = new javax.swing.JLabel();
        lbl_ngayThanhToan = new javax.swing.JLabel();
        lbl_tienApDung = new javax.swing.JLabel();
        lbl_tongTienSanPham = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_trangThai = new javax.swing.JLabel();
        lbl_tienKhachHangThanhToan = new javax.swing.JLabel();
        cbo_trangThai = new javax.swing.JComboBox<>();
        cbo_month = new javax.swing.JComboBox<>();
        cbo_nam = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1218, 746));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Ngày Tạo", "Ngày Thanh Toán", "Tổng Tiền", "Tiền Áp Dụng", "Tiền KH Thanh Toán", "Tình Trạng", "Ghi Chú"
            }
        ));
        tbl_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoaDon);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Hóa Đơn Chi Tiết");

        tbl_hoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP Chi Tiết", "Số Lượng", "Đơn Giá", "Giá Topping", "Trạng Thái", "Thành Tiền"
            }
        ));
        jScrollPane2.setViewportView(tbl_hoaDonChiTiet);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã HD");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày Tạo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày Thanh Toán");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tiền Áp Dụng");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Tiền KH Thanh Toán");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Tổng Tiền SP");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Ghi Chú");

        tet_ghiChu.setColumns(20);
        tet_ghiChu.setRows(5);
        jScrollPane3.setViewportView(tet_ghiChu);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Tình Trạng");

        lbl_trangThai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_ngayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_tienApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(30, 30, 30)
                                        .addComponent(lbl_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_tienKhachHangThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tongTienSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9))
                    .addComponent(lbl_maHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_ngayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_ngayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(lbl_tienApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(lbl_tienKhachHangThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(lbl_tongTienSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        cbo_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Đã Hủy", "Chờ Thanh Toán", " " }));
        cbo_trangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_trangThaiItemStateChanged(evt);
            }
        });

        cbo_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_monthItemStateChanged(evt);
            }
        });

        cbo_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        cbo_nam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_namItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(562, 562, 562))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(215, 215, 215)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2)
                                        .addGap(18, 18, 18)))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(12, 12, 12))))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178)
                .addComponent(cbo_month, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoaDonMouseClicked
        // TODO add your handling code here:
        int index = tbl_hoaDon.getSelectedRow();
        showHoaDon(index);
    }//GEN-LAST:event_tbl_hoaDonMouseClicked

    private void cbo_trangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_trangThaiItemStateChanged
        // TODO add your handling code here:
        int trangThai = cbo_trangThai.getSelectedIndex();
        if (cbo_trangThai.getItemCount() > 0) {
            List<HoaDon> list = hoaDonServiceImpl.timKiemcbo(trangThai);
            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel = (DefaultTableModel) tbl_hoaDon.getModel();
            tblModel.setRowCount(0);
            for (HoaDon hoaDon : list) {
                tblModel.addRow(new Object[]{
                    hoaDon.getMaHD(),
                    hoaDon.getNgayTao(),
                    hoaDon.getNgayThanhToan(),
                    hoaDon.getTongTien(),
                    hoaDon.getTienApDungKM(),
                    hoaDon.getTienKHThanhToan(),
                    hoaDon.getTrangThai(),
                    hoaDon.getGhiChu()
                });
            }
        }
    }//GEN-LAST:event_cbo_trangThaiItemStateChanged

    private void cbo_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_monthItemStateChanged
        // TODO add your handling code here:
        fillTbaleTheoThang();
    }//GEN-LAST:event_cbo_monthItemStateChanged

    private void cbo_namItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_namItemStateChanged
        // TODO add your handling code here:
        fillTbaleTheonam();
    }//GEN-LAST:event_cbo_namItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_month;
    private javax.swing.JComboBox<String> cbo_nam;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_maHD;
    private javax.swing.JLabel lbl_ngayTao;
    private javax.swing.JLabel lbl_ngayThanhToan;
    private javax.swing.JLabel lbl_tienApDung;
    private javax.swing.JLabel lbl_tienKhachHangThanhToan;
    private javax.swing.JLabel lbl_tongTienSanPham;
    private javax.swing.JLabel lbl_trangThai;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTable tbl_hoaDonChiTiet;
    private javax.swing.JTextArea tet_ghiChu;
    // End of variables declaration//GEN-END:variables
}
