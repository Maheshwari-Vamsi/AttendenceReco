package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzew.zza;

public abstract interface zzr
  extends IInterface
{
  public abstract IBinder zza(zzd paramzzd, String paramString, zzew paramzzew, int paramInt)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzr
  {
    public static zzr zzj(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzr))) {
        return (zzr)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
      IBinder localIBinder = zza(zzd.zza.zzbs(paramParcel1.readStrongBinder()), paramParcel1.readString(), zzew.zza.zzE(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(localIBinder);
      return true;
    }
    
    private static class zza
      implements zzr
    {
      private IBinder zzoo;
      
      zza(IBinder paramIBinder)
      {
        this.zzoo = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzoo;
      }
      
      /* Error */
      public IBinder zza(zzd paramzzd, String paramString, zzew paramzzew, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +94 -> 112
        //   21: aload_1
        //   22: invokeinterface 37 1 0
        //   27: astore 8
        //   29: aload 5
        //   31: aload 8
        //   33: invokevirtual 40	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aconst_null
        //   43: astore 9
        //   45: aload_3
        //   46: ifnull +11 -> 57
        //   49: aload_3
        //   50: invokeinterface 46 1 0
        //   55: astore 9
        //   57: aload 5
        //   59: aload 9
        //   61: invokevirtual 40	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   64: aload 5
        //   66: iload 4
        //   68: invokevirtual 50	android/os/Parcel:writeInt	(I)V
        //   71: aload_0
        //   72: getfield 15	com/google/android/gms/ads/internal/client/zzr$zza$zza:zzoo	Landroid/os/IBinder;
        //   75: iconst_1
        //   76: aload 5
        //   78: aload 6
        //   80: iconst_0
        //   81: invokeinterface 56 5 0
        //   86: pop
        //   87: aload 6
        //   89: invokevirtual 59	android/os/Parcel:readException	()V
        //   92: aload 6
        //   94: invokevirtual 62	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   97: astore 11
        //   99: aload 6
        //   101: invokevirtual 65	android/os/Parcel:recycle	()V
        //   104: aload 5
        //   106: invokevirtual 65	android/os/Parcel:recycle	()V
        //   109: aload 11
        //   111: areturn
        //   112: aconst_null
        //   113: astore 8
        //   115: goto -86 -> 29
        //   118: astore 7
        //   120: aload 6
        //   122: invokevirtual 65	android/os/Parcel:recycle	()V
        //   125: aload 5
        //   127: invokevirtual 65	android/os/Parcel:recycle	()V
        //   130: aload 7
        //   132: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	133	0	this	zza
        //   0	133	1	paramzzd	zzd
        //   0	133	2	paramString	String
        //   0	133	3	paramzzew	zzew
        //   0	133	4	paramInt	int
        //   3	123	5	localParcel1	Parcel
        //   8	113	6	localParcel2	Parcel
        //   118	13	7	localObject	Object
        //   27	87	8	localIBinder1	IBinder
        //   43	17	9	localIBinder2	IBinder
        //   97	13	11	localIBinder3	IBinder
        // Exception table:
        //   from	to	target	type
        //   10	17	118	finally
        //   21	29	118	finally
        //   29	42	118	finally
        //   49	57	118	finally
        //   57	99	118	finally
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */