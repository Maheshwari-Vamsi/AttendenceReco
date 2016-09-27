package com.purplebrain.adbuddiz.sdk.f.a;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.f.a.a.g;
import com.purplebrain.adbuddiz.sdk.i.b.c;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  public String f;
  public String g;
  public String h;
  public String i;
  public Integer j;
  public Integer k;
  public String l;
  
  public final void a(Context paramContext, JSONObject paramJSONObject)
  {
    super.a(paramContext, paramJSONObject);
    paramJSONObject.put("ir", this.f);
    paramJSONObject.put("ri", c.a(paramContext, false));
    if (this.b) {
      paramJSONObject.put("rii", c.a(paramContext, true));
    }
  }
  
  public final String b()
  {
    return this.f;
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject.getString("i");
    this.g = paramJSONObject.getString("c");
    if (paramJSONObject.has("afs")) {
      this.i = paramJSONObject.getString("afs");
    }
    if ((paramJSONObject.has("ow")) && (paramJSONObject.has("oh")))
    {
      this.j = Integer.valueOf(paramJSONObject.getInt("oh"));
      this.k = Integer.valueOf(paramJSONObject.getInt("ow"));
    }
    this.l = paramJSONObject.getString("w");
    if (paramJSONObject.has("ts")) {
      this.h = paramJSONObject.getString("ts");
    }
    JSONArray localJSONArray;
    int m;
    if (paramJSONObject.has("cr"))
    {
      localJSONArray = paramJSONObject.getJSONArray("cr");
      m = 0;
    }
    for (;;)
    {
      if (m < localJSONArray.length()) {}
      try
      {
        URL localURL = new URL(localJSONArray.getString(m));
        a(new com.purplebrain.adbuddiz.sdk.f.a.a.e(this, com.purplebrain.adbuddiz.sdk.f.a.a.d.b, false, com.purplebrain.adbuddiz.sdk.f.e.c, localURL));
        m++;
        continue;
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;) {}
      }
    }
  }
  
  public final com.purplebrain.adbuddiz.sdk.f.e c()
  {
    return com.purplebrain.adbuddiz.sdk.f.e.c;
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    paramJSONObject.put("i", this.f);
    paramJSONObject.put("c", this.g);
    paramJSONObject.put("w", this.l);
    if (this.i != null) {
      paramJSONObject.put("afs", this.i);
    }
    if ((this.j != null) && (this.k != null))
    {
      paramJSONObject.put("ow", this.k);
      paramJSONObject.put("oh", this.j);
    }
    if (this.h != null) {
      paramJSONObject.put("ts", this.h);
    }
  }
  
  public final Collection d()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.g != null) && (this.g.length() > 0)) {
      localArrayList.add(new g(this, f().f, com.purplebrain.adbuddiz.sdk.f.e.c, this.g));
    }
    localArrayList.addAll(h());
    return localArrayList;
  }
  
  public final e e()
  {
    return e.c;
  }
  
  public final d f()
  {
    if (this.g.contains("<VAST")) {
      return d.d;
    }
    return d.c;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */