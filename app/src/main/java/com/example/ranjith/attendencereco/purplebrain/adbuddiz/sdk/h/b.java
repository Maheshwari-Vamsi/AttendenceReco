package com.purplebrain.adbuddiz.sdk.h;

import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.s;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public abstract class b
  implements Runnable
{
  private static ExecutorService g;
  private static ExecutorService h;
  protected int a = 0;
  int b = 10;
  public boolean c = false;
  protected a d;
  private boolean e = false;
  private h f = null;
  
  public static HttpURLConnection a(URL paramURL, String paramString)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(15000);
    localHttpURLConnection.setInstanceFollowRedirects(true);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setAllowUserInteraction(false);
    localHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setRequestMethod(paramString);
    return localHttpURLConnection;
  }
  
  public static void h()
  {
    try
    {
      if (g != null)
      {
        g.shutdown();
        g = null;
      }
      if (h != null)
      {
        h.shutdown();
        h = null;
      }
      return;
    }
    finally {}
  }
  
  private static ExecutorService i()
  {
    if ((g == null) || (g.isShutdown())) {}
    try
    {
      if ((g == null) || (g.isShutdown())) {
        g = Executors.newFixedThreadPool(3);
      }
      return g;
    }
    finally {}
  }
  
  private static ExecutorService j()
  {
    if ((h == null) || (h.isShutdown())) {}
    try
    {
      if ((h == null) || (h.isShutdown())) {
        h = Executors.newSingleThreadExecutor();
      }
      return h;
    }
    finally {}
  }
  
  public final int a()
  {
    return this.a;
  }
  
  protected final InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("Content-Length");
    if (str != null) {
      this.f.e = Long.parseLong(str);
    }
    if (paramHttpURLConnection.getResponseCode() >= 400) {}
    for (Object localObject = paramHttpURLConnection.getErrorStream();; localObject = paramHttpURLConnection.getInputStream())
    {
      if ("gzip".equalsIgnoreCase(paramHttpURLConnection.getHeaderField("Content-Encoding"))) {
        localObject = new GZIPInputStream((InputStream)localObject);
      }
      return (InputStream)localObject;
    }
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  final void a(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    this.f.d = paramString.getBytes().length;
    paramHttpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
    paramHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
    paramHttpURLConnection.setDoOutput(true);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(paramHttpURLConnection.getOutputStream()));
    localBufferedOutputStream.write(paramString.getBytes("UTF-8"));
    localBufferedOutputStream.flush();
    localBufferedOutputStream.close();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = 30000;
    for (;;)
    {
      try
      {
        if (this.a < this.b) {
          if (paramBoolean)
          {
            switch (this.a)
            {
            default: 
              i = 3600000 + new Random().nextInt(3600000);
              o.a("Request sleeps " + i + "ms before #" + (1 + this.a) + " try : " + getClass().getSimpleName());
              Thread.sleep(i);
              f();
              return;
            case 1: 
              i = 10000 + new Random().nextInt(10000);
              break;
            case 2: 
              i = 30000 + new Random().nextInt(30000);
              break;
            case 3: 
              i = 60000 + new Random().nextInt(60000);
              break;
            }
            i = 900000 + new Random().nextInt(900000);
            continue;
          }
        }
        switch (this.a)
        {
        case 4: 
          if (this.d != null)
          {
            this.d.a(this);
            return;
          }
          break;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      i = 3600000;
      continue;
      i = 1000;
      continue;
      i = 3000;
      continue;
      i = 7000;
      continue;
      i = 60000;
      continue;
      i = 900000;
    }
  }
  
  protected final String b(HttpURLConnection paramHttpURLConnection)
  {
    return s.a(a(paramHttpURLConnection));
  }
  
  protected final HttpURLConnection b(URL paramURL, String paramString)
  {
    HttpURLConnection localHttpURLConnection = a(paramURL, "POST");
    a(localHttpURLConnection, paramString);
    return localHttpURLConnection;
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally {}
  }
  
  public abstract void c();
  
  public abstract boolean d();
  
  public abstract String e();
  
  public final void f()
  {
    this.a = (1 + this.a);
    if (d()) {}
    for (ExecutorService localExecutorService1 = j();; localExecutorService1 = i()) {
      try
      {
        localExecutorService1.execute(this);
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        ExecutorService localExecutorService2 = Executors.newSingleThreadExecutor();
        localExecutorService2.execute(this);
        localExecutorService2.shutdown();
      }
    }
  }
  
  public final void g()
  {
    try
    {
      if (!this.e) {
        this.e = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 291	com/purplebrain/adbuddiz/sdk/h/b:b	()Z
    //   4: ifeq +27 -> 31
    //   7: new 199	java/lang/StringBuilder
    //   10: dup
    //   11: ldc_w 293
    //   14: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   21: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 231	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   30: return
    //   31: new 199	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 297
    //   38: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   45: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 231	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   54: invokestatic 303	com/purplebrain/adbuddiz/sdk/AdBuddiz:getContext	()Landroid/content/Context;
    //   57: astore 10
    //   59: aload_0
    //   60: new 115	com/purplebrain/adbuddiz/sdk/h/h
    //   63: dup
    //   64: invokespecial 304	com/purplebrain/adbuddiz/sdk/h/h:<init>	()V
    //   67: putfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   70: aload_0
    //   71: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   74: aload_0
    //   75: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   78: putfield 307	com/purplebrain/adbuddiz/sdk/h/h:a	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   85: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   88: putfield 315	com/purplebrain/adbuddiz/sdk/h/h:b	J
    //   91: aload 10
    //   93: ifnull +27 -> 120
    //   96: aload_0
    //   97: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   100: aload 10
    //   102: invokestatic 320	com/purplebrain/adbuddiz/sdk/i/a/i:b	(Landroid/content/Context;)Ljava/lang/Integer;
    //   105: putfield 323	com/purplebrain/adbuddiz/sdk/h/h:f	Ljava/lang/Integer;
    //   108: aload_0
    //   109: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   112: aload 10
    //   114: invokestatic 325	com/purplebrain/adbuddiz/sdk/i/a/i:c	(Landroid/content/Context;)Ljava/lang/Integer;
    //   117: putfield 327	com/purplebrain/adbuddiz/sdk/h/h:g	Ljava/lang/Integer;
    //   120: aload_0
    //   121: invokevirtual 329	com/purplebrain/adbuddiz/sdk/h/b:c	()V
    //   124: aload_0
    //   125: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   128: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   131: aload_0
    //   132: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   135: getfield 315	com/purplebrain/adbuddiz/sdk/h/h:b	J
    //   138: lsub
    //   139: putfield 331	com/purplebrain/adbuddiz/sdk/h/h:c	J
    //   142: aload 10
    //   144: ifnull +44 -> 188
    //   147: aload_0
    //   148: getfield 31	com/purplebrain/adbuddiz/sdk/h/b:c	Z
    //   151: ifeq +37 -> 188
    //   154: aload_0
    //   155: getfield 33	com/purplebrain/adbuddiz/sdk/h/b:f	Lcom/purplebrain/adbuddiz/sdk/h/h;
    //   158: astore 11
    //   160: aload 10
    //   162: invokestatic 336	com/purplebrain/adbuddiz/sdk/i/b/e:a	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   165: astore 13
    //   167: aload 13
    //   169: aload 11
    //   171: invokevirtual 339	com/purplebrain/adbuddiz/sdk/h/h:a	()Lorg/json/JSONObject;
    //   174: invokevirtual 345	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   177: pop
    //   178: aload 10
    //   180: ldc_w 347
    //   183: aload 13
    //   185: invokestatic 352	com/purplebrain/adbuddiz/sdk/i/b/d:a	(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONArray;)V
    //   188: aload_0
    //   189: invokevirtual 291	com/purplebrain/adbuddiz/sdk/h/b:b	()Z
    //   192: ifne +82 -> 274
    //   195: new 199	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 354
    //   202: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_0
    //   206: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   209: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 231	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   218: iconst_0
    //   219: istore_2
    //   220: iconst_1
    //   221: istore_3
    //   222: iload_3
    //   223: ifne -193 -> 30
    //   226: aload_0
    //   227: invokevirtual 291	com/purplebrain/adbuddiz/sdk/h/b:b	()Z
    //   230: ifeq +332 -> 562
    //   233: new 199	java/lang/StringBuilder
    //   236: dup
    //   237: ldc_w 356
    //   240: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   243: iconst_1
    //   244: aload_0
    //   245: getfield 25	com/purplebrain/adbuddiz/sdk/h/b:a	I
    //   248: iadd
    //   249: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: ldc -42
    //   254: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: invokevirtual 218	java/lang/Object:getClass	()Ljava/lang/Class;
    //   261: invokevirtual 224	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   264: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 231	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   273: return
    //   274: new 199	java/lang/StringBuilder
    //   277: dup
    //   278: ldc_w 293
    //   281: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: aload_0
    //   285: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   288: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 231	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   297: goto -79 -> 218
    //   300: astore 9
    //   302: new 199	java/lang/StringBuilder
    //   305: dup
    //   306: ldc_w 358
    //   309: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: aload_0
    //   313: invokevirtual 218	java/lang/Object:getClass	()Ljava/lang/Class;
    //   316: invokevirtual 224	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   319: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 360
    //   325: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 9
    //   330: invokevirtual 363	com/purplebrain/adbuddiz/sdk/h/k:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 365	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   342: iconst_1
    //   343: istore_2
    //   344: iconst_0
    //   345: istore_3
    //   346: goto -124 -> 222
    //   349: astore 8
    //   351: new 199	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 367
    //   358: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload_0
    //   362: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   365: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 365	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   374: iconst_0
    //   375: istore_2
    //   376: iconst_0
    //   377: istore_3
    //   378: goto -156 -> 222
    //   381: astore 7
    //   383: new 199	java/lang/StringBuilder
    //   386: dup
    //   387: ldc_w 369
    //   390: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: aload_0
    //   394: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   397: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 365	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   406: iconst_0
    //   407: istore_2
    //   408: iconst_0
    //   409: istore_3
    //   410: goto -188 -> 222
    //   413: astore 6
    //   415: new 199	java/lang/StringBuilder
    //   418: dup
    //   419: ldc_w 371
    //   422: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   425: aload_0
    //   426: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   429: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 365	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   438: iconst_0
    //   439: istore_2
    //   440: iconst_0
    //   441: istore_3
    //   442: goto -220 -> 222
    //   445: astore 5
    //   447: new 199	java/lang/StringBuilder
    //   450: dup
    //   451: ldc_w 373
    //   454: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: aload_0
    //   458: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   461: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 231	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   470: iconst_0
    //   471: istore_2
    //   472: iconst_0
    //   473: istore_3
    //   474: goto -252 -> 222
    //   477: astore 4
    //   479: new 199	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 375
    //   486: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   493: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 360
    //   499: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 4
    //   504: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 365	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   516: iconst_0
    //   517: istore_2
    //   518: iconst_0
    //   519: istore_3
    //   520: goto -298 -> 222
    //   523: astore_1
    //   524: ldc_w 378
    //   527: aconst_null
    //   528: aload_1
    //   529: invokestatic 383	com/purplebrain/adbuddiz/sdk/i/l:a	(Ljava/lang/String;Lcom/purplebrain/adbuddiz/sdk/f/a/a;Ljava/lang/Throwable;)V
    //   532: new 199	java/lang/StringBuilder
    //   535: dup
    //   536: ldc_w 385
    //   539: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   542: aload_0
    //   543: invokevirtual 295	com/purplebrain/adbuddiz/sdk/h/b:e	()Ljava/lang/String;
    //   546: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 365	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   555: iconst_0
    //   556: istore_2
    //   557: iconst_0
    //   558: istore_3
    //   559: goto -337 -> 222
    //   562: aload_0
    //   563: iload_2
    //   564: invokevirtual 387	com/purplebrain/adbuddiz/sdk/h/b:a	(Z)V
    //   567: return
    //   568: astore 12
    //   570: goto -382 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	b
    //   523	6	1	localThrowable	Throwable
    //   219	345	2	bool	boolean
    //   221	338	3	i	int
    //   477	26	4	localException	Exception
    //   445	1	5	localSSLHandshakeException	javax.net.ssl.SSLHandshakeException
    //   413	1	6	localSocketTimeoutException	java.net.SocketTimeoutException
    //   381	1	7	localConnectException	java.net.ConnectException
    //   349	1	8	localUnknownHostException	java.net.UnknownHostException
    //   300	29	9	localk	k
    //   57	122	10	localContext	android.content.Context
    //   158	12	11	localh	h
    //   568	1	12	localJSONException	org.json.JSONException
    //   165	19	13	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   31	91	300	com/purplebrain/adbuddiz/sdk/h/k
    //   96	120	300	com/purplebrain/adbuddiz/sdk/h/k
    //   120	142	300	com/purplebrain/adbuddiz/sdk/h/k
    //   147	160	300	com/purplebrain/adbuddiz/sdk/h/k
    //   160	188	300	com/purplebrain/adbuddiz/sdk/h/k
    //   188	218	300	com/purplebrain/adbuddiz/sdk/h/k
    //   274	297	300	com/purplebrain/adbuddiz/sdk/h/k
    //   31	91	349	java/net/UnknownHostException
    //   96	120	349	java/net/UnknownHostException
    //   120	142	349	java/net/UnknownHostException
    //   147	160	349	java/net/UnknownHostException
    //   160	188	349	java/net/UnknownHostException
    //   188	218	349	java/net/UnknownHostException
    //   274	297	349	java/net/UnknownHostException
    //   31	91	381	java/net/ConnectException
    //   96	120	381	java/net/ConnectException
    //   120	142	381	java/net/ConnectException
    //   147	160	381	java/net/ConnectException
    //   160	188	381	java/net/ConnectException
    //   188	218	381	java/net/ConnectException
    //   274	297	381	java/net/ConnectException
    //   31	91	413	java/net/SocketTimeoutException
    //   96	120	413	java/net/SocketTimeoutException
    //   120	142	413	java/net/SocketTimeoutException
    //   147	160	413	java/net/SocketTimeoutException
    //   160	188	413	java/net/SocketTimeoutException
    //   188	218	413	java/net/SocketTimeoutException
    //   274	297	413	java/net/SocketTimeoutException
    //   31	91	445	javax/net/ssl/SSLHandshakeException
    //   96	120	445	javax/net/ssl/SSLHandshakeException
    //   120	142	445	javax/net/ssl/SSLHandshakeException
    //   147	160	445	javax/net/ssl/SSLHandshakeException
    //   160	188	445	javax/net/ssl/SSLHandshakeException
    //   188	218	445	javax/net/ssl/SSLHandshakeException
    //   274	297	445	javax/net/ssl/SSLHandshakeException
    //   31	91	477	java/lang/Exception
    //   96	120	477	java/lang/Exception
    //   120	142	477	java/lang/Exception
    //   147	160	477	java/lang/Exception
    //   160	188	477	java/lang/Exception
    //   188	218	477	java/lang/Exception
    //   274	297	477	java/lang/Exception
    //   31	91	523	java/lang/Throwable
    //   96	120	523	java/lang/Throwable
    //   120	142	523	java/lang/Throwable
    //   147	160	523	java/lang/Throwable
    //   160	188	523	java/lang/Throwable
    //   188	218	523	java/lang/Throwable
    //   274	297	523	java/lang/Throwable
    //   160	188	568	org/json/JSONException
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */