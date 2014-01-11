/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.Enumb;

/**
 *
 * @author kevin
 */
public class AddNewSectionListener implements ActionListener
{

    private JButton back, addNewWords;
    private Enumb main;

    public AddNewSectionListener(JButton back, JButton addNewWords, Enumb main)
    {
        this.back = back;
        this.addNewWords = addNewWords;
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object choice = (e.getSource());
        if (choice == back)
        {
            main.goFromMenuToChosenLanguage();
        }
        else if (choice == addNewWords)
        {

        }

    }

}
