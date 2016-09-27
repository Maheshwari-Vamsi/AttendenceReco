package com.purplebrain.adbuddiz.sdk.f.a;

import com.purplebrain.adbuddiz.sdk.f.a.a.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class c
  extends b
{
  public String l;
  public Map m;
  public String n;
  public String o;
  public Long p;
  public Integer q;
  public Integer r;
  
  private void a(JSONObject paramJSONObject, String paramString, com.purplebrain.adbuddiz.sdk.f.a.a.d paramd, boolean paramBoolean)
  {
    if (paramJSONObject.has(paramString))
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext()) {
        try
        {
          String str = (String)localIterator.next();
          URL localURL = new URL(localJSONObject.getString(str));
          a(new f(this, paramd, str, paramBoolean, com.purplebrain.adbuddiz.sdk.f.e.c, localURL));
        }
        catch (MalformedURLException localMalformedURLException) {}
      }
    }
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    super.b(paramJSONObject);
    this.l = paramJSONObject.getString("h");
    this.o = paramJSONObject.getString("w");
    this.m = new HashMap();
    JSONObject localJSONObject = paramJSONObject.getJSONObject("tk");
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = localJSONObject.getString(str1);
      this.m.put(str1, str2);
    }
    if (paramJSONObject.has("ts")) {
      this.n = paramJSONObject.getString("ts");
    }
    if ((paramJSONObject.has("d")) && (paramJSONObject.has("vw")) && (paramJSONObject.has("vh")))
    {
      this.p = Long.valueOf(paramJSONObject.getLong("d"));
      this.q = Integer.valueOf(paramJSONObject.getInt("vw"));
      this.r = Integer.valueOf(paramJSONObject.getInt("vh"));
    }
    a(paramJSONObject, "cr", com.purplebrain.adbuddiz.sdk.f.a.a.d.b, false);
    a(paramJSONObject, "a", com.purplebrain.adbuddiz.sdk.f.a.a.d.c, true);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    super.c(paramJSONObject);
    paramJSONObject.put("h", this.l);
    paramJSONObject.put("w", this.o);
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.m.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
    }
    paramJSONObject.put("tk", localJSONObject);
    if (this.n != null) {
      paramJSONObject.put("ts", this.n);
    }
    if ((this.p != null) && (this.q != null) && (this.r != null))
    {
      paramJSONObject.put("d", this.p);
      paramJSONObject.put("vw", this.q);
      paramJSONObject.put("vh", this.r);
    }
  }
  
  public final Collection d()
  {
    ArrayList localArrayList = new ArrayList(h());
    try
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.b localb = new com.purplebrain.adbuddiz.sdk.f.a.a.b(this);
      localb.a("isVideo", "true");
      if ((this.p != null) && (this.q != null) && (this.r != null))
      {
        com.purplebrain.adbuddiz.sdk.i.c.d.a(localb, this.p.longValue());
        com.purplebrain.adbuddiz.sdk.i.c.d.a(localb, this.q.intValue());
        com.purplebrain.adbuddiz.sdk.i.c.d.b(localb, this.r.intValue());
      }
      localArrayList.add(localb);
      return localArrayList;
    }
    catch (MalformedURLException localMalformedURLException) {}
    return localArrayList;
  }
  
  public final e e()
  {
    return e.b;
  }
  
  public final d f()
  {
    return d.b;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */