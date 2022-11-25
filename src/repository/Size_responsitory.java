/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBCHeper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Nhanvien;
import model.Size;
import static repository.Nhanvien_repository.getallNV;

/**
 *
 * @author Acer
 */
public class Size_responsitory {
    public List<Size> getAllSizes(){     
        String sql = "select * from SIZE";
        try(Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
              List<Size> sizes = new ArrayList<>();
              ResultSet rs = pr.executeQuery();
            while(rs.next()){
               Size size = new Size( rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
               sizes.add(size);
            }
            return sizes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  public boolean addSize(Size si){
      String sql = "INSERT INTO [dbo].[SIZE]\n" +
"           ([MaSize]\n" +
"           ,[TenSize]\n" +
"           ,[Gia]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,?,?,?)";
      int check = 0;
      try(Connection con = DBContext.getConnection();PreparedStatement pr = con.prepareStatement(sql)) {
          pr.setObject(1, si.getMaSize());
          pr.setObject(2, si.getTenSize());
          pr.setObject(3, si.getGia());
          pr.setObject(4, si.getTrangThai());
          check = pr.executeUpdate();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return check > 0;
  }
  public boolean deleteSize(String Ma){
      String sql = "Delete from SIZE where MaSize = ?";
      int check = 0;
      try(Connection con = DBContext.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
          pr.setObject(1, Ma);
          check = pr.executeUpdate();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return check > 0;
  }
  public boolean updateSize(Size si, String ma){
      String sql = "Update SIZE set TenSize = ?, Gia = ?, TrangThai = ? where MaSize = ?";
      int check = 0;
      try(Connection con = DBContext.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
          pr.setObject(1, si.getTenSize());
          pr.setObject(2, si.getGia());
          pr.setObject(3, si.getTrangThai());
          pr.setObject(4, ma);
          check = pr.executeUpdate();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return check > 0;
  }
}
