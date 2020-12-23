import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.SchedulingStrategy;

public class AssignmentTest {

  AlphabeticalSchedulingStrategy strategy;

  @Test
  public void test() {
    Assignment assignment = new Assignment("abc");
    List<Assignment> assignmentList = new ArrayList<>();
    assignmentList.add(assignment);
    strategy = new AlphabeticalSchedulingStrategy();
    strategy.schedule(assignmentList);
  }
}
