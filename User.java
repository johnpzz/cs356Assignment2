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


public class User implements Subject, Visitable {

    private static int totalUsers = 0;
    private static int totalMessages = 0;

    private List<Observable> observers;
    private String userID;
    private List<String> followers = new ArrayList<String>();
    private List<String> followings = new ArrayList<String>();
    private List<String> newsFeed = new ArrayList<String>();
    private long creationTime;
    private long lastUpdateTime;

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }
		
    public User() {
        setTotalUsers(getTotalUsers() + 1);
    }
        
    public User(String name){
        setTotalUsers(getTotalUsers() + 1);
        this.userID = name;
    }

    public void tweet(String tweet){
        setTotalMessages(getTotalMessages() + 1);
        newsFeed.add(tweet);
        setLastUpdateTime(System.currentTimeMillis());
    }

    public String returnFollowers(){
        String d = "";
        for (String str : followers) {
            d += str;
            d += "\n";
        }
        return d;
    }

    public String returnTweets(){
        String tweets = "";
        for (String news : newsFeed) {
            tweets += news;
            tweets += "\n";
        }
        return tweets;

    }

    public void printTweets(){
        for (String news:newsFeed) {
            System.out.println(news);			
        }
    }

    public String getUserID() {
        return userID;
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void addFollower(String follower){
        followers.add(follower);
    }


    @Override
    public void acceptVisitor(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public void attach(Observable obj) {
        observers.add(obj);

    }

    @Override
    public void detach(Observable obj) {
            observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observable> observersLocal = new ArrayList<>(this.observers);

        for (Observable obj: observersLocal) {
            obj.Update();
        }

    }
    
    public List<String> getNewsFeed() {
        return this.newsFeed;
    }

    @Override
    public List<String> getUpdate(Observable obj) {
        return this.newsFeed;		
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public static void setTotalUsers(int totalUsers) {
            User.totalUsers = totalUsers;
    }

    public static int getTotalMessages() {
            return totalMessages;
    }

    public static void setTotalMessages(int totalMessages) {
            User.totalMessages = totalMessages;
    }

    public String toString() {
        return this.getUserID();
    }

}
