package com.decerto.librarymanager.library.infrastructure.adpters.uuid;

import com.decerto.librarymanager.library.domain.ports.outgoing.UuidGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidGeneratorImpl implements UuidGenerator {
    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
