package com.jabaddon.customasserts.model;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class PersonHamcrestMatchers {

    public static TypeSafeMatcher<Person> hasNickName(String nickName) {
        return new TypeSafeMatcher<>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Person has NickName ").appendValue(nickName);
            }

            @Override
            protected void describeMismatchSafely(Person item, Description mismatchDescription) {
                super.describeMismatchSafely(item, mismatchDescription);
//                mismatchDescription.appendText("Person has NickNames ").appendValue(item.getNicknames());
            }

            @Override
            protected boolean matchesSafely(Person person) {
                return person.getNicknames() != null && person.getNicknames().contains(nickName);
            }
        };
    }

    public static TypeSafeMatcher<Person> isAge(int age) {
        return new TypeSafeMatcher<>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Person is ").appendValue(age).appendText(" years old");
            }

            @Override
            protected void describeMismatchSafely(Person item, Description mismatchDescription) {
                super.describeMismatchSafely(item, mismatchDescription);
//                mismatchDescription.appendText("Person is ").appendValue(item.getAge()).appendText(" years old");
            }

            @Override
            protected boolean matchesSafely(Person person) {
                return age == person.getAge();
            }
        };
    }
}
