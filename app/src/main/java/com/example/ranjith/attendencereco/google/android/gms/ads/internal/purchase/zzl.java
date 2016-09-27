package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@zzha
public class zzl
{
  public static boolean zza(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      if (!localSignature.verify(Base64.decode(paramString2, 0)))
      {
        zzb.e("Signature verification failed.");
        return false;
      }
      return true;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      zzb.e("NoSuchAlgorithmException.");
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      zzb.e("Invalid key specification.");
      return false;
    }
    catch (SignatureException localSignatureException)
    {
      zzb.e("Signature exception.");
    }
    return false;
  }
  
  public static PublicKey zzar(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
      return localPublicKey;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      zzb.e("Invalid key specification.");
      throw new IllegalArgumentException(localInvalidKeySpecException);
    }
  }
  
  public static boolean zzc(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      zzb.e("Purchase verification failed: missing data.");
      return false;
    }
    return zza(zzar(paramString1), paramString2, paramString3);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */