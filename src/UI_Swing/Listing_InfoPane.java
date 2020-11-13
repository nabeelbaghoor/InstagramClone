package UI_Swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Listing_InfoPane extends JPanel {

    /**
     * Create the panel.
     */
    public Listing_InfoPane(String Username) {
        setBackground(new Color(255, 255, 224));
        setPreferredSize(new Dimension(400, 70));
        setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        setLayout(null);

        JLabel lblName = new JLabel(Username);
        lblName.setBackground(new Color(255, 255, 255));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(10, 11, 235, 20);
        lblName.setOpaque(true);
        add(lblName);

        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(255, 24, 135, 25);
        add(btnRemove);

    }
}