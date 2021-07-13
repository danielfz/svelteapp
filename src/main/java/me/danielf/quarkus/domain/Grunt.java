package me.danielf.quarkus.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grunt {
    private Long id;
    private String author;
    private String noise;

    public Grunt(String author,String noise) {
        this.author = author;
        this.noise = noise;
    }
}
