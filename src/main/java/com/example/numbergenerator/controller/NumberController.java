package com.example.numbergenerator.controller;

import com.example.numbergenerator.model.Status;
import com.example.numbergenerator.service.TaskService;
import com.example.numbergenerator.service.dto.Generator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController

public class NumberController {

    private final TaskService taskService;

    private static final String NUM_LIST_ACTION = "get_numlist";

    @PostMapping("/api/generate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody
    Map<String, UUID> generateNumber(@RequestBody Generator generator) {

        Map<String, UUID> result = new HashMap<>();

        UUID uuid = taskService.generate(generator);
        result.put("task", uuid);

        return result;
    }

    @PostMapping("/api/bulkGenerate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody
    Map<String, UUID> generateBulkNumber(@RequestBody List<Generator> generator) {

        Map<String, UUID> result = new HashMap<>();

        UUID uuid = taskService.bulkGenerate(generator);
        result.put("task", uuid);

        return result;
    }

    @GetMapping("/api/tasks/{id}/status")
    public @ResponseBody
    Map<String, Status> getStatus(@PathVariable("id") UUID uuid) {
        Map<String, Status> result = new HashMap<>();

        result.put("result", taskService.getTaskStatus(uuid));
        return result;
    }

    @GetMapping(value = "/api/tasks/{id}", params = "action")
    public @ResponseBody
    Map<String, List<String>> getSequences(@PathVariable("id") UUID uuid,
                                           @RequestParam("action") String action) {
        Map<String, List<String>> result = new HashMap<>();

        if (NUM_LIST_ACTION.equals(action)) {
            result.put("result", taskService.getGeneratedNumberSequences(uuid));
        }
        return result;
    }

    public NumberController(TaskService taskService) {
        this.taskService = taskService;
    }
    @RequestMapping("/")  
    public String title()   
    {  
    	return "Number Generator";  
    }  
}
