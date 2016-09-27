package com.purplebrain.adbuddiz.sdk.i;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public final class n
{
  public static String a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString1);
      localMessageDigest.reset();
      localMessageDigest.update(paramString2.getBytes("UTF-8"));
      String str = a(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return "";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    Formatter localFormatter = new Formatter();
    try
    {
      int j = paramArrayOfByte.length;
      while (i < j)
      {
        byte b = paramArrayOfByte[i];
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b);
        localFormatter.format("%02x", arrayOfObject);
        i++;
      }
      String str = localFormatter.toString();
      return str;
    }
    finally
    {
      localFormatter.close();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */