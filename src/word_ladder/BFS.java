package word_ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(base, calculateScore(base, target), null, 0));


    while (!queue.isEmpty()) {
      numOfVisited++;

      Node currNode = queue.poll();
      String currWord = currNode.getWord();

      // TODO: delete after debug done
      // System.out.println("Current Word: " + currWord);
      // List<String> currPath = currNode.getPaths();
      // for (int i = 0; i < currPath.size(); i++) {
      //   System.out.println(currPath.get(i));
      // }
      
      if (currWord.equals(target)) {
        return currNode.getPaths();
      }

      int minScore = 100;
      String minWord = null;

      for (int i = 0; i < currWord.length(); i++) {
        for (int j = 0; j < 26; j++) {
          StringBuilder temp = new StringBuilder(currWord);
          temp.setCharAt(i, (char) ('a' + j));
          String check = new String(temp);

          int tempScore = calculateScore(check, target);

          if (dictionary.contains(check) && !currNode.visited(check) && tempScore < minScore) {
            minScore = tempScore;
            minWord = check;
          }
        }
      }

      if (minWord != null) {
        queue.add(new Node(minWord, minScore, currNode, currNode.getLevel() + 1));
      }
    }
    // PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
    // HashSet<String> vis = new HashSet<>();

    // pq.add(new Node(base, calculateScore(base, target), null, 0));
    // vis.add(base);

    // while (!pq.isEmpty()) {
    // numOfVisited++;
    // Node currNode = pq.poll();
    // String currWord = currNode.getWord();

    // if (currWord.equals(target)) {
    // return currNode.getPaths();
    // }

    // for (int i = 0; i < currWord.length(); i++) {
    // for (int j = 0; j < 26; j++) {
    // StringBuilder temp = new StringBuilder(currWord);
    // temp.setCharAt(i, (char) ('a' + j));
    // String check = new String(temp);

    // if (dictionary.contains(check) && !vis.contains(check)) {
    // pq.add(new Node(check, calculateScore(check, target), currNode,
    // currNode.getLevel() + 1));
    // vis.add(check);
    // }
    // }
    // }
    // }

    return new ArrayList<>();
  }
}