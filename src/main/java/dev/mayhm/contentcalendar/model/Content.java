package dev.mayhm.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
//@Table specify table name
public class Content {

    @Id
    Integer id;
    @NotBlank
    String title;

    @Column("description")
    String desc;
    Status status;
    Type contentType;
    LocalDateTime dateCreated;
    LocalDateTime dateUpdated;
    String url;

//    public Integer getId(){
//        return id;
//    }
}
