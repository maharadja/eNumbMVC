/*
 * Sets the rules for userinput
 * Then passes it to model
 */
package control;

import java.util.Scanner;
import model.Game;

/**
 *
 * @author kevin
 */
public class Parser
{

    private  Game game;

    public Parser(Game game)
    {
        this.game = game;
    }

    public void getUserList()
    {
        game.getUserList();
        
    }

    //Behövs den här? väldigt lik validate answer..
    // Och man kan använda andra metoder för att täcka funktionaliteten
    public static String validateUserInput(String word)
    {
        String input = cleanUp(word);
        maxLetters(input);
 
        return input;
    }

    public static boolean maxLetters(String word)
    {
        if (word.length() > 24 || word.length() < 1)
        {
            return false;
        }
        return true;
    }

    public static boolean lookForNumbers(String input)
    {
        String numbers = "1234567890";      
        
        for (int i = 0; i < 10; i++) {
            if(input.contains(numbers.substring(i,i+1))){
                return false;
            }  
        }
        return true;
    }
    
    
    public static String cleanUp(String s){
        
          return s.toLowerCase().trim();
        
    }
    
    public static boolean passwordCheck(String password, String retype)
    {
        if(password.equals(retype)){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validateUserName(String name)
    {
        
        String user = cleanUp(name);
        
        if((maxLetters(user) && lookForNumbers(name) && game.usernameAvailable(user))){
           
            return true;
        }
        else{
            return false;
        }
        
    }


    public boolean validateAnswer(String answer, int index)
    {
        
        if(maxLetters(answer) && lookForNumbers(answer)){
            String word = cleanUp(answer);
            return game.checkWord(index, word);
        }
        
        return false;
    }

    
    public void setGame(String wordSection, String user, int difficultyLevel)
    {
        game.setUserAndList(wordSection, user, difficultyLevel);
    }

    boolean checkIfPasswordCorrect(String user, String password) {

        game.setUser(user);
        return game.checkPassword(user, password);
        
    }
    
    public Game getGame(){
        
        return game;
    }
}
