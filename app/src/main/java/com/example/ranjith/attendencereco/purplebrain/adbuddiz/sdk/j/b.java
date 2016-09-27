package com.purplebrain.adbuddiz.sdk.j;

import com.purplebrain.adbuddiz.sdk.f.a.a.c;
import com.purplebrain.adbuddiz.sdk.f.a.f;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public f a;
  public com.purplebrain.adbuddiz.sdk.j.b.a b = null;
  public List c = new ArrayList();
  
  public b(com.purplebrain.adbuddiz.sdk.f.a.a parama, com.purplebrain.adbuddiz.sdk.j.b.a parama1)
  {
    this.a = ((f)parama);
    this.b = parama1;
  }
  
  /* Error */
  public static com.purplebrain.adbuddiz.sdk.j.b.a a(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 39	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 43	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: astore 7
    //   10: invokestatic 49	com/purplebrain/adbuddiz/sdk/AdBuddiz:getContext	()Landroid/content/Context;
    //   13: aload_0
    //   14: invokestatic 54	com/purplebrain/adbuddiz/sdk/e/c:a	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/f/a/a/c;)Ljava/io/InputStream;
    //   17: astore 8
    //   19: aload 7
    //   21: aload 8
    //   23: invokevirtual 60	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   26: astore 9
    //   28: aload 8
    //   30: invokevirtual 65	java/io/InputStream:close	()V
    //   33: aload 9
    //   35: invokeinterface 71 1 0
    //   40: astore 11
    //   42: iconst_0
    //   43: istore 12
    //   45: iload 12
    //   47: aload 11
    //   49: invokeinterface 77 1 0
    //   54: if_icmpge +97 -> 151
    //   57: ldc 79
    //   59: aload 11
    //   61: iload 12
    //   63: invokeinterface 83 2 0
    //   68: invokeinterface 89 1 0
    //   73: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +69 -> 145
    //   79: new 97	com/purplebrain/adbuddiz/sdk/j/b/a
    //   82: dup
    //   83: aload 11
    //   85: iload 12
    //   87: invokeinterface 83 2 0
    //   92: invokespecial 100	com/purplebrain/adbuddiz/sdk/j/b/a:<init>	(Lorg/w3c/dom/Node;)V
    //   95: areturn
    //   96: astore 6
    //   98: new 102	com/purplebrain/adbuddiz/sdk/j/a/b
    //   101: dup
    //   102: getstatic 107	com/purplebrain/adbuddiz/sdk/j/a/a:a	Lcom/purplebrain/adbuddiz/sdk/j/a/a;
    //   105: aload 6
    //   107: invokespecial 110	com/purplebrain/adbuddiz/sdk/j/a/b:<init>	(Lcom/purplebrain/adbuddiz/sdk/j/a/a;Ljava/lang/Throwable;)V
    //   110: athrow
    //   111: astore_3
    //   112: aload_1
    //   113: invokevirtual 65	java/io/InputStream:close	()V
    //   116: aload_3
    //   117: athrow
    //   118: astore 5
    //   120: new 102	com/purplebrain/adbuddiz/sdk/j/a/b
    //   123: dup
    //   124: getstatic 113	com/purplebrain/adbuddiz/sdk/j/a/a:i	Lcom/purplebrain/adbuddiz/sdk/j/a/a;
    //   127: aload 5
    //   129: invokespecial 110	com/purplebrain/adbuddiz/sdk/j/a/b:<init>	(Lcom/purplebrain/adbuddiz/sdk/j/a/a;Ljava/lang/Throwable;)V
    //   132: athrow
    //   133: new 102	com/purplebrain/adbuddiz/sdk/j/a/b
    //   136: dup
    //   137: getstatic 107	com/purplebrain/adbuddiz/sdk/j/a/a:a	Lcom/purplebrain/adbuddiz/sdk/j/a/a;
    //   140: aload_2
    //   141: invokespecial 110	com/purplebrain/adbuddiz/sdk/j/a/b:<init>	(Lcom/purplebrain/adbuddiz/sdk/j/a/a;Ljava/lang/Throwable;)V
    //   144: athrow
    //   145: iinc 12 1
    //   148: goto -103 -> 45
    //   151: aconst_null
    //   152: areturn
    //   153: astore 10
    //   155: goto -122 -> 33
    //   158: astore 4
    //   160: goto -44 -> 116
    //   163: astore_3
    //   164: aload 8
    //   166: astore_1
    //   167: goto -55 -> 112
    //   170: astore_2
    //   171: aload 8
    //   173: astore_1
    //   174: goto -41 -> 133
    //   177: astore 5
    //   179: aload 8
    //   181: astore_1
    //   182: goto -62 -> 120
    //   185: astore 6
    //   187: aload 8
    //   189: astore_1
    //   190: goto -92 -> 98
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_1
    //   196: goto -63 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramc	c
    //   1	195	1	localObject1	Object
    //   140	1	2	localThrowable1	Throwable
    //   170	1	2	localThrowable2	Throwable
    //   193	1	2	localThrowable3	Throwable
    //   111	6	3	localObject2	Object
    //   163	1	3	localObject3	Object
    //   158	1	4	localThrowable4	Throwable
    //   118	10	5	localIOException1	java.io.IOException
    //   177	1	5	localIOException2	java.io.IOException
    //   96	10	6	localSAXException1	org.xml.sax.SAXException
    //   185	1	6	localSAXException2	org.xml.sax.SAXException
    //   8	12	7	localDocumentBuilder	javax.xml.parsers.DocumentBuilder
    //   17	171	8	localInputStream	java.io.InputStream
    //   26	8	9	localDocument	org.w3c.dom.Document
    //   153	1	10	localThrowable5	Throwable
    //   40	44	11	localNodeList	org.w3c.dom.NodeList
    //   43	103	12	i	int
    // Exception table:
    //   from	to	target	type
    //   2	19	96	org/xml/sax/SAXException
    //   2	19	111	finally
    //   98	111	111	finally
    //   120	133	111	finally
    //   133	145	111	finally
    //   2	19	118	java/io/IOException
    //   28	33	153	java/lang/Throwable
    //   112	116	158	java/lang/Throwable
    //   19	28	163	finally
    //   19	28	170	java/lang/Throwable
    //   19	28	177	java/io/IOException
    //   19	28	185	org/xml/sax/SAXException
    //   2	19	193	java/lang/Throwable
  }
  
  public final c a(com.purplebrain.adbuddiz.sdk.j.b.a.a parama)
  {
    com.purplebrain.adbuddiz.sdk.j.b.a.d locald = (com.purplebrain.adbuddiz.sdk.j.b.a.d)parama;
    return new com.purplebrain.adbuddiz.sdk.f.a.a.e(this.a, com.purplebrain.adbuddiz.sdk.f.a.a.d.a, false, com.purplebrain.adbuddiz.sdk.f.e.c, new URL(locald.f()));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */