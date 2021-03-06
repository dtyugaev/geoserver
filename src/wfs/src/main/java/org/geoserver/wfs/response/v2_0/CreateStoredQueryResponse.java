/* Copyright (c) 2001 - 2013 OpenPlans - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.wfs.response.v2_0;

import java.io.IOException;
import java.io.OutputStream;

import net.opengis.wfs20.CreateStoredQueryResponseType;

import org.geoserver.config.GeoServer;
import org.geoserver.platform.Operation;
import org.geoserver.platform.ServiceException;
import org.geotools.wfs.v2_0.WFS;
import org.geotools.xml.Encoder;

public class CreateStoredQueryResponse extends WFSResponse {

    public CreateStoredQueryResponse(GeoServer gs) {
        super(gs, CreateStoredQueryResponseType.class);
    }

    @Override
    protected void encode(Encoder encoder, Object value, OutputStream output, Operation op) 
        throws IOException, ServiceException {
        encoder.encode(value, WFS.CreateStoredQueryResponse, output);
    }
}
