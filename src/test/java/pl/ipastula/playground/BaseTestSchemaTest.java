package pl.ipastula.playground;

import org.junit.jupiter.api.Test;

public class BaseTestSchemaTest {

    @Test
    void testIt() {
        assert true == true;
    }

    @Test
    void testIt2() {
        String myName = "NAme";
        String output = String.format("Hello %s", myName);

        assert output.equals("Hello NAme");
    }

    @Test
    void baseSchema() {
        //Arrange  // Given  // Input
        //Act      // When   // Interaction
        //Assert   // Then   // Output
    }
}
