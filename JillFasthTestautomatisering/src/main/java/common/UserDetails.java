package common;


import java.util.Random;

public class UserDetails {

	private String lettersNumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private Random rand =new Random();
	
	public String ranUser() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++)
		builder.append(lettersNumbers.charAt(rand.nextInt(lettersNumbers.length())));
		return builder.toString() +"@test.se";
	}
		public String ranUser101() {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 101; i++)
			builder.append(lettersNumbers.charAt(rand.nextInt(lettersNumbers.length())));
			return builder.toString();
	
	}
	public String password() {
		return "Mak<r0ner";
	}
	public String empty() {
		return "";
	}
	public String saved() {
		return "sara.tvaa@sara.com";
	}
}

