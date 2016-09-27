package com.purplebrain.adbuddiz.sdk.g;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint({"NewApi"})
public final class e
{
  public Map a = new HashMap();
  
  public final String a()
  {
    Iterator localIterator = this.a.keySet().iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      switch (1.a[((a)this.a.get(str)).ordinal()])
      {
      }
      for (int m = i;; m = i + 1)
      {
        i = m;
        break;
        k++;
        break;
        j++;
        break;
      }
    }
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(j);
    arrayOfObject[1] = Integer.valueOf(i + (j + k));
    arrayOfObject[2] = Integer.valueOf(i);
    return String.format(localLocale, "%d / %d err: %d", arrayOfObject);
  }
  
  public final boolean b()
  {
    synchronized (this.a)
    {
      if (this.a.size() == 0) {
        return false;
      }
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.a.get(str) != a.b)
        {
          new StringBuilder("wasFullyLoaded: false - ").append(a());
          return false;
        }
      }
      return true;
    }
  }
  
  public static enum a
  {
    private String d;
    
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      e = arrayOfa;
    }
    
    private a(String paramString1)
    {
      this.d = paramString1;
    }
    
    public static a a(String paramString)
    {
      for (a locala : ) {
        if (locala.d.equals(paramString)) {
          return locala;
        }
      }
      return null;
    }
    
    public static a[] a()
    {
      return (a[])e.clone();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */