package com.example.ranjith.attendencereco.googlecode.javacpp;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;

@Name({"size_t"})
public class SizeTPointer
  extends Pointer
{
  public SizeTPointer(int paramInt)
  {
    try
    {
      allocateArray(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", localUnsatisfiedLinkError);
    }
  }
  
  public SizeTPointer(Pointer paramPointer)
  {
    super(paramPointer);
  }
  
  private native void allocateArray(int paramInt);
  
  public SizeTPointer capacity(int paramInt)
  {
    return (SizeTPointer)super.capacity(paramInt);
  }
  
  public long get()
  {
    return get(0);
  }
  
  @Cast({"size_t"})
  public native long get(int paramInt);
  
  public SizeTPointer limit(int paramInt)
  {
    return (SizeTPointer)super.limit(paramInt);
  }
  
  public SizeTPointer position(int paramInt)
  {
    return (SizeTPointer)super.position(paramInt);
  }
  
  public native SizeTPointer put(int paramInt, long paramLong);
  
  public SizeTPointer put(long paramLong)
  {
    return put(0, paramLong);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\SizeTPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */