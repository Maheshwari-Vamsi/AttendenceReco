package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzha;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public class zzz
{
  private final zzh zzoq;
  private String zzpH;
  private boolean zzpt;
  private zza zztn;
  private AdListener zzto;
  private PlayStorePurchaseListener zzuA;
  private OnCustomRenderedAdLoadedListener zzuB;
  private Correlator zzuC;
  private boolean zzuD;
  private AppEventListener zzub;
  private AdSize[] zzuc;
  private final zzev zzuu = new zzev();
  private final AtomicBoolean zzuv;
  private zzs zzuw;
  private String zzux;
  private ViewGroup zzuy;
  private InAppPurchaseListener zzuz;
  
  public zzz(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, zzh.zzcJ(), false);
  }
  
  public zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzh.zzcJ(), false);
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, zzh paramzzh, zzs paramzzs, boolean paramBoolean2)
  {
    this.zzuy = paramViewGroup;
    this.zzoq = paramzzh;
    this.zzuw = paramzzs;
    this.zzuv = new AtomicBoolean(false);
    this.zzuD = paramBoolean2;
    Context localContext;
    if (paramAttributeSet != null) {
      localContext = paramViewGroup.getContext();
    }
    try
    {
      zzk localzzk = new zzk(localContext, paramAttributeSet);
      this.zzuc = localzzk.zzj(paramBoolean1);
      this.zzpH = localzzk.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        zzl.zzcN().zza(paramViewGroup, zza(localContext, this.zzuc[0], this.zzuD), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzl.zzcN().zza(paramViewGroup, new AdSizeParcel(localContext, AdSize.BANNER), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
    }
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, zzh paramzzh, boolean paramBoolean2)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean1, paramzzh, null, paramBoolean2);
  }
  
  public zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean1, zzh.zzcJ(), paramBoolean2);
  }
  
  public zzz(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this(paramViewGroup, null, false, zzh.zzcJ(), paramBoolean);
  }
  
  private static AdSizeParcel zza(Context paramContext, AdSize paramAdSize, boolean paramBoolean)
  {
    AdSizeParcel localAdSizeParcel = new AdSizeParcel(paramContext, paramAdSize);
    localAdSizeParcel.zzi(paramBoolean);
    return localAdSizeParcel;
  }
  
  private static AdSizeParcel zza(Context paramContext, AdSize[] paramArrayOfAdSize, boolean paramBoolean)
  {
    AdSizeParcel localAdSizeParcel = new AdSizeParcel(paramContext, paramArrayOfAdSize);
    localAdSizeParcel.zzi(paramBoolean);
    return localAdSizeParcel;
  }
  
  private void zzcZ()
  {
    try
    {
      zzd localzzd = this.zzuw.zzaO();
      if (localzzd == null) {
        return;
      }
      this.zzuy.addView((View)com.google.android.gms.dynamic.zze.zzp(localzzd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.zzuw != null) {
        this.zzuw.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.zzto;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.zzuw != null)
      {
        AdSizeParcel localAdSizeParcel = this.zzuw.zzaP();
        if (localAdSizeParcel != null)
        {
          AdSize localAdSize = localAdSizeParcel.zzcL();
          return localAdSize;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", localRemoteException);
      if (this.zzuc != null) {
        return this.zzuc[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.zzuc;
  }
  
  public String getAdUnitId()
  {
    return this.zzpH;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.zzub;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.zzuz;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (this.zzuw != null)
      {
        String str = this.zzuw.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzuB;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (this.zzuw != null)
      {
        boolean bool = this.zzuw.isLoading();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void pause()
  {
    try
    {
      if (this.zzuw != null) {
        this.zzuw.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    if (this.zzuv.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.zzuw != null)
        {
          this.zzuw.zzaR();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to record impression.", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.zzuw != null) {
        this.zzuw.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call resume.", localRemoteException);
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.zzto = paramAdListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramAdListener == null) {
          break label40;
        }
      }
      label40:
      for (zzc localzzc = new zzc(paramAdListener);; localzzc = null)
      {
        localzzs.zza(localzzc);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", localRemoteException);
    }
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.zzuc != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.zzpH != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    this.zzpH = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.zzub = paramAppEventListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramAppEventListener == null) {
          break label40;
        }
      }
      label40:
      for (zzj localzzj = new zzj(paramAppEventListener);; localzzj = null)
      {
        localzzs.zza(localzzj);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", localRemoteException);
    }
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    this.zzuC = paramCorrelator;
    try
    {
      if (this.zzuw != null)
      {
        zzs localzzs = this.zzuw;
        if (this.zzuC == null) {}
        zzm localzzm;
        for (Object localObject = null;; localObject = localzzm)
        {
          localzzs.zza((zzv)localObject);
          return;
          localzzm = this.zzuC.zzaH();
        }
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set correlator.", localRemoteException);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.zzuA != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.zzuz = paramInAppPurchaseListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramInAppPurchaseListener == null) {
          break label58;
        }
      }
      label58:
      for (zzgh localzzgh = new zzgh(paramInAppPurchaseListener);; localzzgh = null)
      {
        localzzs.zza(localzzgh);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", localRemoteException);
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzpt = paramBoolean;
    try
    {
      if (this.zzuw != null) {
        this.zzuw.setManualImpressionsEnabled(this.zzpt);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", localRemoteException);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzuB = paramOnCustomRenderedAdLoadedListener;
    try
    {
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label40;
        }
      }
      label40:
      for (zzcm localzzcm = new zzcm(paramOnCustomRenderedAdLoadedListener);; localzzcm = null)
      {
        localzzs.zza(localzzcm);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", localRemoteException);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (this.zzuz != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      this.zzuA = paramPlayStorePurchaseListener;
      this.zzux = paramString;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramPlayStorePurchaseListener == null) {
          break label66;
        }
      }
      label66:
      for (zzgl localzzgl = new zzgl(paramPlayStorePurchaseListener);; localzzgl = null)
      {
        localzzs.zza(localzzgl, paramString);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", localRemoteException);
    }
  }
  
  public void zza(zza paramzza)
  {
    try
    {
      this.zztn = paramzza;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramzza == null) {
          break label40;
        }
      }
      label40:
      for (zzb localzzb = new zzb(paramzza);; localzzb = null)
      {
        localzzs.zza(localzzb);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", localRemoteException);
    }
  }
  
  public void zza(zzy paramzzy)
  {
    try
    {
      if (this.zzuw == null) {
        zzda();
      }
      if (this.zzuw.zzb(this.zzoq.zza(this.zzuy.getContext(), paramzzy))) {
        this.zzuu.zze(paramzzy.zzcV());
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", localRemoteException);
    }
  }
  
  public void zza(AdSize... paramVarArgs)
  {
    this.zzuc = paramVarArgs;
    try
    {
      if (this.zzuw != null) {
        this.zzuw.zza(zza(this.zzuy.getContext(), this.zzuc, this.zzuD));
      }
      this.zzuy.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", localRemoteException);
      }
    }
  }
  
  void zzda()
    throws RemoteException
  {
    if (((this.zzuc == null) || (this.zzpH == null)) && (this.zzuw == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    this.zzuw = zzdb();
    if (this.zzto != null) {
      this.zzuw.zza(new zzc(this.zzto));
    }
    if (this.zztn != null) {
      this.zzuw.zza(new zzb(this.zztn));
    }
    if (this.zzub != null) {
      this.zzuw.zza(new zzj(this.zzub));
    }
    if (this.zzuz != null) {
      this.zzuw.zza(new zzgh(this.zzuz));
    }
    if (this.zzuA != null) {
      this.zzuw.zza(new zzgl(this.zzuA), this.zzux);
    }
    if (this.zzuB != null) {
      this.zzuw.zza(new zzcm(this.zzuB));
    }
    if (this.zzuC != null) {
      this.zzuw.zza(this.zzuC.zzaH());
    }
    this.zzuw.setManualImpressionsEnabled(this.zzpt);
    zzcZ();
  }
  
  protected zzs zzdb()
    throws RemoteException
  {
    Context localContext = this.zzuy.getContext();
    return zzl.zzcO().zza(localContext, zza(localContext, this.zzuc, this.zzuD), this.zzpH, this.zzuu);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */