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



public class ConcreteUser implements Observer {
	
	private String name;
	private Subject subject;
	
	public ConcreteUser(String name){
		this.name = name;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubject(Subject subject) {
		this.subject = subject;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
        
        public String toString() 
        {
            return this.name;
        }
}


