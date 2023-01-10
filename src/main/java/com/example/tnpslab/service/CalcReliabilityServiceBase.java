package com.example.tnpslab.service;

abstract class CalcReliabilityServiceBase {

    protected String result;

    public String getResult() {
        return result;
    }

    protected void appendResultText(String message) {
        if (result.length() == 0) {
            result = String.format("%s", message);
        } else {
            result = String.format("%s%n%s", result, message);
        }
    }

    protected void appendResultValue(String description, double value) {
        appendResultText(String.format("%s = %f ( %s )", description, value, value));
    }

    protected void appendResultNewline() {
        appendResultText("");
    }

    protected void resetResult() {
        result = "";
    }
}
