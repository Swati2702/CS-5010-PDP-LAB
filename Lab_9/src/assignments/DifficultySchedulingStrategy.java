package assignments;

import java.util.Comparator;
import java.util.List;

public class DifficultySchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> assignmentList) {
    if(assignmentList == null){
      throw  new IllegalArgumentException("invalid");
    }
    assignmentList.sort(Comparator.comparing(Assignment::getDifficulty));
    return "difficulty";
  }
}
