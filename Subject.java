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


public interface Subject {
	
	
    public void attach(Observer obs);

    public void detach(Observer obs);

    public void notifyObservers();

    public List<String> getUpdate(Observer obs);
}
