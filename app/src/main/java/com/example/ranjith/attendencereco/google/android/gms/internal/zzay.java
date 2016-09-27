package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@zzha
public class zzay
  implements zzba
{
  private final VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  private final WeakHashMap<zzie, zzaz> zzrG = new WeakHashMap();
  private final ArrayList<zzaz> zzrH = new ArrayList();
  private final Context zzrI;
  private final zzei zzrJ;
  
  public zzay(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzei paramzzei)
  {
    this.zzrI = paramContext.getApplicationContext();
    this.zzpI = paramVersionInfoParcel;
    this.zzrJ = paramzzei;
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie)
  {
    return zza(paramAdSizeParcel, paramzzie, paramzzie.zzDC.getView());
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie, View paramView)
  {
    return zza(paramAdSizeParcel, paramzzie, new zzaz.zzd(paramView, paramzzie));
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie, zzh paramzzh)
  {
    return zza(paramAdSizeParcel, paramzzie, new zzaz.zza(paramzzh));
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie, zzbh paramzzbh)
  {
    synchronized (this.zzpK)
    {
      if (zzd(paramzzie))
      {
        zzaz localzzaz2 = (zzaz)this.zzrG.get(paramzzie);
        return localzzaz2;
      }
      zzaz localzzaz1 = new zzaz(this.zzrI, paramAdSizeParcel, paramzzie, this.zzpI, paramzzbh, this.zzrJ);
      localzzaz1.zza(this);
      this.zzrG.put(paramzzie, localzzaz1);
      this.zzrH.add(localzzaz1);
      return localzzaz1;
    }
  }
  
  public void zza(zzaz paramzzaz)
  {
    synchronized (this.zzpK)
    {
      if (!paramzzaz.zzch())
      {
        this.zzrH.remove(paramzzaz);
        Iterator localIterator = this.zzrG.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Map.Entry)localIterator.next()).getValue() == paramzzaz) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public boolean zzd(zzie paramzzie)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        zzaz localzzaz = (zzaz)this.zzrG.get(paramzzie);
        if ((localzzaz != null) && (localzzaz.zzch()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zze(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      zzaz localzzaz = (zzaz)this.zzrG.get(paramzzie);
      if (localzzaz != null) {
        localzzaz.zzcf();
      }
      return;
    }
  }
  
  public void zzf(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      zzaz localzzaz = (zzaz)this.zzrG.get(paramzzie);
      if (localzzaz != null) {
        localzzaz.stop();
      }
      return;
    }
  }
  
  public void zzg(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      zzaz localzzaz = (zzaz)this.zzrG.get(paramzzie);
      if (localzzaz != null) {
        localzzaz.pause();
      }
      return;
    }
  }
  
  public void zzh(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      zzaz localzzaz = (zzaz)this.zzrG.get(paramzzie);
      if (localzzaz != null) {
        localzzaz.resume();
      }
      return;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */