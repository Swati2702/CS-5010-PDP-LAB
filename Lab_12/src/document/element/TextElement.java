package document.element;

/**
 * Interface that represents an element in our document.
 */
public interface TextElement {

  /**
   * Returns the text contained within the element.
   * 
   * @return the text
   */
  public String getText();

  /**
   * Making the elements of the document "visitable" by adding the following method
   * to the TextElement interface, and implementing it in the implementing.
   * */
  public <R> R accept(TextElementVisitor<R> visitor);
}
