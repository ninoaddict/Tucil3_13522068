package word_ladder;

/**
 *
 * @author adril
 */

import javax.swing.*;
import java.awt.*;

public class BoxInterface extends JPanel {
  public BoxInterface(char a, boolean check) {
    initComponents(String.valueOf(a), check);
  }

  private void initComponents(String a, boolean check) {
    this.setPreferredSize(new Dimension(50, 50));
    if (check) {
      this.setBackground(new Color(51, 150, 0));
    } else {
      this.setBackground(new Color(20, 20, 20));
    }

    character = new JLabel();
    character.setFont(new java.awt.Font("SansSerif", 1, 30));
    character.setBackground(new java.awt.Color(20, 20, 20));
    character.setForeground(new java.awt.Color(240, 240, 240));
    character.setAlignmentX(CENTER_ALIGNMENT);
    character.setAlignmentY(CENTER_ALIGNMENT);
    character.setText(a.toUpperCase());
    this.add(character);
  }

  private JLabel character;
}
