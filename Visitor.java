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
public interface Visitor {
    
    public void visit (User users);
    public void visit (UserGroups groups);
	
}
