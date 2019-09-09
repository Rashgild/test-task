package ru.rashgild.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.rashgild.task.dao.DocumentDao;
import ru.rashgild.task.model.Document;

@Service("DocumentService")
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao docmentDao;

    @Override
    public List<Document> getList() {
        return docmentDao.getList();
    }

    @Override
    public void save(Document document) {
        docmentDao.save(document);
    }

    @Override
    public Document getByNumber(Integer number) {
        return docmentDao.getByNumber(number);
    }

    @Override
    public void delete(Document document) {
        docmentDao.delete(document);
    }
}
