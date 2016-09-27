package com.example.ranjith.attendencereco.googlecode.javacpp;

import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.ArrayAllocator;
import com.googlecode.javacpp.annotation.ByPtr;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByPtrRef;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Convention;
import com.googlecode.javacpp.annotation.Function;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.MemberSetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.NoException;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Raw;
import com.googlecode.javacpp.annotation.ValueGetter;
import com.googlecode.javacpp.annotation.ValueSetter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generator
  implements Closeable
{
  public static final String JNI_VERSION = "JNI_VERSION_1_6";
  private static final List<Class> baseClasses = Arrays.asList(new Class[] { Pointer.class, BytePointer.class, ShortPointer.class, IntPointer.class, LongPointer.class, FloatPointer.class, DoublePointer.class, CharPointer.class, PointerPointer.class, BoolPointer.class, CLongPointer.class, SizeTPointer.class });
  private static final Logger logger = Logger.getLogger(Generator.class.getName());
  private LinkedListRegister<Class> arrayDeallocators;
  private LinkedListRegister<Class> deallocators;
  private LinkedListRegister<String> functionDefinitions;
  private LinkedListRegister<String> functionPointers;
  private LinkedListRegister<Class> jclasses;
  private LinkedListRegister<Class> jclassesInit;
  private boolean mayThrowExceptions;
  private HashMap<Class, LinkedList<String>> members;
  private PrintWriter out;
  private PrintWriter out2;
  private java.util.Properties properties;
  private boolean usesAdapters;
  
  public Generator(java.util.Properties paramProperties)
  {
    this.properties = paramProperties;
  }
  
  private void doCall(MethodInformation paramMethodInformation, String paramString)
  {
    String str1;
    String str2;
    String str3;
    int i;
    int j;
    if (paramMethodInformation.mayThrowException)
    {
      str1 = "        ";
      str2 = "(";
      str3 = ")";
      i = 0;
      if ((!paramMethodInformation.method.isAnnotationPresent(Index.class)) && ((paramMethodInformation.pairedMethod == null) || (!paramMethodInformation.pairedMethod.isAnnotationPresent(Index.class)))) {
        break label199;
      }
      j = 1;
      label55:
      if (!paramMethodInformation.deallocator) {
        break label205;
      }
      this.out.println(str1 + "void* allocatedAddress = jlong_to_ptr(arg0);");
      this.out.println(str1 + "void (*deallocatorAddress)(void*) = (void(*)(void*))jlong_to_ptr(arg1);");
      this.out.println(str1 + "if (deallocatorAddress != NULL && allocatedAddress != NULL) {");
      this.out.println(str1 + "    (*deallocatorAddress)(allocatedAddress);");
      this.out.println(str1 + "}");
    }
    label199:
    label205:
    label344:
    label348:
    label667:
    label1209:
    label1217:
    label1317:
    label1447:
    do
    {
      return;
      str1 = "    ";
      break;
      j = 0;
      break label55;
      int k;
      int m;
      int n;
      PrintWriter localPrintWriter2;
      StringBuilder localStringBuilder1;
      if ((paramMethodInformation.valueGetter) || (paramMethodInformation.valueSetter) || (paramMethodInformation.memberGetter) || (paramMethodInformation.memberSetter))
      {
        k = -1 + paramMethodInformation.parameterTypes.length;
        if (((paramMethodInformation.valueSetter) || (paramMethodInformation.memberSetter)) && (!(getParameterBy(paramMethodInformation, k) instanceof ByRef)) && (getParameterAdapterInformation(false, paramMethodInformation, k) == null) && (paramMethodInformation.parameterTypes[k] == String.class))
        {
          this.out.print(str1 + "strcpy((char*)");
          m = 1;
          str2 = ", ";
          if (!Modifier.isStatic(paramMethodInformation.modifiers)) {
            break label667;
          }
          this.out.print(getCPPScopeName(paramMethodInformation));
          n = i;
          if (n >= paramMethodInformation.dim) {
            break label1217;
          }
          String str7 = getParameterCast(paramMethodInformation, n);
          localPrintWriter2 = this.out;
          localStringBuilder1 = new StringBuilder().append("[").append(str7);
          if (!paramMethodInformation.parameterTypes[n].isPrimitive()) {
            break label1209;
          }
        }
      }
      for (String str8 = "arg";; str8 = "ptr")
      {
        localPrintWriter2.print(str8 + n + "]");
        n++;
        break label348;
        if ((k >= 1) && (paramMethodInformation.parameterTypes[0].isArray()) && (paramMethodInformation.parameterTypes[0].getComponentType().isPrimitive()) && ((paramMethodInformation.parameterTypes[1] == Integer.TYPE) || (paramMethodInformation.parameterTypes[1] == Long.TYPE)))
        {
          this.out.print(str1 + "memcpy(");
          m = 1;
          str2 = ", ";
          if ((paramMethodInformation.memberGetter) || (paramMethodInformation.valueGetter)) {
            this.out.print("ptr0 + arg1, ");
          }
          for (;;)
          {
            i = 2;
            str3 = " * sizeof(*ptr0)" + str3;
            break;
            str2 = str2 + "ptr0 + arg1, ";
          }
        }
        this.out.print(str1 + paramString);
        if ((paramMethodInformation.valueGetter) || (paramMethodInformation.memberGetter)) {}
        for (str2 = "";; str2 = " = ")
        {
          str3 = "";
          i = 0;
          m = 0;
          break;
        }
        if ((paramMethodInformation.memberGetter) || (paramMethodInformation.memberSetter))
        {
          if (j != 0)
          {
            this.out.print("(*ptr)");
            str2 = "." + paramMethodInformation.memberName[0] + str2;
            break label344;
          }
          this.out.print("ptr->" + paramMethodInformation.memberName[0]);
          break label344;
        }
        PrintWriter localPrintWriter3 = this.out;
        String str9;
        if (j != 0) {
          str9 = "(*ptr)";
        }
        for (;;)
        {
          localPrintWriter3.print(str9);
          break;
          if ((paramMethodInformation.dim > 0) || (m != 0)) {
            str9 = "ptr";
          } else {
            str9 = "*ptr";
          }
        }
        if (paramMethodInformation.bufferGetter)
        {
          this.out.print(str1 + paramString + "ptr");
          str2 = "";
          str3 = "";
          i = 0;
          break label344;
        }
        this.out.print(str1 + paramString);
        if (FunctionPointer.class.isAssignableFrom(paramMethodInformation.cls))
        {
          if (paramMethodInformation.cls.isAnnotationPresent(Namespace.class))
          {
            this.out.print("(ptr0->*(ptr->ptr))");
            i = 1;
            break label344;
          }
          this.out.print("(*ptr->ptr)");
          i = 0;
          break label344;
        }
        if (paramMethodInformation.allocator)
        {
          String[] arrayOfString = getCPPTypeName(paramMethodInformation.cls);
          String str10 = getValueTypeName(arrayOfString);
          if (paramMethodInformation.cls == Pointer.class)
          {
            str2 = "";
            str3 = "";
            i = 0;
            break label344;
          }
          PrintWriter localPrintWriter4 = this.out;
          StringBuilder localStringBuilder2 = new StringBuilder();
          if (getNoException(paramMethodInformation.cls, paramMethodInformation.method)) {}
          for (String str11 = "new (std::nothrow) ";; str11 = "new ")
          {
            localPrintWriter4.print(str11 + str10 + arrayOfString[1]);
            boolean bool = paramMethodInformation.arrayAllocator;
            i = 0;
            if (!bool) {
              break;
            }
            str2 = "[";
            str3 = "]";
            i = 0;
            break;
          }
        }
        if (Modifier.isStatic(paramMethodInformation.modifiers))
        {
          this.out.print(getCPPScopeName(paramMethodInformation));
          i = 0;
          break label344;
        }
        if (j != 0)
        {
          this.out.print("(*ptr)");
          str2 = "." + paramMethodInformation.memberName[0] + str2;
          i = 0;
          break label344;
        }
        this.out.print("ptr->" + paramMethodInformation.memberName[0]);
        i = 0;
        break label344;
      }
      if (paramMethodInformation.memberName.length > 1) {
        this.out.print(paramMethodInformation.memberName[1]);
      }
      this.out.print(str2);
      String str6;
      if (paramMethodInformation.withEnv)
      {
        PrintWriter localPrintWriter1 = this.out;
        if (!Modifier.isStatic(paramMethodInformation.modifiers)) {
          break label1447;
        }
        str6 = "env, cls";
        localPrintWriter1.print(str6);
        if (paramMethodInformation.parameterTypes.length - i - paramMethodInformation.dim > 0) {
          this.out.print(", ");
        }
      }
      int i1 = i + paramMethodInformation.dim;
      if (i1 < paramMethodInformation.parameterTypes.length)
      {
        Annotation localAnnotation = getParameterBy(paramMethodInformation, i1);
        String str4 = getParameterCast(paramMethodInformation, i1);
        AdapterInformation localAdapterInformation = getParameterAdapterInformation(false, paramMethodInformation, i1);
        if ((("(void*)".equals(str4)) || ("(void *)".equals(str4))) && (paramMethodInformation.parameterTypes[i1] == Long.TYPE)) {
          this.out.print("jlong_to_ptr(arg" + i1 + ")");
        }
        for (;;)
        {
          if (i1 < -1 + paramMethodInformation.parameterTypes.length) {
            this.out.print(", ");
          }
          i1++;
          break label1317;
          str6 = "env, obj";
          break;
          if (paramMethodInformation.parameterTypes[i1].isPrimitive())
          {
            this.out.print(str4 + "arg" + i1);
          }
          else if (localAdapterInformation != null)
          {
            String str5 = localAdapterInformation.cast.trim();
            if ((str5.length() > 0) && (!str5.startsWith("(")) && (!str5.endsWith(")"))) {
              str5 = "(" + str5 + ")";
            }
            this.out.print(str5 + "adapter" + i1);
            i1 += -1 + localAdapterInformation.argc;
          }
          else if ((FunctionPointer.class.isAssignableFrom(paramMethodInformation.parameterTypes[i1])) && (localAnnotation == null))
          {
            this.out.print(str4 + "(ptr" + i1 + " == NULL ? NULL : ptr" + i1 + "->ptr)");
          }
          else if (((localAnnotation instanceof ByVal)) || (((localAnnotation instanceof ByRef)) && (paramMethodInformation.parameterTypes[i1] != String.class)))
          {
            this.out.print("*" + str4 + "ptr" + i1);
          }
          else if ((localAnnotation instanceof ByPtrPtr))
          {
            this.out.print(str4 + "(arg" + i1 + " == NULL ? NULL : &ptr" + i1 + ")");
          }
          else
          {
            this.out.print(str4 + "ptr" + i1);
          }
        }
      }
      this.out.print(str3);
      if (paramMethodInformation.memberName.length > 2) {
        this.out.print(paramMethodInformation.memberName[2]);
      }
    } while ((!(getBy(paramMethodInformation.annotations) instanceof ByRef)) || (paramMethodInformation.returnType != String.class));
    this.out.print(");\n" + str1 + "rptr = rstr.c_str()");
  }
  
  private void doCallback(Class<?> paramClass, Method paramMethod, String paramString, boolean paramBoolean)
  {
    Class localClass = paramMethod.getReturnType();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Annotation[] arrayOfAnnotation1 = paramMethod.getAnnotations();
    Annotation[][] arrayOfAnnotation = paramMethod.getParameterAnnotations();
    String str1 = getFunctionClassName(paramClass);
    String[] arrayOfString1 = getCPPTypeName(paramClass);
    String[] arrayOfString2 = arrayOfString1[0].split("\\(");
    String[] arrayOfString3 = new String[1];
    arrayOfString3[0] = arrayOfString2[1];
    arrayOfString2[1] = getValueTypeName(arrayOfString3);
    String str2 = arrayOfString1[1].substring(1);
    this.functionPointers.register("static " + str1 + " " + paramString + "_instance;");
    this.jclassesInit.register(paramClass);
    String str15;
    String str3;
    label255:
    PrintWriter localPrintWriter2;
    StringBuilder localStringBuilder2;
    if (this.out2 != null)
    {
      PrintWriter localPrintWriter6 = this.out2;
      StringBuilder localStringBuilder6 = new StringBuilder().append("JNIIMPORT ").append(arrayOfString2[0]);
      if (arrayOfString2.length > 1)
      {
        str15 = arrayOfString2[1];
        localPrintWriter6.println(str15 + paramString + str2 + ";");
      }
    }
    else
    {
      PrintWriter localPrintWriter1 = this.out;
      StringBuilder localStringBuilder1 = new StringBuilder().append("JNIEXPORT ").append(arrayOfString2[0]);
      if (arrayOfString2.length <= 1) {
        break label408;
      }
      str3 = arrayOfString2[1];
      localPrintWriter1.println(str3 + paramString + str2 + " {");
      localPrintWriter2 = this.out;
      localStringBuilder2 = new StringBuilder();
      if (localClass == Void.TYPE) {
        break label415;
      }
    }
    label408:
    label415:
    for (String str4 = "    return ";; str4 = "    ")
    {
      localPrintWriter2.print(str4 + paramString + "_instance(");
      for (int i = 0; i < arrayOfClass.length; i++)
      {
        this.out.print("arg" + i);
        if (i < -1 + arrayOfClass.length) {
          this.out.print(", ");
        }
      }
      str15 = "";
      break;
      str3 = "";
      break label255;
    }
    this.out.println(");");
    this.out.println("}");
    if (!paramBoolean) {
      return;
    }
    this.out.println(arrayOfString2[0] + str1 + "::operator()" + str2 + " {");
    String str5 = "";
    if (localClass != Void.TYPE)
    {
      this.out.println("    " + getJNITypeName(localClass) + " rarg = 0;");
      str5 = "rarg = ";
    }
    String str6 = getCast(arrayOfAnnotation1, localClass);
    Annotation localAnnotation1 = getBy(arrayOfAnnotation1);
    String[] arrayOfString4 = getCPPTypeName(localClass);
    String str7 = getValueTypeName(arrayOfString4);
    AdapterInformation localAdapterInformation1 = getAdapterInformation(false, str7, arrayOfAnnotation1);
    this.out.println("    jthrowable exc = NULL;");
    this.out.println("    JNIEnv* env;");
    this.out.println("    int attached = JavaCPP_getEnv(&env);");
    this.out.println("    if (attached < 0) {");
    this.out.println("        goto end;");
    this.out.println("    }");
    this.out.println("{");
    if (arrayOfClass.length > 0)
    {
      this.out.println("    jvalue args[" + arrayOfClass.length + "];");
      int k = 0;
      if (k < arrayOfClass.length)
      {
        if (arrayOfClass[k].isPrimitive()) {
          this.out.println("    args[" + k + "]." + getSignature(arrayOfClass[k]).toLowerCase() + " = (" + getJNITypeName(arrayOfClass[k]) + ")arg" + k + ";");
        }
        for (;;)
        {
          k++;
          break;
          Annotation localAnnotation3 = getBy(arrayOfAnnotation[k]);
          String[] arrayOfString6 = getCPPTypeName(arrayOfClass[k]);
          String str11 = getValueTypeName(arrayOfString6);
          Annotation[] arrayOfAnnotation2 = arrayOfAnnotation[k];
          AdapterInformation localAdapterInformation3 = getAdapterInformation(false, str11, arrayOfAnnotation2);
          if (localAdapterInformation3 == null)
          {
            arrayOfString6 = getCastedCPPTypeName(arrayOfAnnotation[k], arrayOfClass[k]);
            str11 = getValueTypeName(arrayOfString6);
          }
          int m;
          label1042:
          label1349:
          String str13;
          if (localAdapterInformation3 != null)
          {
            this.usesAdapters = true;
            this.out.println("    " + localAdapterInformation3.name + " adapter" + k + "(arg" + k + ");");
            this.out.println("    jint size" + k + " = (jint)adapter" + k + ".size;");
            this.out.println("    jlong deallocator" + k + " = ptr_to_jlong(&(" + localAdapterInformation3.name + "::deallocate));");
            m = 1;
            if (!Pointer.class.isAssignableFrom(arrayOfClass[k])) {
              break label2651;
            }
            if (FunctionPointer.class.isAssignableFrom(arrayOfClass[k]))
            {
              arrayOfString6[0] = (getFunctionClassName(arrayOfClass[k]) + "*");
              arrayOfString6[1] = "";
              str11 = getValueTypeName(arrayOfString6);
            }
            this.out.println("    jobject obj" + k + " = NULL;");
            this.out.println("    " + arrayOfString6[0] + " ptr" + k + arrayOfString6[1] + " = NULL;");
            if (!FunctionPointer.class.isAssignableFrom(arrayOfClass[k])) {
              break label2051;
            }
            this.out.println("    ptr" + k + " = new (std::nothrow) " + str11 + ";");
            this.out.println("    if (ptr" + k + " != NULL) {");
            this.out.println("        ptr" + k + "->ptr = arg" + k + ";");
            this.out.println("    }");
            str13 = "    obj" + k + " = env->AllocObject(JavaCPP_getClass(env, " + this.jclasses.register(arrayOfClass[k]) + "));";
            this.jclassesInit.register(arrayOfClass[k]);
            Annotation[] arrayOfAnnotation3 = arrayOfAnnotation[k];
            if ((getAdapterInformation(true, str11, arrayOfAnnotation3) == null) && (!(localAnnotation3 instanceof ByPtrPtr)) && (!(localAnnotation3 instanceof ByPtrRef))) {
              break label2529;
            }
            this.out.println(str13);
            label1455:
            this.out.println("    if (obj" + k + " != NULL) { ");
            if (m == 0) {
              break label2603;
            }
            this.out.println("        if (deallocator" + k + " != 0) {");
            this.out.println("            jvalue args[3];");
            this.out.println("            args[0].j = ptr_to_jlong(ptr" + k + ");");
            this.out.println("            args[1].i = size" + k + ";");
            this.out.println("            args[2].j = deallocator" + k + ";");
            this.out.println("            env->CallNonvirtualVoidMethodA(obj" + k + ", JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
            this.out.println("        } else {");
            this.out.println("            env->SetLongField(obj" + k + ", JavaCPP_addressFID, ptr_to_jlong(ptr" + k + "));");
            this.out.println("            env->SetIntField(obj" + k + ", JavaCPP_limitFID, size" + k + ");");
            this.out.println("            env->SetIntField(obj" + k + ", JavaCPP_capacityFID, size" + k + ");");
            this.out.println("        }");
          }
          for (;;)
          {
            this.out.println("    }");
            this.out.println("    args[" + k + "].l = obj" + k + ";");
            break;
            if ((!(localAnnotation3 instanceof ByVal)) || (arrayOfClass[k] == Pointer.class))
            {
              boolean bool = FunctionPointer.class.isAssignableFrom(arrayOfClass[k]);
              m = 0;
              if (!bool) {
                break label1042;
              }
            }
            this.out.println("    jint size" + k + " = 1;");
            this.out.println("    jlong deallocator" + k + " = ptr_to_jlong(&JavaCPP_" + mangle(arrayOfClass[k].getName()) + "_deallocate);");
            this.deallocators.register(arrayOfClass[k]);
            m = 1;
            break label1042;
            label2051:
            if (localAdapterInformation3 != null)
            {
              this.out.println("    ptr" + k + " = adapter" + k + ";");
              break label1349;
            }
            if (((localAnnotation3 instanceof ByVal)) && (arrayOfClass[k] != Pointer.class))
            {
              PrintWriter localPrintWriter5 = this.out;
              StringBuilder localStringBuilder5 = new StringBuilder().append("    ptr").append(k);
              if (getNoException(arrayOfClass[k], paramMethod)) {}
              for (String str14 = " = new (std::nothrow) ";; str14 = " = new ")
              {
                localPrintWriter5.println(str14 + str11 + arrayOfString6[1] + "(*(" + arrayOfString6[0] + arrayOfString6[1] + ")&arg" + k + ");");
                break;
              }
            }
            if (((localAnnotation3 instanceof ByVal)) || ((localAnnotation3 instanceof ByRef)))
            {
              this.out.println("    ptr" + k + " = (" + arrayOfString6[0] + arrayOfString6[1] + ")&arg" + k + ";");
              break label1349;
            }
            if ((localAnnotation3 instanceof ByPtrPtr))
            {
              this.out.println("    if (arg" + k + " == NULL) {");
              this.out.println("        JavaCPP_log(\"Pointer address of argument " + k + " is NULL in callback for " + paramClass.getCanonicalName() + ".\");");
              this.out.println("    } else {");
              this.out.println("        ptr" + k + " = *arg" + k + ";");
              this.out.println("    }");
              break label1349;
            }
            this.out.println("    ptr" + k + " = arg" + k + ";");
            break label1349;
            label2529:
            this.out.println("    if (ptr" + k + " != NULL) { ");
            this.out.println("    " + str13);
            this.out.println("    }");
            break label1455;
            label2603:
            this.out.println("        env->SetLongField(obj" + k + ", JavaCPP_addressFID, ptr_to_jlong(ptr" + k + "));");
          }
          label2651:
          if (arrayOfClass[k] == String.class)
          {
            PrintWriter localPrintWriter4 = this.out;
            StringBuilder localStringBuilder4 = new StringBuilder().append("    jstring obj").append(k).append(" = arg").append(k).append(" == NULL ? NULL : env->NewStringUTF((const char*)");
            if (localAdapterInformation3 != null) {}
            for (String str12 = "adapter";; str12 = "arg")
            {
              localPrintWriter4.println(str12 + k + ");");
              this.out.println("    args[" + k + "].l = obj" + k + ";");
              break;
            }
          }
          logger.log(Level.WARNING, "Callback \"" + paramMethod + "\" has unsupported parameter type \"" + arrayOfClass[k].getCanonicalName() + "\". Compilation will most likely fail.");
        }
      }
    }
    this.out.println("    if (obj == NULL) {");
    this.out.println("        obj = env->NewGlobalRef(env->AllocObject(JavaCPP_getClass(env, " + this.jclasses.register(paramClass) + ")));");
    this.out.println("        if (obj == NULL) {");
    this.out.println("            JavaCPP_log(\"Error creating global reference of " + paramClass.getCanonicalName() + " instance for callback.\");");
    this.out.println("        } else {");
    this.out.println("            env->SetLongField(obj, JavaCPP_addressFID, ptr_to_jlong(this));");
    this.out.println("        }");
    this.out.println("        ptr = &" + paramString + ";");
    this.out.println("    }");
    this.out.println("    if (mid == NULL) {");
    this.out.println("        mid = env->GetMethodID(JavaCPP_getClass(env, " + this.jclasses.register(paramClass) + "), \"" + paramMethod.getName() + "\", \"(" + getSignature(paramMethod.getParameterTypes()) + ")" + getSignature(paramMethod.getReturnType()) + "\");");
    this.out.println("    }");
    this.out.println("    if (env->IsSameObject(obj, NULL)) {");
    this.out.println("        JavaCPP_log(\"Function pointer object is NULL in callback for " + paramClass.getCanonicalName() + ".\");");
    this.out.println("    } else if (mid == NULL) {");
    this.out.println("        JavaCPP_log(\"Error getting method ID of function caller \\\"" + paramMethod + "\\\" for callback.\");");
    this.out.println("    } else {");
    String str8 = "Object";
    if (localClass.isPrimitive())
    {
      String str10 = localClass.getName();
      str8 = Character.toUpperCase(str10.charAt(0)) + str10.substring(1);
    }
    PrintWriter localPrintWriter3 = this.out;
    StringBuilder localStringBuilder3 = new StringBuilder().append("        ").append(str5).append("env->Call").append(str8).append("MethodA(obj, mid, ");
    String str9;
    int j;
    label3386:
    Annotation localAnnotation2;
    if (arrayOfClass.length == 0)
    {
      str9 = "NULL);";
      localPrintWriter3.println(str9);
      this.out.println("        if ((exc = env->ExceptionOccurred()) != NULL) {");
      this.out.println("            env->ExceptionClear();");
      this.out.println("        }");
      this.out.println("    }");
      j = 0;
      if (j >= arrayOfClass.length) {
        break label4009;
      }
      if (Pointer.class.isAssignableFrom(arrayOfClass[j]))
      {
        String[] arrayOfString5 = getCastedCPPTypeName(arrayOfAnnotation[j], arrayOfClass[j]);
        localAnnotation2 = getBy(arrayOfAnnotation[j]);
        AdapterInformation localAdapterInformation2 = getAdapterInformation(true, getValueTypeName(arrayOfString5), arrayOfAnnotation[j]);
        if ("void*".equals(arrayOfString5[0])) {
          arrayOfString5[0] = "char*";
        }
        if ((localAdapterInformation2 != null) || ((localAnnotation2 instanceof ByPtrPtr)) || ((localAnnotation2 instanceof ByPtrRef)))
        {
          this.out.println("    " + arrayOfString5[0] + " rptr" + j + arrayOfString5[1] + " = (" + arrayOfString5[0] + arrayOfString5[1] + ")jlong_to_ptr(env->GetLongField(obj" + j + ", JavaCPP_addressFID));");
          if (localAdapterInformation2 != null) {
            this.out.println("    jint rsize" + j + " = env->GetIntField(obj" + j + ", JavaCPP_limitFID);");
          }
          if (!arrayOfClass[j].isAnnotationPresent(Opaque.class))
          {
            this.out.println("    jint rposition" + j + " = env->GetIntField(obj" + j + ", JavaCPP_positionFID);");
            this.out.println("    rptr" + j + " += rposition" + j + ";");
            if (localAdapterInformation2 != null) {
              this.out.println("    rsize" + j + " -= rposition" + j + ";");
            }
          }
          if (localAdapterInformation2 == null) {
            break label3897;
          }
          this.out.println("    adapter" + j + ".assign(rptr" + j + ", rsize" + j + ");");
        }
      }
    }
    for (;;)
    {
      if (!arrayOfClass[j].isPrimitive()) {
        this.out.println("    env->DeleteLocalRef(obj" + j + ");");
      }
      j++;
      break label3386;
      str9 = "args);";
      break;
      label3897:
      if ((localAnnotation2 instanceof ByPtrPtr)) {
        this.out.println("    *arg" + j + " = rptr" + j + ";");
      } else if ((localAnnotation2 instanceof ByPtrRef)) {
        this.out.println("    arg" + j + " = rptr" + j + ";");
      }
    }
    label4009:
    this.out.println("}");
    this.out.println("end:");
    if (localClass != Void.TYPE)
    {
      if ("void*".equals(arrayOfString4[0])) {
        arrayOfString4[0] = "char*";
      }
      if (!Pointer.class.isAssignableFrom(localClass)) {
        break label4405;
      }
      this.out.println("    " + arrayOfString4[0] + " rptr" + arrayOfString4[1] + " = rarg == NULL ? NULL : (" + arrayOfString4[0] + arrayOfString4[1] + ")jlong_to_ptr(env->GetLongField(rarg, JavaCPP_addressFID));");
      if (localAdapterInformation1 != null) {
        this.out.println("    jint rsize = rarg == NULL ? 0 : env->GetIntField(rarg, JavaCPP_limitFID);");
      }
      if (!localClass.isAnnotationPresent(Opaque.class))
      {
        this.out.println("    jint rposition = rarg == NULL ? 0 : env->GetIntField(rarg, JavaCPP_positionFID);");
        this.out.println("    rptr += rposition;");
        if (localAdapterInformation1 != null) {
          this.out.println("    rsize -= rposition;");
        }
      }
    }
    this.out.println("    if (exc != NULL) {");
    this.out.println("        jclass cls = env->GetObjectClass(exc);");
    this.out.println("        jmethodID mid = env->GetMethodID(cls, \"toString\", \"()Ljava/lang/String;\");");
    this.out.println("        env->DeleteLocalRef(cls);");
    this.out.println("        jstring str = (jstring)env->CallObjectMethod(exc, mid);");
    this.out.println("        env->DeleteLocalRef(exc);");
    this.out.println("        const char *msg = env->GetStringUTFChars(str, NULL);");
    this.out.println("        JavaCPP_exception e(msg);");
    this.out.println("        env->ReleaseStringUTFChars(str, msg);");
    this.out.println("        env->DeleteLocalRef(str);");
    this.out.println("        JavaCPP_detach(attached);");
    this.out.println("        throw e;");
    this.out.println("    } else {");
    this.out.println("        JavaCPP_detach(attached);");
    this.out.println("    }");
    if (localClass != Void.TYPE)
    {
      if (!localClass.isPrimitive()) {
        break label4542;
      }
      this.out.println("    return " + str6 + "rarg;");
    }
    for (;;)
    {
      this.out.println("}");
      return;
      label4405:
      if (Buffer.class.isAssignableFrom(localClass))
      {
        this.out.println("    " + arrayOfString4[0] + " rptr" + arrayOfString4[1] + " = rarg == NULL ? NULL : env->GetDirectBufferAddress(rarg);");
        if (localAdapterInformation1 == null) {
          break;
        }
        this.out.println("    jint rsize = rarg == NULL ? 0 : env->GetDirectBufferCapacity(rarg);");
        break;
      }
      if (localClass.isPrimitive()) {
        break;
      }
      logger.log(Level.WARNING, "Callback \"" + paramMethod + "\" has unsupported return type \"" + localClass.getCanonicalName() + "\". Compilation will most likely fail.");
      break;
      label4542:
      if (localAdapterInformation1 != null)
      {
        this.usesAdapters = true;
        this.out.println("    return " + localAdapterInformation1.name + "(" + str6 + "rptr, rsize);");
      }
      else if (FunctionPointer.class.isAssignableFrom(localClass))
      {
        this.out.println("    return " + str6 + "(rptr == NULL ? NULL : rptr->ptr);");
      }
      else if (((localAnnotation1 instanceof ByVal)) || ((localAnnotation1 instanceof ByRef)))
      {
        this.out.println("    if (rptr == NULL) {");
        this.out.println("        JavaCPP_log(\"Return pointer address is NULL in callback for " + paramClass.getCanonicalName() + ".\");");
        this.out.println("        static " + str7 + " empty" + arrayOfString4[1] + ";");
        this.out.println("        return empty;");
        this.out.println("    } else {");
        this.out.println("        return *" + str6 + "rptr;");
        this.out.println("    }");
      }
      else if ((localAnnotation1 instanceof ByPtrPtr))
      {
        this.out.println("    return " + str6 + "&rptr;");
      }
      else
      {
        this.out.println("    return " + str6 + "rptr;");
      }
    }
  }
  
  private void doCallbackAllocator(Class paramClass, String paramString)
  {
    String str = getFunctionClassName(paramClass);
    this.out.println("    obj = env->NewWeakGlobalRef(obj);");
    this.out.println("    if (obj == NULL) {");
    this.out.println("        JavaCPP_log(\"Error creating global reference of " + paramClass.getCanonicalName() + " instance for callback.\");");
    this.out.println("        return;");
    this.out.println("    }");
    this.out.println("    " + str + "* rptr = new (std::nothrow) " + str + ";");
    this.out.println("    if (rptr != NULL) {");
    this.out.println("        rptr->ptr = &" + paramString + ";");
    this.out.println("        rptr->obj = obj;");
    this.out.println("        jvalue args[3];");
    this.out.println("        args[0].j = ptr_to_jlong(rptr);");
    this.out.println("        args[1].i = 1;");
    this.out.println("        args[2].j = ptr_to_jlong(&JavaCPP_" + mangle(paramClass.getName()) + "_deallocate);");
    this.deallocators.register(paramClass);
    this.out.println("        env->CallNonvirtualVoidMethodA(obj, JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
    this.out.println("        " + paramString + "_instance = *rptr;");
    this.out.println("    }");
    this.out.println("}");
  }
  
  private boolean doClasses(boolean paramBoolean1, boolean paramBoolean2, String paramString, Class<?>... paramVarArgs)
  {
    this.out.println("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */");
    this.out.println();
    if (this.out2 != null)
    {
      this.out2.println("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */");
      this.out2.println();
    }
    String str1 = this.properties.getProperty("generator.define");
    if ((str1 != null) && (str1.length() > 0))
    {
      for (String str12 : str1.split("\000")) {
        this.out.println("#define " + str12);
      }
      this.out.println();
    }
    this.out.println("#ifdef __APPLE__");
    this.out.println("    #define _JAVASOFT_JNI_MD_H_");
    this.out.println();
    this.out.println("    #define JNIEXPORT __attribute__((visibility(\"default\")))");
    this.out.println("    #define JNIIMPORT");
    this.out.println("    #define JNICALL");
    this.out.println();
    this.out.println("    typedef int jint;");
    this.out.println("    typedef long long jlong;");
    this.out.println("    typedef signed char jbyte;");
    this.out.println("#endif");
    this.out.println("#ifdef _WIN32");
    this.out.println("    #define _JAVASOFT_JNI_MD_H_");
    this.out.println();
    this.out.println("    #define JNIEXPORT __declspec(dllexport)");
    this.out.println("    #define JNIIMPORT __declspec(dllimport)");
    this.out.println("    #define JNICALL __stdcall");
    this.out.println();
    this.out.println("    typedef int jint;");
    this.out.println("    typedef long long jlong;");
    this.out.println("    typedef signed char jbyte;");
    this.out.println("#endif");
    this.out.println("#include <jni.h>");
    if (this.out2 != null) {
      this.out2.println("#include <jni.h>");
    }
    this.out.println("#ifdef ANDROID");
    this.out.println("    #include <android/log.h>");
    this.out.println("    #define NewWeakGlobalRef(obj) NewGlobalRef(obj)");
    this.out.println("    #define DeleteWeakGlobalRef(obj) DeleteGlobalRef(obj)");
    this.out.println("#endif");
    this.out.println();
    this.out.println("#include <stddef.h>");
    this.out.println("#ifndef _WIN32");
    this.out.println("    #include <stdint.h>");
    this.out.println("#endif");
    this.out.println("#include <stdio.h>");
    this.out.println("#include <stdlib.h>");
    this.out.println("#include <string.h>");
    this.out.println("#include <exception>");
    this.out.println("#include <new>");
    this.out.println();
    this.out.println("#define jlong_to_ptr(a) ((void*)(uintptr_t)(a))");
    this.out.println("#define ptr_to_jlong(a) ((jlong)(uintptr_t)(a))");
    this.out.println();
    this.out.println("#if defined(_MSC_VER)");
    this.out.println("    #define JavaCPP_noinline __declspec(noinline)");
    this.out.println("    #define JavaCPP_hidden /* hidden by default */");
    this.out.println("#elif defined(__GNUC__)");
    this.out.println("    #define JavaCPP_noinline __attribute__((noinline))");
    this.out.println("    #define JavaCPP_hidden   __attribute__((visibility(\"hidden\")))");
    this.out.println("#else");
    this.out.println("    #define JavaCPP_noinline");
    this.out.println("    #define JavaCPP_hidden");
    this.out.println("#endif");
    this.out.println();
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = this.properties.getProperty("generator.include");
    arrayOfString1[1] = this.properties.getProperty("generator.cinclude");
    for (int i = 0; i < arrayOfString1.length; i++) {
      if ((arrayOfString1[i] != null) && (arrayOfString1[i].length() > 0))
      {
        if (i == 1)
        {
          this.out.println("extern \"C\" {");
          if (this.out2 != null)
          {
            this.out2.println("#ifdef __cplusplus");
            this.out2.println("extern \"C\" {");
            this.out2.println("#endif");
          }
        }
        for (String str9 : arrayOfString1[i].split("\000"))
        {
          String str10 = "#include ";
          if ((!str9.startsWith("<")) && (!str9.startsWith("\""))) {
            str10 = str10 + '"';
          }
          String str11 = str10 + str9;
          if ((!str9.endsWith(">")) && (!str9.endsWith("\""))) {
            str11 = str11 + '"';
          }
          this.out.println(str11);
          if (this.out2 != null) {
            this.out2.println(str11);
          }
        }
        if (i == 1)
        {
          this.out.println("}");
          if (this.out2 != null)
          {
            this.out2.println("#ifdef __cplusplus");
            this.out2.println("}");
            this.out2.println("#endif");
          }
        }
        this.out.println();
      }
    }
    this.out.println("static JavaVM* JavaCPP_vm = NULL;");
    this.out.println("static const char* JavaCPP_classNames[" + this.jclasses.size() + "] = {");
    Iterator localIterator1 = this.jclasses.iterator();
    label1085:
    LinkedList localLinkedList4;
    for (int j = 0; localIterator1.hasNext(); j = localLinkedList4.size())
    {
      Class localClass5 = (Class)localIterator1.next();
      this.out.print("        \"" + localClass5.getName().replace('.', '/') + "\"");
      if (localIterator1.hasNext()) {
        this.out.println(",");
      }
      localLinkedList4 = (LinkedList)this.members.get(localClass5);
      if ((localLinkedList4 == null) || (localLinkedList4.size() <= j)) {
        break label1085;
      }
    }
    this.out.println(" };");
    this.out.println("static jclass JavaCPP_classes[" + this.jclasses.size() + "] = { NULL };");
    this.out.println("static jmethodID JavaCPP_initMID = NULL;");
    this.out.println("static jfieldID JavaCPP_addressFID = NULL;");
    this.out.println("static jfieldID JavaCPP_positionFID = NULL;");
    this.out.println("static jfieldID JavaCPP_limitFID = NULL;");
    this.out.println("static jfieldID JavaCPP_capacityFID = NULL;");
    this.out.println();
    this.out.println("static inline void JavaCPP_log(const char* fmt, ...) {");
    this.out.println("    va_list ap;");
    this.out.println("    va_start(ap, fmt);");
    this.out.println("#ifdef ANDROID");
    this.out.println("    __android_log_vprint(ANDROID_LOG_ERROR, \"javacpp\", fmt, ap);");
    this.out.println("#else");
    this.out.println("    vfprintf(stderr, fmt, ap);");
    this.out.println("    fprintf(stderr, \"\\n\");");
    this.out.println("#endif");
    this.out.println("    va_end(ap);");
    this.out.println("}");
    this.out.println();
    this.out.println("static JavaCPP_noinline jclass JavaCPP_getClass(JNIEnv* env, int i) {");
    this.out.println("    if (JavaCPP_classes[i] == NULL && env->PushLocalFrame(1) == 0) {");
    this.out.println("        jclass cls = env->FindClass(JavaCPP_classNames[i]);");
    this.out.println("        if (cls == NULL || env->ExceptionCheck()) {");
    this.out.println("            JavaCPP_log(\"Error loading class %s.\", JavaCPP_classNames[i]);");
    this.out.println("            return NULL;");
    this.out.println("        }");
    this.out.println("        JavaCPP_classes[i] = (jclass)env->NewWeakGlobalRef(cls);");
    this.out.println("        if (JavaCPP_classes[i] == NULL || env->ExceptionCheck()) {");
    this.out.println("            JavaCPP_log(\"Error creating global reference of class %s.\", JavaCPP_classNames[i]);");
    this.out.println("            return NULL;");
    this.out.println("        }");
    this.out.println("        env->PopLocalFrame(NULL);");
    this.out.println("    }");
    this.out.println("    return JavaCPP_classes[i];");
    this.out.println("}");
    this.out.println();
    this.out.println("template <typename P> static inline P JavaCPP_dereference(JNIEnv* env, P* ptr) {");
    this.out.println("    if (ptr == NULL) {");
    this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"Return pointer address is NULL.\");");
    this.out.println("        return P();");
    this.out.println("    }");
    this.out.println("    return *ptr;");
    this.out.println("}");
    this.out.println();
    this.out.println("class JavaCPP_hidden JavaCPP_exception : public std::exception {");
    this.out.println("public:");
    this.out.println("    JavaCPP_exception(const char* str) throw() {");
    this.out.println("        if (str == NULL) {");
    this.out.println("            strcpy(msg, \"Unknown exception.\");");
    this.out.println("        } else {");
    this.out.println("            strncpy(msg, str, sizeof(msg));");
    this.out.println("            msg[sizeof(msg) - 1] = 0;");
    this.out.println("        }");
    this.out.println("    }");
    this.out.println("    virtual const char* what() const throw() { return msg; }");
    this.out.println("    char msg[1024];");
    this.out.println("};");
    this.out.println();
    if (paramBoolean1)
    {
      this.out.println("static JavaCPP_noinline void JavaCPP_handleException(JNIEnv* env) {");
      this.out.println("    try {");
      this.out.println("        throw;");
      this.out.println("    } catch (std::exception& e) {");
      this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(RuntimeException.class) + "), e.what());");
      this.out.println("    } catch (...) {");
      this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(RuntimeException.class) + "), \"Unknown exception.\");");
      this.out.println("    }");
      this.out.println("}");
      this.out.println();
    }
    if (paramBoolean2)
    {
      this.out.println("#include <vector>");
      this.out.println("template<typename P, typename T = P> class JavaCPP_hidden VectorAdapter {");
      this.out.println("public:");
      this.out.println("    VectorAdapter(const P* ptr, typename std::vector<T>::size_type size) : ptr((P*)ptr), size(size),");
      this.out.println("        vec2(ptr ? std::vector<T>((P*)ptr, (P*)ptr + size) : std::vector<T>()), vec(vec2) { }");
      this.out.println("    VectorAdapter(const std::vector<T>& vec) : ptr(0), size(0), vec2(vec), vec(vec2) { }");
      this.out.println("    VectorAdapter(      std::vector<T>& vec) : ptr(0), size(0), vec(vec) { }");
      this.out.println("    void assign(P* ptr, typename std::vector<T>::size_type size) {");
      this.out.println("        this->ptr = ptr;");
      this.out.println("        this->size = size;");
      this.out.println("        vec.assign(ptr, ptr + size);");
      this.out.println("    }");
      this.out.println("    static void deallocate(P* ptr) { delete[] ptr; }");
      this.out.println("    operator P*() {");
      this.out.println("        if (vec.size() > size) {");
      this.out.println("            ptr = new (std::nothrow) P[vec.size()];");
      this.out.println("        }");
      this.out.println("        if (ptr) {");
      this.out.println("            std::copy(vec.begin(), vec.end(), ptr);");
      this.out.println("        }");
      this.out.println("        size = vec.size();");
      this.out.println("        return ptr;");
      this.out.println("    }");
      this.out.println("    operator const P*()        { return &vec[0]; }");
      this.out.println("    operator std::vector<T>&() { return vec; }");
      this.out.println("    operator std::vector<T>*() { return ptr ? &vec : 0; }");
      this.out.println("    P* ptr;");
      this.out.println("    typename std::vector<T>::size_type size;");
      this.out.println("    std::vector<T> vec2;");
      this.out.println("    std::vector<T>& vec;");
      this.out.println("};");
      this.out.println();
      this.out.println("#include <string>");
      this.out.println("class JavaCPP_hidden StringAdapter {");
      this.out.println("public:");
      this.out.println("    StringAdapter(const          char* ptr, size_t size) : ptr((char*)ptr), size(size),");
      this.out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
      this.out.println("    StringAdapter(const signed   char* ptr, size_t size) : ptr((char*)ptr), size(size),");
      this.out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
      this.out.println("    StringAdapter(const unsigned char* ptr, size_t size) : ptr((char*)ptr), size(size),");
      this.out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
      this.out.println("    StringAdapter(const std::string& str) : ptr(0), size(0), str2(str), str(str2) { }");
      this.out.println("    StringAdapter(      std::string& str) : ptr(0), size(0), str(str) { }");
      this.out.println("    void assign(char* ptr, size_t size) {");
      this.out.println("        this->ptr = ptr;");
      this.out.println("        this->size = size;");
      this.out.println("        str.assign(ptr ? ptr : \"\");");
      this.out.println("    }");
      this.out.println("    static void deallocate(char* ptr) { free(ptr); }");
      this.out.println("    operator char*() {");
      this.out.println("        const char* c_str = str.c_str();");
      this.out.println("        if (ptr == NULL || strcmp(c_str, ptr) != 0) {");
      this.out.println("            ptr = strdup(c_str);");
      this.out.println("        }");
      this.out.println("        size = strlen(c_str) + 1;");
      this.out.println("        return ptr;");
      this.out.println("    }");
      this.out.println("    operator       signed   char*() { return (signed   char*)(operator char*)(); }");
      this.out.println("    operator       unsigned char*() { return (unsigned char*)(operator char*)(); }");
      this.out.println("    operator const          char*() { return                 str.c_str(); }");
      this.out.println("    operator const signed   char*() { return (signed   char*)str.c_str(); }");
      this.out.println("    operator const unsigned char*() { return (unsigned char*)str.c_str(); }");
      this.out.println("    operator         std::string&() { return str; }");
      this.out.println("    operator         std::string*() { return ptr ? &str : 0; }");
      this.out.println("    char* ptr;");
      this.out.println("    size_t size;");
      this.out.println("    std::string str2;");
      this.out.println("    std::string& str;");
      this.out.println("};");
      this.out.println();
    }
    if (!this.functionDefinitions.isEmpty())
    {
      this.out.println("static JavaCPP_noinline void JavaCPP_detach(int detach) {");
      this.out.println("    if (detach > 0 && JavaCPP_vm->DetachCurrentThread() != 0) {");
      this.out.println("        JavaCPP_log(\"Could not detach the JavaVM from the current thread.\");");
      this.out.println("    }");
      this.out.println("}");
      this.out.println();
      this.out.println("static JavaCPP_noinline int JavaCPP_getEnv(JNIEnv** env) {");
      this.out.println("    int attached = 0;");
      this.out.println("    struct {");
      this.out.println("        JNIEnv **env;");
      this.out.println("        operator JNIEnv**() { return env; } // Android JNI");
      this.out.println("        operator void**() { return (void**)env; } // standard JNI");
      this.out.println("    } env2 = { env };");
      this.out.println("    JavaVM *vm = JavaCPP_vm;");
      this.out.println("    if (vm == NULL) {");
      if (this.out2 != null)
      {
        this.out.println("#ifndef ANDROID");
        this.out.println("        int size = 1;");
        this.out.println("        if (JNI_GetCreatedJavaVMs(&vm, 1, &size) != 0 || size == 0) {");
        this.out.println("#endif");
      }
      this.out.println("            JavaCPP_log(\"Could not get any created JavaVM.\");");
      this.out.println("            return -1;");
      if (this.out2 != null)
      {
        this.out.println("#ifndef ANDROID");
        this.out.println("        }");
        this.out.println("#endif");
      }
      this.out.println("    }");
      this.out.println("    if (vm->GetEnv((void**)env, JNI_VERSION_1_6) != JNI_OK) {");
      this.out.println("        if (vm->AttachCurrentThread(env2, NULL) != 0) {");
      this.out.println("            JavaCPP_log(\"Could not attach the JavaVM to the current thread.\");");
      this.out.println("            return -1;");
      this.out.println("        }");
      this.out.println("        attached = 1;");
      this.out.println("    }");
      this.out.println("    if (JavaCPP_vm == NULL) {");
      this.out.println("        if (JNI_OnLoad(vm, NULL) < 0) {");
      this.out.println("            JavaCPP_detach(attached);");
      this.out.println("            return -1;");
      this.out.println("        }");
      this.out.println("    }");
      this.out.println("    return attached;");
      this.out.println("}");
      this.out.println();
    }
    Iterator localIterator2 = this.functionDefinitions.iterator();
    while (localIterator2.hasNext())
    {
      String str8 = (String)localIterator2.next();
      this.out.println(str8);
    }
    this.out.println();
    Iterator localIterator3 = this.functionPointers.iterator();
    while (localIterator3.hasNext())
    {
      String str7 = (String)localIterator3.next();
      this.out.println(str7);
    }
    this.out.println();
    Iterator localIterator4 = this.deallocators.iterator();
    while (localIterator4.hasNext())
    {
      Class localClass4 = (Class)localIterator4.next();
      String str5 = "JavaCPP_" + mangle(localClass4.getName());
      this.out.print("static void " + str5 + "_deallocate(");
      if (FunctionPointer.class.isAssignableFrom(localClass4))
      {
        String str6 = getFunctionClassName(localClass4);
        this.out.println(str6 + "* p) { JNIEnv *e; int a = JavaCPP_getEnv(&e); if (a >= 0) e->DeleteWeakGlobalRef(p->obj); delete p; JavaCPP_detach(a); }");
      }
      else
      {
        String[] arrayOfString3 = getCPPTypeName(localClass4);
        this.out.println(arrayOfString3[0] + " p" + arrayOfString3[1] + ") { delete p; }");
      }
    }
    Iterator localIterator5 = this.arrayDeallocators.iterator();
    while (localIterator5.hasNext())
    {
      Class localClass3 = (Class)localIterator5.next();
      String str4 = "JavaCPP_" + mangle(localClass3.getName());
      String[] arrayOfString2 = getCPPTypeName(localClass3);
      this.out.println("static void " + str4 + "_deallocateArray(" + arrayOfString2[0] + " p" + arrayOfString2[1] + ") { delete[] p; }");
    }
    this.out.println();
    this.out.println("extern \"C\" {");
    if (this.out2 != null)
    {
      this.out2.println();
      this.out2.println("#ifdef __cplusplus");
      this.out2.println("extern \"C\" {");
      this.out2.println("#endif");
      this.out2.println("JNIIMPORT int JavaCPP_init(int argc, const char *argv[]);");
      this.out.println();
      this.out.println("#ifndef ANDROID");
      this.out.println("JNIEXPORT int JavaCPP_init(int argc, const char *argv[]) {");
      this.out.println("    JavaVM *vm;");
      this.out.println("    JNIEnv *env;");
      this.out.println("    int nOptions = 1 + (argc > 255 ? 255 : argc);");
      this.out.println("    JavaVMOption options[256] = { { NULL } };");
      this.out.println("    options[0].optionString = (char*)\"-Djava.class.path=" + paramString + "\";");
      this.out.println("    for (int i = 1; i < nOptions && argv != NULL; i++) {");
      this.out.println("        options[i].optionString = (char*)argv[i - 1];");
      this.out.println("    }");
      this.out.println("    JavaVMInitArgs vm_args = { JNI_VERSION_1_6, nOptions, options };");
      this.out.println("    return JNI_CreateJavaVM(&vm, (void **)&env, &vm_args);");
      this.out.println("}");
      this.out.println("#endif");
    }
    this.out.println();
    this.out.println("JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {");
    this.out.println("    JNIEnv* env;");
    this.out.println("    if (vm->GetEnv((void**)&env, JNI_VERSION_1_6) != JNI_OK) {");
    this.out.println("        JavaCPP_log(\"Could not get JNIEnv for JNI_VERSION_1_6 inside JNI_OnLoad().\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("    if (JavaCPP_vm == vm) {");
    this.out.println("        return env->GetVersion();");
    this.out.println("    }");
    this.out.println("    JavaCPP_vm = vm;");
    this.out.println("    const char* members[" + this.jclasses.size() + "][" + j + "] = {");
    Iterator localIterator6 = this.jclasses.iterator();
    while (localIterator6.hasNext())
    {
      this.out.print("            { ");
      LinkedList localLinkedList3 = (LinkedList)this.members.get(localIterator6.next());
      Iterator localIterator12;
      if (localLinkedList3 == null) {
        localIterator12 = null;
      }
      while ((localIterator12 != null) && (localIterator12.hasNext()))
      {
        this.out.print("\"" + (String)localIterator12.next() + "\"");
        if (localIterator12.hasNext())
        {
          this.out.print(", ");
          continue;
          localIterator12 = localLinkedList3.iterator();
        }
      }
      this.out.print(" }");
      if (localIterator6.hasNext()) {
        this.out.println(",");
      }
    }
    this.out.println(" };");
    this.out.println("    int offsets[" + this.jclasses.size() + "][" + j + "] = {");
    Iterator localIterator7 = this.jclasses.iterator();
    while (localIterator7.hasNext())
    {
      this.out.print("            { ");
      Class localClass2 = (Class)localIterator7.next();
      LinkedList localLinkedList2 = (LinkedList)this.members.get(localClass2);
      Iterator localIterator11;
      if (localLinkedList2 == null) {
        localIterator11 = null;
      }
      label4430:
      while ((localIterator11 != null) && (localIterator11.hasNext()))
      {
        String str2 = getValueTypeName(getCPPTypeName(localClass2));
        String str3 = (String)localIterator11.next();
        if ("sizeof".equals(str3))
        {
          if ("void".equals(str2)) {
            str2 = "void*";
          }
          this.out.print("sizeof(" + str2 + ")");
        }
        for (;;)
        {
          if (!localIterator11.hasNext()) {
            break label4430;
          }
          this.out.print(", ");
          break;
          localIterator11 = localLinkedList2.iterator();
          break;
          this.out.print("offsetof(" + str2 + "," + str3 + ")");
        }
      }
      this.out.print(" }");
      if (localIterator7.hasNext()) {
        this.out.println(",");
      }
    }
    this.out.println(" };");
    this.out.print("    int memberOffsetSizes[" + this.jclasses.size() + "] = { ");
    Iterator localIterator8 = this.jclasses.iterator();
    if (localIterator8.hasNext())
    {
      LinkedList localLinkedList1 = (LinkedList)this.members.get(localIterator8.next());
      PrintWriter localPrintWriter = this.out;
      if (localLinkedList1 == null) {}
      for (int n = 0;; n = localLinkedList1.size())
      {
        localPrintWriter.print(n);
        if (!localIterator8.hasNext()) {
          break;
        }
        this.out.print(", ");
        break;
      }
    }
    this.out.println(" };");
    this.out.println("    jmethodID putMemberOffsetMID = env->GetStaticMethodID(JavaCPP_getClass(env, " + this.jclasses.register(Loader.class) + "), \"putMemberOffset\", \"(Ljava/lang/String;Ljava/lang/String;I)V\");");
    this.out.println("    if (putMemberOffsetMID == NULL || env->ExceptionCheck()) {");
    this.out.println("        JavaCPP_log(\"Error getting method ID of Loader.putMemberOffset().\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("    for (int i = 0; i < " + this.jclasses.size() + " && !env->ExceptionCheck(); i++) {");
    this.out.println("        for (int j = 0; j < memberOffsetSizes[i] && !env->ExceptionCheck(); j++) {");
    this.out.println("            if (env->PushLocalFrame(2) == 0) {");
    this.out.println("                jvalue args[3];");
    this.out.println("                args[0].l = env->NewStringUTF(JavaCPP_classNames[i]);");
    this.out.println("                args[1].l = env->NewStringUTF(members[i][j]);");
    this.out.println("                args[2].i = offsets[i][j];");
    this.out.println("                env->CallStaticVoidMethodA(JavaCPP_getClass(env, " + this.jclasses.register(Loader.class) + "), putMemberOffsetMID, args);");
    this.out.println("                env->PopLocalFrame(NULL);");
    this.out.println("            }");
    this.out.println("        }");
    this.out.println("    }");
    this.out.println("    JavaCPP_initMID = env->GetMethodID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"init\", \"(JIJ)V\");");
    this.out.println("    if (JavaCPP_initMID == NULL || env->ExceptionCheck()) {");
    this.out.println("        JavaCPP_log(\"Error getting method ID of Pointer.init().\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("    JavaCPP_addressFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"address\", \"J\");");
    this.out.println("    if (JavaCPP_addressFID == NULL || env->ExceptionCheck()) {");
    this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.address.\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("    JavaCPP_positionFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"position\", \"I\");");
    this.out.println("    if (JavaCPP_positionFID == NULL || env->ExceptionCheck()) {");
    this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.position.\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("    JavaCPP_limitFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"limit\", \"I\");");
    this.out.println("    if (JavaCPP_limitFID == NULL || env->ExceptionCheck()) {");
    this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.limit.\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("    JavaCPP_capacityFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"capacity\", \"I\");");
    this.out.println("    if (JavaCPP_capacityFID == NULL || env->ExceptionCheck()) {");
    this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.capacity.\");");
    this.out.println("        return JNI_ERR;");
    this.out.println("    }");
    this.out.println("#ifdef ANDROID");
    Iterator localIterator9 = this.jclassesInit.iterator();
    while (localIterator9.hasNext())
    {
      Class localClass1 = (Class)localIterator9.next();
      if (localClass1 != Pointer.class)
      {
        this.out.println("    if (JavaCPP_getClass(env, " + this.jclasses.indexOf(localClass1) + ") == NULL) {");
        this.out.println("        return JNI_ERR;");
        this.out.println("    }");
      }
    }
    this.out.println("#endif");
    this.out.println("    return env->GetVersion();");
    this.out.println("}");
    this.out.println();
    if (this.out2 != null)
    {
      this.out2.println("JNIIMPORT int JavaCPP_uninit();");
      this.out2.println();
      this.out.println("#ifndef ANDROID");
      this.out.println("JNIEXPORT int JavaCPP_uninit() {");
      this.out.println("    JavaVM *vm = JavaCPP_vm;");
      this.out.println("    JNI_OnUnload(JavaCPP_vm, NULL);");
      this.out.println("    return vm->DestroyJavaVM();");
      this.out.println("}");
      this.out.println("#endif");
    }
    this.out.println();
    this.out.println("JNIEXPORT void JNICALL JNI_OnUnload(JavaVM* vm, void* reserved) {");
    this.out.println("    JNIEnv* env;");
    this.out.println("    if (vm->GetEnv((void**)&env, JNI_VERSION_1_6) != JNI_OK) {");
    this.out.println("        JavaCPP_log(\"Could not get JNIEnv for JNI_VERSION_1_6 inside JNI_OnUnLoad().\");");
    this.out.println("        return;");
    this.out.println("    }");
    this.out.println("    for (int i = 0; i < " + this.jclasses.size() + "; i++) {");
    this.out.println("        env->DeleteWeakGlobalRef(JavaCPP_classes[i]);");
    this.out.println("        JavaCPP_classes[i] = NULL;");
    this.out.println("    }");
    this.out.println("    JavaCPP_vm = NULL;");
    this.out.println("}");
    this.out.println();
    Iterator localIterator10 = baseClasses.iterator();
    while (localIterator10.hasNext()) {
      doMethods((Class)localIterator10.next());
    }
    boolean bool1 = false;
    int k = paramVarArgs.length;
    int m = 0;
    for (;;)
    {
      if (m >= k) {
        break label5819;
      }
      Class<?> localClass = paramVarArgs[m];
      try
      {
        boolean bool2 = doMethods(localClass);
        bool1 |= bool2;
        m++;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        for (;;)
        {
          logger.log(Level.WARNING, "Could not generate code for class " + localClass.getCanonicalName() + ": " + localNoClassDefFoundError);
        }
      }
    }
    label5819:
    this.out.println("}");
    this.out.println();
    if (this.out2 != null)
    {
      this.out2.println("#ifdef __cplusplus");
      this.out2.println("}");
      this.out2.println("#endif");
    }
    return bool1;
  }
  
  private boolean doMethods(Class<?> paramClass)
  {
    com.googlecode.javacpp.annotation.Properties localProperties = (com.googlecode.javacpp.annotation.Properties)paramClass.getAnnotation(com.googlecode.javacpp.annotation.Properties.class);
    int i = 0;
    if (localProperties != null)
    {
      Platform[] arrayOfPlatform = localProperties.value();
      int n = arrayOfPlatform.length;
      for (int i1 = 0; i1 < n; i1++) {
        if (checkPlatform(arrayOfPlatform[i1])) {
          i = 1;
        }
      }
    }
    boolean bool1 = checkPlatform((Platform)paramClass.getAnnotation(Platform.class));
    i = 0;
    if (bool1) {
      i = 1;
    }
    if (i == 0) {
      return false;
    }
    LinkedList localLinkedList = (LinkedList)this.members.get(paramClass);
    if ((!paramClass.isAnnotationPresent(Opaque.class)) && (!FunctionPointer.class.isAssignableFrom(paramClass)))
    {
      if (localLinkedList == null)
      {
        HashMap localHashMap = this.members;
        localLinkedList = new LinkedList();
        localHashMap.put(paramClass, localLinkedList);
      }
      if (!localLinkedList.contains("sizeof")) {
        localLinkedList.add("sizeof");
      }
    }
    boolean bool2 = false;
    Class[] arrayOfClass = paramClass.getDeclaredClasses();
    for (int j = 0; j < arrayOfClass.length; j++) {
      if ((Pointer.class.isAssignableFrom(arrayOfClass[j])) || (Pointer.Deallocator.class.isAssignableFrom(arrayOfClass[j]))) {
        bool2 |= doMethods(arrayOfClass[j]);
      }
    }
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    boolean[] arrayOfBoolean = new boolean[arrayOfMethod.length];
    Method localMethod = getFunctionMethod(paramClass, arrayOfBoolean);
    if (localMethod != null)
    {
      String[] arrayOfString2 = getCPPTypeName(paramClass);
      String[] arrayOfString3 = arrayOfString2[0].split("\\(");
      String[] arrayOfString4 = new String[1];
      arrayOfString4[0] = arrayOfString3[1];
      arrayOfString3[1] = getValueTypeName(arrayOfString4);
      String str7 = arrayOfString2[1].substring(1);
      String str8 = getFunctionClassName(paramClass);
      this.functionDefinitions.register("struct JavaCPP_hidden " + str8 + " {\n" + "    " + str8 + "() : ptr(NULL), obj(NULL) { }\n" + "    " + arrayOfString3[0] + "operator()" + str7 + ";\n" + "    " + arrayOfString2[0] + "ptr" + arrayOfString2[1] + ";\n" + "    jobject obj; static jmethodID mid;\n" + "};\n" + "jmethodID " + str8 + "::mid = NULL;");
    }
    boolean bool3 = true;
    int k = 0;
    if (k < arrayOfMethod.length)
    {
      String str1 = mangle(paramClass.getName()) + "_" + mangle(arrayOfMethod[k].getName());
      if (!checkPlatform((Platform)arrayOfMethod[k].getAnnotation(Platform.class))) {}
      MethodInformation localMethodInformation;
      for (;;)
      {
        k++;
        break;
        localMethodInformation = getMethodInformation(arrayOfMethod[k]);
        String str2 = "JavaCPP_" + str1 + "_callback";
        if ((arrayOfBoolean[k] != 0) && (localMethod == null))
        {
          logger.log(Level.WARNING, "No callback method call() or apply() has been not declared in \"" + paramClass.getCanonicalName() + "\". No code will be generated for callback allocator.");
        }
        else
        {
          if ((arrayOfBoolean[k] != 0) || ((arrayOfMethod[k].equals(localMethod)) && (localMethodInformation == null)))
          {
            Name localName = (Name)arrayOfMethod[k].getAnnotation(Name.class);
            if ((localName != null) && (localName.value().length > 0) && (localName.value()[0].length() > 0)) {
              str2 = localName.value()[0];
            }
            doCallback(paramClass, localMethod, str2, bool3);
            bool3 = false;
            bool2 = true;
          }
          if (localMethodInformation != null)
          {
            if (((localMethodInformation.memberGetter) || (localMethodInformation.memberSetter)) && (!localMethodInformation.noOffset) && (localLinkedList != null) && (!Modifier.isStatic(localMethodInformation.modifiers)))
            {
              String str5 = localMethodInformation.memberName[0];
              if (!localLinkedList.contains(str5))
              {
                String str6 = localMethodInformation.memberName[0];
                localLinkedList.add(str6);
              }
            }
            bool2 = true;
            this.out.print("JNIEXPORT " + getJNITypeName(localMethodInformation.returnType) + " JNICALL Java_" + str1);
            if (localMethodInformation.overloaded) {
              this.out.print("__" + mangle(getSignature(localMethodInformation.parameterTypes)));
            }
            if (Modifier.isStatic(localMethodInformation.modifiers)) {
              this.out.print("(JNIEnv* env, jclass cls");
            }
            for (;;)
            {
              for (int m = 0; m < localMethodInformation.parameterTypes.length; m++) {
                this.out.print(", " + getJNITypeName(localMethodInformation.parameterTypes[m]) + " arg" + m);
              }
              this.out.print("(JNIEnv* env, jobject obj");
            }
            this.out.println(") {");
            if (arrayOfBoolean[k] == 0) {
              break label1044;
            }
            doCallbackAllocator(paramClass, str2);
          }
        }
      }
      label1044:
      String[] arrayOfString1;
      label1105:
      String str3;
      label1262:
      PrintWriter localPrintWriter2;
      StringBuilder localStringBuilder2;
      if ((!Modifier.isStatic(localMethodInformation.modifiers)) && (!localMethodInformation.allocator) && (!localMethodInformation.arrayAllocator) && (!localMethodInformation.deallocator))
      {
        arrayOfString1 = getCPPTypeName(paramClass);
        if (!"void*".equals(arrayOfString1[0])) {
          break label1532;
        }
        arrayOfString1[0] = "char*";
        this.out.println("    " + arrayOfString1[0] + " ptr" + arrayOfString1[1] + " = (" + arrayOfString1[0] + arrayOfString1[1] + ")jlong_to_ptr(env->GetLongField(obj, JavaCPP_addressFID));");
        this.out.println("    if (ptr == NULL) {");
        this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"This pointer address is NULL.\");");
        PrintWriter localPrintWriter1 = this.out;
        StringBuilder localStringBuilder1 = new StringBuilder().append("        return");
        if (localMethodInformation.returnType != Void.TYPE) {
          break label1579;
        }
        str3 = ";";
        localPrintWriter1.println(str3);
        this.out.println("    }");
        if (FunctionPointer.class.isAssignableFrom(paramClass))
        {
          this.out.println("    if (ptr->ptr == NULL) {");
          this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"This function pointer address is NULL.\");");
          localPrintWriter2 = this.out;
          localStringBuilder2 = new StringBuilder().append("        return");
          if (localMethodInformation.returnType != Void.TYPE) {
            break label1587;
          }
        }
      }
      label1532:
      label1579:
      label1587:
      for (String str4 = ";";; str4 = " 0;")
      {
        localPrintWriter2.println(str4);
        this.out.println("    }");
        if (!paramClass.isAnnotationPresent(Opaque.class))
        {
          this.out.println("    jint position = env->GetIntField(obj, JavaCPP_positionFID);");
          this.out.println("    ptr += position;");
          if (localMethodInformation.bufferGetter)
          {
            this.out.println("    jint size = env->GetIntField(obj, JavaCPP_limitFID);");
            this.out.println("    size -= position;");
          }
        }
        doParametersBefore(localMethodInformation);
        doCall(localMethodInformation, doReturnBefore(localMethodInformation));
        doReturnAfter(localMethodInformation);
        doParametersAfter(localMethodInformation);
        if (localMethodInformation.returnType != Void.TYPE) {
          this.out.println("    return rarg;");
        }
        this.out.println("}");
        break;
        if (!FunctionPointer.class.isAssignableFrom(paramClass)) {
          break label1105;
        }
        arrayOfString1[0] = (getFunctionClassName(paramClass) + "*");
        arrayOfString1[1] = "";
        break label1105;
        str3 = " 0;";
        break label1262;
      }
    }
    this.out.println();
    return bool2;
  }
  
  private void doParametersAfter(MethodInformation paramMethodInformation)
  {
    String str1;
    int i;
    if (paramMethodInformation.mayThrowException)
    {
      str1 = "        ";
      i = 0;
      label12:
      if (i >= paramMethodInformation.parameterTypes.length) {
        break label1162;
      }
      if (paramMethodInformation.parameterRaw[i] == 0) {
        break label42;
      }
    }
    for (;;)
    {
      i++;
      break label12;
      str1 = "    ";
      break;
      label42:
      Annotation localAnnotation = getParameterBy(paramMethodInformation, i);
      String str2 = getParameterCast(paramMethodInformation, i);
      String[] arrayOfString = getCastedCPPTypeName(paramMethodInformation.parameterAnnotations[i], paramMethodInformation.parameterTypes[i]);
      AdapterInformation localAdapterInformation = getParameterAdapterInformation(true, paramMethodInformation, i);
      if ("void*".equals(arrayOfString[0])) {
        arrayOfString[0] = "char*";
      }
      if (Pointer.class.isAssignableFrom(paramMethodInformation.parameterTypes[i]))
      {
        if (localAdapterInformation != null)
        {
          int j = 0;
          label123:
          PrintWriter localPrintWriter;
          StringBuilder localStringBuilder;
          if (j < localAdapterInformation.argc)
          {
            this.out.println(str1 + arrayOfString[0] + " rptr" + (i + j) + arrayOfString[1] + " = " + str2 + "adapter" + i + ";");
            localPrintWriter = this.out;
            localStringBuilder = new StringBuilder().append(str1).append("jint rsize").append(i + j).append(" = (jint)adapter").append(i).append(".size");
            if (j <= 0) {
              break label689;
            }
          }
          label689:
          for (String str5 = j + 1 + ";";; str5 = ";")
          {
            localPrintWriter.println(str5);
            this.out.println(str1 + "if (rptr" + (i + j) + " != " + str2 + "ptr" + (i + j) + ") {");
            this.out.println(str1 + "    jvalue args[3];");
            this.out.println(str1 + "    args[0].j = ptr_to_jlong(rptr" + (i + j) + ");");
            this.out.println(str1 + "    args[1].i = rsize" + (i + j) + ";");
            this.out.println(str1 + "    args[2].j = ptr_to_jlong(&(" + localAdapterInformation.name + "::deallocate));");
            this.out.println(str1 + "    env->CallNonvirtualVoidMethodA(arg" + i + ", JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
            this.out.println(str1 + "} else {");
            this.out.println(str1 + "    env->SetIntField(arg" + i + ", JavaCPP_limitFID, rsize" + (i + j) + " + position" + (i + j) + ");");
            this.out.println(str1 + "}");
            j++;
            break label123;
            break;
          }
        }
        if ((((localAnnotation instanceof ByPtrPtr)) || ((localAnnotation instanceof ByPtrRef))) && (!paramMethodInformation.valueSetter) && (!paramMethodInformation.memberSetter))
        {
          if (!paramMethodInformation.parameterTypes[i].isAnnotationPresent(Opaque.class)) {
            this.out.println(str1 + "ptr" + i + " -= position" + i + ";");
          }
          this.out.println(str1 + "if (arg" + i + " != NULL) env->SetLongField(arg" + i + ", JavaCPP_addressFID, ptr_to_jlong(ptr" + i + "));");
        }
      }
      else if (paramMethodInformation.parameterTypes[i] == String.class)
      {
        this.out.println(str1 + "if (arg" + i + " != NULL) env->ReleaseStringUTFChars(arg" + i + ", ptr" + i + ");");
      }
      else if ((paramMethodInformation.parameterTypes[i].isArray()) && (paramMethodInformation.parameterTypes[i].getComponentType().isPrimitive()))
      {
        this.out.print(str1 + "if (arg" + i + " != NULL) ");
        String str3 = paramMethodInformation.parameterTypes[i].getComponentType().getName();
        if ((paramMethodInformation.valueGetter) || (paramMethodInformation.valueSetter) || (paramMethodInformation.memberGetter) || (paramMethodInformation.memberSetter))
        {
          this.out.println("env->ReleasePrimitiveArrayCritical(arg" + i + ", ptr" + i + ", 0);");
        }
        else
        {
          String str4 = Character.toUpperCase(str3.charAt(0)) + str3.substring(1);
          this.out.println("env->Release" + str4 + "ArrayElements(arg" + i + ", ptr" + i + ", 0);");
        }
      }
    }
    label1162:
    if (paramMethodInformation.mayThrowException)
    {
      this.mayThrowExceptions = true;
      this.out.println("    } catch (...) {");
      this.out.println("        JavaCPP_handleException(env);");
      this.out.println("    }");
    }
  }
  
  private void doParametersBefore(MethodInformation paramMethodInformation)
  {
    String str1 = "";
    Object localObject = null;
    int i = 0;
    while (i < paramMethodInformation.parameterTypes.length)
    {
      Annotation localAnnotation;
      String str2;
      String[] arrayOfString;
      AdapterInformation localAdapterInformation;
      if (!paramMethodInformation.parameterTypes[i].isPrimitive())
      {
        localAnnotation = getParameterBy(paramMethodInformation, i);
        str2 = getParameterCast(paramMethodInformation, i);
        arrayOfString = getCPPTypeName(paramMethodInformation.parameterTypes[i]);
        localAdapterInformation = getParameterAdapterInformation(false, paramMethodInformation, i);
        if (FunctionPointer.class.isAssignableFrom(paramMethodInformation.parameterTypes[i]))
        {
          if (paramMethodInformation.parameterTypes[i] == FunctionPointer.class) {
            logger.log(Level.WARNING, "Method \"" + paramMethodInformation.method + "\" has an abstract FunctionPointer parameter, " + "but a concrete subclass is required. Compilation will most likely fail.");
          }
          arrayOfString[0] = (getFunctionClassName(paramMethodInformation.parameterTypes[i]) + "*");
          arrayOfString[1] = "";
        }
        if ((arrayOfString[0].length() == 0) || (paramMethodInformation.parameterRaw[i] != 0))
        {
          paramMethodInformation.parameterRaw[i] = true;
          arrayOfString[0] = getJNITypeName(paramMethodInformation.parameterTypes[i]);
          this.out.println("    " + arrayOfString[0] + " ptr" + i + " = arg" + i + ";");
        }
      }
      else
      {
        i++;
        continue;
      }
      if ("void*".equals(arrayOfString[0])) {
        arrayOfString[0] = "char*";
      }
      this.out.print("    " + arrayOfString[0] + " ptr" + i + arrayOfString[1] + " = ");
      String str5;
      if (Pointer.class.isAssignableFrom(paramMethodInformation.parameterTypes[i]))
      {
        this.out.println("arg" + i + " == NULL ? NULL : (" + arrayOfString[0] + arrayOfString[1] + ")jlong_to_ptr(env->GetLongField(arg" + i + ", JavaCPP_addressFID));");
        if (((i == 0) && (FunctionPointer.class.isAssignableFrom(paramMethodInformation.cls)) && (paramMethodInformation.cls.isAnnotationPresent(Namespace.class))) || ((localAnnotation instanceof ByVal)) || ((localAnnotation instanceof ByRef)))
        {
          this.out.println("    if (ptr" + i + " == NULL) {");
          this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"Pointer address of argument " + i + " is NULL.\");");
          PrintWriter localPrintWriter = this.out;
          StringBuilder localStringBuilder = new StringBuilder().append("        return");
          if (paramMethodInformation.returnType == Void.TYPE)
          {
            str5 = ";";
            label607:
            localPrintWriter.println(str5);
            this.out.println("    }");
          }
        }
        else
        {
          if ((localAdapterInformation != null) || (localObject != null)) {
            this.out.println("    jint size" + i + " = arg" + i + " == NULL ? 0 : env->GetIntField(arg" + i + ", JavaCPP_limitFID);");
          }
          if (!paramMethodInformation.parameterTypes[i].isAnnotationPresent(Opaque.class))
          {
            this.out.println("    jint position" + i + " = arg" + i + " == NULL ? 0 : env->GetIntField(arg" + i + ", JavaCPP_positionFID);");
            this.out.println("    ptr" + i + " += position" + i + ";");
            if ((localAdapterInformation != null) || (localObject != null)) {
              this.out.println("    size" + i + " -= position" + i + ";");
            }
          }
        }
      }
      for (;;)
      {
        if (localAdapterInformation != null)
        {
          this.usesAdapters = true;
          str1 = "    " + localAdapterInformation.name + " adapter" + i + "(";
          localObject = localAdapterInformation;
        }
        if (localObject != null)
        {
          if (!FunctionPointer.class.isAssignableFrom(paramMethodInformation.cls)) {
            str1 = str1 + str2;
          }
          str1 = str1 + "ptr" + i + ", size" + i;
          int j = -1 + ((AdapterInformation)localObject).argc;
          ((AdapterInformation)localObject).argc = j;
          if (j > 0) {
            str1 = str1 + ", ";
          }
        }
        if ((localObject == null) || (((AdapterInformation)localObject).argc > 0)) {
          break;
        }
        this.out.println(str1 + ");");
        localObject = null;
        break;
        str5 = " 0;";
        break label607;
        if (paramMethodInformation.parameterTypes[i] == String.class)
        {
          this.out.println("arg" + i + " == NULL ? NULL : env->GetStringUTFChars(arg" + i + ", NULL);");
          if ((localAdapterInformation != null) || (localObject != null)) {
            this.out.println("    jint size" + i + " = 0;");
          }
        }
        else if ((paramMethodInformation.parameterTypes[i].isArray()) && (paramMethodInformation.parameterTypes[i].getComponentType().isPrimitive()))
        {
          this.out.print("arg" + i + " == NULL ? NULL : ");
          String str3 = paramMethodInformation.parameterTypes[i].getComponentType().getName();
          if ((paramMethodInformation.valueGetter) || (paramMethodInformation.valueSetter) || (paramMethodInformation.memberGetter) || (paramMethodInformation.memberSetter)) {
            this.out.println("(j" + str3 + "*)env->GetPrimitiveArrayCritical(arg" + i + ", NULL);");
          }
          for (;;)
          {
            if ((localAdapterInformation == null) && (localObject == null)) {
              break label1484;
            }
            this.out.println("    jint size" + i + " = arg" + i + " == NULL ? 0 : env->GetArrayLength(arg" + i + ");");
            break;
            String str4 = Character.toUpperCase(str3.charAt(0)) + str3.substring(1);
            this.out.println("env->Get" + str4 + "ArrayElements(arg" + i + ", NULL);");
          }
        }
        else
        {
          label1484:
          if (Buffer.class.isAssignableFrom(paramMethodInformation.parameterTypes[i]))
          {
            this.out.println("arg" + i + " == NULL ? NULL : (" + arrayOfString[0] + arrayOfString[1] + ")env->GetDirectBufferAddress(arg" + i + ");");
            if ((localAdapterInformation != null) || (localObject != null)) {
              this.out.println("    jint size" + i + " = arg" + i + " == NULL ? 0 : env->GetDirectBufferCapacity(arg" + i + ");");
            }
          }
          else
          {
            this.out.println("arg" + i + ";");
            logger.log(Level.WARNING, "Method \"" + paramMethodInformation.method + "\" has an unsupported parameter of type \"" + paramMethodInformation.parameterTypes[i].getCanonicalName() + "\". Compilation will most likely fail.");
          }
        }
      }
    }
  }
  
  private void doReturnAfter(MethodInformation paramMethodInformation)
  {
    String[] arrayOfString = getCastedCPPTypeName(paramMethodInformation.annotations, paramMethodInformation.returnType);
    Annotation localAnnotation = getBy(paramMethodInformation.annotations);
    AdapterInformation localAdapterInformation = getAdapterInformation(false, getValueTypeName(arrayOfString), paramMethodInformation.annotations);
    if ((!paramMethodInformation.returnType.isPrimitive()) && (localAdapterInformation != null)) {
      this.out.print(")");
    }
    if ((Pointer.class.isAssignableFrom(paramMethodInformation.returnType)) && (((localAnnotation instanceof ByVal)) || ((localAnnotation instanceof ByPtrPtr)))) {
      this.out.print(")");
    }
    if (!paramMethodInformation.deallocator) {
      this.out.println(";");
    }
    String str1;
    String str4;
    label183:
    int k;
    label223:
    int n;
    if (paramMethodInformation.mayThrowException)
    {
      str1 = "        ";
      if (paramMethodInformation.returnType != Void.TYPE) {
        break label601;
      }
      if ((paramMethodInformation.allocator) || (paramMethodInformation.arrayAllocator))
      {
        PrintWriter localPrintWriter2 = this.out;
        StringBuilder localStringBuilder2 = new StringBuilder().append(str1).append("jint rcapacity = ");
        if (!paramMethodInformation.arrayAllocator) {
          break label471;
        }
        str4 = "arg0;";
        localPrintWriter2.println(str4);
        if ((paramMethodInformation.cls != Pointer.class) && (!paramMethodInformation.cls.isAnnotationPresent(NoDeallocator.class))) {
          break label479;
        }
        k = 1;
        Annotation[] arrayOfAnnotation = paramMethodInformation.annotations;
        int m = arrayOfAnnotation.length;
        n = 0;
        label237:
        if (n < m)
        {
          if (!(arrayOfAnnotation[n] instanceof NoDeallocator)) {
            break label485;
          }
          k = 1;
        }
        if (k != 0) {
          break label516;
        }
        this.out.println(str1 + "jvalue args[3];");
        this.out.println(str1 + "args[0].j = ptr_to_jlong(rptr);");
        this.out.println(str1 + "args[1].i = rcapacity;");
        this.out.print(str1 + "args[2].j = ptr_to_jlong(&JavaCPP_" + mangle(paramMethodInformation.cls.getName()));
        if (!paramMethodInformation.arrayAllocator) {
          break label491;
        }
        this.out.println("_deallocateArray);");
        this.arrayDeallocators.register(paramMethodInformation.cls);
        label417:
        this.out.println(str1 + "env->CallNonvirtualVoidMethodA(obj, JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
      }
    }
    label471:
    label479:
    label485:
    label491:
    label516:
    label601:
    label840:
    do
    {
      do
      {
        return;
        str1 = "    ";
        break;
        str4 = "1;";
        break label183;
        k = 0;
        break label223;
        n++;
        break label237;
        this.out.println("_deallocate);");
        this.deallocators.register(paramMethodInformation.cls);
        break label417;
        this.out.println(str1 + "env->SetLongField(obj, JavaCPP_addressFID, ptr_to_jlong(rptr));");
        this.out.println(str1 + "env->SetIntField(obj, JavaCPP_limitFID, rcapacity);");
        this.out.println(str1 + "env->SetIntField(obj, JavaCPP_capacityFID, rcapacity);");
        return;
      } while ((paramMethodInformation.valueSetter) || (paramMethodInformation.memberSetter) || (paramMethodInformation.noReturnGetter));
      if (paramMethodInformation.returnType.isPrimitive())
      {
        this.out.println(str1 + "rarg = (" + getJNITypeName(paramMethodInformation.returnType) + ")rvalue;");
        return;
      }
      if (paramMethodInformation.returnRaw)
      {
        this.out.println(str1 + "rarg = rptr;");
        return;
      }
      String str3;
      int i;
      if (localAdapterInformation != null)
      {
        this.out.println(str1 + "rptr = radapter;");
        if (paramMethodInformation.returnType != String.class)
        {
          this.out.println(str1 + "jint rcapacity = (jint)radapter.size;");
          PrintWriter localPrintWriter1 = this.out;
          StringBuilder localStringBuilder1 = new StringBuilder().append(str1).append("jlong deallocator = ");
          if (localAdapterInformation.constant)
          {
            str3 = "0;";
            localPrintWriter1.println(str3);
          }
        }
        else
        {
          i = 1;
        }
      }
      for (;;)
      {
        if (Pointer.class.isAssignableFrom(paramMethodInformation.returnType))
        {
          this.out.print(str1);
          if (!(localAnnotation instanceof ByVal))
          {
            int j;
            if ((Modifier.isStatic(paramMethodInformation.modifiers)) && (paramMethodInformation.parameterTypes.length > 0)) {
              j = 0;
            }
            for (;;)
            {
              if (j < paramMethodInformation.parameterTypes.length)
              {
                String str2 = getParameterCast(paramMethodInformation, j);
                if (paramMethodInformation.parameterTypes[j] == paramMethodInformation.returnType)
                {
                  this.out.println("if (rptr == " + str2 + "ptr" + j + ") {");
                  this.out.println(str1 + "    rarg = arg" + j + ";");
                  this.out.print(str1 + "} else ");
                }
                j++;
                continue;
                str3 = "ptr_to_jlong(&(" + localAdapterInformation.name + "::deallocate));";
                break;
                if (!(localAnnotation instanceof ByVal))
                {
                  boolean bool = FunctionPointer.class.isAssignableFrom(paramMethodInformation.returnType);
                  i = 0;
                  if (!bool) {
                    break label840;
                  }
                }
                this.out.println(str1 + "jint rcapacity = 1;");
                this.out.println(str1 + "jlong deallocator = ptr_to_jlong(&JavaCPP_" + mangle(paramMethodInformation.returnType.getName()) + "_deallocate);");
                this.deallocators.register(paramMethodInformation.returnType);
                i = 1;
                break label840;
                if ((!Modifier.isStatic(paramMethodInformation.modifiers)) && (paramMethodInformation.cls == paramMethodInformation.returnType))
                {
                  this.out.println("if (rptr == ptr) {");
                  this.out.println(str1 + "    rarg = obj;");
                  this.out.print(str1 + "} else ");
                }
              }
            }
          }
          this.out.println("if (rptr != NULL) {");
          this.out.println(str1 + "    rarg = env->AllocObject(JavaCPP_getClass(env, " + this.jclasses.register(paramMethodInformation.returnType) + "));");
          if (i != 0)
          {
            this.out.println(str1 + "    if (deallocator != 0) {");
            this.out.println(str1 + "        jvalue args[3];");
            this.out.println(str1 + "        args[0].j = ptr_to_jlong(rptr);");
            this.out.println(str1 + "        args[1].i = rcapacity;");
            this.out.println(str1 + "        args[2].j = deallocator;");
            this.out.println(str1 + "        env->CallNonvirtualVoidMethodA(rarg, JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
            this.out.println(str1 + "    } else {");
            this.out.println(str1 + "        env->SetLongField(rarg, JavaCPP_addressFID, ptr_to_jlong(rptr));");
            this.out.println(str1 + "        env->SetIntField(rarg, JavaCPP_limitFID, rcapacity);");
            this.out.println(str1 + "        env->SetIntField(rarg, JavaCPP_capacityFID, rcapacity);");
            this.out.println(str1 + "    }");
          }
          for (;;)
          {
            this.out.println(str1 + "}");
            return;
            this.out.println(str1 + "    env->SetLongField(rarg, JavaCPP_addressFID, ptr_to_jlong(rptr));");
          }
        }
      }
      if (paramMethodInformation.returnType == String.class)
      {
        this.out.println(str1 + "if (rptr != NULL) {");
        this.out.println(str1 + "    rarg = env->NewStringUTF(rptr);");
        this.out.println(str1 + "}");
        return;
      }
    } while (!paramMethodInformation.bufferGetter);
    this.out.println(str1 + "if (rptr != NULL) {");
    this.out.println(str1 + "    rarg = env->NewDirectByteBuffer(rptr, size);");
    this.out.println(str1 + "}");
  }
  
  private String doReturnBefore(MethodInformation paramMethodInformation)
  {
    String str1 = "";
    if (paramMethodInformation.returnType == Void.TYPE) {
      if ((paramMethodInformation.allocator) || (paramMethodInformation.arrayAllocator))
      {
        if (paramMethodInformation.cls != Pointer.class)
        {
          this.out.println("    if (!env->IsSameObject(env->GetObjectClass(obj), JavaCPP_getClass(env, " + this.jclasses.register(paramMethodInformation.cls) + "))) {");
          this.out.println("        return;");
          this.out.println("    }");
        }
        String[] arrayOfString2 = getCPPTypeName(paramMethodInformation.cls);
        str1 = arrayOfString2[0] + " rptr" + arrayOfString2[1] + " = ";
      }
    }
    String[] arrayOfString1;
    for (;;)
    {
      if (paramMethodInformation.mayThrowException) {
        this.out.println("    try {");
      }
      return str1;
      arrayOfString1 = getCastedCPPTypeName(paramMethodInformation.annotations, paramMethodInformation.returnType);
      if ((paramMethodInformation.valueSetter) || (paramMethodInformation.memberSetter) || (paramMethodInformation.noReturnGetter))
      {
        this.out.println("    jobject rarg = obj;");
      }
      else
      {
        if (!paramMethodInformation.returnType.isPrimitive()) {
          break;
        }
        this.out.println("    " + getJNITypeName(paramMethodInformation.returnType) + " rarg = 0;");
        str1 = arrayOfString1[0] + " rvalue" + arrayOfString1[1] + " = ";
      }
    }
    Annotation localAnnotation = getBy(paramMethodInformation.annotations);
    String str2 = getValueTypeName(arrayOfString1);
    str1 = "rptr = ";
    if ((arrayOfString1[0].length() == 0) || (paramMethodInformation.returnRaw))
    {
      paramMethodInformation.returnRaw = true;
      arrayOfString1[0] = getJNITypeName(paramMethodInformation.returnType);
      this.out.println("    " + arrayOfString1[0] + " rarg = NULL;");
      this.out.println("    " + arrayOfString1[0] + " rptr;");
    }
    for (;;)
    {
      AdapterInformation localAdapterInformation = getAdapterInformation(false, str2, paramMethodInformation.annotations);
      if (localAdapterInformation == null) {
        break;
      }
      this.usesAdapters = true;
      str1 = localAdapterInformation.name + " radapter(";
      break;
      if (Pointer.class.isAssignableFrom(paramMethodInformation.returnType))
      {
        if (FunctionPointer.class.isAssignableFrom(paramMethodInformation.returnType))
        {
          arrayOfString1[0] = (getFunctionClassName(paramMethodInformation.returnType) + "*");
          arrayOfString1[1] = "";
          str2 = getValueTypeName(arrayOfString1);
          str1 = "if (rptr != NULL) rptr->ptr = ";
        }
        String str3;
        if ((localAnnotation instanceof ByVal))
        {
          StringBuilder localStringBuilder = new StringBuilder().append(str1);
          if (getNoException(paramMethodInformation.returnType, paramMethodInformation.method))
          {
            str3 = "new (std::nothrow) ";
            label572:
            str1 = str3 + str2 + arrayOfString1[1] + "(";
          }
        }
        for (;;)
        {
          this.out.println("    jobject rarg = NULL;");
          this.out.println("    " + arrayOfString1[0] + " rptr" + arrayOfString1[1] + ";");
          if (!FunctionPointer.class.isAssignableFrom(paramMethodInformation.returnType)) {
            break;
          }
          this.out.println("    rptr = new (std::nothrow) " + str2 + ";");
          break;
          str3 = "new ";
          break label572;
          if ((localAnnotation instanceof ByRef)) {
            str1 = str1 + "&";
          } else if ((localAnnotation instanceof ByPtrPtr)) {
            str1 = str1 + "JavaCPP_dereference(env, ";
          }
        }
      }
      if (paramMethodInformation.returnType == String.class)
      {
        this.out.println("    jstring rarg = NULL;");
        this.out.println("    const char* rptr;");
        if ((localAnnotation instanceof ByRef)) {
          str1 = "std::string rstr(";
        } else {
          str1 = str1 + "(const char*)";
        }
      }
      else if (paramMethodInformation.bufferGetter)
      {
        this.out.println("    jobject rarg = NULL;");
        this.out.println("    char* rptr;");
      }
      else
      {
        logger.log(Level.WARNING, "Method \"" + paramMethodInformation.method + "\" has unsupported return type \"" + paramMethodInformation.returnType.getCanonicalName() + "\". Compilation will most likely fail.");
      }
    }
  }
  
  public static AdapterInformation getAdapterInformation(boolean paramBoolean, String paramString, Annotation... paramVarArgs)
  {
    AdapterInformation localAdapterInformation = null;
    boolean bool1 = false;
    Object localObject = "";
    int i = paramVarArgs.length;
    int j = 0;
    if (j < i)
    {
      Annotation localAnnotation = paramVarArgs[j];
      Adapter localAdapter;
      if ((localAnnotation instanceof Adapter))
      {
        localAdapter = (Adapter)localAnnotation;
        label44:
        if (localAdapter == null) {
          break label403;
        }
        localAdapterInformation = new AdapterInformation();
        localAdapterInformation.name = localAdapter.value();
        localAdapterInformation.argc = localAdapter.argc();
        if (localAnnotation == localAdapter) {}
      }
      for (;;)
      {
        try
        {
          localClass = localAnnotation.annotationType();
          boolean bool2 = localClass.isAnnotationPresent(Const.class);
          if (bool2) {
            bool1 = true;
          }
        }
        catch (Exception localException)
        {
          Class localClass;
          String str2;
          Cast localCast1;
          String str1;
          logger.log(Level.WARNING, "Could not invoke the value() method on annotation \"" + localAnnotation + "\".", localException);
          continue;
        }
        try
        {
          str2 = localClass.getDeclaredMethod("value", new Class[0]).invoke(localAnnotation, new Object[0]).toString();
          if (str2 != null)
          {
            int k = str2.length();
            if (k > 0) {
              paramString = str2;
            }
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramString = null;
        }
      }
      localCast1 = (Cast)localClass.getAnnotation(Cast.class);
      if ((localCast1 != null) && (((String)localObject).length() == 0))
      {
        localObject = localCast1.value()[0];
        if (paramString != null) {
          localObject = (String)localObject + "< " + paramString + " >";
        }
        if (localCast1.value().length > 1)
        {
          str1 = (String)localObject + localCast1.value()[1];
          localObject = str1;
        }
      }
      if ((paramString != null) && (paramString.length() > 0)) {
        localAdapterInformation.name = (localAdapterInformation.name + "< " + paramString + " >");
      }
      for (;;)
      {
        j++;
        break;
        localAdapter = (Adapter)localAnnotation.annotationType().getAnnotation(Adapter.class);
        break label44;
        label403:
        if ((localAnnotation instanceof Const))
        {
          bool1 = true;
        }
        else if ((localAnnotation instanceof Cast))
        {
          Cast localCast2 = (Cast)localAnnotation;
          if (localCast2.value().length > 1) {
            localObject = localCast2.value()[1];
          }
        }
      }
    }
    if (localAdapterInformation != null)
    {
      localAdapterInformation.cast = ((String)localObject);
      localAdapterInformation.constant = bool1;
    }
    if ((paramBoolean) && (bool1)) {
      localAdapterInformation = null;
    }
    return localAdapterInformation;
  }
  
  public static String[] getAnnotatedCPPTypeName(Annotation[] paramArrayOfAnnotation, Class<?> paramClass)
  {
    String[] arrayOfString = getCastedCPPTypeName(paramArrayOfAnnotation, paramClass);
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    Annotation localAnnotation = getBy(paramArrayOfAnnotation);
    if ((localAnnotation instanceof ByVal)) {
      str1 = getValueTypeName(arrayOfString);
    }
    for (;;)
    {
      arrayOfString[0] = str1;
      arrayOfString[1] = str2;
      return arrayOfString;
      if ((localAnnotation instanceof ByRef)) {
        str1 = getValueTypeName(arrayOfString) + "&";
      } else if ((localAnnotation instanceof ByPtrPtr)) {
        str1 = str1 + "*";
      } else if ((localAnnotation instanceof ByPtrRef)) {
        str1 = str1 + "&";
      }
    }
  }
  
  public static Annotation getBehavior(Annotation... paramVarArgs)
  {
    Object localObject = null;
    int i = paramVarArgs.length;
    int j = 0;
    if (j < i)
    {
      Annotation localAnnotation = paramVarArgs[j];
      if (((localAnnotation instanceof Function)) || ((localAnnotation instanceof Allocator)) || ((localAnnotation instanceof ArrayAllocator)) || ((localAnnotation instanceof ValueSetter)) || ((localAnnotation instanceof ValueGetter)) || ((localAnnotation instanceof MemberGetter)) || ((localAnnotation instanceof MemberSetter)))
      {
        if (localObject == null) {
          break label129;
        }
        logger.log(Level.WARNING, "Behavior annotation \"" + localObject + "\" already found. Ignoring superfluous annotation \"" + localAnnotation + "\".");
      }
      for (;;)
      {
        j++;
        break;
        label129:
        localObject = localAnnotation;
      }
    }
    return (Annotation)localObject;
  }
  
  public static Annotation getBy(Annotation... paramVarArgs)
  {
    Object localObject = null;
    int i = paramVarArgs.length;
    int j = 0;
    if (j < i)
    {
      Annotation localAnnotation = paramVarArgs[j];
      if (((localAnnotation instanceof ByPtr)) || ((localAnnotation instanceof ByPtrPtr)) || ((localAnnotation instanceof ByPtrRef)) || ((localAnnotation instanceof ByRef)) || ((localAnnotation instanceof ByVal)))
      {
        if (localObject == null) {
          break label113;
        }
        logger.log(Level.WARNING, "\"By\" annotation \"" + localObject + "\" already found. Ignoring superfluous annotation \"" + localAnnotation + "\".");
      }
      for (;;)
      {
        j++;
        break;
        label113:
        localObject = localAnnotation;
      }
    }
    return (Annotation)localObject;
  }
  
  public static String getCPPScopeName(MethodInformation paramMethodInformation)
  {
    String str1 = getCPPScopeName(paramMethodInformation.cls);
    Namespace localNamespace = (Namespace)paramMethodInformation.method.getAnnotation(Namespace.class);
    if (localNamespace == null) {}
    for (String str2 = "";; str2 = localNamespace.value())
    {
      if (((localNamespace != null) && (localNamespace.value().length() == 0)) || (str2.startsWith("::"))) {
        str1 = "";
      }
      if ((str1.length() > 0) && (!str1.endsWith("::"))) {
        str1 = str1 + "::";
      }
      String str3 = str1 + str2;
      if ((str2.length() > 0) && (!str2.endsWith("::"))) {
        str3 = str3 + "::";
      }
      return str3 + paramMethodInformation.memberName[0];
    }
  }
  
  public static String getCPPScopeName(Class<?> paramClass)
  {
    String str1 = "";
    for (;;)
    {
      Namespace localNamespace;
      String str2;
      Name localName;
      String str4;
      int i;
      if (paramClass != null)
      {
        localNamespace = (Namespace)paramClass.getAnnotation(Namespace.class);
        if (localNamespace != null) {
          break label241;
        }
        str2 = "";
        if ((Pointer.class.isAssignableFrom(paramClass)) && (paramClass != Pointer.class))
        {
          localName = (Name)paramClass.getAnnotation(Name.class);
          if (localName != null) {
            break label251;
          }
          str4 = paramClass.getName();
          i = str4.lastIndexOf("$");
          if (i < 0) {
            i = str4.lastIndexOf(".");
          }
        }
      }
      label241:
      label251:
      for (String str3 = str4.substring(i + 1);; str3 = localName.value()[0])
      {
        if ((str2.length() > 0) && (!str2.endsWith("::"))) {
          str2 = str2 + "::";
        }
        str2 = str2 + str3;
        if ((str1.length() > 0) && (!str2.endsWith("::"))) {
          str2 = str2 + "::";
        }
        str1 = str2 + str1;
        if (((localNamespace == null) || (localNamespace.value().length() != 0)) && (!str2.startsWith("::"))) {
          break label265;
        }
        return str1;
        str2 = localNamespace.value();
        break;
      }
      label265:
      paramClass = paramClass.getDeclaringClass();
    }
  }
  
  public static String[] getCPPTypeName(Class<?> paramClass)
  {
    String str1 = "";
    String str2 = "";
    if ((paramClass == Buffer.class) || (paramClass == Pointer.class)) {
      str1 = "void*";
    }
    for (;;)
    {
      return new String[] { str1, str2 };
      if ((paramClass == byte[].class) || (paramClass == ByteBuffer.class) || (paramClass == BytePointer.class))
      {
        str1 = "signed char*";
      }
      else if ((paramClass == short[].class) || (paramClass == ShortBuffer.class) || (paramClass == ShortPointer.class))
      {
        str1 = "short*";
      }
      else if ((paramClass == int[].class) || (paramClass == IntBuffer.class) || (paramClass == IntPointer.class))
      {
        str1 = "int*";
      }
      else if ((paramClass == long[].class) || (paramClass == LongBuffer.class) || (paramClass == LongPointer.class))
      {
        str1 = "jlong*";
      }
      else if ((paramClass == float[].class) || (paramClass == FloatBuffer.class) || (paramClass == FloatPointer.class))
      {
        str1 = "float*";
      }
      else if ((paramClass == double[].class) || (paramClass == DoubleBuffer.class) || (paramClass == DoublePointer.class))
      {
        str1 = "double*";
      }
      else if ((paramClass == char[].class) || (paramClass == CharBuffer.class) || (paramClass == CharPointer.class))
      {
        str1 = "unsigned short*";
      }
      else if (paramClass == boolean[].class)
      {
        str1 = "unsigned char*";
      }
      else if (paramClass == PointerPointer.class)
      {
        str1 = "void**";
      }
      else if (paramClass == String.class)
      {
        str1 = "const char*";
      }
      else if (paramClass == Byte.TYPE)
      {
        str1 = "signed char";
      }
      else if (paramClass == Long.TYPE)
      {
        str1 = "jlong";
      }
      else if (paramClass == Character.TYPE)
      {
        str1 = "unsigned short";
      }
      else if (paramClass == Boolean.TYPE)
      {
        str1 = "unsigned char";
      }
      else if (paramClass.isPrimitive())
      {
        str1 = paramClass.getName();
      }
      else if (FunctionPointer.class.isAssignableFrom(paramClass))
      {
        Method localMethod = getFunctionMethod(paramClass, null);
        if (localMethod != null)
        {
          Convention localConvention = (Convention)paramClass.getAnnotation(Convention.class);
          String str4;
          Namespace localNamespace;
          String str5;
          label400:
          Class[] arrayOfClass;
          Annotation[][] arrayOfAnnotation1;
          String str6;
          int i;
          if (localConvention == null)
          {
            str4 = "";
            localNamespace = (Namespace)paramClass.getAnnotation(Namespace.class);
            if (localNamespace != null) {
              break label728;
            }
            str5 = "";
            if ((str5.length() > 0) && (!str5.endsWith("::"))) {
              str5 = str5 + "::";
            }
            Class localClass = localMethod.getReturnType();
            arrayOfClass = localMethod.getParameterTypes();
            Annotation[] arrayOfAnnotation = localMethod.getAnnotations();
            arrayOfAnnotation1 = localMethod.getParameterAnnotations();
            String[] arrayOfString1 = getAnnotatedCPPTypeName(arrayOfAnnotation, localClass);
            str1 = arrayOfString1[0] + arrayOfString1[1] + " (" + str4 + str5 + "*";
            str6 = ")(";
            if ((localNamespace != null) && (!Pointer.class.isAssignableFrom(arrayOfClass[0]))) {
              logger.log(Level.WARNING, "First parameter of caller method call() or apply() for member function pointer " + paramClass.getCanonicalName() + " is not a Pointer. Compilation will most likely fail.");
            }
            if (localNamespace != null) {
              break label740;
            }
            i = 0;
          }
          for (;;)
          {
            if (i >= arrayOfClass.length) {
              break label746;
            }
            String[] arrayOfString2 = getAnnotatedCPPTypeName(arrayOfAnnotation1[i], arrayOfClass[i]);
            str6 = str6 + arrayOfString2[0] + " arg" + i + arrayOfString2[1];
            if (i < -1 + arrayOfClass.length) {
              str6 = str6 + ", ";
            }
            i++;
            continue;
            str4 = localConvention.value() + " ";
            break;
            label728:
            str5 = localNamespace.value();
            break label400;
            label740:
            i = 1;
          }
          label746:
          str2 = str6 + ")";
          if (paramClass.isAnnotationPresent(Const.class)) {
            str2 = str2 + " const";
          }
        }
      }
      else
      {
        String str3 = getCPPScopeName(paramClass);
        if (str3.length() > 0) {
          str1 = str3 + "*";
        } else {
          logger.log(Level.WARNING, "The class " + paramClass.getCanonicalName() + " does not map to any C++ type. Compilation will most likely fail.");
        }
      }
    }
  }
  
  public static String getCast(Annotation[] paramArrayOfAnnotation, Class<?> paramClass)
  {
    String[] arrayOfString = null;
    Annotation localAnnotation1 = getBy(paramArrayOfAnnotation);
    int i = paramArrayOfAnnotation.length;
    int j = 0;
    if (j < i)
    {
      Annotation localAnnotation2 = paramArrayOfAnnotation[j];
      if ((((localAnnotation2 instanceof Cast)) && (((Cast)localAnnotation2).value()[0].length() > 0)) || (((localAnnotation2 instanceof Const)) && (((localAnnotation1 instanceof ByVal)) || ((localAnnotation1 instanceof ByRef))))) {
        arrayOfString = getCastedCPPTypeName(paramArrayOfAnnotation, paramClass);
      }
      for (;;)
      {
        j++;
        break;
        if ((localAnnotation2 instanceof Const)) {
          arrayOfString = getAnnotatedCPPTypeName(paramArrayOfAnnotation, paramClass);
        }
      }
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return "(" + arrayOfString[0] + arrayOfString[1] + ")";
    }
    return "";
  }
  
  public static String[] getCastedCPPTypeName(Annotation[] paramArrayOfAnnotation, Class<?> paramClass)
  {
    String[] arrayOfString = null;
    int i = 0;
    int j = 0;
    int k = paramArrayOfAnnotation.length;
    int m = 0;
    if (m < k)
    {
      Annotation localAnnotation = paramArrayOfAnnotation[m];
      if ((localAnnotation instanceof Cast)) {
        if (arrayOfString != null)
        {
          i = 1;
          label41:
          String str1 = ((Cast)localAnnotation).value()[0];
          String str2 = "";
          int n = str1.indexOf(')');
          if (n > 0)
          {
            str2 = str1.substring(n).trim();
            str1 = str1.substring(0, n).trim();
          }
          if (str1.length() <= 0) {
            break label132;
          }
          arrayOfString = new String[] { str1, str2 };
        }
      }
      for (;;)
      {
        m++;
        break;
        i = 0;
        break label41;
        label132:
        arrayOfString = null;
        continue;
        if ((localAnnotation instanceof Const))
        {
          if (arrayOfString != null) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label205;
            }
            arrayOfString = getCPPTypeName(paramClass);
            if (!((Const)localAnnotation).value()) {
              break label207;
            }
            arrayOfString[0] = (getValueTypeName(arrayOfString) + " const *");
            break;
          }
          label205:
          continue;
          label207:
          arrayOfString[0] = ("const " + arrayOfString[0]);
        }
        else if (((localAnnotation instanceof Adapter)) || (localAnnotation.annotationType().isAnnotationPresent(Adapter.class)))
        {
          j = 1;
        }
      }
    }
    if ((i != 0) && (j == 0)) {
      logger.log(Level.WARNING, "Without \"Adapter\", \"Cast\" and \"Const\" annotations are mutually exclusive.");
    }
    if (arrayOfString == null) {
      arrayOfString = getCPPTypeName(paramClass);
    }
    return arrayOfString;
  }
  
  private String getFunctionClassName(Class<?> paramClass)
  {
    Name localName = (Name)paramClass.getAnnotation(Name.class);
    if (localName != null) {
      return localName.value()[0];
    }
    return "JavaCPP_" + mangle(paramClass.getName());
  }
  
  private static Method getFunctionMethod(Class<?> paramClass, boolean[] paramArrayOfBoolean)
  {
    if (!FunctionPointer.class.isAssignableFrom(paramClass))
    {
      localMethod = null;
      return localMethod;
    }
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    Method localMethod = null;
    int i = 0;
    label24:
    String str;
    int j;
    Class[] arrayOfClass;
    Class localClass;
    if (i < arrayOfMethod.length)
    {
      str = arrayOfMethod[i].getName();
      j = arrayOfMethod[i].getModifiers();
      arrayOfClass = arrayOfMethod[i].getParameterTypes();
      localClass = arrayOfMethod[i].getReturnType();
      if (!Modifier.isStatic(j)) {
        break label81;
      }
    }
    for (;;)
    {
      i++;
      break label24;
      break;
      label81:
      if ((paramArrayOfBoolean != null) && (str.startsWith("allocate")) && (Modifier.isNative(j)) && (localClass == Void.TYPE) && (arrayOfClass.length == 0)) {
        paramArrayOfBoolean[i] = true;
      } else if ((str.startsWith("call")) || (str.startsWith("apply"))) {
        localMethod = arrayOfMethod[i];
      }
    }
  }
  
  public static String getJNITypeName(Class paramClass)
  {
    if (paramClass == Byte.TYPE) {
      return "jbyte";
    }
    if (paramClass == Short.TYPE) {
      return "jshort";
    }
    if (paramClass == Integer.TYPE) {
      return "jint";
    }
    if (paramClass == Long.TYPE) {
      return "jlong";
    }
    if (paramClass == Float.TYPE) {
      return "jfloat";
    }
    if (paramClass == Double.TYPE) {
      return "jdouble";
    }
    if (paramClass == Character.TYPE) {
      return "jchar";
    }
    if (paramClass == Boolean.TYPE) {
      return "jboolean";
    }
    if (paramClass == byte[].class) {
      return "jbyteArray";
    }
    if (paramClass == short[].class) {
      return "jshortArray";
    }
    if (paramClass == int[].class) {
      return "jintArray";
    }
    if (paramClass == long[].class) {
      return "jlongArray";
    }
    if (paramClass == float[].class) {
      return "jfloatArray";
    }
    if (paramClass == double[].class) {
      return "jdoubleArray";
    }
    if (paramClass == char[].class) {
      return "jcharArray";
    }
    if (paramClass == boolean[].class) {
      return "jbooleanArray";
    }
    if (paramClass.isArray()) {
      return "jobjectArray";
    }
    if (paramClass == String.class) {
      return "jstring";
    }
    if (paramClass == Class.class) {
      return "jclass";
    }
    if (paramClass == Void.TYPE) {
      return "void";
    }
    return "jobject";
  }
  
  public static MethodInformation getMethodInformation(Method paramMethod)
  {
    MethodInformation localMethodInformation;
    if (!Modifier.isNative(paramMethod.getModifiers())) {
      localMethodInformation = null;
    }
    label119:
    label176:
    label294:
    label300:
    label312:
    label392:
    label415:
    label456:
    label486:
    label558:
    label564:
    label570:
    label576:
    label771:
    label808:
    label826:
    label858:
    label929:
    label935:
    label941:
    label950:
    label976:
    label1042:
    label1046:
    label1054:
    label1164:
    label1212:
    label1785:
    label1791:
    label1797:
    label1823:
    for (;;)
    {
      return localMethodInformation;
      localMethodInformation = new MethodInformation();
      localMethodInformation.cls = paramMethod.getDeclaringClass();
      localMethodInformation.method = paramMethod;
      localMethodInformation.annotations = paramMethod.getAnnotations();
      localMethodInformation.modifiers = paramMethod.getModifiers();
      localMethodInformation.returnType = paramMethod.getReturnType();
      localMethodInformation.name = paramMethod.getName();
      Name localName1 = (Name)paramMethod.getAnnotation(Name.class);
      String[] arrayOfString;
      int i;
      boolean bool1;
      if (localName1 != null)
      {
        arrayOfString = localName1.value();
        localMethodInformation.memberName = arrayOfString;
        Index localIndex = (Index)paramMethod.getAnnotation(Index.class);
        if (localIndex == null) {
          break label294;
        }
        i = localIndex.value();
        localMethodInformation.dim = i;
        localMethodInformation.parameterTypes = paramMethod.getParameterTypes();
        localMethodInformation.parameterAnnotations = paramMethod.getParameterAnnotations();
        localMethodInformation.returnRaw = paramMethod.isAnnotationPresent(Raw.class);
        if (!localMethodInformation.returnRaw) {
          break label300;
        }
        bool1 = ((Raw)paramMethod.getAnnotation(Raw.class)).withEnv();
        localMethodInformation.withEnv = bool1;
        localMethodInformation.parameterRaw = new boolean[localMethodInformation.parameterAnnotations.length];
      }
      for (int j = 0;; j++)
      {
        if (j >= localMethodInformation.parameterAnnotations.length) {
          break label312;
        }
        int i17 = 0;
        for (;;)
        {
          if (i17 < localMethodInformation.parameterAnnotations[j].length)
          {
            if ((localMethodInformation.parameterAnnotations[j][i17] instanceof Raw))
            {
              localMethodInformation.parameterRaw[j] = true;
              localMethodInformation.withEnv |= ((Raw)localMethodInformation.parameterAnnotations[j][i17]).withEnv();
            }
            i17++;
            continue;
            arrayOfString = new String[1];
            arrayOfString[0] = localMethodInformation.name;
            break;
            i = 0;
            break label119;
            bool1 = false;
            break label176;
          }
        }
      }
      int k;
      int m;
      int n;
      int i1;
      int i2;
      int i4;
      boolean bool2;
      int i6;
      Method localMethod;
      Class localClass1;
      String str;
      Class[] arrayOfClass;
      if ((localMethodInformation.returnType != Void.TYPE) || ((localMethodInformation.parameterTypes.length > 0) && (localMethodInformation.parameterTypes[0].isArray()) && (localMethodInformation.parameterTypes[0].getComponentType().isPrimitive())))
      {
        k = 1;
        if (((localMethodInformation.returnType != Void.TYPE) && (localMethodInformation.returnType != localMethodInformation.cls)) || (localMethodInformation.parameterTypes.length <= 0)) {
          break label558;
        }
        m = 1;
        if ((Modifier.isStatic(localMethodInformation.modifiers)) || (localMethodInformation.returnType != Void.TYPE)) {
          break label564;
        }
        n = 1;
        if ((n == 0) || (localMethodInformation.parameterTypes.length != 1) || ((localMethodInformation.parameterTypes[0] != Integer.TYPE) && (localMethodInformation.parameterTypes[0] != Long.TYPE))) {
          break label570;
        }
        i1 = 1;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        bool2 = false;
        localObject = null;
        Method[] arrayOfMethod = localMethodInformation.cls.getDeclaredMethods();
        i6 = 0;
        if (i6 >= arrayOfMethod.length) {
          break label1054;
        }
        localMethod = arrayOfMethod[i6];
        int i7 = localMethod.getModifiers();
        localClass1 = localMethod.getReturnType();
        str = localMethod.getName();
        arrayOfClass = localMethod.getParameterTypes();
        if ((!paramMethod.equals(localMethod)) && (Modifier.isNative(i7))) {
          break label576;
        }
      }
      int i8;
      int i14;
      Class localClass2;
      do
      {
        int i12;
        do
        {
          int i9;
          int i10;
          do
          {
            i6++;
            break label486;
            k = 0;
            break;
            m = 0;
            break label392;
            n = 0;
            break label415;
            i1 = 0;
            break label456;
            i8 = 0;
            if ((k != 0) && ("get".equals(localMethodInformation.name)) && ("put".equals(str))) {
              i9 = 1;
            }
            for (;;)
            {
              i10 = 1;
              for (int i11 = 0; (i11 < localMethodInformation.parameterTypes.length) && (i11 < arrayOfClass.length); i11++) {
                if (localMethodInformation.parameterTypes[i11] != arrayOfClass[i11]) {
                  i10 = 0;
                }
              }
              if ((m != 0) && ("put".equals(localMethodInformation.name)) && ("get".equals(str)))
              {
                i8 = 1;
                i9 = 0;
              }
              else
              {
                if (!str.equals(localMethodInformation.name)) {
                  break;
                }
                localMethodInformation.overloaded = true;
                i9 = 0;
                i8 = 0;
              }
            }
          } while (i10 == 0);
          boolean bool5;
          int i16;
          Class localClass3;
          if ((i9 != 0) && (localMethodInformation.parameterTypes.length > 0) && (localMethodInformation.parameterTypes[0].isArray()) && (localMethodInformation.parameterTypes[0].getComponentType().isPrimitive()))
          {
            bool5 = true;
            if ((i8 == 0) || (arrayOfClass.length <= 0) || (!arrayOfClass[0].isArray()) || (!arrayOfClass[0].getComponentType().isPrimitive())) {
              break label929;
            }
            i12 = 1;
            if (k == 0) {
              continue;
            }
            int i15 = arrayOfClass.length;
            if (!bool5) {
              break label935;
            }
            i16 = 0;
            if (i15 - i16 != localMethodInformation.parameterTypes.length) {
              continue;
            }
            if (!bool5) {
              break label941;
            }
            localClass3 = localMethodInformation.parameterTypes[(-1 + localMethodInformation.parameterTypes.length)];
            Class localClass4 = arrayOfClass[(-1 + arrayOfClass.length)];
            if (localClass3 != localClass4) {
              continue;
            }
            Class localClass5 = Void.TYPE;
            if (localClass1 != localClass5)
            {
              Class localClass6 = localMethodInformation.cls;
              if (localClass1 != localClass6) {
                continue;
              }
            }
            localObject = localMethod;
            i2 = i9;
            if (i9 != 0) {
              break label950;
            }
          }
          for (i4 = 1;; i4 = 0)
          {
            bool2 = bool5;
            break;
            bool5 = false;
            break label771;
            i12 = 0;
            break label808;
            i16 = 1;
            break label826;
            localClass3 = localMethodInformation.returnType;
            break label858;
          }
        } while (m == 0);
        int i13 = localMethodInformation.parameterTypes.length;
        if (i12 == 0) {
          break label1042;
        }
        i14 = 0;
        if (i13 - i14 != arrayOfClass.length) {
          break label1046;
        }
        if (i12 != 0) {
          localClass1 = arrayOfClass[(-1 + arrayOfClass.length)];
        }
        localClass2 = localMethodInformation.parameterTypes[(-1 + localMethodInformation.parameterTypes.length)];
      } while (localClass1 != localClass2);
      Object localObject = localMethod;
      int i3 = i8;
      if (i8 == 0) {}
      for (int i5 = 1;; i5 = 0)
      {
        break;
        i14 = 1;
        break label976;
        break;
      }
      Annotation localAnnotation = getBehavior(localMethodInformation.annotations);
      boolean bool3;
      boolean bool4;
      if ((k != 0) && ((localAnnotation instanceof ValueGetter)))
      {
        localMethodInformation.valueGetter = true;
        localMethodInformation.noReturnGetter = bool2;
        if ((localName1 == null) && (localMethodInformation.pairedMethod != null))
        {
          Name localName2 = (Name)localMethodInformation.pairedMethod.getAnnotation(Name.class);
          if (localName2 != null) {
            localMethodInformation.memberName = localName2.value();
          }
        }
        if ((!localMethodInformation.cls.isAnnotationPresent(NoOffset.class)) && (!paramMethod.isAnnotationPresent(NoOffset.class)) && (!paramMethod.isAnnotationPresent(Index.class))) {
          break label1785;
        }
        bool3 = true;
        localMethodInformation.noOffset = bool3;
        if ((!localMethodInformation.noOffset) && (localMethodInformation.pairedMethod != null))
        {
          if ((!localMethodInformation.pairedMethod.isAnnotationPresent(NoOffset.class)) && (!localMethodInformation.pairedMethod.isAnnotationPresent(Index.class))) {
            break label1791;
          }
          bool4 = true;
          localMethodInformation.noOffset = bool4;
        }
        if ((localMethodInformation.parameterTypes.length == 0) || (!localMethodInformation.parameterTypes[0].isArray())) {
          if ((!localMethodInformation.valueGetter) && (!localMethodInformation.memberGetter)) {
            break label1797;
          }
        }
      }
      for (localMethodInformation.dim = localMethodInformation.parameterTypes.length;; localMethodInformation.dim = (-1 + localMethodInformation.parameterTypes.length)) {
        do
        {
          if ((getNoException(localMethodInformation.cls, paramMethod)) || (((!(getBy(localMethodInformation.annotations) instanceof ByVal)) || (getNoException(localMethodInformation.returnType, paramMethod))) && ((localMethodInformation.deallocator) || (localMethodInformation.valueGetter) || (localMethodInformation.valueSetter) || (localMethodInformation.memberGetter) || (localMethodInformation.memberSetter) || (localMethodInformation.bufferGetter)))) {
            break label1823;
          }
          localMethodInformation.mayThrowException = true;
          return localMethodInformation;
          if ((m != 0) && ((localAnnotation instanceof ValueSetter)))
          {
            localMethodInformation.valueSetter = true;
            break;
          }
          if ((k != 0) && ((localAnnotation instanceof MemberGetter)))
          {
            localMethodInformation.memberGetter = true;
            localMethodInformation.noReturnGetter = bool2;
            break;
          }
          if ((m != 0) && ((localAnnotation instanceof MemberSetter)))
          {
            localMethodInformation.memberSetter = true;
            break;
          }
          if ((n != 0) && ((localAnnotation instanceof Allocator)))
          {
            localMethodInformation.allocator = true;
            break;
          }
          if ((i1 != 0) && ((localAnnotation instanceof ArrayAllocator)))
          {
            localMethodInformation.arrayAllocator = true;
            localMethodInformation.allocator = true;
            break;
          }
          if (localAnnotation == null)
          {
            if ((localMethodInformation.returnType == Void.TYPE) && ("deallocate".equals(localMethodInformation.name)) && (!Modifier.isStatic(localMethodInformation.modifiers)) && (localMethodInformation.parameterTypes.length == 2) && (localMethodInformation.parameterTypes[0] == Long.TYPE) && (localMethodInformation.parameterTypes[1] == Long.TYPE))
            {
              localMethodInformation.deallocator = true;
              break;
            }
            if ((n != 0) && ("allocate".equals(localMethodInformation.name)))
            {
              localMethodInformation.allocator = true;
              break;
            }
            if ((i1 != 0) && ("allocateArray".equals(localMethodInformation.name)))
            {
              localMethodInformation.arrayAllocator = true;
              localMethodInformation.allocator = true;
              break;
            }
            if ((localMethodInformation.returnType.isAssignableFrom(ByteBuffer.class)) && ("asDirectBuffer".equals(localMethodInformation.name)) && (!Modifier.isStatic(localMethodInformation.modifiers)) && (localMethodInformation.parameterTypes.length == 0))
            {
              localMethodInformation.bufferGetter = true;
              break;
            }
            if (i2 != 0)
            {
              localMethodInformation.valueGetter = true;
              localMethodInformation.noReturnGetter = bool2;
              localMethodInformation.pairedMethod = ((Method)localObject);
              break;
            }
            if (i3 != 0)
            {
              localMethodInformation.valueSetter = true;
              localMethodInformation.pairedMethod = ((Method)localObject);
              break;
            }
            if (i4 != 0)
            {
              localMethodInformation.memberGetter = true;
              localMethodInformation.noReturnGetter = bool2;
              localMethodInformation.pairedMethod = ((Method)localObject);
              break;
            }
            if (i5 == 0) {
              break;
            }
            localMethodInformation.memberSetter = true;
            localMethodInformation.pairedMethod = ((Method)localObject);
            break;
          }
          logger.log(Level.WARNING, "Method \"" + paramMethod + "\" cannot behave like a \"" + localAnnotation + "\". No code will be generated.");
          return null;
          bool3 = false;
          break label1164;
          bool4 = false;
          break label1212;
        } while ((!localMethodInformation.memberSetter) && (!localMethodInformation.valueSetter));
      }
    }
  }
  
  public static boolean getNoException(Class<?> paramClass, Method paramMethod)
  {
    boolean bool;
    if ((baseClasses.contains(paramClass)) || (paramMethod.isAnnotationPresent(NoException.class))) {
      bool = true;
    }
    for (;;)
    {
      if ((!bool) && (paramClass != null))
      {
        bool = paramClass.isAnnotationPresent(NoException.class);
        if (!bool) {}
      }
      else
      {
        return bool;
        bool = false;
        continue;
      }
      paramClass = paramClass.getDeclaringClass();
    }
  }
  
  public static AdapterInformation getParameterAdapterInformation(boolean paramBoolean, MethodInformation paramMethodInformation, int paramInt)
  {
    AdapterInformation localAdapterInformation;
    if ((paramBoolean) && ((paramMethodInformation.parameterTypes[paramInt] == String.class) || (paramMethodInformation.valueSetter) || (paramMethodInformation.memberSetter))) {
      localAdapterInformation = null;
    }
    String str2;
    do
    {
      return localAdapterInformation;
      String str1 = getParameterCast(paramMethodInformation, paramInt);
      if ((str1 != null) && (str1.startsWith("(")) && (str1.endsWith(")"))) {
        str1 = str1.substring(1, -1 + str1.length());
      }
      if ((str1 == null) || (str1.length() == 0)) {
        str1 = getCastedCPPTypeName(paramMethodInformation.parameterAnnotations[paramInt], paramMethodInformation.parameterTypes[paramInt])[0];
      }
      str2 = getValueTypeName(new String[] { str1 });
      localAdapterInformation = getAdapterInformation(paramBoolean, str2, paramMethodInformation.parameterAnnotations[paramInt]);
    } while ((localAdapterInformation != null) || (paramMethodInformation.pairedMethod == null) || ((!paramMethodInformation.valueSetter) && (!paramMethodInformation.memberSetter)));
    return getAdapterInformation(paramBoolean, str2, paramMethodInformation.pairedMethod.getAnnotations());
  }
  
  public static Annotation getParameterBy(MethodInformation paramMethodInformation, int paramInt)
  {
    Annotation localAnnotation = getBy(paramMethodInformation.parameterAnnotations[paramInt]);
    if ((localAnnotation == null) && (paramMethodInformation.pairedMethod != null) && ((paramMethodInformation.valueSetter) || (paramMethodInformation.memberSetter))) {
      localAnnotation = getBy(paramMethodInformation.pairedMethod.getAnnotations());
    }
    return localAnnotation;
  }
  
  public static String getParameterCast(MethodInformation paramMethodInformation, int paramInt)
  {
    String str = getCast(paramMethodInformation.parameterAnnotations[paramInt], paramMethodInformation.parameterTypes[paramInt]);
    if (((str == null) || (str.length() == 0)) && (paramInt == -1 + paramMethodInformation.parameterTypes.length) && ((paramMethodInformation.valueSetter) || (paramMethodInformation.memberSetter)) && (paramMethodInformation.pairedMethod != null)) {
      str = getCast(paramMethodInformation.pairedMethod.getAnnotations(), paramMethodInformation.pairedMethod.getReturnType());
    }
    return str;
  }
  
  public static String getSignature(Class paramClass)
  {
    if (paramClass == Byte.TYPE) {
      return "B";
    }
    if (paramClass == Short.TYPE) {
      return "S";
    }
    if (paramClass == Integer.TYPE) {
      return "I";
    }
    if (paramClass == Long.TYPE) {
      return "J";
    }
    if (paramClass == Float.TYPE) {
      return "F";
    }
    if (paramClass == Double.TYPE) {
      return "D";
    }
    if (paramClass == Boolean.TYPE) {
      return "Z";
    }
    if (paramClass == Character.TYPE) {
      return "C";
    }
    if (paramClass == Void.TYPE) {
      return "V";
    }
    if (paramClass.isArray()) {
      return paramClass.getName().replace(".", "/");
    }
    return "L" + paramClass.getName().replace(".", "/") + ";";
  }
  
  public static String getSignature(Class... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(2 * paramVarArgs.length);
    for (int i = 0; i < paramVarArgs.length; i++) {
      localStringBuilder.append(getSignature(paramVarArgs[i]));
    }
    return localStringBuilder.toString();
  }
  
  public static String getValueTypeName(String... paramVarArgs)
  {
    String str = paramVarArgs[0];
    if (str.startsWith("const ")) {
      str = str.substring(6, -1 + str.length());
    }
    while (str.length() == 0) {
      return str;
    }
    return str.substring(0, -1 + str.length());
  }
  
  public static String mangle(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i++;
        break;
        if (c == '_')
        {
          localStringBuilder.append("_1");
        }
        else if (c == ';')
        {
          localStringBuilder.append("_2");
        }
        else if (c == '[')
        {
          localStringBuilder.append("_3");
        }
        else
        {
          if ((c != '.') && (c != '/')) {
            break label150;
          }
          localStringBuilder.append("_");
        }
      }
      label150:
      String str = Integer.toHexString(c);
      localStringBuilder.append("_0");
      switch (str.length())
      {
      }
      for (;;)
      {
        localStringBuilder.append(str);
        break;
        localStringBuilder.append("0");
        localStringBuilder.append("0");
        localStringBuilder.append("0");
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean checkPlatform(Platform paramPlatform)
  {
    if (paramPlatform == null) {}
    String[][] arrayOfString;
    boolean[] arrayOfBoolean;
    do
    {
      return true;
      String str = this.properties.getProperty("platform.name");
      arrayOfString = new String[2][];
      arrayOfString[0] = paramPlatform.value();
      arrayOfString[1] = paramPlatform.not();
      arrayOfBoolean = new boolean[] { 0, 0 };
      int i = 0;
      if (i < arrayOfString.length)
      {
        String[] arrayOfString1 = arrayOfString[i];
        int j = arrayOfString1.length;
        for (int k = 0;; k++) {
          if (k < j)
          {
            if (str.startsWith(arrayOfString1[k])) {
              arrayOfBoolean[i] = true;
            }
          }
          else
          {
            i++;
            break;
          }
        }
      }
    } while (((arrayOfString[0].length == 0) || (arrayOfBoolean[0] != 0)) && ((arrayOfString[1].length == 0) || (arrayOfBoolean[1] == 0)));
    return false;
  }
  
  public void close()
  {
    if (this.out != null) {
      this.out.close();
    }
    if (this.out2 != null) {
      this.out2.close();
    }
  }
  
  public boolean generate(String paramString1, String paramString2, String paramString3, Class<?>... paramVarArgs)
    throws FileNotFoundException
  {
    this.out = new PrintWriter(new Writer()
    {
      public void close() {}
      
      public void flush() {}
      
      public void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2) {}
    });
    this.out2 = null;
    this.functionDefinitions = new LinkedListRegister();
    this.functionPointers = new LinkedListRegister();
    this.deallocators = new LinkedListRegister();
    this.arrayDeallocators = new LinkedListRegister();
    this.jclasses = new LinkedListRegister();
    this.jclassesInit = new LinkedListRegister();
    this.members = new HashMap();
    this.mayThrowExceptions = false;
    this.usesAdapters = false;
    boolean bool1 = doClasses(true, true, paramString3, paramVarArgs);
    boolean bool2 = false;
    if (bool1)
    {
      this.out = new PrintWriter(paramString1);
      if (paramString2 != null) {
        this.out2 = new PrintWriter(paramString2);
      }
      bool2 = doClasses(this.mayThrowExceptions, this.usesAdapters, paramString3, paramVarArgs);
    }
    return bool2;
  }
  
  public static class AdapterInformation
  {
    public int argc;
    public String cast;
    public boolean constant;
    public String name;
  }
  
  public static class LinkedListRegister<E>
    extends LinkedList<E>
  {
    public int register(E paramE)
    {
      int i = indexOf(paramE);
      if (i < 0)
      {
        add(paramE);
        i = -1 + size();
      }
      return i;
    }
  }
  
  public static class MethodInformation
  {
    public boolean allocator;
    public Annotation[] annotations;
    public boolean arrayAllocator;
    public boolean bufferGetter;
    public Class<?> cls;
    public boolean deallocator;
    public int dim;
    public boolean mayThrowException;
    public boolean memberGetter;
    public String[] memberName;
    public boolean memberSetter;
    public Method method;
    public int modifiers;
    public String name;
    public boolean noOffset;
    public boolean noReturnGetter;
    public boolean overloaded;
    public Method pairedMethod;
    public Annotation[][] parameterAnnotations;
    public boolean[] parameterRaw;
    public Class<?>[] parameterTypes;
    public boolean returnRaw;
    public Class<?> returnType;
    public boolean valueGetter;
    public boolean valueSetter;
    public boolean withEnv;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\Generator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */