package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzj.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzi
  extends zzj<zzf>
  implements zzsc
{
  private final com.google.android.gms.common.internal.zzf zzafT;
  private Integer zzajt;
  private final Bundle zzbbG;
  private final boolean zzbbX;
  
  public zzi(Context paramContext, Looper paramLooper, boolean paramBoolean, com.google.android.gms.common.internal.zzf paramzzf, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzbbX = paramBoolean;
    this.zzafT = paramzzf;
    this.zzbbG = paramBundle;
    this.zzajt = paramzzf.zzqh();
  }
  
  public zzi(Context paramContext, Looper paramLooper, boolean paramBoolean, com.google.android.gms.common.internal.zzf paramzzf, zzsd paramzzsd, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ExecutorService paramExecutorService)
  {
    this(paramContext, paramLooper, paramBoolean, paramzzf, zza(paramzzsd, paramzzf.zzqh(), paramExecutorService), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public static Bundle zza(zzsd paramzzsd, Integer paramInteger, ExecutorService paramExecutorService)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", paramzzsd.zzDM());
    localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", paramzzsd.zzmy());
    localBundle.putString("com.google.android.gms.signin.internal.serverClientId", paramzzsd.zzmB());
    if (paramzzsd.zzDN() != null) {
      localBundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(paramzzsd, paramExecutorService).asBinder()));
    }
    if (paramInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", paramInteger.intValue());
    }
    localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", paramzzsd.zzDO());
    localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", paramzzsd.zzmA());
    localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", paramzzsd.zzDP());
    return localBundle;
  }
  
  public void connect()
  {
    zza(new zzj.zzf(this));
  }
  
  public void zzDL()
  {
    try
    {
      ((zzf)zzqs()).zzjL(this.zzajt.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  public void zza(zzp paramzzp, Set<Scope> paramSet, zze paramzze)
  {
    zzx.zzb(paramzze, "Expecting a valid ISignInCallbacks");
    try
    {
      ((zzf)zzqs()).zza(new AuthAccountRequest(paramzzp, paramSet), paramzze);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
      try
      {
        paramzze.zza(new ConnectionResult(8, null), new AuthAccountResult(8, null));
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", localRemoteException1);
      }
    }
  }
  
  public void zza(zzp paramzzp, boolean paramBoolean)
  {
    try
    {
      ((zzf)zzqs()).zza(paramzzp, this.zzajt.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public void zza(zzt paramzzt)
  {
    zzx.zzb(paramzzt, "Expecting a valid IResolveAccountCallbacks");
    try
    {
      Account localAccount = this.zzafT.zzpY();
      boolean bool = "<<default account>>".equals(localAccount.name);
      GoogleSignInAccount localGoogleSignInAccount = null;
      if (bool) {
        localGoogleSignInAccount = zzn.zzae(getContext()).zzmW();
      }
      ResolveAccountRequest localResolveAccountRequest = new ResolveAccountRequest(localAccount, this.zzajt.intValue(), localGoogleSignInAccount);
      ((zzf)zzqs()).zza(localResolveAccountRequest, paramzzt);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
      try
      {
        paramzzt.zzb(new ResolveAccountResponse(8));
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", localRemoteException1);
      }
    }
  }
  
  protected zzf zzdX(IBinder paramIBinder)
  {
    return zzf.zza.zzdW(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected Bundle zzlU()
  {
    String str = this.zzafT.zzqd();
    if (!getContext().getPackageName().equals(str)) {
      this.zzbbG.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzafT.zzqd());
    }
    return this.zzbbG;
  }
  
  public boolean zzmn()
  {
    return this.zzbbX;
  }
  
  private static class zza
    extends zzd.zza
  {
    private final zzsd zzaeP;
    private final ExecutorService zzbbY;
    
    public zza(zzsd paramzzsd, ExecutorService paramExecutorService)
    {
      this.zzaeP = paramzzsd;
      this.zzbbY = paramExecutorService;
    }
    
    private GoogleApiClient.ServerAuthCodeCallbacks zzDN()
      throws RemoteException
    {
      return this.zzaeP.zzDN();
    }
    
    public void zza(final String paramString1, final String paramString2, final zzf paramzzf)
      throws RemoteException
    {
      this.zzbbY.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            boolean bool = zzi.zza.zza(zzi.zza.this).onUploadServerAuthCode(paramString1, paramString2);
            paramzzf.zzat(bool);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", localRemoteException);
          }
        }
      });
    }
    
    public void zza(final String paramString, final List<Scope> paramList, final zzf paramzzf)
      throws RemoteException
    {
      this.zzbbY.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            GoogleApiClient.ServerAuthCodeCallbacks localServerAuthCodeCallbacks = zzi.zza.zza(zzi.zza.this);
            Set localSet = Collections.unmodifiableSet(new HashSet(paramList));
            GoogleApiClient.ServerAuthCodeCallbacks.CheckResult localCheckResult = localServerAuthCodeCallbacks.onCheckServerAuthorization(paramString, localSet);
            CheckServerAuthResult localCheckServerAuthResult = new CheckServerAuthResult(localCheckResult.zzoJ(), localCheckResult.zzoK());
            paramzzf.zza(localCheckServerAuthResult);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", localRemoteException);
          }
        }
      });
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\signin\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */