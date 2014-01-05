/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolTip;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import view.Enumb;

/**
 *
 * @author kevin
 */
public class LevelOfDiffucltyListener implements ActionListener, ChangeListener
{

    private JPanel container;
    private JLabel chooseDifficultyText;
    private JSlider slider;
    private JButton back, go;
    private Enumb main;
    private JToolTip toolTipEasy; // Används inte... provar lite för att slippa bakgrunden på tooltipen.

    public LevelOfDiffucltyListener(JPanel container, JLabel chooseDifficultyText, JSlider slider, JButton back, JButton go, Enumb main, JToolTip toolTipEasy)
    {
        this.container = container;
        this.chooseDifficultyText = chooseDifficultyText;
        this.slider = slider;
        this.back = back;
        this.go = go;
        this.main = main;
        this.toolTipEasy = toolTipEasy;
    }

    public LevelOfDiffucltyListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        JSlider source = (JSlider) e.getSource();
        int fps = (int) source.getValue();

        UIManager.put("ToolTip.background", new Color(0x40, 0x51, 0x67, 0x40)); //Changes background color on toolTip.
        UIManager.put("ToolTip.border", BorderFactory.createEmptyBorder()); // Removes border on tooltip.

        String toolTipEasy = "<html><img src=\"file:images\\easy.png\"></html>";
        String toolTipMedium = "<html><img src=\"file:images\\medium.png\"></html>";
        String toolTipHard = "<html><img src=\"file:images\\hard.png\"></html>";
        if (fps == 1)
        {
            slider.setToolTipText(toolTipEasy);
        }
        else if (fps == 2)
        {
            slider.setToolTipText(toolTipMedium);
            container.updateUI();

        }
        else if (fps == 3)
        {
            slider.setToolTipText(toolTipHard);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == back)
        {
            main.goFromMenuToChosenLanguage();
        }
        else if (choice == go)
        {
            main.goFromDifficultyToRunGame();

        }
    }

}
