package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.purplebrain.adbuddiz.sdk.f.e;

public enum m
{
  double e;
  double f;
  int g;
  
  static
  {
    m[] arrayOfm = new m[4];
    arrayOfm[0] = a;
    arrayOfm[1] = b;
    arrayOfm[2] = c;
    arrayOfm[3] = d;
    h = arrayOfm;
  }
  
  private m(double paramDouble1, double paramDouble2, int paramInt1)
  {
    this.e = paramDouble1;
    this.f = paramDouble2;
    this.g = paramInt1;
  }
  
  public static m a(Context paramContext)
  {
    int i = 1;
    DisplayMetrics localDisplayMetrics1 = paramContext.getResources().getDisplayMetrics();
    double d1 = localDisplayMetrics1.widthPixels / localDisplayMetrics1.densityDpi;
    double d2 = localDisplayMetrics1.heightPixels / localDisplayMetrics1.densityDpi;
    double d3 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    if (d.a() == e.a)
    {
      DisplayMetrics localDisplayMetrics3 = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics3.heightPixels / localDisplayMetrics3.density >= 470.0D) {}
    }
    while (i != 0)
    {
      return a;
      i = 0;
      continue;
      DisplayMetrics localDisplayMetrics2 = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics2.widthPixels / localDisplayMetrics2.density >= 470.0D) {
        i = 0;
      }
    }
    if (d3 >= 9.0D) {
      return d;
    }
    if (d3 >= 6.0D) {
      return c;
    }
    return b;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */