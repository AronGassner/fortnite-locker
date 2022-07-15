package ch.clip.samples.authapi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController für
 * @author luigicavuoti
 * @date 10.07.2020
 *
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();  //taskRepository.findAll();
    }

    /**
     * adds a new task to the list - or db
     * @param task
     */
    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }



    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id).get();
        Assert.notNull(existingTask, "Task not found");
        existingTask.setDescription(task.getDescription());
        taskRepository.save(existingTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        Task taskToDel = taskRepository.findById(id).get();
        taskRepository.delete(taskToDel);
    }
}
