package encryption;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class en {
	public static void main(String[] args) throws Exception {
	int i,c=33;

	System.out.println(enc());
	
	String[][] a=new String[2][94];
		//a[][]={-1};
		for(i=0;i<94;i++)
			a[0][i]=Character.toString((char)c++);
		for(i=0;i<94;i++)
			a[1][i]=Integer.toString((int)(Math.random()*100));
			for(i=0;i<93;i++)
				System.out.println(a[0][i]+" "+a[1][i]);
	 
	}
	
	static String enc() {
		String text = "Hello World";
        String key = "TheStrongestPasswordInTheWorld!!"; // 256 bit key
        byte[] encrypted = null;
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(text.getBytes());
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
		return (new String(encrypted));
	}
}
