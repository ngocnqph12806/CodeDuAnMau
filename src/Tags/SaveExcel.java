/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class SaveExcel {

    public static void exportExcel(JTable table, DefaultTableModel _modelDanhSach, String title) {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File(title + ".xls"));
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String nameFile = file.getAbsolutePath();
                if (!nameFile.endsWith(".xls")) {
                    nameFile += ".xls";
                }
                Writer bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile), "UTF8"));
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bf.append(_modelDanhSach.getColumnName(j) + "\t");
                }
                bf.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bf.write(_modelDanhSach.getValueAt(j, k) + "\t");
                    }
                    bf.write("\n");
                }
                bf.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }
}
