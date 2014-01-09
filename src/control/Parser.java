/*
 * Sets the rules for userinput
 * Then passes it to model
 */
package control;

import java.util.Scanner;
import model.Game;
import view.ErrorMessage;

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
        //System.out.println(input);

        return input;
    }

    public String maxLetters(String word)
    {
        if (word.length() > 5 || word.length() < 1)
        {
            ErrorMessage.display("Du får inte har mer än 10 tecken");//felmeddelande panel
            return word;
        }

        return word;

    }

    public String eliminateNumbers(String input)
    {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt())
        {
            //felmeddelande panel
        }
        return input;
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
