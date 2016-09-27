package com.purplebrain.adbuddiz.sdk.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.purplebrain.adbuddiz.sdk.d.a.a;
import com.purplebrain.adbuddiz.sdk.i.a.k;
import com.purplebrain.adbuddiz.sdk.i.o;

public abstract class c
{
  protected Activity d;
  protected com.purplebrain.adbuddiz.sdk.f.a.a e;
  protected String f;
  protected boolean g;
  protected View h;
  protected RelativeLayout i;
  protected com.purplebrain.adbuddiz.sdk.d.a j;
  protected d k = null;
  protected a l = null;
  protected c m = null;
  protected b n = null;
  protected Long o = null;
  protected Long p = null;
  protected Long q = null;
  
  private void b(boolean paramBoolean)
  {
    if ((this.h != null) && (this.h.getParent() != null) && (this.g) && (paramBoolean))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(350L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          try
          {
            c.this.h = null;
            c.this.a();
            c.this.v();
            return;
          }
          catch (Throwable localThrowable)
          {
            com.purplebrain.adbuddiz.sdk.i.l.a("ABAdDisplayer.hideAd.onAnimationEnd", c.this.e, localThrowable);
            o.a("ABAdDisplayer#AnimationListener.onAnimationEnd() Exception : ", localThrowable);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.h.startAnimation(localAlphaAnimation);
      return;
    }
    a();
    v();
  }
  
  @SuppressLint({"NewApi"})
  protected final Drawable a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f1 = com.purplebrain.adbuddiz.sdk.i.a.l.b(this.d) / (paramBitmap.getDensity() / 160);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.d.getResources(), paramBitmap);
    localBitmapDrawable.setBounds(0, 0, (int)(f1 * paramBitmap.getHeight()), (int)(f1 * paramBitmap.getWidth()));
    return localBitmapDrawable;
  }
  
  public View a(Activity paramActivity, Bundle paramBundle, com.purplebrain.adbuddiz.sdk.f.a.a parama, String paramString)
  {
    this.d = paramActivity;
    this.e = parama;
    this.f = paramString;
    if (paramBundle != null) {
      b(paramBundle);
    }
    com.purplebrain.adbuddiz.sdk.d.b localb = new com.purplebrain.adbuddiz.sdk.d.b(this.d);
    int i1 = com.purplebrain.adbuddiz.sdk.i.a.h.b(this.d);
    localb.a.setAlpha(i1);
    localb.f = this.e.f().g;
    localb.setClickable(true);
    this.j = y();
    View localView = b();
    ViewGroup.LayoutParams localLayoutParams1 = b(localView);
    this.i = new RelativeLayout(this.d);
    this.i.setBackgroundColor(-16777216);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(12);
    this.i.setLayoutParams(localLayoutParams2);
    ProgressBar localProgressBar = new ProgressBar(this.d, null, 16842872);
    localProgressBar.setIndeterminate(true);
    int i2 = k.a(this.d, 12);
    localProgressBar.setPadding(i2, i2, i2, i2);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams3.addRule(13);
    localProgressBar.setLayoutParams(localLayoutParams3);
    this.i.addView(localProgressBar);
    if (this.p == null) {
      this.i.setVisibility(4);
    }
    RelativeLayout localRelativeLayout = this.i;
    this.j.addView(localView, localLayoutParams1);
    this.j.addView(localRelativeLayout);
    localb.addView(this.j, new ViewGroup.LayoutParams(-1, -1));
    Bitmap localBitmap = com.purplebrain.adbuddiz.sdk.i.d.b(this.d);
    Object localObject;
    if (localBitmap == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        localb.addView((View)localObject);
      }
      this.h = localb;
      ViewGroup.LayoutParams localLayoutParams5 = new ViewGroup.LayoutParams(-1, -1);
      paramActivity.setContentView(this.h, localLayoutParams5);
      if (this.g)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(400L);
        this.h.startAnimation(localAlphaAnimation);
      }
      return this.h;
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap);
      localObject = new Button(this.d);
      ((Button)localObject).setBackgroundDrawable(localBitmapDrawable);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams4.addRule(12);
      localLayoutParams4.addRule(11);
      localLayoutParams4.width = k.a(this.d, 70);
      localLayoutParams4.height = k.a(this.d, 10);
      localLayoutParams4.bottomMargin = k.a(this.d, 5);
      localLayoutParams4.rightMargin = k.a(this.d, 5);
      ((Button)localObject).setLayoutParams(localLayoutParams4);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          try
          {
            c.this.l.a();
            return;
          }
          catch (Throwable localThrowable)
          {
            com.purplebrain.adbuddiz.sdk.i.l.a("ABAdDisplayer.createByAdBuddizLayout.onClick", c.this.e, localThrowable);
            o.a("ABAdDisplayer#OnClickListener.onClick()", localThrowable);
          }
        }
      });
    }
  }
  
  protected void a()
  {
    this.m.a(this.e);
  }
  
  public void a(Bundle paramBundle) {}
  
  public final void a(a parama)
  {
    this.l = parama;
  }
  
  public final void a(b paramb)
  {
    this.n = paramb;
  }
  
  public final void a(c paramc)
  {
    this.m = paramc;
  }
  
  public final void a(d paramd)
  {
    this.k = paramd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected abstract View b();
  
  protected ViewGroup.LayoutParams b(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  protected void b(Bundle paramBundle) {}
  
  protected final com.purplebrain.adbuddiz.sdk.f.e l()
  {
    if (this.e.g()) {
      return this.e.a;
    }
    return com.purplebrain.adbuddiz.sdk.i.a.d.a();
  }
  
  public final void m()
  {
    this.o = Long.valueOf(System.currentTimeMillis());
  }
  
  protected final void n()
  {
    b(true);
  }
  
  public void o() {}
  
  protected final boolean p()
  {
    if (this.o == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    if (l1 - this.o.longValue() > com.purplebrain.adbuddiz.sdk.e.b.a().b().u) {
      return true;
    }
    new Object[1][0] = Long.valueOf(com.purplebrain.adbuddiz.sdk.e.b.a().b().u - (l1 - this.o.longValue()));
    return false;
  }
  
  protected final boolean q()
  {
    if (this.p == null) {}
    do
    {
      return true;
      if (this.p.longValue() > System.currentTimeMillis()) {
        return false;
      }
    } while (System.currentTimeMillis() - this.p.longValue() > 1000L);
    return false;
  }
  
  protected final void r()
  {
    this.p = Long.valueOf(System.currentTimeMillis());
  }
  
  protected final void s()
  {
    this.l.a(this.e);
    if (com.purplebrain.adbuddiz.sdk.e.b.a().b().q) {
      b(false);
    }
  }
  
  public final boolean t()
  {
    if ((this.j != null) && (this.j.c))
    {
      u();
      b(true);
      return true;
    }
    return false;
  }
  
  protected void u() {}
  
  @SuppressLint({"NewApi"})
  protected void v()
  {
    this.d.finish();
    this.d.overridePendingTransition(0, 0);
  }
  
  public void w() {}
  
  public void x() {}
  
  protected com.purplebrain.adbuddiz.sdk.d.a y()
  {
    com.purplebrain.adbuddiz.sdk.d.a locala = new com.purplebrain.adbuddiz.sdk.d.a(this.d);
    try
    {
      locala.a = a(com.purplebrain.adbuddiz.sdk.i.e.b(this.d));
      locala.b = a(com.purplebrain.adbuddiz.sdk.i.e.a());
      locala.a(true);
      locala.g = new a.a()
      {
        public final void a()
        {
          try
          {
            if (c.this.q == null)
            {
              c.this.q = Long.valueOf(System.currentTimeMillis());
              c.this.u();
              c.this.n();
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            o.a("ABAdDisplayer#OnCloseButtonClickListener.onCloseButtonClicked()", localThrowable);
          }
        }
      };
      com.purplebrain.adbuddiz.sdk.f.a.a locala1 = this.e;
      com.purplebrain.adbuddiz.sdk.f.e locale = com.purplebrain.adbuddiz.sdk.i.a.d.a();
      RectF localRectF = locala1.f().a(locale);
      Rect localRect = com.purplebrain.adbuddiz.sdk.i.a.a.a(locala.getContext(), localRectF);
      locala.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      return locala;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.h localh)
    {
      for (;;) {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(com.purplebrain.adbuddiz.sdk.f.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void a(Throwable paramThrowable);
  }
  
  public static abstract interface c
  {
    public abstract void a(com.purplebrain.adbuddiz.sdk.f.a.a parama);
  }
  
  public static abstract interface d
  {
    public abstract void a(com.purplebrain.adbuddiz.sdk.f.a.a parama, String paramString, Boolean paramBoolean);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */