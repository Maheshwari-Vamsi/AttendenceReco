package com.purplebrain.adbuddiz.sdk.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.purplebrain.adbuddiz.sdk.f.a.a.d;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.t;
import com.purplebrain.adbuddiz.sdk.i.v;
import com.purplebrain.adbuddiz.sdk.i.v.b;
import com.purplebrain.adbuddiz.sdk.k.a.c;
import java.util.Iterator;
import java.util.List;

public final class b
  extends f
{
  private a.c D = new a.c()
  {
    public final void a()
    {
      b.this.k();
    }
  };
  protected WebView a = null;
  protected com.purplebrain.adbuddiz.sdk.k.a b = null;
  protected v c = null;
  
  protected final void a(MediaPlayer paramMediaPlayer)
  {
    com.purplebrain.adbuddiz.sdk.i.b.f.a(this.d, (com.purplebrain.adbuddiz.sdk.f.a.c)this.e);
  }
  
  protected final void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    super.a(paramMediaPlayer, paramInt1, paramInt2);
    if ((this.v == null) || (this.v.intValue() <= 0))
    {
      com.purplebrain.adbuddiz.sdk.i.c.b localb = this.C;
      Integer localInteger = null;
      if (localb != null) {
        localInteger = this.C.a;
      }
      if ((localInteger != null) && (localInteger.intValue() != 0)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.purplebrain.adbuddiz.sdk.i.b.f.a(this.d, (com.purplebrain.adbuddiz.sdk.f.a.c)this.e);
      }
      return;
    }
  }
  
  protected final void a(View paramView)
  {
    if (!this.e.b)
    {
      paramView.playSoundEffect(0);
      k();
    }
  }
  
  protected final View b()
  {
    if (!this.x) {
      return super.b();
    }
    this.a = i();
    return this.a;
  }
  
  protected final com.purplebrain.adbuddiz.sdk.f.a.a.c c()
  {
    Object localObject1 = null;
    Iterator localIterator = com.purplebrain.adbuddiz.sdk.i.c.a(this.e, d.b, true, l()).iterator();
    Object localObject2;
    if ((localObject1 == null) && (localIterator.hasNext()))
    {
      localObject2 = (com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next();
      if (!((com.purplebrain.adbuddiz.sdk.f.a.a.c)localObject2).a("isVideo")) {
        break label62;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      return (com.purplebrain.adbuddiz.sdk.f.a.a.c)localObject1;
      label62:
      localObject2 = localObject1;
    }
  }
  
  protected final Uri d()
  {
    com.purplebrain.adbuddiz.sdk.f.a.a.c localc = c();
    if (localc == null) {
      throw new Exception("Cannot find video resource");
    }
    String str = m.a(this.d, localc);
    return Uri.parse("file://" + str);
  }
  
  protected final String e()
  {
    return ((com.purplebrain.adbuddiz.sdk.f.a.c)this.e).o;
  }
  
  protected final String[] f()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ((com.purplebrain.adbuddiz.sdk.f.a.c)this.e).n;
    return arrayOfString;
  }
  
  protected final Double g()
  {
    if (!this.x) {
      return super.g();
    }
    return null;
  }
  
  protected final ImageButton h()
  {
    if (this.x) {
      return null;
    }
    return super.h();
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  final WebView i()
  {
    // Byte code:
    //   0: new 242	android/webkit/WebView
    //   3: dup
    //   4: aload_0
    //   5: getfield 87	com/purplebrain/adbuddiz/sdk/a/b:d	Landroid/app/Activity;
    //   8: invokespecial 245	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   11: astore_1
    //   12: aload_1
    //   13: ldc -10
    //   15: invokevirtual 249	android/webkit/WebView:setBackgroundColor	(I)V
    //   18: aload_1
    //   19: iconst_1
    //   20: invokevirtual 252	android/webkit/WebView:clearCache	(Z)V
    //   23: aload_0
    //   24: new 254	com/purplebrain/adbuddiz/sdk/k/a
    //   27: dup
    //   28: aload_0
    //   29: getfield 87	com/purplebrain/adbuddiz/sdk/a/b:d	Landroid/app/Activity;
    //   32: aload_0
    //   33: getfield 91	com/purplebrain/adbuddiz/sdk/a/b:e	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   36: checkcast 93	com/purplebrain/adbuddiz/sdk/f/a/c
    //   39: invokespecial 257	com/purplebrain/adbuddiz/sdk/k/a:<init>	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/c;)V
    //   42: putfield 20	com/purplebrain/adbuddiz/sdk/a/b:b	Lcom/purplebrain/adbuddiz/sdk/k/a;
    //   45: aload_0
    //   46: getfield 20	com/purplebrain/adbuddiz/sdk/a/b:b	Lcom/purplebrain/adbuddiz/sdk/k/a;
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: putfield 259	com/purplebrain/adbuddiz/sdk/k/a:c	Landroid/webkit/WebView;
    //   55: aload_1
    //   56: invokestatic 262	com/purplebrain/adbuddiz/sdk/k/a:a	(Landroid/webkit/WebView;)V
    //   59: invokestatic 264	com/purplebrain/adbuddiz/sdk/k/a:a	()V
    //   62: aload_1
    //   63: new 266	com/purplebrain/adbuddiz/sdk/k/a$b
    //   66: dup
    //   67: aload_2
    //   68: iconst_0
    //   69: invokespecial 269	com/purplebrain/adbuddiz/sdk/k/a$b:<init>	(Lcom/purplebrain/adbuddiz/sdk/k/a;B)V
    //   72: invokevirtual 273	android/webkit/WebView:setWebViewClient	(Landroid/webkit/WebViewClient;)V
    //   75: aload_1
    //   76: new 275	com/purplebrain/adbuddiz/sdk/k/a$a
    //   79: dup
    //   80: aload_2
    //   81: iconst_0
    //   82: invokespecial 276	com/purplebrain/adbuddiz/sdk/k/a$a:<init>	(Lcom/purplebrain/adbuddiz/sdk/k/a;B)V
    //   85: invokevirtual 280	android/webkit/WebView:setWebChromeClient	(Landroid/webkit/WebChromeClient;)V
    //   88: aload_0
    //   89: getfield 20	com/purplebrain/adbuddiz/sdk/a/b:b	Lcom/purplebrain/adbuddiz/sdk/k/a;
    //   92: aload_0
    //   93: getfield 29	com/purplebrain/adbuddiz/sdk/a/b:D	Lcom/purplebrain/adbuddiz/sdk/k/a$c;
    //   96: putfield 282	com/purplebrain/adbuddiz/sdk/k/a:d	Lcom/purplebrain/adbuddiz/sdk/k/a$c;
    //   99: aload_0
    //   100: getfield 20	com/purplebrain/adbuddiz/sdk/a/b:b	Lcom/purplebrain/adbuddiz/sdk/k/a;
    //   103: astore 4
    //   105: aload 4
    //   107: getfield 285	com/purplebrain/adbuddiz/sdk/k/a:b	Lcom/purplebrain/adbuddiz/sdk/f/a/c;
    //   110: aload 4
    //   112: getfield 285	com/purplebrain/adbuddiz/sdk/k/a:b	Lcom/purplebrain/adbuddiz/sdk/f/a/c;
    //   115: getfield 287	com/purplebrain/adbuddiz/sdk/f/a/c:l	Ljava/lang/String;
    //   118: invokestatic 290	com/purplebrain/adbuddiz/sdk/i/c:a	(Lcom/purplebrain/adbuddiz/sdk/f/a/a;Ljava/lang/String;)Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;
    //   121: astore 5
    //   123: aload 4
    //   125: getfield 293	com/purplebrain/adbuddiz/sdk/k/a:a	Landroid/content/Context;
    //   128: aload 5
    //   130: invokestatic 298	com/purplebrain/adbuddiz/sdk/e/c:a	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)Ljava/io/InputStream;
    //   133: astore 9
    //   135: aload 9
    //   137: invokestatic 303	com/purplebrain/adbuddiz/sdk/i/s:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   140: astore 10
    //   142: aload 10
    //   144: ifnull +36 -> 180
    //   147: aload 10
    //   149: invokevirtual 306	java/lang/String:length	()I
    //   152: ifle +28 -> 180
    //   155: aload 4
    //   157: getfield 259	com/purplebrain/adbuddiz/sdk/k/a:c	Landroid/webkit/WebView;
    //   160: aconst_null
    //   161: aload 10
    //   163: ldc_w 308
    //   166: ldc_w 310
    //   169: aconst_null
    //   170: invokevirtual 314	android/webkit/WebView:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 9
    //   175: invokevirtual 319	java/io/InputStream:close	()V
    //   178: aload_1
    //   179: areturn
    //   180: new 238	java/io/IOException
    //   183: dup
    //   184: ldc_w 321
    //   187: invokespecial 322	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: astore 6
    //   193: aload 9
    //   195: astore 7
    //   197: aload 7
    //   199: invokevirtual 319	java/io/InputStream:close	()V
    //   202: aload 6
    //   204: athrow
    //   205: astore_3
    //   206: ldc_w 324
    //   209: aload_3
    //   210: invokestatic 329	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_0
    //   214: getfield 332	com/purplebrain/adbuddiz/sdk/a/b:n	Lcom/purplebrain/adbuddiz/sdk/a/c$b;
    //   217: aload_3
    //   218: invokeinterface 337 2 0
    //   223: aload_1
    //   224: areturn
    //   225: astore 11
    //   227: aload_1
    //   228: areturn
    //   229: astore 8
    //   231: goto -29 -> 202
    //   234: astore 6
    //   236: aconst_null
    //   237: astore 7
    //   239: goto -42 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	b
    //   11	217	1	localWebView	WebView
    //   49	32	2	locala1	com.purplebrain.adbuddiz.sdk.k.a
    //   205	13	3	localIOException	java.io.IOException
    //   103	53	4	locala2	com.purplebrain.adbuddiz.sdk.k.a
    //   121	8	5	localc	com.purplebrain.adbuddiz.sdk.f.a.a.c
    //   191	12	6	localObject1	Object
    //   234	1	6	localObject2	Object
    //   195	43	7	localInputStream1	java.io.InputStream
    //   229	1	8	localThrowable1	Throwable
    //   133	61	9	localInputStream2	java.io.InputStream
    //   140	22	10	str	String
    //   225	1	11	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   135	142	191	finally
    //   147	173	191	finally
    //   180	191	191	finally
    //   99	123	205	java/io/IOException
    //   173	178	205	java/io/IOException
    //   197	202	205	java/io/IOException
    //   202	205	205	java/io/IOException
    //   173	178	225	java/lang/Throwable
    //   197	202	229	java/lang/Throwable
    //   123	135	234	finally
  }
  
  @SuppressLint({"NewApi"})
  protected final void j()
  {
    this.u.reset();
    this.u.release();
    this.u = null;
    com.purplebrain.adbuddiz.sdk.d.a locala1 = this.j;
    if (locala1.d != -16777216)
    {
      locala1.d = -16777216;
      locala1.e = locala1.a();
      locala1.invalidate();
    }
    this.s.setMinimumHeight(this.s.getHeight());
    this.s.setMinimumWidth(this.s.getWidth());
    com.purplebrain.adbuddiz.sdk.d.a locala2 = this.j;
    RectF localRectF = new RectF();
    Rect localRect = new Rect();
    locala2.b(localRect);
    locala2.a(localRectF, locala2.getWidth(), locala2.getHeight(), localRect, true);
    float f = localRectF.width() / localRectF.height();
    this.j.removeView(this.r);
    final View localView = new View(this.d);
    localView.setBackgroundColor(-16777216);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.j.addView(localView, 1);
    Animator.AnimatorListener local1 = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        try
        {
          b.this.j.removeViewInLayout(localView);
          b.this.a = b.this.i();
          b.this.j.addView(b.this.a, 0);
          b.a(b.this);
          return;
        }
        catch (Throwable localThrowable)
        {
          o.a("ABAdBuddizVideoAdDisplayer.onMediaPlayerComplete#AnimatorListener.onAnimationEnd", localThrowable);
          l.a("ABAdBuddizVideoAdDisplayer.onMediaPlayerComplete#AnimatorListener.onAnimationEnd", null, localThrowable);
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        try
        {
          b.this.j.removeView(b.this.s);
          return;
        }
        catch (Throwable localThrowable)
        {
          o.a("ABAdBuddizVideoAdDisplayer.onMediaPlayerComplete#AnimatorListener.onAnimationStart", localThrowable);
          l.a("ABAdBuddizVideoAdDisplayer.onMediaPlayerComplete#AnimatorListener.onAnimationStart", null, localThrowable);
        }
      }
    };
    int i = 300;
    if (l() == e.b) {
      i = 100;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.j.f.floatValue();
    arrayOfFloat[1] = f;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat);
    localValueAnimator.setStartDelay(50L);
    localValueAnimator.setDuration(i);
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        try
        {
          double d = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).doubleValue();
          b.this.j.a(Double.valueOf(d));
          return;
        }
        catch (Throwable localThrowable)
        {
          o.a("ABAdBuddizVideoAdDisplayer.onMediaPlayerComplete#AnimatorUpdateListener.onAnimationUpdate", localThrowable);
          l.a("ABAdBuddizVideoAdDisplayer.onMediaPlayerComplete#AnimatorUpdateListener.onAnimationUpdate", null, localThrowable);
        }
      }
    });
    localValueAnimator.addListener(local1);
    localValueAnimator.start();
  }
  
  protected final void k()
  {
    try
    {
      if (!p()) {
        return;
      }
      if (q())
      {
        r();
        this.i.setVisibility(0);
        this.j.a(false);
        String str = t.a(this.d, ((com.purplebrain.adbuddiz.sdk.f.a.b)this.e).j);
        this.c = new v(this.d);
        this.c.b = new v.b()
        {
          public final void a()
          {
            b.this.i.setVisibility(8);
            if (b.this.x) {
              b.this.j.a(true);
            }
            b.this.s();
          }
        };
        this.c.a(str);
        com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
        new Handler().postDelayed(new Runnable()
        {
          public final void run()
          {
            try
            {
              b.this.j.a(true);
              return;
            }
            catch (Throwable localThrowable) {}
          }
        }, localb.w);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.p = null;
      l.a("ABAdBuddizViewAdDisplayer#onEndInterstitialClickListener.onClick", this.e, localThrowable);
      o.a("ABAdBuddizViewAdDisplayer#onEndInterstitialClickListener.onClick", localThrowable);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */