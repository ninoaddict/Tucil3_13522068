package word_ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStar extends Search {
  public AStar() {
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
    PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
    HashSet<String> visited = new HashSet<>();
    pq.add(new Node(base, calculateScore(base, target), null, 0));

    while (!pq.isEmpty()) {
      Node currNode = pq.poll();
      String currWord = currNode.getWord();

      numOfVisited++;

      if (visited.contains(currWord)) {
        continue;
      }

      visited.add(currWord);

      if (currWord.equals(target)) {
        return currNode.getPaths();
      }

      for (int i = 0; i < currWord.length(); i++) {
        for (int j = 0; j < 26; j++) {
          StringBuilder temp = new StringBuilder(currWord);
          temp.setCharAt(i, (char) ('a' + j));
          String check = new String(temp);
          if (dictionary.contains(check) && !visited.contains(check)) {
            pq.add(new Node(check, calculateScore(check, target) + currNode.getLevel() + 1, currNode,
                currNode.getLevel() + 1));
          }
        }
      }
    }

    return new ArrayList<>();
  }
}
