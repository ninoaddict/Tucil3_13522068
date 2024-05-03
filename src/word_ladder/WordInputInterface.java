package word_ladder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class WordInputInterface extends JPanel {
  public WordInputInterface() {
    initComponents();
  }

  public String getText() {
    StringBuilder res = new StringBuilder(arr.size());

    for (Character ch: arr) {
      res.append(ch);
    }

    return res.toString();
  }

  private void initComponents() {
    this.setSize(600, 40);
    this.setBackground(new Color(20, 20, 20));

    gc = new GridBagConstraints();
    arr = new ArrayList<>();

    gc.gridx = 0;
    gc.gridy = 0;
    gc.insets = new Insets(2, 2, 2, 2);

    this.add(new BoxInterface(' ', false), gc);

    this.setLayout(new GridBagLayout());
    this.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() >= 65 && e.getKeyCode() <= 90) {
          if (arr.isEmpty()) {
            remove(0);
          }

          add(new BoxInterface((char)(e.getKeyCode()), false), gc);
          arr.add((char)e.getKeyCode());
          revalidate();
          repaint();

          gc.gridx++;
        }
        if (e.getKeyCode() == 8) {
          if (arr.isEmpty()) {
            return;
          }
          
          remove(arr.size() - 1);
          arr.remove(arr.size() - 1);
          gc.gridx--;

          if (arr.isEmpty()) {
            add(new BoxInterface(' ', false), gc);
          }

          revalidate();
          repaint();
        }
      }
    });
  }
  ArrayList<Character> arr;
  private GridBagConstraints gc;
}
