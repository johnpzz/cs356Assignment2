/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356program2;

/**
 *
 * @author John
 */


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import javax.swing.JTextPane;



// The UserView class initially created a second JFrame, however it now creates a JPanel.
public class UserView extends JFrame {
    
    private User user;
    private String userID;
    private JTextField textFieldUserID;
    private JButton postTweetButton;
    private JTextField tweetMessageButton;
    private JTextPane currentFollowingTextPane;


    
    //after calling the constructor, initialize() is called. Following initialize(), run() is called in MiniTwitterApp.
    public void run(String user) {
        
        try {
            JPanel window = new JPanel();
            //window.setName(user);
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the application.
     * @param string 
     */
    public UserView(String user) {
        
        this.userID = user;
        if (MiniTwitterApp.userMap.containsKey(user)) {
            this.user = MiniTwitterApp.userMap.get(user);
        }
        
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    new JPanel();
    this.setTitle(userID);
    this.setBounds(100, 100, 505, 501);
    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.getContentPane().setLayout(null);

    final JTextPane newsFeedTextPane = new JTextPane();
    newsFeedTextPane.setText("News Feed");
    newsFeedTextPane.setBounds(10, 275, 469, 177);
    this.getContentPane().add(newsFeedTextPane);

    currentFollowingTextPane = new JTextPane();
    currentFollowingTextPane.setText("Current Following");
    currentFollowingTextPane.setBounds(10, 70, 469, 135);
    this.getContentPane().add(currentFollowingTextPane);

    JButton btnFollowUser = new JButton("Follow User");
    btnFollowUser.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            user.addFollower(textFieldUserID.getText());

            String followers = user.returnFollowers();
            currentFollowingTextPane.setText(followers);		

            System.out.println("Follor User: " + textFieldUserID.getText());
        }
    });

    btnFollowUser.setBounds(247, 11, 232, 48);
    this.getContentPane().add(btnFollowUser);

    textFieldUserID = new JTextField();
    textFieldUserID.setText("User ID");
    textFieldUserID.setBounds(10, 11, 223, 48);
    this.getContentPane().add(textFieldUserID);
    textFieldUserID.setColumns(10);

    postTweetButton = new JButton("Post Tweet");
    postTweetButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            user.tweet(tweetMessageButton.getText());
            String news = user.returnTweets();
            newsFeedTextPane.setText(news);				
        }
    });

    postTweetButton.setBounds(275, 216, 204, 48);
    this.getContentPane().add(postTweetButton);

    tweetMessageButton = new JTextField();
    tweetMessageButton.setText("Tweet Message");
    tweetMessageButton.setBounds(10, 216, 255, 48);
    this.getContentPane().add(tweetMessageButton);
    tweetMessageButton.setColumns(10);




    }
}
