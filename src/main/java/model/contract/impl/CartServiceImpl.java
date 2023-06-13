package model.contract.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.contract.CartService;
import model.dto.CartDto;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class CartServiceImpl implements CartService<CartDto> {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<CartDto> getAllCarts() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/carts"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response and create Cart objects
            List<CartDto> cartDtos = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return cartDtos;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public CartDto getCart(Integer cartId) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/carts/" + cartId))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response and create a Cart object
            CartDto cartDto = objectMapper.readValue(response.body(), CartDto.class);

            return cartDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CartDto> getUserCarts(Integer userId) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/carts/user/" + userId))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response and create Cart objects
            List<CartDto> cartDtos = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return cartDtos;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
