package com.web.app.utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.web.app.portal.POJO.Users;

public class FileUpload {

	public static  SortedMap<String, String> getFile(HttpServletRequest request) throws Exception
	{
		HttpSession ses=request.getSession();
		Users usr=(Users) ses.getAttribute("user");

	        SortedMap<String, String> key_values = new TreeMap<String, String>();
	        
	        File file;
	        String filePath = System.getProperty(Constants.homedir)+"/"+Constants.filePreviewPath+"/"+usr.getU_id();
	        File dir=new File(filePath);
	        if(!dir.exists())
	        {
	        	dir.mkdir();
	        }
	        int maxFileSize = 5000 * 1024;
	        int maxMemSize = 5000 * 1024;
	        // Verify the content type
	        String contentType = request.getContentType();
	        if ((contentType.indexOf("multipart/form-data") >= 0)) {
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            // maximum size that will be stored in memory
	            factory.setSizeThreshold(maxMemSize);
	            // Location to save data that is larger than maxMemSize.
	            factory.setRepository(new File(filePath));
	            // Create a new file upload handler
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            // maximum file size to be uploaded.
	            upload.setSizeMax(maxFileSize);
	            try {
	                // Parse the request to get file items.
	                //@SuppressWarnings("unchecked")
	                List<FileItem> fileItems = upload.parseRequest(request);
	                // Process the uploaded file items
	                Iterator<FileItem> i = fileItems.iterator();
	                while (i.hasNext()) {
	                    FileItem fi = (FileItem) i.next();
	                    if (!fi.isFormField()) {
	                        // Get the uploaded file parameters
	                        String fileName = fi.getName();
	                        // Write the file
	                        if (fileName.lastIndexOf("\\") >= 0) {
	                            file = new File(filePath+"/"+fileName);
	                            if(!file.exists())
	                            {
	                            	file.createNewFile();
	                            }
	                        } else {
	                            file = new File(filePath + "/"
	                                + fileName);
	                        }
	                        fi.write(file);
	                        key_values.put("filePath", file.getAbsolutePath());
	                    } else {
	                        key_values.put(fi.getFieldName(), fi.getString());
	                    }
	                    
	                }
	                
	                for(Entry<String, String> entry : key_values.entrySet()) {
	                	  String key = entry.getKey();
	                	  String value = entry.getValue();

	                	  System.out.println(key + " = " + value);
	                	}
	                
	            } catch (Exception ex) {
	                System.out.println(ex);
	            }
	        }
	    return key_values;
	    }
	

	private static void processUploadedFile(FileItem item) {
		// TODO Auto-generated method stub
		try{
			// Process a file upload
			if (!item.isFormField()) {
			    String fieldName = item.getFieldName();
			    String fileName = item.getName();
			    String contentType = item.getContentType();
			    boolean isInMemory = item.isInMemory();
			    long sizeInBytes = item.getSize();
			    System.out.println(" safsf "+contentType);
			    File file=new File("f:/"+fileName);
			    DataInputStream dis = new DataInputStream(item.getInputStream());
			    byte b[]= new byte[100];
			    dis.read(b);
			    FileOutputStream fos=new FileOutputStream(file);
			    fos.write(b);
			    fos.flush();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void processFormField(FileItem item) {
		// TODO Auto-generated method stub
		try{
			String val=item.getName();
			System.out.println("yyyyyyyyyyy   "+val);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
