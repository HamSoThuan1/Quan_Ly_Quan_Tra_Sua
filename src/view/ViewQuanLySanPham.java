/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LoaiSanPham;
import model.SanPham;
import model.Size;
import model.Topping;
import serviceimql.LoaiSanPhamServiceImpl;
import serviceimql.SanPhamServiceImpl;
import serviceimql.Size_servicesimpl;
import serviceimql.ToppingServiceImpl;
import model.Combo;
import model.Combosanpham;
import service.Combo_Sanpham_service;
import serviceimql.Combo_serviceimpl;
import serviceimql.Combosp_servieimpl;
import serviceimql.SanPhamViewModelServiceImpl;
import viewModel.SanPhamViewModel;

/**
 *
 * @author hung2
 */
public class ViewQuanLySanPham extends javax.swing.JPanel {

    /**
     * Creates new form ViewQuanLySanPham
     */
    private List<SanPhamViewModel> ListVsp;
    private List<Combo> listcb;
    private List<Combosanpham> Listcbsp;
    private Combo_serviceimpl comboservice;
    private SanPhamViewModelServiceImpl sanphamviewService;
    private Combosp_servieimpl cbspService;
    private List<SanPham> listSP;
    private List<LoaiSanPham> listLSP;
    private List<Size> listSz;
    private List<Topping> listtp;
    private DefaultTableModel modelSP;
    private DefaultTableModel model;
    private DefaultTableModel modeltp;
    private SanPhamServiceImpl sanPhamService;
    private LoaiSanPhamServiceImpl loaiSpService;
    private Size_servicesimpl sizeService;
    private ToppingServiceImpl toppingService;
    private DefaultComboBoxModel comboboxLSP;
    private DefaultComboBoxModel comboboxLoaiSP;
    private DefaultComboBoxModel comboboxSz;
    private String strHinhAnh = null;

    public ViewQuanLySanPham() {
        initComponents();

        ListVsp = new ArrayList<>();
        listSP = new ArrayList<>();
        listLSP = new ArrayList<>();
        listSz = new ArrayList<>();
        listtp = new ArrayList<>();
        listcb = new ArrayList<>();
        Listcbsp = new ArrayList<>();
        modelSP = new DefaultTableModel();
        model = new DefaultTableModel();
        modeltp = new DefaultTableModel();
        comboboxLSP = new DefaultComboBoxModel();
        comboboxLoaiSP = new DefaultComboBoxModel();
        comboboxSz = new DefaultComboBoxModel();
        tblSanPham.setModel(modelSP);
        tbl_topping.setModel(modeltp);
        sanPhamService = new SanPhamServiceImpl();
        loaiSpService = new LoaiSanPhamServiceImpl();
        sizeService = new Size_servicesimpl();
        toppingService = new ToppingServiceImpl();
        comboservice = new Combo_serviceimpl();
        cbspService = new Combosp_servieimpl();
        sanphamviewService = new SanPhamViewModelServiceImpl();

        String[] heard = {"STT", "Mã SP", "Tên SP", "Loại SP", "Size", "Đơn giá", "Giá size", "Hình ảnh", "Trạng thái", "Mô tả"};
        modelSP.setColumnIdentifiers(heard);

        String[] heardTopping = {"STT", "Mã Topping", "Tên Topping", "Giá", "TrangThai"};
        modeltp.setColumnIdentifiers(heardTopping);

        Integer[] trangThai = {0, 1};
        cbo_trangThai.setModel(new DefaultComboBoxModel(trangThai));

        listSP = sanPhamService.getAll();
        listLSP = loaiSpService.getAll();
        listSz = sizeService.getAllSizes();
        listtp = toppingService.getAllToppings();

        showDataSanPham(listSP);
        showDataTopping(listtp);
        cbbLoaiSP(loaiSpService.getAll());
        cbbSize(listSz);
        filltablecb();
        filltablecbsp();
        txttencbsp.disable();
        txttenspcb.disable();
        txtsize.disable();
        Loadcb();
    }

    public void showDataSanPham(List<SanPham> lists) {
        modelSP.setRowCount(0);
        int stt = 1;
        for (SanPham sp : lists) {
            modelSP.addRow(new Object[]{
                stt++, sp.getMaSP(), sp.getTenSP(), sp.getIdLoaiSP().getTenLoaiSP(), sp.getIdSize().getTenSize(),
                sp.getDonGia(), sp.getIdSize().getGia(), sp.getHinhAnh(), sp.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng", sp.getMoTa()
            });
        }
    }

    public void showDataTopping(List<Topping> list) {
        modeltp.setRowCount(0);
        int stt = 1;
        for (Topping topping : list) {
            modeltp.addRow(new Object[]{
                stt++,
                topping.getMaTopping(),
                topping.getTenToping(),
                topping.getGia(),
                topping.getTrangThai() == 1 ? "Đang bán" : "Ngừng bán"
            });
        }
    }

    public void fillData(int index) {
        SanPham sp = listSP.get(index);
        cbbLoaiSP.setSelectedItem(sp.getIdLoaiSP().getTenLoaiSP());
        cbbSize.setSelectedItem(sp.getIdSize().getTenSize());
        cbbSize.setSelectedItem(sp.getIdSize().getGia());
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtDonGia.setText("" + sp.getDonGia());
        lblHinhAnh.setText(sp.getHinhAnh());
        txtMoTa.setText(sp.getMoTa());
        int trangThai = sp.getTrangThai();
        if (trangThai == 1) {
            rbConHang.setSelected(true);
        } else {
            rbHetHang.setSelected(true);
        }
        sp.setTrangThai(trangThai);
    }

    public void fillDataTopping(int index) {
        Topping topping = listtp.get(index);
        txt_maTopping.setText(topping.getMaTopping());
        txt_tenTopping.setText(topping.getTenToping());
        txt_gia.setText(topping.getGia() + "");
        cbo_trangThai.setSelectedIndex(topping.getTrangThai());
    }

    public void cbbLoaiSP(List<LoaiSanPham> listlsp) {
        cbbLoaiSP.setModel(comboboxLSP);
        for (LoaiSanPham loaiSanPham : listlsp) {
            comboboxLSP.addElement(loaiSanPham.getTenLoaiSP());
        }
    }

    public void cbbSize(List<Size> listsz) {
        cbbSize.setModel(comboboxSz);
        for (Size size : listsz) {
            comboboxSz.addElement(size.getTenSize());
        }
    }

    public void UpdateHinh(String image) {
        ImageIcon img = new ImageIcon(getClass().getResource("/image/" + image));
        Image anh = img.getImage();
        ImageIcon icon = new ImageIcon(anh.getScaledInstance(lblHinhAnh.getWidth(),
                lblHinhAnh.getHeight(), anh.SCALE_SMOOTH));
        lblHinhAnh.setIcon(icon);
    }

    public void resetSP() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        cbbLoaiSP.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtDonGia.setText("");
        lblHinhAnh.setText("");
        txtMoTa.setText("");
        buttonGroup1.clearSelection();
    }

    public void updateSP() {
        int index = tblSanPham.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn để cập nhật");
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa chứ!", "Thông báo!",
                    JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                LoaiSanPham lsp = new LoaiSanPham();
                String idLoaiSP = loaiSpService.getAll().get(cbbLoaiSP.getSelectedIndex()).getIdLoaiSP();
                lsp.setIdLoaiSP(idLoaiSP);

                Size size = new Size();
                String idSize = sizeService.getAllSizes().get(cbbSize.getSelectedIndex()).getIdSize();
                size.setIdSize(idSize);

                SanPham sp = new SanPham();
                String id = sanPhamService.getAll().get(index).getIdSanPham();
                double donGia = Double.parseDouble(txtDonGia.getText());
                sp.setIdLoaiSP(lsp);
                sp.setIdSize(size);
                sp.setMaSP(txtMaSP.getText());
                sp.setTenSP(txtTenSP.getText());
                sp.setDonGia(donGia);
                if (strHinhAnh == null) {
                    sp.setHinhAnh("No Avatar");
                } else {
                    sp.setHinhAnh(strHinhAnh);
                }
                sp.setMoTa(txtMoTa.getText());
                int trangThai = sp.getTrangThai();
                if (rbConHang.isSelected()) {
                    sp.setTrangThai(1);
                }
                if (rbHetHang.isSelected()) {
                    sp.setTrangThai(0);
                }
                JOptionPane.showMessageDialog(this, sanPhamService.update(sp, id));
                listSP = sanPhamService.getAll();
                showDataSanPham(listSP);
            }
        }
    }

    public void deleteSP() {
        int index = tblSanPham.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn để xóa");
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?", "Thông báo!",
                    JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                String id = sanPhamService.getAll().get(index).getIdSanPham();
                JOptionPane.showMessageDialog(this, sanPhamService.delete(id));
                listSP = sanPhamService.getAll();
                showDataSanPham(listSP);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        lblHinhAnh = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rbConHang = new javax.swing.JRadioButton();
        rbHetHang = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        btnLoaiSP = new javax.swing.JButton();
        btnSize = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_maTopping = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_tenTopping = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_gia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbo_trangThai = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        tbn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_topping = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblcombo = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtmacb = new javax.swing.JTextField();
        txttencb = new javax.swing.JTextField();
        txtsoluongcb = new javax.swing.JTextField();
        txtgiacb = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtngaytaocb = new javax.swing.JTextField();
        cbotrangthaicb = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblcacsp = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cbomacb = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txttencbsp = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblcbsp = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        cboloaicb = new javax.swing.JComboBox<>();
        txttenspcb = new javax.swing.JTextField();
        txtsize = new javax.swing.JTextField();
        cbomasp = new javax.swing.JComboBox<>();
        btnthemsp = new javax.swing.JButton();
        btnsuasp = new javax.swing.JButton();
        btnxoasp = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản Lý Sản Phẩm");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Mã SP:");

        txtMaSP.setEnabled(false);

        jLabel7.setText("Tên SP:");

        jLabel1.setText("Đơn Giá");

        jLabel2.setText("Mô tả:");

        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setText("Hình ảnh");
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        jLabel5.setText("Loại sản phẩm:");

        cbbLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Trạng thái:");

        buttonGroup1.add(rbConHang);
        rbConHang.setSelected(true);
        rbConHang.setText("Còn hàng");

        buttonGroup1.add(rbHetHang);
        rbHetHang.setText("Hết hàng");

        jLabel9.setText("Size:");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLoaiSP.setText("+");
        btnLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiSPActionPerformed(evt);
            }
        });

        btnSize.setText("+");
        btnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbConHang, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbHetHang))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnChonAnh)
                                .addGap(51, 51, 51))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSize, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6))
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btnSize))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbConHang)
                            .addComponent(rbHetHang)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChonAnh)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Tìm kiếm:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(212, 566, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(30, Short.MAX_VALUE))
        );

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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Topping");

        jLabel12.setText("Mã Topping");

        jLabel13.setText("Tên Topping");

        jLabel14.setText("Giá");

        jLabel15.setText("Trạng Thái");

        cbo_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        tbn_sua.setText("Sửa");
        tbn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        tbl_topping.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_topping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_toppingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_topping);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txt_maTopping))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tenTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_gia)
                            .addComponent(cbo_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(tbn_sua)
                    .addComponent(btn_xoa))
                .addContainerGap(335, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(534, 534, 534))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel11)
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_maTopping)
                        .addComponent(btn_them)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_tenTopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbn_sua))
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Topping", jPanel6);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Quản Lý Combo");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("tạo combo"));

        tblcombo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Combo", "Tên Combo", "Giá Combo", "Số lượng", "Ngày tạo", "Ghi chú", "Trạng thái"
            }
        ));
        tblcombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcomboMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblcombo);

        jLabel17.setText("Mã Combo");

        jLabel18.setText("Tên Combo");

        jLabel19.setText("Giá Combo");

        jLabel20.setText("Số lượng");

        jLabel21.setText("Ngày tạo");

        jLabel22.setText("Ghi chú");

        jLabel23.setText("Trạng thái");

        cbotrangthaicb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không kinh doanh", "Đang kinh doanh" }));

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane4.setViewportView(txtghichu);

        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setText("sửa");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("xóa");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel31.setText("Các sản phẩm");

        tblcacsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm ", "Tên size"
            }
        ));
        jScrollPane7.setViewportView(tblcacsp);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgiacb, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsoluongcb, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(btnadd)
                                        .addGap(89, 89, 89)
                                        .addComponent(btnupdate))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txttencb, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtngaytaocb)
                            .addComponent(cbotrangthaicb, 0, 135, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btndelete)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21)
                    .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaytaocb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txttencb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cbotrangthaicb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txtgiacb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtsoluongcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnupdate)
                    .addComponent(btndelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý sản phẩm trong combo"));

        jLabel24.setText("Mã combo");

        cbomacb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbomacb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbomacbItemStateChanged(evt);
            }
        });
        cbomacb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomacbActionPerformed(evt);
            }
        });

        jLabel25.setText("Tên Combo");

        jLabel26.setText("Loại sản phẩm");

        jLabel27.setText("Tên sản phẩm");

        jLabel28.setText("Size");

        tblcbsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Combo", "Tên Combo", "Loại sản phẩm", "Mã Sản phẩm", "Tên sản phẩm", "Size"
            }
        ));
        tblcbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcbspMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblcbsp);

        jLabel30.setText("Mã sản phẩm");

        cboloaicb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboloaicb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboloaicbItemStateChanged(evt);
            }
        });

        cbomasp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbomasp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbomaspItemStateChanged(evt);
            }
        });
        cbomasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomaspActionPerformed(evt);
            }
        });

        btnthemsp.setText("Thêm ");
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        btnsuasp.setText("Sửa");
        btnsuasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaspActionPerformed(evt);
            }
        });

        btnxoasp.setText("Xóa ");
        btnxoasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbomacb, 0, 106, Short.MAX_VALUE)
                            .addComponent(cboloaicb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttenspcb)
                            .addComponent(cbomasp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttencbsp, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtsize))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnthemsp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsuasp)
                .addGap(110, 110, 110)
                .addComponent(btnxoasp)
                .addGap(52, 52, 52))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbomacb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txttencbsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cboloaicb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cbomasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(txttenspcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemsp)
                    .addComponent(btnsuasp)
                    .addComponent(btnxoasp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(105, 105, 105))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(507, 507, 507)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(140, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Combo", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            double donGia = Double.parseDouble(txtDonGia.getText());
            if(txtDonGia.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Đơn giá Không được để trống");
                return;
            }
            if (donGia < 0) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số");
            return;
        }
        boolean isOK = true;
        if (isOK) {
            LoaiSanPham lsp = new LoaiSanPham();
            String idLoaiSP = loaiSpService.getAll().get(cbbLoaiSP.getSelectedIndex()).getIdLoaiSP();
            lsp.setIdLoaiSP(idLoaiSP);

            Size size = new Size();
            String idSize = sizeService.getAllSizes().get(cbbSize.getSelectedIndex()).getIdSize();
            size.setIdSize(idSize);

            SanPham sp = new SanPham();
            int index = sanPhamService.getAll().size() + 1;
            double donGia = Double.parseDouble(txtDonGia.getText());
            sp.setIdLoaiSP(lsp);
            sp.setIdSize(size);
            sp.setMaSP("SP" + index);
            sp.setTenSP(txtTenSP.getText());
            sp.setDonGia(donGia);
            if (strHinhAnh == null) {
                sp.setHinhAnh("No Avatar");
            } else {
                sp.setHinhAnh(strHinhAnh);
            }
            int trangThai = sp.getTrangThai();
            if (rbConHang.isSelected()) {
                sp.setTrangThai(1);
            }
            if (rbHetHang.isSelected()) {
                sp.setTrangThai(0);
            }
            sp.setMoTa(txtMoTa.getText());
            JOptionPane.showMessageDialog(this, sanPhamService.insert(sp));
            listSP = sanPhamService.getAll();
            showDataSanPham(listSP);
            resetSP();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSizeActionPerformed
        // TODO add your handling code here:
        ViewChinh mainFormView = null;
        ViewSize size = new ViewSize(mainFormView, true);
        size.setVisible(true);
    }//GEN-LAST:event_btnSizeActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        deleteSP();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiSPActionPerformed
        // TODO add your handling code here:
        ViewChinh mainFormView = null;
//        ViewQuanLySanPham mainFormView = null;
        ViewLoaiSanPham loaiSP = new ViewLoaiSanPham(mainFormView, true);
        loaiSP.setVisible(true);
    }//GEN-LAST:event_btnLoaiSPActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        updateSP();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        resetSP();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("D:\\DuAn1_IT17311\\Quan_Ly_Quan_Tra_Sua\\src\\image");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            strHinhAnh = file.getName();
            lblHinhAnh.setText("");
            int width = lblHinhAnh.getWidth();
            int height = lblHinhAnh.getHeight();
            lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String tenSP = txtSearch.getText();
        if (txtSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm để tìm kiếm");
            return;
        } else {
            List<SanPham> listsp = sanPhamService.searchByTen(tenSP);
            showDataSanPham(listsp);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbl_toppingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_toppingMouseClicked
        // TODO add your handling code here:
        int index = tbl_topping.getSelectedRow();
        fillDataTopping(index);
    }//GEN-LAST:event_tbl_toppingMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        Topping t = new Topping();
        t.setMaTopping(txt_maTopping.getText());
        t.setTenToping(txt_tenTopping.getText());
        t.setGia(Double.parseDouble(txt_gia.getText()));
        t.setTrangThai((int) cbo_trangThai.getSelectedItem());
        JOptionPane.showMessageDialog(this, toppingService.addTopping(t));
        listtp = toppingService.getAllToppings();
        showDataTopping(listtp);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        String MaTopping = txt_maTopping.getText();
        JOptionPane.showMessageDialog(this, toppingService.deleteTopping(MaTopping));
        listtp = toppingService.getAllToppings();
        showDataTopping(listtp);
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tbn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_suaActionPerformed
        // TODO add your handling code here:
        Topping t = new Topping();
        String ma = txt_maTopping.getText();
        t.setMaTopping(ma);
        t.setTenToping(txt_tenTopping.getText());
        t.setGia(Double.parseDouble(txt_gia.getText()));
        t.setTrangThai((int) cbo_trangThai.getSelectedItem());
        JOptionPane.showMessageDialog(this, toppingService.updateTopping(t, ma));
        listtp = toppingService.getAllToppings();
        showDataTopping(listtp);
    }//GEN-LAST:event_tbn_suaActionPerformed

    private void tblcomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcomboMouseClicked
        int index = tblcombo.getSelectedRow();
        model = (DefaultTableModel) tblcombo.getModel();
        String ma = model.getValueAt(index, 0).toString();
        Combo cb = comboservice.GetCBnyma(ma);
        showdetail(cb);
        Loadcb();
    }//GEN-LAST:event_tblcomboMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        if(txtmacb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mã combo ko được để trống");
            return;
        }
        listcb=comboservice.getallCB();
        for(int i=0;i<listcb.size();i++){
            if(txtmacb.getText().equals(listcb.get(i).getMacb())){
                JOptionPane.showMessageDialog(this,"Mã combo ko được để trùng");
            return;
            }
        }
        if(txttencb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"tên combo ko được để trống");
            return;
        }
        if(txtgiacb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Giá combo ko được để trống");
            return;
        }
        double gia;
        try {
            gia=Double.parseDouble(txtgiacb.getText());
            if(gia<0){
            JOptionPane.showMessageDialog(this,"Giá combo phải lớn hơn 0");
            return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Giá combo phải là số");
            return;
        }
        if(txtsoluongcb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"số lượng ko được để trống");
            return;
        }
        int sl;
        try {
            sl =Integer.parseInt(txtsoluongcb.getText());
            if(sl<0){
            JOptionPane.showMessageDialog(this,"số lượng phải lớn hơn 0");
            return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"số lượng phải là số");
            return;
        }
        if(txtngaytaocb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"ngày tạo ko được để trống");
            return;
        }
        try {
            Date Ngaysinh = new SimpleDateFormat("MM-dd-yyyy").parse(txtngaytaocb.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"sai định dạng ngày tạo, Mời nhập lại");
                return;
        }
        try {
            Combo cb = getCBbyfrom();
            comboservice.add(cb);
            filltablecb();
            Loadcb();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if(txtmacb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mã combo ko được để trống");
            return;
        }
        
        
        if(txttencb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"tên combo ko được để trống");
            return;
        }
        if(txtgiacb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Giá combo ko được để trống");
            return;
        }
        double gia;
        try {
            gia=Double.parseDouble(txtgiacb.getText());
            if(gia<0){
            JOptionPane.showMessageDialog(this,"Giá combo phải lớn hơn 0");
            return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Giá combo phải là số");
            return;
        }
        if(txtsoluongcb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"số lượng ko được để trống");
            return;
        }
        int sl;
        try {
            sl =Integer.parseInt(txtsoluongcb.getText());
            if(sl<0){
            JOptionPane.showMessageDialog(this,"số lượng phải lớn hơn 0");
            return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"số lượng phải là số");
            return;
        }
        if(txtngaytaocb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"ngày tạo ko được để trống");
            return;
        }
        try {
            Date Ngaysinh = new SimpleDateFormat("MM-dd-yyyy").parse(txtngaytaocb.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"sai định dạng ngày tạo, Mời nhập lại");
                return;
        }
        try {
            Combo cb = getCBbyfrom();
            comboservice.update(cb);
            filltablecb();
            Loadcb();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if(txtmacb.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mã combo ko được để trống");
            return;
        }
        try {
            Combo cb = getCBbyfrom();
            comboservice.delete(cb);
            filltablecb();
            Loadcb();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void cbomacbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbomacbItemStateChanged
        
        
        if (cbomacb.getItemCount() > 0) {
            String macbo = cbomacb.getSelectedItem().toString();
            Combo cb = comboservice.GetCBnyma(macbo);
            txttencbsp.setText(cb.getTencb());
        }

    }//GEN-LAST:event_cbomacbItemStateChanged

    private void cbomacbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomacbActionPerformed

    }//GEN-LAST:event_cbomacbActionPerformed

    private void tblcbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcbspMouseClicked
        int index = tblcbsp.getSelectedRow();
        String id = cbspService.getallCBSP().get(index).getID();
        Combosanpham cbsp = cbspService.getCBSPbyID(id);
        showdetailcbsp(cbsp);

    }//GEN-LAST:event_tblcbspMouseClicked

    private void cboloaicbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboloaicbItemStateChanged
        if (cboloaicb.getItemCount() > 0) {
            String ma = (String) cboloaicb.getSelectedItem();
            ListVsp = sanphamviewService.getByLoaiSanPham(ma);
            cbomasp.removeAllItems();
            for (int i = 0; i < ListVsp.size(); i++) {
                cbomasp.addItem(ListVsp.get(i).getMaSP());
            }
        }
    }//GEN-LAST:event_cboloaicbItemStateChanged

    private void cbomaspItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbomaspItemStateChanged

        if (cbomasp.getItemCount() > 0) {
            String ma = cbomasp.getSelectedItem().toString();
            SanPhamViewModel sp = sanphamviewService.getSanPhambyma(ma);

            txttenspcb.setText(sp.getTenSP());
            txtsize.setText(sp.getSizeSP());

        }
    }//GEN-LAST:event_cbomaspItemStateChanged

    private void cbomaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomaspActionPerformed

    }//GEN-LAST:event_cbomaspActionPerformed

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        Combosanpham cb = Getcbspbyform();
        cbspService.add(cb);
        filltablecbsp();
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btnsuaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaspActionPerformed
        int index = tblcbsp.getSelectedRow();
        String id = cbspService.getallCBSP().get(index).getID();
        String macb = (String) cbomacb.getSelectedItem();
        String tencb = txttencbsp.getText();
        String tenloaisp = (String) cboloaicb.getSelectedItem();
        String masp = (String) cbomasp.getSelectedItem();
        String tensp = txttenspcb.getText();
        String tensize = txtsize.getText();
        int tt;
        if (cbotrangthaicb.getSelectedItem().equals("Không kinh doanh")) {
            tt = 0;
        } else {
            tt = 1;
        }
        int trangthai = tt;
        Combosanpham cbsp = new Combosanpham(id, macb, tencb, tenloaisp, masp, tensp, tensize, trangthai);
        cbspService.update(cbsp);
        filltablecbsp();
    }//GEN-LAST:event_btnsuaspActionPerformed

    private void btnxoaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaspActionPerformed
        int index = tblcbsp.getSelectedRow();
        String id = cbspService.getallCBSP().get(index).getID();
        Combosanpham cbsp = cbspService.getCBSPbyID(id);
        cbspService.delete(cbsp);
        filltablecbsp();
    }//GEN-LAST:event_btnxoaspActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    public Combo getCBbyfrom() throws ParseException {
        String ma = txtmacb.getText();
        String ten = txttencb.getText();
        double gia = Double.parseDouble(txtgiacb.getText());
        int soluong = Integer.parseInt(txtsoluongcb.getText());
        Date ngaytao = new SimpleDateFormat("MM-dd-yyyy").parse(txtngaytaocb.getText());
        String ghichu = txtghichu.getText();
        int tt;
        if (cbotrangthaicb.getSelectedItem().equals("Không kinh doanh")) {
            tt = 0;
        } else {
            tt = 1;
        }
        int trangthai = tt;
        Combo cb = new Combo(ma, ten, gia, soluong, ngaytao, ghichu, trangthai);
        return cb;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoaiSP;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSize;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsuasp;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnxoasp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JComboBox<String> cboloaicb;
    private javax.swing.JComboBox<String> cbomacb;
    private javax.swing.JComboBox<String> cbomasp;
    private javax.swing.JComboBox<String> cbotrangthaicb;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rbConHang;
    private javax.swing.JRadioButton rbHetHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tbl_topping;
    private javax.swing.JTable tblcacsp;
    private javax.swing.JTable tblcbsp;
    private javax.swing.JTable tblcombo;
    private javax.swing.JButton tbn_sua;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_maTopping;
    private javax.swing.JTextField txt_tenTopping;
    private javax.swing.JTextArea txtghichu;
    private javax.swing.JTextField txtgiacb;
    private javax.swing.JTextField txtmacb;
    private javax.swing.JTextField txtngaytaocb;
    private javax.swing.JTextField txtsize;
    private javax.swing.JTextField txtsoluongcb;
    private javax.swing.JTextField txttencb;
    private javax.swing.JTextField txttencbsp;
    private javax.swing.JTextField txttenspcb;
    // End of variables declaration//GEN-END:variables

    private void filltablecb() {
        listcb = comboservice.getallCB();
        model = (DefaultTableModel) tblcombo.getModel();
        model.setRowCount(0);
        for (int i = 0; i < listcb.size(); i++) {
            String tt;
            if (listcb.get(i).getTrangthai() == 1) {
                tt = "Đang kinh doanh";
            } else {
                tt = "Không kinh doanh";
            }

            Object[] data = new Object[]{
                listcb.get(i).getMacb(), listcb.get(i).getTencb(), listcb.get(i).getGiacb(), listcb.get(i).getSoluong(), listcb.get(i).getNgaytao(), listcb.get(i).getGhichu(), tt
            };
            model.addRow(data);
        }
    }

    private void showdetail(Combo cb) {
        txtmacb.setText(cb.getMacb());
        txttencb.setText(cb.getTencb());
        txtgiacb.setText(cb.getGiacb() + "");
        txtsoluongcb.setText(cb.getSoluong() + "");
        txtngaytaocb.setText(cb.getNgaytao() + "");
        txtghichu.setText(cb.getGhichu());
        String tt = null;
        if (cb.getTrangthai() == 1) {
            tt = "Đang kinh doanh";
        }
        if (cb.getTrangthai() == 0) {
            tt = "Không kinh doanh";
        }
        cbotrangthaicb.setSelectedItem(tt);
        Listcbsp = cbspService.getCBSPbyma(cb.getMacb());
        model = (DefaultTableModel) tblcacsp.getModel();
        model.setRowCount(0);
        for (int i = 0; i < Listcbsp.size(); i++) {
            Object[] data = new Object[]{Listcbsp.get(i).getTensp(), Listcbsp.get(i).getTensize()};
            model.addRow(data);
        }

    }

    private void Loadcb() {
        cbomacb.removeAllItems();
        cboloaicb.removeAllItems();

        listcb = comboservice.getallCB();
        listLSP = loaiSpService.getAll();
        ListVsp = sanphamviewService.getAllSanPham();

        for (int i = 0; i < listcb.size(); i++) {
            cbomacb.addItem(listcb.get(i).getMacb());
        }
        /*for(int i=0;i<ListVsp.size();i++){
            cbomasp.addItem(ListVsp.get(i).getMaSP());
        }*/
        for (int i = 0; i < listLSP.size(); i++) {
            cboloaicb.addItem(listLSP.get(i).getTenLoaiSP());
        }

    }

    private Combosanpham Getcbspbyform() {
        String macb = (String) cbomacb.getSelectedItem();
        String tencb = txttencbsp.getText();
        String tenloaisp = (String) cboloaicb.getSelectedItem();
        String masp = (String) cbomasp.getSelectedItem();
        String tensp = txttenspcb.getText();
        String tensize = txtsize.getText();
        int tt;
        if (cbotrangthaicb.getSelectedItem().equals("Không kinh doanh")) {
            tt = 0;
        } else {
            tt = 1;
        }
        int trangthai = tt;
        Combosanpham cb = new Combosanpham(macb, tencb, tenloaisp, masp, tensp, tensize, trangthai);
        return cb;
    }

    private void filltablecbsp() {
        Listcbsp = cbspService.getallCBSP();
        model = (DefaultTableModel) tblcbsp.getModel();
        model.setRowCount(0);
        for (int i = 0; i < Listcbsp.size(); i++) {
            Object[] data = new Object[]{
                Listcbsp.get(i).getMacb(), Listcbsp.get(i).getTencb(), Listcbsp.get(i).getTenloaisp(),
                Listcbsp.get(i).getMasp(), Listcbsp.get(i).getTensp(), Listcbsp.get(i).getTensize()
            };

            model.addRow(data);
        }
    }

    private void showdetailcbsp(Combosanpham cbsp) {
        cbomacb.setSelectedItem(cbsp.getMacb());
        cboloaicb.setSelectedItem(cbsp.getTenloaisp());
        cbomasp.setSelectedItem(cbsp.getMasp());
    }
}
