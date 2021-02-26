/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import Models.NhanVien;

/**
 *
 * @author NgocPJa
 */
public class Login {

    public static NhanVien _nhanVien = null;

    public static boolean checkNhanVien() {
        if (_nhanVien != null && _nhanVien.isVaiTro()) {
            return true;
        }
        return false;
    }

}
