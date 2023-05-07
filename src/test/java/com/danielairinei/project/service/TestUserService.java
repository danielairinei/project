package com.danielairinei.project.service;

import com.danielairinei.project.model.User;
import com.danielairinei.project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestUserService {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User firstUser;
    private User secondUser;

    private List<User> userList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        firstUser = new User(1, "username1", "parola", "testmail", "01", 2);
        secondUser = new User(2, "username2", "parola", "testmail", "02", 0);
        userList = new ArrayList<>();
        userList.add(firstUser);
        userList.add(secondUser);
    }

    @Test
    public void testAddUser() {
        User newUser = new User(4, "name", "pass", "email", "000-111", 5);
        when(userRepository.save(newUser)).thenReturn(newUser);

        User addedUser = userService.saveUser(newUser);

        assertNotNull(addedUser);
        Assertions.assertEquals(4, addedUser.getId());
        Assertions.assertEquals("name", addedUser.getUsername());
        Assertions.assertEquals("pass", addedUser.getPassword());
        Assertions.assertEquals("email", addedUser.getEmail());
        Assertions.assertEquals("000-111", addedUser.getPhone());
        Assertions.assertEquals(5, addedUser.getNumberOfOrders());
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    public void testGetUsers() {
        when(userRepository.findAll()).thenReturn(userList);

        List<User> users = userService.getUsers();

        Assertions.assertEquals(userList, users);
    }

    @Test
    public void testGetUsersById() {
        when(userRepository.findById(1)).thenReturn(Optional.of(firstUser));

        User user = userService.getUserById(1);

        Assertions.assertEquals(firstUser, user);
    }

    @Test
    public void testDeleteUser() {
        when(userRepository.findById(1)).thenReturn(Optional.of(firstUser));

        userService.deleteUser(1);

        Assertions.assertTrue(true);
    }

    @Test
    public void testUpdateUser() {
        when(userRepository.findById(1)).thenReturn(Optional.of(firstUser));
        User updatedUser = new User(2, "newname", "parola", "testmail", "02", 0);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User user = userService.updateUser(updatedUser);

        Assertions.assertEquals(updatedUser, user);
    }
}
