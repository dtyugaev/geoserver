/* Copyright (c) 2001 - 2013 OpenPlans - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

package org.geoserver.csw;

import net.opengis.cat.csw20.CapabilitiesType;
import net.opengis.cat.csw20.DescribeRecordType;
import net.opengis.cat.csw20.GetCapabilitiesType;
import net.opengis.cat.csw20.GetDomainType;
import net.opengis.cat.csw20.GetRecordByIdType;
import net.opengis.cat.csw20.GetRecordsType;
import net.opengis.cat.csw20.HarvestResponseType;
import net.opengis.cat.csw20.HarvestType;
import net.opengis.cat.csw20.TransactionType;

import org.geoserver.catalog.util.CloseableIterator;
import org.geoserver.csw.response.CSWRecordsResult;
import org.geoserver.csw.store.RepositoryItem;
import org.geoserver.platform.ServiceException;
import org.opengis.feature.type.AttributeDescriptor;

/**
 * The interface representing a Catalog Service for the Web implementation
 * 
 * @author Andrea Aime - GeoSolutions
 */
public interface WebCatalogService {
    /**
     * Returns a object model representing the capabilities document
     */
    CapabilitiesType getCapabilities(GetCapabilitiesType request) throws ServiceException;

    /**
     * Returns the type of records managed by this catalog
     */
    AttributeDescriptor[] describeRecord(DescribeRecordType request) throws ServiceException;

    /**
     * Returns the records matching the specified request
     */
    CSWRecordsResult getRecords(GetRecordsType request) throws ServiceException;

    /**
     * Returns the records matching the specified request
     */
    CSWRecordsResult getRecordById(GetRecordByIdType request) throws ServiceException;
    
    /**
     * Returns the list of possible values for the specified parameter/property
     */
    CloseableIterator<String> getDomain(GetDomainType request) throws ServiceException;
    
    /**
     * The optional GetRepositoryItem request, used for ebRIM but could be useful for
     * a general catalog that wants the data to be made available for download as well
     */
    RepositoryItem getRepositoryItem(GetRepositoryItemType request) throws ServiceException;

    /**
     * Runs a harvest request
     * 
     * @param request
     * @param response
     * @throws CSWException
     */
    HarvestResponseType harvest(HarvestType request) throws ServiceException;
    
    /**
     * Runs a transaction request
     * 
     * @param request
     * @param response
     * @throws CSWException
     */
    HarvestResponseType transaction(TransactionType request) throws ServiceException;

}
