package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzha
public class zzif
{
  private boolean zzIi = false;
  private final LinkedList<zza> zzJM;
  private final String zzJN;
  private final String zzJO;
  private long zzJP = -1L;
  private long zzJQ = -1L;
  private long zzJR = -1L;
  private long zzJS = 0L;
  private long zzJT = -1L;
  private long zzJU = -1L;
  private final Object zzpK = new Object();
  private final zzig zzqC;
  
  public zzif(zzig paramzzig, String paramString1, String paramString2)
  {
    this.zzqC = paramzzig;
    this.zzJN = paramString1;
    this.zzJO = paramString2;
    this.zzJM = new LinkedList();
  }
  
  public zzif(String paramString1, String paramString2)
  {
    this(zzp.zzbA(), paramString1, paramString2);
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    synchronized (this.zzpK)
    {
      localBundle = new Bundle();
      localBundle.putString("seq_num", this.zzJN);
      localBundle.putString("slotid", this.zzJO);
      localBundle.putBoolean("ismediation", this.zzIi);
      localBundle.putLong("treq", this.zzJT);
      localBundle.putLong("tresponse", this.zzJU);
      localBundle.putLong("timp", this.zzJQ);
      localBundle.putLong("tload", this.zzJR);
      localBundle.putLong("pcc", this.zzJS);
      localBundle.putLong("tfetch", this.zzJP);
      localArrayList = new ArrayList();
      Iterator localIterator = this.zzJM.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((zza)localIterator.next()).toBundle());
      }
    }
    localBundle.putParcelableArrayList("tclick", localArrayList);
    return localBundle;
  }
  
  public void zzA(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (this.zzJU != -1L)
      {
        this.zzIi = paramBoolean;
        this.zzqC.zza(this);
      }
      return;
    }
  }
  
  public void zzgD()
  {
    synchronized (this.zzpK)
    {
      if ((this.zzJU != -1L) && (this.zzJQ == -1L))
      {
        this.zzJQ = SystemClock.elapsedRealtime();
        this.zzqC.zza(this);
      }
      this.zzqC.zzgL().zzgD();
      return;
    }
  }
  
  public void zzgE()
  {
    synchronized (this.zzpK)
    {
      if (this.zzJU != -1L)
      {
        zza localzza = new zza();
        localzza.zzgI();
        this.zzJM.add(localzza);
        this.zzJS = (1L + this.zzJS);
        this.zzqC.zzgL().zzgE();
        this.zzqC.zza(this);
      }
      return;
    }
  }
  
  public void zzgF()
  {
    synchronized (this.zzpK)
    {
      if ((this.zzJU != -1L) && (!this.zzJM.isEmpty()))
      {
        zza localzza = (zza)this.zzJM.getLast();
        if (localzza.zzgG() == -1L)
        {
          localzza.zzgH();
          this.zzqC.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzj(AdRequestParcel paramAdRequestParcel)
  {
    synchronized (this.zzpK)
    {
      this.zzJT = SystemClock.elapsedRealtime();
      this.zzqC.zzgL().zzb(paramAdRequestParcel, this.zzJT);
      return;
    }
  }
  
  public void zzl(long paramLong)
  {
    synchronized (this.zzpK)
    {
      this.zzJU = paramLong;
      if (this.zzJU != -1L) {
        this.zzqC.zza(this);
      }
      return;
    }
  }
  
  public void zzm(long paramLong)
  {
    synchronized (this.zzpK)
    {
      if (this.zzJU != -1L)
      {
        this.zzJP = paramLong;
        this.zzqC.zza(this);
      }
      return;
    }
  }
  
  public void zzz(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (this.zzJU != -1L)
      {
        this.zzJR = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.zzJQ = this.zzJR;
          this.zzqC.zza(this);
        }
      }
      return;
    }
  }
  
  @zzha
  private static final class zza
  {
    private long zzJV = -1L;
    private long zzJW = -1L;
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.zzJV);
      localBundle.putLong("tclose", this.zzJW);
      return localBundle;
    }
    
    public long zzgG()
    {
      return this.zzJW;
    }
    
    public void zzgH()
    {
      this.zzJW = SystemClock.elapsedRealtime();
    }
    
    public void zzgI()
    {
      this.zzJV = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */