package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzha
public final class zzdt
  implements zzdl
{
  private final Map<zzjn, Integer> zzzi = new WeakHashMap();
  
  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null) {}
    try
    {
      int i = zzl.zzcN().zzb(paramContext, Integer.parseInt(str));
      paramInt = i;
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzb.zzaH("Could not parse " + paramString + " in a video GMSG: " + str);
    }
    return paramInt;
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if (str1 == null) {
      zzb.zzaH("Action missing from video GMSG.");
    }
    zzjm localzzjm1;
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      if (zzb.zzQ(3))
      {
        JSONObject localJSONObject = new JSONObject(paramMap);
        localJSONObject.remove("google.afma.Notify_dt");
        zzb.zzaF("Video GMSG: " + str1 + " " + localJSONObject.toString());
      }
      if ("background".equals(str1))
      {
        String str4 = (String)paramMap.get("color");
        if (TextUtils.isEmpty(str4))
        {
          zzb.zzaH("Color parameter missing from color video GMSG.");
          return;
        }
        int i5;
        try
        {
          i5 = Color.parseColor(str4);
          zzjm localzzjm2 = paramzzjn.zzhJ();
          if (localzzjm2 != null)
          {
            zzk localzzk3 = localzzjm2.zzhv();
            if (localzzk3 != null)
            {
              localzzk3.setBackgroundColor(i5);
              return;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          zzb.zzaH("Invalid color parameter in video GMSG.");
          return;
        }
        this.zzzi.put(paramzzjn, Integer.valueOf(i5));
        return;
      }
      localzzjm1 = paramzzjn.zzhJ();
      if (localzzjm1 == null)
      {
        zzb.zzaH("Could not get underlay container for a video GMSG.");
        return;
      }
      boolean bool1 = "new".equals(str1);
      boolean bool2 = "position".equals(str1);
      if ((!bool1) && (!bool2)) {
        break label401;
      }
      Context localContext1 = paramzzjn.getContext();
      i = zza(localContext1, paramMap, "x", 0);
      j = zza(localContext1, paramMap, "y", 0);
      k = zza(localContext1, paramMap, "w", -1);
      m = zza(localContext1, paramMap, "h", -1);
      try
      {
        int i2 = Integer.parseInt((String)paramMap.get("player"));
        n = i2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          int i1;
          zzk localzzk1;
          int n = 0;
        }
        localzzjm1.zze(i, j, k, m);
        return;
      }
      if ((!bool1) || (localzzjm1.zzhv() != null)) {
        break;
      }
      localzzjm1.zza(i, j, k, m, n);
    } while (!this.zzzi.containsKey(paramzzjn));
    i1 = ((Integer)this.zzzi.get(paramzzjn)).intValue();
    localzzk1 = localzzjm1.zzhv();
    localzzk1.setBackgroundColor(i1);
    localzzk1.zzft();
    return;
    label401:
    zzk localzzk2 = localzzjm1.zzhv();
    if (localzzk2 == null)
    {
      zzk.zzd(paramzzjn);
      return;
    }
    if ("click".equals(str1))
    {
      Context localContext2 = paramzzjn.getContext();
      int i3 = zza(localContext2, paramMap, "x", 0);
      int i4 = zza(localContext2, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, i3, i4, 0);
      localzzk2.zzd(localMotionEvent);
      localMotionEvent.recycle();
      return;
    }
    if ("currentTime".equals(str1))
    {
      String str3 = (String)paramMap.get("time");
      if (str3 == null)
      {
        zzb.zzaH("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        localzzk2.seekTo((int)(1000.0F * Float.parseFloat(str3)));
        return;
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        zzb.zzaH("Could not parse time parameter from currentTime video GMSG: " + str3);
        return;
      }
    }
    if ("hide".equals(str1))
    {
      localzzk2.setVisibility(4);
      return;
    }
    if ("load".equals(str1))
    {
      localzzk2.zzfs();
      return;
    }
    if ("mimetype".equals(str1))
    {
      localzzk2.setMimeType((String)paramMap.get("mimetype"));
      return;
    }
    if ("muted".equals(str1))
    {
      if (Boolean.parseBoolean((String)paramMap.get("muted")))
      {
        localzzk2.zzeU();
        return;
      }
      localzzk2.zzeV();
      return;
    }
    if ("pause".equals(str1))
    {
      localzzk2.pause();
      return;
    }
    if ("play".equals(str1))
    {
      localzzk2.play();
      return;
    }
    if ("show".equals(str1))
    {
      localzzk2.setVisibility(0);
      return;
    }
    if ("src".equals(str1))
    {
      localzzk2.zzao((String)paramMap.get("src"));
      return;
    }
    if ("volume".equals(str1))
    {
      String str2 = (String)paramMap.get("volume");
      if (str2 == null)
      {
        zzb.zzaH("Level parameter missing from volume video GMSG.");
        return;
      }
      try
      {
        localzzk2.zza(Float.parseFloat(str2));
        return;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        zzb.zzaH("Could not parse volume parameter from volume video GMSG: " + str2);
        return;
      }
    }
    if ("watermark".equals(str1))
    {
      localzzk2.zzft();
      return;
    }
    zzb.zzaH("Unknown video action: " + str1);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */