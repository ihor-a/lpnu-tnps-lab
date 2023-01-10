package com.example.tnpslab.service;

import flanagan.integration.DerivnFunction;

public interface SystemDifferentialEquations extends DerivnFunction {
    int getNumberODEs();
    int[] getSuccessIndices();
}
