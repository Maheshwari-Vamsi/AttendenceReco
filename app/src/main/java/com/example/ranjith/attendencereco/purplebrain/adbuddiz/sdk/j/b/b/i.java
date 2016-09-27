package com.purplebrain.adbuddiz.sdk.j.b.b;

import android.annotation.SuppressLint;
import com.purplebrain.adbuddiz.sdk.i.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Node;

@SuppressLint({"NewApi"})
public final class i
{
  public d a = null;
  public String b;
  public Map c = new HashMap();
  
  private i() {}
  
  public i(Node paramNode)
  {
    this.a = d.a(y.e(paramNode, "event"));
    this.b = y.a(paramNode.getTextContent());
    this.c = y.a(paramNode);
  }
  
  public static i a(JSONObject paramJSONObject)
  {
    i locali = new i();
    locali.a = d.a(paramJSONObject.getString("e"));
    locali.b = paramJSONObject.getString("u");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("a");
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      String str1 = localJSONObject.getString("k");
      String str2 = localJSONObject.getString("v");
      locali.c.put(str1, str2);
    }
    return locali;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("e", this.a.w);
    localJSONObject1.put("u", this.b);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("k", localEntry.getKey());
      localJSONObject2.put("v", localEntry.getValue());
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("a", localJSONArray);
    return localJSONObject1;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */