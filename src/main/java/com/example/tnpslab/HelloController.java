package com.example.tnpslab;

import flanagan.integration.DerivnFunction;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea textArea;

    @FXML
    protected void onHelloButtonClick() {
    }

    public void initialize() {
        textArea.setEditable(false);
    }

    static class DerivnFunctionImpl implements DerivnFunction {

        private final double l1, m1;
        private final double l2, m2;
        private final double l3, m3;
        private final double l4, m4;
        private final double l5, m5;

        DerivnFunctionImpl(double l1, double l2, double l3, double l4, double l5,
                           double m1, double m2, double m3, double m4, double m5) {
            this.l1 = l1;
            this.l2 = l2;
            this.l3 = l3;
            this.l4 = l4;
            this.l5 = l5;
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
            this.m4 = m4;
            this.m5 = m5;

        }

        public double[] derivn(double t, double[] y) {
            double[] dpdt = new double [y.length];

            dpdt[0] = - (l1+l2+l3+l4+l5) * y[0];
            dpdt[1] = l1 * y[0] - (l2+l3+l4+l5) * y[1];
            dpdt[2] = l2 * y[0] - (l1+l3+l4+l5) * y[2];
            dpdt[3] = l3 * y[0] - (l1+l2+l4+l5) * y[3];
            dpdt[4] = l4 * y[0] - (l1+l2+l3+l5) * y[4];
            dpdt[5] = l5 * y[0] - (l1+l2+l3+l4) * y[5];
            dpdt[6] = l1 * y[2] + l2 * y[1] - (l3+l4+l5) * y[6];
            dpdt[7] = l3 * y[2] + l2 * y[3];
            dpdt[8] = l1 * y[4] + l4 * y[1] - (l2+l3+l5) * y[8];
            dpdt[9] = l1 * y[3] + l3 * y[1];
            dpdt[10] = l1 * y[5] + l5 * y[1] - (l2+l3+l4) * y[10];
            dpdt[11] = l2 * y[4] + l4 * y[2] - (l1+l3+l5) * y[11];
            dpdt[12] = l1 * y[11] + l2 * y[8] + l4 * y[6] - (l3+l5) * y[12];
            dpdt[13] = l5 * y[6] + l2 * y[10] + l1 * y[14] - (l3+l4) * y[13];
            dpdt[14] = l5 * y[2] + l2 * y[5] - (l1+l3+l4) * y[14];
            dpdt[15] = l3 * y[10] + l1 * y[16];
            dpdt[16] = l5 * y[3] + l3 * y[5] - (l1+l2+l4) * y[16];
            dpdt[17] = l3 * y[4] + l4 * y[3] - (l1+l2+l5) * y[17];
            dpdt[18] = l5 * y[4] + l4 * y[5];
            dpdt[19] = l3 * y[6];
            dpdt[20] = l3 * y[12];
            dpdt[21] = l3 * y[14] + l2 * y[16];
            dpdt[22] = l5 * y[17] + l4 * y[16];
            dpdt[23] = l5 * y[12] + l4 * y[13];
            dpdt[24] = l3 * y[13];
            dpdt[25] = l3 * y[11] + l2 * y[17];
            dpdt[26] = l3 * y[8] + l1 * y[17];
            dpdt[27] = l5 * y[11] + l4 * y[14];
            dpdt[28] = l5 * y[8] + l4 * y[10];

            return dpdt;
        }

        public double[] derivn2(double t, double[] y) {
            double[] dpdt = new double [y.length];

            dpdt[0] = -y[0]*(l1+2*l2+2*l3+l4+l5)+y[1]*m1+y[2]*m2+y[3]*m3+y[4]*m4+y[5]*m5;
            dpdt[1] = -y[1]*(2*l2+2*l3+l4+l5+m1)+y[0]*l1+y[9]*m2+y[15]*m3+y[19]*m4+y[20]*m5;
            dpdt[2] = -y[2]*(l1+2*l3+l4+l5+m2)+y[0]*l2+y[9]*m1+y[11]*m3+y[21]*m4+y[26]*m5;
            dpdt[3] = -y[3]*(l1+2*l2+l4+l5+m3)+y[0]*l3+y[15]*m1+y[11]*m2+y[24]*m4+y[29]*m5;
            dpdt[4] = -y[4]*(l1+2*l2+2*l3+l5+m4)+y[0]*l4+y[19]*m1+y[21]*m2+y[24]*m3+y[34]*m5;
            dpdt[5] = -y[5]*(l1+2*l2+2*l3+l4+m5)+y[0]*l5+y[20]*m1+y[26]*m2+y[29]*m3+y[34]*m4;
            dpdt[6] = -y[6]*m2+y[0]*l2;
            dpdt[7] = -y[7]*m3+y[0]*l3;
            dpdt[8] = -y[8]*(l1+l2+l3+l4+l5)+y[13]*m1+y[14]*m2+y[18]*m3+y[23]*m4+y[28]*m5;
            dpdt[9] = -y[9]*(2*l3+l4+l5+m1+m2)+y[1]*l2+y[2]*l1+y[35]*m4+y[42]*m5;
            dpdt[10] = -y[10]*m2+y[1]*l2;
            dpdt[11] = -y[11]*(m2+m3)+y[2]*l3+y[3]*l2;
            dpdt[12] = -y[12]*(m2+m3)+y[2]*l3+y[3]*l2;
            dpdt[13] = -y[13]*(l2+l3+l4+l5+m1)+y[8]*l1+y[33]*m2+y[60]*m3+y[37]*m4+y[44]*m5 +y[10]*m2+y[16]*m3;
            dpdt[14] = -y[14]*(l1+l3+l4+l5+m2)+y[8]*l2+y[33]*m1+y[74]*m3+y[63]*m4+y[58]*m5 +y[12]*m3;
            dpdt[15] = -y[15]*(m1+m3)+y[3]*l1+y[1]*l3;
            dpdt[16] = -y[16]*m3+y[1]*l3;
            dpdt[17] = -y[17]*(m4+m5)+y[26]*l4+y[21]*l5;
            dpdt[18] = -y[18]*(l1+l2+l4+l5+m3)+y[8]*l3+y[60]*m1+y[74]*m2+y[52]*m4+y[55]*m5 +y[12]*m2;
            dpdt[19] = -y[19]*(2*l2+2*l3+l5+m1+m4)+y[4]*l1+y[1]*l4+y[35]*m2+y[40]*m3+y[57]*m5;
            dpdt[20] = -y[20]*(2*l2+2*l3+l4+m1+m5)+y[5]*l1+y[1]*l5+y[42]*m2+y[45]*m3+y[57]*m4;
            dpdt[21] = -y[21]*(l1+2*l3+l5+m2+m4)+y[2]*l4+y[4]*l2+y[35]*m1+y[50]*m3+y[17]*m5;
            dpdt[22] = -y[22]*m2+y[4]*l2;
            dpdt[23] = -y[23]*(l1+l2+l3+l5+m4)+y[8]*l4+y[37]*m1+y[63]*m2+y[52]*m3+y[62]*m5 +y[22]*m2+y[25]*m3;
            dpdt[24] = -y[24]*(l1+2*l2+l5+m3+m4)+y[4]*l3+y[3]*l4+y[40]*m1+y[50]*m2+y[56]*m5;
            dpdt[25] = -y[25]*m3+y[4]*l3;
            dpdt[26] = -y[26]*(l1+2*l3+l4+m2+m5)+y[5]*l2+y[2]*l5+y[42]*m1+y[53]*m3+y[17]*m4;
            dpdt[27] = -y[27]*m2+y[5]*l2;
            dpdt[28] = -y[28]*(l1+l2+l3+l4+m5)+y[8]*l5+y[44]*m1+y[58]*m2+y[55]*m3+y[62]*m4 +y[27]*m2+y[30]*m3;
            dpdt[29] = -y[29]*(l1+2*l2+l4+m3+m5)+y[5]*l3+y[3]*l5+y[45]*m1+y[53]*m2+y[56]*m4;
            dpdt[30] = -y[30]*m3+y[5]*l3;
            dpdt[31] = -y[31]*m3+y[9]*l3;
            dpdt[32] = -y[32]*m3+y[9]*l3;
            dpdt[33] = -y[33]*(l3+l4+l5+m1+m2)+y[14]*l1+y[13]*l2+y[59]*m3+y[61]*m4+y[49]*m5 +y[32]*m3;
            dpdt[34] = -y[34]*(m4+m5)+y[4]*l5+y[5]*l4;
            dpdt[35] = -y[35]*(2*l3+l5+m1+m2+m4)+y[21]*l1+y[19]*l2+y[9]*l4+y[38]*m3+y[39]*m5;
            dpdt[36] = -y[36]*m2+y[19]*l2;
            dpdt[37] = -y[37]*(l2+l3+l5+m1+m4)+y[23]*l1+y[13]*l4+y[61]*m2+y[70]*m3+y[65]*m5 +y[36]*m2+y[41]*m3;
            dpdt[38] = -y[38]*2*m3+y[35]*2*l3;
            dpdt[39] = -y[39]*(m4+m5)+y[42]*l4+y[35]*l5;
            dpdt[40] = -y[40]*(m1+m3)+y[24]*l1+y[19]*l3;
            dpdt[41] = -y[41]*m3+y[19]*l3;
            dpdt[42] = -y[42]*(2*l3+l4+m1+m2+m5)+y[26]*l1+y[20]*l2+y[9]*l5+y[47]*m3+y[39]*m4;
            dpdt[43] = -y[43]*m2+y[20]*l2;
            dpdt[44] = -y[44]*(l2+l3+l4+m1+m5)+y[28]*l1+y[13]*l5+y[49]*m2+y[64]*m3+y[65]*m4 +y[43]*m2+y[46]*m3;
            dpdt[45] = -y[45]*(m1+m3)+y[29]*l1+y[20]*l3;
            dpdt[46] = -y[46]*m3+y[20]*l3;
            dpdt[47] = -y[47]*m3+y[42]*l3;
            dpdt[48] = -y[48]*m3+y[42]*l3;
            dpdt[49] = -y[49]*(l3+l4+m1+m2+m5)+y[58]*l1+y[44]*l2+y[33]*l5+y[73]*m3+y[72]*m4 +y[48]*m3;
            dpdt[50] = -y[50]*(m2+m3)+y[24]*l2+y[21]*l3;
            dpdt[51] = -y[51]*(m2+m3)+y[24]*l2+y[21]*l3;
            dpdt[52] = -y[52]*(l1+l2+l5+m3+m4)+y[23]*l3+y[18]*l4+y[70]*m1+y[69]*m2+y[68]*m5 +y[51]*m2;
            dpdt[53] = -y[53]*(m2+m3)+y[29]*l2+y[26]*l3;
            dpdt[54] = -y[54]*(m2+m3)+y[29]*l2+y[26]*l3;
            dpdt[55] = -y[55]*(l1+l2+l4+m3+m5)+y[28]*l3+y[18]*l5+y[64]*m1+y[66]*m2+y[68]*m4 +y[54]*m2;
            dpdt[56] = -y[56]*(m4+m5)+y[29]*l4+y[24]*l5;
            dpdt[57] = -y[57]*(m4+m5)+y[20]*l4+y[19]*l5;
            dpdt[58] = -y[58]*(l1+l3+l4+m2+m5)+y[28]*l2+y[14]*l5+y[49]*m1+y[66]*m3+y[67]*m4 +y[54]*m3;
            dpdt[59] = -y[59]*m3+y[33]*l3;
            dpdt[60] = -y[60]*(m1+m3)+y[18]*l1+y[13]*l3;
            dpdt[61] = -y[61]*(l3+l5+m1+m2+m4)+y[63]*l1+y[37]*l2+y[33]*l4+y[71]*m3+y[72]*m5 +y[75]*m3;
            dpdt[62] = -y[62]*(m4+m5)+y[28]*l4+y[23]*l5;
            dpdt[63] = -y[63]*(l1+2*l3+l5+m2+m4)+y[23]*l2+y[14]*l4+y[61]*m1+y[69]*m3+y[67]*m5 +y[51]*m3;
            dpdt[64] = -y[64]*(m1+m3)+y[55]*l1+y[44]*l3;
            dpdt[65] = -y[65]*(m4+m5)+y[44]*l4+y[37]*l5;
            dpdt[66] = -y[66]*(m2+m3)+y[55]*l2+y[58]*l3;
            dpdt[67] = -y[67]*(m4+m5)+y[58]*l4+y[63]*l5;
            dpdt[68] = -y[68]*(m4+m5)+y[55]*l4+y[52]*l5;
            dpdt[69] = -y[69]*(m2+m3)+y[52]*l2+y[63]*l3;
            dpdt[70] = -y[70]*(m1+m3)+y[52]*l1+y[37]*l3;
            dpdt[71] = -y[71]*m3+y[61]*l3;
            dpdt[72] = -y[72]*(m4+m5)+y[49]*l4+y[61]*l5;
            dpdt[73] = -y[73]*m3+y[49]*2*l3;
            dpdt[74] = -y[74]*(m2+m3)+y[18]*l2+y[14]*l3;

            dpdt[75] = -y[75]*m3+y[35]*l3;

            return dpdt;
        }
    }
}
// P[1] = 0.8228346580560378
//P[2] = 0.0421876350547082
//P[3] = 0.03358051942758218
//P[4] = 0.02505904603188673
//P[5] = 0.020830158540355942
//P[6] = 0.0421876350547082
//P[7] = 0.0017217100479384822
//P[8] = 0.0010670493072575385
//P[9] = 0.0010679850660575126
//P[10] = 0.0013360218502918898
//P[11] = 0.0021630063027779293
//P[12] = 8.500948965881902E-4
//P[13] = 4.35852973678315E-5
//P[14] = 8.827396179276266E-5
//P[15] = 0.0017217100479384822
//P[16] = 4.470384700329421E-5
//P[17] = 0.0012848047642002175
//P[18] = 6.3437277052931E-4
//P[19] = 0.0011124385920668956
//P[20] = 1.78813607724978E-5
//P[21] = 3.360669198361051E-7
//P[22] = 3.5695999413079275E-5
//P[23] = 2.216473763463289E-5
//P[24] = 1.1258565568419203E-6
//P[25] = 6.788940285380945E-7
//P[26] = 1.76819706917268E-5
//P[27] = 2.214396998661516E-5
//P[28] = 2.9663633817600187E-5
//P[29] = 3.7218593089382295E-5
//
//Sum of probabilities = 1.0000000000000004
//Success Probability = 0.99625519532047
//Failure Probability = 0.0037448046795304224