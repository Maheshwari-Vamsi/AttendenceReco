package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

public abstract class zzak
  implements zzaj
{
  protected static GoogleApiClient zznr;
  private static zzaq zzns;
  protected MotionEvent zzno;
  protected DisplayMetrics zznp;
  protected zzap zznq;
  
  protected zzak(Context paramContext, zzap paramzzap, zzaq paramzzaq)
  {
    this.zznq = paramzzap;
    zzns = paramzzaq;
    try
    {
      this.zznp = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.zznp = new DisplayMetrics();
      this.zznp.density = 1.0F;
    }
  }
  
  private void zzS()
  {
    zzns.reset();
  }
  
  private byte[] zzT()
    throws IOException
  {
    return zzns.zzad();
  }
  
  /* Error */
  private String zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 69	com/google/android/gms/internal/zzak:zzS	()V
    //   6: iload_3
    //   7: ifeq +31 -> 38
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 73	com/google/android/gms/internal/zzak:zzd	(Landroid/content/Context;)V
    //   15: aload_0
    //   16: invokespecial 75	com/google/android/gms/internal/zzak:zzT	()[B
    //   19: astore 8
    //   21: aload_0
    //   22: monitorexit
    //   23: aload 8
    //   25: arraylength
    //   26: ifne +35 -> 61
    //   29: iconst_5
    //   30: invokestatic 81	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   33: astore 10
    //   35: aload 10
    //   37: areturn
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 84	com/google/android/gms/internal/zzak:zzc	(Landroid/content/Context;)V
    //   43: goto -28 -> 15
    //   46: astore 7
    //   48: aload_0
    //   49: monitorexit
    //   50: aload 7
    //   52: athrow
    //   53: astore 6
    //   55: bipush 7
    //   57: invokestatic 81	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   60: areturn
    //   61: aload_0
    //   62: aload 8
    //   64: aload_2
    //   65: invokevirtual 87	com/google/android/gms/internal/zzak:zza	([BLjava/lang/String;)Ljava/lang/String;
    //   68: astore 9
    //   70: aload 9
    //   72: areturn
    //   73: astore 5
    //   75: bipush 7
    //   77: invokestatic 81	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   80: areturn
    //   81: astore 4
    //   83: iconst_3
    //   84: invokestatic 81	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   87: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	zzak
    //   0	88	1	paramContext	Context
    //   0	88	2	paramString	String
    //   0	88	3	paramBoolean	boolean
    //   81	1	4	localIOException	IOException
    //   73	1	5	localUnsupportedEncodingException	UnsupportedEncodingException
    //   53	1	6	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   46	5	7	localObject	Object
    //   19	44	8	arrayOfByte	byte[]
    //   68	3	9	str1	String
    //   33	3	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	6	46	finally
    //   10	15	46	finally
    //   15	23	46	finally
    //   38	43	46	finally
    //   48	50	46	finally
    //   0	2	53	java/security/NoSuchAlgorithmException
    //   23	35	53	java/security/NoSuchAlgorithmException
    //   50	53	53	java/security/NoSuchAlgorithmException
    //   61	70	53	java/security/NoSuchAlgorithmException
    //   0	2	73	java/io/UnsupportedEncodingException
    //   23	35	73	java/io/UnsupportedEncodingException
    //   50	53	73	java/io/UnsupportedEncodingException
    //   61	70	73	java/io/UnsupportedEncodingException
    //   0	2	81	java/io/IOException
    //   23	35	81	java/io/IOException
    //   50	53	81	java/io/IOException
    //   61	70	81	java/io/IOException
  }
  
  String zza(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException
  {
    if (paramArrayOfByte.length > 239)
    {
      zzS();
      zza(20, 1L);
      paramArrayOfByte = zzT();
    }
    byte[] arrayOfByte5;
    if (paramArrayOfByte.length < 239)
    {
      arrayOfByte5 = new byte[239 - paramArrayOfByte.length];
      new SecureRandom().nextBytes(arrayOfByte5);
    }
    for (byte[] arrayOfByte1 = ByteBuffer.allocate(240).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).put(arrayOfByte5).array();; arrayOfByte1 = ByteBuffer.allocate(240).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).array())
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      byte[] arrayOfByte3 = ByteBuffer.allocate(256).put(arrayOfByte2).put(arrayOfByte1).array();
      byte[] arrayOfByte4 = new byte['Ā'];
      new zzai().zzb(arrayOfByte3, arrayOfByte4);
      if ((paramString != null) && (paramString.length() > 0)) {
        zza(paramString, arrayOfByte4);
      }
      return this.zznq.zza(arrayOfByte4, true);
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.zzno != null) {
      this.zzno.recycle();
    }
    this.zzno = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.zznp.density, paramInt2 * this.zznp.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }
  
  protected void zza(int paramInt, long paramLong)
    throws IOException
  {
    zzns.zzb(paramInt, paramLong);
  }
  
  protected void zza(int paramInt, String paramString)
    throws IOException
  {
    zzns.zzb(paramInt, paramString);
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.zzno != null) {
        this.zzno.recycle();
      }
      this.zzno = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  void zza(String paramString, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    if (paramString.length() > 32) {
      paramString = paramString.substring(0, 32);
    }
    new zztb(paramString.getBytes("UTF-8")).zzB(paramArrayOfByte);
  }
  
  public String zzb(Context paramContext)
  {
    return zza(paramContext, null, false);
  }
  
  public String zzb(Context paramContext, String paramString)
  {
    return zza(paramContext, paramString, true);
  }
  
  protected abstract void zzc(Context paramContext);
  
  protected abstract void zzd(Context paramContext);
  
  protected String zzk(String paramString)
  {
    if ((paramString != null) && (paramString.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")))
    {
      UUID localUUID = UUID.fromString(paramString);
      byte[] arrayOfByte = new byte[16];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.putLong(localUUID.getMostSignificantBits());
      localByteBuffer.putLong(localUUID.getLeastSignificantBits());
      paramString = this.zznq.zza(arrayOfByte, true);
    }
    return paramString;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */