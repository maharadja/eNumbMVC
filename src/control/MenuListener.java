/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Game;
import view.Enumb;
import view.MenuHelp;

/**
 *
 * @author kevin
 */
public class MenuListener implements ActionListener
{

    private JComboBox<String> chooseLanguage;
    private JButton addNewLanguage, help, quit, next, logOut;
    private JPanel container, containerW, containerE, topLine;
    private JLabel topHeading, flagLabel;
    private Enumb main;
    private Parser parser;
    private Game game;
    private JTextField newLanguageField;

    public MenuListener(JLabel flagLabel, JComboBox<String> chooseLanguage, JButton addNewLanguage, JButton help, JButton quit, JButton next, JButton logOut,
            JPanel containerW, JPanel containerE, JPanel topLine, JLabel topHeading,
            Enumb main, JTextField newLanguageField)
    {
        this.chooseLanguage = chooseLanguage;
        this.addNewLanguage = addNewLanguage;
        this.help = help;
        this.quit = quit;
        this.next = next;
        this.logOut = logOut;
        this.container = container;
        this.containerW = containerW;
        this.containerE = containerE;
        this.topHeading = topHeading;
        this.flagLabel = flagLabel;
        this.main = main;
        this.newLanguageField = newLanguageField;

        parser = MainFactory.getParser();
        game = parser.getGame();

    }

    public MenuListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String language = chooseLanguage.getItemAt(chooseLanguage.getSelectedIndex());
        ImageIcon flag = new ImageIcon("images\\flags\\" + language + ".png");

        if (flag.getIconHeight() < 1)
        {
            flag = new ImageIcon("images\\flags\\pride.png");
        }

        flagLabel.setIcon(flag);

        Object choice = (e.getSource());

        if (choice == addNewLanguage)
        {
            // AddNewLanguage.display();
            String lang = newLanguageField.getText();
            if (languageAvailable(lang))
            {
                game.addNewLanguage(lang);
                newLanguageField.setText("");
                setDropDown();

            }

        }
        else if (choice == quit)
        {
            System.exit(0);
        }
        else if (choice == logOut)
        {
            main.logOutUser();
        }
        else if (choice == next)
        {
            main.goFromMenuToChosenLanguage();
        }
        else if (choice == help)
        {
            MenuHelp.display();
        }
    }

    private boolean languageAvailable(String inputLang)
    {

        if (parser.validateUserInput(inputLang))
        {
            String lang = parser.cleanUp(inputLang);
            String[] langs = game.getListOfLanguages();
            for (int i = 0; i < langs.length; i++)
            {
                if (langs[i].equals(lang))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public String[] getLanguages()
    {

        String[] languages = game.getListOfLanguages();
        String[] langWithCaps = new String[languages.length];

        for (int i = 0; i < languages.length; i++)
        {
            langWithCaps[i] = parser.firstLetterCapital(languages[i]);
        }
        return langWithCaps;
    }

    public void setDropDown()
    {

        chooseLanguage.removeAllItems();

        String[] langs = getLanguages();

        for (String s : langs)
        {

            chooseLanguage.addItem(s);
        }

    }

}
