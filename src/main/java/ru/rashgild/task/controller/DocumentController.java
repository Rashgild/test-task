package ru.rashgild.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.rashgild.task.service.DocumentService;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/doclist")
    public ResponseEntity getDocList() {
        return new ResponseEntity(documentService.getList(), HttpStatus.OK);
    }
}
