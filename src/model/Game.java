/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Felix
 */
public class Game
{

    UserList ul;
    FileManager fm;
    WordList tempWordlist;
    private String tempLang;

    public Game()
    {

        fm = new FileManager();
        ul = new UserList();
        ul = fm.readUserFiles();

    }

    public String[] getUserList()
    {

        return ul.showList();
    }

    public User getUser(String user)
    {

        return ul.getUser(user);

    }

    public String getUserInformation(String username, int choice) throws NullPointerException
    {

        User user = getUser(username);

        switch (choice)
        {

            case 1:
                return user.getfirstname();

            case 2:
                return user.getlastname();

            case 3:
                return user.getPassword();

            case 4:
                String s = "";
                s += user.getHightScore();
                return s;

            case 5:
                String r = "";
                r += user.getTotalScore();
                return r;

            default:
                return "du har gjort fel";

        }

    }

    /**
     * Compares the given password with the actual password of the requested user.
     *
     * @param username
     * @param password
     * @return
     */
    public boolean checkPassword(String username, String password)
    {

        User user = getUser(username);

        if (user.getPassword().equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * Adds a new User and returns true if successful and false if not.
     *
     * @param fName
     * @param lName
     * @param pw1
     * @param pw2
     * @return
     */
    public boolean addNewUser(String fName, String lName, String pw1, String pw2)
    {

        if (pw1.equals(pw2))
        {
            User newUser = new User(new String[]
            {
                fName, lName, pw1
            });
            ul.addUser(newUser);
            fm.writeUserFile(newUser);
            return true;
        }
        else
        {
            return false;
        }

    }

    void createWordList(String fileName, String lang, String[] words)
    {

        tempWordlist = new WordList(fileName);
        tempLang = lang;

        for (int i = 0; i < 20; i++)
        {
            if (i % 2 == 0 || i == 0)
            {
                tempWordlist.addNewWord(words[i], words[i + 1], tempLang);
            }
        }
        fm.writeWordFile(tempWordlist);
    }

    public WordList getWordList(String fileName)
    {

        return fm.readWordFile(fileName);

    }
    
    public String[] getListOfWordfiles(){
      
        return fm.getListOfWordSections("filename");
        
    }
    
    //public String[] getListOfLanguages(){
        
    //    int index = 0;
      
    //    String[] langs =  fm.getListOfWordSections("language");
        
       
        
        
        
    // }

}
