package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzha
public class zzh
{
  public static final zzh zztU = new zzh();
  
  public static zzh zzcJ()
  {
    return zztU;
  }
  
  public AdRequestParcel zza(Context paramContext, zzy paramzzy)
  {
    Date localDate = paramzzy.getBirthday();
    long l;
    String str1;
    int i;
    List localList;
    label57:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    SearchAdRequest localSearchAdRequest;
    if (localDate != null)
    {
      l = localDate.getTime();
      str1 = paramzzy.getContentUrl();
      i = paramzzy.getGender();
      Set localSet = paramzzy.getKeywords();
      if (localSet.isEmpty()) {
        break label231;
      }
      localList = Collections.unmodifiableList(new ArrayList(localSet));
      bool1 = paramzzy.isTestDevice(paramContext);
      j = paramzzy.zzcX();
      localLocation = paramzzy.getLocation();
      localBundle = paramzzy.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramzzy.getManualImpressionsEnabled();
      str2 = paramzzy.getPublisherProvidedId();
      localSearchAdRequest = paramzzy.zzcU();
      if (localSearchAdRequest == null) {
        break label237;
      }
    }
    label231:
    label237:
    for (SearchAdRequestParcel localSearchAdRequestParcel = new SearchAdRequestParcel(localSearchAdRequest);; localSearchAdRequestParcel = null)
    {
      Context localContext = paramContext.getApplicationContext();
      String str3 = null;
      if (localContext != null)
      {
        String str4 = localContext.getPackageName();
        str3 = zzp.zzbx().zza(Thread.currentThread().getStackTrace(), str4);
      }
      boolean bool3 = paramzzy.isDesignedForFamilies();
      return new AdRequestParcel(7, l, localBundle, i, localList, bool1, j, bool2, str2, localSearchAdRequestParcel, localLocation, str1, paramzzy.zzcW(), paramzzy.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(paramzzy.zzcY())), paramzzy.zzcT(), str3, bool3);
      l = -1L;
      break;
      localList = null;
      break label57;
    }
  }
  
  public RewardedVideoAdRequestParcel zza(Context paramContext, zzy paramzzy, String paramString)
  {
    return new RewardedVideoAdRequestParcel(zza(paramContext, paramzzy), paramString);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */