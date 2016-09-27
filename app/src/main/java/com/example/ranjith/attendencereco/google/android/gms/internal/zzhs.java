package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@zzha
public class zzhs
  extends com.google.android.gms.ads.internal.zzb
  implements zzhw
{
  private zzd zzJf;
  private String zzJg;
  private boolean zzJh;
  private HashMap<String, zzht> zzJi = new HashMap();
  
  public zzhs(Context paramContext, AdSizeParcel paramAdSizeParcel, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, null, paramzzew, paramVersionInfoParcel, null);
  }
  
  public void destroy()
  {
    zzx.zzcx("destroy must be called on the main UI thread.");
    Iterator localIterator = this.zzJi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzht localzzht = (zzht)this.zzJi.get(str);
        if ((localzzht != null) && (localzzht.zzgA() != null)) {
          localzzht.zzgA().destroy();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to destroy adapter: " + str);
      }
    }
  }
  
  public boolean isLoaded()
  {
    zzx.zzcx("isLoaded must be called on the main UI thread.");
    return (this.zzoZ.zzqT == null) && (this.zzoZ.zzqU == null) && (this.zzoZ.zzqW != null) && (!this.zzJh);
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    zza(this.zzoZ.zzqW, false);
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", localRemoteException);
    }
  }
  
  public void onRewardedVideoStarted()
  {
    zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAM);
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoStarted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
  
  public void pause()
  {
    zzx.zzcx("pause must be called on the main UI thread.");
    Iterator localIterator = this.zzJi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzht localzzht = (zzht)this.zzJi.get(str);
        if ((localzzht != null) && (localzzht.zzgA() != null)) {
          localzzht.zzgA().pause();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to pause adapter: " + str);
      }
    }
  }
  
  public void resume()
  {
    zzx.zzcx("resume must be called on the main UI thread.");
    Iterator localIterator = this.zzJi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzht localzzht = (zzht)this.zzJi.get(str);
        if ((localzzht != null) && (localzzht.zzgA() != null)) {
          localzzht.zzgA().resume();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to resume adapter: " + str);
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    zzx.zzcx("setUserId must be called on the main UI thread.");
    this.zzJg = paramString;
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    zzx.zzcx("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(paramRewardedVideoAdRequestParcel.zzqP))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid ad unit id. Aborting.");
      return;
    }
    this.zzJh = false;
    this.zzoZ.zzqP = paramRewardedVideoAdRequestParcel.zzqP;
    super.zzb(paramRewardedVideoAdRequestParcel.zzGq);
  }
  
  public void zza(zzd paramzzd)
  {
    zzx.zzcx("setRewardedVideoAdListener must be called on the main UI thread.");
    this.zzJf = paramzzd;
  }
  
  public void zza(RewardItemParcel paramRewardItemParcel)
  {
    zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAN);
    if (this.zzJf == null) {
      return;
    }
    try
    {
      if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzJF != null) && (!TextUtils.isEmpty(this.zzoZ.zzqW.zzJF.zzAV)))
      {
        this.zzJf.zza(new zzhq(this.zzoZ.zzqW.zzJF.zzAV, this.zzoZ.zzqW.zzJF.zzAW));
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", localRemoteException);
      return;
    }
    this.zzJf.zza(new zzhq(paramRewardItemParcel.type, paramRewardItemParcel.zzJD));
  }
  
  public void zza(final zzie.zza paramzza, zzch paramzzch)
  {
    if (paramzza.errorCode != -2)
    {
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          zzhs.this.zzb(new zzie(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    this.zzoZ.zzrp = 0;
    this.zzoZ.zzqU = new zzhz(this.zzoZ.context, this.zzJg, paramzza, this);
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + this.zzoZ.zzqU.getClass().getName());
    this.zzoZ.zzqU.zzfR();
  }
  
  public boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    if (this.zzJf != null) {}
    try
    {
      this.zzJf.onRewardedVideoAdLoaded();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", localRemoteException);
      }
    }
  }
  
  /* Error */
  public zzht zzav(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/google/android/gms/internal/zzhs:zzJi	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 65	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 67	com/google/android/gms/internal/zzht
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +34 -> 47
    //   16: new 67	com/google/android/gms/internal/zzht
    //   19: dup
    //   20: aload_0
    //   21: getfield 332	com/google/android/gms/internal/zzhs:zzpd	Lcom/google/android/gms/internal/zzew;
    //   24: aload_1
    //   25: invokeinterface 338 2 0
    //   30: aload_0
    //   31: invokespecial 341	com/google/android/gms/internal/zzht:<init>	(Lcom/google/android/gms/internal/zzex;Lcom/google/android/gms/internal/zzhw;)V
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 28	com/google/android/gms/internal/zzhs:zzJi	Ljava/util/HashMap;
    //   39: aload_1
    //   40: aload_3
    //   41: invokevirtual 345	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_3
    //   46: astore_2
    //   47: aload_2
    //   48: areturn
    //   49: astore 5
    //   51: new 77	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 347
    //   61: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: aload 5
    //   73: invokestatic 129	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_2
    //   77: areturn
    //   78: astore 4
    //   80: aload_3
    //   81: astore_2
    //   82: aload 4
    //   84: astore 5
    //   86: goto -35 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzhs
    //   0	89	1	paramString	String
    //   11	71	2	localObject1	Object
    //   34	47	3	localzzht	zzht
    //   78	5	4	localException1	Exception
    //   49	23	5	localException2	Exception
    //   84	1	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	35	49	java/lang/Exception
    //   35	45	78	java/lang/Exception
  }
  
  protected boolean zzf(int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load ad: " + paramInt);
    this.zzoX = false;
    if (this.zzJf == null) {
      return false;
    }
    try
    {
      this.zzJf.onRewardedVideoAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  public void zzgy()
  {
    zzx.zzcx("showAd must be called on the main UI thread.");
    if (!isLoaded()) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("The reward video has not loaded.");
    }
    zzht localzzht;
    do
    {
      return;
      this.zzJh = true;
      localzzht = zzav(this.zzoZ.zzqW.zzBr);
    } while ((localzzht == null) || (localzzht.zzgA() == null));
    try
    {
      localzzht.zzgA().showVideo();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", localRemoteException);
    }
  }
  
  public void zzgz()
  {
    onAdClicked();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */