/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.mobile.windows.api.services.xcep;

import org.wso2.carbon.device.mgt.mobile.windows.api.common.PluginConstants;
import org.wso2.carbon.device.mgt.mobile.windows.api.services.xcep.beans.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.BindingType;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Interface for MS-XCEP implementation.
 */

@WebService(targetNamespace = PluginConstants.CERTIFICATE_ENROLLMENT_POLICY_SERVICE_TARGET_NAMESPACE,
		name = "IPolicy")
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
@XmlSeeAlso({ ObjectFactory.class })
public interface CertificateEnrollmentPolicyService {

	@RequestWrapper(localName = "GetPolicies", targetNamespace = PluginConstants.
			ENROLLMENT_POLICY_TARGET_NAMESPACE, className = PluginConstants.REQUEST_WRAPPER_CLASS_NAME)
	@WebMethod(operationName = "GetPolicies")
	@ResponseWrapper(localName = "GetPoliciesResponse", targetNamespace = PluginConstants.
			ENROLLMENT_POLICY_TARGET_NAMESPACE, className = PluginConstants.
			RESPONSE_WRAPPER_CLASS_NAME)
    @POST
    @Consumes({PluginConstants.SYNCML_MEDIA_TYPE, MediaType.APPLICATION_XML})
    @Produces(PluginConstants.SYNCML_MEDIA_TYPE)
    void getPolicies(
            @WebParam(name = "client", targetNamespace = PluginConstants.
                    ENROLLMENT_POLICY_TARGET_NAMESPACE)
                    Client client,
            @WebParam(name = "requestFilter", targetNamespace = PluginConstants.
                    ENROLLMENT_POLICY_TARGET_NAMESPACE)
                    RequestFilter requestFilter,
            @WebParam(mode = WebParam.Mode.OUT, name = "response", targetNamespace = PluginConstants.
                    ENROLLMENT_POLICY_TARGET_NAMESPACE)
                    Holder<Response> response,
            @WebParam(mode = WebParam.Mode.OUT, name = "cAs", targetNamespace = PluginConstants.
                    ENROLLMENT_POLICY_TARGET_NAMESPACE)
                    Holder<CACollection> caCollection,
            @WebParam(mode = WebParam.Mode.OUT, name = "oIDs", targetNamespace = PluginConstants.
                    ENROLLMENT_POLICY_TARGET_NAMESPACE)
                    Holder<OIDCollection> oidCollection
    );
}
