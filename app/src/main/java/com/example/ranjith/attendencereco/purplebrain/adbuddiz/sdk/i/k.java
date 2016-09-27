package com.purplebrain.adbuddiz.sdk.i;

import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static String a(String paramString)
  {
    if (paramString != null) {
      try
      {
        String str = new JSONObject(paramString).getString("c");
        return str;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */