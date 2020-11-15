package UI_Swing;

import Models.Notification;
import Models.Operations;
import Models.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Notif_Builder extends JFrame{

    //Function to Buffer Image
    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

    private JPanel contentPane;

    public Notif_Builder(String Title, Operations BLOp) {
        User user = BLOp.getMyProfile();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        setTitle(Title);

        //Image Setup
        BufferedImage image = null;
        URL url = null;
        try {
            url = new URL("file:" + user.imagePath);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JPanel ListHolderPane = new JPanel();
        ListHolderPane.setPreferredSize(new Dimension(400,375));
        ListHolderPane.setOpaque(true);

        //ScrollPane Setup
        JScrollPane ListHolder = new JScrollPane(ListHolderPane);
        ListHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ListHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ListHolder.setMinimumSize(new Dimension(400,375));
        ListHolder.setPreferredSize(new Dimension(400,375));
        ListHolder.getViewport().setMinimumSize(new Dimension(400,375));
        ListHolder.getViewport().setPreferredSize(new Dimension(400,375));
        contentPane.setLayout(new BorderLayout(0, 0));

        getContentPane().add(ListHolder);

        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(new Color(245, 255, 250));
        contentPane.add(MainPanel, BorderLayout.NORTH);
        MainPanel.setPreferredSize(new Dimension(400,125));
        MainPanel.setLayout(null);

        //Image Label Setup
        JLabel lblImage = null;
        try {
            lblImage = new JLabel(new ImageIcon(scaleImage(120, 105, image)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblImage.setBounds(10, 11, 120, 105);
        MainPanel.add(lblImage);

        String fullname = user.firstName + " " + user.lastName;
        JLabel lblName = new JLabel(fullname);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblName.setBackground(new Color(255, 255, 255));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(152, 11, 227, 23);
        lblName.setOpaque(true);
        MainPanel.add(lblName);

        JLabel lblUserName = new JLabel(user.username);
        lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblUserName.setBackground(new Color(255, 255, 255));
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserName.setBounds(152, 45, 227, 23);
        lblUserName.setOpaque(true);
        MainPanel.add(lblUserName);

        ArrayList<Notification> listing = BLOp.getNotification();
        int pcount = 0;
        String Count = null;
        if (user.notificationList != null)
        {
            pcount = listing.size();
        }

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(400,pcount*110));
        int notshowed = 0;
        for (int i = 0; i < pcount; i++)
        {
            if (listing.get(i).shouldShow) {
                JPanel sp1 = new Notif_Template(listing.get(i).msg,listing.get(i).notificationId,
                        listing.get(i).postId, listing.get(i).isViewed, BLOp);
                panel2.add(sp1);
            }
            else
                notshowed++;
        }
        ListHolder.getViewport().setView(panel2);

        Count = "Total Notifications: " + (pcount - notshowed);

        JLabel lblCounter = new JLabel(Count);
        lblCounter.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCounter.setBackground(new Color(255, 255, 255));
        lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
        lblCounter.setBounds(152, 79, 227, 23);
        lblCounter.setOpaque(true);
        MainPanel.add(lblCounter);

    }

}