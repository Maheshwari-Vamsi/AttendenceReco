package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<libfreenect.h>", "<libfreenect-registration.h>", "<libfreenect_sync.h>"}, includepath={"/usr/local/include/libfreenect/", "/usr/local/include/", "/opt/local/include/libfreenect/", "/opt/local/include/", "/usr/include/libfreenect/"}, link={"freenect@0.1", "freenect_sync@0.1"}, linkpath={"/opt/local/lib/", "/opt/local/lib64/", "/usr/local/lib/", "/usr/local/lib64/"}, value={"linux", "macosx"}), @com.googlecode.javacpp.annotation.Platform(include={"<WinSock2.h>", "<libfreenect.h>", "<libfreenect-registration.h>", "<libfreenect_sync.h>", "<libfreenect_sync.c>"}, includepath={"C:/libfreenect/include/", "C:/libfreenect/wrappers/c_sync/", "C:/pthreads-w32-2-8-0-release/", "C:/pthreads.2/", "C:/Pre-built.2/include/", "src/com/googlecode/javacv/cpp/"}, link={"freenect", "pthreadVC2"}, linkpath={"C:/libfreenect/lib/", "C:/pthreads-w32-2-8-0-release/", "C:/pthreads.2/", "C:/Pre-built.2/lib/"}, value={"windows"})})
public class freenect
{
  public static final int FREENECT_COUNTS_PER_G = 819;
  public static final int FREENECT_DEPTH_10BIT = 1;
  public static final int FREENECT_DEPTH_10BIT_PACKED = 3;
  public static final int FREENECT_DEPTH_11BIT = 0;
  public static final int FREENECT_DEPTH_11BIT_PACKED = 2;
  public static final int FREENECT_DEPTH_MM = 5;
  public static final int FREENECT_DEPTH_MM_MAX_VALUE = 10000;
  public static final int FREENECT_DEPTH_MM_NO_VALUE = 0;
  public static final int FREENECT_DEPTH_RAW_MAX_VALUE = 2048;
  public static final int FREENECT_DEPTH_RAW_NO_VALUE = 2047;
  public static final int FREENECT_DEPTH_REGISTERED = 4;
  public static final int FREENECT_DEVICE_AUDIO = 4;
  public static final int FREENECT_DEVICE_CAMERA = 2;
  public static final int FREENECT_LOG_DEBUG = 5;
  public static final int FREENECT_LOG_ERROR = 1;
  public static final int FREENECT_LOG_FATAL = 0;
  public static final int FREENECT_LOG_FLOOD = 7;
  public static final int FREENECT_LOG_INFO = 4;
  public static final int FREENECT_LOG_NOTICE = 3;
  public static final int FREENECT_LOG_SPEW = 6;
  public static final int FREENECT_LOG_WARNING = 2;
  public static final int FREENECT_RESOLUTION_HIGH = 2;
  public static final int FREENECT_RESOLUTION_LOW = 0;
  public static final int FREENECT_RESOLUTION_MEDIUM = 1;
  public static final int FREENECT_VIDEO_BAYER = 1;
  public static final int FREENECT_VIDEO_IR_10BIT = 3;
  public static final int FREENECT_VIDEO_IR_10BIT_PACKED = 4;
  public static final int FREENECT_VIDEO_IR_8BIT = 2;
  public static final int FREENECT_VIDEO_RGB = 0;
  public static final int FREENECT_VIDEO_YUV_RAW = 6;
  public static final int FREENECT_VIDEO_YUV_RGB = 5;
  public static final int LED_BLINK_GREEN = 4;
  public static final int LED_BLINK_RED_YELLOW = 6;
  public static final int LED_GREEN = 1;
  public static final int LED_OFF = 0;
  public static final int LED_RED = 2;
  public static final int LED_YELLOW = 3;
  public static final int TILT_STATUS_LIMIT = 1;
  public static final int TILT_STATUS_MOVING = 4;
  public static final int TILT_STATUS_STOPPED;
  
  static
  {
    Loader.load();
  }
  
  public static native void freenect_camera_to_world(freenect_device paramfreenect_device, int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public static native int freenect_close_device(freenect_device paramfreenect_device);
  
  @ByVal
  public static native freenect_registration freenect_copy_registration(freenect_device paramfreenect_device);
  
  public static native int freenect_destroy_registration(freenect_registration paramfreenect_registration);
  
  @ByVal
  public static native freenect_frame_mode freenect_find_depth_mode(@Cast({"freenect_resolution"}) int paramInt1, @Cast({"freenect_depth_format"}) int paramInt2);
  
  @ByVal
  public static native freenect_frame_mode freenect_find_video_mode(@Cast({"freenect_resolution"}) int paramInt1, @Cast({"freenect_video_format"}) int paramInt2);
  
  public static native void freenect_free_device_attributes(freenect_device_attributes paramfreenect_device_attributes);
  
  @ByVal
  public static native freenect_frame_mode freenect_get_current_depth_mode(freenect_device paramfreenect_device);
  
  @ByVal
  public static native freenect_frame_mode freenect_get_current_video_mode(freenect_device paramfreenect_device);
  
  @ByVal
  public static native freenect_frame_mode freenect_get_depth_mode(int paramInt);
  
  public static native int freenect_get_depth_mode_count();
  
  public static native void freenect_get_mks_accel(freenect_raw_tilt_state paramfreenect_raw_tilt_state, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
  
  public static native double freenect_get_tilt_degs(freenect_raw_tilt_state paramfreenect_raw_tilt_state);
  
  public static native freenect_raw_tilt_state freenect_get_tilt_state(freenect_device paramfreenect_device);
  
  @Cast({"freenect_tilt_status_code"})
  public static native int freenect_get_tilt_status(freenect_raw_tilt_state paramfreenect_raw_tilt_state);
  
  public static native Pointer freenect_get_user(freenect_device paramfreenect_device);
  
  @ByVal
  public static native freenect_frame_mode freenect_get_video_mode(int paramInt);
  
  public static native int freenect_get_video_mode_count();
  
  public static native int freenect_init(@ByPtrPtr freenect_context paramfreenect_context, freenect_usb_context paramfreenect_usb_context);
  
  public static native int freenect_list_device_attributes(freenect_context paramfreenect_context, @ByPtrPtr freenect_device_attributes paramfreenect_device_attributes);
  
  public static native int freenect_num_devices(freenect_context paramfreenect_context);
  
  public static native int freenect_open_device(freenect_context paramfreenect_context, @ByPtrPtr freenect_device paramfreenect_device, int paramInt);
  
  public static native int freenect_open_device_by_camera_serial(freenect_context paramfreenect_context, @ByPtrPtr freenect_device paramfreenect_device, @Cast({"char*"}) BytePointer paramBytePointer);
  
  public static native int freenect_open_device_by_camera_serial(freenect_context paramfreenect_context, @ByPtrPtr freenect_device paramfreenect_device, String paramString);
  
  public static native int freenect_process_events(freenect_context paramfreenect_context);
  
  public static native int freenect_process_events_timeout(freenect_context paramfreenect_context, timeval paramtimeval);
  
  public static native void freenect_select_subdevices(freenect_context paramfreenect_context, @Cast({"freenect_device_flags"}) int paramInt);
  
  public static native int freenect_set_depth_buffer(freenect_device paramfreenect_device, Pointer paramPointer);
  
  public static native void freenect_set_depth_callback(freenect_device paramfreenect_device, freenect_depth_cb paramfreenect_depth_cb);
  
  public static native int freenect_set_depth_mode(freenect_device paramfreenect_device, @ByVal freenect_frame_mode paramfreenect_frame_mode);
  
  public static native int freenect_set_led(freenect_device paramfreenect_device, @Cast({"freenect_led_options"}) int paramInt);
  
  public static native void freenect_set_log_callback(freenect_context paramfreenect_context, freenect_log_cb paramfreenect_log_cb);
  
  public static native void freenect_set_log_level(freenect_context paramfreenect_context, @Cast({"freenect_loglevel"}) int paramInt);
  
  public static native int freenect_set_tilt_degs(freenect_device paramfreenect_device, double paramDouble);
  
  public static native void freenect_set_user(freenect_device paramfreenect_device, Pointer paramPointer);
  
  public static native int freenect_set_video_buffer(freenect_device paramfreenect_device, Pointer paramPointer);
  
  public static native void freenect_set_video_callback(freenect_device paramfreenect_device, freenect_video_cb paramfreenect_video_cb);
  
  public static native int freenect_set_video_mode(freenect_device paramfreenect_device, @ByVal freenect_frame_mode paramfreenect_frame_mode);
  
  public static native int freenect_shutdown(freenect_context paramfreenect_context);
  
  public static native int freenect_start_depth(freenect_device paramfreenect_device);
  
  public static native int freenect_start_video(freenect_device paramfreenect_device);
  
  public static native int freenect_stop_depth(freenect_device paramfreenect_device);
  
  public static native int freenect_stop_video(freenect_device paramfreenect_device);
  
  public static native int freenect_supported_subdevices();
  
  public static native int freenect_sync_get_depth(@ByPtrPtr @Cast({"void**"}) Pointer paramPointer, @Cast({"uint32_t*"}) int[] paramArrayOfInt, int paramInt1, @Cast({"freenect_depth_format"}) int paramInt2);
  
  public static native int freenect_sync_get_tilt_state(@ByPtrPtr freenect_raw_tilt_state paramfreenect_raw_tilt_state, int paramInt);
  
  public static native int freenect_sync_get_video(@ByPtrPtr @Cast({"void**"}) Pointer paramPointer, @Cast({"uint32_t*"}) int[] paramArrayOfInt, int paramInt1, @Cast({"freenect_video_format"}) int paramInt2);
  
  public static native int freenect_sync_set_led(@Cast({"freenect_led_options"}) int paramInt1, int paramInt2);
  
  public static native int freenect_sync_set_tilt_degs(int paramInt1, int paramInt2);
  
  public static native void freenect_sync_stop();
  
  public static native int freenect_update_tilt_state(freenect_device paramfreenect_device);
  
  @Opaque
  public static class freenect_context
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_context() {}
    
    public freenect_context(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class freenect_depth_cb
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected freenect_depth_cb()
    {
      allocate();
    }
    
    public freenect_depth_cb(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(freenect_device paramfreenect_device, Pointer paramPointer, @Cast({"uint32_t"}) int paramInt);
  }
  
  @Opaque
  public static class freenect_device
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_device() {}
    
    public freenect_device(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class freenect_device_attributes
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_device_attributes()
    {
      allocate();
    }
    
    public freenect_device_attributes(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_device_attributes(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer camera_serial();
    
    public native freenect_device_attributes camera_serial(BytePointer paramBytePointer);
    
    public native freenect_device_attributes next();
    
    public native freenect_device_attributes next(freenect_device_attributes paramfreenect_device_attributes);
  }
  
  public static class freenect_frame_mode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_frame_mode()
    {
      allocate();
    }
    
    public freenect_frame_mode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_frame_mode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int bytes();
    
    public native freenect_frame_mode bytes(int paramInt);
    
    public native byte data_bits_per_pixel();
    
    public native freenect_frame_mode data_bits_per_pixel(byte paramByte);
    
    @Cast({"freenect_depth_format"})
    public native int depth_format();
    
    public native freenect_frame_mode depth_format(int paramInt);
    
    public native byte framerate();
    
    public native freenect_frame_mode framerate(byte paramByte);
    
    public native freenect_frame_mode height(short paramShort);
    
    public native short height();
    
    public native byte is_valid();
    
    public native freenect_frame_mode is_valid(byte paramByte);
    
    public native byte padding_bits_per_pixel();
    
    public native freenect_frame_mode padding_bits_per_pixel(byte paramByte);
    
    public native int reserved();
    
    public native freenect_frame_mode reserved(int paramInt);
    
    @Cast({"freenect_resolution"})
    public native int resolution();
    
    public native freenect_frame_mode resolution(int paramInt);
    
    @Cast({"freenect_video_format"})
    public native int video_format();
    
    public native freenect_frame_mode video_format(int paramInt);
    
    public native freenect_frame_mode width(short paramShort);
    
    public native short width();
  }
  
  public static class freenect_log_cb
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected freenect_log_cb()
    {
      allocate();
    }
    
    public freenect_log_cb(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(freenect_context paramfreenect_context, @Cast({"freenect_loglevel"}) int paramInt, String paramString);
  }
  
  public static class freenect_raw_tilt_state
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_raw_tilt_state()
    {
      allocate();
    }
    
    public freenect_raw_tilt_state(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_raw_tilt_state(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native freenect_raw_tilt_state accelerometer_x(short paramShort);
    
    public native short accelerometer_x();
    
    public native freenect_raw_tilt_state accelerometer_y(short paramShort);
    
    public native short accelerometer_y();
    
    public native freenect_raw_tilt_state accelerometer_z(short paramShort);
    
    public native short accelerometer_z();
    
    public native byte tilt_angle();
    
    public native freenect_raw_tilt_state tilt_angle(byte paramByte);
    
    @Cast({"freenect_tilt_status_code"})
    public native int tilt_status();
    
    public native freenect_raw_tilt_state tilt_status(int paramInt);
  }
  
  public static class freenect_reg_info
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_reg_info()
    {
      allocate();
    }
    
    public freenect_reg_info(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_reg_info(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int ax();
    
    public native freenect_reg_info ax(int paramInt);
    
    public native int ay();
    
    public native freenect_reg_info ay(int paramInt);
    
    public native int back_comp1();
    
    public native freenect_reg_info back_comp1(int paramInt);
    
    public native int back_comp2();
    
    public native freenect_reg_info back_comp2(int paramInt);
    
    public native int bx();
    
    public native freenect_reg_info bx(int paramInt);
    
    public native int by();
    
    public native freenect_reg_info by(int paramInt);
    
    public native int cx();
    
    public native freenect_reg_info cx(int paramInt);
    
    public native int cy();
    
    public native freenect_reg_info cy(int paramInt);
    
    public native int dx();
    
    public native freenect_reg_info dx(int paramInt);
    
    public native int dx_beta_inc();
    
    public native freenect_reg_info dx_beta_inc(int paramInt);
    
    public native int dx_beta_start();
    
    public native freenect_reg_info dx_beta_start(int paramInt);
    
    public native int dx_center();
    
    public native freenect_reg_info dx_center(int paramInt);
    
    public native int dx_start();
    
    public native freenect_reg_info dx_start(int paramInt);
    
    public native int dxdx_start();
    
    public native freenect_reg_info dxdx_start(int paramInt);
    
    public native int dxdxdx_start();
    
    public native freenect_reg_info dxdxdx_start(int paramInt);
    
    public native int dxdxdy_start();
    
    public native freenect_reg_info dxdxdy_start(int paramInt);
    
    public native int dxdy_start();
    
    public native freenect_reg_info dxdy_start(int paramInt);
    
    public native int dy();
    
    public native freenect_reg_info dy(int paramInt);
    
    public native int dy_beta_inc();
    
    public native freenect_reg_info dy_beta_inc(int paramInt);
    
    public native int dy_beta_start();
    
    public native freenect_reg_info dy_beta_start(int paramInt);
    
    public native int dy_start();
    
    public native freenect_reg_info dy_start(int paramInt);
    
    public native int dydx_start();
    
    public native freenect_reg_info dydx_start(int paramInt);
    
    public native int dydxdx_start();
    
    public native freenect_reg_info dydxdx_start(int paramInt);
    
    public native int dydxdy_start();
    
    public native freenect_reg_info dydxdy_start(int paramInt);
    
    public native int dydy_start();
    
    public native freenect_reg_info dydy_start(int paramInt);
    
    public native int dydydx_start();
    
    public native freenect_reg_info dydydx_start(int paramInt);
    
    public native int dydydy_start();
    
    public native freenect_reg_info dydydy_start(int paramInt);
    
    public native int rollout_blank();
    
    public native freenect_reg_info rollout_blank(int paramInt);
    
    public native int rollout_size();
    
    public native freenect_reg_info rollout_size(int paramInt);
  }
  
  public static class freenect_reg_pad_info
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_reg_pad_info()
    {
      allocate();
    }
    
    public freenect_reg_pad_info(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_reg_pad_info(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native freenect_reg_pad_info cropping_lines(short paramShort);
    
    public native short cropping_lines();
    
    public native freenect_reg_pad_info end_lines(short paramShort);
    
    public native short end_lines();
    
    public native freenect_reg_pad_info start_lines(short paramShort);
    
    public native short start_lines();
  }
  
  public static class freenect_registration
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_registration()
    {
      allocate();
    }
    
    public freenect_registration(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_registration(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double const_shift();
    
    public native freenect_registration const_shift(double paramDouble);
    
    public native IntPointer depth_to_rgb_shift();
    
    public native freenect_registration depth_to_rgb_shift(IntPointer paramIntPointer);
    
    @Cast({"uint16_t*"})
    public native ShortPointer raw_to_mm_shift();
    
    public native freenect_registration raw_to_mm_shift(ShortPointer paramShortPointer);
    
    @ByVal
    public native freenect.freenect_reg_info reg_info();
    
    public native freenect_registration reg_info(freenect_reg_info paramfreenect_reg_info);
    
    @ByVal
    public native freenect.freenect_reg_pad_info reg_pad_info();
    
    public native freenect_registration reg_pad_info(freenect_reg_pad_info paramfreenect_reg_pad_info);
    
    @Cast({"int32_t(*)[2]"})
    public native IntPointer registration_table();
    
    public native freenect_registration registration_table(IntPointer paramIntPointer);
    
    public native freenect_registration zero_plane_info(freenect_zero_plane_info paramfreenect_zero_plane_info);
    
    @ByVal
    public native freenect.freenect_zero_plane_info zero_plane_info();
  }
  
  @Opaque
  public static class freenect_usb_context
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_usb_context() {}
    
    public freenect_usb_context(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class freenect_video_cb
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected freenect_video_cb()
    {
      allocate();
    }
    
    public freenect_video_cb(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(freenect_device paramfreenect_device, Pointer paramPointer, @Cast({"uint32_t"}) int paramInt);
  }
  
  public static class freenect_zero_plane_info
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public freenect_zero_plane_info()
    {
      allocate();
    }
    
    public freenect_zero_plane_info(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public freenect_zero_plane_info(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float dcmos_emitter_dist();
    
    public native freenect_zero_plane_info dcmos_emitter_dist(float paramFloat);
    
    public native float dcmos_rcmos_dist();
    
    public native freenect_zero_plane_info dcmos_rcmos_dist(float paramFloat);
    
    public native float reference_distance();
    
    public native freenect_zero_plane_info reference_distance(float paramFloat);
    
    public native float reference_pixel_size();
    
    public native freenect_zero_plane_info reference_pixel_size(float paramFloat);
  }
  
  public static class timeval
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public timeval()
    {
      allocate();
    }
    
    public timeval(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public timeval(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native long tv_sec();
    
    public native timeval tv_sec(long paramLong);
    
    public native long tv_usec();
    
    public native timeval tv_usec(long paramLong);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\freenect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */