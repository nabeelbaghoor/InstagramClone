/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.pic.encodeImage;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.BoxLayout;

/**
 *
 * @author Rehman Butt
 */


public class Gui extends JFrame{

    
    public static void main(String[] args) throws IOException 
    {
        String location="C:\\Users\\Rehman Butt\\Desktop\\p1.png";

        feed f=new feed();
        pic p=new pic();
       // p.convertpic(location);         //converts pic->byte[]->string and reverse and then stores pic on HD
        f.addpic(location);
        
        //give another pic location
        location="C:\\Users\\Rehman Butt\\Desktop\\a1.png";     
                
        f.addpic(location);
        
        
//        File file = new File("C:\\Users\\Rehman Butt\\Desktop\\p1.png");
//         
//            // Reading a Image file from file system
//            FileInputStream imageInFile = new FileInputStream(file);
//            byte imageData[] = new byte[(int) file.length()];
//            imageInFile.read(imageData);
// 
//            // Converting Image byte array into Base64 String
//            String imageDataString = encodeImage(imageData);
//            //f.addpic(imageDataString);
//            
    
    }
}
