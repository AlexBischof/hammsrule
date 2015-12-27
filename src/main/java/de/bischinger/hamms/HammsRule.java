package de.bischinger.hamms;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by bischofa on 27/12/15.
 */
public class HammsRule implements TestRule {

    private String url;

    public HammsRule(String url) {
        this.url = url;
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                statement.evaluate();
            }
        };
    }

    public String getTcpResetUrl() {
        return url + ":5500";
    }

    public String getAcceptButNeverSendBack() {
        return url + ":5501";
    }

    public String getEmptyReplyImmediately() {
        return url + ":5502";
    }

    public String getEmptyReplyAfterSendData() {
        return url + ":5503";
    }

    public String getMalformedResponseImmediately() {
        return url + ":5504";
    }

    public String getMalformedResponseAfterSendData() {
        return url + ":5505";
    }

    public String getOneByteEvery5Seconds() {
        return url + ":5506";
    }

    public String getOneByteEvery30Seconds() {
        return url + ":5507";
    }

    public String getOneByteEveryXSeconds(String sleepInSeconds) {
        return url + ":5508?sleep=" + sleepInSeconds;
    }

    public String getWithResponseCode(String status) {
        return url + ":5509?status=" + status;
    }

    public String getWithContentLength3() {
        return url + ":5510";
    }

    public String getWithHeaderSizeX(String headerSize) {
        return url + ":5511?size=" + headerSize;
    }

    public String getRetryDecrementCounter(String key, String retries) {
        return url + ":5512?key=" + key + "&retries=" + retries;
    }

    public String getRetryDecrement3Counter(String key) {
        return url + ":5512?key=" + key;
    }

    public String getWithFailrate(String failrate) {
        return url + ":5513?failrate=" + failrate;
    }

    public String getBadApplicationType() {
        return url + ":5514";
    }

    public String getIncompleteResponse() {
        return url + ":5515";
    }

    public String getIncompleteClosedResponse() {
        return url + ":5516";
    }
}
