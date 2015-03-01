package com.sjune.examples.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    private int age;
    private String name;
    private Sex sex;

    public enum Sex {
        W, M
    }
}
