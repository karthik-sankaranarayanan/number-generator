package com.example.numbergenerator.service.mapper;

import com.example.numbergenerator.model.Task;
import com.example.numbergenerator.service.dto.Generator;

public class TaskMapper {

    public static Task toModel(Generator dto){
        return new Task();
    }
}
