package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.DisplayMetrics;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzjn;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzha
public abstract class zzb
  extends zza
  implements com.google.android.gms.ads.internal.overlay.zzg, zzj, zzdn, zzeo
{
  private final Messenger mMessenger;
  protected final zzew zzpd;
  protected transient boolean zzpe;
  
  public zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    this(new zzq(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramzzew, null, paramzzd);
  }
  
  zzb(zzq paramzzq, zzew paramzzew, zzo paramzzo, zzd paramzzd)
  {
    super(paramzzq, paramzzo, paramzzd);
    this.zzpd = paramzzew;
    this.mMessenger = new Messenger(new zzfz(this.zzoZ.context));
    this.zzpe = false;
  }
  
  private AdRequestInfoParcel.zza zza(AdRequestParcel paramAdRequestParcel, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = this.zzoZ.context.getApplicationInfo();
    PackageInfo localPackageInfo1;
    try
    {
      PackageInfo localPackageInfo2 = this.zzoZ.context.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localPackageInfo1 = localPackageInfo2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        zzq.zza localzza;
        ViewParent localViewParent;
        int[] arrayOfInt;
        int m;
        int n;
        int i1;
        int i2;
        boolean bool4;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        localPackageInfo1 = null;
      }
    }
    DisplayMetrics localDisplayMetrics = this.zzoZ.context.getResources().getDisplayMetrics();
    localzza = this.zzoZ.zzqS;
    Bundle localBundle1 = null;
    if (localzza != null)
    {
      localViewParent = this.zzoZ.zzqS.getParent();
      localBundle1 = null;
      if (localViewParent != null)
      {
        arrayOfInt = new int[2];
        this.zzoZ.zzqS.getLocationOnScreen(arrayOfInt);
        m = arrayOfInt[0];
        n = arrayOfInt[1];
        i1 = this.zzoZ.zzqS.getWidth();
        i2 = this.zzoZ.zzqS.getHeight();
        bool4 = this.zzoZ.zzqS.isShown();
        i3 = 0;
        if (bool4)
        {
          i4 = m + i1;
          i3 = 0;
          if (i4 > 0)
          {
            i5 = n + i2;
            i3 = 0;
            if (i5 > 0)
            {
              i6 = localDisplayMetrics.widthPixels;
              i3 = 0;
              if (m <= i6)
              {
                i7 = localDisplayMetrics.heightPixels;
                i3 = 0;
                if (n <= i7) {
                  i3 = 1;
                }
              }
            }
          }
        }
        localBundle1 = new Bundle(5);
        localBundle1.putInt("x", m);
        localBundle1.putInt("y", n);
        localBundle1.putInt("width", i1);
        localBundle1.putInt("height", i2);
        localBundle1.putInt("visible", i3);
      }
    }
    String str1 = zzp.zzbA().zzgK();
    this.zzoZ.zzqY = new zzif(str1, this.zzoZ.zzqP);
    this.zzoZ.zzqY.zzj(paramAdRequestParcel);
    String str2 = zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqS, this.zzoZ.zzqV);
    long l1 = 0L;
    if (this.zzoZ.zzrc != null) {}
    try
    {
      long l2 = this.zzoZ.zzrc.getValue();
      l1 = l2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        int i;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot get correlation id, default to 0.");
      }
    }
    String str3 = UUID.randomUUID().toString();
    Bundle localBundle2 = zzp.zzbA().zza(this.zzoZ.context, this, str1);
    ArrayList localArrayList = new ArrayList();
    for (i = 0; i < this.zzoZ.zzri.size(); i++) {
      localArrayList.add(this.zzoZ.zzri.keyAt(i));
    }
    boolean bool1;
    if (this.zzoZ.zzrd != null)
    {
      bool1 = true;
      if ((this.zzoZ.zzre == null) || (!zzp.zzbA().zzgT())) {
        break label699;
      }
    }
    label699:
    for (boolean bool2 = true;; bool2 = false)
    {
      AdSizeParcel localAdSizeParcel = this.zzoZ.zzqV;
      String str4 = this.zzoZ.zzqP;
      String str5 = zzp.zzbA().getSessionId();
      VersionInfoParcel localVersionInfoParcel = this.zzoZ.zzqR;
      List localList1 = this.zzoZ.zzrl;
      boolean bool3 = zzp.zzbA().zzgO();
      Messenger localMessenger = this.mMessenger;
      int j = localDisplayMetrics.widthPixels;
      int k = localDisplayMetrics.heightPixels;
      float f = localDisplayMetrics.density;
      List localList2 = zzbz.zzdl();
      String str6 = this.zzoZ.zzqO;
      NativeAdOptionsParcel localNativeAdOptionsParcel = this.zzoZ.zzrj;
      CapabilityParcel localCapabilityParcel = new CapabilityParcel(bool1, bool2);
      return new AdRequestInfoParcel.zza(localBundle1, paramAdRequestParcel, localAdSizeParcel, str4, localApplicationInfo, localPackageInfo1, str1, str5, localVersionInfoParcel, localBundle2, localList1, localArrayList, paramBundle, bool3, localMessenger, j, k, f, str2, l1, str3, localList2, str6, localNativeAdOptionsParcel, localCapabilityParcel, this.zzoZ.zzbU());
      bool1 = false;
      break;
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (this.zzoZ.zzqW == null) {
      return null;
    }
    return this.zzoZ.zzqW.zzBr;
  }
  
  public void onAdClicked()
  {
    if (this.zzoZ.zzqW == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((this.zzoZ.zzqW.zzJF != null) && (this.zzoZ.zzqW.zzJF.zzAQ != null)) {
      zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzJF.zzAQ);
    }
    if ((this.zzoZ.zzqW.zzBp != null) && (this.zzoZ.zzqW.zzBp.zzAJ != null)) {
      zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAJ);
    }
    super.onAdClicked();
  }
  
  public void pause()
  {
    zzx.zzcx("pause must be called on the main UI thread.");
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzDC != null) && (this.zzoZ.zzbQ())) {
      zzp.zzbz().zzf(this.zzoZ.zzqW.zzDC);
    }
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzBq != null)) {}
    try
    {
      this.zzoZ.zzqW.zzBq.pause();
      this.zzpb.zzg(this.zzoZ.zzqW);
      this.zzoY.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    zzx.zzcx("resume must be called on the main UI thread.");
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzDC != null) && (this.zzoZ.zzbQ())) {
      zzp.zzbz().zzg(this.zzoZ.zzqW.zzDC);
    }
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzBq != null)) {}
    try
    {
      this.zzoZ.zzqW.zzBq.resume();
      this.zzoY.resume();
      this.zzpb.zzh(this.zzoZ.zzqW);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }
  
  public void zza(zzgc paramzzgc)
  {
    zzx.zzcx("setInAppPurchaseListener must be called on the main UI thread.");
    this.zzoZ.zzrd = paramzzgc;
  }
  
  public void zza(zzgg paramzzgg, String paramString)
  {
    zzx.zzcx("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.zzoZ.zzrm = new zzk(paramString);
    this.zzoZ.zzre = paramzzgg;
    if ((!zzp.zzbA().zzgN()) && (paramzzgg != null)) {
      new zzc(this.zzoZ.context, this.zzoZ.zzre, this.zzoZ.zzrm).zzgX();
    }
  }
  
  protected void zza(zzie paramzzie, boolean paramBoolean)
  {
    if (paramzzie == null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      super.zzc(paramzzie);
      if ((paramzzie.zzJF != null) && (paramzzie.zzJF.zzAR != null)) {
        zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie, this.zzoZ.zzqP, paramBoolean, paramzzie.zzJF.zzAR);
      }
    } while ((paramzzie.zzBp == null) || (paramzzie.zzBp.zzAK == null));
    zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie, this.zzoZ.zzqP, paramBoolean, paramzzie.zzBp.zzAK);
  }
  
  public void zza(String paramString, ArrayList<String> paramArrayList)
  {
    com.google.android.gms.ads.internal.purchase.zzd localzzd = new com.google.android.gms.ads.internal.purchase.zzd(paramString, paramArrayList, this.zzoZ.context, this.zzoZ.zzqR.afmaVersion);
    if (this.zzoZ.zzrd == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (!zzl.zzcN().zzT(this.zzoZ.context))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (this.zzoZ.zzre == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseListener is not set.");
        return;
      }
      if (this.zzoZ.zzrm == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (this.zzoZ.zzrq)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("An in-app purchase request is already in progress, abort");
        return;
      }
      this.zzoZ.zzrq = true;
      try
      {
        if (!this.zzoZ.zzre.isValidPurchase(paramString))
        {
          this.zzoZ.zzrq = false;
          return;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
        this.zzoZ.zzrq = false;
        return;
      }
      zzp.zzbH().zza(this.zzoZ.context, this.zzoZ.zzqR.zzLH, new GInAppPurchaseManagerInfoParcel(this.zzoZ.context, this.zzoZ.zzrm, localzzd, this));
      return;
    }
    try
    {
      this.zzoZ.zzrd.zza(localzzd);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, zzf paramzzf)
  {
    try
    {
      if (this.zzoZ.zzre != null) {
        this.zzoZ.zzre.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzoZ.context, paramString, paramBoolean, paramInt, paramIntent, paramzzf));
      }
      zzip.zzKO.postDelayed(new Runnable()
      {
        public void run()
        {
          int i = zzp.zzbH().zzd(paramIntent);
          zzp.zzbH();
          if ((i == 0) && (zzb.this.zzoZ.zzqW != null) && (zzb.this.zzoZ.zzqW.zzDC != null) && (zzb.this.zzoZ.zzqW.zzDC.zzhA() != null)) {
            zzb.this.zzoZ.zzqW.zzDC.zzhA().close();
          }
          zzb.this.zzoZ.zzrq = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzch paramzzch)
  {
    if (!zzaW()) {
      return false;
    }
    Bundle localBundle = zza(zzp.zzbA().zzG(this.zzoZ.context));
    this.zzoY.cancel();
    this.zzoZ.zzrp = 0;
    AdRequestInfoParcel.zza localzza = zza(paramAdRequestParcel, localBundle);
    paramzzch.zzd("seq_num", localzza.zzGt);
    paramzzch.zzd("request_id", localzza.zzGF);
    paramzzch.zzd("session_id", localzza.zzGu);
    if (localzza.zzGr != null) {
      paramzzch.zzd("app_version", String.valueOf(localzza.zzGr.versionCode));
    }
    this.zzoZ.zzqT = zzp.zzbt().zza(this.zzoZ.context, localzza, this.zzoZ.zzqQ, this);
    return true;
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzie paramzzie, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.zzoZ.zzbQ()))
    {
      if (paramzzie.zzAU <= 0L) {
        break label43;
      }
      this.zzoY.zza(paramAdRequestParcel, paramzzie.zzAU);
    }
    for (;;)
    {
      return this.zzoY.zzbr();
      label43:
      if ((paramzzie.zzJF != null) && (paramzzie.zzJF.zzAU > 0L)) {
        this.zzoY.zza(paramAdRequestParcel, paramzzie.zzJF.zzAU);
      } else if ((!paramzzie.zzGN) && (paramzzie.errorCode == 2)) {
        this.zzoY.zzg(paramAdRequestParcel);
      }
    }
  }
  
  boolean zza(zzie paramzzie)
  {
    boolean bool = false;
    AdRequestParcel localAdRequestParcel;
    if (this.zzpa != null)
    {
      localAdRequestParcel = this.zzpa;
      this.zzpa = null;
    }
    for (;;)
    {
      return zza(localAdRequestParcel, paramzzie, bool);
      localAdRequestParcel = paramzzie.zzGq;
      Bundle localBundle = localAdRequestParcel.extras;
      bool = false;
      if (localBundle != null) {
        bool = localAdRequestParcel.extras.getBoolean("_noRefresh", false);
      }
    }
  }
  
  protected boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    if ((paramzzie1 != null) && (paramzzie1.zzBs != null)) {
      paramzzie1.zzBs.zza(null);
    }
    if (paramzzie2.zzBs != null) {
      paramzzie2.zzBs.zza(this);
    }
    int j;
    int i;
    if (paramzzie2.zzJF != null)
    {
      j = paramzzie2.zzJF.zzAZ;
      i = paramzzie2.zzJF.zzBa;
    }
    for (;;)
    {
      this.zzoZ.zzrn.zzg(j, i);
      return true;
      i = 0;
      j = 0;
    }
  }
  
  protected boolean zzaW()
  {
    boolean bool = true;
    if ((!zzp.zzbx().zza(this.zzoZ.context.getPackageManager(), this.zzoZ.context.getPackageName(), "android.permission.INTERNET")) || (!zzp.zzbx().zzJ(this.zzoZ.context))) {
      bool = false;
    }
    return bool;
  }
  
  public void zzaX()
  {
    this.zzpb.zze(this.zzoZ.zzqW);
    this.zzpe = false;
    zzaS();
    this.zzoZ.zzqY.zzgF();
  }
  
  public void zzaY()
  {
    this.zzpe = true;
    zzaU();
  }
  
  public void zzaZ()
  {
    onAdClicked();
  }
  
  public void zzb(zzie paramzzie)
  {
    super.zzb(paramzzie);
    if ((paramzzie.errorCode == 3) && (paramzzie.zzJF != null) && (paramzzie.zzJF.zzAS != null))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging no fill URLs.");
      zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie, this.zzoZ.zzqP, false, paramzzie.zzJF.zzAS);
    }
  }
  
  public void zzba()
  {
    zzaX();
  }
  
  public void zzbb()
  {
    zzaQ();
  }
  
  public void zzbc()
  {
    zzaY();
  }
  
  public void zzbd()
  {
    if (this.zzoZ.zzqW != null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Mediation adapter " + this.zzoZ.zzqW.zzBr + " refreshed, but mediation adapters should never refresh.");
    }
    zza(this.zzoZ.zzqW, true);
    zzaV();
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    return (super.zzc(paramAdRequestParcel)) && (!this.zzpe);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */