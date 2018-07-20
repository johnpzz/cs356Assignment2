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

import java.util.ArrayList;
import java.util.List;

// This is a Group class that defines what each User might have.
public class UserGroups implements Visitable {
	
    private static int totalGroups = 0;

    private String groupID;
    private List<UserGroups> group = new ArrayList<UserGroups>();
    private long creationTime;

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public UserGroups(){
        setTotalGroups(getTotalGroups() + 1);
    }
    
        public UserGroups(String ID){
        setTotalGroups(getTotalGroups() + 1);
        this.groupID = ID;
    }

    @Override
    public void acceptVisitor(Visitor visitor){
        visitor.visit(this);
    }	

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public static int getTotalGroups() {
        return totalGroups;
    }

    public static void setTotalGroups(int totalGroups) {
        totalGroups = totalGroups;
    }
    
    public String toString() {
        return this.getGroupID();
    }

}
