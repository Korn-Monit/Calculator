package application;

import java.util.Stack;

import Controller.CalculatorController;
//import Model.CalculatorModelInterface;
import Controller.CalculatorControllerInterface;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	private CalculatorControllerInterface con = new CalculatorController();
	private Stack<Double> stack = new Stack<Double>();
	private Stack<Double> stackTmp = new Stack<Double>();
	private String accumulator;
    private TextField display;
    private String operator = "";
    private double num1 = 0.0;
    private boolean startNewInput = true;
    private double tmp1, tmp2;
//    CalculatorModelInterface model;
    TextField[] textFields = new TextField[5];
    private double finalResult;

    public static void main(String[] args) {
        launch(args);
    }
    
    public void change(String accumulator) {
    	this.accumulator = accumulator;
    }

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Create an array of TextFields
        

        for (int i = 0; i < 5; i++) {
            textFields[i] = new TextField();
            textFields[i].setMinSize(200, 50);
            textFields[i].setEditable(false);
            grid.add(textFields[i], 0, i, 4, 1);
        }

        String[][] buttonLabels = {
        	    {"7", "8", "9", "+"},
        	    {"4", "5", "6", "-"},
        	    {"1", "2", "3", "*"},
        	    {"0", ",", "+/-", "/"},
        	    {"<>", "clr", "swap", "drop"}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Button button = createButton(buttonLabels[i][j]);
                grid.add(button, j, i + 5); // Adjust the row position
            }
        }

        Scene scene = new Scene(grid, 300, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Button createButton(String label){
        Button button = new Button(label);
        button.setMinSize(50, 50);

        button.setOnAction(e -> {
            String text = button.getText();

            if (text.matches("[0-9]")) {
                if (startNewInput) {
                    textFields[4].clear(); // Clear the first TextField
                    startNewInput = false;
                }
                textFields[4].appendText(text); // Append the clicked number to the first TextField
//                model.getAccumulator(Double.parseDouble(text));
            } 
//            else if (text.equals("C")) {
//                textFields[4].clear();
//                startNewInput = true;
//            } 
            else if (text.equals("<>")) {
            	String tmp = textFields[4].getText();
                shiftTextFields();
                startNewInput = true;
                
                push(Double.parseDouble(tmp));
                //tmp stack
                stackTmp.push(Double.parseDouble(tmp));
                con.change(stack);
//                push(Double.parseDouble(accumulator));
                
                System.out.print(stack);
//                model.push();
//                model.clearAccumulator();
            }
//            else if (text.equals("=") && !startNewInput) {
//                double num2 = Double.parseDouble(textFields[4].getText());
//                double result = calculate(num1, num2, operator);
////                finalResult = result;
//                textFields[4].setText(String.valueOf(result));
//                startNewInput = true;
//            } 
            else {
                operator = text;
                tmp1 = stack.pop();
                tmp2 = stack.pop();
                //result of calculation
                double result = calculate(tmp1, tmp2, operator);
                System.out.print(result);
                textFields[4].clear();
                textFields[4].setText(Double.toString(result));
                
                // Clear other TextFields (0 to 3)
                for (int i = 2; i < 4; i++) {
                    textFields[i].clear();
                }
                
                startNewInput = true;
            }
        });
        return button;
    }
    //insert element onto stack
    public double push(double input){
    	return stack.push(input);
    }
    
    
    
    
    
    private void shiftTextFields() {
//        String temp = textFields[4].getText();
        for (int i = 0; i < 4; i++) {
            textFields[i].setText(textFields[i+1].getText());
        }
        textFields[4].clear();
    }



    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } 
                else {
                    return Double.NaN;
                }
//            case ""
            default:
                return num2;
        }
    }
}