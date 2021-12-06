package com.example;

import com.example.core.DriverUtilities;
import com.example.pageobject.FileUploaderForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(FileUploadTest.class);
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("upload.page");

    @Test(description = "Тест формы FileUploadForm")
    public void testJavascriptFileUpload() {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        FileUploaderForm fileUploaderForm = new FileUploaderForm();
        assertEquals(fileUploaderForm.getTextForm(), "File Uploader",
                "Страница FileUpload не загрузилась");
        fileUploaderForm.uploadFile(TEST_DATA_PROPERTIES.getProperty("file.path"));
        assertEquals(fileUploaderForm.getTextForm(), "File Uploaded!",
                "Файл не загружен!");
        String fileName = TEST_DATA_PROPERTIES.getProperty("file.path");
        assertEquals(fileUploaderForm.getNameOfUploadedFile(), fileName.substring(fileName.lastIndexOf('\\')+1),
                "Неверное имя файла");
    }
}
