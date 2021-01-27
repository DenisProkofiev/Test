
package com.company.repository;

import com.company.model.User;
import java.util.*;

public class UserRepository {
    private final static Map<Long, User> getMap = new LinkedHashMap<>();

    private static volatile UserRepository instance;

    public static UserRepository getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (UserRepository.class) {
            if (instance != null) {
                return instance;
            }
            return new UserRepository();
        }
    }

    private UserRepository() {
    }

    public synchronized Long addUser(User user) {
        Long id = 0L;
        User newUser = new User(++id, user.getName());

            getMap.put(id, newUser);
        return id;
    }

    public User getUser(Long userId) {
        String name = getMap.get(userId).getName(); 
        User userCopy = new User (userId, name);
        return userCopy;
    }

    public List<User> getOrderedUsers() {
        return List.copyOf(getMap.values());
    }
}