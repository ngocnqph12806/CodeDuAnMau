/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NguoiHoc;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public interface QuanLyNguoiHoc {

    List<NguoiHoc> getListNguoihoc();

    String getTenNguoiHoc(String maNguoiHoc);

    NguoiHoc getNguoiHocById(String maNguoiHoc);

    List<NguoiHoc> getListTimKiem(String maNguoiHoc);

    boolean removeNguoiHoc(String maNguoiHoc);

    boolean addNguoiHoc(NguoiHoc nguoiHoc);

    boolean editNguoiHoc(NguoiHoc nguoiHoc);

}
