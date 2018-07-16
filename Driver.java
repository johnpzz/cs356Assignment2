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

//The program's driver class.  getInstance() calls the JFrame to display onto the screen (in JSwing, it's by default non-visible)
public class Driver {
    
    
    public static void main(String[] args) {
            
        // Try to create two apps, we see only one is made (Singleton Pattern)
        MiniTwitterApp.getInstance();
        MiniTwitterApp.getInstance();
        
    }

}
