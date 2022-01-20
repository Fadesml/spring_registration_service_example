package ru.fadesml.practise.services;

import org.springframework.stereotype.Service;
import ru.fadesml.practise.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    //Добавление пользователя / регистрация
    public String addUser(User user) {
        if (containsByName(user.getUsername())) {
            return Messages.ALREADY_EXISTS_BY_NAME;
        }

        this.users.add(user);

        return Messages.SUCCESSFULLY_REGISTERED;
    }

    //Получение копии списка пользователей
    public List<User> getUsers() {
        return List.copyOf(this.users);
    }

    //Проверка на существование пользователя с конкретным именем
    private boolean containsByName(String name) {
        for (User user : this.users) {
            if (user.getUsername().equals(name)) {
                return true;
            }
        }

        return false;
    }

    //Можно отделить в отдельный пакет messages
    public static class Messages {
        public static final String ALREADY_EXISTS_BY_NAME = "Error: user with this username already exist!";
        public static final String SUCCESSFULLY_REGISTERED = "Notify: successful register.";
    }
}
