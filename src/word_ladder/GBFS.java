package word_ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GBFS extends Search {
  public GBFS() {
    numOfVisited = 0;
  }

  public static int calculateScore(String base, String target) {
    int simm = 0;

    for (int i = 0; i < base.length(); i++) {
      if (base.charAt(i) != target.charAt(i)) {
        simm++;
      }
    }
    return simm;
  }

  public List<String> solveWordLadder(String base, String target) {
    HashSet<String> dictionary = Node.dictionary;
    HashSet<String> visited = new HashSet<>();
    List<String> res = new ArrayList<>();
    String currNode = base;

    while (true) {
      res.add(currNode);
      visited.add(currNode);

      numOfVisited++;

      if (currNode.equals(target)) {
        return res;
      }

      int minScore = 100;
      String minWord = null;

      for (int i = 0; i < currNode.length(); i++) {
        for (int j = 0; j < 26; j++) {
          StringBuilder temp = new StringBuilder(currNode);
          temp.setCharAt(i, (char) ('a' + j));
          String check = temp.toString();
          int tempScore = calculateScore(check, target);

          if (dictionary.contains(check) && !visited.contains(check) && tempScore < minScore) {
            minScore = tempScore;
            minWord = check;
          }
        }
      }

      if (minWord == null) {
        break;
      }
      currNode = minWord;
    }
    return new ArrayList<>();
  }
}