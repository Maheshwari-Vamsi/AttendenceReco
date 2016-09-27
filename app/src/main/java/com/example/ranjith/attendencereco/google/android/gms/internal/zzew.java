package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzew
  extends IInterface
{
  public abstract zzex zzaf(String paramString)
    throws RemoteException;
  
  public abstract boolean zzag(String paramString)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzew
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }
    
    public static zzew zzE(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzew))) {
        return (zzew)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        zzex localzzex = zzaf(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localzzex != null) {}
        for (IBinder localIBinder = localzzex.asBinder();; localIBinder = null)
        {
          paramParcel2.writeStrongBinder(localIBinder);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      boolean bool = zzag(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        paramParcel2.writeInt(i);
        return true;
      }
    }
    
    private static class zza
      implements zzew
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
      
      public zzex zzaf(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          this.zzoo.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzex localzzex = zzex.zza.zzF(localParcel2.readStrongBinder());
          return localzzex;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean zzag(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          this.zzoo.transact(2, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */