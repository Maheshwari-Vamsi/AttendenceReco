package com.purplebrain.adbuddiz.sdk.i.b;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.h.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  public static JSONArray a(Context paramContext)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    JSONArray localJSONArray1 = d.b(paramContext, "r");
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < localJSONArray1.length(); i++)
    {
      JSONObject localJSONObject = localJSONArray1.getJSONObject(i);
      h localh = new h();
      localh.a = localJSONObject.getString("r");
      localh.b = localJSONObject.getLong("t");
      localh.c = localJSONObject.getLong("d");
      localh.d = localJSONObject.getLong("rs");
      localh.e = localJSONObject.getLong("s");
      if (localJSONObject.has("nt")) {
        localh.f = Integer.valueOf(localJSONObject.getInt("nt"));
      }
      if (localJSONObject.has("nst")) {
        localh.g = Integer.valueOf(localJSONObject.getInt("nst"));
      }
      long l = System.currentTimeMillis() - localh.b;
      if ((localb == null) || ((l >= 0L) && (l < localb.o))) {
        localArrayList.add(localh);
      }
    }
    JSONArray localJSONArray2 = new JSONArray();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray2.put(((h)localIterator.next()).a());
    }
    return localJSONArray2;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */