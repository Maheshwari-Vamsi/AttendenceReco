package com.purplebrain.adbuddiz.sdk.e.a.a;

import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoError;
import com.purplebrain.adbuddiz.sdk.f.d;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.h.i;
import com.purplebrain.adbuddiz.sdk.h.i.a;
import com.purplebrain.adbuddiz.sdk.i.p;
import java.util.Arrays;
import java.util.List;

public final class c
  extends b
{
  private static List i;
  
  static
  {
    AdBuddizRewardedVideoError[] arrayOfAdBuddizRewardedVideoError = new AdBuddizRewardedVideoError[3];
    arrayOfAdBuddizRewardedVideoError[0] = AdBuddizRewardedVideoError.NETWORK_TOO_SLOW;
    arrayOfAdBuddizRewardedVideoError[1] = AdBuddizRewardedVideoError.UNSUPPORTED_DEVICE;
    arrayOfAdBuddizRewardedVideoError[2] = AdBuddizRewardedVideoError.UNSUPPORTED_OS_VERSION;
    i = Arrays.asList(arrayOfAdBuddizRewardedVideoError);
  }
  
  public c(com.purplebrain.adbuddiz.sdk.e.c paramc)
  {
    super(paramc);
  }
  
  public final String a()
  {
    return "next_incent";
  }
  
  public final void a(i parami)
  {
    super.a(parami);
    d locald = new d(d.a.d, null);
    com.purplebrain.adbuddiz.sdk.c.b.a();
    com.purplebrain.adbuddiz.sdk.c.b.a(locald, AdBuddizRewardedVideoError.NO_MORE_AVAILABLE_ADS, null, true, true);
  }
  
  public final void a(i parami, i.a parama, String paramString)
  {
    super.a(parami, parama, paramString);
    AdBuddizRewardedVideoError localAdBuddizRewardedVideoError = parama.f;
    int j = 0;
    if (localAdBuddizRewardedVideoError == null) {}
    for (;;)
    {
      if (j != 0)
      {
        d locald = new d(d.a.d, null);
        com.purplebrain.adbuddiz.sdk.c.b.a();
        com.purplebrain.adbuddiz.sdk.c.b.a(locald, localAdBuddizRewardedVideoError, paramString, true, true);
      }
      return;
      boolean bool = i.contains(localAdBuddizRewardedVideoError);
      j = 0;
      if (bool) {
        j = 1;
      }
    }
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final p e()
  {
    return p.a(true);
  }
  
  public final i f()
  {
    i locali = new i();
    locali.e = true;
    return locali;
  }
  
  public final void g()
  {
    super.g();
    d locald = new d(d.a.d, null);
    AdBuddizRewardedVideoError localAdBuddizRewardedVideoError = AdBuddizRewardedVideoError.NO_MORE_AVAILABLE_ADS;
    i.a locala = this.c;
    String str = null;
    if (locala != null)
    {
      localAdBuddizRewardedVideoError = this.c.f;
      str = this.d;
    }
    com.purplebrain.adbuddiz.sdk.c.b.a();
    com.purplebrain.adbuddiz.sdk.c.b.a(locald, localAdBuddizRewardedVideoError, str, true, true);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */