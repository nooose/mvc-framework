package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private String queryString;

    // GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");

        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];
        if (hasQueryString(urlPathTokens)) {
            this.queryString = urlPathTokens[1];
        }
    }

    private static boolean hasQueryString(String[] urlPathTokens) {
        return urlPathTokens.length == 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestLine)) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
