package com.example.ranjith.attendencereco.googlecode.javacpp;

import com.googlecode.javacpp.annotation.Platform;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loader
{
  static boolean loadLibraries;
  static Map<String, String> loadedLibraries;
  private static final Logger logger = Logger.getLogger(Loader.class.getName());
  static WeakHashMap<Class<? extends Pointer>, HashMap<String, Integer>> memberOffsets = new WeakHashMap();
  private static String platformName = null;
  private static java.util.Properties platformProperties = null;
  static File tempDir = null;
  
  static
  {
    loadLibraries = true;
    loadedLibraries = Collections.synchronizedMap(new HashMap());
    if (getPlatformName().startsWith("windows")) {
      Runtime.getRuntime().addShutdownHook(new Thread()
      {
        public void run()
        {
          if (Loader.tempDir == null) {
            return;
          }
          try
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(System.getProperty("java.home") + "/bin/java");
            localLinkedList.add("-classpath");
            localLinkedList.add(System.getProperty("java.class.path"));
            localLinkedList.add(Loader.class.getName());
            localLinkedList.add(Loader.tempDir.getAbsolutePath());
            new ProcessBuilder(localLinkedList).start();
            return;
          }
          catch (IOException localIOException)
          {
            throw new RuntimeException(localIOException);
          }
        }
      });
    }
  }
  
  public static Class appendProperties(java.util.Properties paramProperties, Class paramClass)
  {
    Class localClass = paramClass;
    label18:
    String str1;
    com.googlecode.javacpp.annotation.Properties localProperties;
    if ((localClass.getDeclaringClass() == null) || (localClass.isAnnotationPresent(com.googlecode.javacpp.annotation.Properties.class)))
    {
      str1 = paramProperties.getProperty("platform.name");
      localProperties = (com.googlecode.javacpp.annotation.Properties)localClass.getAnnotation(com.googlecode.javacpp.annotation.Properties.class);
      if (localProperties != null) {
        break label477;
      }
    }
    String[] arrayOfString1;
    String[] arrayOfString2;
    String[] arrayOfString3;
    String[] arrayOfString4;
    String[] arrayOfString5;
    String[] arrayOfString6;
    String[] arrayOfString7;
    String[] arrayOfString8;
    String[] arrayOfString9;
    String[] arrayOfString10;
    String str2;
    for (;;)
    {
      int j;
      Platform localPlatform1;
      String[][] arrayOfString;
      boolean[] arrayOfBoolean;
      int i1;
      try
      {
        Platform localPlatform2 = (Platform)localClass.getAnnotation(Platform.class);
        if (localPlatform2 == null)
        {
          return localClass;
          if (localClass.isAnnotationPresent(Platform.class))
          {
            Platform localPlatform3 = (Platform)localClass.getAnnotation(Platform.class);
            if ((localPlatform3.define().length > 0) || (localPlatform3.include().length > 0) || (localPlatform3.cinclude().length > 0) || (localPlatform3.includepath().length > 0) || (localPlatform3.options().length > 0) || (localPlatform3.linkpath().length > 0) || (localPlatform3.link().length > 0) || (localPlatform3.framework().length > 0) || (localPlatform3.preloadpath().length > 0) || (localPlatform3.preload().length > 0) || (localPlatform3.library().length() > 0)) {
              break label18;
            }
          }
          localClass = localClass.getDeclaringClass();
          break;
        }
        Platform[] arrayOfPlatform1 = new Platform[1];
        arrayOfPlatform1[0] = localPlatform2;
        arrayOfString1 = new String[0];
        arrayOfString2 = new String[0];
        arrayOfString3 = new String[0];
        arrayOfString4 = new String[0];
        arrayOfString5 = new String[0];
        arrayOfString6 = new String[0];
        arrayOfString7 = new String[0];
        arrayOfString8 = new String[0];
        arrayOfString9 = new String[0];
        arrayOfString10 = new String[0];
        str2 = "jni" + localClass.getSimpleName();
        Platform[] arrayOfPlatform2 = arrayOfPlatform1;
        int i = arrayOfPlatform2.length;
        j = 0;
        if (j >= i) {
          break label753;
        }
        localPlatform1 = arrayOfPlatform2[j];
        arrayOfString = new String[2][];
        arrayOfString[0] = localPlatform1.value();
        arrayOfString[1] = localPlatform1.not();
        arrayOfBoolean = new boolean[] { 0, 0 };
        int m = 0;
        if (m >= arrayOfString.length) {
          break label495;
        }
        String[] arrayOfString11 = arrayOfString[m];
        int n = arrayOfString11.length;
        i1 = 0;
        if (i1 < n)
        {
          if (!str1.startsWith(arrayOfString11[i1])) {
            break label489;
          }
          arrayOfBoolean[m] = true;
        }
        m++;
        continue;
        arrayOfPlatform1 = localProperties.value();
      }
      catch (Throwable localThrowable)
      {
        logger.log(Level.WARNING, "Could not append properties for " + localClass.getCanonicalName() + ": " + localThrowable);
        return localClass;
      }
      label477:
      continue;
      label489:
      i1++;
      continue;
      label495:
      if (((arrayOfString[0].length == 0) || (arrayOfBoolean[0] != 0)) && ((arrayOfString[1].length == 0) || (arrayOfBoolean[1] == 0)))
      {
        if (localPlatform1.define().length > 0) {
          arrayOfString1 = localPlatform1.define();
        }
        if (localPlatform1.include().length > 0) {
          arrayOfString2 = localPlatform1.include();
        }
        if (localPlatform1.cinclude().length > 0) {
          arrayOfString3 = localPlatform1.cinclude();
        }
        if (localPlatform1.includepath().length > 0) {
          arrayOfString4 = localPlatform1.includepath();
        }
        if (localPlatform1.options().length > 0) {
          arrayOfString5 = localPlatform1.options();
        }
        if (localPlatform1.linkpath().length > 0) {
          arrayOfString6 = localPlatform1.linkpath();
        }
        if (localPlatform1.link().length > 0) {
          arrayOfString7 = localPlatform1.link();
        }
        if (localPlatform1.framework().length > 0) {
          arrayOfString8 = localPlatform1.framework();
        }
        if (localPlatform1.preloadpath().length > 0) {
          arrayOfString9 = localPlatform1.preloadpath();
        }
        if (localPlatform1.preload().length > 0) {
          arrayOfString10 = localPlatform1.preload();
        }
        if (localPlatform1.library().length() > 0) {
          str2 = localPlatform1.library();
        }
      }
      j++;
    }
    label753:
    String str3 = paramProperties.getProperty("path.separator");
    appendProperty(paramProperties, "generator.define", "\000", arrayOfString1);
    appendProperty(paramProperties, "generator.include", "\000", arrayOfString2);
    appendProperty(paramProperties, "generator.cinclude", "\000", arrayOfString3);
    appendProperty(paramProperties, "compiler.includepath", str3, arrayOfString4);
    if (arrayOfString5.length > 0)
    {
      String str4 = paramProperties.getProperty("compiler.options");
      paramProperties.setProperty("compiler.options", "");
      int k = 0;
      if (k < arrayOfString5.length)
      {
        String str5 = str4;
        if (arrayOfString5[k].length() > 0)
        {
          str5 = paramProperties.getProperty("compiler.options." + arrayOfString5[k]);
          if (str5 == null) {
            logger.log(Level.WARNING, "Could not find a property name \"compiler.options." + arrayOfString5[k] + "\".");
          }
        }
        for (;;)
        {
          k++;
          break;
          appendProperty(paramProperties, "compiler.options", " ", new String[] { str5 });
        }
      }
    }
    appendProperty(paramProperties, "compiler.linkpath", str3, arrayOfString6);
    appendProperty(paramProperties, "compiler.link", str3, arrayOfString7);
    appendProperty(paramProperties, "compiler.framework", str3, arrayOfString8);
    appendProperty(paramProperties, "loader.preloadpath", str3, arrayOfString6);
    appendProperty(paramProperties, "loader.preloadpath", str3, arrayOfString9);
    appendProperty(paramProperties, "loader.preload", str3, arrayOfString7);
    appendProperty(paramProperties, "loader.preload", str3, arrayOfString10);
    paramProperties.setProperty("loader.library", str2);
    return localClass;
  }
  
  public static void appendProperty(java.util.Properties paramProperties, String paramString1, String paramString2, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((paramVarArgs.length == 1) && (paramVarArgs[0] != null)) {
      paramVarArgs = paramVarArgs[0].split(paramString2);
    }
    String str1 = paramProperties.getProperty(paramString1, "");
    String[] arrayOfString1 = str1.split(paramString2);
    String str2 = "";
    String[] arrayOfString2 = paramVarArgs;
    int i = arrayOfString2.length;
    int j = 0;
    if (j < i)
    {
      String str3 = arrayOfString2[j];
      if ((str3 == null) || (str3.length() == 0)) {}
      for (;;)
      {
        j++;
        break;
        int k = arrayOfString1.length;
        for (int m = 0;; m++)
        {
          if (m >= k) {
            break label129;
          }
          if (str3.equals(arrayOfString1[m])) {
            break;
          }
        }
        label129:
        if ((str2.length() > 0) && (!str2.endsWith(paramString2))) {
          str2 = str2 + paramString2;
        }
        str2 = str2 + str3;
      }
    }
    if ((str2.length() > 0) && (str1.length() > 0)) {
      str2 = str2 + paramString2;
    }
    paramProperties.setProperty(paramString1, str2 + str1);
  }
  
  public static File extractResource(Class paramClass, String paramString1, File paramFile, String paramString2, String paramString3)
    throws IOException
  {
    return extractResource(paramClass.getResource(paramString1), paramFile, paramString2, paramString3);
  }
  
  public static File extractResource(String paramString1, File paramFile, String paramString2, String paramString3)
    throws IOException
  {
    return extractResource(getCallerClass(2), paramString1, paramFile, paramString2, paramString3);
  }
  
  /* Error */
  public static File extractResource(java.net.URL paramURL, File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_0
    //   5: invokevirtual 282	java/net/URL:openStream	()Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnonnull +11 -> 23
    //   15: aconst_null
    //   16: areturn
    //   17: aconst_null
    //   18: astore 4
    //   20: goto -10 -> 10
    //   23: aconst_null
    //   24: astore 5
    //   26: iconst_0
    //   27: istore 6
    //   29: aload_2
    //   30: ifnonnull +131 -> 161
    //   33: aload_3
    //   34: ifnonnull +127 -> 161
    //   37: aload_1
    //   38: ifnonnull +17 -> 55
    //   41: new 284	java/io/File
    //   44: dup
    //   45: ldc_w 286
    //   48: invokestatic 289	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: new 284	java/io/File
    //   58: dup
    //   59: aload_1
    //   60: new 284	java/io/File
    //   63: dup
    //   64: aload_0
    //   65: invokevirtual 295	java/net/URL:getPath	()Ljava/lang/String;
    //   68: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 296	java/io/File:getName	()Ljava/lang/String;
    //   74: invokespecial 299	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore 12
    //   79: aload 12
    //   81: invokevirtual 303	java/io/File:exists	()Z
    //   84: istore 13
    //   86: iload 13
    //   88: istore 6
    //   90: aload 12
    //   92: astore 5
    //   94: new 305	java/io/FileOutputStream
    //   97: dup
    //   98: aload 5
    //   100: invokespecial 308	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore 7
    //   105: sipush 1024
    //   108: newarray <illegal type>
    //   110: astore 10
    //   112: aload 4
    //   114: aload 10
    //   116: invokevirtual 314	java/io/InputStream:read	([B)I
    //   119: istore 11
    //   121: iload 11
    //   123: iconst_m1
    //   124: if_icmpeq +51 -> 175
    //   127: aload 7
    //   129: aload 10
    //   131: iconst_0
    //   132: iload 11
    //   134: invokevirtual 318	java/io/FileOutputStream:write	([BII)V
    //   137: goto -25 -> 112
    //   140: astore 8
    //   142: aload 5
    //   144: ifnull +14 -> 158
    //   147: iload 6
    //   149: ifne +9 -> 158
    //   152: aload 5
    //   154: invokevirtual 321	java/io/File:delete	()Z
    //   157: pop
    //   158: aload 8
    //   160: athrow
    //   161: aload_2
    //   162: aload_3
    //   163: aload_1
    //   164: invokestatic 325	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   167: astore 5
    //   169: iconst_0
    //   170: istore 6
    //   172: goto -78 -> 94
    //   175: aload 4
    //   177: invokevirtual 328	java/io/InputStream:close	()V
    //   180: aload 7
    //   182: invokevirtual 329	java/io/FileOutputStream:close	()V
    //   185: aload 5
    //   187: areturn
    //   188: astore 8
    //   190: aload 12
    //   192: astore 5
    //   194: iconst_0
    //   195: istore 6
    //   197: goto -55 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramURL	java.net.URL
    //   0	200	1	paramFile	File
    //   0	200	2	paramString1	String
    //   0	200	3	paramString2	String
    //   8	168	4	localInputStream	InputStream
    //   24	169	5	localObject	Object
    //   27	169	6	i	int
    //   103	78	7	localFileOutputStream	java.io.FileOutputStream
    //   140	19	8	localIOException1	IOException
    //   188	1	8	localIOException2	IOException
    //   110	20	10	arrayOfByte	byte[]
    //   119	14	11	j	int
    //   77	114	12	localFile	File
    //   84	3	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   41	55	140	java/io/IOException
    //   55	79	140	java/io/IOException
    //   94	112	140	java/io/IOException
    //   112	121	140	java/io/IOException
    //   127	137	140	java/io/IOException
    //   161	169	140	java/io/IOException
    //   175	185	140	java/io/IOException
    //   79	86	188	java/io/IOException
  }
  
  public static Class getCallerClass(int paramInt)
  {
    Class[] arrayOfClass = new SecurityManager()
    {
      public Class[] getClassContext()
      {
        return super.getClassContext();
      }
    }.getClassContext();
    if (arrayOfClass != null) {
      for (int j = 0; j < arrayOfClass.length; j++) {
        if (arrayOfClass[j] == Loader.class) {
          return arrayOfClass[(paramInt + j)];
        }
      }
    }
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      for (int i = 0; i < arrayOfStackTraceElement.length; i++) {
        if (Class.forName(arrayOfStackTraceElement[i].getClassName()) == Loader.class)
        {
          Class localClass = Class.forName(arrayOfStackTraceElement[(paramInt + i)].getClassName());
          return localClass;
        }
      }
      return null;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public static String getPlatformName()
  {
    if (platformName != null) {
      return platformName;
    }
    String str1 = System.getProperty("java.vm.name").toLowerCase();
    String str2 = System.getProperty("os.name").toLowerCase();
    String str3 = System.getProperty("os.arch").toLowerCase();
    if ((str1.startsWith("dalvik")) && (str2.startsWith("linux")))
    {
      str2 = "android";
      if ((!str3.equals("i386")) && (!str3.equals("i486")) && (!str3.equals("i586")) && (!str3.equals("i686"))) {
        break label180;
      }
      str3 = "x86";
    }
    for (;;)
    {
      String str4 = str2 + "-" + str3;
      platformName = str4;
      return str4;
      if (str2.startsWith("mac os x"))
      {
        str2 = "macosx";
        break;
      }
      int i = str2.indexOf(' ');
      if (i <= 0) {
        break;
      }
      str2 = str2.substring(0, i);
      break;
      label180:
      if ((str3.equals("amd64")) || (str3.equals("x86-64"))) {
        str3 = "x86_64";
      } else if (str3.startsWith("arm")) {
        str3 = "arm";
      }
    }
  }
  
  public static java.util.Properties getProperties()
  {
    if (platformProperties != null) {
      return platformProperties;
    }
    java.util.Properties localProperties = getProperties(getPlatformName());
    platformProperties = localProperties;
    return localProperties;
  }
  
  public static java.util.Properties getProperties(String paramString)
  {
    java.util.Properties localProperties = new java.util.Properties();
    localProperties.put("platform.name", paramString);
    InputStream localInputStream1 = Loader.class.getResourceAsStream("properties/" + paramString + ".properties");
    try
    {
      localProperties.load(new InputStreamReader(localInputStream1));
      return localProperties;
    }
    catch (NoSuchMethodError localNoSuchMethodError2)
    {
      localProperties.load(localInputStream1);
      return localProperties;
    }
    catch (Exception localException1)
    {
      InputStream localInputStream2 = Loader.class.getResourceAsStream("properties/generic.properties");
      try
      {
        localProperties.load(new InputStreamReader(localInputStream2));
        return localProperties;
      }
      catch (NoSuchMethodError localNoSuchMethodError1)
      {
        localProperties.load(localInputStream2);
        return localProperties;
      }
      catch (Exception localException2)
      {
        throw new MissingResourceException("Could not even get generic properties: " + localException2.getMessage(), Loader.class.getName(), "properties/generic.properties");
      }
    }
  }
  
  public static File getTempDir()
  {
    File localFile1;
    if (tempDir == null) {
      localFile1 = new File(System.getProperty("java.io.tmpdir"));
    }
    for (int i = 0;; i++) {
      if (i < 1000)
      {
        File localFile2 = new File(localFile1, "javacpp" + System.nanoTime());
        if (localFile2.mkdir())
        {
          tempDir = localFile2;
          tempDir.deleteOnExit();
        }
      }
      else
      {
        return tempDir;
      }
    }
  }
  
  public static boolean isLoadLibraries()
  {
    return loadLibraries;
  }
  
  public static String load()
  {
    return load(getCallerClass(2));
  }
  
  public static String load(Class paramClass)
  {
    if ((!loadLibraries) || (paramClass == null)) {
      return null;
    }
    java.util.Properties localProperties = (java.util.Properties)getProperties().clone();
    Class localClass1 = appendProperties(localProperties, paramClass);
    Class localClass2;
    String str1;
    String str4;
    Object localObject;
    String[] arrayOfString1;
    for (;;)
    {
      try
      {
        localClass2 = Class.forName(localClass1.getName(), true, localClass1.getClassLoader());
        str1 = localProperties.getProperty("path.separator");
        String str2 = localProperties.getProperty("platform.root");
        if ((str2 != null) && (!str2.endsWith(File.separator))) {
          str2 = str2 + File.separator;
        }
        String str3 = localProperties.getProperty("loader.preloadpath");
        str4 = localProperties.getProperty("loader.preload");
        localObject = null;
        if (str4 == null) {
          break label287;
        }
        if (str3 == null)
        {
          arrayOfString1 = null;
          if ((arrayOfString1 == null) || (str2 == null)) {
            break;
          }
          int j = 0;
          if (j >= arrayOfString1.length) {
            break;
          }
          if (!new File(arrayOfString1[j]).isAbsolute()) {
            arrayOfString1[j] = (str2 + arrayOfString1[j]);
          }
          j++;
          continue;
        }
        NoClassDefFoundError localNoClassDefFoundError;
        arrayOfString1 = str3.split(str1);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localNoClassDefFoundError = new NoClassDefFoundError(localClassNotFoundException.toString());
        localNoClassDefFoundError.initCause(localClassNotFoundException);
        throw localNoClassDefFoundError;
      }
    }
    String[] arrayOfString2 = str4.split(str1);
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString2.length) {
        try
        {
          loadLibrary(localClass2, arrayOfString1, arrayOfString2[i]);
          i++;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          for (;;)
          {
            localObject = localUnsatisfiedLinkError2;
          }
        }
      }
    }
    try
    {
      label287:
      String str5 = loadLibrary(localClass2, null, localProperties.getProperty("loader.library"));
      return str5;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      if (localObject != null) {
        localUnsatisfiedLinkError1.initCause((Throwable)localObject);
      }
      throw localUnsatisfiedLinkError1;
    }
  }
  
  /* Error */
  public static String loadLibrary(Class paramClass, String[] paramArrayOfString, String paramString)
  {
    // Byte code:
    //   0: getstatic 44	com/googlecode/javacpp/Loader:loadLibraries	Z
    //   3: ifeq +7 -> 10
    //   6: aload_0
    //   7: ifnonnull +7 -> 14
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_3
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 28	java/lang/Class:getName	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload 4
    //   22: bipush 46
    //   24: invokevirtual 513	java/lang/String:lastIndexOf	(I)I
    //   27: istore 5
    //   29: iload 5
    //   31: iconst_m1
    //   32: if_icmpeq +342 -> 374
    //   35: aload 4
    //   37: iconst_0
    //   38: iload 5
    //   40: iconst_1
    //   41: iadd
    //   42: invokevirtual 396	java/lang/String:substring	(II)Ljava/lang/String;
    //   45: astore 6
    //   47: new 155	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   54: aload 6
    //   56: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 7
    //   68: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   71: aload 7
    //   73: invokeinterface 519 2 0
    //   78: checkcast 64	java/lang/String
    //   81: astore_3
    //   82: aload_3
    //   83: ifnonnull -71 -> 12
    //   86: aload_2
    //   87: ldc_w 521
    //   90: invokevirtual 248	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   93: astore 8
    //   95: aload 8
    //   97: iconst_0
    //   98: aaload
    //   99: astore 9
    //   101: aload 8
    //   103: arraylength
    //   104: iconst_1
    //   105: if_icmple +276 -> 381
    //   108: aload 8
    //   110: iconst_m1
    //   111: aload 8
    //   113: arraylength
    //   114: iadd
    //   115: aaload
    //   116: astore 10
    //   118: invokestatic 474	com/googlecode/javacpp/Loader:getProperties	()Ljava/util/Properties;
    //   121: astore 11
    //   123: new 155	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   130: aload 11
    //   132: ldc 103
    //   134: invokevirtual 109	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: bipush 47
    //   142: invokevirtual 524	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   145: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore 12
    //   150: new 155	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   157: aload 11
    //   159: ldc_w 526
    //   162: invokevirtual 109	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 9
    //   170: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore 13
    //   178: aload 11
    //   180: ldc_w 528
    //   183: invokevirtual 109	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 14
    //   188: aload_0
    //   189: new 155	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   196: aload 12
    //   198: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 13
    //   203: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 14
    //   208: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 10
    //   213: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 266	java/lang/Class:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   222: astore 15
    //   224: aload 15
    //   226: ifnonnull +39 -> 265
    //   229: aload_0
    //   230: new 155	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   237: aload 12
    //   239: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 13
    //   244: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 10
    //   249: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 14
    //   254: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 266	java/lang/Class:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   263: astore 15
    //   265: aload 15
    //   267: ifnonnull +34 -> 301
    //   270: aload_0
    //   271: new 155	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   278: aload 12
    //   280: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 13
    //   285: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 14
    //   290: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokevirtual 266	java/lang/Class:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   299: astore 15
    //   301: aconst_null
    //   302: astore 16
    //   304: aconst_null
    //   305: astore 17
    //   307: aload 15
    //   309: ifnull +79 -> 388
    //   312: invokestatic 530	com/googlecode/javacpp/Loader:getTempDir	()Ljava/io/File;
    //   315: astore 36
    //   317: aload 15
    //   319: aload 36
    //   321: aconst_null
    //   322: aconst_null
    //   323: invokestatic 269	com/googlecode/javacpp/Loader:extractResource	(Ljava/net/URL;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   326: astore 16
    //   328: aload 16
    //   330: invokevirtual 533	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   333: astore 37
    //   335: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   338: aload 7
    //   340: aload 37
    //   342: invokeinterface 534 3 0
    //   347: pop
    //   348: aload 37
    //   350: invokestatic 536	java/lang/System:load	(Ljava/lang/String;)V
    //   353: aload 16
    //   355: ifnull +16 -> 371
    //   358: aload 16
    //   360: invokevirtual 303	java/io/File:exists	()Z
    //   363: ifeq +8 -> 371
    //   366: aload 16
    //   368: invokevirtual 466	java/io/File:deleteOnExit	()V
    //   371: aload 37
    //   373: areturn
    //   374: ldc -36
    //   376: astore 6
    //   378: goto -331 -> 47
    //   381: ldc -36
    //   383: astore 10
    //   385: goto -267 -> 118
    //   388: iconst_0
    //   389: istore 18
    //   391: aload_1
    //   392: ifnull +234 -> 626
    //   395: aload_1
    //   396: arraylength
    //   397: istore 27
    //   399: aconst_null
    //   400: astore 16
    //   402: iload 18
    //   404: iload 27
    //   406: if_icmpge +220 -> 626
    //   409: new 284	java/io/File
    //   412: dup
    //   413: aload_1
    //   414: iload 18
    //   416: aaload
    //   417: new 155	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   424: aload 13
    //   426: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 14
    //   431: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 10
    //   436: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: astore 28
    //   447: aload 28
    //   449: invokevirtual 303	java/io/File:exists	()Z
    //   452: istore 29
    //   454: aconst_null
    //   455: astore 16
    //   457: iload 29
    //   459: ifne +41 -> 500
    //   462: new 284	java/io/File
    //   465: dup
    //   466: aload_1
    //   467: iload 18
    //   469: aaload
    //   470: new 155	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   477: aload 13
    //   479: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 10
    //   484: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 14
    //   489: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: astore 28
    //   500: aload 28
    //   502: invokevirtual 303	java/io/File:exists	()Z
    //   505: istore 30
    //   507: aconst_null
    //   508: astore 16
    //   510: iload 30
    //   512: ifne +36 -> 548
    //   515: new 284	java/io/File
    //   518: dup
    //   519: aload_1
    //   520: iload 18
    //   522: aaload
    //   523: new 155	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   530: aload 13
    //   532: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 14
    //   537: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: astore 28
    //   548: aload 28
    //   550: invokevirtual 303	java/io/File:exists	()Z
    //   553: istore 31
    //   555: aconst_null
    //   556: astore 16
    //   558: iload 31
    //   560: ifeq +187 -> 747
    //   563: aload 28
    //   565: invokevirtual 540	java/io/File:getPath	()Ljava/lang/String;
    //   568: astore 32
    //   570: aload 32
    //   572: astore_3
    //   573: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   576: aload 7
    //   578: aload_3
    //   579: invokeinterface 534 3 0
    //   584: pop
    //   585: aload_3
    //   586: invokestatic 536	java/lang/System:load	(Ljava/lang/String;)V
    //   589: iconst_0
    //   590: ifeq -578 -> 12
    //   593: aconst_null
    //   594: invokevirtual 303	java/io/File:exists	()Z
    //   597: ifeq -585 -> 12
    //   600: aconst_null
    //   601: invokevirtual 466	java/io/File:deleteOnExit	()V
    //   604: aload_3
    //   605: areturn
    //   606: astore 33
    //   608: aload 33
    //   610: astore 17
    //   612: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   615: aload 7
    //   617: invokeinterface 543 2 0
    //   622: pop
    //   623: goto +124 -> 747
    //   626: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   629: aload 7
    //   631: aload 9
    //   633: invokeinterface 534 3 0
    //   638: pop
    //   639: aload 9
    //   641: invokestatic 545	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   644: iconst_0
    //   645: ifeq +14 -> 659
    //   648: aconst_null
    //   649: invokevirtual 303	java/io/File:exists	()Z
    //   652: ifeq +7 -> 659
    //   655: aconst_null
    //   656: invokevirtual 466	java/io/File:deleteOnExit	()V
    //   659: aload 9
    //   661: areturn
    //   662: astore 24
    //   664: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   667: aload 7
    //   669: invokeinterface 543 2 0
    //   674: pop
    //   675: aload 17
    //   677: ifnull +29 -> 706
    //   680: aload 17
    //   682: athrow
    //   683: astore 23
    //   685: aload 16
    //   687: ifnull +16 -> 703
    //   690: aload 16
    //   692: invokevirtual 303	java/io/File:exists	()Z
    //   695: ifeq +8 -> 703
    //   698: aload 16
    //   700: invokevirtual 466	java/io/File:deleteOnExit	()V
    //   703: aload 23
    //   705: athrow
    //   706: aload 24
    //   708: athrow
    //   709: astore 19
    //   711: getstatic 57	com/googlecode/javacpp/Loader:loadedLibraries	Ljava/util/Map;
    //   714: aload 7
    //   716: invokeinterface 543 2 0
    //   721: pop
    //   722: new 472	java/lang/UnsatisfiedLinkError
    //   725: dup
    //   726: aload 19
    //   728: invokevirtual 546	java/io/IOException:toString	()Ljava/lang/String;
    //   731: invokespecial 547	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   734: astore 21
    //   736: aload 21
    //   738: aload 19
    //   740: invokevirtual 505	java/lang/Error:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   743: pop
    //   744: aload 21
    //   746: athrow
    //   747: iinc 18 1
    //   750: goto -359 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	paramClass	Class
    //   0	753	1	paramArrayOfString	String[]
    //   0	753	2	paramString	String
    //   11	594	3	localObject1	Object
    //   18	18	4	str1	String
    //   27	15	5	i	int
    //   45	332	6	str2	String
    //   66	649	7	str3	String
    //   93	19	8	arrayOfString	String[]
    //   99	561	9	str4	String
    //   116	367	10	str5	String
    //   121	58	11	localProperties	java.util.Properties
    //   148	131	12	str6	String
    //   176	355	13	str7	String
    //   186	350	14	str8	String
    //   222	96	15	localURL	java.net.URL
    //   302	397	16	localFile1	File
    //   305	376	17	localObject2	Object
    //   389	359	18	j	int
    //   709	30	19	localIOException	IOException
    //   734	11	21	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   683	21	23	localObject3	Object
    //   662	45	24	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   397	10	27	k	int
    //   445	119	28	localFile2	File
    //   452	6	29	bool1	boolean
    //   505	6	30	bool2	boolean
    //   553	6	31	bool3	boolean
    //   568	3	32	str9	String
    //   606	3	33	localUnsatisfiedLinkError3	UnsatisfiedLinkError
    //   315	5	36	localFile3	File
    //   333	39	37	str10	String
    // Exception table:
    //   from	to	target	type
    //   573	589	606	java/lang/UnsatisfiedLinkError
    //   312	353	662	java/lang/UnsatisfiedLinkError
    //   395	399	662	java/lang/UnsatisfiedLinkError
    //   409	454	662	java/lang/UnsatisfiedLinkError
    //   462	500	662	java/lang/UnsatisfiedLinkError
    //   500	507	662	java/lang/UnsatisfiedLinkError
    //   515	548	662	java/lang/UnsatisfiedLinkError
    //   548	555	662	java/lang/UnsatisfiedLinkError
    //   563	570	662	java/lang/UnsatisfiedLinkError
    //   612	623	662	java/lang/UnsatisfiedLinkError
    //   626	644	662	java/lang/UnsatisfiedLinkError
    //   312	353	683	finally
    //   395	399	683	finally
    //   409	454	683	finally
    //   462	500	683	finally
    //   500	507	683	finally
    //   515	548	683	finally
    //   548	555	683	finally
    //   563	570	683	finally
    //   573	589	683	finally
    //   612	623	683	finally
    //   626	644	683	finally
    //   664	675	683	finally
    //   680	683	683	finally
    //   706	709	683	finally
    //   711	747	683	finally
    //   312	353	709	java/io/IOException
    //   395	399	709	java/io/IOException
    //   409	454	709	java/io/IOException
    //   462	500	709	java/io/IOException
    //   500	507	709	java/io/IOException
    //   515	548	709	java/io/IOException
    //   548	555	709	java/io/IOException
    //   563	570	709	java/io/IOException
    //   573	589	709	java/io/IOException
    //   612	623	709	java/io/IOException
    //   626	644	709	java/io/IOException
  }
  
  public static String loadLibrary(String paramString)
  {
    return loadLibrary(getCallerClass(2), null, paramString);
  }
  
  public static String loadLibrary(String[] paramArrayOfString, String paramString)
  {
    return loadLibrary(getCallerClass(2), paramArrayOfString, paramString);
  }
  
  public static void main(String[] paramArrayOfString)
  {
    File localFile1 = new File(System.getProperty("java.io.tmpdir"));
    File localFile2 = new File(paramArrayOfString[0]);
    if ((!localFile1.equals(localFile2.getParentFile())) || (!localFile2.getName().startsWith("javacpp"))) {
      return;
    }
    for (File localFile3 : localFile2.listFiles()) {
      while ((localFile3.exists()) && (!localFile3.delete())) {
        try
        {
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
    localFile2.delete();
  }
  
  public static int offsetof(Class<? extends Pointer> paramClass, String paramString)
  {
    return ((Integer)((HashMap)memberOffsets.get(paramClass)).get(paramString)).intValue();
  }
  
  static void putMemberOffset(Class<? extends Pointer> paramClass, String paramString, int paramInt)
  {
    try
    {
      HashMap localHashMap = (HashMap)memberOffsets.get(paramClass);
      if (localHashMap == null)
      {
        WeakHashMap localWeakHashMap = memberOffsets;
        localHashMap = new HashMap();
        localWeakHashMap.put(paramClass, localHashMap);
      }
      localHashMap.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  static void putMemberOffset(String paramString1, String paramString2, int paramInt)
    throws ClassNotFoundException
  {
    putMemberOffset(Class.forName(paramString1.replace('/', '.'), false, Loader.class.getClassLoader()).asSubclass(Pointer.class), paramString2, paramInt);
  }
  
  public static void setPlatformName(String paramString)
  {
    platformName = paramString;
    platformProperties = null;
  }
  
  public static int sizeof(Class<? extends Pointer> paramClass)
  {
    return ((Integer)((HashMap)memberOffsets.get(paramClass)).get("sizeof")).intValue();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */