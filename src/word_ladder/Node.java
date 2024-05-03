package word_ladder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Node {
  protected String word;
  protected int cost;
  private Node before;
  private int level;

  public static HashSet<String> dictionary;

  public static void initNode() {
    try {
      dictionary = DictionaryReader.ReadDictionary();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean checkDictionary(String word) {
    return dictionary.contains(word);
  }

  /* CONSTRUCTOR */
  Node(String word, int cost, Node before, int level) {
    this.word = word;
    this.cost = cost;
    this.before = before;
    this.level = level;
  }

  /* SELEKTOR */
  public String getWord() {
    return word;
  }

  public Integer getCost() {
    return cost;
  }

  public Integer getLevel() {
    return level;
  }

  public List<String> getPaths() {
    List<String> res = new ArrayList<>();

    Node curr = this;
    while (curr != null) {
      res.add(curr.getWord());
      curr = curr.before;
    }

    Collections.reverse(res);
    return res;
  }

  public boolean visited(String word) {
    Node curr = this;
    while (curr != null) {
      if (curr.getWord().equals(word)) {
        return true;
      }
      curr = curr.before;
    }
    return false;
  }
}
