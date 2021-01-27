
package com.company.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class UserRepositoryTest {

    @Test
    public void test() {
        Random random = new Random();
        Long userId1 = UserRepository.getInstance().addUser(newUser(random));
        Long userId2 = UserRepository.getInstance().addUser(newUser(random));
        Long userId3 = UserRepository.getInstance().addUser(newUser(random));

        assertEquals(userId1, UserRepository.getInstance().getUser(userId1).getId());
        assertEquals(userId2, UserRepository.getInstance().getUser(userId2).getId());
        assertEquals(userId3, UserRepository.getInstance().getUser(userId3).getId());

        List<User> savedUsers = UserRepository.getInstance().getOrderedUsers();
        assertEquals(3, savedUsers.size());
        assertEquals(Long.valueOf(1), savedUsers.get(0).getId());
        assertEquals(Long.valueOf(3), savedUsers.get(2).getId());
    }

    private User newUser(Random random) {
        return new User(String.valueOf(random.nextLong()));
    }
}