package testInet01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 
 * 	����ͨ����ѧϰ
 * 		InetAddress��
 * 
 */
public class InetAddressDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress iAddress = InetAddress.getByName("DESKTOP-RLAFMOV"); //ȷ���������Ƶ�IP��ַ�� 
		//System.out.println(iAddress);//DESKTOP-RLAFMOV/169.254.58.208
		
		String hostAddress = iAddress.getHostAddress();
		String hostName = iAddress.getHostName();
		System.out.println(hostAddress);
		System.out.println(hostName);
	}
}
