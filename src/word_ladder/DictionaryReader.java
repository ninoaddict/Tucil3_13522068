/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package word_ladder;

/**
 *
 * @author adril
 */
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
