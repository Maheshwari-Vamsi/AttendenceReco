package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzcu
  extends NativeContentAd
{
  private final List<NativeAd.Image> zzyp = new ArrayList();
  private final zzct zzyr;
  private final zzco zzys;
  
  public zzcu(zzct paramzzct)
  {
    this.zzyr = paramzzct;
    try
    {
      List localList = this.zzyr.getImages();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          zzcn localzzcn2 = zzd(localIterator.next());
          if (localzzcn2 != null) {
            this.zzyp.add(new zzco(localzzcn2));
          }
        }
      }
      try
      {
        zzcn localzzcn1 = this.zzyr.zzdH();
        if (localzzcn1 == null) {
          break label143;
        }
        localzzco = new zzco(localzzcn1);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", localRemoteException2);
          zzco localzzco = null;
        }
      }
    }
    catch (RemoteException localRemoteException1)
    {
      zzb.zzb("Failed to get image.", localRemoteException1);
    }
    this.zzys = localzzco;
  }
  
  public void destroy()
  {
    try
    {
      this.zzyr.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to destroy", localRemoteException);
    }
  }
  
  public CharSequence getAdvertiser()
  {
    try
    {
      String str = this.zzyr.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get attribution.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = this.zzyr.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get body.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getCallToAction()
  {
    try
    {
      String str = this.zzyr.getCallToAction();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get call to action.", localRemoteException);
    }
    return null;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = this.zzyr.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = this.zzyr.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return this.zzyp;
  }
  
  public NativeAd.Image getLogo()
  {
    return this.zzys;
  }
  
  zzcn zzd(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzcn.zza.zzt((IBinder)paramObject);
    }
    return null;
  }
  
  protected zzd zzdE()
  {
    try
    {
      zzd localzzd = this.zzyr.zzdE();
      return localzzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */