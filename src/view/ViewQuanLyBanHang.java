/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import entity.MsgBox;
import java.io.File;
import java.io.FileOutputStream;
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
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KhuyenMai;
import model.LoaiSanPham;
import model.Nhanvien;
import model.SanPham;
import model.Topping;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import service.GiaoCa_service;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.KhachHang_service;
import service.nhanvien_service;
import serviceimql.GiaoCa_serviceimpl;
import serviceimql.HoaDonChiTietServiceImpl;
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
import entity.XMoney;
import java.awt.Color;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

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
//    private DefaultTableModel model;

    /**
     * Creates new form ViewQuanLyBanHang
     */
    private List<SanPhamViewModel> listSP;
    private List<HoaDonChiTiet> listHDchitiet = new ArrayList<>();
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
    private HoaDonChiTietService hoadonchitietservice = new HoaDonChiTietServiceImpl();
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private final String mac;
    public static String topping;
    public static double giaTopping;
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
        if (txtTienKhachDua.getText().isEmpty() || txtTienKhachDua.getText().equalsIgnoreCase("0")) {
            btnThanhToan.setEnabled(false);
        }
    }

    public void cbbKhuyenMai(List<KhuyenMai> lists) {
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
                hoaDonChiTiet.getDonGia(), hoaDonChiTiet.getThanhTien(), hoaDonChiTiet.getTenTopping()
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

    private void loadTienView() {
        long tongTien = 0;
        long tien = 0;
        long giamGia = 0;
        for (int i = 0; i < tblHoaDonCT.getRowCount(); i++) {
            tien = Long.valueOf(tblHoaDonCT.getValueAt(i, 3).toString());
            long soLuong = (int) tblHoaDonCT.getValueAt(i, 2);
            tongTien += (soLuong * tien);
            KhuyenMai km = khuyenMaiService.getAllKM().get(i);
            if (km == null) {
                giamGia += 0;
            } else {
                if (km.getLoaiKM().equalsIgnoreCase("%")) {
                    float giaTriKM = km.getGiatri();
                    giaTriKM = giaTriKM / 100;
                    float giatriGiam = giaTriKM * soLuong;
                    giamGia += (tien * giatriGiam);
                } else {
                    giamGia += (km.getGiatri() * soLuong);
                }
            }
            txtTongTien.setText(XMoney.themDauCham(tongTien));
            txtGiamGia.setText(XMoney.themDauCham(giamGia));
        }
    }

    public void themHoaDonChiTiet() {
        try {
//            loadTien();
            int index = tblSanPham.getSelectedRow();
            int row = tblHoaDon.getSelectedRow();
            if (row < 0) {
                MsgBox.alert(this, "Vui lòng chọn hóa đơn chờ \n Nếu chưa có vui lòng tạo!");
            } else if (index < 0) {
                MsgBox.alert(this, "Vui lòng chọn sản phẩm trên table");
            } else {
                soLuong = JOptionPane.showInputDialog("Nhập số lượng cần mua: ");
                SanPhamViewModel sp = listSP.get(index);
                if (Integer.parseInt(soLuong) < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải là số dương", "warning", JOptionPane.WARNING_MESSAGE);
//                addTableHoaDonCT(listHDCT);
                    return;
                }
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
                hoaDonCT.setThanhTien(Integer.parseInt(soLuong) * Double.parseDouble(tblSanPham.getValueAt(index, 4).toString()));
                hoaDonCT.setTenTopping("");
                for (HoaDonChiTietViewModel hoaDonct : listHDCT) {
                    if (sp.getIdSanPham().equals(hoaDonct.getIdSanPham())) {
                        int so_luong = hoaDonct.getSoLuong() + Integer.parseInt(soLuong);
                        hoaDonct.setSoLuong(so_luong);
                        hoaDonct.setThanhTien(so_luong * Double.parseDouble(tblSanPham.getValueAt(index, 4).toString()));
                        addTableHoaDonCT(listHDCT);
                        loadTien();
                        return;
                    }
                }
                listHDCT.add(hoaDonCT);
                addTableHoaDonCT(listHDCT);
                loadTien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void themToppingHDCT() {
        try {
            loadTien();
            int index = tblHoaDonCT.getSelectedRow();
            SanPhamViewModel sp = listSP.get(index);
            HoaDonChiTietViewModel hoaDonCT = new HoaDonChiTietViewModel();
            if (sp.getIdSanPham().equals(hoaDonCT.getIdSanPham())) {
                listHDCT.remove(index);
                addTableHoaDonCT(listHDCT);
            } else {
                String maSP = tblHoaDonCT.getValueAt(index, 1).toString();
                String tenSP = tblHoaDonCT.getValueAt(index, 2).toString();
                hoaDonCT.setIdSanPham(sp.getIdSanPham());
                hoaDonCT.setMaSP(maSP);
                hoaDonCT.setTenSP(tenSP);
                hoaDonCT.setSoLuong(Integer.parseInt(tblHoaDonCT.getValueAt(index, 3).toString()));
                hoaDonCT.setDonGia(Double.parseDouble(tblHoaDonCT.getValueAt(index, 4).toString()));
                hoaDonCT.setThanhTien(Double.parseDouble(tblHoaDonCT.getValueAt(index, 4).toString()) + giaTopping);
                hoaDonCT.setTenTopping(topping);
                listHDCT.set(index, hoaDonCT);
                addTableHoaDonCT(listHDCT);
                return;
            }
            if (tblHoaDonCT.getRowCount() <= 0) {
                txtTongTien.setText("0");
            }
            loadTien();
        } catch (Exception e) {
            e.printStackTrace();
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
        btnXoaAll = new javax.swing.JButton();
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
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        btnThayDoi = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
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
        txtghichu = new javax.swing.JTextArea();
        btnThanhToan = new javax.swing.JButton();
        btnHuyDon = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTopping = new javax.swing.JTextField();
        lblMaCa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(125, 190, 125));

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

        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add.png"))); // NOI18N
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
                        .addComponent(btnTaoHoaDon))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tblHoaDonCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonCT);

        btnXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/delete.png"))); // NOI18N
        btnXoaSanPham.setText("Xóa");
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

        btnXoaAll.setText("Xóa All");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
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
                            .addComponent(btnThemTopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
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

        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
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

        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });

        btnKhachHang.setText("Chọn");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

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
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKH)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThayDoi)
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHang))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThayDoi))
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

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane4.setViewportView(txtghichu);

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyDon.setText("Hủy hóa đơn");
        btnHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonActionPerformed(evt);
            }
        });

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

        txtGiamGia.setEnabled(false);

        jLabel9.setText("Topping:");

        txtTopping.setEnabled(false);

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
                                .addComponent(btnHuyDon)
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
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNgayTao))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                    .addComponent(jLabel18)))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyDon)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
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
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:
        try {
            int index = tblHoaDonCT.getSelectedRow();
            String so_luong = JOptionPane.showInputDialog("Nhập số lượng: ");
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
                hoaDonCT.setTenTopping("");
                listHDCT.set(index, hoaDonCT);
                addTableHoaDonCT(listHDCT);
                return;
            }
            if (tblHoaDonCT.getRowCount() <= 0) {
                txtTongTien.setText("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
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
            loadTien();
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            if (txtMaHD.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn mã hóa đơn");
                return;
            }
            HoaDon hd = new HoaDon();
            hd.setMaHD(txtMaHD.getText());
            hd.setTongTien(Double.parseDouble(txtTongTien.getText()));
            if (txtGiamGia.getText().equals("")) {
                hd.setTienApDungKM(Double.parseDouble("0"));
            } else {
                hd.setTienApDungKM(Double.parseDouble(txtGiamGia.getText()));
            }
            hd.setTienKHThanhToan(Double.parseDouble(txtTienKhachDua.getText()));
            hd.setNgayThanhToan(new Date());
            if (txtghichu.getText().equals("")) {
                hd.setGhiChu("");
            } else {
                hd.setGhiChu(txtghichu.getText());
            }
            hd.setTrangThai(1);
            if (txtTienKhachDua.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Khách hàng chưa thanh toán");
                txtTienKhachDua.requestFocus();
                return;
            }

            if (txtMaKH.getText().equals("")) {
                hd.setIdkhachhang(null);
            } else {
                String makh = txtMaKH.getText();
                KhachHang kh = khachhangService.getKhachHangByMa(makh);
                hd.setIdkhachhang(kh.getIdKhachHang());
            }

            if (Double.parseDouble(txtTienKhachDua.getText()) < Double.parseDouble(txtTongTien.getText())) {
                JOptionPane.showMessageDialog(this, "Khách hàng chưa đưa đủ tiền");
                txtTienKhachDua.requestFocus();
                return;
            }

            int sd = tblHoaDonCT.getRowCount();
            for (int i = 0; i < sd; i++) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                double dongia = Double.parseDouble(tblHoaDonCT.getValueAt(i, 4).toString());
                int soluong = Integer.parseInt(tblHoaDonCT.getValueAt(i, 3).toString());
                double giaTP = giaTopping;
                int trangthai = 1;
                String maSP = tblHoaDonCT.getValueAt(i, 1).toString();
                String idsps = sanPhamService.getSPByMa(maSP).getIdSanPham();
                String maHD = txtMaHD.getText();
                String idhoadon = hoaDonService.getHoaDonByMaHD(maHD).getIdHoaDon();
                hdct.setDonGia(dongia);
                hdct.setSoluong(soluong);
                hdct.setGiaTopping(giaTP);
                hdct.setTrangthai(trangthai);
                hdct.setIdhoadon(idhoadon);
                hdct.setIdsanpham(idsps);
                System.out.println(hdct);
                hoadonchitietservice.addHDCT(hdct);
            }
            System.out.println(hd);
            hdservice.updateHD(hd);
            fillHDToTable();
            DefaultTableModel model = (DefaultTableModel) tblHoaDonCT.getModel();
            model.setRowCount(0);
//            tblHoaDonCT.removeAll();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            xuatHoaDon();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thanh toán thất bại");
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cbbKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseEntered
        // TODO add your handling code here:
//        KhuyenMai km = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
//        txtGiamGia.setText(String.valueOf(km.getGiatri()));
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

    private void btnHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonActionPerformed
        // TODO add your handling code here:
        if (txtMaHD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
            return;
        } else if (txtghichu.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mời nhập lý do hủy");
            txtghichu.requestFocus();
            txtTienKhachDua.disable();
            return;
        } else {
            String maHD = txtMaHD.getText();
            String ghichu = txtghichu.getText();
            hdservice.update(maHD, ghichu);
            fillHDToTable();
            clearForm();
        }
    }//GEN-LAST:event_btnHuyDonActionPerformed

    private void tblHoaDonCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseClicked
        // TODO add your handling code here:
        int index = tblHoaDonCT.getSelectedRow();
        txtTopping.setText(tblHoaDonCT.getValueAt(index, 6).toString());
    }//GEN-LAST:event_tblHoaDonCTMouseClicked

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        ViewKhachHang viewKH = new ViewKhachHang();
        viewKH.setVisible(true);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tất cả sản phẩm không ?");
        if (choice == JOptionPane.YES_OPTION) {
            listHDCT.removeAll(listHDCT);
            addTableHoaDonCT(listHDCT);
        }
    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        // TODO add your handling code here:
        String tenSP = txtSearch.getText();
        List<SanPhamViewModel> lists = sanPhamService.searchByName(tenSP);
        showDataSanPham(lists);
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        // TODO add your handling code here:
        try {
            showKhachHang();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnThayDoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnThemTopping;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cbbKhuyenMai;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMaCa;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTopping;
    private javax.swing.JTextArea txtghichu;
    // End of variables declaration//GEN-END:variables

    private void fillHDToTable() {
        modelHD = (DefaultTableModel) tblHoaDon.getModel();
        modelHD.setRowCount(0);
        listHD = hdservice.getAllHoaDon();
        int stt = 1;
        for (int i = 0; i < listHD.size(); i++) {
            String mahoadon = listHD.get(i).getMaHD();
            String ngaytao = listHD.get(i).getNgayTao() + "";
            String idnhanvien = listHD.get(i).getIdnhanvien();
            String tennhanvien = nhanVienService.getNVbyid(idnhanvien).getHotenNv();
//            String idkhachhang = listHD.get(i).getIdkhachhang();
//            String tenKH = khachhang.getKHByID(idkhachhang).getTenkh();
            int trangthai = listHD.get(i).getTrangThai();
            Object[] data = new Object[]{
                stt++, mahoadon, ngaytao, tennhanvien, trangthai == 0 ? "Chưa thanh toán" : trangthai == 1 ? "Đã thanh toán" : "Đã hủy"
            };
            modelHD.addRow(data);
        }
    }

//    public void thanhToan() throws ParseException {
//        KhuyenMai kh = new KhuyenMai();
//        String idKhuyenMai = khuyenMaiService.getAllKM().get(cbbKhuyenMai.getSelectedIndex()).getIdKM();
//        HoaDon hd = new HoaDon();
//        String maHD = txtMaHD.getText();
//        int index = tblHoaDon.getSelectedRow();
//        listHD = hdservice.getAllHoaDon();
//        String idNhanVien = nhanVienService.GetallNV().get(index).getID();
//        hd.setMaHD(maHD);
//        hd.setNgayTao(date.parse(txtNgayTao.getText()));
//        hd.setTongTien(Double.parseDouble(txtTongTien.getText()));
//        hd.setTienApDungKM(Double.parseDouble(txtGiamGia.getText()));
//        hd.setTienKHThanhToan(Double.parseDouble(txtTienKhachDua.getText()));
//        hd.setNgayThanhToan(new Date());
//        hd.setTrangThai(1);
//        hd.setIdnhanvien(idNhanVien);
//        hd.setIdkm(idKhuyenMai);
//    }
    private void clearForm() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtMaHD.setText("");
        txtNgayTao.setText("");
        txtTongTien.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtghichu.setText("");
    }

    public void showKhachHang() {
        if (!ViewKhachHang.maKH.equals("KH01")) {
            txtMaKH.setText(ViewKhachHang.maKH);
            txtMaKH.setForeground(Color.black);
            txtTenKH.setText(ViewKhachHang.tenKH);
            txtTenKH.setForeground(Color.black);
        } else {
            txtMaKH.setText(ViewKhachHang.maKH);
            txtMaKH.setForeground(Color.red);
            txtTenKH.setText(ViewKhachHang.tenKH);
            txtTenKH.setForeground(Color.red);
        }
        ViewKhachHang.maKH = null;
        ViewKhachHang.tenKH = null;
        MsgBox.alert(this, "Hiện Thị thành công!");
//        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
//        List<KhachHang> list = nvImpl.getIDKhachHang(lblTenKh.getText());
//        for (int i = 0; i < list.size(); i++) {
//            int id = list.get(i).getId();
//            HoaDon hd = new HoaDon();
//            hd.setIdKhachHang(id);
//            for (int j = 0; j < hds.size(); j++) {
//                hoaDonServices.updateIDKhachHang(hd, hds.get(j).getId());
//            }
//
//        }
    }

    public void xuatHoaDon() {
        try {
            int index = tblHoaDon.getSelectedRow();
            XWPFDocument wordbook = new XWPFDocument();

            XWPFParagraph paragraph = wordbook.createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run.setText("Quán Trà Sữa");
            run.setFontSize(20);
            run.setBold(true);

            XWPFParagraph paragraph2 = wordbook.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            paragraph2.setAlignment(ParagraphAlignment.CENTER);
            run2.setText("ĐC: Phố Trịnh Văn Bô, Xuân Phương, Nam Từ Liêm, Hà Nội");

            XWPFParagraph paragraph3 = wordbook.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);
            run3.setText("ĐT: 0353895062");
            run3.setTextPosition(50);

            XWPFParagraph paragraph4 = wordbook.createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("HÓA ĐƠN BÁN HÀNG");
            run4.setFontSize(30);
            run4.setBold(true);

            XWPFParagraph paragraph5 = wordbook.createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.CENTER);
            run5.setText("Số Hóa Đơn: " + txtMaHD.getText());
            run5.setTextPosition(50);

            XWPFParagraph paragraph6 = wordbook.createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            run6.setText("Khách hàng: " + txtTenKH.getText());

            XWPFParagraph paragraph9 = wordbook.createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            run9.setText("Ngày lập: " + txtNgayTao.getText());
            run9.setTextPosition(20);

            XWPFTable table = wordbook.createTable(tblHoaDonCT.getRowCount() + 2, 6);
            table.setWidth("100%");

            XWPFTableRow row = table.getRow(0);
            XWPFParagraph paragraph10 = row.getCell(0).addParagraph();
            paragraph10.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run10 = paragraph10.createRun();
            run10.setText("Mã sản phẩm");
            run10.setBold(true);
            run10.setTextPosition(20);

            XWPFTableRow row2 = table.getRow(0);
            XWPFParagraph paragraph11 = row.getCell(1).addParagraph();
            paragraph11.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run11 = paragraph11.createRun();
            run11.setText("Tên sản phẩm");
            run11.setBold(true);
            run11.setTextPosition(20);

            XWPFTableRow row3 = table.getRow(0);
            XWPFParagraph paragraph12 = row.getCell(2).addParagraph();
            paragraph12.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run12 = paragraph12.createRun();
            run12.setText("Số lượng");
            run12.setBold(true);
            run12.setTextPosition(20);

            XWPFTableRow row4 = table.getRow(0);
            XWPFParagraph paragraph13 = row.getCell(3).addParagraph();
            paragraph13.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run13 = paragraph13.createRun();
            run13.setText("Đơn giá");
            run13.setBold(true);
            run13.setTextPosition(20);
            
            XWPFTableRow row5 = table.getRow(0);
            XWPFParagraph paragraph14 = row.getCell(4).addParagraph();
            paragraph14.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run14 = paragraph14.createRun();
            run14.setText("Tên topping");
            run14.setBold(true);
            run14.setTextPosition(20);

            XWPFTableRow row6 = table.getRow(0);
            XWPFParagraph paragraph30 = row.getCell(5).addParagraph();
            paragraph30.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run15 = paragraph30.createRun();
            run15.setText("Thành tiền");
            run15.setBold(true);
            run15.setTextPosition(20);

            for (int i = 0; i < tblHoaDonCT.getSelectedRow(); i++) {
                table.getRow(i + 1).getCell(0).setText(tblHoaDonCT.getValueAt(i, 1).toString());
                table.getRow(i + 1).getCell(1).setText(tblHoaDonCT.getValueAt(i, 2).toString());
                table.getRow(i + 1).getCell(2).setText(tblHoaDonCT.getValueAt(i, 3).toString());
                table.getRow(i + 1).getCell(3).setText(XMoney.themDauCham((long) tblHoaDonCT.getValueAt(i, 4)));
                table.getRow(i + 1).getCell(4).setText(tblHoaDonCT.getValueAt(i, 6).toString());
//                table.getRow(i + 1).getCell(5).setText(XMoney.themDauCham(XMoney.loaiBoVND(tblHoaDonCT.getValueAt(i, 4) + "") * Integer.parseInt(tblHoaDonCT.getValueAt(i, 3) + "")) + " VNĐ");
                table.getRow(i + 1).getCell(5).setText(tblHoaDonCT.getValueAt(i, 5) + "");
            }

            int tongSL = 0;
            for (int i = 0; i < tblHoaDonCT.getRowCount(); i++) {
                tongSL += Integer.parseInt(tblHoaDonCT.getValueAt(i, 3) + "");
            }

            table.getRow(tblHoaDonCT.getRowCount() + 1).getCell(0).setText("TỔNG");
            table.getRow(tblHoaDonCT.getRowCount() + 1).getCell(1).setText("");
            table.getRow(tblHoaDonCT.getRowCount() + 1).getCell(2).setText(tongSL + "");
            table.getRow(tblHoaDonCT.getRowCount() + 1).getCell(3).setText("");
            table.getRow(tblHoaDonCT.getRowCount() + 1).getCell(4).setText("");
            table.getRow(tblHoaDonCT.getRowCount() + 1).getCell(5).setText(txtTongTien.getText() + " VNĐ");

            XWPFParagraph paragraph22 = wordbook.createParagraph();
            paragraph22.setAlignment(ParagraphAlignment.LEFT);

            XWPFParagraph paragraph21 = wordbook.createParagraph();
            paragraph21.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run21 = paragraph21.createRun();
            run21.setText("GIẢM GIÁ: " + txtGiamGia.getText() + " VNĐ");
            run21.setBold(true);

            XWPFParagraph paragraph15 = wordbook.createParagraph();
            paragraph15.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run20 = paragraph15.createRun();
            run20.setText("TỔNG TIỀN THANH TOÁN: " + txtTongTien.getText() + " VNĐ");
            run20.setBold(true);

            XWPFParagraph paragraph24 = wordbook.createParagraph();
            paragraph24.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run24 = paragraph24.createRun();
            run24.setText("Tiền mặt: " + txtTienKhachDua.getText() + " VNĐ");

            XWPFParagraph paragraph25 = wordbook.createParagraph();
            paragraph25.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run25 = paragraph25.createRun();
            run25.setText("Tiền trả lại: " + txtTienThua.getText() + " VNĐ");

            XWPFParagraph paragraph23 = wordbook.createParagraph();
            paragraph23.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run23 = paragraph23.createRun();
            run23.setText("------------------------------------------------------------------------------------------------------------------------------------------");

            XWPFParagraph paragraph16 = wordbook.createParagraph();
            paragraph16.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run16 = paragraph16.createRun();
            run16.setText("Người lập hóa đơn");
            run16.setBold(true);
            run16.setFontSize(15);

            String idnhanvien = gcservice.getGiaoCaByMa(mac).getIdnhanvien();
            String tennhanvien = nhanVienService.getNVbyid(idnhanvien).getHotenNv();

            XWPFParagraph paragraph17 = wordbook.createParagraph();
            paragraph17.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run17 = paragraph17.createRun();
            run17.setText(tennhanvien);
            run17.setTextPosition(80);

            XWPFParagraph paragraph18 = wordbook.createParagraph();
            paragraph18.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run18 = paragraph18.createRun();
            run18.setText("Cảm ơn quý khách đã mua hàng!");

            XWPFParagraph paragraph19 = wordbook.createParagraph();
            paragraph19.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run19 = paragraph19.createRun();
            run19.setText("Hẹn gặp lại!");
            
//            JFileChooser j = new JFileChooser();
//            j.setDialogTitle("Hãy chọn địa chỉ muốn xuất file !");
//            int rs = j.showSaveDialog(null);
//            String Path = j.getSelectedFile().getAbsolutePath();
//            String name = j.getSelectedFile().getName();
//            String exclePath = Path + ".docx";
            String exclePath = "C:\\QUAN_LY_QUAN_TRA_SUA\\XUATHOADON\\"+txtMaHD.getText()+".docx";
            System.out.println(exclePath);
            try {
                FileOutputStream fos = new FileOutputStream(exclePath);
                wordbook.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Desktop.getDesktop().open(new File(exclePath));
            JOptionPane.showMessageDialog(this, "Success");
//            FileOutputStream fos = new FileOutputStream(new File("C:\\DuAn1_IT17311\\Quan_Ly_Quan_Tra_Sua\\XuatHoaDon" + txtMaHD.getText() + ".docx"));
//            try {
//                wordbook.write(fos);
//                fos.close();
//                wordbook.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
