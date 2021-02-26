/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NhanVien;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyNhanVienImplement implements QuanLyNhanVien {

//    private DAONhanVien _daoNhanVien = new DAONhanVien();
//    private List<NhanVien> _lstNhanVien = null;
    public QuanLyNhanVienImplement() {
//        _lstNhanVien = new ArrayList<>();
//        _lstNhanVien = _daoNhanVien.selectAll();
    }

    @Override
    public boolean doiMatKhau(NhanVien nhanVien) {
        if (nhanVien != null) {
            if (EntityList._daoNhanVien.update(nhanVien)) {
                EntityList._lstNhanVien.set(getIndex(nhanVien.getMaNV()), nhanVien);
                return true;
            }
        }
        return false;
    }

    private int getIndex(String maNV) {
        if (maNV == null) {
            return -2;
        }
        if (!maNV.isBlank() || !maNV.isEmpty()) {
            for (int i = 0; i < EntityList._lstNhanVien.size(); i++) {
                if (EntityList._lstNhanVien.get(i).getMaNV().equalsIgnoreCase(maNV)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public List<NhanVien> getListNhanVien() {
        return EntityList._lstNhanVien;
    }

    @Override
    public NhanVien getNhanVienById(String maNhanVien) {
        if (maNhanVien != null) {
            for (NhanVien x : EntityList._lstNhanVien) {
                if (x.getMaNV().equalsIgnoreCase(maNhanVien)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public boolean removeNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            if (getNhanVienById(nhanVien.getMaNV()) != null) {
                if (EntityList._daoNhanVien.delete(nhanVien.getMaNV())) {
                    EntityList._lstNhanVien.remove(nhanVien);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            if (getNhanVienById(nhanVien.getMaNV()) == null) {
                if (EntityList._daoNhanVien.insert(nhanVien)) {
                    EntityList._lstNhanVien.add(nhanVien);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean editNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            int index = getIndex(nhanVien.getMaNV());
            if (index > -1) {
                if (EntityList._daoNhanVien.update(nhanVien)) {
                    EntityList._lstNhanVien.set(index, nhanVien);
                    return true;
                }
            }
        }
        return false;
    }

}
