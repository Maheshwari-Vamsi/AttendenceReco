package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@zzha
public class zzed
{
  private final Map<zzee, zzef> zzzS = new HashMap();
  private final LinkedList<zzee> zzzT = new LinkedList();
  private zzea zzzU;
  
  private static void zza(String paramString, zzee paramzzee)
  {
    if (zzb.zzQ(2)) {
      zzb.v(String.format(paramString, new Object[] { paramzzee }));
    }
  }
  
  private String[] zzad(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\000");
      for (int i = 0; i < arrayOfString.length; i++) {
        arrayOfString[i] = new String(Base64.decode(arrayOfString[i], 0), "UTF-8");
      }
      return arrayOfString;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      arrayOfString = new String[0];
    }
  }
  
  private String zzdY()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.zzzT.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(Base64.encodeToString(((zzee)localIterator.next()).toString().getBytes("UTF-8"), 0));
        if (localIterator.hasNext()) {
          localStringBuilder.append("\000");
        }
      }
      str = localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return "";
    }
    String str;
    return str;
  }
  
  void flush()
  {
    while (this.zzzT.size() > 0)
    {
      zzee localzzee = (zzee)this.zzzT.remove();
      zzef localzzef = (zzef)this.zzzS.get(localzzee);
      zza("Flushing interstitial queue for %s.", localzzee);
      while (localzzef.size() > 0) {
        localzzef.zzec().zzzX.zzbo();
      }
      this.zzzS.remove(localzzee);
    }
  }
  
  void restore()
  {
    if (this.zzzU == null) {}
    for (;;)
    {
      return;
      SharedPreferences localSharedPreferences = this.zzzU.zzdW().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
      flush();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = localSharedPreferences.getAll().entrySet().iterator();
      label51:
      Map.Entry localEntry;
      if (localIterator.hasNext()) {
        localEntry = (Map.Entry)localIterator.next();
      }
      try
      {
        if (((String)localEntry.getKey()).equals("PoolKeys")) {
          break label51;
        }
        zzeh localzzeh = new zzeh((String)localEntry.getValue());
        zzee localzzee2 = new zzee(localzzeh.zzqo, localzzeh.zzpH);
        if (this.zzzS.containsKey(localzzee2)) {
          break label51;
        }
        zzef localzzef = new zzef(localzzeh.zzqo, localzzeh.zzpH);
        this.zzzS.put(localzzee2, localzzef);
        localHashMap.put(localzzee2.toString(), localzzee2);
        zza("Restored interstitial queue for %s.", localzzee2);
      }
      catch (IOException localIOException)
      {
        zzb.zzd("Malformed preferences value for InterstitialAdPool.", localIOException);
        break label51;
        String[] arrayOfString = zzad(localSharedPreferences.getString("PoolKeys", ""));
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          zzee localzzee1 = (zzee)localHashMap.get(arrayOfString[j]);
          if (this.zzzS.containsKey(localzzee1)) {
            this.zzzT.add(localzzee1);
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;) {}
      }
    }
  }
  
  void save()
  {
    if (this.zzzU == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.zzzU.zzdW().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
    localEditor.clear();
    Iterator localIterator = this.zzzS.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      zzee localzzee = (zzee)localEntry.getKey();
      if (localzzee.zzea())
      {
        zzef localzzef = (zzef)localEntry.getValue();
        String str = new zzeh(localzzef.zzeb(), localzzef.getAdUnitId()).zzef();
        localEditor.putString(localzzee.toString(), str);
        zza("Saved interstitial queue for %s.", localzzee);
      }
    }
    localEditor.putString("PoolKeys", zzdY());
    localEditor.commit();
  }
  
  zzef.zza zza(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    zzee localzzee1 = new zzee(paramAdRequestParcel, paramString);
    zzef localzzef1 = (zzef)this.zzzS.get(localzzee1);
    zzef localzzef4;
    if (localzzef1 == null)
    {
      zza("Interstitial pool created at %s.", localzzee1);
      localzzef4 = new zzef(paramAdRequestParcel, paramString);
      this.zzzS.put(localzzee1, localzzef4);
    }
    for (zzef localzzef2 = localzzef4;; localzzef2 = localzzef1)
    {
      this.zzzT.remove(localzzee1);
      this.zzzT.add(localzzee1);
      localzzee1.zzdZ();
      while (this.zzzT.size() > ((Integer)zzbz.zzwl.get()).intValue())
      {
        zzee localzzee2 = (zzee)this.zzzT.remove();
        zzef localzzef3 = (zzef)this.zzzS.get(localzzee2);
        zza("Evicting interstitial queue for %s.", localzzee2);
        while (localzzef3.size() > 0) {
          localzzef3.zzec().zzzX.zzbo();
        }
        this.zzzS.remove(localzzee2);
      }
      while (localzzef2.size() > 0)
      {
        zzef.zza localzza = localzzef2.zzec();
        if ((localzza.zzAa) && (zzp.zzbB().currentTimeMillis() - localzza.zzzZ > 1000L * ((Integer)zzbz.zzwn.get()).intValue()))
        {
          zza("Expired interstitial at %s.", localzzee1);
        }
        else
        {
          zza("Pooled interstitial returned at %s.", localzzee1);
          return localzza;
        }
      }
      return null;
    }
  }
  
  void zza(zzea paramzzea)
  {
    if (this.zzzU == null)
    {
      this.zzzU = paramzzea;
      restore();
    }
  }
  
  void zzdX()
  {
    if (this.zzzU == null) {
      return;
    }
    Iterator localIterator = this.zzzS.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      zzee localzzee = (zzee)localEntry.getKey();
      zzef localzzef = (zzef)localEntry.getValue();
      while (localzzef.size() < ((Integer)zzbz.zzwm.get()).intValue())
      {
        zza("Pooling one interstitial for %s.", localzzee);
        localzzef.zzb(this.zzzU);
      }
    }
    save();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */