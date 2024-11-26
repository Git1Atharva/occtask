package com.training.core.documents.dao.impl;
        
import com.training.core.documents.dao.TrainingDocumentDao;
import com.training.core.model.TrainingDocumentModel;
import de.hybris.platform.jalo.flexiblesearch.FlexibleSearchException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TrainingDocumentDaoImpl implements TrainingDocumentDao {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingDocumentDaoImpl.class);
    private static final String QUERY = "SELECT distinct {PK} FROM {TrainingDocument}" ;

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<TrainingDocumentModel> getTrainingDocumentDataList() {
        SearchResult<TrainingDocumentModel> searchResult = null;
        final FlexibleSearchQuery fpQuery = new FlexibleSearchQuery(QUERY);
        try {
            searchResult = getFlexibleSearchService().search(fpQuery);
        } catch (final FlexibleSearchException ex) {
            LOG.error("Exception occurred while fetching the Document data from DB: ", ex);
        }
        if (null != searchResult && CollectionUtils.isNotEmpty(searchResult.getResult())) {
            return searchResult.getResult();
        }
        return null;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

}
