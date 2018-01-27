package myclass.bll;

import java.io.*;
import myclass.dal.uploadFileDal;

public class uploadFileBll {
    private String backMessage=null;
    private boolean flag=false;
    private  String uploadFileName=null;
    private String savedFileName=null;
        
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getBackMessage() {
		return backMessage;
	}
	public void setBackMessage(String backMessage) {
		this.backMessage = backMessage;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
    public boolean uploadFileMethod(String driverPath, String tempFileName,
			String saveFileName, InputStream fileSource){

    	try{
    		uploadFileDal upFile=new uploadFileDal(driverPath,tempFileName,
    			saveFileName,fileSource	);
    		flag=upFile.uploadFileMethod(); 
    		backMessage=upFile.getBackMessage();
    		this.setUploadFileName(upFile.getUploadFileName());
    		this.setSavedFileName(upFile.getSaveFileName());
    	}
    	catch(Exception exp){
    		flag=false;
    		backMessage="";
    		this.setUploadFileName("");
    		this.setSavedFileName("");
    	}
    	return  flag;
    }

}
