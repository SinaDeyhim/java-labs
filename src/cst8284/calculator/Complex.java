package cst8284.calculator;

public class Complex {
	private double real = 0;
	private double imag = 0;
	
	
	// Complex constructor that takes in a single string, e.g. "2-4i"
	public Complex(String cStr){
		this(cStr.split("(?=\\+)|(?=\\-)"));  // splits cStr at + or - into an array of strings having two elements
		// The first element of the resultant array will be the real portion, 
		// while the second is the imaginary portion.  This array is passed to the next constructor.
	}
	
	
	// Complex constructor that takes in an array of two strings from the above constructor
	// e.g. cStr[0]="2", cStr[1]="-4i"
	public Complex(String[] cStr){
		this((cStr[0]),(cStr[1]));
	}

	
	// Complex constructor that takes two separate strings as parameters, e.g. "2" and "-4i"
	public Complex(String r, String i){
		this(Integer.parseInt(r),Integer.parseInt(i.indexOf("i")==-1? i: i.substring(0,i.indexOf("i"))));
	}
	
	
	// Complex constructor that takes in two ints as parameters, e.g. 2 and -4
	public Complex(int r, int i){
		this((double)r,(double)i);
	}
	
	
	// Complex constructor that takes in two ints and stores them as floats, e.g. as 2.0 and -4.0
	public Complex(double r, double i){
		this.setReal(r);
		this.setImag(i);
	}
	
	//default Complex constructor; it should chain automatically 
	public Complex(){this(0,0);	}
	
	
	public double getReal() {
		return real;
	}

	
	public double getImag() {
		return imag;
	}
	
	public void setReal(double r) {
		real= r;
	}

	
	public void setImag(double i) {
		imag= i;
	}
	
	//NOTE: you must return a Complex type, not a String type.
	public Complex getComplex() {
		return this;
	}

	
	// on whether B is positive or negative.  (For example, it wouldn't make sense to return 3.0 +-2.0i; 
	// when the output should be 3.0 - 2.0i.)
	public String toString() {
		String sign=" + ";
		if (getImag()<0) {
			sign=" - ";
			setImag(getImag()*-1);
		}
		return getReal()+sign+getImag()+"i";
	}
	
	// bonus A to check and see if both real and imag are zero
		public boolean isZero() {
			return 0==getImag() && 0==getReal();
		}
	

	public Complex conjugate() {
		return new Complex(getReal(),-1*getImag());
	}


}
