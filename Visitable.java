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
public interface Visitable {
    
    public void acceptVisitor(Visitor visitor);
}
