package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzcz
  extends IInterface
{
  public abstract void zza(zzcv paramzzcv, String paramString)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzcz
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }
    
    public static zzcz zzB(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzcz))) {
        return (zzcz)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
      zza(zzcv.zza.zzy(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzcz
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
      public void zza(zzcv paramzzcv, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +52 -> 68
        //   19: aload_1
        //   20: invokeinterface 37 1 0
        //   25: astore 6
        //   27: aload_3
        //   28: aload 6
        //   30: invokevirtual 40	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 15	com/google/android/gms/internal/zzcz$zza$zza:zzoo	Landroid/os/IBinder;
        //   42: iconst_1
        //   43: aload_3
        //   44: aload 4
        //   46: iconst_0
        //   47: invokeinterface 49 5 0
        //   52: pop
        //   53: aload 4
        //   55: invokevirtual 52	android/os/Parcel:readException	()V
        //   58: aload 4
        //   60: invokevirtual 55	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 55	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aconst_null
        //   69: astore 6
        //   71: goto -44 -> 27
        //   74: astore 5
        //   76: aload 4
        //   78: invokevirtual 55	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 55	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	zza
        //   0	88	1	paramzzcv	zzcv
        //   0	88	2	paramString	String
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        //   74	12	5	localObject	Object
        //   25	45	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   9	15	74	finally
        //   19	27	74	finally
        //   27	58	74	finally
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */