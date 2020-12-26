/*
 * Copyright 2015 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.castlemock.core.mock.soap.service.project.input;

import com.castlemock.core.basis.model.Input;
import com.castlemock.core.basis.model.http.domain.HttpHeader;
import com.castlemock.core.basis.model.validation.NotNull;
import com.castlemock.core.mock.soap.model.project.domain.SoapMockResponseStatus;
import com.castlemock.core.mock.soap.model.project.domain.SoapXPathExpression;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
public final class CreateSoapMockResponseInput implements Input {

    @NotNull
    private final String projectId;
    @NotNull
    private final String portId;
    @NotNull
    private final String operationId;
    @NotNull
    private final String name;
    @NotNull
    private final SoapMockResponseStatus status;
    private final String body;
    private final Integer httpStatusCode;
    private final Boolean usingExpressions;
    private final List<HttpHeader> httpHeaders;
    private final List<SoapXPathExpression> xpathExpressions;


    private CreateSoapMockResponseInput(final Builder builder) {
        this.projectId = Objects.requireNonNull(builder.projectId);
        this.portId = Objects.requireNonNull(builder.portId);
        this.operationId = Objects.requireNonNull(builder.operationId);
        this.name = Objects.requireNonNull(builder.name);
        this.body = builder.body;
        this.status = Objects.requireNonNull(builder.status);
        this.httpStatusCode = builder.httpStatusCode;
        this.usingExpressions = builder.usingExpressions;
        this.httpHeaders = builder.httpHeaders;
        this.xpathExpressions = builder.xpathExpressions;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getPortId() {
        return portId;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getName() {
        return name;
    }

    public SoapMockResponseStatus getStatus() {
        return status;
    }

    public Optional<String> getBody() {
        return Optional.ofNullable(body);
    }

    public Optional<Integer> getHttpStatusCode() {
        return Optional.ofNullable(httpStatusCode);
    }

    public Optional<Boolean> getUsingExpressions() {
        return Optional.ofNullable(usingExpressions);
    }

    public Optional<List<HttpHeader>> getHttpHeaders() {
        return Optional.ofNullable(httpHeaders);
    }

    public Optional<List<SoapXPathExpression>> getXpathExpressions() {
        return Optional.ofNullable(xpathExpressions);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String projectId;
        private String portId;
        private String operationId;
        private String name;
        private String body;
        private SoapMockResponseStatus status;
        private Integer httpStatusCode;
        private Boolean usingExpressions;
        private List<HttpHeader> httpHeaders;
        private List<SoapXPathExpression> xpathExpressions;

        private Builder(){

        }

        public Builder projectId(final String projectId){
            this.projectId = projectId;
            return this;
        }

        public Builder portId(final String portId){
            this.portId = portId;
            return this;
        }

        public Builder operationId(final String operationId){
            this.operationId = operationId;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder body(final String body) {
            this.body = body;
            return this;
        }

        public Builder status(final SoapMockResponseStatus status) {
            this.status = status;
            return this;
        }

        public Builder httpStatusCode(final Integer httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public Builder usingExpressions(final Boolean usingExpressions) {
            this.usingExpressions = usingExpressions;
            return this;
        }

        public Builder httpHeaders(final List<HttpHeader> httpHeaders) {
            this.httpHeaders = httpHeaders;
            return this;
        }

        public Builder xpathExpressions(final List<SoapXPathExpression> xpathExpressions) {
            this.xpathExpressions = xpathExpressions;
            return this;
        }

        public CreateSoapMockResponseInput build(){
            return new CreateSoapMockResponseInput(this);
        }
    }

}
