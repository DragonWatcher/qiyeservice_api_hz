package qiye.mail.tool;
import java.io.UnsupportedEncodingException;

import rsa.RSATool;

/**
 * 单点登录至指定邮件，支持极速6及以上版本
 */
public class LoginFolder {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//企业对应的私钥
		String priKey = "30820276020100300d06092a864886f70d0101010500048202603082025c020100028181008c44b400433fd29cc1118231881e59d4af7c7035fd0a81fa861aa6ba4c9a2d96ac9697cd946f34714f8c4da228bf07e7c2f8cf6ee24e5bab371b73a2ff435522eb12a11b880767c90c9faebab666a3ffbb4fa8fc2286f59e1db176d85ef86f9b4d047d31aa177970f52bca2315a80c0b031893efc8466c2db7437b4e3a62093d020301000102818030ec3d83e1f0bebaa1b4439e97054efb99816379d119fb1fafea57c09ebb1faf6fdece6f8b9805c887a03deb931e9dd93ded9e1be49ec3e641c03762e0795195e8acae54f80fc530be1d5393ea794fab956d56e2cfd1a60dfaf6339f19de962b1b2bb62924a93e46a0660163a529433f42a549089fb2bc6b3e9a9e09bce62c59024100dad36a5f53a8a39c3be38c8e75a4cbfa2fd896694619732b43820cb75abde3b3ea8200d11a49fbb6da1b0b95643b551df65611547d9bff4af81b772e8d678313024100a418e0a8bc3c3678e405118fa8ec051428bddf6f48855db7da4b9053cd15e0ef3b5e85316140bf28088306f9509af6d8ea08f589a7c38892414c06da3a517c6f024003bfe9abb68046457015471c4dd1c4190666dcb4f3198e8aa83e7b3f4d13c1ea1c539bf5f950593ad9e3eabfe596caaf97c003ce01d5017be4627c19551cf7f7024005cb4313722206225a9abb360156e40f0429401c63c921b7fe2330e36498632acf43d51c1b3cf802e7da0883010f97abad07c7f3a652c71db2e486516a41ba4d02410089010c26a68a70d2eb6b9ad24afed90a5974e247f0fe0a22b819574cd7d03604b14e886910599e39e2f422548b956fb00321f9dd76e3582494b77f5a9bd32636";

		String account_name = "zhangsan";
		String domain = "abc.com";
		String time = System.currentTimeMillis() + "";
		String module = "mbox.ListModule|{\"fid\":1,\"order\":\"date\",\"desc\":true}";

                String url = "https://entryhz.qiye.163.com/domain/oa/Entry";
                String src = "domain=" + domain + "&account_name=" + account_name + "&time=" + time + "&module=" + module;
		
		RSATool tool = new RSATool();
		String enc = tool.generateSHA1withRSASigature(account_name + domain + time, priKey);

		String postURL = url + "?" + src + "&enc=" + enc;
		System.out.print(postURL);
	}
}
