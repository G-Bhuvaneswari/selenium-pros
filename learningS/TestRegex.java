package learningS;

public class TestRegex {
	
	public static void main(String a[]) {
		//String n1 = "$29.90";
	//	String[] arr = n1.split("\\$");
		//System.out.println("Arr is "+arr[1]);
		//Double.valueOf(arr[1]);



String itemtotal = "$39.98";
String []spl=itemtotal.split("\\$");
System.out.println(spl[1]);
Double tprice = Double.valueOf(spl[1]);
System.out.println(tprice);




}

}
