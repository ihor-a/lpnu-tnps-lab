package com.example.tnpslab;

import com.example.tnpslab.service.*;

import java.util.HashMap;

public class ServiceInjectorImpl implements ServiceInjector {
    @Override
    public void setServices(CalcReliabilityController controller) {
        CalcReliabilityService calcReliabilityService = new CalcReliabilityServiceImpl();
        calcReliabilityService.setSystemDifferentialEquationsMap(new HashMap<>(){{
            put(controller.getIdLab1(), new SystemDifferentialEquationsLab1());
            put(controller.getIdLab2(), new SystemDifferentialEquationsLab2());
        }});

        controller.setCalcReliabilityService(calcReliabilityService);
    }
}
