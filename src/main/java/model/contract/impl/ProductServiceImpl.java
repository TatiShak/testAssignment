package model.contract.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.contract.ProductService;
import model.dto.CategoryDto;
import model.dto.ProductDto;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class ProductServiceImpl implements ProductService<ProductDto, CategoryDto> {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<ProductDto> getAllProducts() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<ProductDto> products = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<ProductDto> getAllProducts(int limit, int skip, String... fields) {
        String fieldsQueryParam = String.join(",", fields);
        String url = String.format("https://dummyjson.com/products?limit=%d&skip=%d&select=%s", limit, skip, fieldsQueryParam);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            List<ProductDto> products = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public ProductDto getProduct(Integer productId) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products/" + productId))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            ProductDto productDto = objectMapper.readValue(response.body(), ProductDto.class);

            return productDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ProductDto> searchProducts(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products/search?q=" + query))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            List<ProductDto> products = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<CategoryDto> getCategories() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products/categories"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            List<CategoryDto> categories = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return categories;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<ProductDto> getProductsByCategory(String categoryName) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products/category/" + categoryName))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            List<ProductDto> products = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
