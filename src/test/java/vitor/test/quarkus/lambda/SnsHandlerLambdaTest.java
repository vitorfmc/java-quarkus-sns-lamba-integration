package vitor.test.quarkus.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.amazon.lambda.test.LambdaClient;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SnsHandlerLambdaTest {

    @Test
    public void testSimpleLambdaSuccess() throws Exception {
        BookCreateDTO in = new BookCreateDTO();
        in.setLibraryCode("A2");
        String out = LambdaClient.invoke(String.class, in);
        Assertions.assertEquals("OK", out);
    }

}
