package word_ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;

public class DictionaryReader {
  public static HashSet<String> ReadDictionary() throws IOException {
    HashSet<String> set = new HashSet<>();

    final String fileName = "src/word_ladder/dictionary.txt";
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    String word;

    while ((word = reader.readLine()) != null) {
      set.add(word);
    }

    reader.close();

    return set;
  }
}
