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

public class UCS extends Search {
  public UCS() {
    numOfVisited = 0;
  }

  public List<String> solveWordLadder(String base, String target) {
    HashSet<String> dictionary = Node.dictionary;
    PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
    HashSet<String> vis = new HashSet<>();

    pq.add(new Node(base, 0, null, 0));
    vis.add(base);

    while (!pq.isEmpty()) {
      Node currNode = pq.poll();
      String currWord = currNode.getWord();

      numOfVisited++;

      if (currWord.equals(target)) {
        return currNode.getPaths();
      }

      for (int i = 0; i < currWord.length(); i++) {
        for (int j = 0; j < 26; j++) {
          StringBuilder temp = new StringBuilder(currWord);
          temp.setCharAt(i, (char) ('a' + j));
          String check = new String(temp);

          if (dictionary.contains(check) && !vis.contains(check)) {
            pq.add(new Node(check, currNode.getCost() + 1, currNode, currNode.getLevel() + 1));
            vis.add(check);
          }
        }
      }
    }

    return new ArrayList<>();
  }
}
