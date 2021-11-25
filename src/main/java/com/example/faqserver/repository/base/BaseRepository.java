package com.example.faqserver.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface BaseRepository <D,I> extends JpaRepository <D,I> {

    @NonNull
    List<D> findAllByIdIn(@NonNull Collection<I> ids, @NonNull Sort sort);

    @NonNull
    Page<D> findAllByIdIn(@NonNull Collection<I> ids, @NonNull Pageable pageable);

    long deleteByIdIn(@NonNull Collection<I> ids);
}
