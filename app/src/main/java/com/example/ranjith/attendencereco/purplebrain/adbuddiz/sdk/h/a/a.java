package com.purplebrain.adbuddiz.sdk.h.a;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.a.c;
import org.json.JSONObject;

public final class a
{
  String a;
  int b;
  String c;
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pa", this.a);
    localJSONObject.put("vc", this.b);
    localJSONObject.put("vn", this.c);
    return localJSONObject;
  }
  
  public static final class a
  {
    public static a a(Context paramContext)
    {
      a locala = new a();
      locala.a = paramContext.getPackageName();
      locala.b = c.a(paramContext);
      locala.c = c.b(paramContext);
      return locala;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */