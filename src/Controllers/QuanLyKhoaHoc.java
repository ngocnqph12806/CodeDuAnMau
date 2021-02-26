/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.KhoaHoc;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public interface QuanLyKhoaHoc {

    List<KhoaHoc> getListKhoaHoc();

    KhoaHoc getKhoaHocById(String maKhoaHoc);

    boolean removeKhoaHoc(KhoaHoc khoaHoc);

    List<KhoaHoc> getListKhoaHocByIdChuyenDe(String maChuyenDe);

    boolean addKhoaHoc(KhoaHoc khoaHoc);

    boolean editKhoaHoc(KhoaHoc khoaHoc);

    int getIdKhoaHoc();
}
