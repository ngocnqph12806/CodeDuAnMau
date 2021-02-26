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
public class QuanLyHocVienImplement implements QuanLyHocVien {

//    private DAOHocVien _daoHocVien = new DAOHocVien();
//    private List<HocVien> _lstHocVien = null;
    public QuanLyHocVienImplement() {
//        _lstHocVien = new ArrayList<>();
//        _lstHocVien = _daoHocVien.selectAll();
    }

    @Override
    public List<HocVien> getListHocVien() {
        return EntityList._lstHocVien;
    }

    @Override
    public boolean addHocVien(HocVien hocVien) {
        if (hocVien != null) {
            for (HocVien x : EntityList._lstHocVien) {
                if (hocVien.getMaNguoiHoc().equals(x.getMaNguoiHoc())
                        && hocVien.getMaKhoaHoc().equals(x.getMaKhoaHoc())) {
                    return false;
                }
            }
            if (EntityList._daoHocVien.insert(hocVien)) {
                hocVien.setMaHocVien(EntityList._daoHocVien.getIdentity() + "");
                EntityList._lstHocVien.add(hocVien);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeHocVien(String maHocVien) {
        if (maHocVien != null) {
            int index = getIndexHocVien(maHocVien);
            if (index > -1) {
                if (EntityList._daoHocVien.delete(maHocVien)) {
                    EntityList._lstHocVien.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndexHocVien(String maHocVien) {
        if (maHocVien == null) {
            return -2;
        }
        for (int i = 0; i < EntityList._lstHocVien.size(); i++) {
            if (maHocVien.equals(EntityList._lstHocVien.get(i).getMaHocVien())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public HocVien getHocVienById(String maHocVien) {
        if (maHocVien != null) {
            for (HocVien x : EntityList._lstHocVien) {
                if (x.getMaHocVien().equals(maHocVien)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public boolean editHocVien(HocVien hocVien) {
        if (hocVien != null) {
            for (HocVien x : EntityList._lstHocVien) {
                if (x.getMaHocVien().equals(hocVien.getMaHocVien())) {
                    if (EntityList._daoHocVien.update(hocVien)) {
                        x.setDiem(hocVien.getDiem());
                        return true;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public int getIdHocVien() {
        return Controllers.EntityList._daoHocVien.getIdentity();
    }

}
