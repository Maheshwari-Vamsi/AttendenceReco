package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zznt;
import java.io.IOException;
import java.io.OutputStream;

@zzha
public final class LargeParcelTeleporter
  implements SafeParcelable
{
  public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzl();
  final int mVersionCode;
  ParcelFileDescriptor zzHf;
  private Parcelable zzHg;
  private boolean zzHh;
  
  LargeParcelTeleporter(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mVersionCode = paramInt;
    this.zzHf = paramParcelFileDescriptor;
    this.zzHg = null;
    this.zzHh = true;
  }
  
  public LargeParcelTeleporter(SafeParcelable paramSafeParcelable)
  {
    this.mVersionCode = 1;
    this.zzHf = null;
    this.zzHg = paramSafeParcelable;
    this.zzHh = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Parcel localParcel;
    if (this.zzHf == null) {
      localParcel = Parcel.obtain();
    }
    try
    {
      this.zzHg.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      this.zzHf = zzf(arrayOfByte);
      zzl.zza(this, paramParcel, paramInt);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public <T extends SafeParcelable> T zza(Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzHh	Z
    //   4: ifeq +105 -> 109
    //   7: aload_0
    //   8: getfield 33	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzHf	Landroid/os/ParcelFileDescriptor;
    //   11: ifnonnull +10 -> 21
    //   14: ldc 72
    //   16: invokestatic 78	com/google/android/gms/ads/internal/util/client/zzb:e	(Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 80	java/io/DataInputStream
    //   24: dup
    //   25: new 82	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 33	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzHf	Landroid/os/ParcelFileDescriptor;
    //   33: invokespecial 85	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   36: invokespecial 88	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 91	java/io/DataInputStream:readInt	()I
    //   44: newarray <illegal type>
    //   46: astore 5
    //   48: aload_2
    //   49: aload 5
    //   51: iconst_0
    //   52: aload 5
    //   54: arraylength
    //   55: invokevirtual 95	java/io/DataInputStream:readFully	([BII)V
    //   58: aload_2
    //   59: invokestatic 101	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
    //   62: invokestatic 48	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   65: astore 6
    //   67: aload 6
    //   69: aload 5
    //   71: iconst_0
    //   72: aload 5
    //   74: arraylength
    //   75: invokevirtual 104	android/os/Parcel:unmarshall	([BII)V
    //   78: aload 6
    //   80: iconst_0
    //   81: invokevirtual 108	android/os/Parcel:setDataPosition	(I)V
    //   84: aload_0
    //   85: aload_1
    //   86: aload 6
    //   88: invokeinterface 114 2 0
    //   93: checkcast 6	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   96: putfield 35	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzHg	Landroid/os/Parcelable;
    //   99: aload 6
    //   101: invokevirtual 59	android/os/Parcel:recycle	()V
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 37	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzHh	Z
    //   109: aload_0
    //   110: getfield 35	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzHg	Landroid/os/Parcelable;
    //   113: checkcast 6	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   116: areturn
    //   117: astore 4
    //   119: new 116	java/lang/IllegalStateException
    //   122: dup
    //   123: ldc 118
    //   125: aload 4
    //   127: invokespecial 121	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: athrow
    //   131: astore_3
    //   132: aload_2
    //   133: invokestatic 101	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
    //   136: aload_3
    //   137: athrow
    //   138: astore 7
    //   140: aload 6
    //   142: invokevirtual 59	android/os/Parcel:recycle	()V
    //   145: aload 7
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	LargeParcelTeleporter
    //   0	148	1	paramCreator	Parcelable.Creator<T>
    //   39	94	2	localDataInputStream	java.io.DataInputStream
    //   131	6	3	localObject1	Object
    //   117	9	4	localIOException	IOException
    //   46	27	5	arrayOfByte	byte[]
    //   65	76	6	localParcel	Parcel
    //   138	8	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	58	117	java/io/IOException
    //   40	58	131	finally
    //   119	131	131	finally
    //   67	99	138	finally
  }
  
  protected <T> ParcelFileDescriptor zzf(final byte[] paramArrayOfByte)
  {
    try
    {
      ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
      localAutoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(arrayOfParcelFileDescriptor[1]);
      ParcelFileDescriptor localParcelFileDescriptor;
      zzb.zzb("Error transporting the ad response", localIOException1);
    }
    catch (IOException localIOException1)
    {
      try
      {
        new Thread(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: new 33	java/io/DataOutputStream
            //   3: dup
            //   4: aload_0
            //   5: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzHi	Ljava/io/OutputStream;
            //   8: invokespecial 36	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   11: astore_1
            //   12: aload_1
            //   13: aload_0
            //   14: getfield 25	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzHj	[B
            //   17: arraylength
            //   18: invokevirtual 40	java/io/DataOutputStream:writeInt	(I)V
            //   21: aload_1
            //   22: aload_0
            //   23: getfield 25	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzHj	[B
            //   26: invokevirtual 44	java/io/DataOutputStream:write	([B)V
            //   29: aload_1
            //   30: ifnonnull +11 -> 41
            //   33: aload_0
            //   34: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzHi	Ljava/io/OutputStream;
            //   37: invokestatic 50	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
            //   40: return
            //   41: aload_1
            //   42: invokestatic 50	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
            //   45: return
            //   46: astore_2
            //   47: aconst_null
            //   48: astore_1
            //   49: ldc 52
            //   51: aload_2
            //   52: invokestatic 57	com/google/android/gms/ads/internal/util/client/zzb:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
            //   55: invokestatic 63	com/google/android/gms/ads/internal/zzp:zzbA	()Lcom/google/android/gms/internal/zzig;
            //   58: aload_2
            //   59: iconst_1
            //   60: invokevirtual 68	com/google/android/gms/internal/zzig:zzb	(Ljava/lang/Throwable;Z)V
            //   63: aload_1
            //   64: ifnonnull +11 -> 75
            //   67: aload_0
            //   68: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzHi	Ljava/io/OutputStream;
            //   71: invokestatic 50	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
            //   74: return
            //   75: aload_1
            //   76: invokestatic 50	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
            //   79: return
            //   80: astore_3
            //   81: aconst_null
            //   82: astore_1
            //   83: aload_1
            //   84: ifnonnull +12 -> 96
            //   87: aload_0
            //   88: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzHi	Ljava/io/OutputStream;
            //   91: invokestatic 50	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
            //   94: aload_3
            //   95: athrow
            //   96: aload_1
            //   97: invokestatic 50	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
            //   100: goto -6 -> 94
            //   103: astore_3
            //   104: goto -21 -> 83
            //   107: astore_2
            //   108: goto -59 -> 49
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	111	0	this	1
            //   11	86	1	localDataOutputStream	java.io.DataOutputStream
            //   46	13	2	localIOException1	IOException
            //   107	1	2	localIOException2	IOException
            //   80	15	3	localObject1	Object
            //   103	1	3	localObject2	Object
            // Exception table:
            //   from	to	target	type
            //   0	12	46	java/io/IOException
            //   0	12	80	finally
            //   12	29	103	finally
            //   49	63	103	finally
            //   12	29	107	java/io/IOException
          }
        }).start();
        localParcelFileDescriptor = arrayOfParcelFileDescriptor[0];
        return localParcelFileDescriptor;
      }
      catch (IOException localIOException2)
      {
        final ParcelFileDescriptor.AutoCloseOutputStream localAutoCloseOutputStream;
        for (;;) {}
      }
      localIOException1 = localIOException1;
      localAutoCloseOutputStream = null;
    }
    zzp.zzbA().zzb(localIOException1, true);
    zznt.zzb(localAutoCloseOutputStream);
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\LargeParcelTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */