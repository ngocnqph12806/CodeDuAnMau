/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NguoiHoc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyNguoiHocImplement implements QuanLyNguoiHoc {

//    private DAONguoiHoc _daoNguoiHoc = new DAONguoiHoc();
//    private List<NguoiHoc> _lstNguoiHocs = null;
    public QuanLyNguoiHocImplement() {
//        _lstNguoiHocs = new ArrayList<>();
//        _lstNguoiHocs = _daoNguoiHoc.selectAll();
    }

    @Override
    public List<NguoiHoc> getListNguoihoc() {
        return EntityList._lstNguoiHocs;
    }

    @Override
    public String getTenNguoiHoc(String maNguoiHoc) {
        if (maNguoiHoc != null) {
            for (NguoiHoc x : EntityList._lstNguoiHocs) {
                if (x.getMaNguoiHoc().equalsIgnoreCase(maNguoiHoc)) {
                    return x.getHoTen();
                }
            }
        }
        return null;
    }

    @Override
    public NguoiHoc getNguoiHocById(String maNguoiHoc) {
        if (maNguoiHoc != null) {
            for (NguoiHoc x : EntityList._lstNguoiHocs) {
                if (x.getMaNguoiHoc().equalsIgnoreCase(maNguoiHoc)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public List<NguoiHoc> getListTimKiem(String maNguoiHoc) {
        List<NguoiHoc> lstTimKiem = new ArrayList<>();
        if (maNguoiHoc != null) {
            for (NguoiHoc x : EntityList._lstNguoiHocs) {
                if (x.getHoTen().toLowerCase().contains(maNguoiHoc.toLowerCase())) {
                    lstTimKiem.add(x);
                }
            }
        }
        return lstTimKiem;
    }

    @Override
    public boolean removeNguoiHoc(String maNguoiHoc) {
        if (maNguoiHoc != null) {
            int index = getIndexNguoiHoc(maNguoiHoc);
            if (index > -1) {
                if (EntityList._daoNguoiHoc.delete(maNguoiHoc)) {
                    EntityList._lstNguoiHocs.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndexNguoiHoc(String maNguoiHoc) {
        if (maNguoiHoc == null) {
            return -2;
        }
        for (int i = 0; i < EntityList._lstNguoiHocs.size(); i++) {
            if (EntityList._lstNguoiHocs.get(i).getMaNguoiHoc().equalsIgnoreCase(maNguoiHoc)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addNguoiHoc(NguoiHoc nh) {
        if (nh != null) {
            if (getNguoiHocById(nh.getMaNguoiHoc()) == null) {
                if (EntityList._daoNguoiHoc.insert(nh)) {
                    EntityList._lstNguoiHocs.add(nh);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean editNguoiHoc(NguoiHoc nh) {
        if (nh != null) {
            int index = getIndexNguoiHoc(nh.getMaNguoiHoc());
            if (index > -1) {
                if (EntityList._daoNguoiHoc.update(nh)) {
                    EntityList._lstNguoiHocs.set(index, nh);
                    return true;
                }
            }
        }
        return false;
    }

}
