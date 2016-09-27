package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzit.zza;
import com.google.android.gms.internal.zzit.zzb;
import com.google.android.gms.internal.zznl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@zzha
public class zzp
{
  private final Context mContext;
  private final String zzDX;
  private final VersionInfoParcel zzDY;
  private final zzcf zzDZ;
  private final zzch zzEa;
  private final zzit zzEb = new zzit.zzb().zza("min_1", Double.MIN_VALUE, 1.0D).zza("1_5", 1.0D, 5.0D).zza("5_10", 5.0D, 10.0D).zza("10_20", 10.0D, 20.0D).zza("20_30", 20.0D, 30.0D).zza("30_max", 30.0D, Double.MAX_VALUE).zzhi();
  private final long[] zzEc;
  private final String[] zzEd;
  private zzcf zzEe;
  private zzcf zzEf;
  private zzcf zzEg;
  private zzcf zzEh;
  private boolean zzEi;
  private zzi zzEj;
  private boolean zzEk;
  private boolean zzEl;
  private long zzEm = -1L;
  
  public zzp(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, zzch paramzzch, zzcf paramzzcf)
  {
    this.mContext = paramContext;
    this.zzDY = paramVersionInfoParcel;
    this.zzDX = paramString;
    this.zzEa = paramzzch;
    this.zzDZ = paramzzcf;
    String str = (String)zzbz.zzvA.get();
    if (str == null)
    {
      this.zzEd = new String[0];
      this.zzEc = new long[0];
      return;
    }
    String[] arrayOfString = TextUtils.split(str, ",");
    this.zzEd = new String[arrayOfString.length];
    this.zzEc = new long[arrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length) {
      try
      {
        this.zzEc[i] = Long.parseLong(arrayOfString[i]);
        i++;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          zzb.zzd("Unable to parse frame hash target time number.", localNumberFormatException);
          this.zzEc[i] = -1L;
        }
      }
    }
  }
  
  private void zzc(zzi paramzzi)
  {
    long l1 = ((Long)zzbz.zzvB.get()).longValue();
    long l2 = paramzzi.getCurrentPosition();
    int i = 0;
    if (i < this.zzEd.length)
    {
      if (this.zzEd[i] != null) {}
      while (l1 <= Math.abs(l2 - this.zzEc[i]))
      {
        i++;
        break;
      }
      this.zzEd[i] = zza(paramzzi);
    }
  }
  
  private void zzfA()
  {
    if ((this.zzEg != null) && (this.zzEh == null))
    {
      zzcd.zza(this.zzEa, this.zzEg, new String[] { "vff" });
      zzcd.zza(this.zzEa, this.zzDZ, new String[] { "vtt" });
      this.zzEh = zzcd.zzb(this.zzEa);
    }
    long l = com.google.android.gms.ads.internal.zzp.zzbB().nanoTime();
    if ((this.zzEi) && (this.zzEl) && (this.zzEm != -1L))
    {
      double d = TimeUnit.SECONDS.toNanos(1L) / (l - this.zzEm);
      this.zzEb.zza(d);
    }
    this.zzEl = this.zzEi;
    this.zzEm = l;
  }
  
  public void onStop()
  {
    if ((((Boolean)zzbz.zzvz.get()).booleanValue()) && (!this.zzEk))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("type", "native-player-metrics");
      localBundle.putString("request", this.zzDX);
      localBundle.putString("player", this.zzEj.zzeO());
      Iterator localIterator = this.zzEb.getBuckets().iterator();
      while (localIterator.hasNext())
      {
        zzit.zza localzza = (zzit.zza)localIterator.next();
        localBundle.putString("fps_c_" + localzza.name, Integer.toString(localzza.count));
        localBundle.putString("fps_p_" + localzza.name, Double.toString(localzza.zzLg));
      }
      int i = 0;
      if (i < this.zzEc.length)
      {
        String str = this.zzEd[i];
        if (str == null) {}
        for (;;)
        {
          i++;
          break;
          localBundle.putString("fh_" + Long.valueOf(this.zzEc[i]), str);
        }
      }
      com.google.android.gms.ads.internal.zzp.zzbx().zza(this.mContext, this.zzDY.afmaVersion, "gmob-apps", localBundle, true);
      this.zzEk = true;
    }
  }
  
  String zza(TextureView paramTextureView)
  {
    Bitmap localBitmap = paramTextureView.getBitmap(8, 8);
    long l1 = 0L;
    long l2 = 63L;
    int i = 0;
    while (i < 8)
    {
      long l3 = l1;
      long l4 = l2;
      int j = 0;
      if (j < 8)
      {
        int k = localBitmap.getPixel(j, i);
        if (Color.blue(k) + Color.red(k) + Color.green(k) > 128) {}
        for (long l5 = 1L;; l5 = 0L)
        {
          l3 |= l5 << (int)l4;
          int m = j + 1;
          l4 -= 1L;
          j = m;
          break;
        }
      }
      i++;
      l2 = l4;
      l1 = l3;
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(l1);
    return String.format("%016X", arrayOfObject);
  }
  
  public void zza(zzi paramzzi)
  {
    zzcd.zza(this.zzEa, this.zzDZ, new String[] { "vpc" });
    this.zzEe = zzcd.zzb(this.zzEa);
    this.zzEj = paramzzi;
  }
  
  public void zzb(zzi paramzzi)
  {
    zzfA();
    zzc(paramzzi);
  }
  
  public void zzfB()
  {
    this.zzEi = true;
    if ((this.zzEf != null) && (this.zzEg == null))
    {
      zzcd.zza(this.zzEa, this.zzEf, new String[] { "vfp" });
      this.zzEg = zzcd.zzb(this.zzEa);
    }
  }
  
  public void zzfC()
  {
    this.zzEi = false;
  }
  
  public void zzfo()
  {
    if ((this.zzEe == null) || (this.zzEf != null)) {
      return;
    }
    zzcd.zza(this.zzEa, this.zzEe, new String[] { "vfr" });
    this.zzEf = zzcd.zzb(this.zzEa);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */