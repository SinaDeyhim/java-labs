package cst8284.calculator;
// importing math for the first divide method, but it is commented as the bonus methods is used 
// import java.lang.Math;

public class ComplexCalculator {

	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex c;  // stores result of current calculation for use in next calculation

	public ComplexCalculator(Complex c1, Complex c2){

		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /");
		char mathOp = op.nextLine().charAt(0);

		switch (mathOp){
		case '+':
			c = plus(c1, c2);
			break;
		case '-':			
			c = subtract(c1, c2);
			break;
		case '*':
			c = multiply(c1, c2);
			break;
		case '/':
			c = divide(c1, c2);
			break;
		default:
			System.out.println("Unknown operation requested");
		}

	}

	public Complex plus(Complex c1, Complex c2){
		double real = c1.getReal() + c2.getReal();
		double imag = c1.getImag() + c2.getImag();
		c = new Complex(real, imag); // save the result to this class's Complex number
		return(c);
	}


	public Complex subtract(Complex c1, Complex c2){
		double real = c1.getReal() - c2.getReal();
		double imag = c1.getImag() - c2.getImag();
		c = new Complex(real, imag); 
		return(c);

	}

	public Complex multiply(Complex c1, Complex c2){
		double real = c1.getReal() * c2.getReal() - c1.getImag() * c2.getImag();
		double imag = c1.getReal() * c2.getImag() + c2.getReal() * c1.getImag();
		c = new Complex(real, imag); 
		return(c);

	}

	/*public Complex divide(Complex c1, Complex c2){		
		if (c2.isZero()) {
			System.out.println("Divide-by-zero error detected");
			return new Complex();
		} else {
			double real = (c1.getReal() * c2.getReal() + c1.getImag() * c2.getImag())/(Math.pow(c2.getReal(),2)+Math.pow(c2.getImag(),2));
			double imag = (c2.getReal() * c1.getImag() - c1.getReal() * c2.getImag())/(Math.pow(c2.getReal(),2)+Math.pow(c2.getImag(),2));
			c = new Complex(real, imag); 
			return(c);
		}

	}*/ 


	public Complex divide(Complex c1, Complex c2){
		double conj=multiply(c2, c2.conjugate()).getReal();
		if (multiply(c2, c2.conjugate()).isZero()) {
			System.out.println("Divide-by-zero error detected");
			return new Complex();
		} else {
			Complex num= multiply(c1, c2.conjugate());
			c= new Complex (num.getReal()/conj, num.getImag()/conj);
			return c;
		}
		
	}
	


 
	public Complex getComplexResult(){
		return c;
	}


	public String toString(){
		return getComplexResult().toString();
	}

}
