package qiye.mail.api.account;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import rsa.HttpPost;
import rsa.RSASignatureToQiye;

public class UpdatePassword {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//根据企业实际修改，priKey为私钥，domain为域名，product即cid由网易提供
		String priKey = "30820276020100300d06092a864886f70d0101010500048202603082025c0201000281810098644730d2305df39eec5c12504d747b0c2ac0d3a0dc1368b492f9be768aefa4259a7bf67229a9392ae8837d076c98ff71a760c3b6d5d50b6cb6608cc55fee1e47487f7e49a4bc60eb1738a01a75885f046843d239e51ba1ce83967ab93dd275a4905d1dd4bd4e8c9dced3198bdc5097235c5fbf811b3ec27abe49db0e8cfb51020301000102818032860c94431b860a9f45fdc0949f195f32497a64af90475f0f7f2b0dda7f75b416438195d383bc7717a2bef554e0cc58e47579bf697ebb836e27891b22d50b3cbb9a76de897a19e93966ffaabc46deaf30b34fe3b219ebd710a30d623c72b1dd3b3ad5806c51a267f5d4ece44569ac8e86ab1778165f66c8a84c235c66f85801024100cc3b622db331b36d84384230ff1d1f45b3a940b17ef26311e619d30c4a6db7ec5716ae5f9e41aeb320fd8507f3c6bb38c01d36bd6b69d8f2f4fd0d967ae9dd39024100bf04fab600db6e54d2e2d085c6af2f87fac144758995ff3e228b578a378548b907d1b595d985a16ee1851d22b8b89fa3e92a721d1144d915d935994add4a26d902400e62805fc7a75083fe3418356b4299d946f63ce04398bef19bcb65da0fc3fa9862e9ee0e3e0f5246bba41fa297c0ff9ed7a93719d05efc30e0a0923c6f1bd9c1024100b1c373817ea8b6337011add660c0d52de958845a11912a786b735b23006a23f435679e61f68d1a5f72b60b182de97a7ef25512df241bfb1e0f068742994f11790240400f39400cd38ae9e994f30c9b53e5a8fa20e6dc7c07e123978bb527e8c75afd595bedd5f61a97f5e59ff85e008b8906824cdac97a197ac0a7c47e6da6a0ec6f";
		String domain = "abc.com";
		String product = "abc_com";
		
		String account_name = "zhansan";
		String passchange_req = "0";
		String password = "1qw@#er4";
		String time = System.currentTimeMillis() + "";
		
		String url = "https://apihz.qiye.163.com/qiyeservice/api/account/updatePassword";
		String sign = "account_name=" + account_name + "&domain=" + domain
				+ "&passchange_req=" + passchange_req + "&password=" + password
				+ "&product=" + product + "&time=" + time;
		System.out.println(sign);
		sign = RSASignatureToQiye.generateSigature(priKey, sign);
		System.out.println(sign);
		url = url + "?" + "account_name=" + account_name + "&domain=" + domain
				+ "&passchange_req=" + passchange_req + "&password="  + URLEncoder.encode(password, "utf8")
				+ "&product=" + product + "&sign=" + sign + "&time=" + time;
		System.out.println(url);
		HttpPost hp = new HttpPost();
		String res = hp.post(url);
		System.out.print(res);
		
	}

}
