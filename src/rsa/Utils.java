package rsa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Utils {
	private static final int ENCRYPT_LENGTH = 117;

	private static final int DECRYPT_LENGTH = 256;

	public static void createKeyPair() {
		RSATool tool = new RSATool();
		tool.genRSAKeyPair();
	}

	public static String encrypt(String priKey, String source)
			throws UnsupportedEncodingException {
		String param = URLEncoder.encode(source, "utf-8");
		RSATool tool = new RSATool();
		StringBuffer enc = new StringBuffer();
		int index = 0;
		int paramLength = param.length();
		while (index < paramLength) {
			String tmp = null;
			if ((index + ENCRYPT_LENGTH) < paramLength) {
				tmp = param.substring(index, index + ENCRYPT_LENGTH);
			} else {
				tmp = param.substring(index);
			}

			enc.append(tool.encryptWithPriKey(tmp, priKey));
			index += ENCRYPT_LENGTH;
		}

		return enc.toString();
	}

	public static String decrypt(String pubKey, String enc)
			throws UnsupportedEncodingException {
		RSATool tool = new RSATool();
		int times = enc.length() / DECRYPT_LENGTH;
		StringBuffer dec = new StringBuffer();
		for (int i = 0; i < times; i++) {
			String tmp = enc.substring(i * DECRYPT_LENGTH, (i + 1)
					* DECRYPT_LENGTH);
			dec.append(tool.decryptWithPubKey(tmp, pubKey));
		}

		return URLDecoder.decode(dec.toString(), "utf-8");
	}

	public static String getKey(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		StringBuffer keyBuffer = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			keyBuffer.append(line);
		}

		return keyBuffer.toString();
	}
}
