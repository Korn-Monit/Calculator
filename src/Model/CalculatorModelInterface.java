package Model;

import Model.CalculatorModel;

public interface CalculatorModelInterface {
	public void push(int input);
	
	public int pop(); 
	
	public void swap();
	
	public void clear();
	
	public void clearAccumulator();
	
	public int Calculate(String input1); 
	
//	public void hello(); 
	
	// quelque fonctions sont pas neccessaire ex: push
}
