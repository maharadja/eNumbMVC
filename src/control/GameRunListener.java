/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import view.Enumb;

/**
 *
 * @author kevin
 */
public class GameRunListener implements ActionListener
{

    private Enumb main;
    private JButton help, menu, fulKnappSomTasBort;
    private JPanel leftPanel, rightPanel, mainContainer, emptyRightPanel, emptyLeftPanel, emptyBottomPanel;
    private JLabel topLabel;
    private JTextField wordToTranslate, translateField, correctNumbersField;
    private JProgressBar progressBar;
    private int wordNumber, correctNumbers;

    public GameRunListener(Enumb main, JButton help, JButton menu, JButton fulKnappSomTasBort, JPanel leftPanel, JPanel rightPanel, JPanel emptyRightPanel, JPanel emptyLeftPanel, JPanel emptyBottomPanel, JLabel topLabel, JTextField wordToTranslate, JTextField translateField, JTextField correctNumbersField, JProgressBar progressBar, int wordNumber, int correctNumbers)
    {
        this.main = main;
        this.help = help;
        this.menu = menu;
        this.fulKnappSomTasBort = fulKnappSomTasBort;
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
        this.emptyRightPanel = emptyRightPanel;
        this.emptyLeftPanel = emptyLeftPanel;
        this.emptyBottomPanel = emptyBottomPanel;
        this.topLabel = topLabel;
        this.wordToTranslate = wordToTranslate;
        this.translateField = translateField;
        this.correctNumbersField = correctNumbersField;
        this.progressBar = progressBar;
        this.wordNumber = wordNumber;
        this.correctNumbers = correctNumbers;
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
            //help window
        }
        else if (choice == menu)
        {
            main.goFromLogin();
        }
        else if (choice == fulKnappSomTasBort){
            main.goFromGameRunToResult();
        }
    }

}
