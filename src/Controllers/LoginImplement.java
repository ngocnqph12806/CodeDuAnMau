/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAODangNhap;
import Models.NhanVien;

/**
 *
 * @author NgocPJa
 */
public class LoginImplement implements Login {

    private DAODangNhap _dAODangNhap = new DAODangNhap();

    @Override
    public void login(String taiKhoan, String matKhau) {
        Tags.Login._nhanVien = _dAODangNhap.getDangNhap(taiKhoan, matKhau);
    }

}
