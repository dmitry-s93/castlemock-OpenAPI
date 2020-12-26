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

package com.castlemock.core.mock.rest.service.project.input;

import com.castlemock.core.basis.model.Input;
import com.castlemock.core.basis.model.http.domain.HttpMethod;
import com.castlemock.core.basis.model.validation.NotNull;
import com.castlemock.core.mock.rest.model.project.domain.RestMethodStatus;
import com.castlemock.core.mock.rest.model.project.domain.RestResponseStrategy;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
public final class UpdateRestMethodInput implements Input {

    @NotNull
    private final String restProjectId;
    @NotNull
    private final String restApplicationId;
    @NotNull
    private final String restResourceId;
    @NotNull
    private final String restMethodId;
    @NotNull
    private String name;
    @NotNull
    private HttpMethod httpMethod;
    private String forwardedEndpoint;
    @NotNull
    private RestMethodStatus status;
    @NotNull
    private RestResponseStrategy responseStrategy;
    @NotNull
    private boolean simulateNetworkDelay;
    @NotNull
    private long networkDelay;
    private String defaultMockResponseId;

    private UpdateRestMethodInput(final Builder builder) {
        this.restProjectId = Objects.requireNonNull(builder.restProjectId);
        this.restApplicationId = Objects.requireNonNull(builder.restApplicationId);
        this.restResourceId = Objects.requireNonNull(builder.restResourceId);
        this.restMethodId = Objects.requireNonNull(builder.restMethodId);
        this.name = Objects.requireNonNull(builder.name);
        this.httpMethod = Objects.requireNonNull(builder.httpMethod);
        this.forwardedEndpoint = builder.forwardedEndpoint;
        this.status = Objects.requireNonNull(builder.status);
        this.responseStrategy = Objects.requireNonNull(builder.responseStrategy);
        this.simulateNetworkDelay = Objects.requireNonNull(builder.simulateNetworkDelay);
        this.networkDelay = Objects.requireNonNull(builder.networkDelay);
        this.defaultMockResponseId = builder.defaultMockResponseId;
    }

    public String getRestProjectId() {
        return restProjectId;
    }

    public String getRestApplicationId() {
        return restApplicationId;
    }

    public String getRestResourceId() {
        return restResourceId;
    }

    public String getRestMethodId() {
        return restMethodId;
    }

    public String getName() {
        return name;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public Optional<String> getForwardedEndpoint() {
        return Optional.ofNullable(forwardedEndpoint);
    }

    public RestMethodStatus getStatus() {
        return status;
    }

    public RestResponseStrategy getResponseStrategy() {
        return responseStrategy;
    }

    public boolean getSimulateNetworkDelay() {
        return simulateNetworkDelay;
    }

    public long getNetworkDelay() {
        return networkDelay;
    }

    public Optional<String> getDefaultMockResponseId() {
        return Optional.ofNullable(defaultMockResponseId);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {

        private String restProjectId;
        private String restApplicationId;
        private String restResourceId;
        private String restMethodId;
        private String name;
        private HttpMethod httpMethod;
        private String forwardedEndpoint;
        private RestMethodStatus status;
        private RestResponseStrategy responseStrategy;
        private Boolean simulateNetworkDelay;
        private Long networkDelay;
        private String defaultMockResponseId;

        public Builder restProjectId(final String restProjectId){
            this.restProjectId = restProjectId;
            return this;
        }

        public Builder restApplicationId(final String restApplicationId){
            this.restApplicationId = restApplicationId;
            return this;
        }

        public Builder restResourceId(final String restResourceId){
            this.restResourceId = restResourceId;
            return this;
        }

        public Builder restMethodId(final String restMethodId){
            this.restMethodId = restMethodId;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder httpMethod(final HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public Builder forwardedEndpoint(final String forwardedEndpoint) {
            this.forwardedEndpoint = forwardedEndpoint;
            return this;
        }

        public Builder status(final RestMethodStatus status) {
            this.status = status;
            return this;
        }

        public Builder responseStrategy(final RestResponseStrategy responseStrategy) {
            this.responseStrategy = responseStrategy;
            return this;
        }

        public Builder simulateNetworkDelay(final Boolean simulateNetworkDelay) {
            this.simulateNetworkDelay = simulateNetworkDelay;
            return this;
        }

        public Builder networkDelay(final Long networkDelay) {
            this.networkDelay = networkDelay;
            return this;
        }

        public Builder defaultMockResponseId(final String defaultMockResponseId) {
            this.defaultMockResponseId = defaultMockResponseId;
            return this;
        }


        public UpdateRestMethodInput build(){
            return new UpdateRestMethodInput(this);
        }

    }


}
