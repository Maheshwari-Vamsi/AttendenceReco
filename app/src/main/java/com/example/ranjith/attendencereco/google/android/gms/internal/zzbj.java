package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzha
public class zzbj
{
  private final Object zzpK = new Object();
  private int zzsM;
  private List<zzbi> zzsN = new LinkedList();
  
  public boolean zza(zzbi paramzzbi)
  {
    synchronized (this.zzpK)
    {
      return this.zzsN.contains(paramzzbi);
    }
  }
  
  public boolean zzb(zzbi paramzzbi)
  {
    synchronized (this.zzpK)
    {
      Iterator localIterator = this.zzsN.iterator();
      while (localIterator.hasNext())
      {
        zzbi localzzbi = (zzbi)localIterator.next();
        if ((paramzzbi != localzzbi) && (localzzbi.zzcu().equals(paramzzbi.zzcu())))
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void zzc(zzbi paramzzbi)
  {
    synchronized (this.zzpK)
    {
      if (this.zzsN.size() >= 10)
      {
        zzb.zzaF("Queue is full, current size = " + this.zzsN.size());
        this.zzsN.remove(0);
      }
      int i = this.zzsM;
      this.zzsM = (i + 1);
      paramzzbi.zzh(i);
      this.zzsN.add(paramzzbi);
      return;
    }
  }
  
  public zzbi zzcA()
  {
    Object localObject4;
    for (Object localObject1 = null;; localObject1 = localObject4)
    {
      synchronized (this.zzpK)
      {
        if (this.zzsN.size() == 0)
        {
          zzb.zzaF("Queue empty");
          return null;
        }
        if (this.zzsN.size() >= 2)
        {
          i = Integer.MIN_VALUE;
          Iterator localIterator = this.zzsN.iterator();
          if (localIterator.hasNext())
          {
            zzbi localzzbi1 = (zzbi)localIterator.next();
            int j = localzzbi1.getScore();
            if (j <= i) {
              break label150;
            }
            localObject4 = localzzbi1;
            k = j;
            break label160;
          }
          this.zzsN.remove(localObject1);
          return (zzbi)localObject1;
        }
      }
      zzbi localzzbi2 = (zzbi)this.zzsN.get(0);
      localzzbi2.zzcv();
      return localzzbi2;
      label150:
      int k = i;
      localObject4 = localObject1;
      label160:
      int i = k;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */