package com.purplebrain.adbuddiz.sdk;

public enum AdBuddizError
{
  private String name;
  
  static
  {
    ACTIVITY_PARAMETER_IS_NULL = new AdBuddizError("ACTIVITY_PARAMETER_IS_NULL", 1, "ACTIVITY_PARAMETER_IS_NULL");
    MISSING_INTERNET_PERMISSION_IN_MANIFEST = new AdBuddizError("MISSING_INTERNET_PERMISSION_IN_MANIFEST", 2, "MISSING_INTERNET_PERMISSION_IN_MANIFEST");
    MISSING_PUBLISHER_KEY = new AdBuddizError("MISSING_PUBLISHER_KEY", 3, "MISSING_PUBLISHER_KEY");
    MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST = new AdBuddizError("MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST", 4, "MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST");
    CONFIG_NOT_READY = new AdBuddizError("CONFIG_NOT_READY", 5, "CONFIG_NOT_READY");
    CONFIG_EXPIRED = new AdBuddizError("CONFIG_EXPIRED", 6, "CONFIG_EXPIRED");
    INVALID_PUBLISHER_KEY = new AdBuddizError("INVALID_PUBLISHER_KEY", 7, "INVALID_PUBLISHER_KEY");
    PLATFORM_MISMATCH_PUBLISHER_KEY = new AdBuddizError("PLATFORM_MISMATCH_PUBLISHER_KEY", 8, "PLATFORM_MISMATCH_PUBLISHER_KEY");
    PLACEMENT_BLOCKED = new AdBuddizError("PLACEMENT_BLOCKED", 9, "PLACEMENT_BLOCKED");
    NO_NETWORK_AVAILABLE = new AdBuddizError("NO_NETWORK_AVAILABLE", 10, "NO_NETWORK_AVAILABLE");
    FORBIDDEN_RECEIVED_FROM_NETWORK = new AdBuddizError("FORBIDDEN_RECEIVED_FROM_NETWORK", 11, "FORBIDDEN_RECEIVED_FROM_NETWORK");
    NO_MORE_AVAILABLE_CACHED_ADS = new AdBuddizError("NO_MORE_AVAILABLE_CACHED_ADS", 12, "NO_MORE_AVAILABLE_CACHED_ADS");
    NO_MORE_AVAILABLE_ADS = new AdBuddizError("NO_MORE_AVAILABLE_ADS", 13, "NO_MORE_AVAILABLE_ADS");
    INVALID_AD = new AdBuddizError("INVALID_AD", 14, "INVALID_AD");
    SHOW_AD_CALLS_TOO_CLOSE = new AdBuddizError("SHOW_AD_CALLS_TOO_CLOSE", 15, "SHOW_AD_CALLS_TOO_CLOSE");
    AD_IS_ALREADY_ON_SCREEN = new AdBuddizError("AD_IS_ALREADY_ON_SCREEN", 16, "AD_IS_ALREADY_ON_SCREEN");
    UNKNOWN_EXCEPTION_RAISED = new AdBuddizError("UNKNOWN_EXCEPTION_RAISED", 17, "UNKNOWN_EXCEPTION_RAISED");
    AdBuddizError[] arrayOfAdBuddizError = new AdBuddizError[18];
    arrayOfAdBuddizError[0] = UNSUPPORTED_ANDROID_SDK;
    arrayOfAdBuddizError[1] = ACTIVITY_PARAMETER_IS_NULL;
    arrayOfAdBuddizError[2] = MISSING_INTERNET_PERMISSION_IN_MANIFEST;
    arrayOfAdBuddizError[3] = MISSING_PUBLISHER_KEY;
    arrayOfAdBuddizError[4] = MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST;
    arrayOfAdBuddizError[5] = CONFIG_NOT_READY;
    arrayOfAdBuddizError[6] = CONFIG_EXPIRED;
    arrayOfAdBuddizError[7] = INVALID_PUBLISHER_KEY;
    arrayOfAdBuddizError[8] = PLATFORM_MISMATCH_PUBLISHER_KEY;
    arrayOfAdBuddizError[9] = PLACEMENT_BLOCKED;
    arrayOfAdBuddizError[10] = NO_NETWORK_AVAILABLE;
    arrayOfAdBuddizError[11] = FORBIDDEN_RECEIVED_FROM_NETWORK;
    arrayOfAdBuddizError[12] = NO_MORE_AVAILABLE_CACHED_ADS;
    arrayOfAdBuddizError[13] = NO_MORE_AVAILABLE_ADS;
    arrayOfAdBuddizError[14] = INVALID_AD;
    arrayOfAdBuddizError[15] = SHOW_AD_CALLS_TOO_CLOSE;
    arrayOfAdBuddizError[16] = AD_IS_ALREADY_ON_SCREEN;
    arrayOfAdBuddizError[17] = UNKNOWN_EXCEPTION_RAISED;
    $VALUES = arrayOfAdBuddizError;
  }
  
  private AdBuddizError(String paramString1)
  {
    this.name = paramString1;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddizError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */