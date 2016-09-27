package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzp
  extends IInterface
{
  public abstract String getMediationAdapterClassName()
    throws RemoteException;
  
  public abstract boolean isLoading()
    throws RemoteException;
  
  public abstract void zzf(AdRequestParcel paramAdRequestParcel)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzp
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
    }
    
    public static zzp zzh(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
      if ((localIInterface != null) && ((localIInterface instanceof zzp))) {
        return (zzp)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
        if (paramParcel1.readInt() != 0) {}
        for (AdRequestParcel localAdRequestParcel = AdRequestParcel.CREATOR.zzb(paramParcel1);; localAdRequestParcel = null)
        {
          zzf(localAdRequestParcel);
          paramParcel2.writeNoException();
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
        String str = getMediationAdapterClassName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
      boolean bool = isLoading();
      paramParcel2.writeNoException();
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        paramParcel2.writeInt(i);
        return true;
      }
    }
    
    private static class zza
      implements zzp
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
      
      public String getMediationAdapterClassName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
          this.zzoo.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isLoading()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
          this.zzoo.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void zzf(AdRequestParcel paramAdRequestParcel)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 66	com/google/android/gms/ads/internal/client/AdRequestParcel:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/ads/internal/client/zzp$zza$zza:zzoo	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 39 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 42	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 48	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 48	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 60	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_3
        //   67: invokevirtual 48	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 48	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	zza
        //   0	77	1	paramAdRequestParcel	AdRequestParcel
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */