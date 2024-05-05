package word_ladder;

import java.util.List;
import javax.swing.*;
import java.awt.*;

public class ResultInterface extends javax.swing.JFrame {
  public ResultInterface(List<String> res, int numOfVisited, float timeElapsed) {
    initComponents(res, numOfVisited, timeElapsed);
  }

  private void initComponents(List<String> res, int numOfVisited, float timeElapsed) {
    this.setTitle("Result");
    this.setResizable(true);

    scrollPanel = new JScrollPane();
    scrollPanel.setSize(new Dimension(60 * res.get(0).length() + 80, Math.min(1000, 60 * res.size() + 150)));
    scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
    this.add(scrollPanel);
    this.setSize(scrollPanel.getSize());

    basePanel = new JPanel();
    basePanel.setBackground(new Color(20, 20, 20));
    basePanel.setSize(new Dimension(60 * res.get(0).length() + 80, 60 * res.size() + 150));
    basePanel.setLayout(new GridBagLayout());
    scrollPanel.setViewportView(basePanel);

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(4, 0, 4, 0);
    c.gridx = 0;
    c.gridy = 0;

    numberOfPathsLabel = new JLabel();
    numberOfPathsLabel.setFont(new java.awt.Font("Linux Libertine", 1, 14));
    numberOfPathsLabel.setBackground(new java.awt.Color(20, 20, 20));
    numberOfPathsLabel.setForeground(new java.awt.Color(204, 204, 204));
    numberOfPathsLabel.setText("Found " + (res.size() - 1) + " steps to reach target");
    basePanel.add(numberOfPathsLabel, c);

    c.gridy = 1;
    timeElapsedLabel = new JLabel();
    timeElapsedLabel.setFont(new java.awt.Font("Linux Libertine", 1, 14));
    timeElapsedLabel.setBackground(new java.awt.Color(20, 20, 20));
    timeElapsedLabel.setForeground(new java.awt.Color(204, 204, 204));
    timeElapsedLabel.setText("in " + timeElapsed + " ms");
    basePanel.add(timeElapsedLabel, c);

    c.gridy = 2;
    numOfVisitedLabel = new JLabel();
    numOfVisitedLabel.setFont(new java.awt.Font("Linux Libertine", 1, 14));
    numOfVisitedLabel.setBackground(new java.awt.Color(20, 20, 20));
    numOfVisitedLabel.setForeground(new java.awt.Color(204, 204, 204));
    numOfVisitedLabel.setText("by visiting " + numOfVisited + " nodes");
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
}