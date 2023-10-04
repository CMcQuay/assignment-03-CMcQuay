package com.ualr.simpletasklist.model;

public class Task {

    // TODO 01. Define two attributes for the Task class: one to store the task description and a second one that
    //  indicates whether the task is done or not


    private String taskDescription;
    private boolean isTaskDone;

    // TODO 02. Define the class constructor and the corresponding getters and setters.
    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isTaskDone = false;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDone(boolean isTaskDone) {
        this.isTaskDone = isTaskDone;
    }

    public boolean getTaskDone() {
        return this.isTaskDone;
    }
}
