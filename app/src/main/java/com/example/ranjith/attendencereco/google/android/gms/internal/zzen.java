package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzen
{
  public final List<zzem> zzAO;
  public final long zzAP;
  public final List<String> zzAQ;
  public final List<String> zzAR;
  public final List<String> zzAS;
  public final String zzAT;
  public final long zzAU;
  public final String zzAV;
  public final int zzAW;
  public final int zzAX;
  public final long zzAY;
  public int zzAZ;
  public int zzBa;
  
  public zzen(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    if (zzb.zzQ(2)) {
      zzb.v("Mediation Response JSON: " + localJSONObject1.toString(2));
    }
    JSONArray localJSONArray1 = localJSONObject1.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray1.length());
    int i = 0;
    int j = -1;
    while (i < localJSONArray1.length())
    {
      zzem localzzem = new zzem(localJSONArray1.getJSONObject(i));
      localArrayList.add(localzzem);
      if ((j < 0) && (zza(localzzem))) {
        j = i;
      }
      i++;
    }
    this.zzAZ = j;
    this.zzBa = localJSONArray1.length();
    this.zzAO = Collections.unmodifiableList(localArrayList);
    this.zzAT = localJSONObject1.getString("qdata");
    this.zzAX = localJSONObject1.optInt("fs_model_type", -1);
    this.zzAY = localJSONObject1.optLong("timeout_ms", -1L);
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("settings");
    if (localJSONObject2 != null)
    {
      this.zzAP = localJSONObject2.optLong("ad_network_timeout_millis", -1L);
      this.zzAQ = zzp.zzbK().zza(localJSONObject2, "click_urls");
      this.zzAR = zzp.zzbK().zza(localJSONObject2, "imp_urls");
      this.zzAS = zzp.zzbK().zza(localJSONObject2, "nofill_urls");
      long l1 = localJSONObject2.optLong("refresh", -1L);
      if (l1 > 0L) {}
      JSONArray localJSONArray2;
      for (long l2 = l1 * 1000L;; l2 = -1L)
      {
        this.zzAU = l2;
        localJSONArray2 = localJSONObject2.optJSONArray("rewards");
        if ((localJSONArray2 != null) && (localJSONArray2.length() != 0)) {
          break;
        }
        this.zzAV = null;
        this.zzAW = 0;
        return;
      }
      this.zzAV = localJSONArray2.getJSONObject(0).optString("rb_type");
      this.zzAW = localJSONArray2.getJSONObject(0).optInt("rb_amount");
      return;
    }
    this.zzAP = -1L;
    this.zzAQ = null;
    this.zzAR = null;
    this.zzAS = null;
    this.zzAU = -1L;
    this.zzAV = null;
    this.zzAW = 0;
  }
  
  private boolean zza(zzem paramzzem)
  {
    Iterator localIterator = paramzzem.zzAG.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */