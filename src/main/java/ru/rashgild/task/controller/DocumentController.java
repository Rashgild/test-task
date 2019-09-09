package ru.rashgild.task.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.rashgild.task.model.Document;
import ru.rashgild.task.service.DocumentService;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/doclist")
    public ResponseEntity getDocList() {
        return new ResponseEntity(documentService.getList(), HttpStatus.OK);
    }

    @PutMapping("/adddoc")
    public void setDocument(@RequestParam("number") Integer number,
                            @RequestParam("total") BigDecimal total,
                            HttpServletResponse response) throws IOException {

        Document document = new Document();
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        document.setDate(ourJavaDateObject);
        document.setNumber(number);
        document.setTotal(total);
        documentService.save(document);
        response.sendRedirect("/doclist");
    }


    @DeleteMapping("/deldoc/{number}")
    public void deleteDocument(@PathVariable Integer number,
                               HttpServletResponse response) throws IOException {
        Document document = documentService.getByNumber(number);
        if (document != null) {
            documentService.delete(document);
            response.sendRedirect("/doclist");
        } else {
            response.sendRedirect("/404");
        }
    }
}