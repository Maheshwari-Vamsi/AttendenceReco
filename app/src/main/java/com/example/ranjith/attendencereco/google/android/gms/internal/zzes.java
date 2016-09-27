package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzes
{
  public List<String> zza(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      for (int i = 0; i < localJSONArray.length(); i++) {
        localArrayList.add(localJSONArray.getString(i));
      }
      return Collections.unmodifiableList(localArrayList);
    }
    return null;
  }
  
  public void zza(Context paramContext, String paramString1, zzie paramzzie, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramzzie.zzJF.zzAT).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", zzp.zzbA().getSessionId()).replaceAll("@gw_seqnum@", paramzzie.zzGt);
        if (paramzzie.zzBp != null) {
          str2 = str2.replaceAll("@gw_adnetid@", paramzzie.zzBp.zzAF).replaceAll("@gw_allocid@", paramzzie.zzBp.zzAH);
        }
        new zziw(paramContext, paramString1, str2).zzgX();
      }
      break;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */