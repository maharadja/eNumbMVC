/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.*;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author kevin
 */
public class FileManager
{


    File tempFile;
    Scanner scanner;
    File directory = new File("data");
    File[] files = directory.listFiles();
    
    public WordList readWordFile(String filename) {
        
        tempFile = new File(filename);
        
        WordList words = new WordList("words");
        
        String lang;
        
        try{
        scanner = new Scanner(tempFile);}
        catch(Exception e){   
            System.out.println("file not read");
        }
        
        lang = scanner.nextLine();
        
        for (int i = 0; i < 10; i++) {
        words.addNewWord(scanner.next(), scanner.next(), lang);
        }
        
        return words;
    }
    
    public void writeWordFile(WordList wl){
        
        tempFile = new File(wl.getName() + ".txt");
        
        try{
        PrintWriter writer = new PrintWriter(tempFile);
        writer.println(wl.getLang());
            for (int i = 0; i < 10; i++) {
                String[] s = wl.getWord(i);
                writer.println(s[0] + " " + s[1]);
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println("write failed");
        }
    }

    public UserList readUserFiles() {
               
      // File tempFile = new File(fileName + ".txt");
       UserList userlist = new UserList();
       int index = 0;
        
        while( index < files.length){

       try{
       Scanner scanner = new Scanner(files[index]);
       userlist.addUser((new String[]{scanner.nextLine(), scanner.nextLine(), scanner.nextLine()}));       
       }
       catch(Exception e){System.out.println("file not found");}
       
       index++;
        }
       
      return userlist;
    }
    
    public void createUserList(){
        
        
        
    }
    
    

    public void writeUserFile(User user) {
        
        User tempUser = user;
        
        try{
        PrintWriter writer = new PrintWriter(new File(tempUser.getUsername() + ".txt"));
        writer.println(tempUser.getfirstname());
        writer.println(tempUser.getlastname());
        writer.println(tempUser.getPassword());
        writer.println(tempUser.getHightScore());
        writer.println(tempUser.getTotalScore());
        writer.close();
        }
        catch(Exception e){}
        
        
        
    }

    void removeFile(String fileName) {
        File removeFile = new File(fileName + ".txt");
        removeFile.delete();
    }
    


}
