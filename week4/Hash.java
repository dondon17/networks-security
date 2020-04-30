/*
 * 	�ǽ� 4���� ����
 * 	�����̸�: Hash.java
 *	��     ��: �赵��
 *	��     ��: ���̹������а�
 *	��     ��: 201520893
 *	�������: 2020/04/28 23:59																	
 */
package week4;

import java.security.*;

public class Hash {

	public static void main(String[] args) throws DigestException {
		// TODO Auto-generated method stub
		String plaintext = "SHA-2 is a set of cryptographic hash functions "
				+ "(SHA-224, SHA-256, SHA-384, SHA-512, SHA-512/224, SHA-512/256) "
				+ "designed by the U.S. National Security Agency (NSA) "
				+ "and published in 2001 by the NIST "
				+ "as a U.S. Federal Information Processing Standard (FIPS)."
				+ " SHA stands for Secure Hash Algorithm. "
				+ "SHA-2 includes a significant number of changes from its predecessor, SHA-1."
				+ " SHA-2 currently consists of a set of six hash functions "
				+ "with digests that are 224, 256, 384 or 512 bits.";
		
		System.out.println("Plain text : "+plaintext+"\n");
		System.out.println("**********create message digest(hash value) in MD5, SHA-1, SHA-256, SHA-512**********");
		System.out.println("MD5        : "+Hash_func(plaintext, "MD5"));
		System.out.println("SHA-1      : "+Hash_func(plaintext, "SHA-1"));
		System.out.println("SHA-256    : "+Hash_func(plaintext, "SHA-256"));
		System.out.println("SHA-512    : "+Hash_func(plaintext, "SHA-512"));
	}
	
	// hash function �ۼ� �κ�
	public static String Hash_func(String plain, String func) throws DigestException {
		String result = "";
		try {
			// ���޹��� text�� �ؽ� �Լ��� �°� ����Ʈ ������ ��������Ʈ�� ��ȯ.
			MessageDigest md = MessageDigest.getInstance(func);
			md.update(plain.getBytes());
			byte hashval[] = md.digest();
			
			// byte �迭 ������ hex string���� ��ȯ
			StringBuffer sb = new StringBuffer();
			for(byte b : hashval)
				sb.append(String.format("%02x", b&0xFF)); 
			
			result = sb.toString();
		}
		catch(NoSuchAlgorithmException e) {
			throw new DigestException("couldn't make digest of partial content");
		} 
		return result;
	}
}
