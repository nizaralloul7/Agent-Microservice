package com.example.agentservice.controller;


import com.example.agentservice.dto.Client;
import com.example.agentservice.entity.Agent;
import com.example.agentservice.repository.AgentRepository;
import com.example.agentservice.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/api/agent")
public class AgentController
{
    private final AgentService agentService;
    private final RestTemplate restTemplate;
    private final AgentRepository agentRepository;

    @Autowired
    public AgentController(AgentService agentService, AgentRepository agentRepository, RestTemplate restTemplate)
    {
        this.agentService = agentService;
        this.agentRepository = agentRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Agent> getAgents()
    {
        return agentService.getAgents();
    }

    @PostMapping(value = "/add-agent")
    public void addAgent(@RequestBody Agent agent)
    {
        agentRepository.save(agent);
    }

    @PostMapping(value = "/add-client")
    public void addClient(@RequestBody Client client)
    {
        restTemplate.postForObject("http://client-service/add-client",client,Client.class);
        System.out.println("client added successfully");
    }
    @GetMapping("/ref/{refAgent}")
    public Agent getAgentByCin(@PathVariable String refAgent)
    {
        return agentRepository.findAgentByCin(refAgent);
    }

    @PostMapping("/{refAgent}")
    public void updateAgentPlafond(@PathVariable String refAgent, @RequestBody double nouveauPlafond)
    {
        agentService.updateAgentPlafond(refAgent, nouveauPlafond);
    }

}