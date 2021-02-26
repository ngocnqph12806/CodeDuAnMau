/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author NgocPJa
 */
public class MsgThongBao {

    private static String title = "Hệ thống quản lý đào tạo EduSys";

    public static void alert(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component parent, String msg) {
        return JOptionPane.showConfirmDialog(parent, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }

    public static String prompt(Component parent, String msg) {
        return JOptionPane.showInputDialog(parent, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
