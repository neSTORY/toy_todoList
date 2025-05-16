package toy.todoList.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.todoList.domain.Task;
import toy.todoList.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * findAll
     * findById
     * save
     * delete
     * update
     */

    public Task save(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void remove(Long id) {
        taskRepository.remove(id);
    }

    public void update(Long id, Task updateTask) {
        taskRepository.update(id, updateTask);
    }
}
