package com.tulio.store_multimarcas.client.service;

import com.tulio.store_multimarcas.client.dto.CreateClientReponseDTO;
import com.tulio.store_multimarcas.client.dto.CreateClientRequestDTO;

public interface ClientService {

    CreateClientReponseDTO createClient(CreateClientRequestDTO request);
}
