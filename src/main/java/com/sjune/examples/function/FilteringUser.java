package com.sjune.examples.function;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sjune.examples.domain.User;

import java.util.List;
import java.util.stream.Collectors;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.greaterThan;

public class FilteringUser implements CodeStyle {
    private List<User> users;
    private int filteringAge;

    public FilteringUser(List<User> users, int filteringAge) {
        this.users = users;
        this.filteringAge = filteringAge;
    }

    @Override
    public List<User> byJava() {
        List<User> results = Lists.newArrayList();
        for (User user : users) {
            if (user.getAge() > filteringAge) {
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
                return input.getAge() > filteringAge;
            }
        }));
    }

    @Override
    public List<User> byLambdaj() {
        return filter(having(on(User.class).getAge(), greaterThan(30)), users);
    }

    @Override
    public List<User> byJava8() {
        return users.stream().filter(member -> member.getAge() > filteringAge).collect(Collectors.toList());
    }
}
