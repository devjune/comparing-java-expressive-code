package com.sjune.examples.biz;

import com.google.common.collect.Lists;
import com.sjune.examples.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.sjune.examples.domain.User.Sex.M;
import static com.sjune.examples.domain.User.Sex.W;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class ExtractNamesTest {
    ExtractNames dut;

    @Before
    public void before() {
        generateUsers();
    }

    @Test
    public void testByJava() {
        assertThat(dut.byJava(), hasItem("user1"));
        assertThat(dut.byJava(), hasItem("user2"));
        assertThat(dut.byJava(), hasItem("user3"));
        assertThat(dut.byJava(), hasItem("user4"));
        assertThat(dut.byJava(), hasItem("user5"));
    }

    @Test
    public void testByGuava() {
        assertThat(dut.byGuava(), hasItem("user1"));
        assertThat(dut.byGuava(), hasItem("user2"));
        assertThat(dut.byGuava(), hasItem("user3"));
        assertThat(dut.byGuava(), hasItem("user4"));
        assertThat(dut.byGuava(), hasItem("user5"));
    }

    @Test
    public void testByLambdaj() {
        assertThat(dut.byLambdaj(), hasItem("user1"));
        assertThat(dut.byLambdaj(), hasItem("user2"));
        assertThat(dut.byLambdaj(), hasItem("user3"));
        assertThat(dut.byLambdaj(), hasItem("user4"));
        assertThat(dut.byLambdaj(), hasItem("user5"));
    }

    @Test
    public void testByJava8() {
        assertThat(dut.byJava8(), hasItem("user1"));
        assertThat(dut.byJava8(), hasItem("user2"));
        assertThat(dut.byJava8(), hasItem("user3"));
        assertThat(dut.byJava8(), hasItem("user4"));
        assertThat(dut.byJava8(), hasItem("user5"));
    }

    private void generateUsers() {
        List<User> users = Lists.newArrayList(
                User.builder().age(22).name("user1").sex(M).build(),
                User.builder().age(30).name("user2").sex(M).build(),
                User.builder().age(38).name("user3").sex(W).build(),
                User.builder().age(13).name("user4").sex(W).build(),
                User.builder().age(67).name("user5").sex(M).build());
        dut = new ExtractNames(users);
    }
}
