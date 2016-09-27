package com.purplebrain.adbuddiz.sdk.i.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;

public final class l
{
  @SuppressLint({"NewApi"})
  public static DisplayMetrics a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      Display localDisplay = ((DisplayManager)paramContext.getSystemService("display")).getDisplay(0);
      if (localDisplay != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localDisplay.getRealMetrics(localDisplayMetrics);
        return localDisplayMetrics;
      }
      return null;
    }
    return paramContext.getResources().getDisplayMetrics();
  }
  
  public static float b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static enum a
  {
    public String c;
    
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      d = arrayOfa;
    }
    
    private a(String paramString1)
    {
      this.c = paramString1;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */