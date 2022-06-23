package br.com.easypay.backend.adapters.controllers;

import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonNewDTO;
import br.com.easypay.backend.domain.doors.interfaces.PhysicalPersonServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/physicalPerson")
public class PhysicalPersonController {

    private final PhysicalPersonServicePort physicalPersonServicePort;

    public PhysicalPersonController(PhysicalPersonServicePort physicalPersonServicePort) {
        this.physicalPersonServicePort = physicalPersonServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> insertPhysicalPerson(@Valid @RequestBody PhysicalPersonNewDTO physicalPersonNewDTO) {
        PhysicalPersonDTO physicalPersonDTO = this.physicalPersonServicePort.insertAPhysicalPerson(physicalPersonNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(physicalPersonDTO.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{physicalPersonId}")
    public ResponseEntity<Void> deletePhysicalPerson(@PathVariable Long physicalPersonId) {
        this.physicalPersonServicePort.deleteAPhysicalPerson(physicalPersonId);

        return ResponseEntity.noContent().build();
    }
}
