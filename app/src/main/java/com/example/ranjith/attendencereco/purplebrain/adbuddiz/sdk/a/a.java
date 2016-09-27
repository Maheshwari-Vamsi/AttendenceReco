package com.purplebrain.adbuddiz.sdk.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.t;
import com.purplebrain.adbuddiz.sdk.i.v;
import com.purplebrain.adbuddiz.sdk.i.v.a;
import com.purplebrain.adbuddiz.sdk.i.v.b;

public final class a
  extends c
{
  protected v a = null;
  
  /* Error */
  private Bitmap c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	com/purplebrain/adbuddiz/sdk/a/a:l	()Lcom/purplebrain/adbuddiz/sdk/f/e;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 24	com/purplebrain/adbuddiz/sdk/a/a:e	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   9: getstatic 30	com/purplebrain/adbuddiz/sdk/f/a/a/d:b	Lcom/purplebrain/adbuddiz/sdk/f/a/a/d;
    //   12: aload_1
    //   13: invokestatic 35	com/purplebrain/adbuddiz/sdk/i/c:a	(Lcom/purplebrain/adbuddiz/sdk/f/a/a;Lcom/purplebrain/adbuddiz/sdk/f/a/a/d;Lcom/purplebrain/adbuddiz/sdk/f/e;)Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +72 -> 90
    //   21: new 37	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 39
    //   27: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_1
    //   31: getfield 47	com/purplebrain/adbuddiz/sdk/f/e:e	Ljava/lang/String;
    //   34: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 53
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 61	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   48: new 37	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 63
    //   54: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: getfield 47	com/purplebrain/adbuddiz/sdk/f/e:e	Ljava/lang/String;
    //   61: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 65
    //   66: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 61	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 24	com/purplebrain/adbuddiz/sdk/a/a:e	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   79: getstatic 30	com/purplebrain/adbuddiz/sdk/f/a/a/d:b	Lcom/purplebrain/adbuddiz/sdk/f/a/a/d;
    //   82: aload_1
    //   83: invokestatic 68	com/purplebrain/adbuddiz/sdk/f/e:b	(Lcom/purplebrain/adbuddiz/sdk/f/e;)Lcom/purplebrain/adbuddiz/sdk/f/e;
    //   86: invokestatic 35	com/purplebrain/adbuddiz/sdk/i/c:a	(Lcom/purplebrain/adbuddiz/sdk/f/a/a;Lcom/purplebrain/adbuddiz/sdk/f/a/a/d;Lcom/purplebrain/adbuddiz/sdk/f/e;)Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 72	com/purplebrain/adbuddiz/sdk/a/a:d	Landroid/app/Activity;
    //   94: aload_2
    //   95: invokestatic 77	com/purplebrain/adbuddiz/sdk/e/c:a	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)Ljava/io/InputStream;
    //   98: astore 8
    //   100: aload 8
    //   102: astore 4
    //   104: aload 4
    //   106: invokestatic 83	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   109: astore 9
    //   111: aload 4
    //   113: invokevirtual 88	java/io/InputStream:close	()V
    //   116: aload 9
    //   118: ifnonnull +37 -> 155
    //   121: ldc 90
    //   123: invokestatic 61	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield 72	com/purplebrain/adbuddiz/sdk/a/a:d	Landroid/app/Activity;
    //   130: aload_0
    //   131: getfield 24	com/purplebrain/adbuddiz/sdk/a/a:e	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   134: invokestatic 95	com/purplebrain/adbuddiz/sdk/i/b/f:a	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/a;)V
    //   137: aload_0
    //   138: getfield 99	com/purplebrain/adbuddiz/sdk/a/a:n	Lcom/purplebrain/adbuddiz/sdk/a/c$b;
    //   141: new 101	java/lang/Exception
    //   144: dup
    //   145: ldc 103
    //   147: invokespecial 104	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   150: invokeinterface 109 2 0
    //   155: aload 9
    //   157: areturn
    //   158: astore 6
    //   160: aconst_null
    //   161: astore 4
    //   163: ldc 111
    //   165: aload 6
    //   167: invokestatic 114	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_0
    //   171: getfield 72	com/purplebrain/adbuddiz/sdk/a/a:d	Landroid/app/Activity;
    //   174: aload_0
    //   175: getfield 24	com/purplebrain/adbuddiz/sdk/a/a:e	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   178: invokestatic 95	com/purplebrain/adbuddiz/sdk/i/b/f:a	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/a;)V
    //   181: aload_0
    //   182: getfield 99	com/purplebrain/adbuddiz/sdk/a/a:n	Lcom/purplebrain/adbuddiz/sdk/a/c$b;
    //   185: aload 6
    //   187: invokeinterface 109 2 0
    //   192: aload 4
    //   194: invokevirtual 88	java/io/InputStream:close	()V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_3
    //   200: aconst_null
    //   201: astore 4
    //   203: aload 4
    //   205: invokevirtual 88	java/io/InputStream:close	()V
    //   208: aload_3
    //   209: athrow
    //   210: astore 10
    //   212: goto -96 -> 116
    //   215: astore 7
    //   217: goto -20 -> 197
    //   220: astore 5
    //   222: goto -14 -> 208
    //   225: astore_3
    //   226: goto -23 -> 203
    //   229: astore 6
    //   231: goto -68 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	a
    //   4	79	1	locale	com.purplebrain.adbuddiz.sdk.f.e
    //   16	79	2	localc	com.purplebrain.adbuddiz.sdk.f.a.a.c
    //   199	10	3	localObject1	Object
    //   225	1	3	localObject2	Object
    //   102	102	4	localInputStream1	java.io.InputStream
    //   220	1	5	localThrowable1	Throwable
    //   158	28	6	localThrowable2	Throwable
    //   229	1	6	localThrowable3	Throwable
    //   215	1	7	localThrowable4	Throwable
    //   98	3	8	localInputStream2	java.io.InputStream
    //   109	47	9	localBitmap	Bitmap
    //   210	1	10	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   90	100	158	java/lang/Throwable
    //   90	100	199	finally
    //   111	116	210	java/lang/Throwable
    //   192	197	215	java/lang/Throwable
    //   203	208	220	java/lang/Throwable
    //   104	111	225	finally
    //   163	192	225	finally
    //   104	111	229	java/lang/Throwable
  }
  
  public final View a(Activity paramActivity, Bundle paramBundle, com.purplebrain.adbuddiz.sdk.f.a.a parama, String paramString)
  {
    View localView = super.a(paramActivity, paramBundle, parama, paramString);
    this.k.a(parama, paramString, Boolean.valueOf(true));
    return localView;
  }
  
  protected final void a()
  {
    super.a();
    if (this.a != null)
    {
      v localv = this.a;
      if (localv.c != null) {
        localv.c.a();
      }
    }
  }
  
  protected final View b()
  {
    Bitmap localBitmap = c();
    ImageView localImageView = new ImageView(this.d);
    localImageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    if (localBitmap != null)
    {
      localImageView.setAdjustViewBounds(true);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setImageBitmap(localBitmap);
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          try
          {
            if (!a.this.p()) {
              return;
            }
            if (a.this.q())
            {
              a.this.r();
              a.this.i.setVisibility(0);
              a.this.j.a(false);
              String str = t.a(a.this.d, ((com.purplebrain.adbuddiz.sdk.f.a.b)a.this.e).j);
              a.this.a = new v(a.this.d);
              a.this.a.b = new v.b()
              {
                public final void a()
                {
                  a.this.i.setVisibility(8);
                  a.this.j.a(true);
                  a.this.s();
                }
              };
              a.this.a.a(str);
              com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
              new Handler().postDelayed(new Runnable()
              {
                public final void run()
                {
                  try
                  {
                    a.this.j.a(true);
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
            a.this.p = null;
            l.a("ABAdBuddizAdDisplayer.createAdView.onClick", a.this.e, localThrowable);
            o.a("ABAdDisplayer.createAdView().onClick() Ad Exception : ", localThrowable);
          }
        }
      });
    }
    return localImageView;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */