package model.contract.impl;

import model.contract.CartService;
import model.dto.CartDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartServiceImplTest {
    private CartService<CartDto> cartService;

    @BeforeEach
    public void setUp() {
        cartService = new CartServiceImpl();
    }

    @Test
    public void testGetAllCarts() {
        List<CartDto> carts = cartService.getAllCarts();
        Assertions.assertNotNull(carts);
        Assertions.assertFalse(carts.isEmpty());
    }

    @Test
    public void testGetCart() {
        Integer cartId = 1;
        CartDto cart = cartService.getCart(cartId);
        Assertions.assertNotNull(cart);
        Assertions.assertEquals(cartId, cart.getId());
    }

    @Test
    public void testGetUserCarts() {
        Integer userId = 1;
        List<CartDto> carts = cartService.getUserCarts(userId);
        Assertions.assertNotNull(carts);
        Assertions.assertFalse(carts.isEmpty());
        for (CartDto cart : carts) {
            Assertions.assertEquals(userId, cart.getUserId());
        }
    }
}