package ru.rashgild.task.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rashgild.task.model.Document;

@Repository("DocumentDao")
@Transactional
public class DocumentDaoImpl extends DaoImpl<Document> implements DocumentDao {

    public DocumentDaoImpl() {
        super(Document.class);
    }

    @Override
    public Document getByNumber(Integer number) {
        Criteria criteria = getSession().createCriteria(Document.class);
        criteria.add(Restrictions.eq("number", number));
        return (Document) criteria.uniqueResult();
    }
}
