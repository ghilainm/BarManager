package repn.services.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import repn.services.PasswordConvertionService;

@Service
public class PasswordConvertionServiceImpl implements PasswordConvertionService{
	
	public String getPasswordSHA(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		byte[] bytesOfMessage = password.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] thedigest = md.digest(bytesOfMessage);
		return new String(thedigest, "UTF-8");
	}
	
}
