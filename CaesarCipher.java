/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        alphabet = new char[26];
        shifted = new char[26];
        shift = 0;

        String apples = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i<26; i++)
        {
            alphabet[i] = apples.charAt(i);
        }

        shifted = alphabet;
        
    }

    public CaesarCipher(int num){
        alphabet = new char[26];
        shifted = new char[26];
        shift = num;


        String apples = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i<26; i++)
        {
            alphabet[i] = apples.charAt(i);
        }

        System.out.println(alphabet);
        shifter(shift);
        System.out.println(shifted);

    }

    public String encrypt(String message){
        String end = "";
        String apples = "abcdefghijklmnopqrstuvwxyz";
        boolean has = false;
        for(int i = 0; i<message.length(); i++)
        {
            has = false;
            for (char c : alphabet) 
            {
                if(c == message.charAt(i))
                {
                    has = true;
                }
            }

            if(!has)
            {
                end += message.charAt(i);
            }
            else
            {
                for(int ii = 0; ii<alphabet.length; ii++)
                {
                    if(alphabet[ii] == message.charAt(i))
                    {
                        end += shifted[ii];
                    }
                }
            }
        }

        return end;
    }

    public String decrypt(String message){
        String end = "";
        String apples = "abcdefghijklmnopqrstuvwxyz";
        boolean has = false;
        for(int i = 0; i<message.length(); i++)
        {
            has = false;
            for (char c : alphabet) 
            {
                if(c == message.charAt(i))
                {
                    has = true;
                }
            }

            if(!has)
            {
                end += message.charAt(i);
            }
            else
            {
                for(int ii = 0; ii<alphabet.length; ii++)
                {
                    if(shifted[ii] == message.charAt(i))
                    {
                        end += alphabet[ii];
                    }
                }
            }
        }

        return end;

    }

    public void shifter(int num){
        for(int i = 0; i<alphabet.length; i++)
        {
            shifted[(i+num)%alphabet.length] = alphabet[i];
        }

    }


}