package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzcj
  implements CustomRenderedAd
{
  private final zzck zzxj;
  
  public zzcj(zzck paramzzck)
  {
    this.zzxj = paramzzck;
  }
  
  public String getBaseUrl()
  {
    try
    {
      String str = this.zzxj.zzdy();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", localRemoteException);
    }
    return null;
  }
  
  public String getContent()
  {
    try
    {
      String str = this.zzxj.getContent();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate getContent to CustomRenderedAd", localRemoteException);
    }
    return null;
  }
  
  public void onAdRendered(View paramView)
  {
    try
    {
      zzck localzzck = this.zzxj;
      if (paramView != null) {}
      for (zzd localzzd = zze.zzB(paramView);; localzzd = null)
      {
        localzzck.zza(localzzd);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", localRemoteException);
    }
  }
  
  public void recordClick()
  {
    try
    {
      this.zzxj.recordClick();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate recordClick to CustomRenderedAd", localRemoteException);
    }
  }
  
  public void recordImpression()
  {
    try
    {
      this.zzxj.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", localRemoteException);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */