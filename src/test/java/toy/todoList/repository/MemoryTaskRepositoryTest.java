package toy.todoList.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import toy.todoList.domain.Task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryTaskRepositoryTest {

    MemoryTaskRepository repository = new MemoryTaskRepository();

    @BeforeEach
    public void beforeEach() {
        repository.clear();
    }

    @Test
    void save() {
        //given
        Task task1 = new Task("할 일1", false);
        Task task2 = new Task("할 일2", false);

        //when
        repository.save(task1);
        repository.save(task2);

        //then
        assertThat(repository.findAll().size()).isEqualTo(2);
    }

    @Test
    void findById() {
        //given
        Task task1 = new Task("할 일1", false);
        Task task2 = new Task("할 일2", false);

        repository.save(task1);
        repository.save(task2);

        //when
        Long task1Id = task1.getId();
        Task findTask = repository.findById(task1Id);

        //then
        assertThat(findTask).isEqualTo(task1);
    }

    @Test
    void update() {
        //given
        Task task1 = new Task("할 일1", false);
        Task updateTask = new Task("할 일1", true);

        repository.save(task1);

        //when
        Long id = task1.getId();
        repository.update(id, updateTask);

        //then
        Task findTask = repository.findById(id);
        assertThat(findTask.isCompleted()).isTrue();
    }


}