package word_ladder;

/**
 *
 * @author adril
 */

import javax.swing.*;
import java.awt.*;

public class ListBoxInterface extends JPanel {
  public ListBoxInterface(String base, String target) {
    initComponents(base, target);
  }

  private void initComponents(String base, String target) {
    this.setLayout(new GridBagLayout());
    this.setBackground(new Color(0, 51, 51));
    GridBagConstraints c = new GridBagConstraints();
    c.gridy = 0;
    c.insets = new Insets(0, 3, 0, 3);

    for (int i = 0; i < base.length(); i++) {
      c.gridx = i + 0;
      if (base.charAt(i) == target.charAt(i)) {
        this.add(new BoxInterface(base.charAt(i), true), c);
      }
      else {
        this.add(new BoxInterface(base.charAt(i), false), c);
      }
    }
  }
}
