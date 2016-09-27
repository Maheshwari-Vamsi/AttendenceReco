package com.purplebrain.adbuddiz.sdk.j.b.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum d
{
  public String w;
  private List x = new ArrayList();
  
  static
  {
    d[] arrayOfd = new d[22];
    arrayOfd[0] = a;
    arrayOfd[1] = b;
    arrayOfd[2] = c;
    arrayOfd[3] = d;
    arrayOfd[4] = e;
    arrayOfd[5] = f;
    arrayOfd[6] = g;
    arrayOfd[7] = h;
    arrayOfd[8] = i;
    arrayOfd[9] = j;
    arrayOfd[10] = k;
    arrayOfd[11] = l;
    arrayOfd[12] = m;
    arrayOfd[13] = n;
    arrayOfd[14] = o;
    arrayOfd[15] = p;
    arrayOfd[16] = q;
    arrayOfd[17] = r;
    arrayOfd[18] = s;
    arrayOfd[19] = t;
    arrayOfd[20] = u;
    arrayOfd[21] = v;
    y = arrayOfd;
  }
  
  private d(String paramString1, String... paramVarArgs)
  {
    this.w = paramString1;
    this.x.addAll(Arrays.asList(paramVarArgs));
  }
  
  public static d a(String paramString)
  {
    for (d locald : (d[])y.clone()) {
      if (locald.w.equals(paramString)) {
        return locald;
      }
    }
    return v;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */