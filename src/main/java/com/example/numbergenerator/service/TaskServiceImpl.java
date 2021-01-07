package com.example.numbergenerator.service;

import com.example.numbergenerator.model.Status;
import com.example.numbergenerator.model.Task;
import com.example.numbergenerator.service.dto.Generator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    public static final Map<UUID, Task> taskMap = new HashMap<>();

    private final AsyncService asyncService;

    @Override
    public UUID generate(Generator generator) {
        UUID uuid = UUID.randomUUID();

        Task t = createTask(uuid);

        asyncService.createSequenceNumber(List.of(generator), t);

        return uuid;
    }

    @Override
    public UUID bulkGenerate(List<Generator> generators) {
        UUID uuid = UUID.randomUUID();
        Task t = createTask(uuid);

        asyncService.createSequenceNumber(generators, t);

        return uuid;
    }

    @Override
    public Status getTaskStatus(UUID taskId) {
        Task t = taskMap.get(taskId);

        return t != null ? t.getStatus() : null;
    }

    @Override
    public List<String> getGeneratedNumberSequences(UUID taskId) {
        Task t = taskMap.get(taskId);

        return t != null ? t.getNumberSequences() : null;
    }

    private Task createTask(UUID uuid) {
        Task t = new Task();
        taskMap.put(uuid, t);
        return t;
    }

    public TaskServiceImpl(AsyncService asyncService) {
        this.asyncService = asyncService;
    }
}
