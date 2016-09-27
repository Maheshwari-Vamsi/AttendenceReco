package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public final class k
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return (int)TypedValue.applyDimension(1, paramInt, localDisplayMetrics);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */