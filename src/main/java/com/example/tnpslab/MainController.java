package com.example.tnpslab;

import com.example.tnpslab.service.CalcReliabilityService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;
import java.util.stream.Collectors;

public class MainController implements CalcReliabilityController {
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
    @FXML private TextField finalValOfT;
    @FXML private TextField stepSize;

    @FXML private RadioButton lab1;
    @FXML private RadioButton lab2;
    @FXML private ToggleGroup toggleGroup;

    private Map<TextField, String> inputRatesMap;

    private CalcReliabilityService calcReliabilityService;

    @Override
    public void setCalcReliabilityService(CalcReliabilityService calcReliabilityService) {
        this.calcReliabilityService = calcReliabilityService;
    }

    @Override
    public String getIdLab1() {
        return this.lab1.getId();
    }

    @Override
    public String getIdLab2() {
        return this.lab2.getId();
    }

    public void initialize() {
        resultArea.setEditable(false);

        // Create and set default values
        inputRatesMap = new HashMap<>() {{
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

        Map<TextField, String> inputAllNumericsMap = new HashMap<>(Map.copyOf(inputRatesMap));
        inputAllNumericsMap.put(finalValOfT, "100");
        inputAllNumericsMap.put(stepSize, "1");

        // Set validators
        inputAllNumericsMap.forEach((textField, value) -> {
            textField.setText(value);
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[\\d*.]")) {
                    textField.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            });
        });

        // Radiobutton group
        this.toggleGroup = new ToggleGroup();
        lab1.setToggleGroup(toggleGroup);
        lab2.setToggleGroup(toggleGroup);
        lab2.setSelected(true);
    }

    private double getNumericFieldValue(TextField textField) {
        double result;
        if (textField.getText().equals("")) {
            result = 0.0;
            textField.setText(String.valueOf(result));
        } else {
            result = Double.parseDouble(textField.getText());
        }
        return result;
    }

    @FXML
    protected void onCalculateButtonClick() {

        RadioButton selectedButton = (RadioButton) toggleGroup.getSelectedToggle();

        Map<String, Double> inputRates = inputRatesMap.keySet()
                .stream()
                .collect(Collectors.toMap(TextField::getId, this::getNumericFieldValue));

        try {
            resultArea.setText(
                    calcReliabilityService.calculate(
                            selectedButton.getId(),
                            inputRates,
                            0.0,
                            getNumericFieldValue(finalValOfT),
                            getNumericFieldValue(stepSize)
                    )
            );
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
//Sum of probabilities = 1.0000000000000004
//Success Probability = 0.99625519532047
//Failure Probability = 0.0037448046795304224

// Number of iterations = 100
//Result Sum = 0.952345 ( 0.9523448971124018 )
//Success Probability = 0.951914 ( 0.951914135971483 )
//Failure Probability = 0.000431 ( 4.307611409187784E-4 )