package qa_java.generators;

import qa_java.model.User;

public class UserGenerator {

    public static User getDefault(){
        return new User("login090909090909@ya.ru","password","name");
    }

    public static User getDefaultToken(){
        return new User("login090909090909Token@ya.ru","password","name");
    }

    public static User getWithoutPassField(){
        return new User("login090909090909@ya.ru",null,"name");
    }

    public static User getWithoutLoginField(){
        return new User(null,"password","name");
    }

    public static User getNotExist(){
        return new User("login090909090909@wya.ru","password","name");
    }
}
