package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

public final class a
{
  public static Rect a(Context paramContext, RectF paramRectF)
  {
    Rect localRect = new Rect();
    m localm = m.a(paramContext);
    localRect.left = k.a(paramContext, (int)(26.0D * localm.e * paramRectF.left));
    localRect.top = k.a(paramContext, (int)(26.0D * localm.f * paramRectF.top) + localm.g);
    localRect.right = k.a(paramContext, (int)(26.0D * localm.e * paramRectF.right));
    localRect.bottom = k.a(paramContext, (int)(26.0D * localm.e * paramRectF.bottom));
    return localRect;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */