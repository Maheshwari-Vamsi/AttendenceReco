package com.purplebrain.adbuddiz.sdk.i;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"NewApi"})
public final class v
{
  private static List d = Arrays.asList(new String[] { "http://play.google.com/store/apps/details?", "https://play.google.com/store/apps/details?", "http://market.android.com/details?", "https://market.android.com/details?" });
  Context a;
  public b b = null;
  public a c = null;
  
  public v(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(String paramString)
  {
    this.c = new a((byte)0);
    a locala = this.c;
    locala.a = new Thread(new v.a.1(locala, paramString));
    locala.a.start();
  }
  
  private final class a
  {
    Thread a = null;
    boolean b = false;
    
    private a() {}
    
    /* Error */
    final String a(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: invokestatic 35	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   5: invokevirtual 39	java/lang/Thread:isInterrupted	()Z
      //   8: ifeq +7 -> 15
      //   11: aconst_null
      //   12: astore_3
      //   13: aload_3
      //   14: areturn
      //   15: aload_1
      //   16: invokestatic 43	com/purplebrain/adbuddiz/sdk/i/v:b	(Ljava/lang/String;)Ljava/lang/String;
      //   19: astore_3
      //   20: aload_3
      //   21: ldc 45
      //   23: invokevirtual 51	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   26: ifne -13 -> 13
      //   29: new 53	java/net/URL
      //   32: dup
      //   33: aload_3
      //   34: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
      //   37: astore 4
      //   39: aload 4
      //   41: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   44: checkcast 62	java/net/HttpURLConnection
      //   47: astore 6
      //   49: aload 6
      //   51: sipush 8000
      //   54: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   57: aload 6
      //   59: sipush 8000
      //   62: invokevirtual 69	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   65: aload 6
      //   67: iconst_0
      //   68: invokevirtual 73	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   71: aload 6
      //   73: iconst_0
      //   74: invokevirtual 76	java/net/HttpURLConnection:setUseCaches	(Z)V
      //   77: aload 6
      //   79: iconst_0
      //   80: invokevirtual 79	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
      //   83: aload 6
      //   85: ldc 81
      //   87: ldc 83
      //   89: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   92: aload 6
      //   94: iconst_1
      //   95: invokevirtual 90	java/net/HttpURLConnection:setDoInput	(Z)V
      //   98: aload 6
      //   100: ldc 92
      //   102: invokevirtual 95	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   105: aload 6
      //   107: invokevirtual 99	java/net/HttpURLConnection:getResponseCode	()I
      //   110: istore 12
      //   112: iload 12
      //   114: sipush 302
      //   117: if_icmpne +98 -> 215
      //   120: aload 6
      //   122: ldc 101
      //   124: invokevirtual 104	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   127: astore 13
      //   129: aload 13
      //   131: ifnull +72 -> 203
      //   134: aload 13
      //   136: ldc 106
      //   138: invokevirtual 51	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   141: ifeq +41 -> 182
      //   144: new 108	java/lang/StringBuilder
      //   147: dup
      //   148: invokespecial 109	java/lang/StringBuilder:<init>	()V
      //   151: aload 4
      //   153: invokevirtual 113	java/net/URL:getProtocol	()Ljava/lang/String;
      //   156: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: ldc 119
      //   161: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: aload 4
      //   166: invokevirtual 122	java/net/URL:getHost	()Ljava/lang/String;
      //   169: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: aload 13
      //   174: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   177: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   180: astore 13
      //   182: iconst_1
      //   183: anewarray 4	java/lang/Object
      //   186: dup
      //   187: iconst_0
      //   188: aload 13
      //   190: aastore
      //   191: pop
      //   192: aload_0
      //   193: aload 13
      //   195: invokevirtual 127	com/purplebrain/adbuddiz/sdk/i/v$a:a	(Ljava/lang/String;)Ljava/lang/String;
      //   198: astore 15
      //   200: aload 15
      //   202: astore_3
      //   203: aload 6
      //   205: ifnull -192 -> 13
      //   208: aload 6
      //   210: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
      //   213: aload_3
      //   214: areturn
      //   215: iconst_1
      //   216: anewarray 4	java/lang/Object
      //   219: iconst_0
      //   220: iload 12
      //   222: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   225: aastore
      //   226: goto -23 -> 203
      //   229: astore 11
      //   231: aload 6
      //   233: ifnull +8 -> 241
      //   236: aload 6
      //   238: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
      //   241: aconst_null
      //   242: areturn
      //   243: astore 8
      //   245: aconst_null
      //   246: astore 6
      //   248: aload 6
      //   250: ifnull -237 -> 13
      //   253: aload 6
      //   255: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
      //   258: aload_3
      //   259: areturn
      //   260: astore 7
      //   262: aload_2
      //   263: ifnull +7 -> 270
      //   266: aload_2
      //   267: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
      //   270: aload 7
      //   272: athrow
      //   273: astore 10
      //   275: aload 6
      //   277: astore_2
      //   278: aload 10
      //   280: astore 7
      //   282: goto -20 -> 262
      //   285: astore 9
      //   287: goto -39 -> 248
      //   290: astore 5
      //   292: aconst_null
      //   293: astore 6
      //   295: goto -64 -> 231
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	298	0	this	a
      //   0	298	1	paramString	String
      //   1	277	2	localObject1	Object
      //   12	247	3	localObject2	Object
      //   37	128	4	localURL	java.net.URL
      //   290	1	5	localInterruptedIOException1	java.io.InterruptedIOException
      //   47	247	6	localHttpURLConnection	java.net.HttpURLConnection
      //   260	11	7	localObject3	Object
      //   280	1	7	localObject4	Object
      //   243	1	8	localIOException1	java.io.IOException
      //   285	1	9	localIOException2	java.io.IOException
      //   273	6	10	localObject5	Object
      //   229	1	11	localInterruptedIOException2	java.io.InterruptedIOException
      //   110	111	12	i	int
      //   127	67	13	str1	String
      //   198	3	15	str2	String
      // Exception table:
      //   from	to	target	type
      //   49	112	229	java/io/InterruptedIOException
      //   120	129	229	java/io/InterruptedIOException
      //   134	182	229	java/io/InterruptedIOException
      //   182	200	229	java/io/InterruptedIOException
      //   215	226	229	java/io/InterruptedIOException
      //   29	49	243	java/io/IOException
      //   29	49	260	finally
      //   49	112	273	finally
      //   120	129	273	finally
      //   134	182	273	finally
      //   182	200	273	finally
      //   215	226	273	finally
      //   49	112	285	java/io/IOException
      //   120	129	285	java/io/IOException
      //   134	182	285	java/io/IOException
      //   182	200	285	java/io/IOException
      //   215	226	285	java/io/IOException
      //   29	49	290	java/io/InterruptedIOException
    }
    
    public final void a()
    {
      try
      {
        this.b = true;
        if (this.a != null) {
          this.a.interrupt();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */