/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.pic.decodeImage;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.util.Arrays.stream;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author Rehman Butt
 */
public class feed extends JFrame{
    feed()
    {
       // int i=50;
        JLabel name = new JLabel("Instagram");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.TOP);
        name.setFont(new Font("Roboto",Font.ITALIC,30));
        add(name);
        
        JScrollPane scrollPane = new JScrollPane();    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane);
      
        
        //getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //setLayout(new GridBagLayout());  //error
        setVisible(true);
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    // if we save the converted image of 64based string on HD
    //working good
    public void addpic(String location)
    {
        //String convertedPicLocation="C:\\Users\\Rehman Butt\\Desktop\\p2.png";
        ImageIcon icon = new ImageIcon(location); 
        JLabel label = new JLabel(icon);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));      //pics on top of each other
        
       
        
        add(label);
        
        JButton like = new JButton("Like");
        like.addActionListener(al ->
        {
            //to implement like button
        });
        //like.setAlignmentX(TOP_ALIGNMENT);
        add(like);
        JScrollPane scrollPane = new JScrollPane();    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane);
        
    }
    //without storing image on HD
    // displaying like (cable kharab) jesi image  -- incorrect rn
//    public void addpic(String imageDataString)
//    {
//
//        byte[] imageByteArray = decodeImage(imageDataString);
//        BufferedImage image = createRGBImage(imageByteArray, 200, 200);
//        //ImageIO.write(image, "BMP", stream);
//        ImageIcon icon = new ImageIcon(image);
//        JLabel label = new JLabel(icon,SwingConstants.CENTER);
//        add(label);
//    }

    public BufferedImage createRGBImage(byte[] bytes, int width, int height) {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
    
    }
}

