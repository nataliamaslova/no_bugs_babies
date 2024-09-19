package org.example.tasklist;

import java.util.ArrayList;
import java.util.Collections;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void sortTasksByPriority(ArrayList<Task> tasks) {
        Collections.sort(tasks);
    }

}
