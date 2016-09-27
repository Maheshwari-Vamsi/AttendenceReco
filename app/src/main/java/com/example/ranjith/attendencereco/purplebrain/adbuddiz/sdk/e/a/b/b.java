package com.purplebrain.adbuddiz.sdk.e.a.b;

import android.media.MediaMetadataRetriever;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.i.b.f;
import com.purplebrain.adbuddiz.sdk.i.m;
import java.util.Collection;
import java.util.Iterator;

public final class b
  extends c
{
  public b()
  {
    super((byte)0);
  }
  
  private void b(a parama)
  {
    int i;
    try
    {
      Iterator localIterator = parama.d().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!b((com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next()));
      i = 1;
    }
    catch (Exception localException)
    {
      this.a.a(parama, localException);
      return;
    }
    if (this.a != null)
    {
      this.a.b(parama);
      return;
    }
    while (i != 0)
    {
      return;
      i = 0;
    }
  }
  
  /* Error */
  private boolean e(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 40	com/purplebrain/adbuddiz/sdk/e/a/b/c:b	(Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)Z
    //   5: ifeq +5 -> 10
    //   8: iconst_1
    //   9: ireturn
    //   10: aload_1
    //   11: getfield 57	com/purplebrain/adbuddiz/sdk/f/a/a/c:a	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   14: checkcast 59	com/purplebrain/adbuddiz/sdk/f/a/c
    //   17: astore_2
    //   18: new 61	com/purplebrain/adbuddiz/sdk/f/a/a/f
    //   21: dup
    //   22: aload_1
    //   23: getfield 57	com/purplebrain/adbuddiz/sdk/f/a/a/c:a	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   26: getstatic 66	com/purplebrain/adbuddiz/sdk/f/a/a/d:b	Lcom/purplebrain/adbuddiz/sdk/f/a/a/d;
    //   29: aload_1
    //   30: invokevirtual 69	com/purplebrain/adbuddiz/sdk/f/a/a/c:b	()Ljava/lang/String;
    //   33: iconst_1
    //   34: getstatic 75	com/purplebrain/adbuddiz/sdk/f/e:c	Lcom/purplebrain/adbuddiz/sdk/f/e;
    //   37: aload_1
    //   38: invokevirtual 78	com/purplebrain/adbuddiz/sdk/f/a/a/c:d	()Ljava/net/URL;
    //   41: invokespecial 81	com/purplebrain/adbuddiz/sdk/f/a/a/f:<init>	(Lcom/purplebrain/adbuddiz/sdk/f/a/a;Lcom/purplebrain/adbuddiz/sdk/f/a/a/d;Ljava/lang/String;ZLcom/purplebrain/adbuddiz/sdk/f/e;Ljava/net/URL;)V
    //   44: astore_3
    //   45: invokestatic 87	com/purplebrain/adbuddiz/sdk/AdBuddiz:getContext	()Landroid/content/Context;
    //   48: aload_1
    //   49: invokestatic 92	com/purplebrain/adbuddiz/sdk/i/m:c	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)Ljava/io/InputStream;
    //   52: astore 7
    //   54: aload 7
    //   56: invokestatic 97	com/purplebrain/adbuddiz/sdk/i/s:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   59: astore 8
    //   61: aload_2
    //   62: getfield 101	com/purplebrain/adbuddiz/sdk/f/a/c:m	Ljava/util/Map;
    //   65: invokeinterface 107 1 0
    //   70: invokeinterface 110 1 0
    //   75: astore 9
    //   77: aload 8
    //   79: astore 10
    //   81: aload 9
    //   83: invokeinterface 31 1 0
    //   88: ifeq +45 -> 133
    //   91: aload 9
    //   93: invokeinterface 35 1 0
    //   98: checkcast 112	java/util/Map$Entry
    //   101: astore 20
    //   103: aload 10
    //   105: aload 20
    //   107: invokeinterface 115 1 0
    //   112: checkcast 117	java/lang/CharSequence
    //   115: aload 20
    //   117: invokeinterface 120 1 0
    //   122: checkcast 117	java/lang/CharSequence
    //   125: invokevirtual 126	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   128: astore 10
    //   130: goto -49 -> 81
    //   133: invokestatic 87	com/purplebrain/adbuddiz/sdk/AdBuddiz:getContext	()Landroid/content/Context;
    //   136: astore 11
    //   138: new 128	java/io/ByteArrayInputStream
    //   141: dup
    //   142: aload 10
    //   144: ldc -126
    //   146: invokevirtual 134	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   149: invokespecial 137	java/io/ByteArrayInputStream:<init>	([B)V
    //   152: astore 12
    //   154: aload 11
    //   156: aload 12
    //   158: aload_3
    //   159: invokestatic 140	com/purplebrain/adbuddiz/sdk/i/m:a	(Landroid/content/Context;Ljava/io/InputStream;Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)V
    //   162: aload 12
    //   164: invokevirtual 145	java/io/InputStream:close	()V
    //   167: aload_2
    //   168: getfield 148	com/purplebrain/adbuddiz/sdk/f/a/a:e	Ljava/util/Set;
    //   171: astore 16
    //   173: aload 16
    //   175: monitorenter
    //   176: aload_2
    //   177: getfield 148	com/purplebrain/adbuddiz/sdk/f/a/a:e	Ljava/util/Set;
    //   180: aload_1
    //   181: invokeinterface 152 2 0
    //   186: pop
    //   187: aload 16
    //   189: monitorexit
    //   190: aload_2
    //   191: aload_3
    //   192: invokevirtual 155	com/purplebrain/adbuddiz/sdk/f/a/c:a	(Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)V
    //   195: aload_0
    //   196: getfield 44	com/purplebrain/adbuddiz/sdk/e/a/b/b:a	Lcom/purplebrain/adbuddiz/sdk/e/a/b/c$a;
    //   199: aload_2
    //   200: invokeinterface 157 2 0
    //   205: aload 7
    //   207: invokevirtual 145	java/io/InputStream:close	()V
    //   210: iconst_0
    //   211: ireturn
    //   212: astore 13
    //   214: aconst_null
    //   215: astore 12
    //   217: aload 12
    //   219: invokevirtual 145	java/io/InputStream:close	()V
    //   222: aload 13
    //   224: athrow
    //   225: astore 4
    //   227: aload 7
    //   229: astore 5
    //   231: aload 5
    //   233: invokevirtual 145	java/io/InputStream:close	()V
    //   236: aload 4
    //   238: athrow
    //   239: astore 17
    //   241: aload 16
    //   243: monitorexit
    //   244: aload 17
    //   246: athrow
    //   247: astore 15
    //   249: goto -82 -> 167
    //   252: astore 14
    //   254: goto -32 -> 222
    //   257: astore 19
    //   259: goto -49 -> 210
    //   262: astore 6
    //   264: goto -28 -> 236
    //   267: astore 4
    //   269: aconst_null
    //   270: astore 5
    //   272: goto -41 -> 231
    //   275: astore 13
    //   277: goto -60 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	b
    //   0	280	1	paramc	com.purplebrain.adbuddiz.sdk.f.a.a.c
    //   17	183	2	localc	com.purplebrain.adbuddiz.sdk.f.a.c
    //   44	148	3	localf	com.purplebrain.adbuddiz.sdk.f.a.a.f
    //   225	12	4	localObject1	Object
    //   267	1	4	localObject2	Object
    //   229	42	5	localInputStream1	java.io.InputStream
    //   262	1	6	localThrowable1	Throwable
    //   52	176	7	localInputStream2	java.io.InputStream
    //   59	19	8	str1	String
    //   75	17	9	localIterator	Iterator
    //   79	64	10	str2	String
    //   136	19	11	localContext	android.content.Context
    //   152	66	12	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   212	11	13	localObject3	Object
    //   275	1	13	localObject4	Object
    //   252	1	14	localThrowable2	Throwable
    //   247	1	15	localThrowable3	Throwable
    //   171	71	16	localSet	java.util.Set
    //   239	6	17	localObject5	Object
    //   257	1	19	localThrowable4	Throwable
    //   101	15	20	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   138	154	212	finally
    //   54	77	225	finally
    //   81	130	225	finally
    //   133	138	225	finally
    //   162	167	225	finally
    //   167	176	225	finally
    //   190	205	225	finally
    //   217	222	225	finally
    //   222	225	225	finally
    //   244	247	225	finally
    //   176	190	239	finally
    //   241	244	239	finally
    //   162	167	247	java/lang/Throwable
    //   217	222	252	java/lang/Throwable
    //   205	210	257	java/lang/Throwable
    //   231	236	262	java/lang/Throwable
    //   45	54	267	finally
    //   154	162	275	finally
  }
  
  private boolean f(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      if ((localObject1 == null) && (i < 2)) {}
      Object localObject2;
      for (;;)
      {
        try
        {
          MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
          localMediaMetadataRetriever.setDataSource(m.a(AdBuddiz.getContext(), paramc));
          String str1 = localMediaMetadataRetriever.extractMetadata(9);
          String str2 = localMediaMetadataRetriever.extractMetadata(18);
          String str3 = localMediaMetadataRetriever.extractMetadata(19);
          if ((str3 == null) || (str2 == null)) {
            break label220;
          }
          if (str1 == null)
          {
            break label220;
            localObject2 = Boolean.valueOf(bool);
            break;
          }
          com.purplebrain.adbuddiz.sdk.f.a.c localc = (com.purplebrain.adbuddiz.sdk.f.a.c)paramc.a;
          localc.p = Long.valueOf(Long.parseLong(str1));
          localc.q = Integer.valueOf(Integer.parseInt(str2));
          localc.r = Integer.valueOf(Integer.parseInt(str3));
          com.purplebrain.adbuddiz.sdk.i.c.d.a(paramc, localc.p.longValue());
          com.purplebrain.adbuddiz.sdk.i.c.d.a(paramc, localc.q.intValue());
          com.purplebrain.adbuddiz.sdk.i.c.d.b(paramc, localc.r.intValue());
          this.a.a(localc);
          bool = true;
          continue;
          if (localObject1 != null) {
            break label215;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable)
        {
          localObject2 = Boolean.valueOf(false);
        }
        return false;
        label215:
        return ((Boolean)localObject1).booleanValue();
        label220:
        boolean bool = false;
      }
      i++;
      localObject1 = localObject2;
    }
  }
  
  public final void a(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    b(paramc.a);
  }
  
  public final void a(a parama)
  {
    b(parama);
  }
  
  public final void a(a parama, Collection paramCollection)
  {
    new com.purplebrain.adbuddiz.sdk.i.b();
    com.purplebrain.adbuddiz.sdk.i.b.a(paramCollection);
  }
  
  public final boolean a(a parama, e parame)
  {
    Iterator localIterator = parama.d().iterator();
    while (localIterator.hasNext())
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc = (com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next();
      if (!c(localc)) {
        return false;
      }
      if ((localc.a("isVideo")) && (!com.purplebrain.adbuddiz.sdk.i.c.d.a(localc))) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean b(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    if (paramc.a("isVideo"))
    {
      boolean bool3;
      if (super.b(paramc)) {
        bool3 = true;
      }
      boolean bool4;
      do
      {
        boolean bool2;
        do
        {
          return bool3;
          bool2 = com.purplebrain.adbuddiz.sdk.i.c.d.a(paramc);
          bool3 = false;
        } while (bool2);
        bool4 = f(paramc);
        bool3 = false;
      } while (bool4);
      f.a(AdBuddiz.getContext(), (com.purplebrain.adbuddiz.sdk.f.a.c)paramc.a);
      throw new Exception("Cannot extract metadata information from the video.");
    }
    com.purplebrain.adbuddiz.sdk.f.a.a.d locald1 = paramc.b;
    com.purplebrain.adbuddiz.sdk.f.a.a.d locald2 = com.purplebrain.adbuddiz.sdk.f.a.a.d.c;
    boolean bool1 = false;
    if (locald1 != locald2) {}
    while (bool1)
    {
      return e(paramc);
      bool1 = ((com.purplebrain.adbuddiz.sdk.f.a.c)paramc.a).l.equals(paramc.b());
    }
    return super.b(paramc);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */