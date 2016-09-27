package com.purplebrain.adbuddiz.sdk.i;

import java.io.InputStream;
import java.io.OutputStream;

public final class s
{
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  /* Error */
  public static String a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 23	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 27	java/lang/StringBuffer:<init>	()V
    //   7: astore_1
    //   8: new 29	java/io/BufferedReader
    //   11: dup
    //   12: new 31	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: ldc 33
    //   19: invokespecial 36	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 39	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 43	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 7
    //   32: aload 7
    //   34: ifnull +33 -> 67
    //   37: aload_1
    //   38: aload 7
    //   40: invokevirtual 47	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   43: pop
    //   44: goto -18 -> 26
    //   47: astore 5
    //   49: ldc 49
    //   51: aload 5
    //   53: invokestatic 54	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 57	java/io/BufferedReader:close	()V
    //   64: ldc 59
    //   66: areturn
    //   67: aload_1
    //   68: invokevirtual 62	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   71: astore 9
    //   73: aload_2
    //   74: invokevirtual 57	java/io/BufferedReader:close	()V
    //   77: aload 9
    //   79: areturn
    //   80: astore 10
    //   82: ldc 64
    //   84: aload 10
    //   86: invokestatic 54	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload 9
    //   91: areturn
    //   92: astore 6
    //   94: ldc 64
    //   96: aload 6
    //   98: invokestatic 54	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: goto -37 -> 64
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 57	java/io/BufferedReader:close	()V
    //   115: aload_3
    //   116: athrow
    //   117: astore 4
    //   119: ldc 64
    //   121: aload 4
    //   123: invokestatic 54	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: goto -11 -> 115
    //   129: astore_3
    //   130: goto -23 -> 107
    //   133: astore 5
    //   135: aconst_null
    //   136: astore_2
    //   137: goto -88 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramInputStream	InputStream
    //   7	61	1	localStringBuffer	StringBuffer
    //   25	112	2	localBufferedReader	java.io.BufferedReader
    //   104	12	3	localObject1	Object
    //   129	1	3	localObject2	Object
    //   117	5	4	localIOException1	java.io.IOException
    //   47	5	5	localIOException2	java.io.IOException
    //   133	1	5	localIOException3	java.io.IOException
    //   92	5	6	localIOException4	java.io.IOException
    //   30	9	7	str1	String
    //   71	19	9	str2	String
    //   80	5	10	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	32	47	java/io/IOException
    //   37	44	47	java/io/IOException
    //   67	73	47	java/io/IOException
    //   73	77	80	java/io/IOException
    //   60	64	92	java/io/IOException
    //   8	26	104	finally
    //   111	115	117	java/io/IOException
    //   26	32	129	finally
    //   37	44	129	finally
    //   49	56	129	finally
    //   67	73	129	finally
    //   8	26	133	java/io/IOException
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */