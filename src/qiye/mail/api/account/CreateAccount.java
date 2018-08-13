package qiye.mail.api.account;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import rsa.HttpPost;
import rsa.RSASignatureToQiye;

public class CreateAccount {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// 根据企业实际修改，priKey为私钥，domain为域名，product即cid由网易提供
		String priKey = "30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100dfabd67bdeb5eb756e7f53c9529a8cf98df1da17edba96476426e46b309ac308d1b268685547c00e28dd68020585f18e06dbf827e3e3f3e1f35533d4627dc954421eceb3eb29470eabba08c55f2eb3afbdb0ccc1d132597f44a39084eed767614690af73c4eb084037afc1905369f8c6553cbdd18251b87507a6bb59ff876827020301000102818006bd8ff625ad07ce7f28f9266d05d94fbff654e339b7d0c59000180c1ee7db0ecdfaf968838169094433ffe967af34ab5a0b90fbeac338db4b50fb01e081f7ea32b2fd07a23e9382100064be1203bf5986b46405fe8c700db02515b5cd4b1dc48e693abf373423ed0d83429f153cc7a823ff8e8607f8d66ee638f96b393f1ec9024100f4276131e3899d6daca0664863407a708e47d1ccf0a8211af32e47033645765638025c60a97ea4db87b997cfb42945976b5d97900046764582965253c00e1153024100ea860b9061cfe9d676ae367454be79e450795902cd4cd4f4f2dd6417f34c7509ff28ae876205319816f8170ae9ac2b38cf3589db8fee2bcba08f5adec1d3cf5d0241009f31fe21f567098b357ff0b14a66046fd795e4aa685078258662aa52e1d430f0cedc5b377bcce3d9708a06fe9b4e3dde1957913787b669efb0d22b24089a239902400fbc10988e4771cbe6c88774c49ec6f4cf8564b87067c03df2f1719ebdbf1a77223c6b813fcd53677ddb0548c126c0fb9dc35ccd7359aa6c8e08303393d38f2d02404db24c942ad4319891d69b574366741f720a04f1a7493d0a5859ebbf38964510a925afd6fa511dcbe2ff127a4d4abe0c6f6297da0e1abce598e40f5904a05342";
		String domain = "abc.com";
		String product = "abc_com";

		String account_name = "2013250ww50132";
		String passchange_req = "1";
		String password = "93kI53K8jr2";
		String mobile = "15144306250";
		String nickname = "杨子叶";
		String pass_type = "0";
		String time = System.currentTimeMillis() + "";
		String unit_id = "default";

		String url = "https://apihz.qiye.163.com/qiyeservice/api/account/createAccount";
		String sign = "account_name=" + account_name + "&domain=" + domain
				+ "&mobile=" + mobile + "&nickname=" + nickname + "&pass_type="
				+ pass_type + "&passchange_req=" + passchange_req
				+ "&password=" + password + "&product=" + product + "&time="
				+ time + "&unit_id=" + unit_id;
		System.out.println(sign);
		sign = RSASignatureToQiye.generateSigature(priKey, sign);
		System.out.println(sign);
		String s_url = url + "?" + "account_name=" + account_name + "&domain="
				+ domain + "&mobile=" + mobile + "&nickname="
				+ URLEncoder.encode(nickname, "utf8") + "&pass_type="
				+ pass_type + "&passchange_req=" + passchange_req
				+ "&password=" + URLEncoder.encode(password, "utf8") + "&product=" + product + "&sign="
				+ sign + "&time=" + time + "&unit_id=" + unit_id;
		System.out.println(s_url);
		HttpPost hp = new HttpPost();
		String res = hp.post(s_url);
		System.out.print(res);
	}
}
