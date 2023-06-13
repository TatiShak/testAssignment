package model.contract.impl;

import model.contract.UserService;
import model.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceImplTest {
    private UserService<UserDto> userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void testGetAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        Assertions.assertNotNull(users);
        Assertions.assertFalse(users.isEmpty());
    }

    @Test
    public void testGetUser() {
        Integer userId = 1;
        UserDto user = userService.getUser(userId);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(userId, user.getId());
    }

    @Test
    public void testSearchUsers() {
        String query = "John";
        List<UserDto> users = userService.searchUsers(query);
        Assertions.assertNotNull(users);
    }
}