/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package word_ladder;

/**
 *
 * @author adril
 */

public class WordLadder {
  public static void main(String[] args) {
    try {
      Node.initNode();
      UserInterface ui = new UserInterface();
      ui.setVisible(true);

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
