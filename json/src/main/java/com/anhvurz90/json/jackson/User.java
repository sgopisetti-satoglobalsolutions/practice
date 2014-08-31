package com.anhvurz90.json.jackson;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vuna
 * Date: 6/25/14
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int age = 29;
    private String name = "anhvu";
    private List<String> messages;

    public User() {
        setMessages(Arrays.asList(new String[]{"msg 1", "msg 2", "msg 3"}));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User: [ name: " + name +
               ", age: " + age + ", messages: " +
               messages + "]";
    }
}
