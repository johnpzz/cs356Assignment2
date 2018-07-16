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


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;


//This is the main class of the program that will initialize the JFrame
public class MiniTwitterApp extends JFrame {
	
    public static Map<String, User> userMap = new HashMap<String, User>();


    private JTextField textFieldUser;
    private JTextField textFieldGroup;


    // The following code is for the Singleton Design Pattern
    private static MiniTwitterApp instance = null;

    protected static MiniTwitterApp getInstance() {
                
        if (instance == null) {
            instance = new MiniTwitterApp();           //Constructor is called.
            instance.run();			
        }
            return instance;
    }
    
    // End of Singleton Code


    
    //Constructor --> initialize() --> run()
    private void run() {
        try {
            new MiniTwitterApp();  // Test the singleton instance.
            this.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    
    //Singleton constructor must be private by nature.
    //This constructor calls the initialize() method for the program to be created.
    
    private MiniTwitterApp() {
        initialize();
    }


    private void initialize() {
        
        this.setTitle("CS356 - Mini Twitter Application");
        this.setSize(800, 800);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
     
        int xPos = (dim.width/2 - this.getWidth()/2);
        int yPos = (dim.height/2 - this.getHeight()/2);
        
        this.setLocation(xPos,yPos);
        
        
        //this.setBounds(100, 100, 795, 537);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        
        
        
        JTree tree = new JTree();	
        
        UserGroups group = new UserGroups("root");
        
        tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode(group) {
                    {
                        DefaultMutableTreeNode node1;
                        DefaultMutableTreeNode node2;
                        User user = new User("john");
                        userMap.put("john", user);
                        add(new DefaultMutableTreeNode(user));
                        user = new User("bob");
                        add(new DefaultMutableTreeNode(user));
                        userMap.put("bob", user);
                        user = new User("steve");
                        userMap.put("steve", user);
                        add(new DefaultMutableTreeNode(user));
                        UserGroups group = new UserGroups("CS356");
                        node1 = new DefaultMutableTreeNode(group);
                        
                                user = new User("stu1");
                                userMap.put("stu1", user);
                                
                                node1.add(new DefaultMutableTreeNode(user));
                                user = new User("stu2");
                                userMap.put("stu2", user);

                                node1.add(new DefaultMutableTreeNode(user));
                                user = new User("stu3");
                                userMap.put("stu3", user);

                                node1.add(new DefaultMutableTreeNode(user));
                                group = new UserGroups("CS356Session01");
                                node2 = new DefaultMutableTreeNode(group);
                                        user = new User("stu8");
                                        userMap.put("stu8", user);

                                        node2.add(new DefaultMutableTreeNode(user));
                                        user = new User("stu9");
                                        userMap.put("stu9", user);

                                        node2.add(new DefaultMutableTreeNode(user));
                                        user = new User("stu10");
                                        userMap.put("stu10", user);

                                        node2.add(new DefaultMutableTreeNode(user));
                                node1.add(node2);
                                user = new User("stu4");
                                userMap.put("stu4", user);

                                node1.add(new DefaultMutableTreeNode(user));
                        add(node1);
                        user = new User("oopstu");
                        userMap.put("oopstu", user);

                        add(new DefaultMutableTreeNode(user));
                        user = new User("ppstu2");
                        userMap.put("ppstu2", user);

                        add(new DefaultMutableTreeNode(user));
                    }
                }
        ));
        
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        
    




        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setUserID(textFieldUser.getText());

                //Check if adding user currently exists or is not a child of root

                if (!userMap.containsKey(textFieldUser.getText())) {
                    userMap.put(textFieldUser.getText(), user);
                    tree.setEditable(true);
                    //add new tree node
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new User(textFieldUser.getText()));
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
                    System.out.println(node.toString());
                    node.add(newNode);
                    
                    

                    
                    tree.setEditable(false);
                    tree.updateUI();
                   
                    
                    
                    
                    
                    System.out.println("User: " + user.getUserID() + " has been added.");
                } else {
                    System.out.println("User: " + user.getUserID() + " already exists.");
                }

            }
        });
        
        
        
        addUserButton.setBounds(395, 48, 182, 60);
        this.getContentPane().add(addUserButton);

        
        
 

        JButton addGroupButton = new JButton("Add Group");
        addGroupButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                UserGroups group = new UserGroups();
                group.setGroupID(textFieldGroup.getText());
                System.out.println("Group: " + group.getGroupID() + " has been added.");
            }
        });
        
        
        addGroupButton.setBounds(587, 48, 182, 60);
        this.getContentPane().add(addGroupButton);


        JButton openUserViewButton = new JButton("Open User View");
        openUserViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                if (!userMap.containsKey(textFieldUser.getText())) {
                    System.out.println("User: "+textFieldUser.getText() + " does not exist.");
                } else {
                    UserView openView = new UserView(textFieldUser.getText());
                    openView.run(textFieldUser.getText());
                    System.out.println("Open User View : " + textFieldUser.getText());
                }
            }
        });
        openUserViewButton.setBounds(395, 174, 374, 60);
        this.getContentPane().add(openUserViewButton);

        JButton showPositivePercentagesButton = new JButton("Show Positive Percentage");
        showPositivePercentagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    AppStats test = new AppStats();
                    System.out.println("Percentage of positive Tweets: " + test.getPercentage() + "%");
            }
        });
        showPositivePercentagesButton.setBounds(587, 422, 182, 66);
        this.getContentPane().add(showPositivePercentagesButton);

        JButton showTotalMessagesButton = new JButton("Show Messages Total");
        showTotalMessagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Total number of messages: " + User.getTotalMessages());
            }
        });
        showTotalMessagesButton.setBounds(395, 422, 182, 66);
        this.getContentPane().add(showTotalMessagesButton);


        //Total Users Button
        JButton showTotalUsersButton = new JButton("Show User Total");
        showTotalUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Total number of users: " + userMap.size());
            }
        });
        showTotalUsersButton.setBounds(395, 345, 182, 66);
        this.getContentPane().add(showTotalUsersButton);


        JButton showGroupTotalButton = new JButton("Show Group Total");
        showGroupTotalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Total number of groups: " + UserGroups.getTotalGroups());
            }
        });
        showGroupTotalButton.setBounds(587, 345, 182, 66);
        this.getContentPane().add(showGroupTotalButton);

        textFieldUser = new JTextField();
        textFieldUser.setText("User Id");
        textFieldUser.setBounds(395, 11, 182, 26);
        this.getContentPane().add(textFieldUser);
        textFieldUser.setColumns(10);

        textFieldGroup = new JTextField();
        textFieldGroup.setText("Group Id");
        textFieldGroup.setBounds(587, 11, 182, 26);
        this.getContentPane().add(textFieldGroup);
        textFieldGroup.setColumns(10);


       
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                
                if (node == null) {
                    System.out.println("NULL");
                    return;
                }
                
                if (node.isLeaf()) {
                    System.out.println("Leaf node has been selected. ");
                    textFieldUser.setText(node.toString());
                    textFieldGroup.setText(node.getParent().toString());
                    //textFieldUserID.setText(node.getUserObject().toString());
                    
                } else {
                    
                }
                
            }
            
        });
        



        tree.setBounds(10, 16, 375, 472);
        this.getContentPane().add(tree);



    }
}
