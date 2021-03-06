/*
 *Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */

package org.wso2.carbon.identity.application.common.model;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.axiom.om.OMElement;

public class Claim implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9123587946522643637L;

    private String claimUri;
    private int claimId;

    /**
     * 
     * @return
     */
    public String getClaimUri() {
        return claimUri;
    }

    /**
     * 
     * @param claimUri
     */
    public void setClaimUri(String claimUri) {
        this.claimUri = claimUri;
    }

    /**
     * 
     * @return
     */
    public int getClaimId() {
        return claimId;
    }

    /**
     * 
     * @param claimId
     */
    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    /*
     * <Claim> <ClaimUri></ClaimUri></Claim>
     */
    public static Claim build(OMElement claimOM) {

        if (claimOM == null) {
            return null;
        }

        Claim claim = new Claim();

        Iterator<?> iter = claimOM.getChildElements();

        while (iter.hasNext()) {
            OMElement element = (OMElement) (iter.next());
            String elementName = element.getLocalName();

            if (elementName.equals("ClaimUri")) {
                claim.setClaimUri(element.getText());
            }

        }
        return claim;

    }
}
