package com.example.tnpslab.service;

import java.util.Map;

public interface CalcReliabilityService {
    String calculate(Map<String, Double> inputValues, double initialValOfT, double finalValOfT, double stepSize);
}
