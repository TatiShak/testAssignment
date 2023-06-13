package model.contract.impl;

import model.contract.ProductService;
import model.dto.CategoryDto;
import model.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductServiceImplTest {
    private ProductService<ProductDto, CategoryDto> productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductServiceImpl();
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        Assertions.assertNotNull(products);
        Assertions.assertFalse(products.isEmpty());
    }

    @Test
    public void testGetAllProductsWithParameters() {
        int limit = 10;
        int skip = 0;
        String[] fields = {"title", "price"};
        List<ProductDto> products = productService.getAllProducts(limit, skip, fields);
        Assertions.assertNotNull(products);
        Assertions.assertFalse(products.isEmpty());
    }

    @Test
    public void testGetProduct() {
        Integer productId = 1;
        ProductDto product = productService.getProduct(productId);
        Assertions.assertNotNull(product);
        Assertions.assertEquals(productId, product.getId());
    }

    @Test
    public void testSearchProducts() {
        String query = "iphone";
        List<ProductDto> products = productService.searchProducts(query);
        Assertions.assertNotNull(products);
    }

    @Test
    public void testGetCategories() {
        List<CategoryDto> categories = productService.getCategories();
        Assertions.assertNotNull(categories);
        Assertions.assertFalse(categories.isEmpty());
    }

    @Test
    public void testGetProductsByCategory() {
        String categoryName = "smartphones";
        List<ProductDto> products = productService.getProductsByCategory(categoryName);
        Assertions.assertNotNull(products);
    }
}