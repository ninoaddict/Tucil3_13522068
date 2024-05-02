package word_ladder;

import java.util.List;

public abstract class Search {
  protected int numOfVisited;

  public void reset() {
    numOfVisited = 0;
  }

  public int getNumOfVisited() {
    return numOfVisited;
  }

  public abstract List<String> solveWordLadder(String base, String target);
}
