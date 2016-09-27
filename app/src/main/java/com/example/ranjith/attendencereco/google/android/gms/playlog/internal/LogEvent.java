package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Set;

public class LogEvent
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final String tag;
  public final int versionCode;
  public final long zzaYn;
  public final long zzaYo;
  public final byte[] zzaYp;
  public final Bundle zzaYq;
  
  LogEvent(int paramInt, long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.versionCode = paramInt;
    this.zzaYn = paramLong1;
    this.zzaYo = paramLong2;
    this.tag = paramString;
    this.zzaYp = paramArrayOfByte;
    this.zzaYq = paramBundle;
  }
  
  public LogEvent(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.versionCode = 1;
    this.zzaYn = paramLong1;
    this.zzaYo = paramLong2;
    this.tag = paramString;
    this.zzaYp = paramArrayOfByte;
    this.zzaYq = zzd(paramVarArgs);
  }
  
  private static Bundle zzd(String... paramVarArgs)
  {
    Bundle localBundle = null;
    if (paramVarArgs == null) {}
    for (;;)
    {
      return localBundle;
      if (paramVarArgs.length % 2 != 0) {
        throw new IllegalArgumentException("extras must have an even number of elements");
      }
      int i = paramVarArgs.length / 2;
      localBundle = null;
      if (i != 0)
      {
        localBundle = new Bundle(i);
        for (int j = 0; j < i; j++) {
          localBundle.putString(paramVarArgs[(j * 2)], paramVarArgs[(1 + j * 2)]);
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag=").append(this.tag).append(",");
    localStringBuilder.append("eventTime=").append(this.zzaYn).append(",");
    localStringBuilder.append("eventUptime=").append(this.zzaYo).append(",");
    if ((this.zzaYq != null) && (!this.zzaYq.isEmpty()))
    {
      localStringBuilder.append("keyValues=");
      Iterator localIterator = this.zzaYq.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("(").append(str).append(",");
        localStringBuilder.append(this.zzaYq.getString(str)).append(")");
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\playlog\internal\LogEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */