package com.sjune.examples.biz;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sjune.examples.CodeStyle;
import com.sjune.examples.domain.User;

import java.util.List;
import java.util.stream.Collectors;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

public class ExtractNames implements CodeStyle {
    private List<User> users;

    public ExtractNames(List<User> users) {
        this.users = users;
    }

    @Override
    public List<String> byJava() {
        List<String> results = Lists.newArrayList();
        for (User user : users) {
            results.add(user.getName());
        }
        return results;
    }


    @Override
    public List<String> byGuava() {
        return Lists.newArrayList(Iterables.transform(users, new Function<User, String>() {
            @Override
            public String apply(User input) {
                return input.getName();
            }
        }));
    }

    @Override
    public List<String> byLambdaj() {
        return extract(users, on(User.class).getName());

    }

    @Override
    public List<String> byJava8() {
        return users.stream().map(User::getName).collect(Collectors.toList());
    }
}
