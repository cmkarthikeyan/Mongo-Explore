package com.cmk.mongo.SampleMongoCRUDOperation.repository;

import com.cmk.mongo.SampleMongoCRUDOperation.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.stream.Stream;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
    @Query("{'firstName': ?0}")  //for Testcontainers only
    Optional<Users> findByName(String firstName);

    Stream<List<Users>> findByAddress_State(String state);


}
