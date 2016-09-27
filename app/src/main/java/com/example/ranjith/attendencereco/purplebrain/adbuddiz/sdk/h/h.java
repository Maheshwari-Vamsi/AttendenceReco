package com.purplebrain.adbuddiz.sdk.h;

import org.json.JSONObject;

public final class h
{
  public String a;
  public long b;
  public long c;
  public long d = 0L;
  public long e = 0L;
  public Integer f = null;
  public Integer g = null;
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("r", this.a);
    localJSONObject.put("t", this.b);
    localJSONObject.put("d", this.c);
    localJSONObject.put("rs", this.d);
    localJSONObject.put("s", this.e);
    if (this.f != null) {
      localJSONObject.put("nt", this.f);
    }
    if (this.g != null) {
      localJSONObject.put("nst", this.g);
    }
    return localJSONObject;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */