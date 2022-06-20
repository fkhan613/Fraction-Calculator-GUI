/***************************************
 * File: Fraction.java 	   
 * Date Created: 2022 / 03 / 28 
 * Author: Farhan Khan 	   
 * Program Description: This class   
 * contains fields of a fraction(num, den). This class
 * can do various operations that many individuals may find
 * very tideaus for example, adding, subtracting, multiplying
 * dividing, reducing of a fraction etc.
 ***************************************/

class Fraction {
	
	private int num, den;
	
	//Default constructor 
	public Fraction() {this(1, 1);}

	//Custom constructor
	public Fraction(int n, int d) {
		setNum(n);
		setDen(d);
	}
	
	//Copy Constructor
	public Fraction(Fraction f) {this(f.getNum(), f.getDen());}
	
	//Getters & Setters
	public int getNum() {return this.num;}
	public int getDen() {return this.den;}
	public void setNum(int v) {this.num = v;}
	public void setDen(int d) {this.den = checkDen(d);}
	
	//toString
    public String toString(){return this.num + " / " + this.den;}
	
	//this method will invert and return the numerator and denominator
    public Fraction invert(){return new Fraction(this.den, this.num);}

    //this method will reduce the fields of the fraction class
    public void reduce(){
        int divisor = 1;

        //loop for for the lenght of the numerator
        for(int i = Math.abs(this.num); i>=1; i--){

            //if a common divider is found, set "divisor" to "i"
            if(this.num % i == 0 && this.den % i == 0){
                divisor = i;
                break;
            }
        }
        //if the divisor is not 0, that means there is a common divider
        if(divisor != 1){
            //reduce the numerator and denominator
            setNum(this.num/divisor);
            setDen(this.den/divisor);
        }
    }

    //this method will return the divided value of the fraction
    public double toDecimal(){return (double)this.num/this.den;}

    //this method calculates and returns the sum
    public Fraction add(Fraction f){
        return new Fraction(((this.num * f.getDen()) + (f.getNum() * this.den)), (this.den * f.getDen()));
    }

    //this method calculates and returns the difference
    public Fraction subtract(Fraction f){
        return new Fraction(((this.num * f.getDen()) - (f.getNum() * this.den)), (this.den * f.getDen()));
    }

    //this method calculates and returns the product
    public Fraction times(Fraction f){
        return new Fraction((this.num * f.getNum()), (this.den * f.getDen()));
    }

    //this method calculates and returns the quotient
    public Fraction divide(Fraction f){
        return new Fraction((this.num * f.getDen()), (this.den * f.getNum()));
    }
    
    //this method prints the info of the Fraction class
    public static void info(){

        System.out.println("Information: \n\nClass: Fraction.java \n\nMethods:");
        System.out.println("public Fraction()");
        System.out.println("public Fraction(int n, int d)");
        System.out.println("public Fraction(Fraction f)");
        System.out.println("public int getNum()");
        System.out.println("public int getDen()");
        System.out.println("public void setNum(int n)");
        System.out.println("public void setDen(int d)");
        System.out.println("public Fraction invert()");
        System.out.println("public void reduce()");
        System.out.println("public double toDecimal()");
        System.out.println("public Fraction add(Fraction f) \npublic Fraction subtract(Fraction f)" +
        "\npublic Fraction times(Fraction f) \npublic Fraction divide(Fraction f)");
        System.out.println("public  String toString()");
        System.out.println("public void info()");
        System.out.println("private int checkDen(int d)");
    }

	//this method checks the whole fraction for formating errors
	private int checkDen(int d) {
        
        //check if the denominator is 0
        if(d == 0) {
			System.err.println("\nCan't have a denominator of 0. Can't you math?👎\n");
			return 0;
		}
        //check if both values are negative, if so make them positive
        else if (this.num < 0 && d < 0) {setNum(this.num*-1); d = Math.abs(d);}
        //check if only the denominator is negative, if so flip the signs
        else if(this.num > 0 && d < 0) {setNum(this.num*-1); d = Math.abs(d);}
		
        return d;
	}

    //tester method
    public static void test(){

        Fraction f = new Fraction(6, -12);
    	Fraction f1 = new Fraction(500, 100);
		Fraction f2 = new Fraction(24, 5);
		Fraction f3 = new Fraction(23, 0);
		Fraction f4 = new Fraction(23, -1);
		Fraction f5 = new Fraction(0, 23);
		Fraction f6 = new Fraction(-1, 23);
		Fraction f7 = f1.invert();
		Fraction f8 = f5.invert();
		Fraction f9 = f6.invert();
		Fraction f10 = new Fraction(-500, 100);
        Fraction copy_f = new Fraction(f.invert());

        f1.reduce();
		System.out.println(f1 + "\nExpected: 5 / 1\n");
		System.out.println(f3 + "\nExpected: 23 / 1\n");
		System.out.println(f4 + "\nExpected: -23 / 1\n");
		System.out.println(f7 + "\nExpected: 100 / 500\n");
		System.out.println(f8 + "\nExpected: 23 / 1\n");
		System.out.println(f9 + "\nExpected: -23 / 1\n");
		f10.reduce();
		System.out.println(f10 + "\nExpected: -5 / 1\n");
        System.out.println(f + "\nExpected: -6 / 12\n");
        f.reduce();
        System.out.println(f + "\nExpected: -1 / 2\n");
        System.out.println(f.toDecimal() + "\nExpected: -0.5\n");
        System.out.println(f.add(new Fraction(2, 3)) + "\nExpected: 1 / 6\n\n");
        System.out.println(copy_f + "\nExpected: -12 / 6\n");
        copy_f.reduce();
        System.out.println(copy_f + "\nExpected: -2 / 1\n");
        System.out.println(copy_f.toDecimal() + "\nExpected: -2.0\n");
        System.out.println(copy_f.divide(new Fraction(1, 2)) + "\nExpected: -4 / 1\n");
         
        Fraction.info();
    }
}
