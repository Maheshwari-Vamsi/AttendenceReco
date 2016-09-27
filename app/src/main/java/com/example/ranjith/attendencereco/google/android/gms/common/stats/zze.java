package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze
{
  private final long zzalW;
  private final int zzalX;
  private final SimpleArrayMap<String, Long> zzalY;
  
  public zze()
  {
    this.zzalW = 60000L;
    this.zzalX = 10;
    this.zzalY = new SimpleArrayMap(10);
  }
  
  public zze(int paramInt, long paramLong)
  {
    this.zzalW = paramLong;
    this.zzalX = paramInt;
    this.zzalY = new SimpleArrayMap();
  }
  
  private void zzb(long paramLong1, long paramLong2)
  {
    for (int i = -1 + this.zzalY.size(); i >= 0; i--) {
      if (paramLong2 - ((Long)this.zzalY.valueAt(i)).longValue() > paramLong1) {
        this.zzalY.removeAt(i);
      }
    }
  }
  
  public Long zzcM(String paramString)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.zzalW;
    try
    {
      while (this.zzalY.size() >= this.zzalX)
      {
        zzb(l2, l1);
        l2 /= 2L;
        Log.w("ConnectionTracker", "The max capacity " + this.zzalX + " is not enough. Current durationThreshold is: " + l2);
      }
      localLong = (Long)this.zzalY.put(paramString, Long.valueOf(l1));
    }
    finally {}
    Long localLong;
    return localLong;
  }
  
  public boolean zzcN(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.zzalY.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\stats\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */