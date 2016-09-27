package com.purplebrain.adbuddiz.sdk.h.a;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.i.q;
import org.json.JSONObject;

public final class d
{
  String a;
  String b;
  String c;
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pk", this.a);
    localJSONObject.put("v", this.b);
    localJSONObject.put("t", this.c);
    return localJSONObject;
  }
  
  public static final class a
  {
    public static d a(Context paramContext)
    {
      d locald = new d();
      locald.a = q.b(paramContext);
      locald.b = AdBuddiz.getVersion();
      locald.c = AdBuddiz.getType();
      return locald;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */