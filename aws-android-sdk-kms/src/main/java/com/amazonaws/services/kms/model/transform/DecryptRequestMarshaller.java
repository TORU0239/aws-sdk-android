/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.kms.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * Decrypt Request Marshaller
 */
public class DecryptRequestMarshaller implements Marshaller<Request<DecryptRequest>, DecryptRequest> {

    public Request<DecryptRequest> marshall(DecryptRequest decryptRequest) {
    if (decryptRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<DecryptRequest> request = new DefaultRequest<DecryptRequest>(decryptRequest, "AWSKMS");
        String target = "TrentService.Decrypt";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);

            jsonWriter.beginObject();
            
            if (decryptRequest.getCiphertextBlob() != null) {
                jsonWriter.name("CiphertextBlob").value(decryptRequest.getCiphertextBlob());
            }
            if (decryptRequest.getEncryptionContext() != null) {
                jsonWriter.name("EncryptionContext");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> encryptionContextListValue : decryptRequest.getEncryptionContext().entrySet()) {
                    if (encryptionContextListValue.getValue() != null) {
                        jsonWriter.name(encryptionContextListValue.getKey());

                        jsonWriter.value(encryptionContextListValue.getValue());
                    }
                }
                jsonWriter.endObject();
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<String> grantTokensList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(decryptRequest.getGrantTokens());
            if (grantTokensList != null && !(grantTokensList.isAutoConstruct() && grantTokensList.isEmpty())) {

                jsonWriter.name("GrantTokens");
                jsonWriter.beginArray();

                for (String grantTokensListValue : grantTokensList) {
                    if (grantTokensListValue != null) {
                        jsonWriter.value(grantTokensListValue);
                    }
                }
                jsonWriter.endArray();
            }

            jsonWriter.endObject();

            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
