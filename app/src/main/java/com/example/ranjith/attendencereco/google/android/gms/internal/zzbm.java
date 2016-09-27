package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbm
{
  private static MessageDigest zztd = null;
  protected Object zzpK = new Object();
  
  protected MessageDigest zzcG()
  {
    for (;;)
    {
      int i;
      synchronized (this.zzpK)
      {
        if (zztd != null)
        {
          MessageDigest localMessageDigest2 = zztd;
          return localMessageDigest2;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        zztd = MessageDigest.getInstance("MD5");
        i++;
        continue;
        MessageDigest localMessageDigest1 = zztd;
        return localMessageDigest1;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
  
  abstract byte[] zzz(String paramString);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */