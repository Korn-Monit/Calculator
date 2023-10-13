package Model;

import Model.CalculatorModelInterface;

public interface CalculatorModelInterface {
	public void push(int input);
	
	public int pop(); 
	
	public void swap();
	
	public void clear();
	
	public void clearAccumulator();
	
	public int Calculate(String input1); 
}
