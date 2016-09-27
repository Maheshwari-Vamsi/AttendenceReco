package com.purplebrain.adbuddiz.sdk;

public enum AdBuddizRewardedVideoError
{
  private String name;
  
  static
  {
    ACTIVITY_PARAMETER_IS_NULL = new AdBuddizRewardedVideoError("ACTIVITY_PARAMETER_IS_NULL", 1, "ACTIVITY_PARAMETER_IS_NULL");
    MISSING_INTERNET_PERMISSION_IN_MANIFEST = new AdBuddizRewardedVideoError("MISSING_INTERNET_PERMISSION_IN_MANIFEST", 2, "MISSING_INTERNET_PERMISSION_IN_MANIFEST");
    MISSING_PUBLISHER_KEY = new AdBuddizRewardedVideoError("MISSING_PUBLISHER_KEY", 3, "MISSING_PUBLISHER_KEY");
    MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST = new AdBuddizRewardedVideoError("MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST", 4, "MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST");
    CONFIG_NOT_READY = new AdBuddizRewardedVideoError("CONFIG_NOT_READY", 5, "CONFIG_NOT_READY");
    CONFIG_EXPIRED = new AdBuddizRewardedVideoError("CONFIG_EXPIRED", 6, "CONFIG_EXPIRED");
    INVALID_PUBLISHER_KEY = new AdBuddizRewardedVideoError("INVALID_PUBLISHER_KEY", 7, "INVALID_PUBLISHER_KEY");
    PLATFORM_MISMATCH_PUBLISHER_KEY = new AdBuddizRewardedVideoError("PLATFORM_MISMATCH_PUBLISHER_KEY", 8, "PLATFORM_MISMATCH_PUBLISHER_KEY");
    NO_NETWORK_AVAILABLE = new AdBuddizRewardedVideoError("NO_NETWORK_AVAILABLE", 9, "NO_NETWORK_AVAILABLE");
    FORBIDDEN_RECEIVED_FROM_NETWORK = new AdBuddizRewardedVideoError("FORBIDDEN_RECEIVED_FROM_NETWORK", 10, "FORBIDDEN_RECEIVED_FROM_NETWORK");
    NETWORK_TOO_SLOW = new AdBuddizRewardedVideoError("NETWORK_TOO_SLOW", 11, "NETWORK_TOO_SLOW");
    UNSUPPORTED_DEVICE = new AdBuddizRewardedVideoError("UNSUPPORTED_DEVICE", 12, "UNSUPPORTED_DEVICE");
    UNSUPPORTED_OS_VERSION = new AdBuddizRewardedVideoError("UNSUPPORTED_OS_VERSION", 13, "UNSUPPORTED_OS_VERSION");
    FETCH_VIDEO_AD_NOT_CALLED = new AdBuddizRewardedVideoError("FETCH_VIDEO_AD_NOT_CALLED", 14, "FETCH_VIDEO_AD_NOT_CALLED");
    VIDEO_AD_EXPIRED = new AdBuddizRewardedVideoError("VIDEO_AD_EXPIRED", 15, "VIDEO_AD_EXPIRED");
    FETCHING_AD = new AdBuddizRewardedVideoError("FETCHING_AD", 16, "FETCHING_AD");
    NO_MORE_AVAILABLE_ADS = new AdBuddizRewardedVideoError("NO_MORE_AVAILABLE_ADS", 17, "NO_MORE_AVAILABLE_ADS");
    SHOW_AD_CALLS_TOO_CLOSE = new AdBuddizRewardedVideoError("SHOW_AD_CALLS_TOO_CLOSE", 18, "SHOW_AD_CALLS_TOO_CLOSE");
    AD_IS_ALREADY_ON_SCREEN = new AdBuddizRewardedVideoError("AD_IS_ALREADY_ON_SCREEN", 19, "AD_IS_ALREADY_ON_SCREEN");
    UNKNOWN_EXCEPTION_RAISED = new AdBuddizRewardedVideoError("UNKNOWN_EXCEPTION_RAISED", 20, "UNKNOWN_EXCEPTION_RAISED");
    AdBuddizRewardedVideoError[] arrayOfAdBuddizRewardedVideoError = new AdBuddizRewardedVideoError[21];
    arrayOfAdBuddizRewardedVideoError[0] = UNSUPPORTED_ANDROID_SDK;
    arrayOfAdBuddizRewardedVideoError[1] = ACTIVITY_PARAMETER_IS_NULL;
    arrayOfAdBuddizRewardedVideoError[2] = MISSING_INTERNET_PERMISSION_IN_MANIFEST;
    arrayOfAdBuddizRewardedVideoError[3] = MISSING_PUBLISHER_KEY;
    arrayOfAdBuddizRewardedVideoError[4] = MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST;
    arrayOfAdBuddizRewardedVideoError[5] = CONFIG_NOT_READY;
    arrayOfAdBuddizRewardedVideoError[6] = CONFIG_EXPIRED;
    arrayOfAdBuddizRewardedVideoError[7] = INVALID_PUBLISHER_KEY;
    arrayOfAdBuddizRewardedVideoError[8] = PLATFORM_MISMATCH_PUBLISHER_KEY;
    arrayOfAdBuddizRewardedVideoError[9] = NO_NETWORK_AVAILABLE;
    arrayOfAdBuddizRewardedVideoError[10] = FORBIDDEN_RECEIVED_FROM_NETWORK;
    arrayOfAdBuddizRewardedVideoError[11] = NETWORK_TOO_SLOW;
    arrayOfAdBuddizRewardedVideoError[12] = UNSUPPORTED_DEVICE;
    arrayOfAdBuddizRewardedVideoError[13] = UNSUPPORTED_OS_VERSION;
    arrayOfAdBuddizRewardedVideoError[14] = FETCH_VIDEO_AD_NOT_CALLED;
    arrayOfAdBuddizRewardedVideoError[15] = VIDEO_AD_EXPIRED;
    arrayOfAdBuddizRewardedVideoError[16] = FETCHING_AD;
    arrayOfAdBuddizRewardedVideoError[17] = NO_MORE_AVAILABLE_ADS;
    arrayOfAdBuddizRewardedVideoError[18] = SHOW_AD_CALLS_TOO_CLOSE;
    arrayOfAdBuddizRewardedVideoError[19] = AD_IS_ALREADY_ON_SCREEN;
    arrayOfAdBuddizRewardedVideoError[20] = UNKNOWN_EXCEPTION_RAISED;
    $VALUES = arrayOfAdBuddizRewardedVideoError;
  }
  
  private AdBuddizRewardedVideoError(String paramString1)
  {
    this.name = paramString1;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddizRewardedVideoError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */