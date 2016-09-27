package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.a.a.c;
import com.purplebrain.adbuddiz.sdk.f.a.a.d;
import com.purplebrain.adbuddiz.sdk.f.a.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class m
{
  public static String a(Context paramContext, c paramc)
  {
    return paramContext.getFileStreamPath(a(paramc)).getAbsolutePath();
  }
  
  public static String a(c paramc)
  {
    return b(paramc) + paramc.b();
  }
  
  private static String a(e parame)
  {
    return "ABZ_31_" + parame.e + "_";
  }
  
  public static String a(File paramFile, e parame)
  {
    return paramFile.getName().substring(a(parame).length());
  }
  
  public static String a(String paramString)
  {
    return "ABZ_31_" + paramString + ".abz";
  }
  
  public static List a(Context paramContext, e parame, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = a(parame);
    for (String str2 : paramContext.fileList()) {
      if ((str2.startsWith(str1)) && ((paramBoolean) || ((!paramBoolean) && (!str2.endsWith("_tmp"))))) {
        localArrayList.add(paramContext.getFileStreamPath(str2));
      }
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, InputStream paramInputStream, c paramc)
  {
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(c(paramc), 0);
      s.a(paramInputStream, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      paramContext.getFileStreamPath(c(paramc)).renameTo(paramContext.getFileStreamPath(a(paramc)));
      return;
    }
    catch (IOException localIOException)
    {
      o.a("writeAdResource() IOException", localIOException);
      paramContext.getFileStreamPath(c(paramc)).delete();
      paramContext.getFileStreamPath(a(paramc)).delete();
      throw localIOException;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, "ABZ_31_" + paramString1 + ".abz", paramString2);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getFileStreamPath(a(paramString)).exists();
  }
  
  public static InputStream b(Context paramContext, String paramString)
  {
    return paramContext.openFileInput(a(paramString));
  }
  
  private static String b(c paramc)
  {
    if (paramc.b.e) {
      return "ABZ_31_";
    }
    return a(paramc.a.e()) + paramc.a() + "_";
  }
  
  public static void b(Context paramContext, c paramc)
  {
    File localFile = paramContext.getFileStreamPath(a(paramc));
    if (localFile.exists()) {
      localFile.setLastModified(new Date().getTime());
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString1, 0);
      localFileOutputStream.flush();
      localFileOutputStream.write(paramString2.getBytes());
      localFileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        o.a("writeConfig() IOException", localIOException);
      }
    }
    finally {}
  }
  
  public static InputStream c(Context paramContext, c paramc)
  {
    return paramContext.openFileInput(a(paramc));
  }
  
  public static String c(Context paramContext, String paramString)
  {
    return e(paramContext, "ABZ_31_" + paramString + ".abz");
  }
  
  private static String c(c paramc)
  {
    return b(paramc) + paramc.b() + "_tmp";
  }
  
  public static void d(Context paramContext, String paramString)
  {
    paramContext.deleteFile("ABZ_31_" + paramString + ".abz");
  }
  
  public static String e(Context paramContext, String paramString)
  {
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput(paramString);
      str = s.a(localFileInputStream);
      localFileInputStream.close();
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException = localFileNotFoundException;
        str = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException = localIOException;
        String str = null;
      }
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */