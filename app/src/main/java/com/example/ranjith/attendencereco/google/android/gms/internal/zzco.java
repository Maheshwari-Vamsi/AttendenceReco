package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzco
  extends NativeAd.Image
{
  private final Drawable mDrawable;
  private final Uri mUri;
  private final double zzxx;
  private final zzcn zzyn;
  
  public zzco(zzcn paramzzcn)
  {
    this.zzyn = paramzzcn;
    try
    {
      zzd localzzd = this.zzyn.zzdC();
      if (localzzd == null) {
        break label92;
      }
      localDrawable = (Drawable)zze.zzp(localzzd);
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        zzb.zzb("Failed to get drawable.", localRemoteException1);
        Drawable localDrawable = null;
      }
    }
    this.mDrawable = localDrawable;
    try
    {
      Uri localUri2 = this.zzyn.getUri();
      localUri1 = localUri2;
    }
    catch (RemoteException localRemoteException2)
    {
      for (;;)
      {
        double d1;
        zzb.zzb("Failed to get uri.", localRemoteException2);
        Uri localUri1 = null;
      }
    }
    this.mUri = localUri1;
    d1 = 1.0D;
    try
    {
      double d2 = this.zzyn.getScale();
      d1 = d2;
    }
    catch (RemoteException localRemoteException3)
    {
      for (;;)
      {
        zzb.zzb("Failed to get scale.", localRemoteException3);
      }
    }
    this.zzxx = d1;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public double getScale()
  {
    return this.zzxx;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */