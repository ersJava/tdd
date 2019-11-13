package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
class PersonTest {

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