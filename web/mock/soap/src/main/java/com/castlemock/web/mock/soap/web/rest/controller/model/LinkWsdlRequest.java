/*
 * Copyright 2020 Karl Dahlgren
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

package com.castlemock.web.mock.soap.web.rest.controller.model;

import java.util.Objects;

public class LinkWsdlRequest {

    private String url;
    private Boolean generateResponse;
    private Boolean includeImports;

    public String getUrl() {
        return url;
    }

    public Boolean getGenerateResponse() {
        return generateResponse;
    }

    public Boolean getIncludeImports() {
        return includeImports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkWsdlRequest that = (LinkWsdlRequest) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(generateResponse, that.generateResponse) &&
                Objects.equals(includeImports, that.includeImports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, generateResponse, includeImports);
    }

    @Override
    public String toString() {
        return "LinkWsdlRequest{" +
                "url='" + url + '\'' +
                ", generateResponse=" + generateResponse +
                ", includeImports=" + includeImports +
                '}';
    }
}
