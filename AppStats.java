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


public class AppStats {

    private double percentage = 0.0;
    private double totalMessages = 0.0;
    private double positiveMessages = 0.0;
    private List<String> messages = new ArrayList<String>();
    private List<String> positiveWords = new ArrayList<String>();
	
    public AppStats() {
        addPositiveWords();
        addMessages();
        setTotalMessages(messages.size());
        calcPositiveMessages();
        setPercentage(getPositiveMessages()/getTotalMessages());
    }

    private void calcPositiveMessages(){

        int posCount = 0;
        for(String x: messages){
                for(String y: positiveWords){
                        if(x.toLowerCase().contains(y)){
                                posCount++;
                        }
                }
        }
        setPositiveMessages(posCount);
    }

    private void addMessages(){
        this.messages.add("CS356 is a good class");
        this.messages.add("I am happy!");
        this.messages.add("Horror night is good");
    }

    private void addPositiveWords(){
        this.positiveWords.add("cool");
        this.positiveWords.add("good");
        this.positiveWords.add("fun");
        this.positiveWords.add("happy");
    }

    public double getPositiveMessages() {
        return positiveMessages;
    }

    private void setPositiveMessages(int positiveMessages) {
        this.positiveMessages = positiveMessages;
    }

    public double getTotalMessages() {
        return totalMessages;
    }

    private void setTotalMessages(int totalMessages) {
        this.totalMessages = totalMessages;
    }

    public double getPercentage() {
        return percentage;
    }

    private void setPercentage(double percentage) {
        this.percentage = percentage*100;
    }

	
	
	
}
