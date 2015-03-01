package com.sjune.examples.biz;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sjune.examples.CodeStyle;
import com.sjune.examples.domain.User;

import java.util.List;
import java.util.stream.Collectors;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.greaterThan;

public class FilterUserByAge implements CodeStyle {
    private List<User> users;
    private int minAge;

    public FilterUserByAge(List<User> users, int minAge) {
        this.users = users;
        this.minAge = minAge;
    }

    @Override
    public List<User> byJava() {
        List<User> results = Lists.newArrayList();
        for (User user : users) {
            if (user.getAge() > minAge) {
                results.add(user);
            }
        }
        return results;
    }

    @Override
    public List<User> byGuava() {
        return Lists.newArrayList(Iterables.filter(users, new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return input.getAge() > minAge;
            }
        }));
    }

    @Override
    public List<User> byLambdaj() {
        return filter(having(on(User.class).getAge(), greaterThan(minAge)), users);
    }

    @Override
    public List<User> byJava8() {
        return users.stream().filter(member -> member.getAge() > minAge).collect(Collectors.toList());
    }
}
