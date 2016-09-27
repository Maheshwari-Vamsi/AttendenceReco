package com.example.ranjith.attendencereco.googlecode.javacv;

import com.jogamp.opencl.CLBuffer;
import com.jogamp.opencl.CLContext;
import com.jogamp.opencl.CLImage2d;
import com.jogamp.opencl.CLMemory.Mem;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public abstract interface ImageTransformerCL
  extends ImageTransformer
{
  public abstract JavaCVCL getContext();
  
  public abstract void transform(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2, CLImage2d paramCLImage2d3, CLImage2d paramCLImage2d4, CLImage2d paramCLImage2d5, CLImage2d paramCLImage2d6, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean, InputData paramInputData, OutputData paramOutputData);
  
  public static class InputData
  {
    boolean autoWrite = true;
    CLBuffer<ByteBuffer> buffer = null;
    public double outlierThreshold = 0.0D;
    public int pyramidLevel = 0;
    public int roiHeight = 0;
    public int roiWidth = 0;
    public int roiX = 0;
    public int roiY = 0;
    public double zeroThreshold = 0.0D;
    
    public InputData()
    {
      this(true);
    }
    
    public InputData(boolean paramBoolean)
    {
      this.autoWrite = paramBoolean;
    }
    
    CLBuffer<ByteBuffer> getBuffer(JavaCVCL paramJavaCVCL)
    {
      if ((this.buffer == null) || (this.buffer.getCLSize() < 16))
      {
        if (this.buffer != null) {
          this.buffer.release();
        }
        CLContext localCLContext = paramJavaCVCL.getCLContext();
        CLMemory.Mem[] arrayOfMem = new CLMemory.Mem[1];
        arrayOfMem[0] = CLMemory.Mem.READ_ONLY;
        this.buffer = localCLContext.createByteBuffer(16, arrayOfMem);
      }
      return this.buffer;
    }
    
    public CLBuffer<ByteBuffer> writeBuffer(JavaCVCL paramJavaCVCL)
    {
      getBuffer(paramJavaCVCL);
      ((ByteBuffer)((ByteBuffer)this.buffer.getBuffer()).rewind()).putInt(this.roiY).putInt(this.roiHeight).putFloat((float)this.zeroThreshold).putFloat((float)this.outlierThreshold).rewind();
      paramJavaCVCL.writeBuffer(this.buffer, false);
      return this.buffer;
    }
  }
  
  public static class OutputData
  {
    boolean autoRead = true;
    CLBuffer<ByteBuffer> buffer = null;
    public int dstCount = 0;
    public int dstCountOutlier = 0;
    public int dstCountZero = 0;
    public FloatBuffer dstDstDot = null;
    public FloatBuffer srcDstDot = null;
    
    public OutputData()
    {
      this(true);
    }
    
    public OutputData(boolean paramBoolean)
    {
      this.autoRead = paramBoolean;
    }
    
    CLBuffer<ByteBuffer> getBuffer(JavaCVCL paramJavaCVCL, int paramInt1, int paramInt2)
    {
      int i = 4 * (paramInt1 + 4 + paramInt1 * paramInt1);
      if ((this.buffer == null) || (this.buffer.getCLSize() < i * paramInt2))
      {
        if (this.buffer != null) {
          this.buffer.release();
        }
        this.buffer = paramJavaCVCL.getCLContext().createByteBuffer(i * paramInt2, new CLMemory.Mem[0]);
        ByteBuffer localByteBuffer = (ByteBuffer)this.buffer.getBuffer();
        localByteBuffer.position(16);
        this.srcDstDot = localByteBuffer.asFloatBuffer();
        localByteBuffer.position(4 * (paramInt1 + 4));
        this.dstDstDot = localByteBuffer.asFloatBuffer();
        localByteBuffer.rewind();
      }
      return this.buffer;
    }
    
    public CLBuffer<ByteBuffer> readBuffer(JavaCVCL paramJavaCVCL)
    {
      paramJavaCVCL.readBuffer(this.buffer, true);
      ByteBuffer localByteBuffer = (ByteBuffer)this.buffer.getBuffer();
      this.dstCount = localByteBuffer.getInt(4);
      this.dstCountZero = localByteBuffer.getInt(8);
      this.dstCountOutlier = localByteBuffer.getInt(12);
      return this.buffer;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ImageTransformerCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */