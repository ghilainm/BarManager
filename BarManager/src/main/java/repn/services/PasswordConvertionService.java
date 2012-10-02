package repn.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface PasswordConvertionService {

	public String getPasswordSHA(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	
}
