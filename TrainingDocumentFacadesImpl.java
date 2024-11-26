package com.training.facades.documents.impl;
        
import com.training.core.documents.service.TrainingDocumentService;
import com.training.core.model.TrainingDocumentModel;
import com.training.facades.document.data.TrainingDocumentData;
import com.training.facades.document.data.TrainingDocumentListData;
import com.training.facades.documents.TrainingDocumentFacades;

import java.util.ArrayList;
import java.util.List;

public class TrainingDocumentFacadesImpl implements TrainingDocumentFacades {

    private TrainingDocumentService trainingDocumentService;

    @Override
    public TrainingDocumentListData getDocumentListData() {
        TrainingDocumentListData trainingDocumentListData = new TrainingDocumentListData();
        List<TrainingDocumentData> trainingDocumentList = new ArrayList<>();
        List<TrainingDocumentModel> trainingDocumentModels = trainingDocumentService.getDocumentListData();
        for(TrainingDocumentModel trainingDocumentModel : trainingDocumentModels) {
            TrainingDocumentData trainingDocumentData = new TrainingDocumentData();
            trainingDocumentData.setCode(trainingDocumentModel.getCode());
            trainingDocumentData.setDocName(trainingDocumentModel.getDocName());
            trainingDocumentData.setDocType(trainingDocumentModel.getDocType().toString());
            trainingDocumentData.setKeywords(trainingDocumentModel.getKeywords().toString());
            trainingDocumentData.setLanguage(trainingDocumentModel.getLanguage().toString());
            trainingDocumentData.setUrl(trainingDocumentModel.getUrl());
            trainingDocumentData.setVisibility(trainingDocumentModel.getVisibility());
            trainingDocumentData.setDocumentAge(trainingDocumentModel.getDocumentAge());
            trainingDocumentList.add(trainingDocumentData);
        }
        trainingDocumentListData.setDocuments(trainingDocumentList);
        return trainingDocumentListData;
    }

    public TrainingDocumentService getTrainingDocumentService() {
        return trainingDocumentService;
    }

    public void setTrainingDocumentService(TrainingDocumentService trainingDocumentService) {
        this.trainingDocumentService = trainingDocumentService;
    }

}