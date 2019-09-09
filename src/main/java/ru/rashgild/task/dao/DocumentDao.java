package ru.rashgild.task.dao;

import ru.rashgild.task.model.Document;

public interface DocumentDao extends Dao<Document> {
    Document getByNumber(Integer number);
}
