/*
 * 	�ǽ� 1���� ����
 * 	�����̸�: Transposition.java
 *	��     ��: �赵��
 *	��     ��: ���̹������а�
 *	��     ��: 201520893
 *	�������: 2020/03/31 23:59																	
 */
package week1;

public class Transposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Plaintxt = "Common sense is not so common.";
		String Cipertxt = transposition_encrypt(Plaintxt, 8);
		
		System.out.println(Plaintxt);
		System.out.println(Cipertxt);
	}

	public static String transposition_encrypt(String txt, int key) {
		// TODO Auto-generated method stub
		

		int col = 0;
		String result = "";
		String row;
		
		for(int i = 0; i < key; i++)
			for(int j = i; j < txt.length(); j+=key) 
				result = result+txt.charAt(j);
		return result;
	}
}
