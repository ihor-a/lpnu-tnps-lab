package com.example.tnpslab.service;

import java.util.Map;

public interface CalcReliabilityService {
    String calculate(String systemDifferentialEquationsKey,
                     Map<String, Double> inputRates,
                     double initialValOfT,
                     double finalValOfT,
                     double stepSize);

    void setSystemDifferentialEquationsMap(Map<String, SystemDifferentialEquations> systemDifferentialEquationsMap);
}
