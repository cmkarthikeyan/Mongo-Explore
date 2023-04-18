package com.cmk.mongo.SampleMongoCRUDOperation.repository;

import com.cmk.mongo.SampleMongoCRUDOperation.entity.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.0.10");
    {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }


    @Test
    @DisplayName("Should find Users By name")
    void shouldFindUsersByName() {
        final var expectedUsers = Users.builder()
                .userId(3087L)
                .firstName("selvam")
                .email("selvam@test.com")
                .build();
        userRepository.save(expectedUsers);

        final var actualUser = userRepository.findByName("selvam").orElseThrow(() -> new RuntimeException("Record not found"));
        assertEquals(expectedUsers.getFirstName(), actualUser.getFirstName());
        assertEquals(expectedUsers.getUserId(), actualUser.getUserId());
    }

    @Test
    @DisplayName("No Record found in find Users By name")
    void shouldRecordNotExistsInFindUsersByName() {
        Optional<Users> users =  userRepository.findByName("cm");
        assertThat(users).isEmpty();
    }

}
