package Controller;
import java.util.Stack;

import Controller.CalculatorControllerInterface;
import Model.CalculatorModel;
import Model.CalculatorModelInterface;
import application.Main;

public class CalculatorController implements CalculatorControllerInterface{
	public Stack<Double> stack = new Stack<Double>();
	String accumulator;
	private CalculatorModel getStack;
	private Main acc;
	
	public void pushStackToModel(){
		
	}
	
	//this one is to get the stack from GUI
	public void change(Stack<Double> stack) {
	    this.stack = stack;
	}

	//get accumulator from model
//	public void change(String accumulator) {
//		this.accumulator = accumulator;
//	}
	
	//pass accumulator to GUI
//	public void passAccumulatorToGUI(){
//		acc.change(accumulator);
//	}
	
	//this one is to pass the stack to model
	public void change() {
		getStack.getStackFromController(stack);
	}
	
	
	
	
}
