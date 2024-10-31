package org.acme;

public class StringAndInt {
    private final String stringValue;
    private final int intValue;

    public StringAndInt(String s, int i) {
        this.stringValue = s;
        this.intValue = i;
    }

    public static StringAndInt parse(String value) {
        if (value == null) {
            return null;
        }
        int dot = value.indexOf(':');
        if (-1 == dot) {
            throw new IllegalArgumentException(value);
        }
        try {
            return new StringAndInt(value.substring(0, dot), Integer.parseInt(value.substring(dot + 1)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(value, e);
        }
    }

    public String format() {
        return this.stringValue + ":" + intValue;
    }
}
