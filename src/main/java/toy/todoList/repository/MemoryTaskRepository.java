package toy.todoList.repository;

import org.springframework.stereotype.Repository;
import toy.todoList.domain.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryTaskRepository implements TaskRepository {

    private Map<Long, Task> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Task save(Task task) {
        task.setId(++sequence);
        store.put(sequence, task);
        return task;
    }

    @Override
    public Task findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void remove(Long id) {
        store.remove(id);
    }

    @Override
    public void update(Long id, Task updateTask) {
        Task task = store.get(id);
        task.setTitle(updateTask.getTitle());
        task.setCompleted(updateTask.isCompleted());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
