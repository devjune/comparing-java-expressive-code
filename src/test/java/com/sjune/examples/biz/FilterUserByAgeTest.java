package com.sjune.examples.biz;

import com.google.common.collect.Lists;
import com.sjune.examples.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.sjune.examples.domain.User.Sex.M;
import static com.sjune.examples.domain.User.Sex.W;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FilterUserByAgeTest {
    FilterUserByAge dut;

    @Before
    public void before() {
        generateUsers();
    }

    @Test
    public void testByJava() {
        assertThat(dut.byJava().size(), is(2));
    }

    @Test
    public void testByGuava() {
        assertThat(dut.byGuava().size(), is(2));
    }

    @Test
    public void testByLambdaj() {
        assertThat(dut.byLambdaj().size(), is(2));
    }

    @Test
    public void testByJava8() {
        assertThat(dut.byJava8().size(), is(2));
    }

    private void generateUsers() {
        List<User> users = Lists.newArrayList(
            User.builder().age(22).name("user1").sex(M).build(),
            User.builder().age(30).name("user2").sex(M).build(),
            User.builder().age(38).name("user3").sex(W).build(),
            User.builder().age(13).name("user4").sex(W).build(),
            User.builder().age(67).name("user5").sex(M).build());

        dut = new FilterUserByAge(users, 30);
    }
}
