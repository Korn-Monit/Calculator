
package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private String currentInput = "";
    private double result = 0;
    private String operator = "";
    //a JavaFX class that represents a text label or display element in the graphical user interface (GUI)
    private Label displayLabel;

    @Override
    //is a top-level container or window that represents a platform-specific window for your JavaFX application   
    public void start(Stage primaryStage) {
        try {
        	//set title of calculator        	
            primaryStage.setTitle("Calculator");
            //grid, each button represents number and operation form 0 to 9
            GridPane grid = new GridPane();
            //specifies that the content should be centered both horizontally and vertically within the cells of the GridPane
            grid.setAlignment(Pos.CENTER);
            //distance between each grid
            grid.setHgap(10);
            grid.setVgap(10);
            
            grid.setPadding(new Insets(10, 10, 10, 10));

            displayLabel = new Label("");
            //set space for displaying the result
            displayLabel.setMinWidth(230);
            displayLabel.setMinHeight(35);
            //color of border
            displayLabel.setStyle("-fx-border-color: lightgray;");
            displayLabel.setAlignment(Pos.CENTER_RIGHT);
            
            grid.add(displayLabel, 0, 0, 4, 1);

            String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
            };

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Button button = new Button(buttonLabels[i][j]);
                    button.setMinSize(50, 50);
                    button.setOnAction(e -> handleButtonClick(button.getText()));
                    grid.add(button, j, i + 1);
                }
            }

            Button clearButton = new Button("C");
            clearButton.setMinSize(50, 50);
            clearButton.setStyle("-fx-base: #ff3333;");
            clearButton.setOnAction(e -> clear());
            grid.add(clearButton, 3, 5);

            VBox vbox = new VBox(20);
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(grid);

            Scene scene = new Scene(vbox, 250, 350);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleButtonClick(String value) {
        if (value.matches("[0-9]") || value.equals(".")) {
            currentInput += value;
            displayLabel.setText(currentInput);
        } else if (value.matches("[/*\\-+]")) {
            if (!currentInput.isEmpty()) {
                if (!operator.isEmpty()) {
                    calculate();
                }
                operator = value;
                result = Double.parseDouble(currentInput);
                currentInput = "";
            }
        } else if (value.equals("=")) {
            calculate();
            operator = "";
        }
    }

    private void calculate() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    result += secondOperand;
                    break;
                case "-":
                    result -= secondOperand;
                    break;
                case "*":
                    result *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result /= secondOperand;
                    } else {
                        displayLabel.setText("Error");
                        currentInput = "";
                        result = 0;
                        operator = "";
                        return;
                    }
                    break;
            }
            displayLabel.setText(Double.toString(result));
            currentInput = "";
        }
    }

    private void clear() {
        currentInput = "";
        result = 0.0;
        operator = "";
        displayLabel.setText("");
    }

public static void main(String[] args) {
        launch(args);
    }
}