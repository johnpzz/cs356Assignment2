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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
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
        long time = System.currentTimeMillis();
        
        this.setTitle("CS356 - Mini Twitter Application");
        this.setSize(1000, 1000);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
     
        int xPos = (dim.width/2 - this.getWidth()/2);   //1920/2 - 800/2 = 960 - 400 = 540
        int yPos = (dim.height/2 - this.getHeight()/2); //1080/2 - 800/2 =  540 - 400 = 140
        
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
                        DefaultMutableTreeNode node3;
                        DefaultMutableTreeNode node4;
                        DefaultMutableTreeNode node5;
                        User user = new User("john");
                        user.setCreationTime(time);
                        userMap.put("john", user);
                        add(new DefaultMutableTreeNode(user));
                        user = new User("bob");
                        user.setCreationTime(System.currentTimeMillis());
                        add(new DefaultMutableTreeNode(user));
                        userMap.put("bob", user);
                        user = new User("steve");
                        user.setCreationTime(System.currentTimeMillis());
                        userMap.put("steve", user);
                        add(new DefaultMutableTreeNode(user));
                        UserGroups group = new UserGroups("CS356");
                        node1 = new DefaultMutableTreeNode(group);
                        
                                user = new User("stu1");
                                user.setCreationTime(System.currentTimeMillis());
                                userMap.put("stu1", user);
                                
                                node1.add(new DefaultMutableTreeNode(user));
                                user = new User("stu2");
                                user.setCreationTime(System.currentTimeMillis());
                                userMap.put("stu2", user);

                                node1.add(new DefaultMutableTreeNode(user));
                                user = new User("stu3");
                                user.setCreationTime(System.currentTimeMillis());
                                userMap.put("stu3", user);

                                node1.add(new DefaultMutableTreeNode(user));
                                group = new UserGroups("CS356Session01");
                                node2 = new DefaultMutableTreeNode(group);
                                        user = new User("stu8");
                                        user.setCreationTime(System.currentTimeMillis());
                                        userMap.put("stu8", user);

                                        node2.add(new DefaultMutableTreeNode(user));
                                        user = new User("stu9");
                                        user.setCreationTime(System.currentTimeMillis());
                                        userMap.put("stu9", user);

                                        node2.add(new DefaultMutableTreeNode(user));
                                        user = new User("stu10");
                                        user.setCreationTime(System.currentTimeMillis());
                                        userMap.put("stu10", user);

                                        node2.add(new DefaultMutableTreeNode(user));
                                node1.add(node2);
                                user = new User("stu4");
                                user.setCreationTime(System.currentTimeMillis());
                                userMap.put("stu4", user);
                                
                                node1.add(new DefaultMutableTreeNode(user));
                        add(node1);
                        user = new User("oopstu");
                        user.setCreationTime(System.currentTimeMillis());
                        userMap.put("oopstu", user);

                        add(new DefaultMutableTreeNode(user));
                        user = new User("ppstu2");
                        user.setCreationTime(System.currentTimeMillis());
                        userMap.put("ppstu2", user);

                        add(new DefaultMutableTreeNode(user));
                    }
                }
        ));
        
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        

                
        JTextPane infoView = new JTextPane();
        infoView.setBounds(475, 250, 182, 66);
        this.getContentPane().add(infoView);
        infoView.setText("");
        
        
        
        
        
        
        


        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                long time = (long) System.currentTimeMillis();
                
                
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                
                if (!selectedNode.isRoot()) {
                    
                    DefaultMutableTreeNode selectedNodeParent = (DefaultMutableTreeNode) selectedNode;
                    
                    if (selectedNodeParent.getAllowsChildren()) {                

                    User user = new User();
                    user.setUserID(textFieldUser.getText());

                    //Check if adding user currently exists or is not a child of root

                    if (!userMap.containsKey(textFieldUser.getText())) {
                        userMap.put(textFieldUser.getText(), user);
                        infoView.setText(textFieldUser.getText());
                        tree.setEditable(true);
                        //add new tree node

                        //DefaultMutableTreeNode node = (DefaultMutableTreeNode) (tree.getLastSelectedPathComponent());
                        //DefaultMutableTreeNode nodeP = (DefaultMutableTreeNode) node.getParent();

                        selectedNodeParent.add(new DefaultMutableTreeNode(new User(textFieldUser.getText())));


                        System.out.println(selectedNodeParent);

                        //DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new User(textFieldUser.getText()));
                        //DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
                        //System.out.println(node.toString());
                        //node.add(newNode);



                        user.setCreationTime(time);


                        tree.updateUI();





                        System.out.println("User: " + user.getUserID() + " has been added.");
                    } else {
                        System.out.println("User: " + user.getUserID() + " already exists.");
                    }
                }
                    
                } else {
                
                    DefaultMutableTreeNode selectedNodeParent = selectedNode;

                    if (selectedNodeParent.getAllowsChildren()) {                

                    User user = new User();
                    user.setUserID(textFieldUser.getText());

                    //Check if adding user currently exists or is not a child of root

                    if (!userMap.containsKey(textFieldUser.getText())) {
                        userMap.put(textFieldUser.getText(), user);
                        infoView.setText(textFieldUser.getText());
                        tree.setEditable(true);
                        //add new tree node

                        //DefaultMutableTreeNode node = (DefaultMutableTreeNode) (tree.getLastSelectedPathComponent());
                        //DefaultMutableTreeNode nodeP = (DefaultMutableTreeNode) node.getParent();

                        selectedNodeParent.add(new DefaultMutableTreeNode(new User(textFieldUser.getText())));


                        System.out.println(selectedNodeParent);

                        //DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new User(textFieldUser.getText()));
                        //DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
                        //System.out.println(node.toString());
                        //node.add(newNode);



                        user.setCreationTime(time);


                        tree.updateUI();





                        System.out.println("User: " + user.getUserID() + " has been added.");
                    } else {
                        System.out.println("User: " + user.getUserID() + " already exists.");
                    }
                }

                }
            }
        });
        
        
        
        addUserButton.setBounds(395, 48, 182, 60);
        this.getContentPane().add(addUserButton);

        
        
 

        JButton addGroupButton = new JButton("Add Group");
        addGroupButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                long time = (long) System.currentTimeMillis();
                UserGroups group = new UserGroups();
                group.setCreationTime(time);
                //time = group.getCreationTime();
                group.setGroupID(textFieldGroup.getText());
                System.out.println("Group: " + group.getGroupID() + " has been added.");
                tree.setEditable(true);
                
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(new UserGroups(textFieldGroup.getText()));
                
                selectedNode.add(newGroup);
                
                
                

                                
                
                
                //node.add(new DefaultMutableTreeNode(new UserGroups(textFieldGroup.getText())));
                
                
                
                tree.updateUI();
                
                
                
            }
        });
        
        
        addGroupButton.setBounds(587, 48, 182, 60);
        this.getContentPane().add(addGroupButton);


        JButton openUserViewButton = new JButton("Open User View");
        openUserViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
     
                if (!userMap.containsKey(node.toString())) {
                    System.out.println("User: "+textFieldUser.getText() + " does not exist.");
                } else {
                    UserView openView = new UserView(node.toString());
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
        textFieldUser.setText("");
        textFieldUser.setBounds(395, 11, 182, 26);
        //this.add(textFieldUser);
        this.getContentPane().add(textFieldUser);
        textFieldUser.setColumns(10);

        textFieldGroup = new JTextField();
        textFieldGroup.setText("");
        textFieldGroup.setBounds(587, 11, 182, 26);
        this.getContentPane().add(textFieldGroup);
        textFieldGroup.setColumns(10);

        textFieldUser.setEditable(false);
        textFieldGroup.setEditable(false);

        JButton userGroupVerification = new JButton();
        userGroupVerification.setText("Verification");
        userGroupVerification.setBounds(400, 525, 100, 66);
        this.getContentPane().add(userGroupVerification);
        
        ArrayList<String> unVerified = new ArrayList<>();
        
        userGroupVerification.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //for (int i = 0; i < userMap.size(); i++) {
                    
                    if (userMap.containsValue(" ") || userMap.containsKey(" ")) {
                        unVerified.add(userMap.get(" ").getUserID());
                    }
                //}
                infoView.setText("List of Unverified Users: " + Arrays.asList(unVerified).toString());
                               
            }
           
            
        });
        
        
        JButton lastUpdatedButton = new JButton();
        lastUpdatedButton.setText("Last Updated");
        lastUpdatedButton.setBounds(625,525,145,66);
        this.getContentPane().add(lastUpdatedButton);
        
        lastUpdatedButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Set s = userMap.entrySet();
                for (Object o : s) {
                    if ( o instanceof User) {
                        ((User) o).getNewsFeed().get(((User) o).getNewsFeed().size()-1);
                    }
                }

                
                //infoView.setText("" + );
            }
            
        });
        
        
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                
                if (node == null) {
                    System.out.println("NULL");
                    return;
                }
                
                if (node.isLeaf()) {
                    textFieldUser.setEditable(false);
                    textFieldGroup.setEditable(false);
                    System.out.println("Leaf node has been selected. ");
                    infoView.setText("User: " + node.toString() + "    Group: " + node.getParent().toString());;
                    //textFieldUser.setText(node.toString());
                    //textFieldGroup.setText(node.getParent().toString());
                    //textFieldUserID.setText(node.getUserObject().toString());
                    
                } else {
                    textFieldUser.setEditable(true);
                    textFieldGroup.setEditable(true);
                    
                }
                
            }
            
        });
        



        tree.setBounds(10, 16, 375, 472);
        this.getContentPane().add(tree);



    }
}
