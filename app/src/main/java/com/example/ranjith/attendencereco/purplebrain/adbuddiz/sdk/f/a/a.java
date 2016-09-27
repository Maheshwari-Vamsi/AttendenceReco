package com.purplebrain.adbuddiz.sdk.f.a;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.f.a.a.c.a;
import com.purplebrain.adbuddiz.sdk.i.h;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a
{
  public com.purplebrain.adbuddiz.sdk.f.e a = null;
  public boolean b;
  protected long c;
  protected int d = 0;
  public Set e = new HashSet();
  
  public static a a(JSONObject paramJSONObject)
  {
    e locale = e.a(paramJSONObject.getString("at"));
    int i = 1.a[locale.ordinal()];
    Object localObject = null;
    switch (i)
    {
    default: 
      if (paramJSONObject.has("fo")) {
        ((a)localObject).a = com.purplebrain.adbuddiz.sdk.f.e.a(paramJSONObject.getString("fo"));
      }
      if (paramJSONObject.has("in")) {
        ((a)localObject).b = paramJSONObject.getBoolean("in");
      }
      if (!paramJSONObject.has("ct")) {
        break;
      }
    }
    for (((a)localObject).c = paramJSONObject.getLong("ct");; ((a)localObject).c = h.a().getTime())
    {
      ((a)localObject).d = paramJSONObject.getInt("ce");
      if (!paramJSONObject.has("r")) {
        break label250;
      }
      JSONArray localJSONArray = paramJSONObject.getJSONArray("r");
      for (int j = 0; j < localJSONArray.length(); j++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(j);
        ((a)localObject).a(new c.a((a)localObject, com.purplebrain.adbuddiz.sdk.f.a.a.d.a(localJSONObject.getString("t")), localJSONObject.getBoolean("p"), com.purplebrain.adbuddiz.sdk.f.e.a(localJSONObject.getString("o")), localJSONObject));
      }
      localObject = new b();
      break;
      localObject = new c();
      break;
      localObject = new f();
      break;
    }
    label250:
    ((a)localObject).b(paramJSONObject);
    return (a)localObject;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("at", e().d);
    localJSONObject.put("in", this.b);
    if (this.a != null) {
      localJSONObject.put("fo", this.a);
    }
    localJSONObject.put("ct", this.c);
    localJSONObject.put("ce", this.d);
    synchronized (this.e)
    {
      if (!this.e.isEmpty())
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.e.iterator();
        if (localIterator.hasNext())
        {
          localJSONArray.put(((com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next()).g());
          localJSONObject.put("r", localJSONArray);
        }
      }
    }
    c(localJSONObject);
    return localJSONObject;
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject.put("at", e().d);
    paramJSONObject.put("in", this.b);
  }
  
  public final void a(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    synchronized (this.e)
    {
      this.e.add(paramc);
      return;
    }
  }
  
  public abstract String b();
  
  protected abstract void b(JSONObject paramJSONObject);
  
  public abstract com.purplebrain.adbuddiz.sdk.f.e c();
  
  protected abstract void c(JSONObject paramJSONObject);
  
  public abstract Collection d();
  
  public abstract e e();
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof a)) {
      return false;
    }
    return b().equals(((a)paramObject).b());
  }
  
  public abstract d f();
  
  public final boolean g()
  {
    return (this.a != null) && (this.a != com.purplebrain.adbuddiz.sdk.f.e.c);
  }
  
  public final Collection h()
  {
    synchronized (this.e)
    {
      Collection localCollection = Collections.unmodifiableCollection(this.e);
      return localCollection;
    }
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
  
  public final long i()
  {
    return this.c;
  }
  
  public final int j()
  {
    return 1000 * this.d;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */