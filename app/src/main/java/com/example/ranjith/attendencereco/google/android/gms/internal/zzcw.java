package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzha
public class zzcw
  implements NativeCustomTemplateAd
{
  private final zzcv zzyt;
  
  public zzcw(zzcv paramzzcv)
  {
    this.zzyt = paramzzcv;
  }
  
  public List<String> getAvailableAssetNames()
  {
    try
    {
      List localList = this.zzyt.getAvailableAssetNames();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get available asset names.", localRemoteException);
    }
    return null;
  }
  
  public String getCustomTemplateId()
  {
    try
    {
      String str = this.zzyt.getCustomTemplateId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get custom template id.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getImage(String paramString)
  {
    try
    {
      zzcn localzzcn = this.zzyt.zzT(paramString);
      if (localzzcn != null)
      {
        zzco localzzco = new zzco(localzzcn);
        return localzzco;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get image.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getText(String paramString)
  {
    try
    {
      String str = this.zzyt.zzS(paramString);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get string.", localRemoteException);
    }
    return null;
  }
  
  public void performClick(String paramString)
  {
    try
    {
      this.zzyt.performClick(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to perform click.", localRemoteException);
    }
  }
  
  public void recordImpression()
  {
    try
    {
      this.zzyt.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to record impression.", localRemoteException);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */