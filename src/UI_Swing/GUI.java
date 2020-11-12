package UI_Swing;

import Models.IUI;
import Models.Operations;

import javax.swing.*;
import java.awt.*;

public class GUI implements IUI {
    public GUI() {
    }

    public void start(Operations BLOp) {
        //Look Setup
        try {
            //com.sun.java.swing.plaf.gtk.GTKLookAndFeel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main_Frame frame = new Main_Frame(BLOp);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
