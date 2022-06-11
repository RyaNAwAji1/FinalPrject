package com.example.demo.Repository;

import com.example.demo.Model.ServiceEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository <ServiceEvaluation,Integer> {
}
