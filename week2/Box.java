/*
 * 	�ǽ� 2���� ����
 * 	�����̸�: Box.java
 *	��     ��: �赵��
 *	��     ��: ���̹������а�
 *	��     ��: 201520893
 *	�������: 2020/04/07 23:59																	
 */
package week2;

public class Box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String PlanText = "ABCDEFGH";
		int[] index1 = {2, 6, 3, 1, 4, 8, 5, 7};
		int[] index2 = {4, 1, 3, 5, 7, 2, 8, 6};

		String rs1 = PBox(PlanText, index1);
		String rs2 = PBox(rs1, index2);
		
		System.out.println(rs1);
		System.out.println(rs2);
	}
	
	public static String PBox(String P, int[] index) {
		String result = "";
		if(P.length() != 8) return "err";
		
		// P box ���� �κ�
		for(int i=0; i<P.length(); i++) result += P.charAt(index[i]-1);
		
		return result;
	}
}
