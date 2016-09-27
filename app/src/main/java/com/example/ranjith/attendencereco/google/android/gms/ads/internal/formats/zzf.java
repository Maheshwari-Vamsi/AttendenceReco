package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzcv.zza;
import com.google.android.gms.internal.zzha;
import java.util.Arrays;
import java.util.List;

@zzha
public class zzf
  extends zzcv.zza
  implements zzh.zza
{
  private final Object zzpK = new Object();
  private final zza zzxG;
  private zzh zzxH;
  private final String zzxK;
  private final SimpleArrayMap<String, zzc> zzxL;
  private final SimpleArrayMap<String, String> zzxM;
  
  public zzf(String paramString, SimpleArrayMap<String, zzc> paramSimpleArrayMap, SimpleArrayMap<String, String> paramSimpleArrayMap1, zza paramzza)
  {
    this.zzxK = paramString;
    this.zzxL = paramSimpleArrayMap;
    this.zzxM = paramSimpleArrayMap1;
    this.zzxG = paramzza;
  }
  
  public List<String> getAvailableAssetNames()
  {
    String[] arrayOfString = new String[this.zzxL.size() + this.zzxM.size()];
    int i = 0;
    int j = 0;
    int m;
    for (;;)
    {
      int k = this.zzxL.size();
      m = 0;
      if (i >= k) {
        break;
      }
      arrayOfString[j] = ((String)this.zzxL.keyAt(i));
      int n = i + 1;
      j++;
      i = n;
    }
    while (m < this.zzxM.size())
    {
      arrayOfString[j] = ((String)this.zzxM.keyAt(m));
      m++;
      j++;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public String getCustomTemplateId()
  {
    return this.zzxK;
  }
  
  public void performClick(String paramString)
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH == null)
      {
        zzb.e("Attempt to call performClick before ad initialized.");
        return;
      }
      this.zzxH.zza(paramString, null, null, null);
      return;
    }
  }
  
  public void recordImpression()
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH == null)
      {
        zzb.e("Attempt to perform recordImpression before ad initialized.");
        return;
      }
      this.zzxH.recordImpression();
      return;
    }
  }
  
  public String zzS(String paramString)
  {
    return (String)this.zzxM.get(paramString);
  }
  
  public zzcn zzT(String paramString)
  {
    return (zzcn)this.zzxL.get(paramString);
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (this.zzpK)
    {
      this.zzxH = paramzzh;
      return;
    }
  }
  
  public String zzdF()
  {
    return "3";
  }
  
  public zza zzdG()
  {
    return this.zzxG;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */