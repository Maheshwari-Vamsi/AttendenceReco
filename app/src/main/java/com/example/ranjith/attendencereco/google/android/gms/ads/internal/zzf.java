package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjo.zzb;
import java.util.List;

@zzha
public class zzf
  extends zzc
{
  private boolean zzpt;
  
  public zzf(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzew, paramVersionInfoParcel, paramzzd);
  }
  
  private AdSizeParcel zzb(zzie.zza paramzza)
  {
    if (paramzza.zzJL.zztZ) {
      return this.zzoZ.zzqV;
    }
    String str = paramzza.zzJL.zzGQ;
    String[] arrayOfString;
    if (str != null)
    {
      arrayOfString = str.split("[xX]");
      arrayOfString[0] = arrayOfString[0].trim();
      arrayOfString[1] = arrayOfString[1].trim();
    }
    for (AdSize localAdSize = new AdSize(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]));; localAdSize = this.zzoZ.zzqV.zzcL()) {
      return new AdSizeParcel(this.zzoZ.context, localAdSize);
    }
  }
  
  private boolean zzb(zzie paramzzie1, zzie paramzzie2)
  {
    if (paramzzie2.zzGN) {}
    for (;;)
    {
      View localView1;
      try
      {
        com.google.android.gms.dynamic.zzd localzzd = paramzzie2.zzBq.getView();
        if (localzzd == null)
        {
          zzb.zzaH("View in mediation adapter is null.");
          return false;
        }
        View localView2 = (View)com.google.android.gms.dynamic.zze.zzp(localzzd);
        View localView3 = this.zzoZ.zzqS.getNextView();
        if (localView3 != null)
        {
          if ((localView3 instanceof zzjn)) {
            ((zzjn)localView3).destroy();
          }
          this.zzoZ.zzqS.removeView(localView3);
        }
        if (paramzzie2.zzJG == null) {
          continue;
        }
      }
      catch (RemoteException localRemoteException)
      {
        try
        {
          zzb(localView2);
          if (this.zzoZ.zzqS.getChildCount() > 1) {
            this.zzoZ.zzqS.showNext();
          }
          if (paramzzie1 != null)
          {
            localView1 = this.zzoZ.zzqS.getNextView();
            if (!(localView1 instanceof zzjn)) {
              break label295;
            }
            ((zzjn)localView1).zza(this.zzoZ.context, this.zzoZ.zzqV, this.zzoU);
            this.zzoZ.zzbP();
          }
          this.zzoZ.zzqS.setVisibility(0);
          return true;
        }
        catch (Throwable localThrowable)
        {
          zzb.zzd("Could not add mediation view to view hierarchy.", localThrowable);
          return false;
        }
        localRemoteException = localRemoteException;
        zzb.zzd("Could not get View from mediation adapter.", localRemoteException);
        return false;
      }
      if (paramzzie2.zzDC != null)
      {
        paramzzie2.zzDC.zza(paramzzie2.zzJG);
        this.zzoZ.zzqS.removeAllViews();
        this.zzoZ.zzqS.setMinimumWidth(paramzzie2.zzJG.widthPixels);
        this.zzoZ.zzqS.setMinimumHeight(paramzzie2.zzJG.heightPixels);
        zzb(paramzzie2.zzDC.getView());
        continue;
        label295:
        if (localView1 != null) {
          this.zzoZ.zzqS.removeView(localView1);
        }
      }
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzx.zzcx("setManualImpressionsEnabled must be called from the main thread.");
    this.zzpt = paramBoolean;
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  protected zzjn zza(zzie.zza paramzza, zze paramzze)
  {
    if (this.zzoZ.zzqV.zztZ) {
      this.zzoZ.zzqV = zzb(paramzza);
    }
    return super.zza(paramzza, paramzze);
  }
  
  public boolean zza(zzie paramzzie1, final zzie paramzzie2)
  {
    if (!super.zza(paramzzie1, paramzzie2)) {
      return false;
    }
    if ((this.zzoZ.zzbQ()) && (!zzb(paramzzie1, paramzzie2)))
    {
      zzf(0);
      return false;
    }
    zza(paramzzie2, false);
    if (this.zzoZ.zzbQ()) {
      if (paramzzie2.zzDC != null)
      {
        if (paramzzie2.zzJE != null) {
          this.zzpb.zza(this.zzoZ.zzqV, paramzzie2);
        }
        if (!paramzzie2.zzcb()) {
          break label115;
        }
        this.zzpb.zza(this.zzoZ.zzqV, paramzzie2).zza(paramzzie2.zzDC);
      }
    }
    for (;;)
    {
      return true;
      label115:
      paramzzie2.zzDC.zzhC().zza(new zzjo.zzb()
      {
        public void zzbh()
        {
          zzf.this.zzpb.zza(zzf.this.zzoZ.zzqV, paramzzie2).zza(paramzzie2.zzDC);
        }
      });
      continue;
      if ((this.zzoZ.zzro != null) && (paramzzie2.zzJE != null)) {
        this.zzpb.zza(this.zzoZ.zzqV, paramzzie2, this.zzoZ.zzro);
      }
    }
  }
  
  protected boolean zzaW()
  {
    boolean bool = true;
    if (!zzp.zzbx().zza(this.zzoZ.context.getPackageManager(), this.zzoZ.context.getPackageName(), "android.permission.INTERNET"))
    {
      zzl.zzcN().zza(this.zzoZ.zzqS, this.zzoZ.zzqV, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!zzp.zzbx().zzJ(this.zzoZ.context))
    {
      zzl.zzcN().zza(this.zzoZ.zzqS, this.zzoZ.zzqV, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (this.zzoZ.zzqS != null)) {
      this.zzoZ.zzqS.setVisibility(0);
    }
    return bool;
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    return super.zzb(zze(paramAdRequestParcel));
  }
  
  AdRequestParcel zze(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel.zztv == this.zzpt) {
      return paramAdRequestParcel;
    }
    int i = paramAdRequestParcel.versionCode;
    long l = paramAdRequestParcel.zztq;
    Bundle localBundle = paramAdRequestParcel.extras;
    int j = paramAdRequestParcel.zztr;
    List localList = paramAdRequestParcel.zzts;
    boolean bool1 = paramAdRequestParcel.zztt;
    int k = paramAdRequestParcel.zztu;
    if ((paramAdRequestParcel.zztv) || (this.zzpt)) {}
    for (boolean bool2 = true;; bool2 = false) {
      return new AdRequestParcel(i, l, localBundle, j, localList, bool1, k, bool2, paramAdRequestParcel.zztw, paramAdRequestParcel.zztx, paramAdRequestParcel.zzty, paramAdRequestParcel.zztz, paramAdRequestParcel.zztA, paramAdRequestParcel.zztB, paramAdRequestParcel.zztC, paramAdRequestParcel.zztD, paramAdRequestParcel.zztE, paramAdRequestParcel.zztF);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */