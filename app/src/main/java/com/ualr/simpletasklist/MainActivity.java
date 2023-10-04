package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.Task;
import com.ualr.simpletasklist.model.TaskList;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    // TODO 05. Add a TaskList member to the MainActivity. Initialize the new member.
    TaskList list = new TaskList();
        private void mapMethod() {
            HashMap<Integer, Task> tasks = list.getTasks();
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO 06.02 Bind the onAddBtnClicked method to the add button, so the onAddBtnClicked is
        // triggered whenever the user clicks on that button
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddBtnClicked();
            }
        });
        //TODO 07.02 Bind the onDeleteBtnClicked method to the delete button, so that method is
        // triggered whenever the user clicks on that button
        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { onDeleteBtnClicked(); }
        });
        //TODO 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { onDoneBtnClicked(); }
        });
    }


    // TODO 06. Create a new functionality to add a new task using the description provided
    //  through the text field on the top of the screen by tapping the "+" on the right

    // TODO 06.01. Create a new method called onAddBtnClicked.
    public void onAddBtnClicked() {
        // TODO 06.05. Invoke TaskList class' add method to ask the TaskList to
        //  add a new Task with the description provided through the text field.
        String taskDescription = binding.editTextTextPersonName.getText().toString();
        list.add(taskDescription);
        // TODO 06.06. Use TaskList class' toString method to get a string with the formatted task list
        //  and display it on screen in the TextView with the id "textView"
        binding.taskList.setText(list.toString());
    }
    // TODO 07. Create a new functionality to delete a task from the task list

    // TODO 07.01. Create a new method called onDeleteBtnClicked.
    public void onDeleteBtnClicked() {
        // TODO 07.04. Invoke TaskList class' delete method to ask the TaskList to
        //  delete a Task given the id provided through the text field on the bottom.
        String taskIdInput = binding.editTextTaskId.getText().toString();
        try {
            int taskId = Integer.parseInt(taskIdInput);
            list.delete(taskId);
            // TODO 07.05. Use TaskList class' toString method to get a string with the formatted task list
            //  and display it on screen in the TextView with the id "textView"
            binding.taskList.setText(list.toString());
        } catch (NumberFormatException exception) {
            Toast.makeText(this, "Invalid Task ID", Toast.LENGTH_SHORT).show();
        }
    }



    // TODO 08. Create a new functionality to mark a task as done.

    // TODO 08.01. Create a new method called onDoneBtnClicked
    public void onDoneBtnClicked() {
        // TODO 08.04. Invoke TaskList class' markDone method to ask the TaskList to
        //  mark a Task given the id provided through the text field on the bottom.
        String taskIdInput = binding.editTextTaskId.getText().toString();
        try {
            int taskId = Integer.parseInt(taskIdInput);
            list.markDone(taskId);
            // TODO 08.05. Use TaskList class' toString method to get a string with the formatted task list
            //  and display it on screen in the TextView with the id "textView"
            binding.taskList.setText(list.toString());
        } catch (NumberFormatException exception) {
            Toast.makeText(this, "Invalid Task ID", Toast.LENGTH_SHORT).show();
        }
    }
}