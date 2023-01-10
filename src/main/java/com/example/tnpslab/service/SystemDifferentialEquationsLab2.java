package com.example.tnpslab.service;

import java.util.Map;

public class SystemDifferentialEquationsLab2 implements SystemDifferentialEquations {

    private final double l1, m1;
    private final double l2, m2;
    private final double l3, m3;
    private final double l4, m4;
    private final double l5, m5;

    SystemDifferentialEquationsLab2(Map<String, Double> inputValues) {
        l1 = inputValues.get("l1");
        l2 = inputValues.get("l2");
        l3 = inputValues.get("l3");
        l4 = inputValues.get("l4");
        l5 = inputValues.get("l5");
        m1 = inputValues.get("m1");
        m2 = inputValues.get("m2");
        m3 = inputValues.get("m3");
        m4 = inputValues.get("m4");
        m5 = inputValues.get("m5");
    }
    @Override
    public int getNumberODEs() {
        return 76;
    }

    @Override
    public int[] getSuccessIndices() {
        return new int[] {
                0,1,2,3,4,5,6,7,8,9,10,13,14,18,19,20,21,22,23,24,25,
                26,27,28,29,30,33,35,36,37,42,43,44,49,52,55,58,61,63
        };
    }

    @Override
    public double[] derivn(double t, double[] p) {
        double[] dpdt = new double [p.length];

        dpdt[0] = -p[0]*(l1+2*l2+2*l3+l4+l5)+ p[1]*m1+ p[2]*m2+ p[3]*m3+ p[4]*m4+ p[5]*m5;
        dpdt[1] = -p[1]*(2*l2+2*l3+l4+l5+m1)+ p[0]*l1+ p[9]*m2+ p[15]*m3+ p[19]*m4+ p[20]*m5;
        dpdt[2] = -p[2]*(l1+2*l3+l4+l5+m2)+ p[0]*l2+ p[9]*m1+ p[11]*m3+ p[21]*m4+ p[26]*m5;
        dpdt[3] = -p[3]*(l1+2*l2+l4+l5+m3)+ p[0]*l3+ p[15]*m1+ p[11]*m2+ p[24]*m4+ p[29]*m5;
        dpdt[4] = -p[4]*(l1+2*l2+2*l3+l5+m4)+ p[0]*l4+ p[19]*m1+ p[21]*m2+ p[24]*m3+ p[34]*m5;
        dpdt[5] = -p[5]*(l1+2*l2+2*l3+l4+m5)+ p[0]*l5+ p[20]*m1+ p[26]*m2+ p[29]*m3+ p[34]*m4;
        dpdt[6] = -p[6]*m2+ p[0]*l2;
        dpdt[7] = -p[7]*m3+ p[0]*l3;
        dpdt[8] = -p[8]*(l1+2*l2+2*l3+l4+l5)+ p[13]*m1+ p[14]*m2+ p[18]*m3+ p[23]*m4+ p[28]*m5;
        dpdt[9] = -p[9]*(2*l3+l4+l5+m1+m2)+ p[1]*l2+ p[2]*l1+ p[35]*m4+ p[42]*m5;
        dpdt[10] = -p[10]*m2+ p[1]*l2;
        dpdt[11] = -p[11]*(m2+m3)+ p[2]*l3+ p[3]*l2;
        dpdt[12] = -p[12]*(m2+m3)+ p[2]*l3+ p[3]*l2;
        dpdt[13] = -p[13]*(2*l2+2*l3+l4+l5+m1)+ p[8]*l1+ p[33]*m2+ p[60]*m3+ p[37]*m4+ p[44]*m5 + p[10]*m2+ p[16]*m3;
        dpdt[14] = -p[14]*(l1+2*l3+l4+l5+m2)+ p[8]*2*l2+ p[33]*m1+ p[74]*m3+ p[63]*m4+ p[58]*m5 + p[12]*m3;
        dpdt[15] = -p[15]*(m1+m3)+ p[3]*l1+ p[1]*l3;
        dpdt[16] = -p[16]*m3+ p[1]*l3;
        dpdt[17] = -p[17]*(m4+m5)+ p[26]*l4+ p[21]*l5;
        dpdt[18] = -p[18]*(l1+2*l2+l4+l5+m3)+ p[8]*2*l3+ p[60]*m1+ p[74]*m2+ p[52]*m4+ p[55]*m5 + p[12]*m2;
        dpdt[19] = -p[19]*(2*l2+2*l3+l5+m1+m4)+ p[4]*l1+ p[1]*l4+ p[35]*m2+ p[40]*m3+ p[57]*m5;
        dpdt[20] = -p[20]*(2*l2+2*l3+l4+m1+m5)+ p[5]*l1+ p[1]*l5+ p[42]*m2+ p[45]*m3+ p[57]*m4;
        dpdt[21] = -p[21]*(l1+2*l3+l5+m2+m4)+ p[2]*l4+ p[4]*l2+ p[35]*m1+ p[50]*m3+ p[17]*m5;
        dpdt[22] = -p[22]*m2+ p[4]*l2;
        dpdt[23] = -p[23]*(l1+2*l2+2*l3+l5+m4)+ p[8]*l4+ p[37]*m1+ p[63]*m2+ p[52]*m3+ p[62]*m5 + p[22]*m2+ p[25]*m3;
        dpdt[24] = -p[24]*(l1+2*l2+l5+m3+m4)+ p[4]*l3+ p[3]*l4+ p[40]*m1+ p[50]*m2+ p[56]*m5;
        dpdt[25] = -p[25]*m3+ p[4]*l3;
        dpdt[26] = -p[26]*(l1+2*l3+l4+m2+m5)+ p[5]*l2+ p[2]*l5+ p[42]*m1+ p[53]*m3+ p[17]*m4;
        dpdt[27] = -p[27]*m2+ p[5]*l2;
        dpdt[28] = -p[28]*(l1+2*l2+2*l3+l4+m5)+ p[8]*l5+ p[44]*m1+ p[58]*m2+ p[55]*m3+ p[62]*m4 + p[27]*m2+ p[30]*m3;
        dpdt[29] = -p[29]*(l1+2*l2+l4+m3+m5)+ p[5]*l3+ p[3]*l5+ p[45]*m1+ p[53]*m2+ p[56]*m4;
        dpdt[30] = -p[30]*m3+ p[5]*l3;
        dpdt[31] = -p[31]*m3+ p[9]*l3;
        dpdt[32] = -p[32]*m3+ p[9]*l3;
        dpdt[33] = -p[33]*(2*l3+l4+l5+m1+m2)+ p[14]*l1+ p[13]*2*l2+ p[59]*m3+ p[61]*m4+ p[49]*m5 + p[32]*m3;
        dpdt[34] = -p[34]*(m4+m5)+ p[4]*l5+ p[5]*l4;
        dpdt[35] = -p[35]*(2*l3+l5+m1+m2+m4)+ p[21]*l1+ p[19]*l2+ p[9]*l4+ p[38]*m3+ p[39]*m5;
        dpdt[36] = -p[36]*m2+ p[19]*l2;
        dpdt[37] = -p[37]*(2*l2+2*l3+l5+m1+m4)+ p[23]*l1+ p[13]*l4+ p[61]*m2+ p[70]*m3+ p[65]*m5 + p[36]*m2+ p[41]*m3;
        dpdt[38] = -p[38]*2*m3+ p[35]*2*l3;
        dpdt[39] = -p[39]*(m4+m5)+ p[42]*l4+ p[35]*l5;
        dpdt[40] = -p[40]*(m1+m3)+ p[24]*l1+ p[19]*l3;
        dpdt[41] = -p[41]*m3+ p[19]*l3;
        dpdt[42] = -p[42]*(2*l3+l4+m1+m2+m5)+ p[26]*l1+ p[20]*l2+ p[9]*l5+ p[47]*m3+ p[39]*m4;
        dpdt[43] = -p[43]*m2+ p[20]*l2;
        dpdt[44] = -p[44]*(2*l2+2*l3+l4+m1+m5)+ p[28]*l1+ p[13]*l5+ p[49]*m2+ p[64]*m3+ p[65]*m4 + p[43]*m2+ p[46]*m3;
        dpdt[45] = -p[45]*(m1+m3)+ p[29]*l1+ p[20]*l3;
        dpdt[46] = -p[46]*m3+ p[20]*l3;
        dpdt[47] = -p[47]*m3+ p[42]*l3;
        dpdt[48] = -p[48]*m3+ p[42]*l3;
        dpdt[49] = -p[49]*(2*l3+l4+m1+m2+m5)+ p[58]*l1+ p[44]*2*l2+ p[33]*l5+ p[73]*m3+ p[72]*m4 + p[48]*m3;
        dpdt[50] = -p[50]*(m2+m3)+ p[24]*l2+ p[21]*l3;
        dpdt[51] = -p[51]*(m2+m3)+ p[24]*l2+ p[21]*l3;
        dpdt[52] = -p[52]*(l1+2*l2+l5+m3+m4)+ p[23]*2*l3+ p[18]*l4+ p[70]*m1+ p[69]*m2+ p[68]*m5 + p[51]*m2;
        dpdt[53] = -p[53]*(m2+m3)+ p[29]*l2+ p[26]*l3;
        dpdt[54] = -p[54]*(m2+m3)+ p[29]*l2+ p[26]*l3;
        dpdt[55] = -p[55]*(l1+2*l2+l4+m3+m5)+ p[28]*2*l3+ p[18]*l5+ p[64]*m1+ p[66]*m2+ p[68]*m4 + p[54]*m2;
        dpdt[56] = -p[56]*(m4+m5)+ p[29]*l4+ p[24]*l5;
        dpdt[57] = -p[57]*(m4+m5)+ p[20]*l4+ p[19]*l5;
        dpdt[58] = -p[58]*(l1+2*l3+l4+m2+m5)+ p[28]*2*l2+ p[14]*l5+ p[49]*m1+ p[66]*m3+ p[67]*m4 + p[54]*m3;
        dpdt[59] = -p[59]*m3+ p[33]*2*l3;
        dpdt[60] = -p[60]*(m1+m3)+ p[18]*l1+ p[13]*2*l3;
        dpdt[61] = -p[61]*(2*l3+l5+m1+m2+m4)+ p[63]*l1+ p[37]*2*l2+ p[33]*l4+ p[71]*m3+ p[72]*m5 + p[75]*m3;
        dpdt[62] = -p[62]*(m4+m5)+ p[28]*l4+ p[23]*l5;
        dpdt[63] = -p[63]*(l1+2*l3+l5+m2+m4)+ p[23]*2*l2+ p[14]*l4+ p[61]*m1+ p[69]*m3+ p[67]*m5 + p[51]*m3;
        dpdt[64] = -p[64]*(m1+m3)+ p[55]*l1+ p[44]*2*l3;
        dpdt[65] = -p[65]*(m4+m5)+ p[44]*l4+ p[37]*l5;
        dpdt[66] = -p[66]*(m2+m3)+ p[55]*2*l2+ p[58]*2*l3;
        dpdt[67] = -p[67]*(m4+m5)+ p[58]*l4+ p[63]*l5;
        dpdt[68] = -p[68]*(m4+m5)+ p[55]*l4+ p[52]*l5;
        dpdt[69] = -p[69]*(m2+m3)+ p[52]*2*l2+ p[63]*2*l3;
        dpdt[70] = -p[70]*(m1+m3)+ p[52]*l1+ p[37]*2*l3;
        dpdt[71] = -p[71]*m3+ p[61]*2*l3;
        dpdt[72] = -p[72]*(m4+m5)+ p[49]*l4+ p[61]*l5;
        dpdt[73] = -p[73]*m3+ p[49]*2*l3;
        dpdt[74] = -p[74]*(m2+m3)+ p[18]*2*l2+ p[14]*2*l3;
        dpdt[75] = -p[75]*m3+ p[35]*l3;

        return dpdt;
    }
}
