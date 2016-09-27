package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzly;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzly<BatchResult>
{
  private int zzaes;
  private boolean zzaet;
  private boolean zzaeu;
  private final PendingResult<?>[] zzaev;
  private final Object zzpK = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.zzaes = paramList.size();
    this.zzaev = new PendingResult[this.zzaes];
    for (int i = 0; i < paramList.size(); i++)
    {
      PendingResult localPendingResult = (PendingResult)paramList.get(i);
      this.zzaev[i] = localPendingResult;
      localPendingResult.zza(new PendingResult.zza()
      {
        public void zzu(Status paramAnonymousStatus)
        {
          for (;;)
          {
            synchronized (Batch.zza(Batch.this))
            {
              if (Batch.this.isCanceled()) {
                return;
              }
              if (paramAnonymousStatus.isCanceled())
              {
                Batch.zza(Batch.this, true);
                Batch.zzb(Batch.this);
                if (Batch.zzc(Batch.this) == 0)
                {
                  if (!Batch.zzd(Batch.this)) {
                    break;
                  }
                  Batch.zze(Batch.this);
                }
                return;
              }
            }
            if (!paramAnonymousStatus.isSuccess()) {
              Batch.zzb(Batch.this, true);
            }
          }
          if (Batch.zzf(Batch.this)) {}
          for (Status localStatus = new Status(13);; localStatus = Status.zzaeX)
          {
            Batch.this.zzb(new BatchResult(localStatus, Batch.zzg(Batch.this)));
            break;
          }
        }
      });
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zzaev;
    int i = arrayOfPendingResult.length;
    for (int j = 0; j < i; j++) {
      arrayOfPendingResult[j].cancel();
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.zzaev);
  }
  
  public static final class Builder
  {
    private GoogleApiClient zzYC;
    private List<PendingResult<?>> zzaex = new ArrayList();
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.zzYC = paramGoogleApiClient;
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.zzaex.size());
      this.zzaex.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.zzaex, this.zzYC, null);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */