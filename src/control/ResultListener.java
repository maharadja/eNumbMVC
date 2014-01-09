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
import view.Enumb;

/**
 *
 * @author kevin
 */
public class ResultListener implements ActionListener
{

    private Enumb main;
    private JLabel topLabel, goodResultText, okayResultText, badResultText, resultSummary, percentText, compareResult, easyResultWindow, mediumResultWindow, hardResultWindow;
    private JPanel leftContainer, rightContainer, allLevelsIncludedLabel;
    private JButton menu, help, quit;
    private int correctAnswers, inPercent, comparedToEarlierResult, easyLevelResult, mediumLevelResult, hardLevelResult;

    public ResultListener(Enumb main, JLabel topLabel, JLabel goodResultText, JLabel okayResultText, JLabel badResultText, JLabel resultSummary, JLabel compareResult, JLabel easyResultWindow, JLabel mediumResultWindow, JLabel hardResultWindow, JPanel leftContainer, JPanel rightContainer, JPanel allLevelsIncludedLabel, JButton menu, JButton help, JButton quit, int correctAnswers, int inPercent, int comparedToEarlierResult, int easyLevelResult, int mediumLevelResult, int hardLevelResult)
    {
        this.main = main;
        this.topLabel = topLabel;
        this.goodResultText = goodResultText;
        this.okayResultText = okayResultText;
        this.badResultText = badResultText;
        this.resultSummary = resultSummary;
        this.compareResult = compareResult;
        this.easyResultWindow = easyResultWindow;
        this.mediumResultWindow = mediumResultWindow;
        this.hardResultWindow = hardResultWindow;
        this.leftContainer = leftContainer;
        this.rightContainer = rightContainer;
        this.allLevelsIncludedLabel = allLevelsIncludedLabel;
        this.menu = menu;
        this.help = help;
        this.quit = quit;
        this.correctAnswers = correctAnswers;
        this.inPercent = inPercent;
        this.comparedToEarlierResult = comparedToEarlierResult;
        this.easyLevelResult = easyLevelResult;
        this.mediumLevelResult = mediumLevelResult;
        this.hardLevelResult = hardLevelResult;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
