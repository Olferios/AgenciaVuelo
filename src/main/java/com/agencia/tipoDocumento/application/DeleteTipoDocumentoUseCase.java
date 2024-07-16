package com.agencia.tipoDocumento.application;

import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;

public class DeleteTipoDocumentoUseCase {
    private final TipoDocumentoService tipoDocumentoService;
    
    public DeleteTipoDocumentoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
    

}
