package com.google.android.gms.internal;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;

@zzha
class zzef
{
  private final String zzpH;
  private AdRequestParcel zzqo;
  private final LinkedList<zza> zzzW;
  
  zzef(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    zzx.zzy(paramAdRequestParcel);
    zzx.zzy(paramString);
    this.zzzW = new LinkedList();
    this.zzqo = paramAdRequestParcel;
    this.zzpH = paramString;
  }
  
  String getAdUnitId()
  {
    return this.zzpH;
  }
  
  int size()
  {
    return this.zzzW.size();
  }
  
  void zzb(zzea paramzzea)
  {
    zza localzza = new zza(paramzzea);
    this.zzzW.add(localzza);
    localzza.zzh(this.zzqo);
  }
  
  AdRequestParcel zzeb()
  {
    return this.zzqo;
  }
  
  zza zzec()
  {
    return (zza)this.zzzW.remove();
  }
  
  class zza
  {
    boolean zzAa;
    boolean zzAb;
    zzk zzzX;
    zzeb zzzY;
    long zzzZ;
    MutableContextWrapper zzzz;
    
    zza(zzea paramzzea)
    {
      zzea localzzea = paramzzea.zzdV();
      this.zzzz = paramzzea.zzdW();
      this.zzzX = localzzea.zzac(zzef.zza(zzef.this));
      this.zzzY = new zzeb();
      this.zzzY.zzc(this.zzzX);
    }
    
    private void zzed()
    {
      if ((!this.zzAa) && (zzef.zzc(zzef.this) != null))
      {
        this.zzAb = this.zzzX.zzb(zzef.zzc(zzef.this));
        this.zzAa = true;
        this.zzzZ = zzp.zzbB().currentTimeMillis();
      }
    }
    
    void zzc(zzea paramzzea)
    {
      Context localContext = paramzzea.zzdW().getBaseContext();
      this.zzzz.setBaseContext(localContext);
    }
    
    void zzh(AdRequestParcel paramAdRequestParcel)
    {
      if (paramAdRequestParcel != null) {
        zzef.zza(zzef.this, paramAdRequestParcel);
      }
      zzed();
      Iterator localIterator = zzef.zzb(zzef.this).iterator();
      while (localIterator.hasNext()) {
        ((zza)localIterator.next()).zzed();
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */