package UI_Swing;

import Models.Operations;
import Models.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class My_Profile extends JFrame {

    private JPanel contentPane;


    public My_Profile(User user, Operations BLop) throws Exception {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 464, 477);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JLabel lblImage = null;
        try {
            lblImage = new JLabel(new ImageIcon(scaleImage(170, 180, image)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblImage.setBackground(Color.WHITE);
        lblImage.setOpaque(true);
        lblImage.setBounds(10, 11, 170, 180);
        contentPane.add(lblImage);

        JLabel lblFnameEntry = new JLabel(user.firstName);
        lblFnameEntry.setOpaque(true);
        lblFnameEntry.setBackground(Color.WHITE);
        lblFnameEntry.setBounds(267, 11, 170, 25);
        contentPane.add(lblFnameEntry);

        JLabel lblLnameEntry = new JLabel(user.lastName);
        lblLnameEntry.setOpaque(true);
        lblLnameEntry.setBackground(Color.WHITE);
        lblLnameEntry.setBounds(267, 47, 170, 25);
        contentPane.add(lblLnameEntry);

        JLabel lblEmailEntry = new JLabel(user.emailAddress);
        lblEmailEntry.setOpaque(true);
        lblEmailEntry.setBackground(Color.WHITE);
        lblEmailEntry.setBounds(267, 83, 170, 25);
        contentPane.add(lblEmailEntry);

        JLabel lblUserNameEntry = new JLabel(user.username);
        lblUserNameEntry.setOpaque(true);
        lblUserNameEntry.setBackground(Color.WHITE);
        lblUserNameEntry.setBounds(267, 119, 170, 25);
        contentPane.add(lblUserNameEntry);

        JLabel lblFname = new JLabel("First Name:");
        lblFname.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblFname.setBounds(190, 11, 67, 25);
        contentPane.add(lblFname);

        JLabel lblLname = new JLabel("Last Name:");
        lblLname.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblLname.setBounds(190, 47, 67, 25);
        contentPane.add(lblLname);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblEmail.setBounds(190, 83, 67, 25);
        contentPane.add(lblEmail);

        JLabel lblUserName = new JLabel("Username:");
        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblUserName.setBounds(190, 119, 67, 25);
        contentPane.add(lblUserName);

        JLabel lblGenderEntry = new JLabel(user.gender);
        lblGenderEntry.setOpaque(true);
        lblGenderEntry.setBackground(Color.WHITE);
        lblGenderEntry.setBounds(267, 155, 59, 25);
        contentPane.add(lblGenderEntry);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblGender.setBounds(190, 155, 67, 25);
        contentPane.add(lblGender);

        JTextArea lblBioEntry = new JTextArea(user.bio);
        lblBioEntry.setOpaque(true);

        lblBioEntry.setEditable(false);
        lblBioEntry.setLineWrap(true);
        lblBioEntry.setWrapStyleWord(true);
        lblBioEntry.setBackground(Color.WHITE);
        lblBioEntry.setBounds(9, 308, 428, 85);
        contentPane.add(lblBioEntry);
        String Count;

        if (user.followingsList != null)
            Count = user.followingsList.size() + "";
        else
            Count = "0";

        JLabel lblFollowingCountEntry = new JLabel(Count);
        lblFollowingCountEntry.setHorizontalAlignment(SwingConstants.CENTER);
        lblFollowingCountEntry.setOpaque(true);
        lblFollowingCountEntry.setBackground(Color.WHITE);
        lblFollowingCountEntry.setBounds(121, 202, 59, 25);
        contentPane.add(lblFollowingCountEntry);

        if (user.followersList != null)
            Count = user.followersList.size() + "";
        else
            Count = "0";
        JLabel lblFollowerCountEntry = new JLabel(Count);
        lblFollowerCountEntry.setHorizontalAlignment(SwingConstants.CENTER);
        lblFollowerCountEntry.setOpaque(true);
        lblFollowerCountEntry.setBackground(Color.WHITE);
        lblFollowerCountEntry.setBounds(121, 238, 59, 25);
        contentPane.add(lblFollowerCountEntry);

        JLabel lblFollowingCount = new JLabel("Following Count:");
        lblFollowingCount.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblFollowingCount.setBounds(10, 202, 101, 25);
        contentPane.add(lblFollowingCount);

        JLabel lblFollowerCount = new JLabel("Follower Count:");
        lblFollowerCount.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblFollowerCount.setBounds(10, 238, 101, 25);
        contentPane.add(lblFollowerCount);

        JLabel lblBio = new JLabel("Bio:");
        lblBio.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblBio.setBounds(10, 274, 32, 25);
        contentPane.add(lblBio);

        JButton btnOK = new JButton("OK\r\n");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Main_Frame Window = new Main_Frame(BLop);
                Window.setVisible(true);
                dispose();
            }
        });
        btnOK.setBounds(322, 405, 115, 23);
        contentPane.add(btnOK);

        JLabel lblDOB = new JLabel("Date of Birth: (dd-mm-yy)");
        lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblDOB.setBounds(237, 202, 200, 25);
        contentPane.add(lblDOB);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.dateOfBirth);
        String datevalues = calendar.get(Calendar.DAY_OF_MONTH) + "";
        JLabel lblDay = new JLabel(datevalues);
        lblDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblDay.setOpaque(true);
        lblDay.setBackground(Color.WHITE);
        lblDay.setBounds(237, 238, 59, 25);
        contentPane.add(lblDay);

        datevalues = (calendar.get(Calendar.MONTH) + 1) + "";
        JLabel lblMonth = new JLabel(datevalues);
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonth.setOpaque(true);
        lblMonth.setBackground(Color.WHITE);
        lblMonth.setBounds(309, 238, 59, 25);
        contentPane.add(lblMonth);

        datevalues = calendar.get(Calendar.YEAR) + "";
        JLabel lblYear = new JLabel(datevalues);
        lblYear.setHorizontalAlignment(SwingConstants.CENTER);
        lblYear.setOpaque(true);
        lblYear.setBackground(Color.WHITE);
        lblYear.setBounds(378, 238, 59, 25);
        contentPane.add(lblYear);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        panel.setBounds(0, 0, 448, 197);
        panel.setOpaque(true);
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 239, 213));
        panel_1.setBounds(0, 197, 448, 242);
        panel_1.setOpaque(true);
        contentPane.add(panel_1);
        panel_1.setLayout(null);


        //Edit Profile Pane opener
        JButton btnEditProfile = new JButton("Edit Profile");
        btnEditProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Edit_Profile Window = new Edit_Profile(user, BLop);
                Window.setVisible(true);
                dispose();
            }
        });
        btnEditProfile.setBounds(206, 208, 112, 23);
        panel_1.add(btnEditProfile);

        JLabel lblPhoneEntry = new JLabel(user.phoneNumber);
        lblPhoneEntry.setOpaque(true);
        lblPhoneEntry.setBackground(Color.WHITE);
        lblPhoneEntry.setBounds(309, 77, 129, 25);
        panel_1.add(lblPhoneEntry);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblPhone.setBounds(237, 77, 62, 25);
        panel_1.add(lblPhone);
    }

    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }
}
