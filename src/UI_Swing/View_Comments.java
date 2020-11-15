/*
package UI_Swing;

import Models.Comment;
import Models.Operations;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View_Comments extends JFrame {
    View_Comments(ArrayList<String> commentList, Operations Blop)
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 464, 477);


        JPanel jPanelComment = new JPanel();
        jPanelComment.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;

        String name ;

        JLabel uName;
        JLabel comment;
        String userId;
        for(int i=0;i<commentList.size();i++)
        {
            //name = Blop.getProfileInfo(commentList.get(i).userID).username;





            uName= new JLabel(Blop.getProfileInfo(commentList.get(i)).username);
            jPanelComment.add(uName,c);
            c.gridx++;
            comment = new JLabel(commentList.get(i).commentText);
            jPanelComment.add(comment);
            c.gridx=0;
            c.gridy++;
        }

        add(jPanelComment);
        setVisible(true);
    }

}
*/
