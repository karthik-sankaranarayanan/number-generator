package com.example.numbergenerator.service;

import com.example.numbergenerator.model.Status;
import com.example.numbergenerator.service.dto.Generator;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    UUID generate(Generator task);
    UUID bulkGenerate(List<Generator> tasks);
    Status getTaskStatus(UUID taskId);
    List<String> getGeneratedNumberSequences(UUID taskId);
}
