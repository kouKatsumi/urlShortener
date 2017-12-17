package com.ada.ulrShortener.repositories;

import com.ada.ulrShortener.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mbart on 28.02.2016.
 */
public interface SheetRepository extends JpaRepository<ShortUrl, String> {
}
