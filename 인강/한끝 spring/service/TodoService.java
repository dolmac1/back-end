package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
//- todo 리스트 목록에 아이템 추가(post / 메소드를 통해 추가)
//- todo 리스트 목록 중 특정 아이템을 조회 (get /{id} 를 통해 조회)
//- todo 리스트 전체 목록을 조회(get / 메소드를 통해서 조회)
//- todo 리스트 목록 중 특정 아이템을 수정(patch /{id}를 통해 수정)
//- todo 리스트 목록 중 특정 아이템을 삭제(delete /{id}를 통해 삭제)
//- todo 리스트 전체 목록 삭제(delete / 를 통해 삭제)

    private TodoEntity add(TodoRequest request){
        TodoEntity todoEntity = new TodoEntity();

        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoEntity);

    }

    private TodoEntity searchById(Long id){
        return this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private List<TodoEntity> searchAll(){
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        if(todoEntity.getTitle() == null){
            todoEntity.setTitle(request.getTitle());
        }
        if(todoEntity.getOrder() == null){
            todoEntity.setOrder(request.getOrder());
        }
        if(todoEntity.getCompleted() == null){
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
