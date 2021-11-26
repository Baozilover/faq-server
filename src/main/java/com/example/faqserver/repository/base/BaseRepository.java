package com.example.faqserver.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.List;

public interface BaseRepository <D,I> extends JpaRepository <D,I> {

    @NonNull
    List<D> findAllByIdIn(@NonNull Collection<I> ids, @NonNull Sort sort);

    @NonNull
    Page<D> findAllByIdIn(@NonNull Collection<I> ids, @NonNull Pageable pageable);

    long deleteByIdIn(@NonNull Collection<I> ids);
}
