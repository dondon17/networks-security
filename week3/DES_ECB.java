/*
 * 	실습 3주차 과제
 * 	파일이름: DES_ECB.java
 *	이     름: 김도운
 *	학     과: 사이버보안학과
 *	학     번: 201520893
 *	제출기한: 2020/04/21 23:59																	
 */
package week3;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DES_ECB{
	public static SecretKey key;
	
	public static void main(String[] args) {
		
		byte[] k = {(byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67
				, (byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF};
		key = new SecretKeySpec(k, 0, k.length, "DES");
		
		String plainText = "Now is the time for";
		try {
			System.out.println("Plain test : "+plainText);
			DES_encrypt(plainText);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void DES_encrypt(String data) throws Exception{
		Cipher cipher = Cipher.getInstance("DES/ECB/Nopadding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] plainToByte = data.getBytes();

		if(data.length() % 8 != 0) {
			int padsize = 8 - (data.length() % 8);
			byte[] padPKCS5 = new byte[data.length() + padsize];
			byte[] padANSI = new byte[data.length() + padsize];
			byte[] padZERO = new byte[data.length() + padsize];
			for(int i=0; i<data.length(); i++) {
				padPKCS5[i] = plainToByte[i];
				padANSI[i] = plainToByte[i];
				padZERO[i] = plainToByte[i];
			}
			for(int i=data.length(); i<data.length()+padsize; i++) {
				padPKCS5[i] = (byte)padsize;
				padZERO[i] = (byte)0x00;
				padANSI[i] = (byte)0x00;
				if(i == data.length()+padsize-1) padANSI[i] = (byte)padsize;
			}
			byte[] encPKCS5 = cipher.doFinal(padPKCS5);
			byte[] encANSI = cipher.doFinal(padANSI);
			byte[] encZERO = cipher.doFinal(padZERO);
			System.out.println("Padded with PKCS5 : "+ByteToHex(padPKCS5));
			System.out.println("Padded with ANSI  : "+ByteToHex(padANSI));
			System.out.println("Padded with ZERO  : "+ByteToHex(padZERO));
			System.out.println();
			System.out.println("Encryted byte(PKCS5) : "+ByteToHex(encPKCS5));
			System.out.println("Encryted byte(ANSI)  : "+ByteToHex(encANSI));
			System.out.println("Encryted byte(ZERO)  : "+ByteToHex(encZERO));
		}
		if(data.length() % 8 == 0) {
			byte[] padPKCS5 = new byte[data.length() + 8];
			byte[] padANSI = new byte[data.length() + 8];
			for(int i=0; i<data.length(); i++) {
				padPKCS5[i] = plainToByte[i];
				padANSI[i] = plainToByte[i];
			}
			for(int i=data.length(); i<data.length()+8; i++) {
				padPKCS5[i] = (byte)0x08;
				padANSI[i] = (byte)0x00;
				if(i == data.length()+7) padANSI[i] = (byte)0x08;
			}
			byte[] encPKCS5 = cipher.doFinal(padPKCS5);
			byte[] encANSI = cipher.doFinal(padANSI);
			byte[] encZERO = cipher.doFinal(plainToByte);
			
			System.out.println("Padded with PKCS5 : "+ByteToHex(padPKCS5));
			System.out.println("Padded with ANSI  : "+ByteToHex(padANSI));
			System.out.println("Padded with ZERO  : "+ByteToHex(plainToByte));
			System.out.println();
			System.out.println("Encryted byte(PKCS5) : "+ByteToHex(encPKCS5));
			System.out.println("Encryted byte(ANSI)  : "+ByteToHex(encANSI));
			System.out.println("Encryted byte(ZERO)  : "+ByteToHex(encZERO));
		}
	}
	
	// 바이트 배열을 16진수로 변환
	public static String ByteToHex(byte[] arr){
		StringBuilder sb = new StringBuilder(arr.length * 2);
		for(byte b : arr) sb.append(String.format("%02X ", b & 0xff));
		return sb.toString();
	}
}
