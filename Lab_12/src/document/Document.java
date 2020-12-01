package document;

import document.element.TextElementVisitor;
import java.util.ArrayList;
import java.util.List;

import document.element.TextElement;

/**
 * Hello.
 * */
public class Document {
  
  private List<TextElement> content;

  /**
   * Hello.
   * */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Hello.
   * */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * Hello.
   * */
  public int countWords() {
    int count = 0;
    TextElementVisitor<Integer> wordCountVisitor = new WordCountVisitor();
    for (TextElement textElement : content) {
      count += textElement.accept(wordCountVisitor);
    }
    return count;
  }

  /**
   * Hello.
   * */
  public <R> String toText(TextElementVisitor<R> visitor) {
    StringBuilder stb = new StringBuilder();
    for (TextElement textElement : content) {
      stb.append(textElement.accept(visitor));
    }
    return stb.toString().trim();
  }
}
