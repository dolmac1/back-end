//인터페이스임
package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //repository 임을 표시
public interface TodoRepository extends JpaRepository<TodoEntity, Long> { // 모델과 id의생성자를 적음


}
