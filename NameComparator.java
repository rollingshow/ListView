package com.example.customadapterdemo;
import com.example.customadapterdemo.User;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {
    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }
}