package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Joe", "Java");
        //then
        assertAll("Test Props Set",
                () -> assertEquals( "Joe", person.getFirstName()),
                () -> assertEquals( "Java", person.getLastName()));
    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Person person = new Person(1l, "Joe", "Java");
        //then
        assertAll("Test Props Set",
                () -> assertEquals( "Joe", person.getFirstName(), "First name failed"),
                () -> assertEquals( "Java", person.getLastName(), "Last name failed"));
    }
}