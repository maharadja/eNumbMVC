/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.Enumb;
import view.Help;

/**
 *
 * @author kevin
 */
public class GameRunListener implements ActionListener
{

    private JButton help, menu, choiceNr1, choiceNr2, choiceNr3, choiceNr4, fulKnappSomTasBort;
    private Enumb main;

    public GameRunListener(JButton help, JButton menu, JButton choiceNr1, JButton choiceNr2, JButton choiceNr3, JButton choiceNr4, JButton fulKnappSomTasBort, Enumb main)
    {
        this.help = help;
        this.menu = menu;
        this.choiceNr1 = choiceNr1;
        this.choiceNr2 = choiceNr2;
        this.choiceNr3 = choiceNr3;
        this.choiceNr4 = choiceNr4;
        this.fulKnappSomTasBort = fulKnappSomTasBort;
        this.main = main;

    }

    public GameRunListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == help)
        {
            Help.display("GameRun");
        }
        else if (choice == menu)
        {
            main.goFromLogin();
        }
        else if (choice == fulKnappSomTasBort)
        {
            main.goFromGameRunToResult();
        }

        else if (choice == choiceNr1)
        {
            JOptionPane.showMessageDialog(null, "Jag fyller ingen funktion 1");
        }
        else if (choice == choiceNr1)
        {
            JOptionPane.showMessageDialog(null, "Jag fyller ingen funktion 2");
        }

        else if (choice == choiceNr1)
        {
            JOptionPane.showMessageDialog(null, "Jag fyller ingen funktion 3");
        }
        else if (choice == choiceNr1)
        {
            JOptionPane.showMessageDialog(null, "Jag fyller ingen funktion 4");
        }
    }

}
