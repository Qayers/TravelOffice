package com.travelsite.traveloffice.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;

public interface PagingAndSortingRepository {

    public abstract Iterable findAll(SpringDataWebProperties.Sort arg0);

    public abstract Page findAll(SpringDataWebProperties.Pageable arg0);
}
