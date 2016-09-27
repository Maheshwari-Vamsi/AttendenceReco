package com.purplebrain.adbuddiz.sdk.f;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class f
{
  public String a;
  public double b;
  public double c;
  public double d;
  public Map e = new HashMap();
  public int f;
  public double g;
  public double h;
  
  public static f a(JSONObject paramJSONObject)
  {
    f localf = new f();
    localf.a = paramJSONObject.getString("t");
    localf.b = paramJSONObject.getDouble("s");
    localf.c = paramJSONObject.getDouble("d");
    localf.d = paramJSONObject.getDouble("u");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("f");
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Double localDouble = Double.valueOf(localJSONObject.getDouble(str));
      localf.e.put(str, localDouble);
    }
    localf.f = paramJSONObject.getInt("b");
    localf.g = paramJSONObject.getDouble("bs");
    localf.h = paramJSONObject.getDouble("bps");
    return localf;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("t", this.a);
    localJSONObject1.put("s", this.b);
    localJSONObject1.put("d", this.c);
    localJSONObject1.put("u", this.d);
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
    }
    localJSONObject1.put("f", localJSONObject2);
    localJSONObject1.put("b", this.f);
    localJSONObject1.put("bs", this.g);
    localJSONObject1.put("bps", this.h);
    return localJSONObject1;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */