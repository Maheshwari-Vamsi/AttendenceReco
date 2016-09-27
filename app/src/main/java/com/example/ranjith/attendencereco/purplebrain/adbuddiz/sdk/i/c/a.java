package com.purplebrain.adbuddiz.sdk.i.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public long a;
  
  private a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public static a a(String paramString, long paramLong)
  {
    if (paramString.contains("%")) {
      return c(paramString, paramLong);
    }
    return b(paramString, paramLong);
  }
  
  public static a b(String paramString, long paramLong)
  {
    Matcher localMatcher = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})(\\.([0-9]{3}))?").matcher(paramString);
    if (!localMatcher.matches()) {
      return null;
    }
    for (;;)
    {
      long l1;
      long l2;
      long l3;
      long l4;
      try
      {
        l1 = Integer.parseInt(localMatcher.group(1));
        l2 = Integer.parseInt(localMatcher.group(2));
        l3 = Integer.parseInt(localMatcher.group(3));
        l4 = 0L;
        if ((localMatcher.groupCount() <= 3) || (localMatcher.group(5) == null)) {
          break label108;
        }
        l4 = Integer.parseInt(localMatcher.group(5));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        a locala;
        return null;
      }
      locala = new a(paramLong);
      return locala;
      label108:
      long l5;
      do
      {
        Object localObject;
        paramLong = localObject;
        break;
        l5 = l4 + (l1 * 3600000L + l2 * 60000L + 1000L * l3);
      } while (l5 <= paramLong);
    }
  }
  
  private static a c(String paramString, long paramLong)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(0, -1 + paramString.length()));
      if ((i < 0) || (i > 100)) {
        throw new IllegalArgumentException();
      }
      a locala = new a((i / 100.0D * paramLong));
      return locala;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */