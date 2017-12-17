package com.ada.music.sheets.repositories;

import com.ada.music.sheets.domain.ShortUrl;
import java.net.URL;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mbart on 28.02.2016.
 */
public interface SheetRepository extends JpaRepository<ShortUrl, String> {
}
