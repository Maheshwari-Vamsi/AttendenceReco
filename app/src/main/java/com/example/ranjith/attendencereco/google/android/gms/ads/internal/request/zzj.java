package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzj
  extends IInterface
{
  public abstract void zza(AdRequestInfoParcel paramAdRequestInfoParcel, zzk paramzzk)
    throws RemoteException;
  
  public abstract AdResponseParcel zzd(AdRequestInfoParcel paramAdRequestInfoParcel)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzj
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }
    
    public static zzj zzX(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if ((localIInterface != null) && ((localIInterface instanceof zzj))) {
        return (zzj)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        int j = paramParcel1.readInt();
        AdRequestInfoParcel localAdRequestInfoParcel2 = null;
        if (j != 0) {
          localAdRequestInfoParcel2 = AdRequestInfoParcel.CREATOR.zzi(paramParcel1);
        }
        AdResponseParcel localAdResponseParcel = zzd(localAdRequestInfoParcel2);
        paramParcel2.writeNoException();
        if (localAdResponseParcel != null)
        {
          paramParcel2.writeInt(1);
          localAdResponseParcel.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      int i = paramParcel1.readInt();
      AdRequestInfoParcel localAdRequestInfoParcel1 = null;
      if (i != 0) {
        localAdRequestInfoParcel1 = AdRequestInfoParcel.CREATOR.zzi(paramParcel1);
      }
      zza(localAdRequestInfoParcel1, zzk.zza.zzY(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzj
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
      
      public void zza(AdRequestInfoParcel paramAdRequestInfoParcel, zzk paramzzk)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramAdRequestInfoParcel != null)
            {
              localParcel1.writeInt(1);
              paramAdRequestInfoParcel.writeToParcel(localParcel1, 0);
              if (paramzzk != null)
              {
                localIBinder = paramzzk.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.zzoo.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public AdResponseParcel zzd(AdRequestInfoParcel paramAdRequestInfoParcel)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramAdRequestInfoParcel != null)
            {
              localParcel1.writeInt(1);
              paramAdRequestInfoParcel.writeToParcel(localParcel1, 0);
              this.zzoo.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                AdResponseParcel localAdResponseParcel2 = AdResponseParcel.CREATOR.zzj(localParcel2);
                localAdResponseParcel1 = localAdResponseParcel2;
                return localAdResponseParcel1;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            AdResponseParcel localAdResponseParcel1 = null;
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
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */