package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzsd.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<GoogleApiClient> zzaez = Collections.newSetFromMap(new WeakHashMap());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (zzaez)
    {
      String str = paramString + "  ";
      Iterator localIterator = zzaez.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        PrintWriter localPrintWriter = paramPrintWriter.append(paramString).append("GoogleApiClient#");
        j = i + 1;
        localPrintWriter.println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      return;
    }
  }
  
  public static Set<GoogleApiClient> zzoE()
  {
    return zzaez;
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public <C extends Api.zzb> C zza(Api.zzc<C> paramzzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(zzmp paramzzmp)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzoF()
  {
    throw new UnsupportedOperationException();
  }
  
  public <L> zzmn<L> zzq(L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder
  {
    private final Context mContext;
    private Account zzSo;
    private String zzTz;
    private final Set<Scope> zzaeA = new HashSet();
    private final Set<Scope> zzaeB = new HashSet();
    private int zzaeC;
    private View zzaeD;
    private String zzaeE;
    private final Map<Api<?>, zzf.zza> zzaeF = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> zzaeG = new ArrayMap();
    private FragmentActivity zzaeH;
    private int zzaeI = -1;
    private GoogleApiClient.OnConnectionFailedListener zzaeJ;
    private Looper zzaeK;
    private GoogleApiAvailability zzaeL = GoogleApiAvailability.getInstance();
    private Api.zza<? extends zzsc, zzsd> zzaeM = zzsa.zzTp;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaeN = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaeO = new ArrayList();
    private zzsd zzaeP;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.zzaeK = paramContext.getMainLooper();
      this.zzTz = paramContext.getPackageName();
      this.zzaeE = paramContext.getClass().getName();
    }
    
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      zzx.zzb(paramConnectionCallbacks, "Must provide a connected listener");
      this.zzaeN.add(paramConnectionCallbacks);
      zzx.zzb(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.zzaeO.add(paramOnConnectionFailedListener);
    }
    
    private static <C extends Api.zzb, O> C zza(Api.zza<C, O> paramzza, Object paramObject, Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return paramzza.zza(paramContext, paramLooper, paramzzf, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
    
    private static <C extends Api.zzd, O> zzad zza(Api.zze<C, O> paramzze, Object paramObject, Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzad(paramContext, paramLooper, paramzze.zzoD(), paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf, paramzze.zzp(paramObject));
    }
    
    private <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, int paramInt, Scope... paramVarArgs)
    {
      int i = 1;
      int j = 0;
      if (paramInt == i) {}
      HashSet localHashSet;
      for (;;)
      {
        localHashSet = new HashSet(paramApi.zzoy().zzn(paramO));
        int k = paramVarArgs.length;
        while (j < k)
        {
          localHashSet.add(paramVarArgs[j]);
          j++;
        }
        if (paramInt != 2) {
          break;
        }
        i = 0;
      }
      throw new IllegalArgumentException("Invalid resolution mode: '" + paramInt + "', use a constant from GoogleApiClient.ResolutionMode");
      this.zzaeF.put(paramApi, new zzf.zza(localHashSet, i));
    }
    
    private void zza(zzmr paramzzmr, GoogleApiClient paramGoogleApiClient)
    {
      paramzzmr.zza(this.zzaeI, paramGoogleApiClient, this.zzaeJ);
    }
    
    private void zzd(final GoogleApiClient paramGoogleApiClient)
    {
      zzmr localzzmr = zzmr.zza(this.zzaeH);
      if (localzzmr == null)
      {
        new Handler(this.mContext.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            if ((GoogleApiClient.Builder.zza(GoogleApiClient.Builder.this).isFinishing()) || (GoogleApiClient.Builder.zza(GoogleApiClient.Builder.this).getSupportFragmentManager().isDestroyed())) {
              return;
            }
            GoogleApiClient.Builder.zza(GoogleApiClient.Builder.this, zzmr.zzb(GoogleApiClient.Builder.zza(GoogleApiClient.Builder.this)), paramGoogleApiClient);
          }
        });
        return;
      }
      zza(localzzmr, paramGoogleApiClient);
    }
    
    private GoogleApiClient zzoI()
    {
      zzf localzzf = zzoH();
      Object localObject1 = null;
      Map localMap = localzzf.zzqc();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zzaeG.keySet().iterator();
      Object localObject2 = null;
      Object localObject3;
      Object localObject4;
      int j;
      label131:
      zzlz localzzlz;
      Api.zze localzze;
      if (localIterator.hasNext())
      {
        localObject3 = (Api)localIterator.next();
        localObject4 = this.zzaeG.get(localObject3);
        Object localObject5 = localMap.get(localObject3);
        j = 0;
        if (localObject5 != null)
        {
          if (((zzf.zza)localMap.get(localObject3)).zzaju) {
            j = 1;
          }
        }
        else
        {
          localArrayMap1.put(localObject3, Integer.valueOf(j));
          localzzlz = new zzlz((Api)localObject3, j);
          localArrayList.add(localzzlz);
          if (!((Api)localObject3).zzoB()) {
            break label297;
          }
          localzze = ((Api)localObject3).zzoz();
          if (localzze.getPriority() != 1) {
            break label598;
          }
        }
      }
      label223:
      label297:
      label349:
      label579:
      label585:
      label591:
      label598:
      for (Object localObject9 = localObject3;; localObject9 = localObject2)
      {
        Object localObject7 = zza(localzze, localObject4, this.mContext, this.zzaeK, localzzf, localzzlz, localzzlz);
        Object localObject8 = localObject9;
        localArrayMap2.put(((Api)localObject3).zzoA(), localObject7);
        Api.zza localzza;
        if (((Api.zzb)localObject7).zzmJ())
        {
          if (localObject1 == null) {
            break label349;
          }
          throw new IllegalStateException(((Api)localObject3).getName() + " cannot be used with " + ((Api)localObject1).getName());
          j = 2;
          break label131;
          localzza = ((Api)localObject3).zzoy();
          if (localzza.getPriority() != 1) {
            break label591;
          }
        }
        for (Object localObject6 = localObject3;; localObject6 = localObject2)
        {
          localObject7 = zza(localzza, localObject4, this.mContext, this.zzaeK, localzzf, localzzlz, localzzlz);
          localObject8 = localObject6;
          break label223;
          localObject3 = localObject1;
          localObject2 = localObject8;
          localObject1 = localObject3;
          break;
          boolean bool1;
          if (localObject1 != null)
          {
            if (localObject2 != null) {
              throw new IllegalStateException(((Api)localObject1).getName() + " cannot be used with " + ((Api)localObject2).getName());
            }
            if (this.zzSo != null) {
              break label579;
            }
            bool1 = true;
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = ((Api)localObject1).getName();
            zzx.zza(bool1, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", arrayOfObject1);
            boolean bool2 = this.zzaeA.equals(this.zzaeB);
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = ((Api)localObject1).getName();
            zzx.zza(bool2, "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", arrayOfObject2);
            if (this.zzaeP != null) {
              break label585;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = ((Api)localObject1).getName();
            zzx.zza(bool3, "Must not call requestServerAuthCode in GoogleApiClient.Builder when using %s. Call requestServerAuthCode in GoogleSignInOptions.Builder instead.", arrayOfObject3);
            int i = zzmg.zza(localArrayMap2.values(), true);
            return new zzmg(this.mContext, new ReentrantLock(), this.zzaeK, localzzf, this.zzaeL, this.zzaeM, localArrayMap1, this.zzaeN, this.zzaeO, localArrayMap2, this.zzaeI, i, localArrayList);
            bool1 = false;
            break;
          }
        }
      }
    }
    
    public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      zzx.zzb(paramApi, "Api must not be null");
      this.zzaeG.put(paramApi, null);
      List localList = paramApi.zzoy().zzn(null);
      this.zzaeB.addAll(localList);
      this.zzaeA.addAll(localList);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      zzx.zzb(paramApi, "Api must not be null");
      zzx.zzb(paramO, "Null options are not permitted for this Api");
      this.zzaeG.put(paramApi, paramO);
      List localList = paramApi.zzoy().zzn(paramO);
      this.zzaeB.addAll(localList);
      this.zzaeA.addAll(localList);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      zzx.zzb(paramApi, "Api must not be null");
      zzx.zzb(paramO, "Null options are not permitted for this Api");
      this.zzaeG.put(paramApi, paramO);
      zza(paramApi, paramO, 1, paramVarArgs);
      return this;
    }
    
    public Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      zzx.zzb(paramApi, "Api must not be null");
      this.zzaeG.put(paramApi, null);
      zza(paramApi, null, 1, paramVarArgs);
      return this;
    }
    
    public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzx.zzb(paramConnectionCallbacks, "Listener must not be null");
      this.zzaeN.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzx.zzb(paramOnConnectionFailedListener, "Listener must not be null");
      this.zzaeO.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public Builder addScope(Scope paramScope)
    {
      zzx.zzb(paramScope, "Scope must not be null");
      this.zzaeA.add(paramScope);
      return this;
    }
    
    public GoogleApiClient build()
    {
      boolean bool;
      if (!this.zzaeG.isEmpty()) {
        bool = true;
      }
      for (;;)
      {
        zzx.zzb(bool, "must call addApi() to add at least one API");
        GoogleApiClient localGoogleApiClient = zzoI();
        synchronized (GoogleApiClient.zzoG())
        {
          GoogleApiClient.zzoG().add(localGoogleApiClient);
          if (this.zzaeI >= 0) {
            zzd(localGoogleApiClient);
          }
          return localGoogleApiClient;
          bool = false;
        }
      }
    }
    
    public Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "clientId must be non-negative");
        this.zzaeI = paramInt;
        this.zzaeH = ((FragmentActivity)zzx.zzb(paramFragmentActivity, "Null activity is not permitted."));
        this.zzaeJ = paramOnConnectionFailedListener;
        return this;
      }
    }
    
    public Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }
    
    @Deprecated
    public Builder requestServerAuthCode(String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks)
    {
      this.zzaeP = new zzsd.zza().zza(paramString, paramServerAuthCodeCallbacks).zzDQ();
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      if (paramString == null) {}
      for (Account localAccount = null;; localAccount = new Account(paramString, "com.google"))
      {
        this.zzSo = localAccount;
        return this;
      }
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      this.zzaeC = paramInt;
      return this;
    }
    
    public Builder setHandler(Handler paramHandler)
    {
      zzx.zzb(paramHandler, "Handler must not be null");
      this.zzaeK = paramHandler.getLooper();
      return this;
    }
    
    public Builder setViewForPopups(View paramView)
    {
      zzx.zzb(paramView, "View must not be null");
      this.zzaeD = paramView;
      return this;
    }
    
    public Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
    
    public zzf zzoH()
    {
      boolean bool;
      Account localAccount;
      Set localSet;
      Map localMap;
      int i;
      View localView;
      String str1;
      String str2;
      if (this.zzaeG.containsKey(zzsa.API))
      {
        if (this.zzaeP == null)
        {
          bool = true;
          zzx.zza(bool, "SignIn.API can't be used in conjunction with requestServerAuthCode.");
          this.zzaeP = ((zzsd)this.zzaeG.get(zzsa.API));
        }
      }
      else
      {
        localAccount = this.zzSo;
        localSet = this.zzaeA;
        localMap = this.zzaeF;
        i = this.zzaeC;
        localView = this.zzaeD;
        str1 = this.zzTz;
        str2 = this.zzaeE;
        if (this.zzaeP == null) {
          break label131;
        }
      }
      label131:
      for (zzsd localzzsd = this.zzaeP;; localzzsd = zzsd.zzbbH)
      {
        return new zzf(localAccount, localSet, localMap, i, localView, str1, str2, localzzsd);
        bool = false;
        break;
      }
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
  
  public static abstract interface ServerAuthCodeCallbacks
  {
    public abstract CheckResult onCheckServerAuthorization(String paramString, Set<Scope> paramSet);
    
    public abstract boolean onUploadServerAuthCode(String paramString1, String paramString2);
    
    public static class CheckResult
    {
      private Set<Scope> zzVH;
      private boolean zzaeR;
      
      private CheckResult(boolean paramBoolean, Set<Scope> paramSet)
      {
        this.zzaeR = paramBoolean;
        this.zzVH = paramSet;
      }
      
      public static CheckResult newAuthNotRequiredResult()
      {
        return new CheckResult(false, null);
      }
      
      public static CheckResult newAuthRequiredResult(Set<Scope> paramSet)
      {
        if ((paramSet != null) && (!paramSet.isEmpty())) {}
        for (boolean bool = true;; bool = false)
        {
          zzx.zzb(bool, "A non-empty scope set is required if further auth is needed.");
          return new CheckResult(true, paramSet);
        }
      }
      
      public boolean zzoJ()
      {
        return this.zzaeR;
      }
      
      public Set<Scope> zzoK()
      {
        return this.zzVH;
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(ConnectionResult paramConnectionResult);
    
    public abstract void zzb(ConnectionResult paramConnectionResult);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */