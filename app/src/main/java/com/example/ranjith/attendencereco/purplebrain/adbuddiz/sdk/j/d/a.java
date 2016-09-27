package com.purplebrain.adbuddiz.sdk.j.d;

import com.purplebrain.adbuddiz.sdk.f.a.a.c;
import com.purplebrain.adbuddiz.sdk.j.b.b.b;
import com.purplebrain.adbuddiz.sdk.j.b.b.e;
import com.purplebrain.adbuddiz.sdk.j.b.b.f;
import com.purplebrain.adbuddiz.sdk.j.b.b.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class a
{
  public static List a(c paramc, com.purplebrain.adbuddiz.sdk.j.b.b.d paramd)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramc.b("t"));
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        i locali = i.a(localJSONArray.getJSONObject(i));
        if (locali.a == paramd) {
          localArrayList.add(locali.b);
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException) {}
  }
  
  public static void a(c paramc, f paramf)
  {
    e locale = (e)paramf.a;
    com.purplebrain.adbuddiz.sdk.j.b.a.a locala = locale.a;
    paramc.a("u", paramf.f());
    com.purplebrain.adbuddiz.sdk.i.c.d.a(paramc, locale.c());
    if (locale.f()) {
      paramc.a("so", locale.g());
    }
    com.purplebrain.adbuddiz.sdk.i.c.d.a(paramc, paramf.c().intValue());
    com.purplebrain.adbuddiz.sdk.i.c.d.b(paramc, paramf.d().intValue());
    paramc.a("e", locala.b());
    paramc.a("i", locala.c());
    paramc.a("c", locale.d());
    paramc.a("ct", locale.e());
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = locale.b().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      try
      {
        localJSONArray.put(locali.a());
      }
      catch (JSONException localJSONException) {}
    }
    paramc.a("t", localJSONArray.toString());
  }
  
  public static List b(c paramc, com.purplebrain.adbuddiz.sdk.j.b.b.d paramd)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramc.b("t"));
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        i locali = i.a(localJSONArray.getJSONObject(i));
        if (locali.a == paramd) {
          localArrayList.add(locali);
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */