package ExpressionLanguage.Registered;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationYourInformationTest {

    @Test
    public void canUsed() {

        AuthenticationYourInformation authenticationYourInformation =
                new AuthenticationYourInformation("liu66zsxdcfgvbhctfvygbup234567eng", "12345", "12345");

        int number = authenticationYourInformation.canUsed();

        System.out.println(number);

    }
}