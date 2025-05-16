package toy.todoList.repository;

import toy.todoList.domain.Task;

import java.util.List;

public interface TaskRepository {

    Task save(Task task);

    Task findById(Long id);

    List<Task> findAll();

    void remove(Long id);

    void update(Long id, Task updateTask);

    void clear();

}
