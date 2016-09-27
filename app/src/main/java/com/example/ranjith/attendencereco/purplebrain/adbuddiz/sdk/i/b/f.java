package com.purplebrain.adbuddiz.sdk.i.b;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.a.b;
import org.json.JSONArray;
import org.json.JSONException;

public final class f
{
  public static void a(Context paramContext, a parama)
  {
    switch (1.a[parama.e().ordinal()])
    {
    default: 
      return;
    }
    long l = ((b)parama).g;
    new Object[1][0] = Long.valueOf(l);
    try
    {
      JSONArray localJSONArray = d.b(paramContext, "uc");
      localJSONArray.put(l);
      d.a(paramContext, "uc", localJSONArray);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */