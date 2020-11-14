package UI_Swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notif_Template extends JPanel {

    /**
     * Create the panel.
     */
    public Notif_Template(String msg, boolean type) {

        if (!type)
        {
            setBackground(new Color(255, 255, 224));
        }
        else
            setBackground(SystemColor.controlShadow);
        setPreferredSize(new Dimension(400, 70));
        setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        setLayout(null);

        JTextArea lblName = new JTextArea(msg);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblName.setBackground(new Color(255, 255, 255));
        lblName.setBounds(10, 11, 235, 49);
        lblName.setBorder(new LineBorder(new Color(128, 0, 0), 1, true));
        lblName.setOpaque(true);
        lblName.setEditable(false);
        lblName.setLineWrap(true);
        lblName.setWrapStyleWord(true);
        add(lblName);

        JButton btnCheckPost = new JButton("Check Post");
        btnCheckPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnCheckPost.setBounds(255, 11, 135, 25);
        add(btnCheckPost);

        JButton btnRemovePost = new JButton("Remove");
        btnRemovePost.setBounds(255, 35, 135, 25);
        add(btnRemovePost);

    }
}

