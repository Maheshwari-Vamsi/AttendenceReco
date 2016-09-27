package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;

@zzha
public class zzgq
{
  public zzir zza(Context paramContext, zza paramzza, zzie.zza paramzza1, zzan paramzzan, zzjn paramzzjn, zzew paramzzew, zza paramzza2, zzch paramzzch)
  {
    AdResponseParcel localAdResponseParcel = paramzza1.zzJL;
    Object localObject;
    if (localAdResponseParcel.zzGN) {
      localObject = new zzgt(paramContext, paramzza1, paramzzew, paramzza2, paramzzch);
    }
    for (;;)
    {
      zzb.zzaF("AdRenderer: " + localObject.getClass().getName());
      ((zzir)localObject).zzfR();
      return (zzir)localObject;
      if (localAdResponseParcel.zztY)
      {
        if ((paramzza instanceof zzn))
        {
          localObject = new zzgu(paramContext, (zzn)paramzza, new zzbc(), paramzza1, paramzzan, paramzza2);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Invalid NativeAdManager type. Found: ");
          if (paramzza != null) {}
          for (String str = paramzza.getClass().getName();; str = "null") {
            throw new IllegalArgumentException(str + "; Required: NativeAdManager.");
          }
        }
      }
      else if (localAdResponseParcel.zzGT) {
        localObject = new zzgo(paramContext, paramzza1, paramzzjn, paramzza2);
      } else if ((((Boolean)zzbz.zzvZ.get()).booleanValue()) && (zznx.zzrU()) && (!zznx.isAtLeastL()) && (paramzzjn.zzaP().zztW)) {
        localObject = new zzgs(paramContext, paramzza1, paramzzjn, paramzza2);
      } else {
        localObject = new zzgr(paramContext, paramzza1, paramzzjn, paramzza2);
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(zzie paramzzie);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */