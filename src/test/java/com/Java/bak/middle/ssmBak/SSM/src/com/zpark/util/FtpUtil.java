package com.Java.bak.middle.ssmBak.SSM.src.com.zpark.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {
	 
	  /** 
	   * FTP server configuration--IP key,value is type of String 
	   */ 
	  public static final String SERVER_IP = "SERVER_IP"; 
	 
	  /** 
	   * FTP server configuration--Port key,value is type of Integer 
	   */ 
	  public static final String SERVER_PORT = "SERVER_PORT"; 
	 
	  /** 
	   * FTP server configuration--ANONYMOUS Log in key, value is type of Boolean 
	   */ 
	  public static final String IS_ANONYMOUS = "IS_ANONYMOUS"; 
	 
	  /** 
	   * user name of anonymous log in 
	   */ 
	  public static final String ANONYMOUS_USER_NAME = "anonymous"; 
	 
	  /** 
	   * password of anonymous log in 
	   */ 
	  public static final String ANONYMOUS_PASSWORD = ""; 
	 
	  /** 
	   * FTP server configuration--log in user name, value is type of String 
	   */ 
	  public static final String USER_NAME = "USER_NAME"; 
	 
	  /** 
	   * FTP server configuration--log in password, value is type of String 
	   */ 
	  public static final String PASSWORD = "PASSWORD"; 
	 
	  /** 
	   * FTP server configuration--PASV key, value is type of Boolean 
	   */ 
	  public static final String IS_PASV = "IS_PASV"; 
	 
	  /** 
	   * FTP server configuration--working directory key, value is type of String While logging in, the current directory 
	   * is the user's home directory, the workingDirectory must be set based on it. Besides, the workingDirectory must 
	   * exist, it can not be created automatically. If not exist, file will be uploaded in the user's home directory. If 
	   * not assigned, "/" is used. 
	   */ 
	  public static final String WORKING_DIRECTORY = "WORKING_DIRECTORY"; 
	   
	 
	  public static Map<String, Object> serverCfg = new HashMap<String, Object>(); 
	   
	  static Properties prop; 
	   
	  static{ 
	    prop = new Properties(); 
	    try { 
	      InputStream fps = FtpUtil.class.getResourceAsStream("/ftp.properties"); 
	      prop.load(fps); 
	      fps.close(); 
	    } catch (Exception e) { 
	    } 
	    serverCfg.put(FtpUtil.SERVER_IP, values("SERVER_IP")); 
	    serverCfg.put(FtpUtil.SERVER_PORT, Integer.parseInt(values("SERVER_PORT"))); 
	    serverCfg.put(FtpUtil.USER_NAME, values("USER_NAME")); 
	    serverCfg.put(FtpUtil.PASSWORD, values("PASSWORD")); 
	  } 
	 
	  /** 
	   * Upload a file to FTP server. 
	   * 
	   * @param serverCfg : FTP server configuration 
	   * @param filePathToUpload : path of the file to upload 
	   * @param fileStoredName : the name to give the remote stored file, null, "" and other blank word will be replaced 
	   *      by the file name to upload 
	   * @throws IOException 
	   * @throws SocketException 
	   */ 
	  public static final void upload(Map<String,Object> serverCfg, String filePathToUpload, String fileStoredName) 
	      throws Exception { 
	    //upload(serverCfg, new File(filePathToUpload), fileStoredName); 
	  } 
	 
	  /** 
	   * Upload a file to FTP server. 
	   * 
	   * @param serverCfg : FTP server configuration 
	   * @param fileToUpload : file to upload 
	   * @param fileStoredName : the name to give the remote stored file, null, "" and other blank word will be replaced 
	   *      by the file name to upload 
	   * @throws IOException 
	   * @throws SocketException 
	   */ 
	  public static final void upload(Map<String, Object> serverCfg, InputStream fileToUpload, String fileStoredName) 
	      throws SocketException, IOException { 
	   /* if (!fileToUpload.exists()) { 
	      throw new IllegalArgumentException("File to upload does not exists：" + fileToUpload.getAbsolutePath ()); 
	    } 
	    if (!fileToUpload.isFile()) { 
	      throw new IllegalArgumentException("File to upload is not a file:" + fileToUpload.getAbsolutePath()); 
	    } */
	    if (StringUtils.isBlank((String) serverCfg.get(SERVER_IP))) { 
	      throw new IllegalArgumentException("SERVER_IP must be contained in the FTP server configuration."); 
	    } 
	    transferFile(true, serverCfg, fileToUpload, fileStoredName, null, null); 
	  } 
	 
	  /** 
	   * Download a file from FTP server 
	   * 
	   * @param serverCfg : FTP server configuration 
	   * @param fileNameToDownload : file name to be downloaded 
	   * @param fileStoredPath : stored path of the downloaded file in local 
	   * @throws SocketException 
	   * @throws IOException 
	   */ 
	 /* public static final void download(Map<String, Object> serverCfg, String fileNameToDownload, String fileStoredPath) 
	      throws SocketException, IOException { 
	    if (StringUtils.isBlank(fileNameToDownload)) { 
	      throw new IllegalArgumentException("File name to be downloaded can not be blank."); 
	    } 
	    if (StringUtils.isBlank(fileStoredPath)) { 
	      throw new IllegalArgumentException("Stored path of the downloaded file in local can not be blank."); 
	    } 
	    if (StringUtils.isBlank((String) serverCfg.get(SERVER_IP))) { 
	      throw new IllegalArgumentException("SERVER_IP must be contained in the FTP server configuration."); 
	    } 
	    transferFile(false, serverCfg, null, null, fileNameToDownload, fileStoredPath); 
	  }*/ 
	 
	  private static final void transferFile(boolean isUpload, Map<String, Object> serverCfg, InputStream fileToUpload, 
	      String serverFileStoredName, String fileNameToDownload, String localFileStoredPath) throws  
	      SocketException, 
	      IOException { 
	    String host = (String) serverCfg.get(SERVER_IP); 
	    Integer port = (Integer) serverCfg.get(SERVER_PORT); 
	    Boolean isAnonymous = (Boolean) serverCfg.get(IS_ANONYMOUS); 
	    String username = (String) serverCfg.get(USER_NAME); 
	    String password = (String) serverCfg.get(PASSWORD); 
	    Boolean isPASV = (Boolean) serverCfg.get(IS_PASV); 
	    String workingDirectory = (String) serverCfg.get(WORKING_DIRECTORY); 
	    FTPClient ftpClient = new FTPClient(); 
	    InputStream fileIn = null; 
	    OutputStream fileOut = null; 
	    try { 
	      if (port == null) { 
	        ftpClient.connect(host); 
	      } else { 
	        ftpClient.connect(host, port); 
	      } 
	      int reply = ftpClient.getReplyCode(); 
	      if (!FTPReply.isPositiveCompletion(reply)) { 
	        return; 
	      } 
	 
	     /* if (isAnonymous != null && isAnonymous) { 
	        username = ANONYMOUS_USER_NAME; 
	        password = ANONYMOUS_PASSWORD; 
	      }*/ 
	      System.out.println("登陆状态"+ftpClient.login(username, password));
	    /*  if (!ftpClient.login(username, password)) { 
	        ftpClient.logout(); 
	        return; 
	      }*/ 
	 
	      // Here we will use the BINARY mode as the transfer file type, 
	      // ASCII mode is not supportted. 
	      ftpClient.setFileType(FTP.BINARY_FILE_TYPE); 
	 
	      ftpClient.enterLocalPassiveMode(); 
	     /* if (isPASV != null && isPASV) { 
	      } else { 
	        ftpClient.enterLocalActiveMode(); 
	      } */
	 
	     /* if (StringUtils.isBlank(workingDirectory)) { 
	        workingDirectory = "/etc/vsftpd/"; 
	      }*/ 
	       
	      //changeWorkingDirectory(ftpClient,workingDirectory); 
	       ftpClient.changeWorkingDirectory("/");
	      if (isUpload) { // upload 
	        if (StringUtils.isBlank(serverFileStoredName)) { 
	          serverFileStoredName = "ddddd.png"; 
	        } 
	        fileIn = fileToUpload; 
	        if (!ftpClient.storeFile(serverFileStoredName, fileIn)) { 
	        	System.out.println("存储失败");
	        } else { 
	        	System.out.println("存储成功");
	        } 
	      } else { // download 
	        // make sure the file directory exists 
	        File fileStored = new File(localFileStoredPath); 
	        if (!fileStored.getParentFile().exists()) { 
	          fileStored.getParentFile().mkdirs(); 
	        } 
	        fileOut = new FileOutputStream(fileStored); 
	        if (!ftpClient.retrieveFile(fileNameToDownload, fileOut)) { 
	        } else { 
	        } 
	      } 
	 
	      ftpClient.noop(); 
	 
	      ftpClient.logout(); 
	 
	    } finally { 
	      if (ftpClient.isConnected()) { 
	        try { 
	          ftpClient.disconnect(); 
	        } catch (IOException f) { 
	        } 
	      } 
	      if (fileIn != null) { 
	        try { 
	          fileIn.close(); 
	        } catch (IOException e) { 
	        } 
	      } 
	      if (fileOut != null) { 
	        try { 
	          fileOut.close(); 
	        } catch (IOException e) { 
	        } 
	      } 
	    } 
	  } 
	  public static final void transferFile(boolean isUpload, Map<String, Object> serverCfg, FileInputStream fileToUpload, 
		      String serverFileStoredName, String fileNameToDownload, String localFileStoredPath) throws  
		      SocketException, 
		      IOException { 
		    String host = (String) serverCfg.get(SERVER_IP); 
		    Integer port = (Integer) serverCfg.get(SERVER_PORT); 
		    Boolean isAnonymous = (Boolean) serverCfg.get(IS_ANONYMOUS); 
		    String username = (String) serverCfg.get(USER_NAME); 
		    String password = (String) serverCfg.get(PASSWORD); 
		    Boolean isPASV = (Boolean) serverCfg.get(IS_PASV); 
		    String workingDirectory = (String) serverCfg.get(WORKING_DIRECTORY); 
		    FTPClient ftpClient = new FTPClient(); 
		    InputStream fileIn = null; 
		    OutputStream fileOut = null; 
		    try { 
		      if (port == null) { 
		        ftpClient.connect(host); 
		      } else { 
		        ftpClient.connect(host, port); 
		      } 
		      int reply = ftpClient.getReplyCode(); 
		      if (!FTPReply.isPositiveCompletion(reply)) { 
		        return; 
		      } 
		 
		      if (isAnonymous != null && isAnonymous) { 
		        username = ANONYMOUS_USER_NAME; 
		        password = ANONYMOUS_PASSWORD; 
		      } 
		      if (!ftpClient.login(username, password)) { 
		        ftpClient.logout(); 
		        return; 
		      } 
		 
		      // Here we will use the BINARY mode as the transfer file type, 
		      // ASCII mode is not supportted. 
		      ftpClient.setFileType(FTP.BINARY_FILE_TYPE); 
		 
		      if (isPASV != null && isPASV) { 
		        ftpClient.enterLocalPassiveMode(); 
		      } else { 
		        ftpClient.enterLocalActiveMode(); 
		      } 
		 
		      if (StringUtils.isBlank(workingDirectory)) { 
		        workingDirectory = "/"; 
		      } 
		       
		      changeWorkingDirectory(ftpClient,workingDirectory); 
		       
		      if (isUpload) { // upload 
		        if (StringUtils.isBlank(serverFileStoredName)) { 
		          serverFileStoredName = "dddd"; 
		        } 
		        if (!ftpClient.storeFile(serverFileStoredName, fileIn)) { 
		        } else { 
		        } 
		      } else { // download 
		        // make sure the file directory exists 
		        File fileStored = new File(localFileStoredPath); 
		        if (!fileStored.getParentFile().exists()) { 
		          fileStored.getParentFile().mkdirs(); 
		        } 
		        fileOut = new FileOutputStream(fileStored); 
		        if (!ftpClient.retrieveFile(fileNameToDownload, fileOut)) { 
		        } else { 
		        } 
		      } 
		 
		      ftpClient.noop(); 
		 
		      ftpClient.logout(); 
		 
		    } finally { 
		      if (ftpClient.isConnected()) { 
		        try { 
		          ftpClient.disconnect(); 
		        } catch (IOException f) { 
		        } 
		      } 
		      if (fileIn != null) { 
		        try { 
		          fileIn.close(); 
		        } catch (IOException e) { 
		        } 
		      } 
		      if (fileOut != null) { 
		        try { 
		          fileOut.close(); 
		        } catch (IOException e) { 
		        } 
		      } 
		    } 
		  } 
		   	   
	  private static final boolean changeWorkingDirectory(FTPClient ftpClient, String workingDirectory) throws IOException{ 
	    if(!ftpClient.changeWorkingDirectory(workingDirectory)){ 
	      String [] paths = workingDirectory.split("/"); 
	      for(int i=0 ;i<paths.length ;i++){ 
	        if(!"".equals(paths[i])){ 
	          if(!ftpClient.changeWorkingDirectory(paths[i])){ 
	            ftpClient.makeDirectory(paths[i]); 
	            ftpClient.changeWorkingDirectory(paths[i]); 
	          } 
	        } 
	      } 
	    } 
	    return true; 
	  } 
	   
	  public static final void upload(Map<String, Object> serverCfg, String filePathToUpload, String fileStoredPath, String  
	 
	fileStoredName) 
	      throws SocketException, IOException { 
	    //upload(serverCfg, new File(filePathToUpload), fileStoredPath, fileStoredName); 
	  } 
	   
	  public static final void upload(Map<String, Object> serverCfg, InputStream fileToUpload, String fileStoredPath, String  
	 
	fileStoredName) 
	      throws SocketException, IOException { 
	    if(fileStoredPath!=null && !"".equals(fileStoredPath)){ 
	      serverCfg.put(WORKING_DIRECTORY, fileStoredPath); 
	    } 
	    upload(serverCfg, fileToUpload, fileStoredName); 
	  } 
	   
	  public static final void upload(String filePathToUpload, String fileStoredPath)throws SocketException, IOException { 
	    upload(serverCfg, filePathToUpload, fileStoredPath, ""); 
	  } 
	   
	  public static final void upload(InputStream fileToUpload, String fileStoredPath)throws SocketException, IOException { 
	    upload(serverCfg, fileToUpload, fileStoredPath, ""); 
	  } 
	   
	 
	 
	   
	  public static String values(String key) { 
	    String value = prop.getProperty(key); 
	    if (value != null) { 
	      return value; 
	    } else { 
	      return null; 
	    } 
	  } 
}
