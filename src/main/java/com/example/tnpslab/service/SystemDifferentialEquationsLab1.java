package com.example.tnpslab.service;

import java.util.Map;

public class SystemDifferentialEquationsLab1 implements SystemDifferentialEquations {

    private double l1, l2, l3, l4, l5;

    @Override
    public void setInputRates(Map<String, Double> inputRates) {
        l1 = inputRates.get("l1");
        l2 = inputRates.get("l2");
        l3 = inputRates.get("l3");
        l4 = inputRates.get("l4");
        l5 = inputRates.get("l5");
    }

    @Override
    public int getNumberODEs() {
        return 29;
    }

    @Override
    public int[] getSuccessIndices() {
        return new int[] {0,1,2,3,4,5,6,8,10,11,12,13,14,16,17};
    }

    @Override
    public double[] derivn(double t, double[] p) {
        double[] dpdt = new double [p.length];

        dpdt[0] = - (l1+l2+l3+l4+l5) * p[0];
        dpdt[1] = l1 * p[0] - (l2+l3+l4+l5) * p[1];
        dpdt[2] = l2 * p[0] - (l1+l3+l4+l5) * p[2];
        dpdt[3] = l3 * p[0] - (l1+l2+l4+l5) * p[3];
        dpdt[4] = l4 * p[0] - (l1+l2+l3+l5) * p[4];
        dpdt[5] = l5 * p[0] - (l1+l2+l3+l4) * p[5];
        dpdt[6] = l1 * p[2] + l2 * p[1] - (l3+l4+l5) * p[6];
        dpdt[7] = l3 * p[2] + l2 * p[3];
        dpdt[8] = l1 * p[4] + l4 * p[1] - (l2+l3+l5) * p[8];
        dpdt[9] = l1 * p[3] + l3 * p[1];
        dpdt[10] = l1 * p[5] + l5 * p[1] - (l2+l3+l4) * p[10];
        dpdt[11] = l2 * p[4] + l4 * p[2] - (l1+l3+l5) * p[11];
        dpdt[12] = l1 * p[11] + l2 * p[8] + l4 * p[6] - (l3+l5) * p[12];
        dpdt[13] = l5 * p[6] + l2 * p[10] + l1 * p[14] - (l3+l4) * p[13];
        dpdt[14] = l5 * p[2] + l2 * p[5] - (l1+l3+l4) * p[14];
        dpdt[15] = l3 * p[10] + l1 * p[16];
        dpdt[16] = l5 * p[3] + l3 * p[5] - (l1+l2+l4) * p[16];
        dpdt[17] = l3 * p[4] + l4 * p[3] - (l1+l2+l5) * p[17];
        dpdt[18] = l5 * p[4] + l4 * p[5];
        dpdt[19] = l3 * p[6];
        dpdt[20] = l3 * p[12];
        dpdt[21] = l3 * p[14] + l2 * p[16];
        dpdt[22] = l5 * p[17] + l4 * p[16];
        dpdt[23] = l5 * p[12] + l4 * p[13];
        dpdt[24] = l3 * p[13];
        dpdt[25] = l3 * p[11] + l2 * p[17];
        dpdt[26] = l3 * p[8] + l1 * p[17];
        dpdt[27] = l5 * p[11] + l4 * p[14];
        dpdt[28] = l5 * p[8] + l4 * p[10];

        return dpdt;
    }
}
