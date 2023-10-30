package Model;

import java.util.Stack;

import Controller.CalculatorControllerInterface;

import java.util.Iterator;
import java.util.Scanner;

public class CalculatorModel implements CalculatorModelInterface{
    
    // Declare the stack as a class-level variable
    public Stack<Double> stack = new Stack<>();
    public String accumulator;
    public double tmp1, tmp2, result;
    public CalculatorControllerInterface change;
    
    // get controller from controller
    public void getStackFromController(Stack<Double> stack){
    	this.stack = stack;
    }
    
    // Operation on the last two operands
    public void addition() {
    	tmp1 = pop();
    	tmp2 = pop();
    	result = tmp1 + tmp2;
    	
    	accumulator = String.valueOf(result);
    	
//    	change.change(accumulator);
    	
    }
    
    public void substaction() {
    	tmp1 = pop();
    	tmp2 = pop();
    	result = tmp1 - tmp2;
    	
    	accumulator = String.valueOf(result);
    	
//    	change.change(accumulator);
    }
    
    public void multiplication() {
    	tmp1 = pop();
    	tmp2 = pop();
    	
    	result = tmp1 * tmp2;
    	
    	accumulator = String.valueOf(result);
//    	change.change(accumulator);
    }
    
//    public void division() {
//    	tmp1 = pop();
//    	tmp2 = pop();
//    	
//    	result = tmp1 / tmp2;
//    	accumulator = String.valueOf(result);
//    	
//    	change.change(accumulator);
//    }
    
    //function to push onto stack
    public void push(double input) {
    	stack.push(input);
    }
    
//    public void hello() {
//    	System.out.printf("Hello World !"); 
//    }
    
    //function to pop
    public double pop() {
    	return stack.pop();
    }
    //swap operand in stack
    public void swap() {
    	double tmp1 = pop();
    	double tmp2 = pop();
    	
    	push(tmp1);
    	push(tmp2);
    }
    //clear the stack
    public void clear(){
    	stack.clear();
    }
    //function to clear accumulator
    
//    public void clearAccumulator() {
//    	accumulator = 0;
//    }
    
    
    
    
    
    
    
//    public int Calculate(String input1) {
//  
//
//        if (input1.equals("+") || input1.equals("-") || input1.equals("*") || input1.equals("/")) {
//            if (stack.size() < 2) {
//                throw new IllegalArgumentException("Not enough operands in the stack for the operator: " + input1);
//            }
//
//            int operand2 = pop();
//            int operand1 = pop();
//
//            if (input1.equals("+")) {
//                accumulator = operand1 + operand2;
//            } else if (input1.equals("-")) {
//                accumulator = operand1 - operand2;
//            } else if (input1.equals("*")) {
//                accumulator = operand1 * operand2;
//            } else if (input1.equals("/")) {
//                accumulator = operand1 / operand2;
//            }
//
//            // Store the result in the stack
//            push(accumulator);
//            push(operand1);
//            push(operand2);
//        } else {
//            // If it's not an operator, assume it's a number and push it onto the stack
//        	push(Integer.parseInt(input1));
//        }
//
//        return accumulator;
//    }
    

//    public static void main(String[] args) {
//    	CalculatorModel var1 = new CalculatorModel();
//    	
//    	
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//
//            System.out.print("Input number or operator (+, -, *, /), \ntype 'q' to quit, \n'k' to clear accumulator, \n's' to swap the order of data on stack, \n'c' to print the elements on stack: ");
//            String input = scanner.nextLine();
//
//            if (input.equals("q")) {
//                break;
//            }
//            else if(input.equals("k")) {
//            	var1.clearAccumulator();
//            	System.out.print(var1.accumulator);
//            }
//            else if(input.equals("s")) {
//            	var1.swap();
//            	Iterator<Integer> iterator= var1.stack.iterator();
//                while (iterator.hasNext()) {
//                    int element = iterator.next();
//                    System.out.println(element);
//                }
//            }
//            else if(input.equals("c")){
//            	Iterator<Integer> iterator= var1.stack.iterator();
//                while (iterator.hasNext()) {
//                    int element = iterator.next();
//                    System.out.println(element);
//                }
//            }
//
//            try {
//                int result = var1.Calculate(input);
//                System.out.println("Accumulator: " + result);
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a number or a valid operator.");
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        scanner.close();
//    }
}
