package com.josemeurer.HumanResources_worker.repositories;

import com.josemeurer.HumanResources_worker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WokerRepository extends JpaRepository<Worker, Long> {
}
