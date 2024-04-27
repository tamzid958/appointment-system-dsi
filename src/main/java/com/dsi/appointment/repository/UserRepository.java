package com.dsi.appointment.repository;

import com.dsi.appointment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    @RestResource(rel = "by-username", path = "by-username")
    User findByUsername(@Param("username") String username);
}
