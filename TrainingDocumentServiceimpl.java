package com.training.core.documents.service.impl;
        
import com.training.core.documents.dao.TrainingDocumentDao;
import com.training.core.documents.service.TrainingDocumentService;
import com.training.core.model.TrainingDocumentModel;
import java.util.List;

public class TrainingDocumentServiceImpl implements TrainingDocumentService {

    private TrainingDocumentDao trainingDocumentDao;

    @Override
    public List<TrainingDocumentModel> getDocumentListData() {
       return trainingDocumentDao.getTrainingDocumentDataList();
    }

    public TrainingDocumentDao getTrainingDocumentDao() {
        return trainingDocumentDao;
    }

    public void setTrainingDocumentDao(TrainingDocumentDao trainingDocumentDao) {
        this.trainingDocumentDao = trainingDocumentDao;
    }

}