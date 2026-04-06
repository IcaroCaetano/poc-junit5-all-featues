package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import com.myprojecticaro.poc_junit5_all_featues.mockito.model.User;
import com.myprojecticaro.poc_junit5_all_featues.mockito.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldRegisterUserSuccessfully() {

        String email = "test@email.com";

        when(repository.findByEmail(email))
            .thenReturn(Optional.empty());

        when(repository.save(any(User.class)))
            .thenAnswer(invocation -> {
                User user = invocation.getArgument(0);
                System.out.println("Value: " + user.getEmail());
                return new User(user.getEmail());
            });


        User result = userService.registerUser(email);

        assertEquals(email, result.getEmail());

        verify(repository).findByEmail(email);
        verify(repository).save(any(User.class));
    }

    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() {

        String email = "test@email.com";

        when(repository.findByEmail(email))
            .thenReturn(Optional.of(new User(email)));

        assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser(email);
        });

        verify(repository).findByEmail(email);
        verify(repository, never()).save(any());
    }

    @Test
    void shouldCaptureSavedUser() {

        String email = "test@email.com";

        when(repository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        userService.registerUser(email);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        verify(repository).save(captor.capture());

        User capturedUser = captor.getValue();

        assertEquals(email, capturedUser.getEmail());
    }

    @Test
    void shouldCaptureMultipleUsers() {

        List<String> emails = List.of("a@email.com", "b@email.com");

        userService.registerMultiple(emails);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        verify(repository, times(2)).save(captor.capture());

        List<User> capturedUsers = captor.getAllValues();

        assertEquals(2, capturedUsers.size());

        assertEquals("a@email.com", capturedUsers.get(0).getEmail());
        assertEquals("b@email.com", capturedUsers.get(1).getEmail());
    }

    @Test
    void shouldThrowExceptionWhenDeleteFails() {

        User user = new User("test@email.com");

        doThrow(new RuntimeException("Database error"))
                .when(repository)
                .delete(user);

        assertThrows(RuntimeException.class, () -> {
            userService.deleteUser(user);
        });

        verify(repository).delete(user);
    }

    @Test
    void shouldDeleteUserSuccessfully() {

        User user = new User("test@email.com");

        doNothing()
                .when(repository)
                .delete(user);

        userService.deleteUser(user);

        verify(repository).delete(user);
    }
}