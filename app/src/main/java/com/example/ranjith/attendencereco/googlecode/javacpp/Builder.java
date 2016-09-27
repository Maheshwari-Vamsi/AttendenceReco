package com.example.ranjith.attendencereco.googlecode.javacpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

public class Builder
{
  UserClassLoader classLoader = null;
  ClassScanner classScanner = null;
  LinkedList<Class> classes = null;
  boolean compile = true;
  LinkedList<String> compilerOptions = null;
  Map<String, String> environmentVariables = null;
  boolean header = false;
  String jarPrefix = null;
  File outputDirectory = null;
  String outputName = null;
  Properties properties = null;
  
  public Builder()
  {
    Loader.loadLibraries = false;
    this.classLoader = new UserClassLoader(Thread.currentThread().getContextClassLoader());
    this.properties = Loader.getProperties();
    this.classes = new LinkedList();
    this.classScanner = new ClassScanner(this.classes, this.classLoader);
    this.compilerOptions = new LinkedList();
  }
  
  public static void createJar(File paramFile, String[] paramArrayOfString, LinkedList<File> paramLinkedList)
    throws IOException
  {
    System.out.println("Creating JAR file: " + paramFile);
    JarOutputStream localJarOutputStream = new JarOutputStream(new FileOutputStream(paramFile));
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      String str1 = localFile.getPath();
      if (paramArrayOfString != null)
      {
        String[] arrayOfString = new String[paramArrayOfString.length];
        for (int j = 0; j < paramArrayOfString.length; j++)
        {
          String str2 = new File(paramArrayOfString[j]).getCanonicalPath();
          if (str1.startsWith(str2)) {
            arrayOfString[j] = str1.substring(1 + str2.length());
          }
        }
        for (int k = 0; k < arrayOfString.length; k++) {
          if ((arrayOfString[k] != null) && (arrayOfString[k].length() < str1.length())) {
            str1 = arrayOfString[k];
          }
        }
      }
      ZipEntry localZipEntry = new ZipEntry(str1.replace(File.separatorChar, '/'));
      localZipEntry.setTime(localFile.lastModified());
      localJarOutputStream.putNextEntry(localZipEntry);
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localJarOutputStream.write(arrayOfByte, 0, i);
      }
      localFileInputStream.close();
      localJarOutputStream.closeEntry();
    }
    localJarOutputStream.close();
  }
  
  public static void includeJavaPaths(Properties paramProperties)
  {
    String str1 = Loader.getPlatformName();
    String str2 = paramProperties.getProperty("path.separator");
    final String str3 = paramProperties.getProperty("compiler.link.prefix", "") + "jvm" + paramProperties.getProperty("compiler.link.suffix", "");
    final String str4 = paramProperties.getProperty("library.prefix", "") + "jvm" + paramProperties.getProperty("library.suffix", "");
    String[] arrayOfString1 = new String[2];
    final String[] arrayOfString2 = new String[2];
    FilenameFilter local1 = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        if (new File(paramAnonymousFile, "jni.h").exists()) {
          this.val$jnipath[0] = paramAnonymousFile.getAbsolutePath();
        }
        if (new File(paramAnonymousFile, "jni_md.h").exists()) {
          this.val$jnipath[1] = paramAnonymousFile.getAbsolutePath();
        }
        if (new File(paramAnonymousFile, str3).exists()) {
          arrayOfString2[0] = paramAnonymousFile.getAbsolutePath();
        }
        if (new File(paramAnonymousFile, str4).exists()) {
          arrayOfString2[1] = paramAnonymousFile.getAbsolutePath();
        }
        return new File(paramAnonymousFile, paramAnonymousString).isDirectory();
      }
    };
    Object localObject1 = new File(System.getProperty("java.home")).getParentFile();
    try
    {
      File localFile4 = ((File)localObject1).getCanonicalFile();
      localObject1 = localFile4;
    }
    catch (IOException localIOException1)
    {
      LinkedList localLinkedList;
      for (;;) {}
    }
    localLinkedList = new LinkedList(Arrays.asList(((File)localObject1).listFiles(local1)));
    while (!localLinkedList.isEmpty())
    {
      File localFile2 = (File)localLinkedList.pop();
      String str5 = localFile2.getPath();
      for (Object localObject2 : localFile2.listFiles(local1))
      {
        try
        {
          File localFile3 = ((File)localObject2).getCanonicalFile();
          localObject2 = localFile3;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
        if (!str5.startsWith(((File)localObject2).getPath())) {
          localLinkedList.add(localObject2);
        }
      }
    }
    if ((arrayOfString1[0] != null) && (arrayOfString1[0].equals(arrayOfString1[1]))) {
      arrayOfString1[1] = null;
    }
    for (;;)
    {
      if ((arrayOfString2[0] != null) && (arrayOfString2[0].equals(arrayOfString2[1]))) {
        arrayOfString2[1] = null;
      }
      Loader.appendProperty(paramProperties, "compiler.includepath", str2, arrayOfString1);
      if (str1.equals(paramProperties.getProperty("platform.name", str1)))
      {
        Loader.appendProperty(paramProperties, "compiler.link", str2, new String[] { "jvm" });
        Loader.appendProperty(paramProperties, "compiler.linkpath", str2, arrayOfString2);
        if (str1.startsWith("macosx")) {
          Loader.appendProperty(paramProperties, "compiler.framework", str2, new String[] { "JavaVM" });
        }
      }
      return;
      if (arrayOfString1[0] == null)
      {
        File localFile1 = new File("/System/Library/Frameworks/JavaVM.framework/Headers/");
        if (localFile1.isDirectory()) {
          arrayOfString1[0] = "/System/Library/Frameworks/JavaVM.framework/Headers/";
        }
      }
    }
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    int i = 0;
    Builder localBuilder = new Builder();
    int j = 0;
    if (j < paramArrayOfString.length)
    {
      if (("-help".equals(paramArrayOfString[j])) || ("--help".equals(paramArrayOfString[j])))
      {
        printHelp();
        System.exit(0);
      }
      for (;;)
      {
        j++;
        break;
        if (("-classpath".equals(paramArrayOfString[j])) || ("-cp".equals(paramArrayOfString[j])) || ("-lib".equals(paramArrayOfString[j])))
        {
          j++;
          localBuilder.classPaths(paramArrayOfString[j]);
        }
        else if ("-d".equals(paramArrayOfString[j]))
        {
          j++;
          localBuilder.outputDirectory(paramArrayOfString[j]);
        }
        else if ("-o".equals(paramArrayOfString[j]))
        {
          j++;
          localBuilder.outputName(paramArrayOfString[j]);
        }
        else if (("-cpp".equals(paramArrayOfString[j])) || ("-nocompile".equals(paramArrayOfString[j])))
        {
          localBuilder.compile(false);
        }
        else if ("-header".equals(paramArrayOfString[j]))
        {
          localBuilder.header(true);
        }
        else if ("-jarprefix".equals(paramArrayOfString[j]))
        {
          j++;
          localBuilder.jarPrefix(paramArrayOfString[j]);
        }
        else if ("-properties".equals(paramArrayOfString[j]))
        {
          j++;
          localBuilder.properties(paramArrayOfString[j]);
        }
        else if ("-propertyfile".equals(paramArrayOfString[j]))
        {
          j++;
          localBuilder.propertyFile(paramArrayOfString[j]);
        }
        else if (paramArrayOfString[j].startsWith("-D"))
        {
          localBuilder.property(paramArrayOfString[j]);
        }
        else if ("-Xcompiler".equals(paramArrayOfString[j]))
        {
          String[] arrayOfString2 = new String[1];
          j++;
          arrayOfString2[0] = paramArrayOfString[j];
          localBuilder.compilerOptions(arrayOfString2);
        }
        else if (paramArrayOfString[j].startsWith("-"))
        {
          System.err.println("Error: Invalid option \"" + paramArrayOfString[j] + "\"");
          printHelp();
          System.exit(1);
        }
        else
        {
          String[] arrayOfString1 = new String[1];
          arrayOfString1[0] = paramArrayOfString[j];
          localBuilder.classesOrPackages(arrayOfString1);
          i = 1;
        }
      }
    }
    if (i == 0) {
      localBuilder.classesOrPackages(null);
    }
    localBuilder.build();
  }
  
  public static void printHelp()
  {
    String str = Builder.class.getPackage().getImplementationVersion();
    if (str == null) {
      str = "unknown";
    }
    System.out.println("JavaCPP version " + str + "\n" + "Copyright (C) 2011-2013 Samuel Audet <samuel.audet@gmail.com>\n" + "Project site: http://code.google.com/p/javacpp/\n\n" + "Licensed under the GNU General Public License version 2 (GPLv2) with Classpath exception.\n" + "Please refer to LICENSE.txt or http://www.gnu.org/licenses/ for details.");
    System.out.println();
    System.out.println("Usage: java -jar javacpp.jar [options] [class or package (suffixed with .* or .**)]");
    System.out.println();
    System.out.println("where options include:");
    System.out.println();
    System.out.println("    -classpath <path>      Load user classes from path");
    System.out.println("    -d <directory>         Output all generated files to directory");
    System.out.println("    -o <name>              Output everything in a file named after given name");
    System.out.println("    -nocompile             Do not compile or delete the generated source files");
    System.out.println("    -header                Generate header file with declarations of callbacks functions");
    System.out.println("    -jarprefix <prefix>    Also create a JAR file named \"<prefix>-<platform.name>.jar\"");
    System.out.println("    -properties <resource> Load all properties from resource");
    System.out.println("    -propertyfile <file>   Load all properties from file");
    System.out.println("    -D<property>=<value>   Set property to value");
    System.out.println("    -Xcompiler <option>    Pass option directly to compiler");
    System.out.println();
  }
  
  public Collection<File> build()
    throws IOException, InterruptedException
  {
    if (this.classes.isEmpty()) {
      return null;
    }
    if (this.outputName == null)
    {
      localLinkedList1 = new LinkedList();
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      Iterator localIterator1 = this.classes.iterator();
      while (localIterator1.hasNext())
      {
        Class localClass = (Class)localIterator1.next();
        Properties localProperties = (Properties)this.properties.clone();
        if (Loader.appendProperties(localProperties, localClass) == localClass)
        {
          String str2 = localProperties.getProperty("loader.library", "");
          if (str2.length() != 0)
          {
            LinkedList localLinkedList3 = (LinkedList)localLinkedHashMap.get(str2);
            if (localLinkedList3 == null)
            {
              localLinkedList3 = new LinkedList();
              localLinkedHashMap.put(str2, localLinkedList3);
            }
            localLinkedList3.add(localClass);
          }
        }
      }
      Iterator localIterator2 = localLinkedHashMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        LinkedList localLinkedList2 = (LinkedList)localLinkedHashMap.get(str1);
        File localFile3 = generateAndCompile((Class[])localLinkedList2.toArray(new Class[localLinkedList2.size()]), str1);
        if (localFile3 != null) {
          localLinkedList1.add(localFile3);
        }
      }
    }
    LinkedList localLinkedList1 = new LinkedList();
    File localFile4 = generateAndCompile((Class[])this.classes.toArray(new Class[this.classes.size()]), this.outputName);
    if (localFile4 != null) {
      localLinkedList1.add(localFile4);
    }
    File localFile1;
    if ((this.jarPrefix != null) && (!localLinkedList1.isEmpty()))
    {
      localFile1 = new File(this.jarPrefix + "-" + this.properties.get("platform.name") + ".jar");
      File localFile2 = localFile1.getParentFile();
      if ((localFile2 != null) && (!localFile2.exists())) {
        localFile2.mkdir();
      }
      if (this.outputDirectory != null) {
        break label410;
      }
    }
    label410:
    for (String[] arrayOfString = this.classLoader.getPaths();; arrayOfString = null)
    {
      createJar(localFile1, arrayOfString, localLinkedList1);
      return localLinkedList1;
    }
  }
  
  public Builder classPaths(String paramString)
  {
    if (paramString == null) {}
    for (String[] arrayOfString = null;; arrayOfString = paramString.split(File.pathSeparator))
    {
      classPaths(arrayOfString);
      return this;
    }
  }
  
  public Builder classPaths(String... paramVarArgs)
  {
    this.classLoader.addPaths(paramVarArgs);
    return this;
  }
  
  public Builder classesOrPackages(String... paramVarArgs)
    throws IOException
  {
    if (paramVarArgs == null) {
      this.classScanner.addPackage(null, true);
    }
    for (;;)
    {
      return this;
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramVarArgs[j];
        this.classScanner.addClassOrPackage(str);
      }
    }
  }
  
  public int compile(String paramString1, String paramString2, Properties paramProperties)
    throws IOException, InterruptedException
  {
    LinkedList localLinkedList = new LinkedList();
    includeJavaPaths(paramProperties);
    String str1 = Loader.getPlatformName();
    String str2 = paramProperties.getProperty("path.separator");
    String str3 = paramProperties.getProperty("platform.root");
    if ((str3 == null) || (str3.length() == 0)) {
      str3 = ".";
    }
    String str4 = File.separator;
    if (!str3.endsWith(str4)) {
      str3 = str3 + File.separator;
    }
    String str5 = paramProperties.getProperty("compiler.path");
    if (str3 != null)
    {
      File localFile1 = new File(str5);
      if ((!localFile1.isAbsolute()) && (new File(str3 + str5).exists())) {
        str5 = str3 + str5;
      }
    }
    localLinkedList.add(str5);
    String str6 = paramProperties.getProperty("compiler.sysroot");
    if ((str6 != null) && (str6.length() > 0))
    {
      String str27 = paramProperties.getProperty("compiler.sysroot.prefix", "");
      String[] arrayOfString6 = str6.split(str2);
      int i5 = arrayOfString6.length;
      int i6 = 0;
      if (i6 < i5)
      {
        String str28 = arrayOfString6[i6];
        if (str3 != null)
        {
          File localFile6 = new File(str28);
          if (!localFile6.isAbsolute()) {
            str28 = str3 + str28;
          }
        }
        File localFile7 = new File(str28);
        if (localFile7.isDirectory())
        {
          if (!str27.endsWith(" ")) {
            break label352;
          }
          localLinkedList.add(str27.trim());
          localLinkedList.add(str28);
        }
        for (;;)
        {
          i6++;
          break;
          label352:
          localLinkedList.add(str27 + str28);
        }
      }
    }
    String str7 = paramProperties.getProperty("compiler.includepath");
    if ((str7 != null) && (str7.length() > 0))
    {
      String str25 = paramProperties.getProperty("compiler.includepath.prefix", "");
      String[] arrayOfString5 = str7.split(str2);
      int i3 = arrayOfString5.length;
      int i4 = 0;
      if (i4 < i3)
      {
        String str26 = arrayOfString5[i4];
        if (str3 != null)
        {
          File localFile4 = new File(str26);
          if (!localFile4.isAbsolute()) {
            str26 = str3 + str26;
          }
        }
        File localFile5 = new File(str26);
        if (localFile5.isDirectory())
        {
          if (!str25.endsWith(" ")) {
            break label546;
          }
          localLinkedList.add(str25.trim());
          localLinkedList.add(str26);
        }
        for (;;)
        {
          i4++;
          break;
          label546:
          localLinkedList.add(str25 + str26);
        }
      }
    }
    localLinkedList.add(paramString1);
    String str8 = paramProperties.getProperty("compiler.options");
    if ((str8 != null) && (str8.length() > 0)) {
      localLinkedList.addAll(Arrays.asList(str8.split(" ")));
    }
    localLinkedList.addAll(this.compilerOptions);
    String str9 = paramProperties.getProperty("compiler.output.prefix");
    if ((str9 != null) && (str9.length() > 0)) {
      localLinkedList.addAll(Arrays.asList(str9.split(" ")));
    }
    String str22;
    String str23;
    int i2;
    label760:
    String str24;
    if ((str9 == null) || (str9.length() == 0) || (str9.endsWith(" ")))
    {
      localLinkedList.add(paramString2);
      String str10 = paramProperties.getProperty("compiler.linkpath");
      if ((str10 == null) || (str10.length() <= 0)) {
        break label1002;
      }
      str22 = paramProperties.getProperty("compiler.linkpath.prefix", "");
      str23 = paramProperties.getProperty("compiler.linkpath.prefix2");
      String[] arrayOfString4 = str10.split(str2);
      int i1 = arrayOfString4.length;
      i2 = 0;
      if (i2 >= i1) {
        break label1002;
      }
      str24 = arrayOfString4[i2];
      if (str3 != null)
      {
        File localFile2 = new File(str24);
        if (!localFile2.isAbsolute()) {
          str24 = str3 + str24;
        }
      }
      File localFile3 = new File(str24);
      if (localFile3.isDirectory())
      {
        if (!str22.endsWith(" ")) {
          break label944;
        }
        localLinkedList.add(str22.trim());
        localLinkedList.add(str24);
        label869:
        if (str23 != null)
        {
          if (!str23.endsWith(" ")) {
            break label973;
          }
          localLinkedList.add(str23.trim());
          localLinkedList.add(str24);
        }
      }
    }
    for (;;)
    {
      i2++;
      break label760;
      localLinkedList.add((String)localLinkedList.removeLast() + paramString2);
      break;
      label944:
      localLinkedList.add(str22 + str24);
      break label869;
      label973:
      localLinkedList.add(str23 + str24);
    }
    label1002:
    String str11 = paramProperties.getProperty("compiler.link");
    if ((str11 != null) && (str11.length() > 0))
    {
      String str19 = paramProperties.getProperty("compiler.link.prefix", "");
      String str20 = paramProperties.getProperty("compiler.link.suffix", "");
      String[] arrayOfString2 = str11.split(str2);
      int m = arrayOfString2.length;
      int n = 0;
      if (n < m)
      {
        String[] arrayOfString3 = arrayOfString2[n].split("@");
        String str21;
        if ((arrayOfString3.length == 3) && (arrayOfString3[1].length() == 0))
        {
          str21 = arrayOfString3[0] + arrayOfString3[2];
          label1124:
          if ((!str19.endsWith(" ")) || (!str20.startsWith(" "))) {
            break label1191;
          }
          localLinkedList.add(str19.trim());
          localLinkedList.add(str21);
          localLinkedList.add(str20.trim());
        }
        for (;;)
        {
          n++;
          break;
          str21 = arrayOfString3[0];
          break label1124;
          label1191:
          if (str19.endsWith(" "))
          {
            localLinkedList.add(str19.trim());
            localLinkedList.add(str21 + str20);
          }
          else if (str20.startsWith(" "))
          {
            localLinkedList.add(str19 + str21);
            localLinkedList.add(str20.trim());
          }
          else
          {
            localLinkedList.add(str19 + str21 + str20);
          }
        }
      }
    }
    String str12 = paramProperties.getProperty("compiler.framework");
    if ((str12 != null) && (str12.length() > 0))
    {
      String str16 = paramProperties.getProperty("compiler.framework.prefix", "");
      String str17 = paramProperties.getProperty("compiler.framework.suffix", "");
      String[] arrayOfString1 = str12.split(str2);
      int j = arrayOfString1.length;
      int k = 0;
      if (k < j)
      {
        String str18 = arrayOfString1[k];
        if ((str16.endsWith(" ")) && (str17.startsWith(" ")))
        {
          localLinkedList.add(str16.trim());
          localLinkedList.add(str18);
          localLinkedList.add(str17.trim());
        }
        for (;;)
        {
          k++;
          break;
          if (str16.endsWith(" "))
          {
            localLinkedList.add(str16.trim());
            localLinkedList.add(str18 + str17);
          }
          else if (str17.startsWith(" "))
          {
            localLinkedList.add(str16 + str18);
            localLinkedList.add(str17.trim());
          }
          else
          {
            localLinkedList.add(str16 + str18 + str17);
          }
        }
      }
    }
    boolean bool = str1.startsWith("windows");
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      String str13 = (String)localIterator.next();
      int i;
      label1649:
      String str15;
      label1669:
      PrintStream localPrintStream1;
      if (str13.indexOf(" ") > 0)
      {
        i = 1;
        if (i != 0)
        {
          PrintStream localPrintStream2 = System.out;
          if (!bool) {
            break label1729;
          }
          str15 = "\"";
          localPrintStream2.print(str15);
        }
        System.out.print(str13);
        if (i != 0)
        {
          localPrintStream1 = System.out;
          if (!bool) {
            break label1737;
          }
        }
      }
      label1729:
      label1737:
      for (String str14 = "\"";; str14 = "'")
      {
        localPrintStream1.print(str14);
        System.out.print(" ");
        break;
        i = 0;
        break label1649;
        str15 = "'";
        break label1669;
      }
    }
    System.out.println();
    ProcessBuilder localProcessBuilder = new ProcessBuilder(localLinkedList);
    if (this.environmentVariables != null) {
      localProcessBuilder.environment().putAll(this.environmentVariables);
    }
    Process localProcess = localProcessBuilder.start();
    new Piper(localProcess.getErrorStream(), System.err).start();
    new Piper(localProcess.getInputStream(), System.out).start();
    return localProcess.waitFor();
  }
  
  public Builder compile(boolean paramBoolean)
  {
    this.compile = paramBoolean;
    return this;
  }
  
  public Builder compilerOptions(String... paramVarArgs)
  {
    if (paramVarArgs != null) {
      this.compilerOptions.addAll(Arrays.asList(paramVarArgs));
    }
    return this;
  }
  
  public Builder environmentVariables(Map<String, String> paramMap)
  {
    this.environmentVariables = paramMap;
    return this;
  }
  
  public File generateAndCompile(Class[] paramArrayOfClass, String paramString)
    throws IOException, InterruptedException
  {
    Properties localProperties = (Properties)this.properties.clone();
    int i = paramArrayOfClass.length;
    for (int j = 0; j < i; j++) {
      Loader.appendProperties(localProperties, paramArrayOfClass[j]);
    }
    String str1 = localProperties.getProperty("platform.name");
    String str2 = localProperties.getProperty("source.suffix", ".cpp");
    String str3 = localProperties.getProperty("library.prefix", "") + paramString + localProperties.getProperty("library.suffix", "");
    if (this.outputDirectory == null) {}
    File localFile1;
    Generator localGenerator;
    String str5;
    String str6;
    String str7;
    for (;;)
    {
      try
      {
        File localFile3 = new File(paramArrayOfClass[0].getResource('/' + paramArrayOfClass[0].getName().replace('.', '/') + ".class").toURI()).getParentFile();
        localFile1 = new File(localFile3, str1);
        String str10 = localFile3.getPath() + File.separator + paramString;
        str4 = str10;
        if (!localFile1.exists()) {
          localFile1.mkdirs();
        }
        localGenerator = new Generator(localProperties);
        str5 = str4 + str2;
        if (!this.header) {
          break label415;
        }
        str6 = str4 + ".h";
        str7 = System.getProperty("java.class.path");
        String[] arrayOfString = this.classLoader.getPaths();
        int k = arrayOfString.length;
        int m = 0;
        if (m >= k) {
          break;
        }
        String str9 = arrayOfString[m];
        str7 = str7 + File.pathSeparator + str9;
        m++;
        continue;
        RuntimeException localRuntimeException;
        localFile1 = this.outputDirectory;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        localRuntimeException = new RuntimeException(localURISyntaxException);
        throw localRuntimeException;
      }
      String str4 = localFile1.getPath() + File.separator + paramString;
      continue;
      label415:
      str6 = null;
    }
    System.out.println("Generating source file: " + str5);
    if (localGenerator.generate(str5, str6, str7, paramArrayOfClass))
    {
      localGenerator.close();
      if (this.compile)
      {
        String str8 = localFile1.getPath() + File.separator + str3;
        System.out.println("Building library file: " + str8);
        int n = compile(str5, str8, localProperties);
        if (n == 0)
        {
          File localFile2 = new File(str5);
          localFile2.delete();
          return new File(str8);
        }
        System.exit(n);
        return null;
      }
      return new File(str5);
    }
    System.out.println("Source file not generated: " + str5);
    return null;
  }
  
  public Builder header(boolean paramBoolean)
  {
    this.header = paramBoolean;
    return this;
  }
  
  public Builder jarPrefix(String paramString)
  {
    this.jarPrefix = paramString;
    return this;
  }
  
  public Builder outputDirectory(File paramFile)
  {
    this.outputDirectory = paramFile;
    return this;
  }
  
  public Builder outputDirectory(String paramString)
  {
    if (paramString == null) {}
    for (File localFile = null;; localFile = new File(paramString))
    {
      outputDirectory(localFile);
      return this;
    }
  }
  
  public Builder outputName(String paramString)
  {
    this.outputName = paramString;
    return this;
  }
  
  public Builder properties(String paramString)
  {
    if (paramString == null) {}
    for (Properties localProperties = null;; localProperties = Loader.getProperties(paramString))
    {
      properties(localProperties);
      return this;
    }
  }
  
  public Builder properties(Properties paramProperties)
  {
    if (paramProperties != null) {
      this.properties.putAll(paramProperties);
    }
    return this;
  }
  
  public Builder property(String paramString)
  {
    int i = paramString.indexOf('=');
    if (i < 0) {
      i = paramString.indexOf(':');
    }
    property(paramString.substring(2, i), paramString.substring(i + 1));
    return this;
  }
  
  public Builder property(String paramString1, String paramString2)
  {
    if ((paramString1.length() > 0) && (paramString2.length() > 0)) {
      this.properties.put(paramString1, paramString2);
    }
    return this;
  }
  
  public Builder propertyFile(File paramFile)
    throws IOException
  {
    if (paramFile == null) {
      return this;
    }
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    this.properties = new Properties(this.properties);
    try
    {
      this.properties.load(new InputStreamReader(localFileInputStream));
      localFileInputStream.close();
      return this;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        this.properties.load(localFileInputStream);
      }
    }
  }
  
  public Builder propertyFile(String paramString)
    throws IOException
  {
    if (paramString == null) {}
    for (File localFile = null;; localFile = new File(paramString))
    {
      propertyFile(localFile);
      return this;
    }
  }
  
  public static class ClassScanner
  {
    private Collection<Class> classes;
    private UserClassLoader loader;
    
    public ClassScanner(Collection<Class> paramCollection, UserClassLoader paramUserClassLoader)
    {
      this.classes = paramCollection;
      this.loader = paramUserClassLoader;
    }
    
    public void addClass(String paramString)
    {
      if (paramString == null) {}
      for (;;)
      {
        return;
        if (paramString.endsWith(".class")) {
          paramString = paramString.substring(0, -6 + paramString.length());
        }
        try
        {
          Class localClass = Class.forName(paramString, false, this.loader);
          if (!this.classes.contains(localClass))
          {
            this.classes.add(localClass);
            return;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          System.err.println("Warning: Could not find class " + paramString + ": " + localClassNotFoundException);
          return;
        }
        catch (NoClassDefFoundError localNoClassDefFoundError)
        {
          System.err.println("Warning: Could not load class " + paramString + ": " + localNoClassDefFoundError);
        }
      }
    }
    
    public void addClassOrPackage(String paramString)
      throws IOException
    {
      if (paramString == null) {
        return;
      }
      String str = paramString.replace('/', '.');
      if (str.endsWith(".**"))
      {
        addPackage(str.substring(0, -3 + str.length()), true);
        return;
      }
      if (str.endsWith(".*"))
      {
        addPackage(str.substring(0, -2 + str.length()), false);
        return;
      }
      addClass(str);
    }
    
    public void addMatchingDir(String paramString1, File paramFile, String paramString2, boolean paramBoolean)
    {
      File[] arrayOfFile = paramFile.listFiles();
      Arrays.sort(arrayOfFile);
      int i = arrayOfFile.length;
      int j = 0;
      if (j < i)
      {
        File localFile = arrayOfFile[j];
        String str;
        if (paramString1 == null)
        {
          str = localFile.getName();
          label44:
          if (!localFile.isDirectory()) {
            break label114;
          }
          addMatchingDir(str + "/", localFile, paramString2, paramBoolean);
        }
        for (;;)
        {
          j++;
          break;
          str = paramString1 + localFile.getName();
          break label44;
          label114:
          addMatchingFile(str, paramString2, paramBoolean);
        }
      }
    }
    
    public void addMatchingFile(String paramString1, String paramString2, boolean paramBoolean)
    {
      if ((paramString1 != null) && (paramString1.endsWith(".class")) && ((paramString2 == null) || ((paramBoolean) && (paramString1.startsWith(paramString2))) || (paramString1.regionMatches(0, paramString2, 0, Math.max(paramString1.lastIndexOf('/'), paramString2.lastIndexOf('/')))))) {
        addClass(paramString1.replace('/', '.'));
      }
    }
    
    public void addPackage(String paramString, boolean paramBoolean)
      throws IOException
    {
      String[] arrayOfString = this.loader.getPaths();
      String str;
      int i;
      int k;
      label33:
      File localFile;
      if (paramString == null)
      {
        str = null;
        i = this.classes.size();
        int j = arrayOfString.length;
        k = 0;
        if (k >= j) {
          break label173;
        }
        localFile = new File(arrayOfString[k]);
        if (!localFile.isDirectory()) {
          break label108;
        }
        addMatchingDir(null, localFile, str, paramBoolean);
      }
      for (;;)
      {
        k++;
        break label33;
        str = paramString.replace('.', '/') + "/";
        break;
        label108:
        JarInputStream localJarInputStream = new JarInputStream(new FileInputStream(localFile));
        for (ZipEntry localZipEntry = localJarInputStream.getNextEntry(); localZipEntry != null; localZipEntry = localJarInputStream.getNextEntry())
        {
          addMatchingFile(localZipEntry.getName(), str, paramBoolean);
          localJarInputStream.closeEntry();
        }
        localJarInputStream.close();
      }
      label173:
      if ((this.classes.size() == 0) && (paramString == null))
      {
        System.err.println("Warning: No classes found in the unnamed package");
        Builder.printHelp();
      }
      while ((i != this.classes.size()) || (paramString == null)) {
        return;
      }
      System.err.println("Warning: No classes found in package " + paramString);
    }
  }
  
  public static class Piper
    extends Thread
  {
    InputStream is;
    OutputStream os;
    
    public Piper(InputStream paramInputStream, OutputStream paramOutputStream)
    {
      this.is = paramInputStream;
      this.os = paramOutputStream;
    }
    
    public void run()
    {
      try
      {
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          int i = this.is.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          this.os.write(arrayOfByte, 0, i);
        }
        return;
      }
      catch (IOException localIOException)
      {
        System.err.println("Could not pipe from the InputStream to the OutputStream: " + localIOException.getMessage());
      }
    }
  }
  
  public static class UserClassLoader
    extends URLClassLoader
  {
    private LinkedList<String> paths = new LinkedList();
    
    public UserClassLoader()
    {
      super();
    }
    
    public UserClassLoader(ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
    }
    
    public void addPaths(String... paramVarArgs)
    {
      if (paramVarArgs == null) {
        return;
      }
      int i = paramVarArgs.length;
      int j = 0;
      while (j < i)
      {
        String str = paramVarArgs[j];
        this.paths.add(str);
        try
        {
          addURL(new File(str).toURI().toURL());
          j++;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          throw new RuntimeException(localMalformedURLException);
        }
      }
    }
    
    protected Class<?> findClass(String paramString)
      throws ClassNotFoundException
    {
      if (this.paths.isEmpty())
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = System.getProperty("user.dir");
        addPaths(arrayOfString);
      }
      return super.findClass(paramString);
    }
    
    public String[] getPaths()
    {
      if (this.paths.isEmpty())
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = System.getProperty("user.dir");
        addPaths(arrayOfString);
      }
      return (String[])this.paths.toArray(new String[this.paths.size()]);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */