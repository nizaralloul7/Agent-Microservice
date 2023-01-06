package com.example.agentservice.repository;

import com.example.agentservice.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long>
{
    /*@Modifying
    @Query(value="UPDATE agent SET password = :newPassword, is_password_changed = :isPasswordChanged WHERE id = :agentId", nativeQuery = true)
    @Transactional
    void changePasswordInFirstLogin(@Param("newPassword") String newPassword, @Param("isPasswordChanged") boolean isPasswordChanged, @Param("agentId") Long agentId);

     */
    Agent findAgentByCin(String cin);

}
