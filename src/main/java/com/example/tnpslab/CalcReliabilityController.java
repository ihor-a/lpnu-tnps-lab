package com.example.tnpslab;

import com.example.tnpslab.service.CalcReliabilityService;

public interface CalcReliabilityController {
    void setCalcReliabilityService(CalcReliabilityService calcReliabilityService);

    String getIdLab1();
    String getIdLab2();
}
