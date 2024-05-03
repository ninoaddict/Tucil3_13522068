package word_ladder;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
  public int compare(Node node1, Node node2) {
    if (node1.getCost() < node2.getCost()) {
      return -1;
    } else if (node1.getCost() > node2.getCost()) {
      return 1;
    } else {
      return 0;
    }
  }
}
