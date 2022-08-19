package com.educavalieri.MicroserviceTests.repositories;

import com.educavalieri.MicroserviceTests.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
