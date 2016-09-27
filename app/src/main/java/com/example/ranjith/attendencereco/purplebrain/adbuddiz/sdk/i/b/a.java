package com.purplebrain.adbuddiz.sdk.i.b;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.o;
import org.json.JSONArray;
import org.json.JSONException;

public final class a
{
  public static JSONArray a(Context paramContext)
  {
    JSONArray localJSONArray1 = new JSONArray();
    try
    {
      JSONArray localJSONArray2 = d.b(paramContext, "aia");
      return localJSONArray2;
    }
    catch (JSONException localJSONException)
    {
      o.a("ABAlreadyInstalledApps.getAlreadyInstalledApps()", localJSONException);
    }
    return localJSONArray1;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */