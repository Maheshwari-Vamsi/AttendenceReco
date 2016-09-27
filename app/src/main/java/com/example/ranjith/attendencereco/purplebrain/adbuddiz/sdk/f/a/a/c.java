package com.purplebrain.adbuddiz.sdk.f.a.a;

import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.e;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c
{
  public a a = null;
  public d b = null;
  public e c = null;
  public boolean d = false;
  private Map e = new HashMap();
  
  public c(a parama, d paramd, boolean paramBoolean, e parame)
  {
    this.a = parama;
    this.b = paramd;
    this.d = paramBoolean;
    this.c = parame;
  }
  
  public String a()
  {
    return this.a.b();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
  }
  
  public final void a(String paramString, List paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    this.e.put(paramString, localJSONArray.toString());
  }
  
  public final boolean a(String paramString)
  {
    return this.e.containsKey(paramString);
  }
  
  public abstract String b();
  
  public final String b(String paramString)
  {
    return (String)this.e.get(paramString);
  }
  
  public final List c(String paramString)
  {
    localArrayList = new ArrayList();
    String str = (String)this.e.get(paramString);
    if (str != null) {
      try
      {
        JSONArray localJSONArray = new JSONArray(str);
        for (int i = 0; i < localJSONArray.length(); i++) {
          localArrayList.add(localJSONArray.getString(i));
        }
        return localArrayList;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public abstract boolean c();
  
  public abstract URL d();
  
  public abstract boolean e();
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (!(paramObject instanceof c));
    return b().equals(((c)paramObject).b());
  }
  
  public abstract String f();
  
  public final JSONObject g()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("t", this.b.d);
    localJSONObject1.put("p", this.d);
    localJSONObject1.put("o", this.c.d);
    localJSONObject1.put("ai", a());
    localJSONObject1.put("n", b());
    if (c()) {}
    try
    {
      localJSONObject1.put("u", d());
      if (e()) {
        localJSONObject1.put("c", f());
      }
      HashMap localHashMap = new HashMap(this.e);
      JSONObject localJSONObject2 = new JSONObject();
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
      }
      localJSONObject1.put("ps", localJSONObject2);
      return localJSONObject1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
  
  private static final class a
    extends c
  {
    private String e = null;
    private String f = null;
    private boolean g = false;
    private String h = null;
    private boolean i = false;
    private String j = null;
    
    public a(a parama, d paramd, boolean paramBoolean, e parame, JSONObject paramJSONObject)
    {
      super(paramd, paramBoolean, parame);
      this.e = paramJSONObject.getString("ai");
      this.f = paramJSONObject.getString("n");
      if (paramJSONObject.has("u"))
      {
        this.g = true;
        this.h = paramJSONObject.getString("u");
      }
      if (paramJSONObject.has("c"))
      {
        this.i = true;
        this.j = paramJSONObject.getString("c");
      }
      JSONObject localJSONObject = paramJSONObject.getJSONObject("ps");
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(str, localJSONObject.getString(str));
      }
    }
    
    public final String a()
    {
      return this.e;
    }
    
    public final String b()
    {
      return this.f;
    }
    
    public final boolean c()
    {
      return this.g;
    }
    
    public final URL d()
    {
      if (this.h == null) {
        return null;
      }
      return new URL(this.h);
    }
    
    public final boolean e()
    {
      return this.i;
    }
    
    public final String f()
    {
      return this.j;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */