package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzjp
{
  public zzjn zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel)
  {
    return zza(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, null, null);
  }
  
  public zzjn zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzch paramzzch, zzd paramzzd)
  {
    zzjq localzzjq = new zzjq(zzjr.zzb(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, paramzzch, paramzzd));
    localzzjq.setWebViewClient(zzp.zzbz().zzb(localzzjq, paramBoolean2));
    localzzjq.setWebChromeClient(zzp.zzbz().zzh(localzzjq));
    return localzzjq;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */