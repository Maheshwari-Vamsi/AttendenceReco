package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.h.f;
import java.net.MalformedURLException;

public final class d
{
  public static void a(Context paramContext)
  {
    if (!m.a(paramContext, "BA")) {}
    try
    {
      f localf = new f();
      localf.e = w.i();
      localf.f = "BA";
      localf.f();
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static android.graphics.Bitmap b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 10
    //   3: invokestatic 15	com/purplebrain/adbuddiz/sdk/i/m:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: istore_1
    //   7: aconst_null
    //   8: astore_2
    //   9: iload_1
    //   10: ifeq +33 -> 43
    //   13: aload_0
    //   14: ldc 10
    //   16: invokestatic 49	com/purplebrain/adbuddiz/sdk/i/m:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore 9
    //   21: aload 9
    //   23: astore 4
    //   25: aload 4
    //   27: invokestatic 55	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   30: astore_2
    //   31: aload_2
    //   32: sipush 360
    //   35: invokevirtual 61	android/graphics/Bitmap:setDensity	(I)V
    //   38: aload 4
    //   40: invokevirtual 66	java/io/InputStream:close	()V
    //   43: aload_2
    //   44: areturn
    //   45: astore 7
    //   47: aconst_null
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 66	java/io/InputStream:close	()V
    //   55: aload_2
    //   56: areturn
    //   57: astore 8
    //   59: aload_2
    //   60: areturn
    //   61: astore_3
    //   62: aconst_null
    //   63: astore 4
    //   65: aload_3
    //   66: astore 5
    //   68: aload 4
    //   70: invokevirtual 66	java/io/InputStream:close	()V
    //   73: aload 5
    //   75: athrow
    //   76: astore 11
    //   78: aload_2
    //   79: areturn
    //   80: astore 6
    //   82: goto -9 -> 73
    //   85: astore 5
    //   87: goto -19 -> 68
    //   90: astore 10
    //   92: goto -42 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   6	4	1	bool	boolean
    //   8	71	2	localBitmap	android.graphics.Bitmap
    //   61	5	3	localObject1	Object
    //   23	46	4	localInputStream1	java.io.InputStream
    //   66	8	5	localObject2	Object
    //   85	1	5	localObject3	Object
    //   80	1	6	localThrowable1	Throwable
    //   45	1	7	localException1	Exception
    //   57	1	8	localThrowable2	Throwable
    //   19	3	9	localInputStream2	java.io.InputStream
    //   90	1	10	localException2	Exception
    //   76	1	11	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   13	21	45	java/lang/Exception
    //   50	55	57	java/lang/Throwable
    //   13	21	61	finally
    //   38	43	76	java/lang/Throwable
    //   68	73	80	java/lang/Throwable
    //   25	38	85	finally
    //   25	38	90	java/lang/Exception
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */