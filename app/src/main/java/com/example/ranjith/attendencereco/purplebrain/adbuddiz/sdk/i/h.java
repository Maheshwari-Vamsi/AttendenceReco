package com.purplebrain.adbuddiz.sdk.i;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class h
{
  public static Date a()
  {
    return Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
  }
  
  public static boolean a(Long paramLong, int paramInt)
  {
    if (paramLong == null) {}
    while ((paramLong.longValue() + paramInt <= System.currentTimeMillis()) || (paramLong.longValue() - 1L >= System.currentTimeMillis())) {
      return false;
    }
    return true;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */