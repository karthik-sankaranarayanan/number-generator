package com.example.numbergenerator.service;

import com.example.numbergenerator.model.Status;
import com.example.numbergenerator.model.Task;
import com.example.numbergenerator.service.dto.Generator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class AsyncServiceImpl implements AsyncService {
    private final Random random = new Random();

    @Async
    public void createSequenceNumber(List<Generator> generators, Task task) {
        List<String> sequences = new ArrayList<>();

        try {
            for (Generator generator : generators) {
                sequences.add(createSequenceNumber(generator));
            }
            task.setNumberSequences(sequences);
            task.setStatus(Status.SUCCESS);

        } catch (InterruptedException | IllegalArgumentException e) {
            task.setStatus(Status.ERROR);
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private String createSequenceNumber(Generator generator) throws InterruptedException {

        if (generator.getStep() <= 0) {
            throw new IllegalArgumentException("Step must be a positive number");
        }

        StringBuilder serial = new StringBuilder();
        var goal = generator.getGoal();
        var step = generator.getStep();

        while (goal >= 0) {
            serial.append(goal);
            goal -= step;

            if (goal >= 0) {
                serial.append(",");
            }
            Thread.sleep(generateSecBetween(10, 30) * 1000L);
        }
        return serial.toString();
    }

    private int generateSecBetween(int low, int high) {
        return random.nextInt(high - low) + low;
    }
}
