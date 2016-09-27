package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzem
{
  public final String zzAE;
  public final String zzAF;
  public final List<String> zzAG;
  public final String zzAH;
  public final String zzAI;
  public final List<String> zzAJ;
  public final List<String> zzAK;
  public final String zzAL;
  public final List<String> zzAM;
  public final List<String> zzAN;
  
  public zzem(JSONObject paramJSONObject)
    throws JSONException
  {
    this.zzAF = paramJSONObject.getString("id");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    for (int i = 0; i < localJSONArray.length(); i++) {
      localArrayList.add(localJSONArray.getString(i));
    }
    this.zzAG = Collections.unmodifiableList(localArrayList);
    this.zzAH = paramJSONObject.optString("allocation_id", null);
    this.zzAJ = zzp.zzbK().zza(paramJSONObject, "clickurl");
    this.zzAK = zzp.zzbK().zza(paramJSONObject, "imp_urls");
    this.zzAM = zzp.zzbK().zza(paramJSONObject, "video_start_urls");
    this.zzAN = zzp.zzbK().zza(paramJSONObject, "video_complete_urls");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ad");
    String str1;
    JSONObject localJSONObject2;
    if (localJSONObject1 != null)
    {
      str1 = localJSONObject1.toString();
      this.zzAE = str1;
      localJSONObject2 = paramJSONObject.optJSONObject("data");
      if (localJSONObject2 == null) {
        break label217;
      }
    }
    label217:
    for (String str2 = localJSONObject2.toString();; str2 = null)
    {
      this.zzAL = str2;
      String str3 = null;
      if (localJSONObject2 != null) {
        str3 = localJSONObject2.optString("class_name");
      }
      this.zzAI = str3;
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */