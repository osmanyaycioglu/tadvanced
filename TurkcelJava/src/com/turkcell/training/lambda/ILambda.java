package  com.turkcell.training.lambda;

@FunctionalInterface
public interface ILambda {
	String abcd(String str);

	static String formatStr(ILambda lmd,String str) {
		return lmd.abcd(str).toUpperCase();
	}
	
	default String upper(String str) {
		return abcd(str).toUpperCase();
	}
	

	static String lower(String str) {
		return str.toLowerCase();
	}
	
	default String cont(String str) {
		return str + abcd(str);
	}
	
}
