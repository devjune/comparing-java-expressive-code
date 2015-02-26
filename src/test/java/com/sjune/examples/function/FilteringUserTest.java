package com.sjune.examples.function;

import com.google.common.collect.Lists;
import com.sjune.examples.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FilteringUserTest {
    FilteringUser sut;

    @Before
    public void before() {
        int filteringAge = 30;
        ArrayList<User> users = Lists.newArrayList(
                new User(22, "user1"),
                new User(30, "user2"),
                new User(38, "user3"),
                new User(13, "user4"),
                new User(67, "user5"));

        sut = new FilteringUser(users, filteringAge);
    }

    @Test
    public void testByJava() {
        assertThat(sut.byJava().size(), is(2));
    }

    @Test
    public void testByGuava() {
        assertThat(sut.byGuava().size(), is(2));
    }

    @Test
    public void testByLambdaj() {
        assertThat(sut.byLambdaj().size(), is(2));
    }

    @Test
    public void testByJava8() {
        assertThat(sut.byJava8().size(), is(2));
    }
}
