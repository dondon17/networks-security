/*
 * 	실습 1주차 과제
 * 	파일이름: Caesar.java
 *	이     름: 김도운
 *	학     과: 사이버보안학과
 *	학     번: 201520893
 *	제출기한: 2020/03/31 23:59																	
 */
package week1;

public class Caesar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Plaintext = "The quick brown fox jumps over the lazy dog.";
		String Cipertext = Caesar(Plaintext, 2, "encrypt");
		String rst = Caesar(Cipertext, 2, "decrypt");
		
		System.out.println(Plaintext);
		System.out.println(Cipertext);
		System.out.println(rst);
	}

	public static String Caesar(String txt, int key, String mode) {
		// TODO Auto-generated method stub
		
		String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String TXT= txt.toUpperCase();
		String result = "";		
		
		if(mode.equals("decrypt")) key = (word.length() - key)%word.length();
		else if(mode.equals("encrypt")) key = key%word.length();
		else return "err";
		
		// Caesar 암호 구현 부분
		char[] tmp = TXT.toCharArray();
		for (int i = 0; i < TXT.length(); i++) {
			if(tmp[i] < 'A' || tmp[i] > 'Z') continue;
			else if((int)tmp[i]+key > 90) tmp[i] = (char)((int)tmp[i]+key-26);
			else tmp[i] = (char)((int)tmp[i]+key);
		}
		
		result = new String(tmp);
		return result;
	}
}
