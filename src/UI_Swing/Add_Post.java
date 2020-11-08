package UI_Swing;

import Models.Operations;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Add_Post extends JFrame {
    private int image_height;
    private int image_aspect_ratio;
    private Graphics2D engine;
    private JLabel photoComponent;
    // Variables declaration - do not modify
    private JButton jButtonAttach;
    private JLabel jImageHolder;
    private JLabel jImagePath;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public Add_Post(Operations BLOp) {
        getContentPane().setBackground(new Color(230, 230, 250));
        setResizable(false);
        setTitle("Add Post");
        initComponents(BLOp);
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

    private void initComponents(Operations BLOp) {

        jButtonAttach = new JButton();
        jButtonAttach.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jButtonAttach.setBounds(319, 12, 115, 30);

        jImagePath = new JLabel();
        jImagePath.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jImagePath.setBackground(new Color(255, 250, 250));
        jImagePath.setBounds(195, 53, 239, 30);
        jImagePath.setOpaque(true);
        jImagePath.setHorizontalAlignment(SwingConstants.CENTER);

        jImageHolder = new JLabel();
        jImageHolder.setBackground(new Color(255, 250, 250));
        jImageHolder.setBounds(10, 53, 170, 180);
        jImageHolder.setOpaque(true);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(460, 330));

        jButtonAttach.setText("Browse");
        jButtonAttach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jButtonAttach);
        getContentPane().add(jImagePath);
        getContentPane().add(jImageHolder);

        lblNewLabel = new JLabel("Image:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setBounds(10, 11, 170, 31);
        getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Image Location");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_1.setBounds(195, 11, 239, 31);
        getContentPane().add(lblNewLabel_1);

        JTextArea textArea = new JTextArea("");
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int max = 140;
                if (textArea.getText().length() > max + 1) {
                    e.consume();
                    String shortened = textArea.getText().substring(0, max);
                    textArea.setText(shortened);
                } else if (textArea.getText().length() > max) {
                    e.consume();
                }
            }
        });
        textArea.setBounds(195, 133, 240, 100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        getContentPane().add(textArea);

        JLabel lblNewLabel_2 = new JLabel("Post Description:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_2.setBounds(195, 94, 170, 31);
        getContentPane().add(lblNewLabel_2);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnCancel.setBounds(335, 256, 99, 30);
        getContentPane().add(btnCancel);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFrame Confirm = new JFrame();
                String FileLocation = "";
                String FileType = "";
                FileLocation = jImagePath.getText();
                if (FileLocation.compareTo("") != 0) {
                    FileType = FileLocation.substring(FileLocation.lastIndexOf("."));
                }

                if (FileType.compareTo(".png") != 0) {
                    JOptionPane.showMessageDialog(Confirm, "Please Add a Photo For Post");
                } else {
                    JOptionPane.showMessageDialog(Confirm, "Post Has Been Added");
                    BLOp.addPost(jImagePath.getText(), textArea.getText());
                    dispose();
                }
            }
        });
        btnOk.setBounds(226, 256, 99, 30);
        getContentPane().add(btnOk);

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        jImagePath.setText(filename);
        try {
            ImageIcon ii = new ImageIcon(scaleImage(170, 180, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
            jImageHolder.setIcon(ii);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
}