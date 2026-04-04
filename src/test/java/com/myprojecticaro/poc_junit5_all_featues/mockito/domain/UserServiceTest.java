package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

import com.myprojecticaro.poc_junit5_all_featues.mockito.model.User;
import com.myprojecticaro.poc_junit5_all_featues.mockito.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserServiceTest {

    // cria um objeto falso
    @Mock
    private UserRepository repository;

    // cria a classe que sera testada e injeta os mocks nela
    @InjectMocks
    private UserService userService;

    @Test
    void shouldRegisterUserSuccessfully() {

        String email = "test@email.com";

        when(repository.findByEmail(email))
            .thenReturn(Optional.empty());

        when(repository.save(any(User.class)))
                // retorna dinamicamente o que foi passado Ex: "test@email.com"
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
}