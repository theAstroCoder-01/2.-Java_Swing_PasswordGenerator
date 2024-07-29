package PasswordGenerator;

import java.util.Random;

// This is the backEnd.

public class BackEnd {

	private static final long serialVersionUID = 1L;
	
	public static final String lowercase_characters = "abcdefghijklmnopqrstuvwxyz";
	public static final String uppercase_characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numbers = "0123456789";
	public static final String special_symbols = "!@#$€%^&*()-_=+[]{};:,.<>/?";
	
	//this random instance allows us to create a random number
	private final Random random;
		
	
	//the constructor
	public BackEnd(){random = new Random();}
	
	//'length' of the password to be generated (it is taken by the user)
	public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, 
				boolean includeNumbers, boolean includeSpecialSymbols) {
			
			StringBuilder passwordBuilder = new StringBuilder();
			
			String validCharacters = "";
			if(includeUppercase) validCharacters += uppercase_characters; 
			if(includeLowercase) validCharacters += lowercase_characters;
			if(includeNumbers) validCharacters += numbers;
			if(includeSpecialSymbols) validCharacters += special_symbols;
		
		for(int i = 0; i < length; i++) {
			//this generates the random index
			int randomIndex = random.nextInt(validCharacters.length());
			
			char randomChar = validCharacters.charAt(randomIndex);
			
			passwordBuilder.append(randomChar);
	
		}
		
	//this statement returns the result
	return passwordBuilder.toString();
	
	}
}
	
	
	
	
