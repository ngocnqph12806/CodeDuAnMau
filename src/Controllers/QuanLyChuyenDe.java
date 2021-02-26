/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ChuyenDe;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public interface QuanLyChuyenDe {

    List<ChuyenDe> getListChuyenDe();

    ChuyenDe getChuyenDeById(String maChuyenDe);

    boolean addChuyenDe(ChuyenDe cd);

    boolean editChuyenDe(ChuyenDe cd);

    boolean removeChuyenDe(ChuyenDe cd);

}
