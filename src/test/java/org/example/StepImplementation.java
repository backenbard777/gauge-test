package org.example;

import com.thoughtworks.gauge.Step;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {
    @Step("The number <number> is divisible by <divider>.")
    public void checkDivisibility(int number, int divider) {
        assertThat(number % divider).isEqualTo(0);
    }

    @Step("The sentence <sentence> has <expectedWordCount> words.")
    public void verifyWordsCountInSentence(String sentence, int expectedWordCount) {
        var actualCount = sentence.split(" ").length;

        assertThat(actualCount).isEqualTo(expectedWordCount);
    }

    @Step("A request to URL <urlString> returns status <expectedStatus>.")
    public void verifyHttpRequestStatus(String urlString, int expectedStatusCode) throws IOException {
        var url = new URL(urlString);

        var connection = (HttpURLConnection) url.openConnection();
        var actualStatusCode = connection.getResponseCode();

        assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }
}
