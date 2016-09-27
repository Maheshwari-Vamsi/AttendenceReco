package com.purplebrain.adbuddiz.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.purplebrain.adbuddiz.sdk.a.c.a;
import com.purplebrain.adbuddiz.sdk.a.c.b;
import com.purplebrain.adbuddiz.sdk.a.c.c;
import com.purplebrain.adbuddiz.sdk.a.c.d;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.h.g;
import com.purplebrain.adbuddiz.sdk.i.i;
import com.purplebrain.adbuddiz.sdk.i.i.4;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.p;
import com.purplebrain.adbuddiz.sdk.i.r;
import java.util.List;
import org.json.JSONObject;

public class AdBuddizActivity
  extends Activity
{
  public static final String EXTRA_AD = "a";
  public static final String EXTRA_FULLSCREEN = "fs";
  public static final String EXTRA_NAVIGATION_BAR_COLOR = "snc";
  public static final String EXTRA_PLACEMENT = "p";
  public static final String EXTRA_STATUS_BAR_COLOR = "sbc";
  public static final String EXTRA_SYSTEM_UI_FLAGS = "suf";
  public static final String EXTRA_WITHOUT_TITLE = "wt";
  private static boolean a = false;
  private com.purplebrain.adbuddiz.sdk.f.a.a b;
  private String c;
  private com.purplebrain.adbuddiz.sdk.a.c d;
  private View e;
  private boolean f = false;
  private boolean g = false;
  private c.d h = new c.d()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa, String paramAnonymousString, Boolean paramAnonymousBoolean)
    {
      if (!AdBuddizActivity.a(AdBuddizActivity.this))
      {
        AdBuddizActivity.b(AdBuddizActivity.this);
        com.purplebrain.adbuddiz.sdk.h.d locald = new com.purplebrain.adbuddiz.sdk.h.d();
        locald.e = paramAnonymousa;
        locald.f = paramAnonymousString;
        locald.g = paramAnonymousBoolean;
        locald.f();
      }
    }
  };
  private c.a i = new c.a()
  {
    public final void a()
    {
      String str = com.purplebrain.adbuddiz.sdk.e.b.a().b().i;
      AdBuddizActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
    
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa)
    {
      com.purplebrain.adbuddiz.sdk.h.c localc = new com.purplebrain.adbuddiz.sdk.h.c();
      localc.e = paramAnonymousa;
      localc.f = AdBuddizActivity.c(AdBuddizActivity.this);
      localc.f();
      if (!paramAnonymousa.b) {
        i.a(new i.4());
      }
    }
  };
  private c.c j = new c.c()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa)
    {
      if (!paramAnonymousa.b) {
        i.a();
      }
      if (paramAnonymousa.b)
      {
        if (!AdBuddizActivity.a(AdBuddizActivity.this)) {
          break label47;
        }
        r.a();
      }
      for (;;)
      {
        p.a(paramAnonymousa.b).a = Long.valueOf(System.currentTimeMillis());
        return;
        label47:
        r.b();
      }
    }
  };
  private c.b k = new c.b()
  {
    public final void a(Throwable paramAnonymousThrowable)
    {
      if (com.purplebrain.adbuddiz.sdk.e.b.a().b().A.contains(AdBuddizError.INVALID_AD))
      {
        com.purplebrain.adbuddiz.sdk.f.d locald = new com.purplebrain.adbuddiz.sdk.f.d(d.a.b, AdBuddizActivity.c(AdBuddizActivity.this));
        g localg = new g();
        localg.g = AdBuddizActivity.d(AdBuddizActivity.this);
        localg.a(AdBuddizError.INVALID_AD);
        localg.a(paramAnonymousThrowable);
        localg.i = locald;
        localg.f();
      }
      if (AdBuddizActivity.d(AdBuddizActivity.this).b)
      {
        if (!AdBuddizActivity.a(AdBuddizActivity.this)) {
          break label112;
        }
        r.a();
      }
      for (;;)
      {
        AdBuddizActivity.this.finish();
        return;
        label112:
        r.b();
      }
    }
  };
  
  private void a(View paramView)
  {
    paramView.setBackgroundDrawable(null);
    if (paramView.getBackground() != null) {
      paramView.getBackground().setCallback(null);
    }
    if ((paramView instanceof ImageView))
    {
      ImageView localImageView = (ImageView)paramView;
      if (localImageView.getDrawable() != null)
      {
        localImageView.getDrawable().setCallback(null);
        localImageView.setImageDrawable(null);
      }
    }
    if (paramView.getResources() != null) {
      paramView.getResources().flushLayoutCache();
    }
    paramView.destroyDrawingCache();
    if ((paramView instanceof ViewGroup))
    {
      for (int m = 0; m < ((ViewGroup)paramView).getChildCount(); m++) {
        a(((ViewGroup)paramView).getChildAt(m));
      }
      ((ViewGroup)paramView).removeAllViews();
    }
  }
  
  public static boolean isAdOnScreen()
  {
    return a;
  }
  
  public boolean hasHardwareAcceleration()
  {
    try
    {
      if ((getWindow() != null) && ((0x1000000 & getWindow().getAttributes().flags) != 0)) {
        return true;
      }
      int m = getPackageManager().getActivityInfo(getComponentName(), 0).flags;
      if ((m & 0x200) != 0) {
        break label55;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return false;
    label55:
    return true;
  }
  
  public void onBackPressed()
  {
    try
    {
      if (!this.f) {
        this.f = this.d.t();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("AdBuddizActivity.onBackPressed", this.b, localThrowable);
      o.a("AdBuddizActivity.onBackPressed() Exception : ", localThrowable);
    }
  }
  
  @TargetApi(11)
  protected void onCreate(Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        a = true;
        super.onCreate(paramBundle);
        if (AdBuddiz.getContext() == null) {
          AdBuddiz.a(this);
        }
        Bundle localBundle1 = getIntent().getExtras();
        if ((localBundle1 == null) || (!localBundle1.containsKey("p")) || (!localBundle1.containsKey("a")))
        {
          o.b("invalid AdBuddizActivity intent.");
          finish();
          return;
        }
        this.c = localBundle1.getString("p");
        this.b = com.purplebrain.adbuddiz.sdk.f.a.a.a(new JSONObject(localBundle1.getString("a")));
        Bundle localBundle2 = getIntent().getExtras();
        getWindow().addFlags(128);
        if ((localBundle2.containsKey("wt")) && (localBundle2.getBoolean("wt"))) {
          requestWindowFeature(1);
        }
        if ((localBundle2.containsKey("fs")) && (localBundle2.getBoolean("fs"))) {
          getWindow().addFlags(1024);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          if ((localBundle2.containsKey("sbc")) || (localBundle2.containsKey("snc"))) {
            getWindow().addFlags(Integer.MIN_VALUE);
          }
          if (localBundle2.containsKey("sbc")) {
            getWindow().setStatusBarColor(localBundle2.getInt("sbc"));
          }
          if (localBundle2.containsKey("snc")) {
            getWindow().setNavigationBarColor(localBundle2.getInt("snc"));
          }
        }
        com.purplebrain.adbuddiz.sdk.f.a.a locala1 = this.b;
        if ((locala1.a != null) && (locala1.a != e.c)) {}
        switch (5.a[locala1.a.ordinal()])
        {
        default: 
          i1 = getRequestedOrientation();
          setRequestedOrientation(i1);
          if (paramBundle != null) {
            this.g = paramBundle.getBoolean("hasImpressionBeenSent");
          }
          com.purplebrain.adbuddiz.sdk.f.a.a locala2 = this.b;
          if (com.purplebrain.adbuddiz.sdk.e.b.a().b() != null) {
            break label439;
          }
          m = 1;
          com.purplebrain.adbuddiz.sdk.e.a.a();
          boolean bool = com.purplebrain.adbuddiz.sdk.e.a.a(locala2);
          if (m != 0) {
            break label542;
          }
          n = 0;
          if (bool) {
            break label542;
          }
          if (n == 0) {
            break label451;
          }
          if (this.b.b) {
            break label445;
          }
          i.a();
          finish();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        l.a("AdBuddizActivity.onCreate", this.b, localThrowable);
        o.a("AdBuddizActivity.onCreate() Exception : ", localThrowable);
        finish();
        return;
      }
      int i1 = 0;
      continue;
      i1 = 1;
      continue;
      label439:
      int m = 0;
      continue;
      label445:
      r.b();
      continue;
      label451:
      this.d = this.b.f().a();
      this.d.a(hasHardwareAcceleration());
      this.d.a(this.h);
      this.d.a(this.i);
      this.d.a(this.j);
      this.d.a(this.k);
      this.e = this.d.a(this, paramBundle, this.b, this.c);
      return;
      label542:
      int n = 1;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.d != null) {
        this.d.x();
      }
      if (isFinishing()) {
        a = false;
      }
      if (this.e != null)
      {
        a(this.e);
        this.e = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("AdBuddizActivity.onDestroy", this.b, localThrowable);
      o.a("AdBuddizActivity.onDestroy() Exception : ", localThrowable);
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (this.d != null) {
        this.d.o();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("AdBuddizActivity.onRestart", this.b, localThrowable);
      o.a("AdBuddizActivity.onRestart() Exception : ", localThrowable);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    try
    {
      paramBundle.putBoolean("hasImpressionBeenSent", this.g);
      if (this.d != null) {
        this.d.a(paramBundle);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("AdBuddizActivity.onSaveInstanceState", this.b, localThrowable);
      o.a("AdBuddizActivity.onSaveInstanceState() Exception : ", localThrowable);
    }
  }
  
  protected void onStart()
  {
    try
    {
      super.onStart();
      Bundle localBundle = getIntent().getExtras();
      if ((Build.VERSION.SDK_INT >= 19) && (localBundle.containsKey("suf")))
      {
        int m = localBundle.getInt("suf");
        if ((m & 0x800) != 0) {
          m = 0x1000 | m & 0xF7FF;
        }
        getWindow().getDecorView().setSystemUiVisibility(m);
      }
      this.d.m();
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("AdBuddizActivity.onStart", this.b, localThrowable);
      o.a("AdBuddizActivity.onStart() Exception : ", localThrowable);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    try
    {
      if (this.d != null) {
        this.d.w();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("AdBuddizActivity.onStop", this.b, localThrowable);
      o.a("AdBuddizActivity.onStop() Exception : ", localThrowable);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddizActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */