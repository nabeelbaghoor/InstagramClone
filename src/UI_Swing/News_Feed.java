/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Swing;

import Models.Operations;
import Models.Post;
import com.google.cloud.Timestamp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
/**
 *
 * @author Rehman Butt
 */
public class News_Feed extends javax.swing.JFrame {

    /**
     * Creates new form News_Feed
     *
     */

    public News_Feed()
    {
        initComponents();
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
    /*News_Feed(ArrayList<String> location) {

        initComponents();

        for(int i=0;i<location.size();i++)
        {
            addpic(location.get(i));
        }
    }*/

    News_Feed(ArrayList<Post> feedPosts, Operations Blop) throws Exception {
        initComponents();
        for(int i=0;i< feedPosts.size();i++)
        {
            AddUserInfo(feedPosts.get(i).postId,feedPosts.get(i).userId,Blop);
            Addpic(feedPosts.get(i).imagePath);
            AddPicDescription(feedPosts.get(i).postId,feedPosts.get(i).userId,feedPosts.get(i).timestamp,feedPosts.get(i).postText,feedPosts.get(i).likesList,feedPosts.get(i).commentsList,Blop);

        }

    }

    News_Feed(Post feedPost, Operations Blop) throws Exception {
        initComponents();
        AddUserInfo(feedPost.postId,feedPost.userId,Blop);
        Addpic(feedPost.imagePath);
        AddPicDescription(feedPost.postId,feedPost.userId,feedPost.timestamp,
                feedPost.postText,feedPost.likesList,feedPost.commentsList,Blop);
    }

    public void AddUserInfo(String postId, String userId,Operations Blop)
    {
        jPanelUser = new JPanel();
        jPanelUser.setLayout(new GridBagLayout());


        String temp = Blop.getProfileInfo(userId).username;

        JLabel name = new JLabel(temp);
        JButton follow = new JButton("Follow");
        follow.addActionListener(followAction ->
        {
            try {
                Blop.followUser(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();

        });
        JButton block = new JButton("Block");
        block.addActionListener(blockAction ->
        {
            try {
                Blop.blockUser(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();
        });

        //JLabel pIdText = new JLabel("Post ID=");
        //JLabel uId = new JLabel(userId);
        //JLabel uIdText = new JLabel("User Id =");
        // String time = timeStamp.toString();
        //JLabel tStamp = new JLabel(time);
        //JLabel tStampText = new JLabel("Upload Time is ");


        GridBagConstraints c = new GridBagConstraints();

        c.gridx=c.gridy=0;
        jPanelUser.add(name,c);
        c.gridy=1;
        jPanelUser.add(follow,c);
        c.gridx=1;
        jPanelUser.add(block,c);
        //jPanelUser.add(pId);
        //jPanelUser.add(uIdText);
        //jPanelUser.add(uId);
        //jPanelUser.add(tStampText);
        //jPanelUser.add(tStamp);

        jPanel1.add(jPanelUser);

    }

    public void Addpic(String location) throws Exception {


        BufferedImage image = null;
        URL url = null;
        try {
            url = new URL("file:" + location);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        image = ImageIO.read(url);
        //String convertedPicLocation="C:\\Users\\Rehman Butt\\Desktop\\p2.png";
        JLabel label= new JLabel(new ImageIcon(scaleImage(170, 180, image)));;
        //JLabel label = new JLabel(icon);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));


        JButton like = new JButton("Like");
        like.addActionListener( likeAction ->
        {
            //to implement like button
        });
        like.setBounds(1,1,1,1);


        JButton removePost = new JButton("Remove Following Post");
        like.addActionListener( removeAction ->
        {
            //to implement remove button
        });


        JButton viewComments = new JButton("View Comments");
        like.addActionListener( viewCommentsAction ->
        {
            //to implement view Comments button
        });

        //like.setAlignmentX(TOP_ALIGNMENT);

        JButton share = new JButton("Share");
        JButton comment = new JButton("Comment");
        JTextArea commentText =new JTextArea();
        commentText.setWrapStyleWord(true);
        commentText.setPreferredSize(new Dimension(100,30));
        setBounds(100, 100, 565, 390);

        //jPanel1.setBounds(100, 100, 565, 390);

        //JLabel test = new JLabel("this is another pannel to make buttons in flow layout");






        //jPanel1.add(jPanelUser);
        //jPanel1.add(removePost);
        jPanel1.add(label);             //picture
        /*jPanel1.add(like);
        jPanel1.add(share);
        jPanel1.add(comment);
        jPanel1.add(commentText);
        jPanel1.add(viewComments);*/

       /* jPanelDesc=new JPanel();
        jPanelDesc.setLayout(new FlowLayout());
       // jPanelDesc.add(test);
        jPanelDesc.add(like);
        jPanelDesc.add(share);
        jPanelDesc.add(comment);
        jPanelDesc.add(commentText);
        jPanelDesc.add(viewComments);
        //jPanelDesc.setMaximumSize(new Dimension(170,100));    // not working width



        jPanel1.add(jPanelDesc);*/

        setVisible(true);


    }

    public void AddPicDescription(String postId, String userId, Timestamp timestamp,String postText, ArrayList<String> likesList, ArrayList<String> commentsList,Operations Blop)
    {
        JButton like = new JButton("Like");
        like.addActionListener( likeAction ->
        {

            try {
                Blop.likePost(postId,userId);           // gives file not found on the pic i added and gives nullpointer exception on the pics that previously added
            } catch (Exception e) {
                e.printStackTrace();
            }
            like.setEnabled(false);

        });
        like.setBounds(1,1,1,1);



        JButton viewComments = new JButton("View Comments");
        //View_Comments newWindow = null;
        viewComments.addActionListener( viewCommentsAction ->
        {
            //call
           // newWindow=new View_Comments(commentList,Blop);

        });

        //like.setAlignmentX(TOP_ALIGNMENT);

        JButton share = new JButton("Share");
        share.addActionListener(shareAction ->
        {
            Share Window = new Share(Blop,postId,userId);
        });
        JTextArea commentText =new JTextArea();
        commentText.setWrapStyleWord(true);
        commentText.setPreferredSize(new Dimension(100,30));

        JButton comment = new JButton("Comment");
        comment.addActionListener(commentAction ->
        {
            try
            {
                Blop.addComment(postId,commentText.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        setBounds(100, 100, 565, 390);

        JLabel captionText = new JLabel("Caption:");

        JLabel caption = new JLabel(postText);


        caption.setMaximumSize(new Dimension(20,20));
        caption.setSize(new Dimension(50,20));
        // from here

        jPanelDesc=new JPanel();
        jPanelDesc.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        //jPanelDesc.setPreferredSize(new Dimension(50,100));
        jPanelDesc.setBorder(new EmptyBorder(0, 0, 45, 0));
        // jPanelDesc.add(test);
        jPanelDesc.add(captionText,c);
        c.gridx=2;
        jPanelDesc.add(caption);
        c.gridy=1;
        c.gridx=1;
        jPanelDesc.add(like,c);
        c.gridx=2;
        jPanelDesc.add(share,c);
        c.gridy=2;
        c.gridx=1;
        jPanelDesc.add(commentText,c);      // to get comment string commentText.getText();
        c.gridx=2;
        jPanelDesc.add(comment,c);
        c.gridy=3;
        jPanelDesc.add(viewComments,c);
        //jPanelDesc.setMaximumSize(new Dimension(170,100));    // not working width


        // till here
        jPanel1.add(jPanelDesc);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jLabel1.setText("FEED");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel1)
                                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(273, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;                 // feed on the top of frame
    private javax.swing.JPanel jPanel1;                 // Child of below jScrollPanel1
    private javax.swing.JScrollPane jScrollPane1;       // child of this main JFrame
    private javax.swing.JPanel jPanelDesc;
    private javax.swing.JPanel jPanelUser;
    // End of variables declaration
}
