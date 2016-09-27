package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.e;

public final class d
{
  public static e a()
  {
    Context localContext = AdBuddiz.getContext();
    Display localDisplay = ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {
      return e.a;
    }
    if (localDisplay.getWidth() > localDisplay.getHeight()) {
      return e.b;
    }
    int i = localContext.getResources().getConfiguration().orientation;
    if (i == 1) {
      return e.a;
    }
    if (i == 2) {
      return e.b;
    }
    return e.a;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */