package word_ladder;

import javax.swing.*;
import java.awt.*;

public class BoxInterface extends JPanel {
  public BoxInterface(char a, boolean check) {
    initComponents(String.valueOf(a), check);
  }

  private void initComponents(String a, boolean check) {
    this.setPreferredSize(new Dimension(40, 40));
    if (check) {
      this.setBackground(new Color(51, 150, 0));
    } else {
      this.setBackground(new Color(70, 70, 70));
    }

    character = new JLabel();
    character.setFont(new java.awt.Font("SansSerif", 1, 24));
    character.setBackground(new java.awt.Color(20, 20, 20));
    character.setForeground(new java.awt.Color(204, 204, 204));
    character.setAlignmentX(CENTER_ALIGNMENT);
    character.setAlignmentY(CENTER_ALIGNMENT);
    character.setText(a.toUpperCase());
    this.add(character);
  }

  private JLabel character;
}
