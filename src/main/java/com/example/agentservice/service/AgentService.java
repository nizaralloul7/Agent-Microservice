package com.example.agentservice.service;



import com.example.agentservice.dto.Client;
import com.example.agentservice.entity.Agent;
import com.example.agentservice.repository.AgentRepository;
import com.example.agentservice.security.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService
{
    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }


    public void addAgent(Agent agent, String loginLink)
    {
        String pass = PasswordGenerator.alphaNumericString();
        System.out.println(pass);
        //Send Password to agent by email
        this.agentRepository.save(agent);
    }

    public void updateAgentPlafond(String refAgent, double nouveauPlafond)
    {
        Agent agent = agentRepository.findAgentByCin(refAgent);
        agent.setPlafond(nouveauPlafond);

        agentRepository.save(agent);
    }
}
