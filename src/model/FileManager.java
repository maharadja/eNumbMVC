/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.io.*;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class FileManager
{

    File tempFile;
    Scanner scanner;
    File wordDirectory = new File("data\\words");
    File[] wordfiles = wordDirectory.listFiles();
    File userDirectory = new File("data\\users");
    File[] userfiles = userDirectory.listFiles();
    ArrayList<WordList> wordSections;
    
    

    public WordList readWordFile(String filename)
    {

        tempFile = new File("data\\words\\" + filename + ".txt");

        WordList words = new WordList("words");

        String lang;

        try
        {
            scanner = new Scanner(tempFile);
        }
        catch (Exception e)
        {
            System.out.println("file not read");
        }

        lang = scanner.nextLine();

        for (int i = 0; i < 10; i++)
        {
            words.addNewWord(scanner.next(), scanner.next(), lang);
        }
        
        return words;
    }

    public void writeWordFile(WordList wl)
    {

        tempFile = new File("data\\words\\" + wl.getName() + ".txt");
        tempFile.getParentFile().getParentFile().mkdirs();
        tempFile.getParentFile().mkdirs();

        try
        {
            PrintWriter writer = new PrintWriter(tempFile);
            writer.println(wl.getLang());
            for (int i = 0; i < 10; i++)
            {
                String[] s = wl.getWord(i);
                writer.println(s[0] + " " + s[1]);
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("write failed");
        }
    }

    public UserList readUserFiles()
    {

        // File tempFile = new File(fileName + ".txt");
        UserList userlist = new UserList();
        int index = 0;

        while (index < userfiles.length)
        {

            try
            {
                Scanner scanner = new Scanner(userfiles[index]);
                userlist.addUser((new String[]
                {
                    scanner.nextLine(), scanner.nextLine(), scanner.nextLine()
                }));
            }
            catch (Exception e)
            {
                System.out.println("file not found");
            }

            index++;
        }

        return userlist;
    }

    public void createUserList()
    {

    }

    public void writeUserFile(User user)
    {

        User tempUser = user;

        tempFile = new File("data\\users\\" + tempUser.getUsername() + ".txt");
        tempFile.getParentFile().getParentFile().mkdirs();
        tempFile.getParentFile().mkdirs();

        try
        {
            PrintWriter writer = new PrintWriter(tempFile);
            writer.println(tempUser.getfirstname());
            writer.println(tempUser.getlastname());
            writer.println(tempUser.getPassword());
            writer.println(tempUser.getHightScore());
            writer.println(tempUser.getTotalScore());
            writer.close();
        }
        catch (Exception e)
        {
        }

    }

    void removeUserFile(String fileName)
    {

        File removeFile = new File("data\\users\\" + fileName + ".txt");
        removeFile.delete();

    }
    
    void removeWordFile(String fileName)
    {

        File removeFile = new File("data\\words\\" + fileName + ".txt");
        removeFile.delete();

    }

    public String[] getListOfWordSections(String get) {
        
        int length = (int) wordfiles.length;
        
        String[] list = new String[length];
       
        for (int i = 0; i < length; i++) {
            
            if(get.equals("filename")){
            String s = wordfiles[i].getName();
            s = s.substring(0, s.length()-4);
            list[i] = s;}
            else if(get.equals("language")){
                
            try{  scanner = new Scanner(wordfiles[i]);
               String s = scanner.nextLine();
               list[i] = s;
             }
             catch(Exception e){}  
            }
          
        }
        
        return list;
        
    }
    
    public String[] getListOfWordSections(){
        
        readAllWordFiles();
        
        String[] sections = new String[wordSections.size()];
        
        for (int i = 0; i < wordSections.size(); i++) {
            
            sections[i] = wordSections.get(i).getName();
        }
        
        return sections;
    }
    
    private void readAllWordFiles(){
        
        wordSections = new ArrayList<>();
        
        int length = (int) wordfiles.length;
        
       // String[] list = new String[length];
       
        for (int i = 0; i < length; i++) {
            
            String s = wordfiles[i].getName();        
            s = s.substring(0, s.length()-4);
            wordSections.add(readWordFile(s));  
        }
    }
            

 

}
