package ru.rashgild.task.service;

import java.util.List;

import ru.rashgild.task.model.Document;

public interface DocumentService {

    List<Document> getList();

    void save(Document document);

    Document getByNumber(Integer number);

    void delete(Document document);
}
