

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindNumFromString {

	public FindNumFromString() {
		// TODO Auto-generated constructor stub
	}
	
	public static Double findNum(String string){
		Pattern pattern=Pattern.compile("[^0-9]");
		Matcher matcher=pattern.matcher(string);
		String s=matcher.replaceAll("").trim();
		System.out.println(s);
		return Double.parseDouble(s);
	}

	public static double div(double a,double b,int scale) throws IllegalAccessException{
		//如果精确范围小于0，抛出异常信息
        if(scale<0){         
            throw new IllegalAccessException("精确度不能小于0");
        }
		BigDecimal b1=new BigDecimal(Double.valueOf(a));
		BigDecimal b2=new BigDecimal(Double.valueOf(b));
		return b1.divide(b2, scale, 1).doubleValue();
	}
	public static void main(String[] args) {
		String string="love1next25csdn6javaeye";
		String string2="sdwdasd3ses32weqweqw";
		try {
			System.out.println(div(findNum(string), findNum(string2), 4));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
