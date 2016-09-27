package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.WeakHashMap;

@zzha
public final class zzhj
{
  private WeakHashMap<Context, zza> zzIW = new WeakHashMap();
  
  public zzhi zzE(Context paramContext)
  {
    zza localzza = (zza)this.zzIW.get(paramContext);
    if ((localzza != null) && (!localzza.hasExpired()) && (((Boolean)zzbz.zzwq.get()).booleanValue())) {}
    for (zzhi localzzhi = new zzhi.zza(paramContext, localzza.zzIY).zzgv();; localzzhi = new zzhi.zza(paramContext).zzgv())
    {
      this.zzIW.put(paramContext, new zza(localzzhi));
      return localzzhi;
    }
  }
  
  private class zza
  {
    public final long zzIX = zzp.zzbB().currentTimeMillis();
    public final zzhi zzIY;
    
    public zza(zzhi paramzzhi)
    {
      this.zzIY = paramzzhi;
    }
    
    public boolean hasExpired()
    {
      return this.zzIX + ((Long)zzbz.zzwr.get()).longValue() < zzp.zzbB().currentTimeMillis();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */