package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzha
public class zzbp
  extends zzbm
{
  private MessageDigest zztl;
  
  byte[] zza(String[] paramArrayOfString)
  {
    byte[] arrayOfByte = new byte[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++) {
      arrayOfByte[i] = zzk(zzbo.zzC(paramArrayOfString[i]));
    }
    return arrayOfByte;
  }
  
  byte zzk(int paramInt)
  {
    return (byte)(paramInt & 0xFF ^ (0xFF00 & paramInt) >> 8 ^ (0xFF0000 & paramInt) >> 16 ^ (0xFF000000 & paramInt) >> 24);
  }
  
  public byte[] zzz(String paramString)
  {
    byte[] arrayOfByte1 = zza(paramString.split(" "));
    this.zztl = zzcG();
    for (;;)
    {
      byte[] arrayOfByte3;
      synchronized (this.zzpK)
      {
        if (this.zztl == null)
        {
          byte[] arrayOfByte2 = new byte[0];
          return arrayOfByte2;
        }
        this.zztl.reset();
        this.zztl.update(arrayOfByte1);
        arrayOfByte3 = this.zztl.digest();
        i = 4;
        if (arrayOfByte3.length > i)
        {
          byte[] arrayOfByte4 = new byte[i];
          System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte4.length);
          return arrayOfByte4;
        }
      }
      int i = arrayOfByte3.length;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */