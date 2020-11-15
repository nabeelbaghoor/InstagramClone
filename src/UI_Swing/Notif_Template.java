package UI_Swing;

import Models.Operations;
import Models.Post;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notif_Template extends JPanel {

    /**
     * Create the panel.
     */
    public Notif_Template(String msg , String notifid, String postid, boolean type, Operations BLOp) {

        if (!type)
        {
            setBackground(new Color(255, 255, 224));
        }
        else
            setBackground(SystemColor.controlShadow);
        setPreferredSize(new Dimension(400, 105));
        setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        setLayout(null);

        JTextArea lblName = new JTextArea(msg);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblName.setBackground(new Color(255, 255, 255));
        lblName.setBounds(10, 37, 285, 53);
        lblName.setBorder(new LineBorder(new Color(128, 0, 0), 1, true));
        lblName.setOpaque(true);
        lblName.setEditable(false);
        lblName.setLineWrap(true);
        lblName.setWrapStyleWord(true);
        add(lblName);

        JButton btnCheckPost = new JButton("Check Post");
        btnCheckPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                BLOp.notifIsViewed(notifid);
                BLOp.getPost(postid);
                News_Feed Window = null;
                try {
                    Window = new News_Feed((Post)BLOp.getPost(postid),BLOp);
                    Window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JComponent comp = (JComponent) arg0.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        btnCheckPost.setBounds(305, 33, 85, 29);
        add(btnCheckPost);

        JLabel lblNewLabel_1 = new JLabel("Description:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 11, 125, 14);
        add(lblNewLabel_1);

    }
}