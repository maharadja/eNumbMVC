/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Felix
 */
public class Game {
    
    UserList ul;
    FileManager fm;
    
    public Game(){
        
        fm = new FileManager();
        ul = new UserList();
        ul = fm.readUserFiles();
        
    }

    public String[] getUserList() {
        
        
        
        return ul.showList();
    }

    public User getUser(String user) {
        
        return ul.getUser(user);
        
    }

   
    
    
    
    
}
