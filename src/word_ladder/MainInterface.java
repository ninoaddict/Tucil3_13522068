package word_ladder;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainInterface extends JFrame {
  public MainInterface() {
    initComponents();
  }

  private void initComponents() {
    this.setTitle("Word Ladder");
    this.setSize(600, 400);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    basePanel = new JPanel();
    basePanel.setBackground(new Color(20, 20, 20));
    basePanel.setSize(this.getSize());
    basePanel.setLayout(new GridBagLayout());
    this.add(basePanel);

    GridBagConstraints basePanelGbc = new GridBagConstraints();
    basePanelGbc.insets = new Insets(2, 2, 2, 2);
    basePanelGbc.gridx = 0;
    basePanelGbc.gridy = 0;

    title = new JLabel();
    title.setFont(new Font("Linux Libertine", 1, 24));
    title.setForeground(new Color(204, 204, 204));
    title.setText("Word Ladder Solver");
    title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    basePanel.add(title, basePanelGbc);
    basePanelGbc.gridy = 1;

    startInput = new WordInputInterface();
    startInput.setFocusable(true);
    basePanel.add(startInput, basePanelGbc);
    basePanelGbc.gridy = 2;

    midLabel = new JLabel();
    midLabel.setFont(new Font("Linux Libertine", 1, 14));
    midLabel.setForeground(new Color(204, 204, 204));
    midLabel.setText("TO");
    midLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    basePanel.add(midLabel, basePanelGbc);
    basePanelGbc.gridy = 3;

    endInput = new WordInputInterface();
    endInput.setFocusable(true);
    basePanel.add(endInput, basePanelGbc);
    basePanelGbc.gridy = 4;

    endInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

    algoSelect = new JComboBox<>();
    algoSelect.setBackground(new Color(20, 20, 20));
    algoSelect.setFont(new Font("Linux Libertine", 1, 14));
    algoSelect.setForeground(new Color(204, 204, 204));
    algoSelect.setModel(new DefaultComboBoxModel<>(
        new String[] { "Uniform Cost Search", "Best First Search", "A* Algorithm" }));
    algoSelect.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    basePanel.add(algoSelect, basePanelGbc);
    basePanelGbc.gridy = 5;

    searchButton = new JButton();
    searchButton.setBackground(new Color(55, 65, 81));
    searchButton.setFont(new Font("Linux Libertine", 1, 14));
    searchButton.setForeground(new Color(204, 204, 204));
    searchButton.setText("Search");
    searchButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchButtonActionPerformed(evt);
      }
    });
    basePanel.add(searchButton, basePanelGbc);

    startInput.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent me) {
        startInput.requestFocus();
      }
    });

    endInput.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent me) {
        endInput.requestFocus();
      }
    });
  }

  private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchButtonActionPerformed
    String startText = startInput.getText().toLowerCase().trim();
    String endText = endInput.getText().toLowerCase().trim();

    if (startText.equals("") || endText.equals("")) {
      JOptionPane.showMessageDialog(this, "Field can't be empty");
    }

    if (!Node.checkDictionary(startText)) {
      JOptionPane.showMessageDialog(this, startText + " is not found");
      return;
    }

    if (!Node.checkDictionary(endText)) {
      JOptionPane.showMessageDialog(this, endText + " is not found");
      return;
    }

    if (endText.length() != startText.length()) {
      JOptionPane.showMessageDialog(this, "The inputs must be of the same length");
      return;
    }

    int selectedIndex = algoSelect.getSelectedIndex();

    try {
      List<String> res;
      ResultInterface ri;
      long timestart = System.nanoTime();
      long timeend;
      switch (selectedIndex) {
        case 0:
          UCS ucs = new UCS();
          res = ucs.solveWordLadder(startText, endText);
          timeend = System.nanoTime();

          if (res.isEmpty()) {
            this.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Solution not found!");
            return;
          }

          // this.setEnabled(false);
          ri = new ResultInterface(res, ucs.getNumOfVisited(), (float) (timeend - timestart)/1000000);
          ri.setVisible(true);
          break;
        case 1:
          GBFS bfs = new GBFS();
          res = bfs.solveWordLadder(startText, endText);
          timeend = System.nanoTime();

          if (res.isEmpty()) {
            this.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Solution not found!");
            return;
          }

          // this.setEnabled(false);
          ri = new ResultInterface(res, bfs.getNumOfVisited(), (float) (timeend - timestart)/1000000);
          ri.setVisible(true);
          break;
        case 2:
          AStar astar = new AStar();
          res = astar.solveWordLadder(startText, endText);
          timeend = System.nanoTime();

          if (res.isEmpty()) {
            this.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Solution not found!");
            return;
          }

          // this.setEnabled(false);
          ri = new ResultInterface(res, astar.getNumOfVisited(), (float) (timeend - timestart)/1000000);
          ri.setVisible(true);
          break;
        default:
          break;
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Solution not found!");
      e.printStackTrace();
      this.setEnabled(true);
      return;
    } 
  }

  private JLabel title;
  private JLabel midLabel;
  private WordInputInterface startInput;
  private WordInputInterface endInput;
  private JPanel basePanel;
  private JComboBox<String> algoSelect;
  private JButton searchButton;
}
