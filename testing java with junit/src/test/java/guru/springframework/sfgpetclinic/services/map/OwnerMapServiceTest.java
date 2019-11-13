package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test --")
class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private PetTypeService petTypeService;
    private PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("First before each");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type --")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "puppy");
            PetType petType2 = new PetType(2L, "pony");

            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("Nested before each");
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();

            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Test --")
        @Nested
        class SaveOwnersTests {

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("Saved owners before each");
            }

            @Test
            void saveOwner() {

                Owner owner = new Owner(2L, "Joe", "Java");

                Owner savedOwner = ownerMapService.save(owner);

                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Save Owners Test --")
            @Nested
            class FindOwnersTests {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {

                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner not found")
                @Test
                void findOwnerNotFound() {

                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                }
            }
        }
    }

    @DisplayName("Verify still zero owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }
}