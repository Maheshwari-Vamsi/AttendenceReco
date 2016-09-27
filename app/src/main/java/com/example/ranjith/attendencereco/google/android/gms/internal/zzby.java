package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.concurrent.Callable;

@zzha
public class zzby
{
  private final Object zzpK = new Object();
  private boolean zzqh = false;
  private SharedPreferences zzvc = null;
  
  public void initialize(Context paramContext)
  {
    Context localContext;
    synchronized (this.zzpK)
    {
      if (this.zzqh) {
        return;
      }
      localContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (localContext == null) {
        return;
      }
    }
    this.zzvc = zzp.zzbE().zzw(localContext);
    this.zzqh = true;
  }
  
  public <T> T zzd(final zzbv<T> paramzzbv)
  {
    synchronized (this.zzpK)
    {
      if (!this.zzqh)
      {
        Object localObject3 = paramzzbv.zzdk();
        return (T)localObject3;
      }
      (T)zziz.zzb(new Callable()
      {
        public T call()
        {
          return (T)paramzzbv.zza(zzby.zza(zzby.this));
        }
      });
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */