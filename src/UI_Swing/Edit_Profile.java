package UI_Swing;

import Models.Operations;
import Models.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Edit_Profile extends JFrame {

    JLabel lblImagePath;
    JLabel lblImage;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public Edit_Profile(User user, Operations BLOp) {

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


        lblImage = null;
        try {
            lblImage = new JLabel(new ImageIcon(scaleImage(170, 180, image)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblImage.setBackground(Color.WHITE);
        lblImage.setOpaque(true);
        lblImage.setBounds(10, 11, 170, 180);
        contentPane.add(lblImage);

        JTextField lblFnameEntry = new JTextField(user.firstName);
        lblFnameEntry.setOpaque(true);
        lblFnameEntry.setBackground(Color.WHITE);
        lblFnameEntry.setBounds(267, 11, 170, 25);
        contentPane.add(lblFnameEntry);

        JTextField lblLnameEntry = new JTextField(user.lastName);
        lblLnameEntry.setOpaque(true);
        lblLnameEntry.setBackground(Color.WHITE);
        lblLnameEntry.setBounds(267, 47, 170, 25);
        contentPane.add(lblLnameEntry);

        JTextField lblEmailEntry = new JTextField(user.emailAddress);
        lblEmailEntry.setOpaque(true);
        lblEmailEntry.setBackground(Color.WHITE);
        lblEmailEntry.setBounds(267, 83, 170, 25);
        contentPane.add(lblEmailEntry);

        JTextField lblUserNameEntry = new JTextField(user.username);
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

        String Genders[] = {"Male", "Female"};
        JComboBox lblGenderEntry = new JComboBox(Genders);
        lblGenderEntry.setOpaque(true);
        lblGenderEntry.setBackground(Color.WHITE);
        lblGenderEntry.setBounds(267, 155, 73, 25);
        contentPane.add(lblGenderEntry);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblGender.setBounds(190, 155, 67, 25);
        contentPane.add(lblGender);

        JTextArea lblBioEntry = new JTextArea(user.bio);
        lblBioEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int max = 150;
                if (lblBioEntry.getText().length() > max + 1) {
                    e.consume();
                    String shortened = lblBioEntry.getText().substring(0, max);
                    lblBioEntry.setText(shortened);
                } else if (lblBioEntry.getText().length() > max) {
                    e.consume();
                }
            }
        });
        lblBioEntry.setOpaque(true);
        lblBioEntry.setLineWrap(true);
        lblBioEntry.setWrapStyleWord(true);
        lblBioEntry.setBackground(Color.WHITE);
        lblBioEntry.setBounds(9, 308, 428, 85);
        contentPane.add(lblBioEntry);

        JLabel lblBio = new JLabel("Bio:");
        lblBio.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblBio.setBounds(10, 274, 32, 25);
        contentPane.add(lblBio);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Main_Frame Window = new Main_Frame(BLOp);
                Window.setVisible(true);
                dispose();
            }
        });
        btnCancel.setBounds(322, 405, 115, 23);
        contentPane.add(btnCancel);

        JLabel lblDOB = new JLabel("Date of Birth: (dd-mm-yy)");
        lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblDOB.setBounds(237, 202, 200, 25);
        contentPane.add(lblDOB);

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

        JTextField lblPhoneEntry = new JTextField(user.phoneNumber);
        lblPhoneEntry.setOpaque(true);
        lblPhoneEntry.setBackground(Color.WHITE);
        lblPhoneEntry.setBounds(309, 77, 129, 25);
        panel_1.add(lblPhoneEntry);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblPhone.setBounds(237, 77, 62, 25);
        panel_1.add(lblPhone);

        JButton btnBrowser = new JButton("Browse");
        btnBrowser.setBounds(10, 11, 112, 23);
        panel_1.add(btnBrowser);

        lblImagePath = new JLabel(user.imagePath.substring(8));
        lblImagePath.setOpaque(true);
        lblImagePath.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagePath.setBackground(Color.WHITE);
        lblImagePath.setBounds(10, 41, 209, 25);
        panel_1.add(lblImagePath);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.dateOfBirth);
        SimpleDateFormat model = new SimpleDateFormat("dd.MM.yyyy");
        JSpinner Yearspinner = new JSpinner(new SpinnerDateModel());
        Yearspinner.setValue(calendar.getTime());
        Yearspinner.setEditor(new JSpinner.DateEditor(Yearspinner, model.toPattern()));
        Yearspinner.setBounds(237, 41, 105, 25);
        panel_1.add(Yearspinner);

        btnBrowser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                JFrame Confirm = new JFrame();

                user.bio = lblBioEntry.getText();
                user.dateOfBirth = (Date) Yearspinner.getValue();
                user.gender = lblGenderEntry.getSelectedItem().toString();
                user.username = lblUserNameEntry.getText();
                user.phoneNumber = lblPhoneEntry.getText();

                String FileLocation = "";
                String FileType = "";
                FileLocation = lblImagePath.getText();
                if (FileLocation.compareTo("") != 0) {
                    FileType = FileLocation.substring(FileLocation.lastIndexOf("."));
                }

                user.imagePath = "file:\\" + lblImagePath.getText();
                //JOptionPane.showMessageDialog(Confirm, "Photo not added due to unsupported type");

                user.lastName = lblLnameEntry.getText();
                user.firstName = lblFnameEntry.getText();
                user.emailAddress = lblEmailEntry.getText();

                JOptionPane.showMessageDialog(Confirm, "Profile Has Been Edited");
                try {
                    BLOp.editUserData(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Main_Frame Window = new Main_Frame(BLOp);
                Window.setVisible(true);
                dispose();
            }
        });
        btnConfirm.setBounds(206, 208, 112, 23);
        panel_1.add(btnConfirm);
    }

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

    private void jButton1ActionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename;
        if (f == null)
            return;
        filename = f.getAbsolutePath();
        lblImagePath.setText(filename);
        try {
            ImageIcon ii = new ImageIcon(scaleImage(170, 180, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
            lblImage.setIcon(ii);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

