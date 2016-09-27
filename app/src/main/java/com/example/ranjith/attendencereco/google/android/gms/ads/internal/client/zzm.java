package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzha;
import java.util.Random;

@zzha
public class zzm
  extends zzv.zza
{
  private Object zzpK = new Object();
  private final Random zzuj = new Random();
  private long zzuk;
  
  public zzm()
  {
    zzcS();
  }
  
  public long getValue()
  {
    return this.zzuk;
  }
  
  public void zzcS()
  {
    Object localObject1 = this.zzpK;
    int i = 3;
    long l = 0L;
    for (;;)
    {
      i--;
      if (i > 0) {}
      try
      {
        l = 2147483648L + this.zzuj.nextInt();
        if ((l == this.zzuk) || (l == 0L)) {
          continue;
        }
        this.zzuk = l;
        return;
      }
      finally {}
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */