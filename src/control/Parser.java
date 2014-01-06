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

    private Game game;

    public Parser()
    {
        game = new Game();
    }

    public void getUserList()
    {
        game.getUserList();
    }

    public String validateUserInput(String word)
    {
        String input = word.toLowerCase().trim();
        maxLetters(input);
        eliminateNumbers(input);
        System.out.println(input);

        return input;
    }

    private String maxLetters(String word)
    {
        if (word.length() > 24 || word.length() < 1)
        {
            //felmeddelande panel
        }
        return word;
    }

    private String eliminateNumbers(String input)
    {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt())
        {
            //felmeddelande panel
        }
        return input;
    }

    public void validateFullName(String name)
    {
        String user = name.toLowerCase().trim();
        maxLetters(user);
    }

    public void passwordCheck(String password)
    {
        String word = password.toLowerCase().trim();
        maxLetters(word);
    }

    public void validateAnswer(String answer)
    {
        String word = answer.toLowerCase().trim();
        eliminateNumbers(word);
        maxLetters(word);
        //send to model
    }

    public void setGame(int difficultyLevel)
    {
        int level = difficultyLevel;
        switch (level)
        {
            case 1: //call method to set difficulty level to 1
                break;
            case 2: //call method to set difficulty level to 2
                break;
            case 3: //call method to set difficulty level to 3
        }
    }
}
