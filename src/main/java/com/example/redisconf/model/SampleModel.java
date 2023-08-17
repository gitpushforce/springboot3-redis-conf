package com.example.redisconf.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
// serializable is important,
// if Serializable is not used; when checking the "key" it will always be recognized as null
public class SampleModel implements Serializable {
    private String fieldValue;
}
