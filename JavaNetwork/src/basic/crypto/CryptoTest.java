package basic.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CryptoTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, 
	InvalidKeyException, 
	NoSuchPaddingException, 
	InvalidAlgorithmParameterException, 
	IllegalBlockSizeException,
	BadPaddingException,
	UnsupportedEncodingException {
		String str = "Hello, world!";
		
		System.out.println("MD5:"+CryptoUtil.md5(str));
		System.out.println("SHA-256:"+CryptoUtil.sha256(str));
		System.out.println("SHA-512:"+CryptoUtil.sha512(str));
	
		System.out.println("------------------------------------------------");
		AES256Util aes256 = new AES256Util();
		String temp = "Hello, World!";
		String strTest = aes256.encrypt(temp);
		System.out.println("원본값:"+temp);
		System.out.println("암호화 값 : "+strTest);
		System.out.println("복호화 값"+aes256.decrypt(strTest));
	}

}
