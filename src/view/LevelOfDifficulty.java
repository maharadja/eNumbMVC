/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.LevelOfDiffucltyListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolTip;

/**
 *
 * @author Viktor
 */
public class LevelOfDifficulty extends JPanel
{

    private JPanel container;
    private JLabel chooseDifficultyText;
    private JSlider slider;
    private JButton back, go;
    private Enumb main;
    private JToolTip toolTipEasy; // Används inte... provar lite för att slippa bakgrunden på tooltipen.

    public LevelOfDifficulty(Enumb jf)
    {

        //new Panels
        container = new JPanel();

        //new Labels
        chooseDifficultyText = new JLabel("Välj svårighetsgrad!");

        //new Buttons
        back = new JButton("Tillbaka");
        go = new JButton("Kör!");

        //new Slider
        slider = new JSlider(JSlider.HORIZONTAL, 1, 3, 1);

        //new HashTable
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();

        main = jf;

        //LevelOfDiffucltyListener
        LevelOfDiffucltyListener listener = new LevelOfDiffucltyListener(container, chooseDifficultyText, slider, back, go, main, toolTipEasy);

        //set size
        container.setPreferredSize(new Dimension(700, 500));
        slider.setPreferredSize(new Dimension(700, 150));

        //background settings
        setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        slider.setBackground(Color.WHITE);

        //font settings
        chooseDifficultyText.setFont(new Font("century gothic", Font.BOLD, 34));

        //add actionListeners and changeListeners
        back.addActionListener(listener);
        go.addActionListener(listener);
        slider.addChangeListener(listener);

        //Settings for JSlider
        labelTable.put(1, new JLabel("Lätt"));
        labelTable.put(2, new JLabel("Medel"));
        labelTable.put(3, new JLabel("Svårt"));
        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(0);

        //Addings
        container.add(chooseDifficultyText);
        container.add(Box.createRigidArea(new Dimension(58, 220)));
        container.add(slider);
        container.add(go);
        container.add(back);
        add(container);

    }

}
