package com.stackroute.trackservice.domain;

import lombok.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="track")
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
