package document;

import java.util.List;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElementVisitor;


/**
 * Hello.
 * */
public class MarkdownStringVisitor implements TextElementVisitor<String> {
  @Override
  public  String visitBasicText(BasicText current) {
    return current.getText().trim() + "\n";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return "**" + current.getText().trim() + "**\n";
  }

  @Override
  public String visitHeading(Heading current) {
    StringBuilder s = new StringBuilder();
    switch (current.getLevel()) {
      case 1: s.append("# ");
      break;
      case 2: s.append("## ");
      break;
      case 3: s.append("### ");
      break;
      default: s.append(" ");
    }
    return s.append(current.getText().trim()).append("\n").toString();
  }

  @Override
  public String visitHyperText(HyperText current) {
    return "[" + current.getText().trim() + "](" + current.getUrl().trim() + ")\n";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return "*" + current.getText().trim() + "*\n";
  }

  @Override
  public String visitParagraph(Paragraph current) {

    StringBuilder s = new StringBuilder();
    s.append("\n");
    List<BasicText> list = current.getContent();
    for (BasicText b : list ) {
      s.append(b.accept(this));
    }
    s.append("\n");
    return s.toString();

  }
}
