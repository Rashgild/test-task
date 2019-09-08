package ru.rashgild.task.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rashgild.task.model.Document;

@Repository("DocumentDao")
@Transactional
public class DocumentDaoImpl extends DaoImpl<Document> implements DocumentDao {

    public DocumentDaoImpl() {
        super(Document.class);
    }
}
