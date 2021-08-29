package dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
@Setter
@Getter
@ToString //System.out.println에 해당 클래스의 인스턴스를 넣으면 string 형식으로 보여줌
@NoArgsConstructor //argument 가 없는 생성자 생성
@AllArgsConstructor // 모든 argument가 들어간 생성자 생성
//@RequiredArgsConstructor // 일부 argument 가 들어간 생성자 생성
@Builder // builder 사용 가능
//@Data //이거 하나면 위의 6줄 다 필요없음, 양날의 검이라 실제에서는 잘 안씀
@Slf4j
public class DevDto {
    private String name;
    private Integer age;
    private LocalDateTime startAt;

    public void printLog(){
        log.info(getName());
    }
//롬복으로 setter getter를 대체함
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDateTime getStartAt() {
//        return startAt;
//    }
//
//    public void setStartAt(LocalDateTime startAt) {
//        this.startAt = startAt;
//    }
}
