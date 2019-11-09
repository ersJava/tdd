package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

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
    }

}