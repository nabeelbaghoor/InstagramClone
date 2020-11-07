package UI_Swing;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        //Operation obj =
        //Setting Look and Feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme
        }
        catch (Exception e)
        { e.printStackTrace(); }

        //Changeable Variables
        String urlpath = "file:\\C:\\Users\\inspiron\\Pictures\\Saved Pictures\\received_1367138483367972.jpeg";
        String Fullname = "FullName PlaceHolder";
        int FollowingC = 10;
        int FollowerC = 10;

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Main_Frame frame = new Main_Frame(Fullname,urlpath,FollowingC,FollowerC);
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
