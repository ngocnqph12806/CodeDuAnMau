/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NgocPJa
 */
public class Pattern {

    public static String checkMa(String inputMa, String title) {
        if (inputMa.isBlank() || inputMa.isEmpty()) {
            return title + " không được dể trống!\n";
        }
        if (inputMa.length() > 10) {
            return title + " chỉ được phép tối đa 10 ký tự!\n";
        }
        if (inputMa.matches("[a-zA-Z0-9]+")) {
            return "";
        }
        return title + " không được chứa các ký tự đặc biệt!\n";
    }

    public static String checkTen(String inputTen, String title) {
        if (inputTen.isBlank() || inputTen.isEmpty()) {
            return title + " không được để trống!\n";
        }
        if (!inputTen.matches("\\p{Punct}")) {
            return "";
        }
        for (char c : inputTen.toCharArray()) {
            if ((c + "").matches("[0-9]")) {
                return title + " không được chứa số!\n";
            }
        }
        return title + " không được chứa các ký đặc biệt!\n";
    }

    public static String checkThoiLuong(String inputSoNguyen, String title) {
        if (inputSoNguyen.isBlank() || inputSoNguyen.isEmpty()) {
            return title + " không được để trống!\n";
        }
        try {
            int soNguyen = Integer.parseInt(inputSoNguyen);
            if (soNguyen <= 0) {
                return title + " phải lớn hơn 0.\n";
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return title + " đã nhập không phải là một số nguyên dương!\n";
        }
    }

    public static String checkHocPhi(String inputSoThuc, String title) {
        if (inputSoThuc.isBlank() || inputSoThuc.isEmpty()) {
            return title + " không được để trống!\n";
        }
        try {
            double soThuc = Double.parseDouble(inputSoThuc);
            if (soThuc <= 0) {
                return title + " nhập vào phải lớn hơn 0.\n";
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return title + " nhập vào không phải là một số thực!\n";
        }
    }

    public static String checkNgay(String inputNgay, String title) {
        if (inputNgay.isBlank() || inputNgay.isEmpty()) {
            return title + " không được để trống!\n";
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(inputNgay);
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return title + " phải có định dạng dd-MM-yyyy\n";
        }
    }

    public static String checkEmail(String inputEmail) {
        if (inputEmail.isBlank() || inputEmail.isEmpty()) {
            return "Email không được để trống!\n";
        }
        if (inputEmail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            return "";
        }
        return "Email nhập vào không hợp lệ!\n";
    }

    public static String checkSoDienThoai(String inputSoDienThoai) {
        if (inputSoDienThoai.isBlank() || inputSoDienThoai.isEmpty()) {
            return "Số điện thoại không được để trống!\n";
        }
        if (inputSoDienThoai.matches("\\d{3}\\s\\d{3}-\\d{4}")
                || inputSoDienThoai.matches("03[0-9]{8}")
                || inputSoDienThoai.matches("09[0-9]{8}")) {
            return "";
        }
        return "Số điện thoại nhập vào không hợp lệ!\n";
    }

    public static String checkHinhAnh(String inputHinhAnh, String title) {
        if (inputHinhAnh.isBlank() || inputHinhAnh.isEmpty()) {
            return title + " chưa được thêm!\n";
        }
        String duoiAnh = inputHinhAnh.substring(inputHinhAnh.lastIndexOf("."));
        if (duoiAnh.equalsIgnoreCase(".png") || duoiAnh.equalsIgnoreCase(".jpg")) {
            return "";
        }
        return title + " không đúng định dạng!\n";
    }

}
