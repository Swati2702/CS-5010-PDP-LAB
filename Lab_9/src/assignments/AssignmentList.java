package assignments;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of task that need to be completed.
 */
public class AssignmentList {

  private List<Assignment> tasks = new ArrayList<>();
  private String ordering;

  /** Default constructor. */
  public AssignmentList() {
    tasks = new ArrayList<>();
    ordering = "assigned";
  }

  /**
   * Add a task to the task list.
   * 
   * @param t the task
   */
  public void add(Assignment t) {
    tasks.add(t);
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer("Ordered by ");
    sb.append(ordering);
    sb.append("\n");
    for (int i = 0 ; i < tasks.size() ; i++) {
      sb.append(i + 1);
      sb.append(" -- ");
      sb.append(tasks.get(i));
      sb.append("\n");
    }
    return sb.toString();
  }

  public void scheduleAssignments(SchedulingStrategy schedulingStrategy){
    if (schedulingStrategy == null){
      throw new IllegalArgumentException("Invalid");
    }

    this.ordering = schedulingStrategy.schedule(this.tasks);

  }
}
