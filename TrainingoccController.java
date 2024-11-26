package com.training.controllers;
        
import com.training.constants.TrainingoccConstants;
import com.training.facades.document.data.TrainingDocumentListData;
import com.training.facades.documents.TrainingDocumentFacades;
import com.training.occ.dto.document.TrainingDocumentListWsDTO;
import de.hybris.platform.commerceservices.request.mapping.annotation.ApiVersion;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.mapping.FieldSetLevelHelper;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdUserIdAndCartIdParam;
import de.hybris.platform.webservicescommons.swagger.ApiFieldsParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@ApiVersion("v2")
@RequestMapping(value = "/{baseSiteId}")
public class TrainingoccController
{
    private static final Logger LOG = LoggerFactory.getLogger(TrainingoccController.class);

    @Resource(name = "dataMapper")
    private DataMapper dataMapper;

    @Resource(name = "trainingDocumentFacades")
    private TrainingDocumentFacades trainingDocumentFacades;

  
    
    @Secured({ TrainingoccConstants.ROLE_CUSTOMERGROUP, TrainingoccConstants.ROLE_GUEST,
            TrainingoccConstants.ROLE_CUSTOMERMANAGERGROUP, TrainingoccConstants.ROLE_TRUSTED_CLIENT })
    @GetMapping(path = "/document")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiBaseSiteIdUserIdAndCartIdParam
    public TrainingDocumentListWsDTO getDocumentData (
            @ApiFieldsParam @RequestParam(required = false, defaultValue = FieldSetLevelHelper.DEFAULT_LEVEL) final String fields)
    {
        TrainingDocumentListData trainingDocumentListData = new TrainingDocumentListData();
        try {
            trainingDocumentListData = trainingDocumentFacades.getDocumentListData();
        } catch (Exception ex) {
            LOG.error("Error Occurred in TrainingoccController While fetching the document data: ", ex);
        }
        return dataMapper.map(trainingDocumentListData, TrainingDocumentListWsDTO.class, fields);
    }

}