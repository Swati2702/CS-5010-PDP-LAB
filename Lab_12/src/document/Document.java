package document;

import document.element.TextElementVisitor;
import java.util.ArrayList;
import java.util.List;

import document.element.TextElement;

public class Document {
  
  private List<TextElement> content;
  
  public Document() {
    content = new ArrayList<>();
  }

  public void add(TextElement e) {
    content.add(e);
  }

  public int countWords() {
    int count = 0;
    TextElementVisitor<Integer> wordCountVisitor = new WordCountVisitor();
    for (TextElement textElement : content) {
      count += textElement.accept(wordCountVisitor);
    }
    return count;
  }

  public <R> String toText(TextElementVisitor<R> visitor) {
    StringBuilder stb = new StringBuilder();
    for (TextElement textElement : content) {
      stb.append(textElement.accept(visitor));
    }
    return stb.toString();
  }
}
