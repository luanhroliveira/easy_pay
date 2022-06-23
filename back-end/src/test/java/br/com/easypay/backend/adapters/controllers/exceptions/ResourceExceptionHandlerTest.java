package br.com.easypay.backend.adapters.controllers.exceptions;

import br.com.easypay.backend.domain.adapters.services.exceptions.DataIntegrityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResourceExceptionHandlerTest {

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private ResourceExceptionHandler resourceExceptionHandler;

    @Test
    void should() {
        DataIntegrityException dataIntegrityException = new DataIntegrityException("Erro de integridade de dados");

        when(this.request.getRequestURI()).thenReturn("Request URI");

        ResponseEntity<StandardError> result =
            this.resourceExceptionHandler.dataIntegrityException(dataIntegrityException, request);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(StandardError.class, result.getBody().getClass());
        assertEquals(Instant.class, result.getBody().getTimestamp().getClass());
        assertEquals("Request Bad Request", result.getBody().getError());
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getBody().getStatus());
        assertEquals(dataIntegrityException.getMessage(), result.getBody().getMessage());
        assertEquals(this.request.getRequestURI(), result.getBody().getPath());
        assertEquals(ResponseEntity.class, result.getClass());
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

}