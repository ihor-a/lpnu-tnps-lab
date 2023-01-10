package com.example.tnpslab;

import com.example.tnpslab.service.CalcReliabilityService;
import com.example.tnpslab.service.CalcReliabilityServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {
    @FXML
    private TextArea resultArea;
    @FXML private TextField l1;
    @FXML private TextField l2;
    @FXML private TextField l3;
    @FXML private TextField l4;
    @FXML private TextField l5;
    @FXML private TextField m1;
    @FXML private TextField m2;
    @FXML private TextField m3;
    @FXML private TextField m4;
    @FXML private TextField m5;

    Map<TextField, String> inputValuesMap;

    @FXML
    protected void onCalculateButtonClick() {

        double initialValOfT = 0;
        double finalValOfT = 100;
        double stepSize = 1;

//        try {
//            ClassLoader classLoader = this.getClass().getClassLoader();
//            Class<HelloController> clazz = (Class<HelloController>) classLoader.loadClass(HelloController.class.getName());
//            HelloController obj = clazz.getDeclaredConstructor().newInstance();
//
//            obj.sayHello();
//
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }

        Map<String, Double> inputValues = inputValuesMap.keySet()
                .stream()
                .collect(Collectors.toMap(TextField::getId, this::getFieldValue));

        CalcReliabilityService calcReliabilityService = new CalcReliabilityServiceImpl();
        resultArea.setText(
                calcReliabilityService.calculate(inputValues, initialValOfT, finalValOfT, stepSize)
        );
    }

    public void initialize() {
        resultArea.setEditable(false);

        // Create and set default values
        inputValuesMap = new HashMap<>() {{
            put(l1, "0.0005");
            put(l2, "0.0004");
            put(l3, "0.0003");
            put(l4, "0.00025");
            put(l5, "0.0005");
            put(m1, "0.05");
            put(m2, "0.04");
            put(m3, "0.03");
            put(m4, "0.025");
            put(m5, "0.05");
        }};

        // Set validators
        inputValuesMap.forEach((textField, value) -> {
            textField.setText(value);
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[\\d*.]")) {
                    textField.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            });
        });
    }

    private double getFieldValue(TextField textField) {
        double result;
        if (textField.getText().equals("")) {
            result = 0.0;
            textField.setText(String.valueOf(result));
        } else {
            result = Double.parseDouble(textField.getText());
        }
        return result;
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


// Number of iterations = 100
//Result Sum = 0.952345 ( 0.9523448971124018 )
//Success Probability = 0.951914 ( 0.951914135971483 )
//Failure Probability = 0.000431 ( 4.307611409187784E-4 )