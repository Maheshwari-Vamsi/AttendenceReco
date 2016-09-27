package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzv
{
  private final String separator;
  
  private zzv(String paramString)
  {
    this.separator = paramString;
  }
  
  public static zzv zzcF(String paramString)
  {
    return new zzv(paramString);
  }
  
  public final String zza(Iterable<?> paramIterable)
  {
    return zza(new StringBuilder(), paramIterable).toString();
  }
  
  public final StringBuilder zza(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      paramStringBuilder.append(zzw(localIterator.next()));
      while (localIterator.hasNext())
      {
        paramStringBuilder.append(this.separator);
        paramStringBuilder.append(zzw(localIterator.next()));
      }
    }
    return paramStringBuilder;
  }
  
  CharSequence zzw(Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */