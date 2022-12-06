/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.KhachHang;
import model.KhuyenMai;
import model.LoaiSanPham;
import model.Nhanvien;
import model.SanPham;
import model.Topping;
import repository.Khuyenmai_repository;
import service.GiaoCa_service;
import service.HoaDonService;
import service.KhachHang_service;
import service.nhanvien_service;
import serviceimql.GiaoCa_serviceimpl;
import serviceimql.HoaDonServiceImpl;
import serviceimql.KhachHang_serviceimpl;
import serviceimql.KhuyenMai_serviceimpl;
import serviceimql.LoaiSanPhamServiceImpl;
import serviceimql.Nhanvien_serviceimpl;
import serviceimql.SanPhamServiceImpl;
import serviceimql.SanPhamViewModelServiceImpl;
import viewModel.GiaoCaViewModel;
import viewModel.HoaDonChiTietViewModel;
import viewModel.HoaDonViewModel;
import viewModel.SanPhamViewModel;

/**
 *
 * @author hung2
 */
public class ViewQuanLyBanHang extends javax.swing.JPanel {
//    private final String mac;

    private List<GiaoCaViewModel> listgcvm = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private nhanvien_service nvservice = new Nhanvien_serviceimpl();
    private GiaoCa_service gcservice = new GiaoCa_serviceimpl();
    private HoaDonService hdservice = new HoaDonServiceImpl();
    private DefaultTableModel model;

    /**
     * Creates new form ViewQuanLyBanHang
     */
    private List<SanPhamViewModel> listSP;
    private List<KhachHang> listKH;
    private List<LoaiSanPham> listLSP;
    private List<HoaDonChiTietViewModel> listHDCT;
    private List<Topping> listTP;
    private List<KhuyenMai> listKM;
    private DefaultTableModel modelHD;
    private DefaultTableModel modelHDCT;
    private DefaultTableModel modelSP;
    private DefaultComboBoxModel comboboxLSP;
    private DefaultComboBoxModel comboboxKM;
    private SanPhamViewModelServiceImpl sanPhamService;
    private LoaiSanPhamServiceImpl loaiSanPhamService;
    private HoaDonServiceImpl hoaDonService;
    private Nhanvien_serviceimpl nhanVienService;
    private KhachHang_service khachhangService = new KhachHang_serviceimpl();
    private KhuyenMai_serviceimpl khuyenMaiService;
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private final String mac;
    public static String topping;
    public String soLuong;
    private DecimalFormat df = new DecimalFormat("#");

    public ViewQuanLyBanHang(String mac) {
        initComponents();
        this.mac = mac;
        listSP = new ArrayList<>();
        listHDCT = new ArrayList<>();
        listLSP = new ArrayList<>();
        listTP = new ArrayList<>();
        listKM = new ArrayList<>();
        modelHD = new DefaultTableModel();
        modelHDCT = new DefaultTableModel();
        modelSP = new DefaultTableModel();
        comboboxLSP = new DefaultComboBoxModel();
        comboboxKM = new DefaultComboBoxModel();
        tblHoaDon.setModel(modelHD);
        tblHoaDonCT.setModel(modelHDCT);
        tblSanPham.setModel(modelSP);
        cbbLoaiSP.setModel(comboboxLSP);
        cbbKhuyenMai.setModel(comboboxLSP);
        sanPhamService = new SanPhamViewModelServiceImpl();
        loaiSanPhamService = new LoaiSanPhamServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
        nhanVienService = new Nhanvien_serviceimpl();
        khuyenMaiService = new KhuyenMai_serviceimpl();

        String[] heardHD = {"STT", "Mã HD", "Ngày Tạo", "Nhân Viên", "Trạng Thái"};
        modelHD.setColumnIdentifiers(heardHD);

        String[] heardHDCT = {"STT", "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành tiền", "Tên Topping"};
        modelHDCT.setColumnIdentifiers(heardHDCT);

        String[] heardSP = {"STT", "Mã SP", "Tên SP", "Loại SP", "Đơn Giá", "Mô Tả"};
        modelSP.setColumnIdentifiers(heardSP);

        listSP = sanPhamService.getAllSanPham();
        listLSP = loaiSanPhamService.getAll();
        listKM = khuyenMaiService.getAllKM();
        
        showDataSanPham(listSP);
        cbbLoaiSP.removeAllItems();
        for (int i = 0; i < listLSP.size(); i++) {
            cbbLoaiSP.addItem(listLSP.get(i).getTenLoaiSP().toString());
        }
        cbbKhuyenMai(listKM);
        fillHDToTable();
    }
    
    public void cbbKhuyenMai(List<KhuyenMai> lists){
        cbbKhuyenMai.setModel(comboboxKM);
        for (KhuyenMai km : lists) {
            comboboxKM.addElement(km.getGiatri());
        }
    }

    public void showDataSanPham(List<SanPhamViewModel> lists) {
        modelSP.setRowCount(0);
        int stt = 1;
        for (SanPhamViewModel sanPham : lists) {
            modelSP.addRow(new Object[]{
                stt++, sanPham.getMaSP(), sanPham.getTenSP() + " (size " + sanPham.getSizeSP() + ")", sanPham.getLoaiSP(),
                sanPham.getDonGia() + sanPham.getGiaSize(), sanPham.getMoTa()
            });
        }
    }

    public void addTableHoaDonCT(List<HoaDonChiTietViewModel> listgh) {
        modelHDCT.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietViewModel hoaDonChiTiet : listgh) {
            modelHDCT.addRow(new Object[]{
                stt++, hoaDonChiTiet.getMaSP(), hoaDonChiTiet.getTenSP() + " (size " + hoaDonChiTiet.getTenSize() + ")", hoaDonChiTiet.getSoLuong(),
                hoaDonChiTiet.getDonGia(), hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia(), hoaDonChiTiet.getTenTopping()
            });
        }
    }

    public void loadTien() {
        double money = 0;
        for (int i = 0; i < tblHoaDonCT.getRowCount(); i++) {
            money += Double.parseDouble(tblHoaDonCT.getValueAt(i, 5).toString());
        }
        txtTongTien.setText(String.valueOf(money));
    }

    public void themHoaDonChiTiet() {
        loadTien();
        soLuong = JOptionPane.showInputDialog("Nhập số lượng cần mua: ");
        int index = tblSanPham.getSelectedRow();
        SanPhamViewModel sp = listSP.get(index);
        if (Integer.parseInt(soLuong) == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng");
            return;
        }
        listSP.set(index, sp);
        showDataSanPham(listSP);

        HoaDonChiTietViewModel hoaDonCT = new HoaDonChiTietViewModel();
        hoaDonCT.setIdSanPham(sp.getIdSanPham());
        hoaDonCT.setMaSP(sp.getMaSP());
        hoaDonCT.setTenSP(sp.getTenSP());
        hoaDonCT.setTenSize(sp.getSizeSP());
        hoaDonCT.setSoLuong(Integer.parseInt(soLuong));
        hoaDonCT.setDonGia(sp.getDonGia() + sp.getGiaSize());
        hoaDonCT.setTenTopping("");
        for (HoaDonChiTietViewModel hoaDonct : listHDCT) {
            if (sp.getIdSanPham().equals(hoaDonct.getIdSanPham())) {
                int so_luong = hoaDonct.getSoLuong() + Integer.parseInt(soLuong);
                hoaDonct.setSoLuong(so_luong);
                addTableHoaDonCT(listHDCT);
                return;
            }
        }
        listHDCT.add(hoaDonCT);
        addTableHoaDonCT(listHDCT);
        loadTien();
    }

    public void themToppingHDCT() {
        int index = tblHoaDonCT.getSelectedRow();
        SanPhamViewModel sp = listSP.get(index);
        HoaDonChiTietViewModel hoaDonCT = new HoaDonChiTietViewModel();
        if (sp.getIdSanPham().equals(hoaDonCT.getIdSanPham())) {
            listHDCT.remove(index);
            addTableHoaDonCT(listHDCT);
        } else {
            String maSP = tblSanPham.getValueAt(index, 1).toString();
            String tenSP = tblSanPham.getValueAt(index, 2).toString();
            hoaDonCT.setIdSanPham(sp.getIdSanPham());
            hoaDonCT.setMaSP(maSP);
            hoaDonCT.setTenSP(tenSP);
            hoaDonCT.setTenSize(sp.getSizeSP());
            hoaDonCT.setSoLuong(Integer.parseInt(tblHoaDonCT.getValueAt(index, 3).toString()));
            hoaDonCT.setDonGia(sp.getDonGia() + sp.getGiaSize());
            hoaDonCT.setTenTopping(topping);
            listHDCT.set(index, hoaDonCT);
            addTableHoaDonCT(listHDCT);
            return;
        }
        if (tblHoaDonCT.getRowCount() <= 0) {
            txtTongTien.setText("0");
        }
    }

    public void fillHoaDon() {
        int index = tblHoaDon.getSelectedRow();
        txtMaHD.setText(tblHoaDon.getValueAt(index, 1).toString());
        txtNgayTao.setText(tblHoaDon.getValueAt(index, 2).toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        btnXoaSanPham = new javax.swing.JButton();
        btnThemTopping = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        btnThemSP = new javax.swing.JButton();
        btnTatCa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnThanhToan = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        lblMaCa = new javax.swing.JLabel();

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Giỏ Hàng");

        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonCT);

        btnXoaSanPham.setText("Xóa sản phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnThemTopping.setText("Thêm Topping");
        btnThemTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemToppingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemTopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sản Phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblSanPham);

        jLabel3.setText("Tìm kiếm");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel4.setText("Loại sản phẩm");

        cbbLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiSPItemStateChanged(evt);
            }
        });

        btnThemSP.setText("Thêm SP");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnTatCa.setText("Tất cả");
        btnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(btnTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("Mã KH:");

        jLabel17.setText("Tên KH:");

        jButton2.setText("Thay đổi");

        jButton6.setText("Chọn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel6.setText("Mã HĐ:");

        jLabel8.setText("Ngày Tạo:");

        jLabel10.setText("Thanh toán:");

        jLabel13.setText("VNĐ");

        jLabel14.setText("Tiền khách đưa:");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        jLabel15.setText("VNĐ");

        jLabel16.setText("Tiền thừa:");

        jLabel18.setText("VNĐ");

        jLabel19.setText("Ghi chú");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jButton4.setText("Hủy hóa đơn");

        jButton5.setText("Làm mới");

        jLabel11.setText("Khuyến mãi:");

        cbbKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseEntered(evt);
            }
        });

        txtMaHD.setEnabled(false);

        txtNgayTao.setEnabled(false);

        txtTongTien.setEnabled(false);

        txtTienThua.setEnabled(false);
        txtTienThua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienThuaMouseClicked(evt);
            }
        });

        jLabel7.setText("Giảm giá:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtNgayTao))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtGiamGia))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel18))))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(lblMaCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        themHoaDonChiTiet();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        String tenSP = txtSearch.getText();
        if (txtSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm để tìm kiếm");
            return;
        } else {
            List<SanPhamViewModel> lists = sanPhamService.searchByName(tenSP);
            showDataSanPham(lists);
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cbbLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiSPItemStateChanged
        // TODO add your handling code here:
        String tenLoaiSP = cbbLoaiSP.getSelectedItem().toString();
        if (cbbLoaiSP.getItemCount() > 0) {
            List<SanPhamViewModel> listlsp = sanPhamService.getByLoaiSanPham(tenLoaiSP);
            showDataSanPham(listlsp);
        }
    }//GEN-LAST:event_cbbLoaiSPItemStateChanged

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        HoaDonViewModel hd = new HoaDonViewModel();
        int index = hoaDonService.getAllHoaDon().size() + 1;
        hd.setMaHD("HD" + index);
        hd.setNgayTao(new Date());
        hd.setTrangThai(0);
        hd.setIdNhanVien(gcservice.getGiaoCaByMa(mac).getIdnhanvien());
        hoaDonService.add(hd);
        fillHDToTable();
        fillHoaDon();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:
        int index = tblHoaDonCT.getSelectedRow();
        String so_luong = JOptionPane.showInputDialog("Nhập số lượng: " );
        if (Integer.parseInt(so_luong) > Integer.parseInt(tblHoaDonCT.getValueAt(index, 3).toString())) {
            JOptionPane.showMessageDialog(this, "Bạn đã nhập quá số lượng\n Vui lòng nhập lại");
            return;
        }
        if (Integer.parseInt(tblHoaDonCT.getValueAt(index, 3).toString()) == Integer.parseInt(so_luong)) {
            listHDCT.remove(index);
            addTableHoaDonCT(listHDCT);
        } else {
            String maSP = tblSanPham.getValueAt(index, 1).toString();
            String tenSP = tblSanPham.getValueAt(index, 2).toString();
            SanPhamViewModel sp = listSP.get(index);
            HoaDonChiTietViewModel hoaDonCT = new HoaDonChiTietViewModel();
            hoaDonCT.setIdSanPham(sp.getIdSanPham());
            hoaDonCT.setMaSP(maSP);
            hoaDonCT.setTenSP(tenSP);
            hoaDonCT.setTenSize(sp.getSizeSP());
            hoaDonCT.setSoLuong(Integer.parseInt(tblHoaDonCT.getValueAt(index, 3).toString()) - Integer.parseInt(so_luong));
            hoaDonCT.setDonGia(sp.getDonGia() + sp.getGiaSize());
            listHDCT.set(index, hoaDonCT);
            addTableHoaDonCT(listHDCT);
            return;
        }
        if (tblHoaDonCT.getRowCount() <= 0) {
            txtTongTien.setText("0");
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        fillHoaDon();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCaActionPerformed
        // TODO add your handling code here:
        listSP = sanPhamService.getAllSanPham();
        showDataSanPham(listSP);
    }//GEN-LAST:event_btnTatCaActionPerformed

    private void btnThemToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemToppingActionPerformed
        // TODO add your handling code here:
        int index = tblHoaDonCT.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có thêm topping vào giỏ hàng không?");
        if (confirm == JOptionPane.YES_OPTION) {
            ViewChinh mainFormView = null;
            ViewThongTinTopping option = new ViewThongTinTopping(mainFormView, true);
            option.setVisible(true);
            themToppingHDCT();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa thêm sản phẩm");
            return;
        }
    }//GEN-LAST:event_btnThemToppingActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().isEmpty()) {
            return;
        }
        double tien = Double.valueOf(txtTienKhachDua.getText());

        if (Double.valueOf(txtTienKhachDua.getText()) - Double.valueOf(txtTongTien.getText()) >= 0) {
            btnThanhToan.setEnabled(true);
        } else {
            btnThanhToan.setEnabled(false);
        }
        txtTienThua.setText(df.format(Double.valueOf(txtTienKhachDua.getText()) - Double.valueOf(txtTongTien.getText())) + "");
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        String maHD = txtMaHD.getText();
        HoaDon hd = hdservice.getHoaDonByMaHD(maHD);
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cbbKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseEntered
        // TODO add your handling code here:
        KhuyenMai km = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        txtGiamGia.setText(String.valueOf(km.getGiatri()));
    }//GEN-LAST:event_cbbKhuyenMaiMouseEntered

    private void txtTienThuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienThuaMouseClicked
        // TODO add your handling code here:
        double tongTien, giamGia, tienGiamDuoc, tienPhaiTra;
        tongTien = Double.parseDouble(txtTongTien.getText());
        giamGia = Double.parseDouble(txtGiamGia.getText());
        tienGiamDuoc = (tongTien * giamGia) / 100;
        tienPhaiTra = tongTien - tienGiamDuoc;
        txtTienThua.setText(String.valueOf(tienPhaiTra));
    }//GEN-LAST:event_txtTienThuaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnThemTopping;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cbbKhuyenMai;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblMaCa;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void fillHDToTable() {
        listHD = hdservice.getAllHoaDon();
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (int i = 0; i < listHD.size(); i++) {
            String mahoadon = listHD.get(i).getMaHD();
            String ngaytao = listHD.get(i).getNgayTao() + "";
            String idnhanvien = listHD.get(i).getIdnhanvien();
            String tennhanvien = nhanVienService.getNVbyid(idnhanvien).getHotenNv();
//            String idkhachhang = listHD.get(i).getIdkhachhang();
//            String tenKH = khachhang.getKHByID(idkhachhang).getTenkh();
            int trangthai = listHD.get(i).getTrangThai();

            int stt = 1;
            Object[] data = new Object[]{
                stt++, mahoadon, ngaytao, tennhanvien, trangthai == 0 ? "Chưa thanh toán" : trangthai == 1 ? "Đã thanh toán" : "Đã hủy"
            };
            model.addRow(data);
        }
    }
    
    public void thanhToan() throws ParseException{
        KhuyenMai kh = new KhuyenMai();
        String idKhuyenMai = khuyenMaiService.getAllKM().get(cbbKhuyenMai.getSelectedIndex()).getIdKM();
        HoaDon hd = new HoaDon();
        String maHD = txtMaHD.getText();
        int index = tblHoaDon.getSelectedRow();
        listHD = hdservice.getAllHoaDon();
        String idNhanVien = nhanVienService.GetallNV().get(index).getID();
        hd.setMaHD(maHD);
        hd.setNgayTao(date.parse(txtNgayTao.getText()));
        hd.setTongTien(Double.parseDouble(txtTongTien.getText()));
        hd.setTienApDungKM(Double.parseDouble(txtGiamGia.getText()));
        hd.setTienKHThanhToan(Double.parseDouble(txtTienKhachDua.getText()));
        hd.setNgayThanhToan(new Date());
        hd.setTrangThai(1);
        hd.setIdnhanvien(idNhanVien);
        hd.setIdkm(idKhuyenMai);
    }
}
