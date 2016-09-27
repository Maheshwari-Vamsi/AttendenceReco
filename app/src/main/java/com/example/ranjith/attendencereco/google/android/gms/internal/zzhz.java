package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@zzha
public class zzhz
  extends zzil
  implements zzhy
{
  private final Context mContext;
  private final zzie.zza zzFc;
  private final zzhs zzJA;
  private final String zzJg;
  private final ArrayList<Future> zzJx = new ArrayList();
  private final ArrayList<String> zzJy = new ArrayList();
  private final HashSet<String> zzJz = new HashSet();
  private final Object zzpK = new Object();
  
  public zzhz(Context paramContext, String paramString, zzie.zza paramzza, zzhs paramzzhs)
  {
    this.mContext = paramContext;
    this.zzJg = paramString;
    this.zzFc = paramzza;
    this.zzJA = paramzzhs;
  }
  
  private void zzj(String paramString1, String paramString2)
  {
    synchronized (this.zzpK)
    {
      zzht localzzht = this.zzJA.zzav(paramString1);
      if ((localzzht == null) || (localzzht.zzgB() == null) || (localzzht.zzgA() == null)) {
        return;
      }
      zzhu localzzhu = new zzhu(this.mContext, paramString1, this.zzJg, paramString2, this.zzFc, localzzht, this);
      this.zzJx.add(localzzhu.zzgX());
      this.zzJy.add(paramString1);
      return;
    }
  }
  
  public void onStop() {}
  
  public void zza(String paramString, int paramInt) {}
  
  public void zzaw(String paramString)
  {
    synchronized (this.zzpK)
    {
      this.zzJz.add(paramString);
      return;
    }
  }
  
  public void zzbp()
  {
    Iterator localIterator1 = this.zzFc.zzJF.zzAO.iterator();
    while (localIterator1.hasNext())
    {
      zzem localzzem = (zzem)localIterator1.next();
      String str2 = localzzem.zzAL;
      Iterator localIterator2 = localzzem.zzAG.iterator();
      while (localIterator2.hasNext()) {
        zzj((String)localIterator2.next(), str2);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < this.zzJx.size()) {}
      try
      {
        ((Future)this.zzJx.get(i)).get();
        synchronized (this.zzpK)
        {
          if (this.zzJz.contains(this.zzJy.get(i)))
          {
            String str1 = (String)this.zzJy.get(i);
            final zzie localzzie2 = new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, -2, this.zzFc.zzJL.zzAR, this.zzFc.zzJL.zzGP, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, this.zzFc.zzJL.zzGN, (zzem)this.zzFc.zzJF.zzAO.get(i), null, str1, this.zzFc.zzJF, null, this.zzFc.zzJL.zzGO, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJL.zzGR, this.zzFc.zzJL.zzGS, this.zzFc.zzJE, null);
            zza.zzLE.post(new Runnable()
            {
              public void run()
              {
                zzhz.zza(zzhz.this).zzb(localzzie2);
              }
            });
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        final zzie localzzie1 = new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, 3, this.zzFc.zzJL.zzAR, this.zzFc.zzJL.zzGP, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, this.zzFc.zzJL.zzGN, null, null, null, this.zzFc.zzJF, null, this.zzFc.zzJL.zzGO, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJL.zzGR, this.zzFc.zzJL.zzGS, this.zzFc.zzJE, null);
        zza.zzLE.post(new Runnable()
        {
          public void run()
          {
            zzhz.zza(zzhz.this).zzb(localzzie1);
          }
        });
        return;
      }
      catch (Exception localException)
      {
        i++;
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */