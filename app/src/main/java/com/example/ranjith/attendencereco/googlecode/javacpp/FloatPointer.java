package com.example.ranjith.attendencereco.googlecode.javacpp;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class FloatPointer
  extends Pointer
{
  public FloatPointer(int paramInt)
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
  
  public FloatPointer(Pointer paramPointer)
  {
    super(paramPointer);
  }
  
  public FloatPointer(FloatBuffer paramFloatBuffer)
  {
    super(paramFloatBuffer);
    if ((paramFloatBuffer != null) && (paramFloatBuffer.hasArray()))
    {
      float[] arrayOfFloat = paramFloatBuffer.array();
      allocateArray(arrayOfFloat.length);
      put(arrayOfFloat);
      position(paramFloatBuffer.position());
      limit(paramFloatBuffer.limit());
    }
  }
  
  public FloatPointer(float... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  private native void allocateArray(int paramInt);
  
  public final FloatBuffer asBuffer()
  {
    return asByteBuffer().asFloatBuffer();
  }
  
  public FloatPointer capacity(int paramInt)
  {
    return (FloatPointer)super.capacity(paramInt);
  }
  
  public float get()
  {
    return get(0);
  }
  
  public native float get(int paramInt);
  
  public FloatPointer get(float[] paramArrayOfFloat)
  {
    return get(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }
  
  public native FloatPointer get(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  public FloatPointer limit(int paramInt)
  {
    return (FloatPointer)super.limit(paramInt);
  }
  
  public FloatPointer position(int paramInt)
  {
    return (FloatPointer)super.position(paramInt);
  }
  
  public FloatPointer put(float paramFloat)
  {
    return put(0, paramFloat);
  }
  
  public native FloatPointer put(int paramInt, float paramFloat);
  
  public FloatPointer put(float[] paramArrayOfFloat)
  {
    return put(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }
  
  public native FloatPointer put(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\FloatPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */