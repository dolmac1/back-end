package com.dolmac.programming.dmaker.entity;

import com.dolmac.programming.dmaker.type.DeveloperLevel;
import com.dolmac.programming.dmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)//createddate, lastmodifiedDate 사용을 위함
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    private Integer experienceYear;
    private String memberId;
    private String name;
    private Integer age;

    @CreatedDate //생성시점
    private LocalDateTime createdAt;

    @LastModifiedDate //최종 변경일시
    private LocalDateTime updatedAt;
}
