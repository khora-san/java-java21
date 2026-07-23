package java17.ex01;


import java17.data.Data;
import java17.data.Person;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 02 - Filter, Map
 */
public class Optional_01_Test {

    class NotPresentException extends RuntimeException {

    }

    @Test
    public void test_optional_ifPresent() throws Exception {

        List<Person> persons = Data.buildPersonList(100);

        Optional<Person> optPerson = persons.stream()
                .filter(p -> p.getAge() == 18)
                .findFirst();
        assertThat(optPerson.isPresent(), is(true));

        optPerson.ifPresent(System.out::println);
    }

    @Test(expected = NotPresentException.class)
    public void test_optional_notPresent() throws Exception {
        List<Person> persons = Data.buildPersonList(50);

        Optional<Person> optPerson = persons.stream()
                .filter(p -> p.getAge() == 75)
                .findFirst();
        assertThat(optPerson.isPresent(), is(false));

        optPerson.orElseThrow(NotPresentException::new);
    }
}
