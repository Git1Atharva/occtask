package com.training.core.documents.dao;
        
import com.training.core.model.TrainingDocumentModel;

import java.util.List;

public interface TrainingDocumentDao {

    /**
     * Fetch List document data from TrainingDocumentModel
     * @return List of TrainingDocumentModel
     */
    List<TrainingDocumentModel> getTrainingDocumentDataList();

}