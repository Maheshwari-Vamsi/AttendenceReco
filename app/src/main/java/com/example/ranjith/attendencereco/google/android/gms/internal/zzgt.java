package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.List;

@zzha
public class zzgt
  extends zzgp
{
  private zzen zzBf;
  private zzel zzFx;
  protected zzer zzFy;
  private final zzch zzoU;
  private zzew zzpd;
  
  zzgt(Context paramContext, zzie.zza paramzza, zzew paramzzew, zzgq.zza paramzza1, zzch paramzzch)
  {
    super(paramContext, paramzza, paramzza1);
    this.zzpd = paramzzew;
    this.zzBf = paramzza.zzJF;
    this.zzoU = paramzzch;
  }
  
  public void onStop()
  {
    synchronized (this.zzFf)
    {
      super.onStop();
      if (this.zzFx != null) {
        this.zzFx.cancel();
      }
      return;
    }
  }
  
  protected zzie zzD(int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = this.zzFc.zzJK;
    AdRequestParcel localAdRequestParcel = localAdRequestInfoParcel.zzGq;
    List localList1 = this.zzFd.zzAQ;
    List localList2 = this.zzFd.zzAR;
    List localList3 = this.zzFd.zzGP;
    int i = this.zzFd.orientation;
    long l = this.zzFd.zzAU;
    String str1 = localAdRequestInfoParcel.zzGt;
    boolean bool = this.zzFd.zzGN;
    zzem localzzem;
    zzex localzzex;
    label105:
    String str2;
    label121:
    zzen localzzen;
    if (this.zzFy != null)
    {
      localzzem = this.zzFy.zzBp;
      if (this.zzFy == null) {
        break label234;
      }
      localzzex = this.zzFy.zzBq;
      if (this.zzFy == null) {
        break label240;
      }
      str2 = this.zzFy.zzBr;
      localzzen = this.zzBf;
      if (this.zzFy == null) {
        break label250;
      }
    }
    label234:
    label240:
    label250:
    for (zzep localzzep = this.zzFy.zzBs;; localzzep = null)
    {
      return new zzie(localAdRequestParcel, null, localList1, paramInt, localList2, localList3, i, l, str1, bool, localzzem, localzzex, str2, localzzen, localzzep, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
      localzzem = null;
      break;
      localzzex = null;
      break label105;
      str2 = AdMobAdapter.class.getName();
      break label121;
    }
  }
  
  protected void zzh(long paramLong)
    throws zzgp.zza
  {
    synchronized (this.zzFf)
    {
      this.zzFx = zzi(paramLong);
      this.zzFy = this.zzFx.zzc(this.zzBf.zzAO);
      switch (this.zzFy.zzBo)
      {
      default: 
        throw new zzgp.zza("Unexpected mediation result: " + this.zzFy.zzBo, 0);
      }
    }
    throw new zzgp.zza("No fill from any mediation ad networks.", 3);
  }
  
  zzel zzi(long paramLong)
  {
    if (this.zzBf.zzAX != -1) {
      return new zzet(this.mContext, this.zzFc.zzJK, this.zzpd, this.zzBf, this.zzFd.zztY, paramLong, ((Long)zzbz.zzwC.get()).longValue(), 2);
    }
    return new zzeu(this.mContext, this.zzFc.zzJK, this.zzpd, this.zzBf, this.zzFd.zztY, paramLong, ((Long)zzbz.zzwC.get()).longValue(), this.zzoU);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */