package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzha
public class zzbn
{
  private final int zzte;
  private final int zztf;
  private final int zztg;
  private final zzbm zzth = new zzbp();
  
  public zzbn(int paramInt)
  {
    this.zztf = paramInt;
    this.zzte = 6;
    this.zztg = 0;
  }
  
  private String zzA(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    if (arrayOfString.length == 0) {
      return "";
    }
    zza localzza = zzcH();
    Arrays.sort(arrayOfString, new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    });
    int i = 0;
    if ((i < arrayOfString.length) && (i < this.zztf))
    {
      if (arrayOfString[i].trim().length() == 0) {}
      for (;;)
      {
        i++;
        break;
        try
        {
          localzza.write(this.zzth.zzz(arrayOfString[i]));
        }
        catch (IOException localIOException)
        {
          zzb.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return localzza.toString();
  }
  
  String zzB(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\n");
    if (arrayOfString1.length == 0) {
      return "";
    }
    zza localzza = zzcH();
    PriorityQueue localPriorityQueue = new PriorityQueue(this.zztf, new Comparator()
    {
      public int zza(zzbq.zza paramAnonymouszza1, zzbq.zza paramAnonymouszza2)
      {
        return (int)(paramAnonymouszza1.value - paramAnonymouszza2.value);
      }
    });
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = zzbo.zzD(arrayOfString1[i]);
      if (arrayOfString2.length < this.zzte) {}
      for (;;)
      {
        i++;
        break;
        zzbq.zza(arrayOfString2, this.zztf, this.zzte, localPriorityQueue);
      }
    }
    Iterator localIterator = localPriorityQueue.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        zzbq.zza localzza1 = (zzbq.zza)localIterator.next();
        try
        {
          localzza.write(this.zzth.zzz(localzza1.zztm));
        }
        catch (IOException localIOException)
        {
          zzb.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return localzza.toString();
  }
  
  public String zza(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((String)localIterator.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    switch (this.zztg)
    {
    default: 
      return "";
    case 0: 
      return zzB(localStringBuffer.toString());
    }
    return zzA(localStringBuffer.toString());
  }
  
  zza zzcH()
  {
    return new zza();
  }
  
  static class zza
  {
    ByteArrayOutputStream zztj = new ByteArrayOutputStream(4096);
    Base64OutputStream zztk = new Base64OutputStream(this.zztj, 10);
    
    public String toString()
    {
      try
      {
        this.zztk.close();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            this.zztj.close();
            String str = this.zztj.toString();
            return str;
          }
          catch (IOException localIOException2)
          {
            zzb.zzb("HashManager: Unable to convert to Base64.", localIOException2);
            return "";
          }
          finally
          {
            this.zztj = null;
            this.zztk = null;
          }
          localIOException1 = localIOException1;
          zzb.zzb("HashManager: Unable to convert to Base64.", localIOException1);
        }
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.zztk.write(paramArrayOfByte);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */