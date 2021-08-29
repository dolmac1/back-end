package dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DevDtoTest {
    @Test
    void test(){
        DevDto devdto = new DevDto();

        devdto.setName("dolmac");
        devdto.setAge(27);
        devdto.setStartAt(LocalDateTime.now());
        System.out.println("name : "+devdto.getName()+", age : "+devdto.getAge()+", startAT : "+devdto.getStartAt());
        System.out.println(devdto);
        DevDto devdto2 = DevDto.builder()
                .name("chovy")
                .age(27)
                .startAt(LocalDateTime.now())
                .build(); // builder 를 include 함으로써 사용 가능한 문법
        System.out.println(devdto2);
        devdto.printLog();
    }
}