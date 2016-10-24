/**
* Copyright 2016 dryTools doo
* Email: contact@drytools.co
* 
* This file is part of ideapallo.
* 
* ideapallo is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* ideapallo is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with ideapallo. If not, see <http://www.gnu.org/licenses/>.*
**/
package com.ideapallo.ideapallo.web.rest;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import java.net.URLConnection;
import com.ideapallo.ideapallo.service.FileStorageService;


@RestController
@RequestMapping("/api/")
public class FileApi {

    private final Logger log = LoggerFactory.getLogger(FileApi.class);

    @Inject
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/file/{key}/{fileName}", method = RequestMethod.GET)
    @Timed
    public ResponseEntity<Void> findFile(HttpServletResponse response, @PathVariable String key, @PathVariable String fileName) throws IOException {
        log.debug("GET /file/{}/{}", key, fileName);
        final Optional<BufferedInputStream> result = fileStorageService.retrieve(key, fileName);

        if (result.isPresent()) {
            final String mimeType = URLConnection.guessContentTypeFromStream(result.get());
            final HttpHeaders headers = new HttpHeaders();
            final int oneWeek = 7 * 24 * 60 * 60;
            response.setHeader("Cache-Control", "no-cache, no-store, max-age=" + oneWeek + ", must-revalidate");
            response.setContentType(mimeType);

            IOUtils.copy(result.get(), response.getOutputStream());
            return ResponseEntity.ok().headers(headers).build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
