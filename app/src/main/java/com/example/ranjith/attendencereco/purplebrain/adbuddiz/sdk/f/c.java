package com.purplebrain.adbuddiz.sdk.f;

import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static b a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      b localb = new b();
      localb.a = paramJSONObject.getLong("updateTimestamp");
      localb.b = paramJSONObject.getLong("updateFrequency");
      localb.d = paramJSONObject.getLong("cacheExpiration");
      localb.c = paramJSONObject.getString("a");
      localb.e = paramJSONObject.getBoolean("isTablet");
      localb.f = paramJSONObject.getLong("publisherId");
      localb.g = paramJSONObject.getString("downloadAdBaseUrl");
      localb.h = paramJSONObject.getString("downloadVideoAdBaseUrl");
      localb.i = paramJSONObject.getString("byAdBuddizLinkUrl");
      JSONArray localJSONArray1 = paramJSONObject.getJSONArray("inactivePlacementIds");
      for (int j = 0; j < localJSONArray1.length(); j++) {
        localb.j.add(localJSONArray1.getString(j));
      }
      localb.k = paramJSONObject.getInt("maxNbAdBuddizAdInCache");
      localb.l = paramJSONObject.getInt("maxSizeRTBAdContent");
      localb.m = paramJSONObject.getInt("maxNbAdBuddizImpressionTimestampSent");
      localb.n = paramJSONObject.getInt("maxNbRTBImpressionTimestampSent");
      localb.o = paramJSONObject.getLong("maxTimeToKeepRequestInformation");
      localb.p = paramJSONObject.getInt("additionalInformationToSend");
      localb.q = paramJSONObject.getBoolean("automaticallyHideAdOnClick");
      localb.u = paramJSONObject.getLong("minTimeBeforeClickEnabled");
      if (paramJSONObject.has("minTimeBeforeClickEnabledForEndInterstitial")) {
        localb.v = Long.valueOf(paramJSONObject.getLong("minTimeBeforeClickEnabledForEndInterstitial"));
      }
      localb.w = paramJSONObject.getLong("minTimeBeforeCloseEnabledWhileFollowingLinks");
      localb.z = paramJSONObject.getLong("minTimeBeforeCloseEnabledWhenMediaPlayerStuck");
      if (paramJSONObject.has("minTimeBeforeCloseEnabledOnMRAID")) {
        localb.x = Long.valueOf(paramJSONObject.getLong("minTimeBeforeCloseEnabledOnMRAID"));
      }
      if (paramJSONObject.has("minTimeBeforeCloseEnabledOnMRAIDIfFullyLoaded")) {
        localb.y = Long.valueOf(paramJSONObject.getLong("minTimeBeforeCloseEnabledOnMRAIDIfFullyLoaded"));
      }
      localb.r = paramJSONObject.getLong("minTimeBetween2ShowAdCalls");
      localb.s = paramJSONObject.getLong("minTimeBetween2ReportOnIsReady");
      localb.t = paramJSONObject.getLong("minTimeBetween2RequestNextAdAfterNoFill");
      if (paramJSONObject.has("showAdEventsToReport"))
      {
        localb.A.clear();
        JSONArray localJSONArray3 = paramJSONObject.getJSONArray("showAdEventsToReport");
        for (int k = 0; k < localJSONArray3.length(); k++) {
          localb.A.add(AdBuddizError.valueOf(localJSONArray3.getString(k)));
        }
      }
      if (paramJSONObject.has("isReadyToShowAdEventsToReport"))
      {
        localb.B.clear();
        JSONArray localJSONArray2 = paramJSONObject.getJSONArray("isReadyToShowAdEventsToReport");
        while (i < localJSONArray2.length())
        {
          localb.B.add(AdBuddizError.valueOf(localJSONArray2.getString(i)));
          i++;
        }
      }
      if (paramJSONObject.has("afterLoadScript")) {
        localb.C = paramJSONObject.getString("afterLoadScript");
      }
      localb.D = paramJSONObject.getBoolean("mediaPlayerStartsMuted");
      localb.E = paramJSONObject.getDouble("percentageBeforeNotReportingVASTError");
      localb.F = f.a(paramJSONObject.getJSONObject("mediaFileSelectorParameters"));
      return localb;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public static JSONObject a(b paramb)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("updateTimestamp", paramb.a);
      localJSONObject.put("updateFrequency", paramb.b);
      localJSONObject.put("cacheExpiration", paramb.d);
      localJSONObject.put("a", paramb.c);
      localJSONObject.put("isTablet", paramb.e);
      localJSONObject.put("publisherId", paramb.f);
      localJSONObject.put("downloadAdBaseUrl", paramb.g);
      localJSONObject.put("downloadVideoAdBaseUrl", paramb.h);
      localJSONObject.put("byAdBuddizLinkUrl", paramb.i);
      JSONArray localJSONArray1 = new JSONArray();
      Iterator localIterator1 = paramb.j.iterator();
      while (localIterator1.hasNext()) {
        localJSONArray1.put((String)localIterator1.next());
      }
      localJSONObject.put("inactivePlacementIds", localJSONArray1);
      localJSONObject.put("maxNbAdBuddizAdInCache", paramb.k);
      localJSONObject.put("maxSizeRTBAdContent", paramb.l);
      localJSONObject.put("maxNbAdBuddizImpressionTimestampSent", paramb.m);
      localJSONObject.put("maxNbRTBImpressionTimestampSent", paramb.n);
      localJSONObject.put("maxTimeToKeepRequestInformation", paramb.o);
      localJSONObject.put("additionalInformationToSend", paramb.p);
      localJSONObject.put("automaticallyHideAdOnClick", paramb.q);
      localJSONObject.put("minTimeBeforeClickEnabled", paramb.u);
      if (paramb.v != null) {
        localJSONObject.put("minTimeBeforeClickEnabledForEndInterstitial", paramb.v);
      }
      localJSONObject.put("minTimeBeforeCloseEnabledWhileFollowingLinks", paramb.w);
      localJSONObject.put("minTimeBeforeCloseEnabledWhenMediaPlayerStuck", paramb.z);
      if (paramb.x != null) {
        localJSONObject.put("minTimeBeforeCloseEnabledOnMRAID", paramb.x);
      }
      if (paramb.y != null) {
        localJSONObject.put("minTimeBeforeCloseEnabledOnMRAIDIfFullyLoaded", paramb.y);
      }
      localJSONObject.put("minTimeBetween2ShowAdCalls", paramb.r);
      localJSONObject.put("minTimeBetween2ReportOnIsReady", paramb.s);
      localJSONObject.put("minTimeBetween2RequestNextAdAfterNoFill", paramb.t);
      JSONArray localJSONArray2 = new JSONArray();
      Iterator localIterator2 = paramb.A.iterator();
      while (localIterator2.hasNext()) {
        localJSONArray2.put(((AdBuddizError)localIterator2.next()).name());
      }
      localJSONObject.put("showAdEventsToReport", localJSONArray2);
      JSONArray localJSONArray3 = new JSONArray();
      Iterator localIterator3 = paramb.B.iterator();
      while (localIterator3.hasNext()) {
        localJSONArray3.put(((AdBuddizError)localIterator3.next()).name());
      }
      localJSONObject.put("isReadyToShowAdEventsToReport", localJSONArray3);
      if (paramb.C != null) {
        localJSONObject.put("afterLoadScript", paramb.C);
      }
      localJSONObject.put("mediaPlayerStartsMuted", paramb.D);
      localJSONObject.put("percentageBeforeNotReportingVASTError", paramb.E);
      localJSONObject.put("mediaFileSelectorParameters", paramb.F.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */