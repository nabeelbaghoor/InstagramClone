package UI_Swing;

import Models.Operations;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listing_InfoPane extends JPanel {

    /**
     * Create the panel.
     */
    public Listing_InfoPane(String Username, String UserId, Operations BLOp, int type) {
        setBackground(new Color(255, 255, 224));
        setPreferredSize(new Dimension(400, 70));
        setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        setLayout(null);

        JLabel lblName = new JLabel(Username);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBackground(new Color(255, 255, 255));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(10, 19, 235, 35);
        lblName.setBorder(new LineBorder(new Color(128,0,0),2,true));
        lblName.setOpaque(true);
        add(lblName);


        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(255, 24, 135, 25);
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JComponent comp = (JComponent) arg0.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);

                JFrame Confirm = new JFrame();
                if (type == 1)
                {
                    try {
                        BLOp.removeFollower(UserId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(type == 2)
                {
                    try {
                        BLOp.unfollowUser(UserId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(type == 3)
                {
                    try {
                        BLOp.unblockUser(UserId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                JOptionPane.showMessageDialog(Confirm, "User has been removed from the list");
                win.dispose();
            }
        });
        add(btnRemove);

    }
}