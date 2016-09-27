package com.purplebrain.adbuddiz.sdk.i;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class g
{
  public static String a(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
      localGZIPOutputStream.flush();
      localGZIPOutputStream.close();
      String str = a(localByteArrayOutputStream.toByteArray());
      return str;
    }
    catch (Exception localException)
    {
      o.a("ABDataEncryptionHelper.gzipAndEncode()", localException);
    }
    return null;
  }
  
  @SuppressLint({"TrulyRandom"})
  private static String a(byte[] paramArrayOfByte)
  {
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(f.a("bWZSYjVSNUtlc2tkYjJ4Tg=="));
      SecretKeySpec localSecretKeySpec = a();
      if (localSecretKeySpec == null) {
        return null;
      }
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, localSecretKeySpec, localIvParameterSpec);
      String str = new String(f.a(localCipher.doFinal(paramArrayOfByte)));
      return str;
    }
    catch (Exception localException)
    {
      o.a("ABDataEncryptionHelper.encrypt()", localException);
    }
    return null;
  }
  
  private static SecretKeySpec a()
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if (localb == null) {}
    StringBuilder localStringBuilder;
    for (String str = null; str == null; str = localStringBuilder.toString())
    {
      return null;
      localStringBuilder = new StringBuilder();
      for (int i = 0; i < 12; i++)
      {
        localStringBuilder.append(localb.c.charAt(i));
        localStringBuilder.append("D01FX2jKW5g=".charAt(i));
      }
    }
    return new SecretKeySpec(f.a(str), "AES");
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */