package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.math.BigInteger;
import java.util.Locale;

@zzha
public final class zzik
{
  private static String zzKs;
  private static final Object zzqf = new Object();
  
  public static String zza(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (zzqf)
    {
      if ((zzKs == null) && (!TextUtils.isEmpty(paramString1))) {
        zzb(paramContext, paramString1, paramString2);
      }
      String str = zzKs;
      return str;
    }
  }
  
  private static void zzb(Context paramContext, String paramString1, String paramString2)
  {
    BigInteger localBigInteger2;
    try
    {
      ClassLoader localClassLoader = paramContext.createPackageContext(paramString2, 3).getClassLoader();
      Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, localClassLoader);
      BigInteger localBigInteger1 = new BigInteger(new byte[1]);
      String[] arrayOfString = paramString1.split(",");
      localBigInteger2 = localBigInteger1;
      for (int i = 0; i < arrayOfString.length; i++) {
        if (zzp.zzbx().zza(localClassLoader, localClass, arrayOfString[i])) {
          localBigInteger2 = localBigInteger2.setBit(i);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      zzKs = "err";
      return;
    }
    tmp105_102[0] = localBigInteger2;
    zzKs = String.format(Locale.US, "%X", tmp105_102);
  }
  
  public static String zzgW()
  {
    synchronized (zzqf)
    {
      String str = zzKs;
      return str;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */