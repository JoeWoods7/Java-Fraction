import java.util.Formatter;
public class Frac{

public Frac(int a, int b){
setNumDem(a,b);
}
	
	public setNumDem(int a, int b){
		numerator = a;
		denominator= b;
	}

public Frac(double a){
frac = DoubleToFraction(a);
}
private static int numerator, denominator;
private String frac;

String getFrac(){
return frac;}

double getDecimal (){
return numerator/(double)denominator;
}

int getNumerator(){
return numerator;}

int getDenominator(){
return denominator;}

public static void main (String[]args){
Frac a;

if(args.length >1){
a = new Frac(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
System.out.println(a.numerator+"/"+a.denominator+"\n"+a.getDecimal());
}
else {a = new Frac(Double.parseDouble(args[0]));
System.out.println(a.getFrac());
}

}
//-----------
static String DoubleToFraction(double num)
    {
double epsilon = 0.0001;
int maxIterations = 20;
 
        double[] d = new double[maxIterations + 2];
        d[1] = 1;
        double z = num;
        double n = 1;
        int t = 1;

        int wholeNumberPart = (int)num;
        double decimalNumberPart = num - (double)(wholeNumberPart);

        while (t < maxIterations && Math.abs(n / d[t] - num) > epsilon)
        {
            t++;
            z = 1 / (z - (int)z);
            d[t] = d[t - 1] * (int)z + d[t - 2];
            n = (int)(decimalNumberPart * d[t] + 0.5);
        }

        String result = String.format((wholeNumberPart > 0 ? wholeNumberPart + " " : "") + "%1$d/%2$d", (int)n, (int)d[t] );
	
	    setNumDem((int)n, (int)d[t]);
	return result;
    }


}
