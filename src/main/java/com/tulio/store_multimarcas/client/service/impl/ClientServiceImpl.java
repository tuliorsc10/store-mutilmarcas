package com.tulio.store_multimarcas.client.service.impl;

import com.tulio.store_multimarcas.client.dto.*;
import com.tulio.store_multimarcas.client.mapper.ClientMapper;
import com.tulio.store_multimarcas.client.repository.ClientRepository;
import com.tulio.store_multimarcas.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public RetrieveClientDTO retrieveClientById(Long id) {
        Optional<ClientEntity> clientFound = clientRepository.findById(id);
        ClientEntity clientEntity = clientFound.orElseThrow(() -> new RuntimeException("Client with Id " + id + " not found!"));
        return clientMapper.toRetrieveClient(clientEntity);
    }

    @Override
    public void deleteClientById(Long id) {
        Optional<ClientEntity> clientFound = clientRepository.findById(id);
        if (clientFound.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client with Id " + id + " not found!");
        }
    }

    @Override
    public UpdateClientResponseDTO updateClient(Long id, UpdateClientResquestDTO request) {
        Optional<ClientEntity> clientFound = clientRepository.findById(id);
        if (clientFound.isPresent() && clientFound.get().getDocumentCpf().equalsIgnoreCase(request.getDocumentCpf())) {
            ClientEntity clientEntity = updateValidation(clientFound.get(), request);
            ClientEntity client = clientRepository.save(clientEntity);
            return clientMapper.toUpdateClientResponse(client);
        }
        return null;
    }

    private ClientEntity updateValidation(ClientEntity clientEntity, UpdateClientResquestDTO resquest) {
        if (resquest != null) {
            clientEntity.setName(StringUtils.isBlank(resquest.getName()) ? clientEntity.getName() : resquest.getName());
            clientEntity.setEmail(StringUtils.isBlank(resquest.getEmail()) ? clientEntity.getEmail() : resquest.getEmail());
            clientEntity.setPhone(StringUtils.isBlank(resquest.getPhone()) ? clientEntity.getPhone() : resquest.getPhone());
            verifyAddress(clientEntity, resquest);
        }
        return clientEntity;
    }

    private void verifyAddress(ClientEntity clientEntity, UpdateClientResquestDTO resquest) {
        if (resquest.getAddress() != null) {
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().street()) ? clientEntity.getStreet() : resquest.getAddress().street());
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().number()) ? clientEntity.getNumber() : resquest.getAddress().number());
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().district()) ? clientEntity.getDistrict() : resquest.getAddress().district());
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().city()) ? clientEntity.getCity() : resquest.getAddress().city());
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().state()) ? clientEntity.getState() : resquest.getAddress().state());
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().country()) ? clientEntity.getCountry() : resquest.getAddress().country());
            clientEntity.setState(StringUtils.isBlank(resquest.getAddress().complement()) ? clientEntity.getComplement() : resquest.getAddress().complement());
        }
    }
}
