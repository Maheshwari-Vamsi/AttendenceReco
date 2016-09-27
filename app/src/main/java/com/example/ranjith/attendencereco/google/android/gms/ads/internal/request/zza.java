package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzil;

@zzha
public class zza
{
  public zzil zza(Context paramContext, AdRequestInfoParcel.zza paramzza, zzan paramzzan, zza paramzza1)
  {
    if (paramzza.zzGq.extras.getBundle("sdk_less_server_data") != null) {}
    for (Object localObject = new zzm(paramContext, paramzza, paramzza1);; localObject = new zzb(paramContext, paramzza, paramzzan, paramzza1))
    {
      ((zzil)localObject).zzgX();
      return (zzil)localObject;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzie.zza paramzza);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */