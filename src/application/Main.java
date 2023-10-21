package application;

import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stack<String> stack = new Stack<String>();
	private double accumulator = 0;
    private TextField display;
    private String operator = "";
    private double num1 = 0.0;
    private boolean startNewInput = true;
    private double tmp1;
    private double tmp2;
    TextField[] textFields = new TextField[5];

    public static void main(String[] args) {
        launch(args);
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
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "C", "=", "+"}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button button = createButton(buttonLabels[i][j]);
                grid.add(button, j, i + 5); // Adjust the row position
            }
        }

        Scene scene = new Scene(grid, 300, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Button createButton(String label) {
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
            } else if (text.equals("C")) {
                textFields[4].clear();
                startNewInput = true;
            } else if (text.equals("=") && !startNewInput) {
                double num2 = Double.parseDouble(textFields[4].getText());
                double result = calculate(num1, num2, operator);
                textFields[4].setText(String.valueOf(result));
                startNewInput = true;
            } else {
                operator = text;
                num1 = Double.parseDouble(textFields[4].getText());
                startNewInput = true;
            }
        });
        return button;
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
                } else {
                    return Double.NaN;
                }
            default:
                return num2;
        }
    }
}
