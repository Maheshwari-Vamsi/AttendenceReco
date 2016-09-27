package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzha
class zzeh
{
  final String zzpH;
  final AdRequestParcel zzqo;
  
  zzeh(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    this.zzqo = paramAdRequestParcel;
    this.zzpH = paramString;
  }
  
  zzeh(String paramString)
    throws IOException
  {
    String[] arrayOfString = paramString.split("\000");
    if (arrayOfString.length != 2) {
      throw new IOException("Incorrect field count for QueueSeed.");
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzpH = new String(Base64.decode(arrayOfString[0], 0), "UTF-8");
      byte[] arrayOfByte = Base64.decode(arrayOfString[1], 0);
      localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
      localParcel.setDataPosition(0);
      this.zzqo = AdRequestParcel.CREATOR.zzb(localParcel);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IOException("Malformed QueueSeed encoding.");
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  String zzef()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      String str1 = Base64.encodeToString(this.zzpH.getBytes("UTF-8"), 0);
      this.zzqo.writeToParcel(localParcel, 0);
      String str2 = Base64.encodeToString(localParcel.marshall(), 0);
      String str3 = str1 + "\000" + str2;
      return str3;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      zzb.e("QueueSeed encode failed because UTF-8 is not available.");
      return "";
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */