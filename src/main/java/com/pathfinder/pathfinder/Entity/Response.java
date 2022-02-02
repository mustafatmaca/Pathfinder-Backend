package com.pathfinder.pathfinder.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<E> {
    boolean success;
    String message;
    E result;
}
