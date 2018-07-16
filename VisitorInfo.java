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
public class VisitorInfo implements Visitor {
	
    private int totalUsers;
    private int totalMessages;
    private int totalGroups;


    @Override
    public void visit(User users) {
        setTotalUsers(users.getTotalUsers());
        setTotalMessages(users.getTotalMessages());
    }

    @Override
    public void visit(UserGroups groups) {
        setTotalGroups(groups.getTotalGroups());

    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getTotalMessages() {
        return totalMessages;
    }

    public void setTotalMessages(int totalMessages) {
        this.totalMessages = totalMessages;
    }

    public int getTotalGroups() {
        return totalGroups;
    }

    public void setTotalGroups(int totalGroups) {
        this.totalGroups = totalGroups;
    }


}
