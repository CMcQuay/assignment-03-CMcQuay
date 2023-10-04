package com.ualr.simpletasklist.model;

import java.util.HashMap;

public class TaskList {

    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.
    private HashMap<Integer, Task> tasks;
    public TaskList() {
        tasks = new HashMap<>();
    }
    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object
    //public static HashMap<Integer, Task> taskList = new HashMap<Integer, Task>();
    // TODO 04. Define the class constructor and the corresponding getters and setters.
    public void setTasks(HashMap<Integer, Task> tasks) {

        this.tasks = tasks;
    }

    public HashMap<Integer, Task> getTasks() {

        return this.tasks;
    }
    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.
    public void add(String taskDescription) {
        Task newTask = new Task(taskDescription);
        int taskId = tasks.size();
        tasks.put(taskId, newTask);
    }
    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer taskId : tasks.keySet()) {
            Task task = tasks.get(taskId);
            stringBuilder.append(taskId).append(" - ").append(task.getTaskDescription());
            if (task.getTaskDone()) {
                stringBuilder.append(" - Done");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.
    public void delete(int taskId) {
        tasks.remove(taskId);
    }
    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.
    public void markDone(int taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setTaskDone(true);
        }
    }
}
