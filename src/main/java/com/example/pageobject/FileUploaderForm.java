package com.example.pageobject;

import com.example.elements.Button;
import com.example.elements.TextField;
import org.openqa.selenium.By;

public class FileUploaderForm extends BaseForm {
    private static final TextField FORM =
            new TextField(By.xpath("//div[@class='example']//h3"), "FileUploaderForm");

    private static final Button BTN_FILE_UPLOAD =
            new Button(By.xpath("//input[@id='file-upload']"), "FileUploader");

    private static final Button BTN_FILE_SUBMIT =
            new Button(By.xpath("//input[@id='file-submit']"), "FileSubmit");

    private static final TextField NAME_OF_UPLOADED_FILE =
            new TextField(By.xpath("//div[@id='uploaded-files']"), "NameOfUploadedFile");

    public FileUploaderForm() {
        super(FORM, "FileUploader");
    }

    public String getTextForm() {
        return FORM.getText();
    }

    public void uploadFile(String filePath) {
        BTN_FILE_UPLOAD.uploadFileUseSendKeys(filePath);
        BTN_FILE_SUBMIT.click();
    }

    public String getNameOfUploadedFile(){
        return NAME_OF_UPLOADED_FILE.getText();
    }
}
