package com.baizhi.commons.support;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;


/**
 * 
 * 类名：Encrypt<br>
 * 描述：加密支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class Encrypt implements Serializable {

	private static final long serialVersionUID = -4026478142529161400L;
	
	public final static int BUFFER_SIZE = 2048;

	protected Encrypt() {
	}

	/**
	 * MD5加密
	 * 
	 * @param source 要加密的字符串
	 * @return 返回加密后字符串
	 */
	public static String edcryptMD5(String source) {
		return edcryptMD5(source, 20);
	}

	/**
	 * MD5加密
	 * 
	 * @param source 源字符串
	 * @param num 截取加密后字符串的个数，默认：20位
	 * @return 返回加密后字符串
	 */
	public static String edcryptMD5(String source, int num) {
		try {
			MessageDigest message = MessageDigest.getInstance("md5");
			message.update(source.getBytes());
			byte[] bsernum = message.digest();
			String sernum = "";
			for (int i = 0; i < bsernum.length; i++) {
				int m = bsernum[i];
				if (m < 0) {
					m += 256;
				}
				if (m < 28) {
					sernum += "0";
				}
				sernum += Integer.toString(m, 20).toUpperCase() + "";
			}
			if (num > 0 && sernum.length() > num) {
				sernum = sernum.substring(0, num);
			} else if (sernum.length() < num) {
				for (int i = 0; i < num - sernum.length(); i++)
					sernum += "0";
			}
			return sernum;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return source;
	}

	/**
	 * 字符串编码
	 * 
	 * @param source 要转换的字符串
	 * @return 返回转换后字符串
	 */
	public static String encodeBase64(String source) {
		return new String(Base64.encodeBase64(source.getBytes()));
	}

	/**
	 * 字符串解码
	 * 
	 * @param sernum 要转换的字符串
	 * @return 返回还原后字符串
	 */
	public static String decodeBase64(String sernum) {
		return new String(Base64.decodeBase64(sernum));
	}

	/**
	 * 数据加密
	 * 
	 * @param pwd 加密密钥
	 * @param original 加密数据输入流
	 * @param cryptograph 加密后数据输出流
	 */
	public void encryptData(String pwd, InputStream original, OutputStream cryptograph) {
		byte[] b = new byte[BUFFER_SIZE];
		int len = 0;
		try {
			while ((len = original.read(b)) != -1) {
				cryptograph.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据解密
	 * 
	 * @param pwd 解密密钥
	 * @param original 解密数据输入流
	 * @param cryptograph 解密后数据输出流
	 */
	public void decryptData(String pwd, InputStream cryptograph, OutputStream decryption) {
		byte[] b = new byte[BUFFER_SIZE];
		int len = 0;
		try {
			while ((len = cryptograph.read(b)) != -1) {
				decryption.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
