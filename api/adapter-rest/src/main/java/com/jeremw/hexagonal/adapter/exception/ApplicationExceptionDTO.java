package com.jeremw.hexagonal.adapter.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) class representing information about a resource-related
 * exception.
 *

 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object (DTO) representing information about a resource-related exception.")
public class ApplicationExceptionDTO {
    /**
     * The human-readable error message.
     */
    @Schema(description = "The human-readable error message.", example = "Resource not found.")
    private String errorMessage;

    /**
     * The URL of the HTTP request that triggered the exception.
     */
    @Schema(description = "The URL of the HTTP request that triggered the exception.", example = "http://example.com/resource")
    private String requestURL;

}
