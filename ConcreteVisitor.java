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

import java.util.List;


public class ConcreteVisitor {
    
    private List<Visitable> items;

    public int showUserTotal(){
        VisitorInfo visitor = new VisitorInfo();

        for (Visitable item: items) {
            item.acceptVisitor(visitor);
        }
        return visitor.getTotalUsers();

    }

    public int showGroupTotal(){
        VisitorInfo visitor = new VisitorInfo();

        for (Visitable item: items) {
            item.acceptVisitor(visitor);
        }

        return visitor.getTotalGroups();
    }

    public int showMessageTotal(){
        VisitorInfo visitor = new VisitorInfo();

        for (Visitable item: items) {
            item.acceptVisitor(visitor);
        }

        return visitor.getTotalMessages();
    }
}
