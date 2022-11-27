package qa_java.generators;

import qa_java.model.User;

public class UserGenerator {

    public static User getDefault() {
        return new User("login090909090909@ya.ru", "password", "name");
    }

    public static User getDefaultEmailChange() {
        return new User("1login090909090909@ya.ru", "password", "name");
    }

    public static User getDefaultPasswordChange() {
        return new User("login090909090909@ya.ru", "1password", "name");
    }

    public static User getDefaultNameChange() {
        return new User("login090909090909@ya.ru", "password", "1name");
    }

    public static User getDefaultToken() {
        return new User("login090909090909Token@ya.ru", "password", "name");
    }

    public static User getWithoutPassField() {
        return new User("login090909090909@ya.ru", null, "name");
    }

    public static User getWithoutLoginField() {
        return new User(null, "password", "name");
    }

    public static User getWithoutNameField() {
        return new User("login090909090909@ya.ru", "password", null);
    }

    public static User getWrongPassField() {
        return new User("login090909090909@ya.ru", "password1", "name");
    }

    public static User getWrongLoginField() {
        return new User("login090909090909@ya.ru1", "password", "name");
    }
}
