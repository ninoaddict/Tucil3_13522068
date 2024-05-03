package word_ladder;

public class WordLadder {
  public static void main(String args[]) {
    try {
      Node.initNode();
      MainInterface ui = new MainInterface();
      ui.setVisible(true);

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
