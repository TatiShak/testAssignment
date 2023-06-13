package model.contract.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.contract.UserService;
import model.dto.UserDto;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService<UserDto> {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<UserDto> getAllUsers() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/users"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<UserDto> users = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public UserDto getUser(Integer userId) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/users/" + userId))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            UserDto user = objectMapper.readValue(response.body(), UserDto.class);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserDto> searchUsers(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/users/search?q=" + query))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            List<UserDto> users = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}