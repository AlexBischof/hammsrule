# hammsrule

Reusable JUnit Rule for integration test with [Hamms](https://github.com/kevinburke/hamms)

###Installation

```xml
    <dependency>
        <groupId>de.bischinger</groupId>
        <artifactId>hammsrule</artifactId>
        <version>1.0.0</version>
        <scope>test</scope>
    </dependency>
```
###Sample use

```java
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Rule;
import org.junit.Test;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HammsRuleIT {

    @Rule
    public HammsRule hammsRule = new HammsRule("http://127.0.0.1");

    private MyOpenWeatherMapService myService;

    private ThrowingCallable callService = () -> myService.getCity("Munich");

    @Test
    public void testTcpReset() {
        myService = new MyOpenWeatherMapService(hammsRule.getTcpResetUrl());
        assertThatThrownBy(callService).hasCauseInstanceOf(ConnectException.class);
    }
}
```