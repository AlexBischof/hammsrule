package de.bischinger.hamms;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Rule;
import org.junit.Test;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by bischofa on 08/12/15.
 */
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

    @Test
    public void testAcceptButNeverSendBack() {
        myService = new MyOpenWeatherMapService(hammsRule.getAcceptButNeverSendBack());
        assertThatThrownBy(callService).hasCauseInstanceOf(SocketTimeoutException.class);
    }
}