package de.bischinger.hamms;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.ws.rs.client.Client;

import static java.util.concurrent.TimeUnit.SECONDS;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by bischofa on 08/12/15.
 */
public class MyOpenWeatherMapService {

    private String url = "http://api.openweathermap.org/data/2.5/" +
            "forecast/daily?q=London&units=metric&cnt=7&appid=2de143494c0b295cca9337e1e96b00e0";
    private Client client;

    public MyOpenWeatherMapService(String url) {
        this.url = url;
        client = new ResteasyClientBuilder()
                .establishConnectionTimeout(2, SECONDS).socketTimeout(2, SECONDS)
                .build();
    }

    public String getCity(String city) {
        return client.target(url).queryParam("q", city).request(APPLICATION_JSON).get(String.class);
    }
}
