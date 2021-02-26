/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class Tab {

    private static List<Component> _lstOpen = new ArrayList<>();

    public static void openTab(Component component) {
        if (_lstOpen.size() > 20) {
            MsgThongBao.alert(component, "Bạn chỉ có thể mở tối đa 20 tab.");
            return;
        }
        component.setVisible(true);
        _lstOpen.add(component);
    }

    public static void closeTab(Component component) {
        if (_lstOpen.size() > 0) {
            for (Component x : _lstOpen) {
                if (!x.isVisible()) {
                    _lstOpen.remove(x);
                    return;
                }
            }
        }
    }

    public static void closeAllTab() {
        if (_lstOpen != null && !_lstOpen.isEmpty()) {
            for (Component x : _lstOpen) {
                x.setVisible(false);
            }
        }
    }
}
