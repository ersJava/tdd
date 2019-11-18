package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Java");
        owner.setCity("Denver");
        owner.setTelephone("8081234567");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                    () -> assertEquals("Joe", owner.getFirstName(), "First name does not match"),
                    () -> assertEquals("Java", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Denver", owner.getCity(), "City doe not match"),
                        () -> assertEquals("8081234567", owner.getTelephone())
                        ));

        // Hamcrest example
        assertThat(owner.getCity(), is("Denver"));
    }
    @DisplayName("Value Source Test")
    @ParameterizedTest(name ="{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println("value: " + val);
    }
}