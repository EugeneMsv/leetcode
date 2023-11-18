package heap.n621TaskScheduler;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

  public int leastInterval(char[] names, int n) {
    Map<Character, Task> tasks = new HashMap<>(26);
    for (char name : names) {
      Task task = tasks.get(name);
      if (task == null) {
        task = new Task(name);
        tasks.put(name, task);
      }
      task.count++;
    }

    PriorityQueue<Task> executionQueue = new PriorityQueue<>(26,
        Comparator.comparing(Task::getCount).reversed());
    PriorityQueue<Task> coolDownQueue = new PriorityQueue<>(26,
        Comparator.comparing(Task::getCoolDown));
    PriorityQueue<Task> coolDownBackupQueue = new PriorityQueue<>(26,
        Comparator.comparing(Task::getCoolDown));

    for (Task task : tasks.values()) {
      executionQueue.offer(task);
    }

    // Result calculation
    int cycles = 0;

    while (!executionQueue.isEmpty() || !coolDownQueue.isEmpty()) {
      cycles++;
      if (!coolDownQueue.isEmpty()) {
        // Calc new coolDowns
        for (Task waitingTask : coolDownQueue) {
          waitingTask.coolDown--;
          coolDownBackupQueue.offer(waitingTask);
        }
        coolDownQueue.clear();
        PriorityQueue<Task> temp = coolDownQueue;
        coolDownQueue = coolDownBackupQueue;
        coolDownBackupQueue = temp;

        // Check if there is a task with 0 coolDown, put it back to execution
        Task executionCandidate = coolDownQueue.peek();
        if (executionCandidate.coolDown == 0) {
          coolDownQueue.poll();
          executionQueue.offer(executionCandidate);
        }
      }

      if (!executionQueue.isEmpty()) {
        Task executingTask = executionQueue.poll();
        executingTask.count--;
        if (executingTask.count > 0) {
          executingTask.coolDown = n + 1;
          coolDownQueue.offer(executingTask);
        }
      }
    }

    return cycles;

  }

  private static class Task {

    char name;
    int count;
    int coolDown;

    Task(char name) {
      this.name = name;
    }

    int getCount() {
      return this.count;
    }

    int getCoolDown() {
      return this.coolDown;
    }

    public int hashCode() {
      return Objects.hash(name);
    }

    public boolean equals(Object input) {
      if (!(input instanceof Task)) {
        return false;
      }
      return this.name == ((Task) input).name;
    }

    public String toString() {
      return "Task '" + name + "': count=" + count + ", coolDown=" + coolDown;
    }
  }
}
