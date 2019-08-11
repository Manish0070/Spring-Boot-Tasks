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
//User Track Class
public class Track {
    @Id
    //Properties
    private int id;
    private String name;
    private String comments;


}
