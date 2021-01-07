package com.example.numbergenerator.service;

import com.example.numbergenerator.model.Task;
import com.example.numbergenerator.service.dto.Generator;

import java.util.List;

public interface AsyncService {
    void createSequenceNumber(List<Generator> generators, Task tasks);
}
