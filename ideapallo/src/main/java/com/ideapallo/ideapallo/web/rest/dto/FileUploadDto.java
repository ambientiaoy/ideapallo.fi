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
package com.ideapallo.ideapallo.web.rest.dto;

import java.io.Serializable;

import javax.validation.constraints.*;


public class FileUploadDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String fileName;

    @NotNull
    private String base64;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FileUploadDto other = (FileUploadDto) obj;
        if ((fileName == null && other.fileName != null) || !fileName.equals(other.fileName))
            return false;
        if ((base64 == null && other.base64 != null) || !base64.equals(other.base64))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((base64 == null) ? 0 : base64.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FileUploadDto[" + "fileName=" + fileName + "]";
    }

}
