package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("repeated")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelRepeatedTests {
    @BeforeEach
    default void beforeAllConsoleOutputer(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running -" + testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }
}
