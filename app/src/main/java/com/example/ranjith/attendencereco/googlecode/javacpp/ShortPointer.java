package com.example.ranjith.attendencereco.googlecode.javacpp;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class ShortPointer
  extends Pointer
{
  public ShortPointer(int paramInt)
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
  
  public ShortPointer(Pointer paramPointer)
  {
    super(paramPointer);
  }
  
  public ShortPointer(ShortBuffer paramShortBuffer)
  {
    super(paramShortBuffer);
    if ((paramShortBuffer != null) && (paramShortBuffer.hasArray()))
    {
      short[] arrayOfShort = paramShortBuffer.array();
      allocateArray(arrayOfShort.length);
      put(arrayOfShort);
      position(paramShortBuffer.position());
      limit(paramShortBuffer.limit());
    }
  }
  
  public ShortPointer(short... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  private native void allocateArray(int paramInt);
  
  public final ShortBuffer asBuffer()
  {
    return asByteBuffer().asShortBuffer();
  }
  
  public ShortPointer capacity(int paramInt)
  {
    return (ShortPointer)super.capacity(paramInt);
  }
  
  public ShortPointer get(short[] paramArrayOfShort)
  {
    return get(paramArrayOfShort, 0, paramArrayOfShort.length);
  }
  
  public native ShortPointer get(short[] paramArrayOfShort, int paramInt1, int paramInt2);
  
  public short get()
  {
    return get(0);
  }
  
  public native short get(int paramInt);
  
  public ShortPointer limit(int paramInt)
  {
    return (ShortPointer)super.limit(paramInt);
  }
  
  public ShortPointer position(int paramInt)
  {
    return (ShortPointer)super.position(paramInt);
  }
  
  public native ShortPointer put(int paramInt, short paramShort);
  
  public ShortPointer put(short paramShort)
  {
    return put(0, paramShort);
  }
  
  public ShortPointer put(short[] paramArrayOfShort)
  {
    return put(paramArrayOfShort, 0, paramArrayOfShort.length);
  }
  
  public native ShortPointer put(short[] paramArrayOfShort, int paramInt1, int paramInt2);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\ShortPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */