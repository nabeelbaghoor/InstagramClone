package UI_Swing;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;
import java.awt.Paint;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Frame extends JFrame {

    private JPanel contentPane;

    public Main_Frame(String FullName, String urlpath, int FollowingC, int FollowerC) {
        String FollowingCount = FollowingC + " Following";
        String FollowerCount = FollowerC + " Followers";

        //JFrame Setup
        setTitle("InstaClone");
        setResizable(false);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(565, 390));
        setBounds(0, 0, 565, 390);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Image image = null;
        URL url = null;
        try {
            url = new URL(urlpath);
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
        JPanel AccountInfoPane = new JPanel();
        AccountInfoPane.setBounds(10, 11, 528, 178);
        contentPane.add(AccountInfoPane);

        JLabel lblImage = new JLabel(new ImageIcon(image));
        lblImage.setBounds(0, 0, 170, 180);

        JPanel Divider_Panel = new JPanel();
        Divider_Panel.setBounds(173, 0, 13, 178);
        Divider_Panel.setBackground(new Color(255, 250, 240));

        JLabel lblUserName = new JLabel(FullName);
        lblUserName.setBounds(189, 0, 339, 43);
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 22));

        JLabel lblFollowingCount = new JLabel(FollowingCount);
        lblFollowingCount.setBounds(190, 66, 160, 40);
        lblFollowingCount.setHorizontalAlignment(SwingConstants.CENTER);
        lblFollowingCount.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblFollowerCount = new JLabel(FollowerCount);
        lblFollowerCount.setBounds(368, 66, 160, 40);
        lblFollowerCount.setHorizontalAlignment(SwingConstants.CENTER);
        lblFollowerCount.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFollowerCount.setBackground(new Color(255, 255, 240));

        JPanel Divider_Panel2 = new JPanel();
        Divider_Panel2.setBackground(new Color(255, 250, 240));
        Divider_Panel2.setBounds(184, 44, 344, 11);
        AccountInfoPane.setLayout(null);
        AccountInfoPane.add(lblImage);
        AccountInfoPane.add(Divider_Panel);
        AccountInfoPane.add(lblFollowingCount);
        AccountInfoPane.add(lblFollowerCount);
        AccountInfoPane.add(lblUserName);
        AccountInfoPane.add(Divider_Panel2);

        JPanel Divider_Panel3 = new JPanel();
        Divider_Panel3.setBackground(new Color(255, 250, 240));
        Divider_Panel3.setBounds(348, 54, 18, 124);
        AccountInfoPane.add(Divider_Panel3);

        JPanel Divider_Panel4 = new JPanel();
        Divider_Panel4.setBackground(new Color(255, 250, 240));
        Divider_Panel4.setBounds(186, 117, 342, 11);
        AccountInfoPane.add(Divider_Panel4);

        JButton btnProfileButton = new JButton("My Profile");
        btnProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnProfileButton.setBounds(185, 128, 160, 50);
        AccountInfoPane.add(btnProfileButton);

        JButton btnNotifButton = new JButton("Notifications");
        btnNotifButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNotifButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNotifButton.setBounds(368, 128, 160, 50);
        AccountInfoPane.add(btnNotifButton);

        JPanel Account_BackPanel = new JPanel();
        Account_BackPanel.setBackground(new Color(255, 250, 240));
        Account_BackPanel.setBounds(0, 0, 548, 200);
        contentPane.add(Account_BackPanel);

        JPanel Action_BackPanel = new JPanel();
        Action_BackPanel.setBackground(new Color(255, 240, 245));
        Action_BackPanel.setBounds(0, 200, 548, 254);
        contentPane.add(Action_BackPanel);
        Action_BackPanel.setLayout(null);

        JPanel Action_Buttons_Panel = new JPanel();
        Action_Buttons_Panel.setBounds(21, 11, 504, 130);
        Action_BackPanel.add(Action_Buttons_Panel);
        Action_Buttons_Panel.setLayout(null);

        JButton btnNewsFeed = new JButton("News Feed");
        btnNewsFeed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewsFeed.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewsFeed.setBounds(0, 50, 227, 29);
        Action_Buttons_Panel.add(btnNewsFeed);

        JPanel DividerPanel = new JPanel();
        DividerPanel.setBackground(new Color(255, 240, 245));
        DividerPanel.setBounds(227, 0, 43, 175);
        Action_Buttons_Panel.add(DividerPanel);

        JButton btnAddPost = new JButton("Add Post");
        btnAddPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Add_Post Window = new Add_Post();
                Window.setVisible(true);
            }
        });
        btnAddPost.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddPost.setBounds(0, 0, 227, 29);
        Action_Buttons_Panel.add(btnAddPost);

        JButton btnMyPosts = new JButton("My Posts");
        btnMyPosts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnMyPosts.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMyPosts.setBounds(271, 0, 233, 29);
        Action_Buttons_Panel.add(btnMyPosts);

        JButton btngetFollowing = new JButton("Following List");
        btngetFollowing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btngetFollowing.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btngetFollowing.setBounds(271, 50, 233, 29);
        Action_Buttons_Panel.add(btngetFollowing);

        JPanel DividerPanel_1 = new JPanel();
        DividerPanel_1.setBackground(new Color(255, 240, 245));
        DividerPanel_1.setBounds(0, 27, 504, 23);
        Action_Buttons_Panel.add(DividerPanel_1);

        JButton btngetFollowers = new JButton("Follower List");
        btngetFollowers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btngetFollowers.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btngetFollowers.setBounds(0, 100, 227, 29);
        Action_Buttons_Panel.add(btngetFollowers);

        JButton btngetBlocked = new JButton("Blocked List");
        btngetBlocked.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btngetBlocked.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btngetBlocked.setBounds(271, 100, 233, 29);
        Action_Buttons_Panel.add(btngetBlocked);

        JPanel DividerPanel_2 = new JPanel();
        DividerPanel_2.setBackground(new Color(255, 240, 245));
        DividerPanel_2.setBounds(0, 77, 504, 23);
        Action_Buttons_Panel.add(DividerPanel_2);
    }
}

