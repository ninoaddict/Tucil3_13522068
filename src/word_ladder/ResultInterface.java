/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package word_ladder;

/**
 *
 * @author adril
 */

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResultInterface extends javax.swing.JFrame {
  public ResultInterface(Component parent, List<String> res, int numOfVisited, float timeElapsed) {
    this.parent = parent;
    initComponents(res, numOfVisited, timeElapsed);
  }

  private void initComponents(List<String> res, int numOfVisited, float timeElapsed) {
    this.setTitle("Result");
    this.setResizable(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        parent.setEnabled(true);
      }
    });

    scrollPanel = new JScrollPane();
    scrollPanel.setSize(new Dimension(60 * res.get(0).length() + 100, Math.min(1000, 60 * res.size() + 150)));
    this.add(scrollPanel);
    this.setSize(scrollPanel.getSize());

    basePanel = new JPanel();
    basePanel.setBackground(new Color(0, 51, 51));
    basePanel.setSize(new Dimension(60 * res.get(0).length() + 100, 60 * res.size() + 150));
    basePanel.setLayout(new GridBagLayout());
    scrollPanel.setViewportView(basePanel);

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(4, 0, 4, 0);
    c.gridx = 0;
    c.gridy = 0;

    numberOfPathsLabel = new JLabel();
    numberOfPathsLabel.setFont(new java.awt.Font("SansSerif", 1, 14));
    numberOfPathsLabel.setBackground(new java.awt.Color(20, 20, 20));
    numberOfPathsLabel.setForeground(new java.awt.Color(240, 240, 240));
    numberOfPathsLabel.setText("Found " + (res.size() - 1) + " steps to reach target");
    basePanel.add(numberOfPathsLabel, c);

    c.gridy = 1;
    timeElapsedLabel = new JLabel();
    timeElapsedLabel.setFont(new java.awt.Font("SansSerif", 1, 14));
    timeElapsedLabel.setBackground(new java.awt.Color(20, 20, 20));
    timeElapsedLabel.setForeground(new java.awt.Color(240, 240, 240));
    timeElapsedLabel.setText("in " + timeElapsed + " ms");
    basePanel.add(timeElapsedLabel, c);

    c.gridy = 2;
    numOfVisitedLabel = new JLabel();
    numOfVisitedLabel.setFont(new java.awt.Font("SansSerif", 1, 14));
    numOfVisitedLabel.setBackground(new java.awt.Color(20, 20, 20));
    numOfVisitedLabel.setForeground(new java.awt.Color(240, 240, 240));
    numOfVisitedLabel.setText("by visiting " + numOfVisited + " node");
    numOfVisitedLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    basePanel.add(numOfVisitedLabel, c);

    for (int i = 0; i < res.size(); i++) {
      c.gridy = 3 + i;
      basePanel.add(new ListBoxInterface(res.get(i), res.get(res.size() - 1)), c);
    }
  }

  private JScrollPane scrollPanel;
  private JPanel basePanel;
  private JLabel numberOfPathsLabel;
  private JLabel timeElapsedLabel;
  private JLabel numOfVisitedLabel;
  private Component parent;
}