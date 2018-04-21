/*
 * Copyright 2018 Karl Dahlgren
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


package com.castlemock.web.mock.soap.model.project.repository;

import com.castlemock.core.basis.model.SearchQuery;
import com.castlemock.core.basis.model.SearchResult;
import com.castlemock.core.basis.model.http.domain.ContentEncoding;
import com.castlemock.core.basis.model.http.domain.HttpHeader;
import com.castlemock.core.mock.soap.model.project.domain.SoapMockResponse;
import com.castlemock.core.mock.soap.model.project.dto.SoapMockResponseDto;
import com.castlemock.web.basis.model.RepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class SoapMockResponseRepositoryImpl extends RepositoryImpl<SoapMockResponse, SoapMockResponseDto, String> implements SoapMockResponseRepository {

    @Value(value = "${soap.response.file.directory}")
    private String fileDirectory;
    @Value(value = "${soap.response.file.extension}")
    private String fileExtension;

    /**
     * The method returns the directory for the specific file repository. The directory will be used to indicate
     * where files should be saved and loaded from. The method is abstract and every subclass is responsible for
     * overriding the method and provided the directory for their corresponding file type.
     *
     * @return The file directory where the files for the specific file repository could be saved and loaded from.
     */
    @Override
    protected String getFileDirectory() {
        return fileDirectory;
    }

    /**
     * The method returns the postfix for the file that the file repository is responsible for managing.
     * The method is abstract and every subclass is responsible for overriding the method and provided the postfix
     * for their corresponding file type.
     *
     * @return The file extension for the file type that the repository is responsible for managing .
     */
    @Override
    protected String getFileExtension() {
        return fileExtension;
    }

    /**
     * The method is responsible for controller that the type that is about the be saved to the file system is valid.
     * The method should check if the type contains all the necessary values and that the values are valid. This method
     * will always be called before a type is about to be saved. The main reason for why this is vital and done before
     * saving is to make sure that the type can be correctly saved to the file system, but also loaded from the
     * file system upon application startup. The method will throw an exception in case of the type not being acceptable.
     *
     * @param type The instance of the type that will be checked and controlled before it is allowed to be saved on
     *             the file system.
     * @see #save
     */
    @Override
    protected void checkType(SoapMockResponse type) {

    }


    /**
     * The post initialize method can be used to run functionality for a specific service. The method is called when
     * the method {@link #initialize} has finished successful.
     *
     * The method is responsible to validate the imported types and make certain that all the collections are
     * initialized.
     * @see #initialize
     * @since 1.4
     */
    @Override
    protected void postInitiate() {
        for(SoapMockResponse soapMockResponse : collection.values()) {
            List<HttpHeader> httpHeaders = new CopyOnWriteArrayList<HttpHeader>();
            if (soapMockResponse.getHttpHeaders() != null) {
                httpHeaders.addAll(soapMockResponse.getHttpHeaders());
            }
            soapMockResponse.setHttpHeaders(httpHeaders);

            List<ContentEncoding> contentEncodings = new CopyOnWriteArrayList<ContentEncoding>();
            if (soapMockResponse.getContentEncodings() != null) {
                contentEncodings.addAll(soapMockResponse.getContentEncodings());
            }

            soapMockResponse.setContentEncodings(contentEncodings);
        }
    }


    /**
     * The method provides the functionality to search in the repository with a {@link SearchQuery}
     *
     * @param query The search query
     * @return A <code>list</code> of {@link SearchResult} that matches the provided {@link SearchQuery}
     */
    @Override
    public List<SearchResult> search(SearchQuery query) {
        return null;
    }

    @Override
    public void deleteWithOperationId(String operationId) {
        Iterator<SoapMockResponse> iterator = this.collection.values().iterator();
        while (iterator.hasNext()){
            SoapMockResponse mockResponse = iterator.next();
            if(mockResponse.getOperationId().equals(operationId)){
                delete(mockResponse.getId());
            }
        }
    }

    @Override
    public List<SoapMockResponseDto> findWithOperationId(String operationId) {
        final List<SoapMockResponseDto> mockResponses = new ArrayList<>();
        for(SoapMockResponse mockResponse : this.collection.values()){
            if(mockResponse.getOperationId().equals(operationId)){
                SoapMockResponseDto operationDto = this.mapper.map(mockResponse, SoapMockResponseDto.class);
                mockResponses.add(operationDto);
            }
        }
        return mockResponses;
    }
}
