package com.wolfpack.tracker.helpers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
/**
 * Contains static methods that help
 * perform trivial URI related tasks
 * Cannot be instantiated
 */
public class UriHelper {
    private UriHelper(){}

    public static URI buildNewResourceUri(Long resourceId) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resourceId)
                .toUri();
    }
}
