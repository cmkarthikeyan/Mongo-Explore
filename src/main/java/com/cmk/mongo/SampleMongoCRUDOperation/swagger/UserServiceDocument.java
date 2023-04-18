package com.cmk.mongo.SampleMongoCRUDOperation.swagger;

import com.cmk.mongo.SampleMongoCRUDOperation.dto.UserDto;
import com.cmk.mongo.SampleMongoCRUDOperation.response.UserApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RequestMapping("/api/v1/users")
public interface UserServiceDocument {
    @Operation(summary = "Create User")
    @PostMapping
    public UserApiResponse addUser(@RequestBody UserDto userDto);

    @Operation(summary = "Fetch the users from backend based on filters (firstName/lastName/email/address.city/address.state/address.pincode)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "Success", description = "Fetched the users successfully based on filters",
                    content = {@Content(mediaType = "application/json")})
    })
    @PostMapping("/search")
    public UserApiResponse getUsersWithFilters(@RequestBody UserDto userDto);

    @Operation(summary = "Fetch the User from backend based on first name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "Success", description = "Fetched the users successfully based on filters",
                    content = {@Content(mediaType = "application/json")})
    })
    @GetMapping("/search/{name}")
    public UserApiResponse getUsersByName(@PathVariable String name, @RequestParam(required = false) String transactionId);

    @Operation(summary = "Fetch the User from backend based on state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "Success", description = "Fetched the users successfully based on filters",
                    content = {@Content(mediaType = "application/json")})
    })
    @PostMapping("/search/by-state/")
    public UserApiResponse getUsersByState(@RequestBody UserDto userDto) throws ExecutionException, InterruptedException;
}
