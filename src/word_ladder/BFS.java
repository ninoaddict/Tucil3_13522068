/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package word_ladder;

/**
 *
 * @author adril
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class BFS extends Search {
  public BFS() {
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
    HashSet<String> vis = new HashSet<>();

    pq.add(new Node(base, calculateScore(base, target), null, 0));
    vis.add(base);

    while (!pq.isEmpty()) {
      numOfVisited++;
      Node currNode = pq.poll();
      String currWord = currNode.getWord();

      if (currWord.equals(target)) {
        return currNode.getPaths();
      }

      for (int i = 0; i < currWord.length(); i++) {
        for (int j = 0; j < 26; j++) {
          StringBuilder temp = new StringBuilder(currWord);
          temp.setCharAt(i, (char) ('a' + j));
          String check = new String(temp);

          if (dictionary.contains(check) && !vis.contains(check)) {
            pq.add(new Node(check, calculateScore(check, target), currNode, currNode.getLevel() + 1));
            vis.add(check);
          }
        }
      }
    }

    return new ArrayList<>();
  }
}