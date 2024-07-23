package com.example.testinterview.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
}
