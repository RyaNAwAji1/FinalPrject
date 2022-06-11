package com.example.demo.Repository;

import com.example.demo.Model.Troubles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TroublesRepository extends JpaRepository <Troubles,Integer> {
}
