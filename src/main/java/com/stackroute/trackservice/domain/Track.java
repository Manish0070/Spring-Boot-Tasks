package com.stackroute.trackservice.domain;

import lombok.*;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Track {
    @Id
    private int id;
    private String name;
    private String comments;


}
