package com.google.ads.mediation;

@Deprecated
public abstract interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters>
{
  public abstract void destroy();
  
  public abstract Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();
  
  public abstract Class<SERVER_PARAMETERS> getServerParametersType();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\ads\mediation\MediationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */