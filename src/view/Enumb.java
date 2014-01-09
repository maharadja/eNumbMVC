/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Viktor
 */
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public final class Enumb extends JFrame
{

    JPanel cont, test;
    JLabel background, testLabel;
    JLayeredPane jPane;
    JButton logIn;
    CardLayout cl;

    Menu menu;
    LogIn login;
    ChosenLanguage chosenLanguage;
    LevelOfDifficulty levelOfDifficulty;
    GameRun gameRun;
    Result result;

    public Enumb() throws IOException
    {

        //new Panels
        cont = new JPanel();

        //new Layouts
        cl = new CardLayout();

        login = new LogIn(this);
        menu = new Menu(this);
        chosenLanguage = new ChosenLanguage(this);
        levelOfDifficulty = new LevelOfDifficulty(this);
        gameRun = new GameRun(this, 2);
        result = new Result(this);

        //addNewLanguage = new AddNewLanguage(this);
        JFrame();
        //layout settings.
        cont.setLayout(cl);

        //addings.
        cont.add(login, "1");
        cont.add(menu, "2");
        cont.add(chosenLanguage, "3");
        cont.add(levelOfDifficulty, "4");
        cont.add(result, "6");
        add(cont);//adding to extended JFrame

        cl.show(cont, "1");

    }

//    public static void main(String[] args) throws IOException
//    {
//        Enumb enumb = new Enumb();
//    }
    public void JFrame()
    {
        //settings for the extended JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(512, 690));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public void goFromLogin()
    {
        cl.show(cont, "2");
        setPreferredSize(new Dimension(1330, 900));
        menu.updateUI();
        pack();
        setLocationRelativeTo(null);
    }

    public void goFromMenuToChosenLanguage()
    {
        cl.show(cont, "3");
        setPreferredSize(new Dimension(1330, 900));
        chosenLanguage.updateUI();
        pack();
        setLocationRelativeTo(null);
    }

    public void goFromChosenLanguageToDifficulty()
    {
        cl.show(cont, "4");
        setPreferredSize(new Dimension(1330, 900));
        levelOfDifficulty.updateUI();
        pack();
        setLocationRelativeTo(null);
    }

    public void goFromDifficultyToRunGame(int i)
    {
        gameRun = new GameRun(this, i);
        cont.add(gameRun, "5");
        cl.show(cont, "5");
        setPreferredSize(new Dimension(1330, 900));
        gameRun.updateUI();
        pack();
        setLocationRelativeTo(null);
    }

    public void goFromGameRunToResult()
    {
        cl.show(cont, "6");
        setPreferredSize(new Dimension(1330, 900));
        result.updateUI();
        pack();
        setLocationRelativeTo(null);

    }

    public void logOutUser()
    {
        cl.show(cont, "1");
        JFrame();
    }

}
