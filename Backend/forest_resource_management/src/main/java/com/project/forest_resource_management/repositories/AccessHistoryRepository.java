package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.models.AccessHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessHistoryRepository extends JpaRepository<AccessHistoryEntity, Long> {
}
