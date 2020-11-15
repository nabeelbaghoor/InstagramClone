package UI_Swing;

import Models.Operations;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Share extends JFrame {
    Share(Operations Blop,String postId,String userId) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 464, 477);
        HashMap<String,String> followers = new HashMap<>();
        followers = Blop.getFollowers();

        String []id=new String[followers.size()];
        String []names = new String[followers.size()];
        int i=0;
        for (Map.Entry entry : followers.entrySet())
        {
            names[i] = entry.getValue().toString();
            id[i]= entry.getKey().toString();
            i++;
        }
        JComboBox lbl = new JComboBox(names);
        lbl.setOpaque(true);
        lbl.setBackground(Color.WHITE);

        JButton share = new JButton("Share");
        share.addActionListener(shareAction ->
        {
            String selectedId = new String();
            selectedId = id[lbl.getSelectedIndex()];
            try {
                Blop.sharePost(postId,selectedId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();
        });


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(lbl);
        panel.add(share);

        add(panel);
        //add(share);


        setVisible(true);
    }
}
