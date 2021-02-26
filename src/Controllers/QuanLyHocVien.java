/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.HocVien;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public interface QuanLyHocVien {

    List<HocVien> getListHocVien();

    boolean addHocVien(HocVien hocVien);

    boolean removeHocVien(String maHocVien);

    HocVien getHocVienById(String maHocVien);

    boolean editHocVien(HocVien hocVien);

    int getIdHocVien();

}
