package com.zuozuo.base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class SafeUtil {

	public final static String SALT = "lich-king";

	public static String getSaltPassword(String password) {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
		String dest = SALT + password;
		sha.update(dest.getBytes());
		String digest = Hex.encodeHexString(sha.digest());
		return digest + "$" + SALT;
	}
}