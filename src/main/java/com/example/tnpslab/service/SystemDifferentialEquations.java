package com.example.tnpslab.service;

import flanagan.integration.DerivnFunction;
import java.util.Map;

public interface SystemDifferentialEquations extends DerivnFunction {
    void setInputRates(Map<String, Double> inputRates);
    int getNumberODEs();
    int[] getSuccessIndices();
}
