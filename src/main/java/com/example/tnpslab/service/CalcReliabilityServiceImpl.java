package com.example.tnpslab.service;

import flanagan.integration.RungeKutta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CalcReliabilityServiceImpl extends CalcReliabilityServiceBase implements CalcReliabilityService {
    @Override
    public String calculate(Map<String, Double> inputValues, double initialValOfT, double finalValOfT, double stepSize) {
        SystemDifferentialEquations systemDifferentialEquations = new SystemDifferentialEquationsLab2(inputValues);

        // Initial values
        double[] initialValOfP = new double[systemDifferentialEquations.getNumberODEs()];
        initialValOfP[0] = 1.0;

        // Create and setup RungeKutta class
        RungeKutta rungeKutta = new RungeKutta();
        rungeKutta.setInitialValueOfX(initialValOfT);
        rungeKutta.setFinalValueOfX(finalValOfT);
        rungeKutta.setInitialValuesOfY(initialValOfP);
        rungeKutta.setStepSize(stepSize);

        // Call Fourth Order Runge-Kutta method
        double[] rungeKuttaResult = rungeKutta.fourthOrder(systemDifferentialEquations);

        // Output the results
        resetResult();
        appendResultText("Result with Runge-Kutta fourthOrder method:");
        double resultSum = 0.0;
        for (int i = 0; i < rungeKuttaResult.length; i++) {
            resultSum += rungeKuttaResult[i];
            appendResultValue("P"+i, rungeKuttaResult[i]);
        }

        List<Double> resultList = Arrays.stream(rungeKuttaResult).boxed().toList();


        double successProbability = Arrays.stream(systemDifferentialEquations.getSuccessIndices())
                .mapToObj(resultList::get)
                .reduce(0.0, Double::sum);
        double failureProbability = resultSum - successProbability;

        appendResultNewline();
        appendResultText("Number of iterations = " + rungeKutta.getNumberOfIterations());
        appendResultValue("Result Sum", resultSum);
        appendResultValue("Success Probability", successProbability);
        appendResultValue("Failure Probability", failureProbability);

        return getResult();
    }
}
