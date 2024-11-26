package com.training.core.documents.service;
        
import com.training.core.model.TrainingDocumentModel;

import java.util.List;

public interface TrainingDocumentService {

    /**
     * Fetch List of Document data form DB
     * @return List TrainingDocumentModel
     */
    List<TrainingDocumentModel> getDocumentListData();

}