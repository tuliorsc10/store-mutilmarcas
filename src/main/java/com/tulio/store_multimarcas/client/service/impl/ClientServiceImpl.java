package com.tulio.store_multimarcas.client.service.impl;

import com.tulio.store_multimarcas.client.dto.ClientEntity;
import com.tulio.store_multimarcas.client.dto.CreateClientReponseDTO;
import com.tulio.store_multimarcas.client.dto.CreateClientRequestDTO;
import com.tulio.store_multimarcas.client.mapper.ClientMapper;
import com.tulio.store_multimarcas.client.repository.ClientRepository;
import com.tulio.store_multimarcas.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public CreateClientReponseDTO createClient(CreateClientRequestDTO request) {
        Optional<ClientEntity> client = clientRepository.findByEmail(request.getEmail());
        if (client.isPresent()) {
            throw new RuntimeException(String.format("A client with this email address %s has already been registered", client.get().getEmail()));
        }
        ClientEntity clientEntity = clientMapper.toClientEntity(request);
        ClientEntity saveClient = clientRepository.save(clientEntity);
        return clientMapper.toCreateClientResponse(saveClient);
    }
}
